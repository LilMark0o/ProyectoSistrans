from decimal import Decimal
from pymongo import MongoClient
from bson.objectid import ObjectId
from faker import Faker
import random
from datetime import datetime, timedelta
from bson.datetime_ms import DatetimeMS



# Importa data.py o define room_types_prices, adjectives y names aquí
from data import *

collections = ["tipoHabitacion", "servicioProducto", "hotel", "reserva", "usuario", "cuentaServicio"]

fake = Faker()

client = MongoClient(
    "mongodb://ISIS2304D25202320:EbQTnmWmZawE@157.253.236.88:8087/ISIS2304D25202320")
# Asumiendo que este es el nombre de tu base de datos
db = client["ISIS2304D25202320"]

def drop_collections(collection_names):
    for collection in collection_names:
        db[collection].drop()


def borrar_todos_los_documentos(collection_names):
    for collection in collection_names:
        db[collection].delete_many({})

def poblar_tipos_habitacion():
    tipos_habitacion = []
    for tipo, precio_base in room_types_prices.items():
        precio = precio_base 
        tipo_habitacion = {
            "nombre": tipo,
            "costoNoche": precio,
            "capacidad": random.randint(1, 5)
        }
        tipos_habitacion.append(tipo_habitacion)
    db.tipoHabitacion.insert_many(tipos_habitacion)

def poblar_servicios(cantidad=35):
    servicios = []
    spa_product_names2 = spa_product_names.copy()
    product_name_restaurant_food2 = product_name_restaurant_food.copy()
    barUsado = []
    gimnasioUsado = []
    spaUsado = []
    restauranteUsado = []
    tiendaUsado = []
    for _ in range(cantidad):
        esProducto = True
        servicio = {
            "esProducto": esProducto
        }
        if esProducto:
            dur = random.choices([random.randint(10, 200), 0], weights=[0.3, 0.7], k=1)[0]
            #random choice como se hace el weight
            if dur > 0:
                name = random.choice(spa_product_names2)
                servicio["nombre"] = name
                servicio["duracion"] = dur
                spa_product_names2.remove(name)
            else:
                name = random.choice(product_name_restaurant_food2)
                servicio["nombre"] = name
                product_name_restaurant_food2.remove(name)
            servicio["precio"] = round(random.randint(10000, 100000))
        
        servicios.append(servicio)
    db.servicioProducto.insert_many(servicios)
    global_id = 0
    for _ in range(25):
        bar = random.choice(service_names_for_tables["bar"])
        num_hoteles = 9
        while bar in barUsado:
            bar = random.choice(service_names_for_tables["bar"])
        global_id += 1
        barUsado.append(global_id)

        precio = 0
        description = f"El bar {bar} que ofrece una variedad de bebidas y aperitivos para disfrutar en un ambiente relajado y amigable"
        db.servicioProducto.insert_one({"nombre": bar, "precio": precio, "esProducto": False})
    for _ in range(20):
        gimnasio = random.choice(service_names_for_tables["gimnasio"])
        num_hoteles = 9
        while gimnasio in gimnasioUsado:
            gimnasio = random.choice(service_names_for_tables["gimnasio"])
        global_id += 1

        precio = 0
        description = f"El gimnasio {gimnasio} tiene maquinas de alta precisión y mancuernas desde 5 a 90KG"
        db.servicioProducto.insert_one({"nombre": gimnasio, "precio": precio, "esProducto": False})    
    for internet in (service_names_for_tables["internet"]):
        num_hoteles = 9
        global_id += 1

        precio = random.randint(10, 50)*1000
        description = f"El internet {internet} es valido por {random.randint(1, 5)} días sin costo adicional"
        db.servicioProducto.insert_one({"nombre": internet, "precio": precio, "esProducto": False})
    for lavado in (service_names_for_tables["lavado"]):
        num_hoteles = 9
        global_id += 1
        precio = random.randint(20, 50)*1000
        description = f"El servicio de lavado {lavado} es valido para {random.randint(3, 8)} prendas sin costo adicional"
        db.servicioProducto.insert_one({"nombre": lavado, "precio": precio, "esProducto": False})
    for piscina in (service_names_for_tables["piscina"]):
        num_hoteles = 9
        global_id += 1
        precio = 0
        description = f"La piscina {piscina} tiene una temperatura de {random.randint(20, 30)} grados"
        db.servicioProducto.insert_one({"nombre": piscina, "precio": precio, "esProducto": False})
    for prestamo in (service_names_for_tables["prestamo"]):
        num_hoteles = 9
        global_id += 1
        precio = 0
        description = f"El servicio de prestamo {prestamo} es valido para {random.randint(1, 5)} personas"
        db.servicioProducto.insert_one({"nombre": prestamo, "precio": precio, "esProducto": False})
    for _ in range(30):
        restaurante = random.choice(service_names_for_tables["restaurante"])
        num_hoteles = 9
        global_id += 1
        restauranteUsado.append(global_id)
        precio = 0
        description = f"El restaurante {restaurante} ofrece una variedad de platos y bebidas para disfrutar en un ambiente relajado y amigable"
        db.servicioProducto.insert_one({"nombre": restaurante, "precio": precio, "esProducto": False})
    for spa in (service_names_for_tables["spa"]):
        num_hoteles = 9
        global_id += 1
        precio = random.randint(120, 180)*1000
        description = f"El spa {spa} ofrece una variedad de tratamientos para disfrutar en un ambiente relajado y amigable"
        db.servicioProducto.insert_one({"nombre": spa, "precio": precio, "esProducto": False})
    for _ in range(25):

        tienda = random.choice(service_names_for_tables["tienda"])
        while tienda in tiendaUsado:
            tienda = random.choice(service_names_for_tables["tienda"])
        num_hoteles = 9
        global_id += 1
        tiendaUsado.append(tienda)
        precio = 0
        description = f"La tienda {tienda} ofrece una variedad de productos para disfrutar en un ambiente relajado y amigable"
        db.servicioProducto.insert_one({"nombre": tienda, "precio": precio, "esProducto": False})
  

