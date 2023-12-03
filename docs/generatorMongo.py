from pymongo import MongoClient
from bson.objectid import ObjectId
from faker import Faker
import random
from datetime import datetime, timedelta
from data import *

fake = Faker()

# Conexión a MongoDB
client = MongoClient(
    "mongodb://ISIS2304D25202320:EbQTnmWmZawE@157.253.236.88:8087/ISIS2304D25202320")
# Asumiendo que este es el nombre de tu base de datos
db = client["ISIS2304D25202320"]

# Función para poblar tipos de habitación

collections = ["tipoHabitacion", "servicioProducto", "hotel", "reserva"]


def borrar_todos_los_documentos(collection_name: list):
    for collection in collection_name:
        result = db[collection].delete_many({})
    return result.deleted_count


def poblar_tipos_habitacion(cantidad=20):
    tipos_habitacion = []
    for tipo in room_types_prices:
        precio = room_types_prices[tipo] + (random.randint(11, 99)/100)
        metible = {
            "nombre": tipo,
            "costoNoche": precio,
            "capacidad": random.randint(1, 5),
        }
        tipos_habitacion.append(metible)
    db.tipoHabitacion.insert_many(tipos_habitacion)

# Función para poblar servicios


def poblar_servicios(cantidad=35):
    servicios = []
    for _ in range(cantidad):
        servicio = {
            "nombre": fake.word(),
            "precio": round(random.uniform(10, 100), 2),
            "esProducto": fake.boolean()
        }
        servicios.append(servicio)
    db.servicioProducto.insert_many(servicios)

# Función para poblar hoteles con habitaciones


def poblar_hoteles_con_habitaciones(num_hoteles=5, habitaciones_por_hotel=40):
    tipos_habitacion_ids = [tipo["_id"] for tipo in db.tipoHabitacion.find()]
    for _ in range(num_hoteles):
        habitaciones = [{
            "descripcion": fake.sentence(),
            "tipoHabitacionId": random.choice(tipos_habitacion_ids)
        } for _ in range(habitaciones_por_hotel)]
        hotel = {
            "nombre": fake.company(),
            "habitaciones": habitaciones
        }
        db.hotel.insert_one(hotel)

# Función para poblar reservaciones


def poblar_reservaciones(cantidad=50000):
    reservaciones = []
    for _ in range(cantidad):
        checkin = fake.date_between(start_date="-3y", end_date="today")
        checkout = checkin + timedelta(days=random.randint(1, 5))
        reservacion = {
            "checkin": checkin,
            "checkout": checkout,
            "precio": round(random.uniform(100, 1000), 2),
            # Asume que ya tienes IDs de habitaciones y usuarios
            "habitacionId": str(ObjectId()),
            "usuarioId": str(ObjectId())
        }
        reservaciones.append(reservacion)
    db.reserva.insert_many(reservaciones)


# Poblar la base de datos
# poblar_tipos_habitacion()
# poblar_servicios()
# poblar_hoteles_con_habitaciones()
# poblar_reservaciones()
borrar_todos_los_documentos(collections)
print("Base de datos poblada con éxito.")
