from pymongo import MongoClient
from bson.objectid import ObjectId
from faker import Faker
import random
from datetime import datetime, timedelta

fake = Faker()

# Conexión a MongoDB
client = MongoClient("mongodb://ISIS2304D25202320:EbQTnmWmZawE@157.253.236.88:8087/ISIS2304D25202320")
db = client["ISIS2304D25202320"]  # Asumiendo que este es el nombre de tu base de datos

# Función para poblar tipos de habitación
def poblar_tipos_habitacion(cantidad=20):
    tipos_habitacion = []
    for _ in range(cantidad):
        tipo = {
            "nombre": fake.word(),
            "costoNoche": round(random.uniform(50, 500), 2),
            "capacidad": random.randint(1, 4)
        }
        tipos_habitacion.append(tipo)
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
poblar_tipos_habitacion()
poblar_servicios()
poblar_hoteles_con_habitaciones()
poblar_reservaciones()

print("Base de datos poblada con éxito.")
