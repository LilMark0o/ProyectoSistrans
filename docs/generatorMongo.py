from pymongo import MongoClient
from bson.objectid import ObjectId
from faker import Faker
import random
from datetime import datetime, timedelta

# Importa data.py o define room_types_prices, adjectives y names aquí
from data import *

collections = ["tipoHabitacion", "servicioProducto", "hotel", "reserva", "usuario"]

fake = Faker()

# Conexión a MongoDB
client = MongoClient("mongodb://usuario:contraseña@host:puerto/")
db = client["nombre_de_la_base_de_datos"]

def borrar_todos_los_documentos(collection_names):
    for collection in collection_names:
        db[collection].delete_many({})

def poblar_tipos_habitacion():
    tipos_habitacion = []
    for tipo, precio_base in room_types_prices.items():
        precio = precio_base + (random.randint(11, 99) / 100)
        tipo_habitacion = {
            "nombre": tipo,
            "costoNoche": precio,
            "capacidad": random.randint(1, 5)
        }
        tipos_habitacion.append(tipo_habitacion)
    db.tipoHabitacion.insert_many(tipos_habitacion)

def poblar_servicios():
    servicios = []
    for _ in range(35):
        servicio = {
            "nombre": fake.word(),
            "precio": round(random.uniform(10, 100), 2),
            "esProducto": fake.boolean()
        }
        servicios.append(servicio)
    db.servicioProducto.insert_many(servicios)

def poblar_hoteles_con_habitaciones(num_hoteles=5):
    hoteles = [random.choice(adjectives) + " " + random.choice(names) for _ in range(num_hoteles)]
    tipos_habitacion_ids = [str(tipo["_id"]) for tipo in db.tipoHabitacion.find()]
    servicios_ids = [str(servicio["_id"]) for servicio in db.servicioProducto.find()]
    for i in range(num_hoteles):
        habitaciones = [{"descripcion": fake.sentence(), "tipoHabitacionId": random.choice(tipos_habitacion_ids)} for _ in range(40)]
        hotel = {
            "nombre": hoteles[i],
            "habitaciones": habitaciones,
            "serviciosProductos": servicios_ids
        }
        db.hotel.insert_one(hotel)


def poblar_usuarios(cantidad=50000):
    usuarios = []
    pesos = [5, 2, 10, 78, 5]

    # Generate sample data for usuario
    num_users = cantidad

    random_names = [
        f"{random.choice(first_names)} {random.choice(last_names)}" for _ in range(num_users)]

    usernames_real = [name.split()[0].lower() + str(i)
                      for i, name in enumerate(random_names, 1)]
    passwords_real = [f"pwd_{name.split()[1].lower()[:3]}{i}" for i,
                      name in enumerate(random_names, 1)]

    user_tipousuario = random.choices(
        tipousuario_data, weights=pesos, k=num_users)
    
    for i in range(num_users):
        usuario = {
            "nombre": random_names[i],
            "username": usernames_real[i],
            "password": passwords_real[i],
            "tipoUsuario": user_tipousuario[i]
        }
        usuarios.append(usuario)
    db.usuario.insert_many(usuarios)

def poblar_reservaciones(cantidad=50000):
    reservaciones = []
    habitacion_ids = [str(habitacion["_id"]) for habitacion in db.hotel.find({}, {"habitaciones": 1})]
    usuario_ids = [str(usuario["_id"]) for usuario in db.usuario.find()]
    for _ in range(cantidad):
        checkin = fake.date_between(start_date="-3y", end_date="today")
        checkout = checkin + timedelta(days=random.randint(1, 5))
        reservacion = {
            "checkin": checkin,
            "checkout": checkout,
            "precio": round(random.uniform(100, 1000), 2),
            "habitacion_id": random.choice(habitacion_ids),
            "usuario_id": random.choice(usuario_ids)
        }
        reservaciones.append(reservacion)
    db.reserva.insert_many(reservaciones)

# Ejecutar funciones de poblado
borrar_todos_los_documentos(collections)
poblar_tipos_habitacion()
poblar_servicios()
poblar_hoteles_con_habitaciones()
poblar_reservaciones()
print("Base de datos poblada con éxito.")