def poblar_hoteles_con_habitaciones(num_hoteles=5):
    hoteles = [random.choice(adjectives) + " " + random.choice(names) for _ in range(num_hoteles)]
    tipos_habitacion_ids = [ObjectId(tipo["_id"]) for tipo in db.tipoHabitacion.find()]
    servicios_ids = [ObjectId(servicio["_id"]) for servicio in db.servicioProducto.find()]
    for i in range(num_hoteles):
        habitaciones = [{"id": (i*1000)+_,"descripcion": fake.sentence(), "tipoHabitacionId": random.choice(tipos_habitacion_ids)} for _ in range(200)]
        hotel = {
            "nombre": hoteles[i],
            "habitaciones":habitaciones,
            "serviciosProductos": random.choices(servicios_ids, k=70)
        }
        db.hotel.insert_one(hotel)


def poblar_usuarios(cantidad=5000):
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
    
    habitaciones = list(db.hotel.aggregate([
        {"$unwind": "$habitaciones"},  # Deshace la matriz de habitaciones
        {"$replaceRoot": {"newRoot": "$habitaciones"}},  # Hace que las habitaciones sean el documento principal
        {"$project": {"id": 1, "tipoHabitacionId": 1}}  # Proyecta el _id y tipoHabitacionId
    ]))
    # for habitacion in habitaciones:
    #     print(habitacion)
    habitacion_ids = [hab['id'] for hab in habitaciones]  # Obtiene los IDs de las habitaciones
    
    # Obtén todos los IDs de los usuarios
    usuario_ids = [usuario['_id'] for usuario in db.usuario.find()]

    for _ in range(cantidad):
        checkin = fake.date_between(start_date="-3y", end_date="today")
        checkout = checkin + timedelta(days=random.randint(1, 28))
        
        # Elige un ID de habitación aleatorio y encuentra el tipo de habitación correspondiente
        hab_id = random.choice(habitacion_ids)
        tipo_habitacion = db.tipoHabitacion.find_one({"_id": next(hab for hab in habitaciones if hab['id'] == hab_id)['tipoHabitacionId']})
        if tipo_habitacion:
            precio_por_noche = tipo_habitacion['costoNoche']
            precio_total = int(precio_por_noche) * (checkout - checkin).days
            checkin = datetime.combine(checkin, datetime.min.time())
            checkout = datetime.combine(checkout, datetime.min.time())
            reservacion = {
                "checkin": checkin,
                "checkout": checkout,
                "precio": precio_total,
                "habitacion_id": hab_id,
                "usuario_id": random.choice(usuario_ids)
            }
            reservaciones.append(reservacion)
        if len(reservaciones) % 100 == 0:
            print(f"Reservaciones generadas: {len(reservaciones)}")
    # Inserta las reservaciones en la base de datos
    db.reserva.insert_many(reservaciones)




# Función para poblar consumos
def poblar_consumos(cantidad=200000):
    # Obtén IDs de reservas y servicios/productos existentes
    reserva_ids = [(reserva['_id'], reserva["usuario_id"]) for reserva in db.reserva.find()]
    servicio_ids = [(servicio['_id'], servicio["nombre"], str(servicio["precio"])) for servicio in db.servicioProducto.find()]
    
    consumos = []
    for _ in range(cantidad):
        # Crea un documento de consumo
        date = fake.date_time_between(start_date="-3y", end_date="now")
        date = datetime.combine(date, datetime.min.time())
        servicio = random.choice(servicio_ids)
        reserva = random.choice(reserva_ids)
        nombre = db.usuario.find_one({"_id": reserva[1]})["nombre"]
        consumo = {
            "descripcion": f"{nombre} consumió {servicio[1]} en la fecha {date} con un costo de {servicio[2]}",
            "fecha": fake.date_time_between(start_date="-3y", end_date="now"),  # Fecha aleatoria en los últimos 3 años
            "reservaId": reserva[0],  # ID de reserva aleatoria
            "servicioId": servicio[0]  # ID de servicio/producto aleatorio
        }
        consumos.append(consumo)
        # if len(consumos) % 100 == 0:
        #     print(f"Consumos generados: {len(consumos)}")
        # Inserta en lotes para mejorar la eficiencia
        if len(consumos) >= 1000:
            db.cuentaServicio.insert_many(consumos)
            consumos = []  # Vaciar la lista para el siguiente lote
    
    # Inserta cualquier documento restante
    if consumos:
        db.cuentaServicio.insert_many(consumos)



# Ejecutar funciones de poblado
borrar_todos_los_documentos(collections)
# drop_collections(collections)
poblar_tipos_habitacion()
poblar_servicios()
poblar_hoteles_con_habitaciones()
poblar_usuarios()
poblar_reservaciones()
poblar_consumos()
print("Base de datos poblada con éxito.")
