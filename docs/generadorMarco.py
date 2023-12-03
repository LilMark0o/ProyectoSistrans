from data import *
import random
from datetime import datetime, timedelta
from bson.decimal128 import Decimal128

path = "generator.sql"

con = open(path, "w")


def hotelandesJeje():
    hoteles = [[a, random.choice(adjectives) + " " +
                random.choice(names)] for a in range(1, 10)]

    for a, b in hoteles:
        con.write(f"INSERT INTO hotel VALUES ({a}, '{b}');\n")


def generarUsuarios():
    # Generate sample data for tipousuario
    tipousuario_records = [(name,) for name in tipousuario_data]

    pesos = [5, 2, 10, 78, 5]

    # Generate sample data for usuario
    num_users = 20000

    random_names = [
        f"{random.choice(first_names)} {random.choice(last_names)}" for _ in range(num_users)]

    usernames_real = [name.split()[0].lower() + str(i)
                      for i, name in enumerate(random_names, 1)]
    passwords_real = [f"pwd_{name.split()[1].lower()[:3]}{i}" for i,
                      name in enumerate(random_names, 1)]

    # Assign random tipousuario to each user
    user_tipousuario = random.choices(
        tipousuario_data, weights=pesos, k=num_users)

    usuario_records = list(zip(range(1, num_users + 1), random_names,
                               usernames_real, passwords_real, user_tipousuario))
    for a, b, c, d, e in usuario_records:
        f = int(random.randint(1, 9))
        con.write(
            f"INSERT INTO usuario VALUES ({a}, '{b}', '{c}', '{d}', '{e}',{f});\n")


def generarTipoHabitacion():
    tipoHabitacion_records = [(name, room_types_prices)
                              for name, room_types_prices in room_types_prices.items()]

    for idx, a in enumerate(tipoHabitacion_records):
        con.write(
            f"INSERT INTO tipoHabitacion VALUES ({idx+1}, '{a[1][0]}','{a[1][1]}','{a[0]}');\n")


def generarHabitaciones():
    num_rooms = 10000
    num_tipoHabitacion = 8
    num_hotel = 9
    for index in range(num_rooms):
        descripcion = random.choice(descripciones_habitaciones)
        con.write(
            f"INSERT INTO habitacion VALUES ({index+1}, {random.randint(1, num_hotel)}, {random.randint(1, num_tipoHabitacion)}, '{descripcion}');\n")


def generarPlanConsumo():
    num_hotel = 9
    for index, descuento in enumerate(descuentosAAA):
        percent = descuento[0]
        descripcion = descuento[1]
        con.write(
            f"INSERT INTO planConsumo VALUES ({index+1}, '{descripcion}',{percent},{random.randint(1,num_hotel)});\n")


def generarReserva():
    for index in range(200000):
        dias_aleatorios = random.randint(0, 365 * 4)
        fecha_actual = datetime.now()
        fecha_aleatoria = fecha_actual - timedelta(days=dias_aleatorios)
        duracion_reserva = random.randint(5, 45)
        fecha_con_10_dias = fecha_aleatoria + timedelta(days=duracion_reserva)

        check_in = fecha_aleatoria.strftime("%Y-%m-%d")
        check_out = fecha_con_10_dias.strftime("%Y-%m-%d")

        precio = random.randint(200000, 1000000)

        habitacion_id = random.randint(1, 10000)

        usuario_id = random.randint(1, 20000)

        con.write(
            f"INSERT INTO reserva VALUES ({index+1}, TO_DATE('{check_in}', 'YYYY-MM-DD'), TO_DATE('{check_out}', 'YYYY-MM-DD'), {precio}, {habitacion_id}, {usuario_id});\n")


def generarServiciosYProductos():
    global_id = 7

    barUsado = []
    gimnasioUsado = []
    spaUsado = []
    restauranteUsado = []
    tiendaUsado = []

    for _ in range(200):
        bar = random.choice(service_names_for_tables["bar"])
        num_hoteles = 9
        while bar in barUsado:
            bar = random.choice(service_names_for_tables["bar"])
        global_id += 1
        barUsado.append(global_id)

        precio = 0
        description = f"El bar {bar} que ofrece una variedad de bebidas y aperitivos para disfrutar en un ambiente relajado y amigable"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{bar}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for _ in range(20):
        gimnasio = random.choice(service_names_for_tables["gimnasio"])
        num_hoteles = 9
        while gimnasio in gimnasioUsado:
            gimnasio = random.choice(service_names_for_tables["gimnasio"])
        global_id += 1

        precio = 0
        description = f"El gimnasio {gimnasio} tiene maquinas de alta precisión y mancuernas desde 5 a 90KG"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{gimnasio}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for internet in (service_names_for_tables["internet"]):
        num_hoteles = 9
        global_id += 1

        precio = random.randint(10, 50)*1000
        description = f"El internet {internet} es valido por {random.randint(1, 5)} días sin costo adicional"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{internet}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for lavado in (service_names_for_tables["lavado"]):
        num_hoteles = 9
        global_id += 1
        precio = random.randint(20, 50)*1000
        description = f"El servicio de lavado {lavado} es valido para {random.randint(3, 8)} prendas sin costo adicional"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{lavado}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for piscina in (service_names_for_tables["piscina"]):
        num_hoteles = 9
        global_id += 1
        precio = 0
        description = f"La piscina {piscina} tiene una temperatura de {random.randint(20, 30)} grados"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{piscina}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for prestamo in (service_names_for_tables["prestamo"]):
        num_hoteles = 9
        global_id += 1
        precio = 0
        description = f"El servicio de prestamo {prestamo} es valido para {random.randint(1, 5)} personas"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{prestamo}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for _ in range(30):
        restaurante = random.choice(service_names_for_tables["restaurante"])
        num_hoteles = 9
        global_id += 1
        restauranteUsado.append(global_id)
        precio = 0
        description = f"El restaurante {restaurante} ofrece una variedad de platos y bebidas para disfrutar en un ambiente relajado y amigable"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{restaurante}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for spa in (service_names_for_tables["spa"]):
        num_hoteles = 9
        global_id += 1
        spaUsado.append(global_id)
        precio = random.randint(120, 180)*1000
        description = f"El spa {spa} ofrece una variedad de tratamientos para disfrutar en un ambiente relajado y amigable"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{spa}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    for _ in range(25):
        tienda = random.choice(service_names_for_tables["tienda"])
        num_hoteles = 9
        global_id += 1
        tiendaUsado.append(global_id)
        precio = 0
        description = f"La tienda {tienda} ofrece una variedad de productos para disfrutar en un ambiente relajado y amigable"
        con.write(
            f"INSERT INTO servicio VALUES ({global_id}, '{tienda}',{precio}, '{description}',{random.randint(1,num_hoteles)});\n")
    global_id_product = 2
    bebida_ids = []
    restaurant_food_ids = []
    spa_ids = []
    for drink in (product_names_drink):
        precio = random.randint(4, 12)*1000
        global_id_product += 1
        bebida_ids.append(global_id_product)
        duracion = 0
        con.write(
            f"INSERT INTO producto VALUES ({global_id_product}, {precio}, '{drink}', {duracion});\n")
    for food in (product_name_restaurant_food):
        precio = random.randint(20, 40)*1000
        global_id_product += 1
        restaurant_food_ids.append(global_id_product)
        duracion = 0
        con.write(
            f"INSERT INTO producto VALUES ({global_id_product}, {precio}, '{food}', {duracion});\n")
    for spaProduct in (spa_product_names):
        precio = random.randint(80, 150)*1000
        global_id_product += 1
        spa_ids.append(global_id_product)
        duracion = random.randint(3, 7)
        con.write(
            f"INSERT INTO producto VALUES ({global_id_product}, {precio}, '{spaProduct}', {duracion});\n")

    tuplasUsables = []

    for _ in range(800):
        restaurante_id = random.choice(restauranteUsado)
        bebida_id = random.choice(bebida_ids)
        tuplasUsables.append((restaurante_id, bebida_id))
        con.write(
            f"INSERT INTO ServicioProducto VALUES ({restaurante_id}, {bebida_id});\n")
    for _ in range(800):
        tienda_id = random.choice(tiendaUsado)
        bebida_id = random.choice(bebida_ids)
        tuplasUsables.append((tienda_id, bebida_id))
        con.write(
            f"INSERT INTO ServicioProducto VALUES ({tienda_id}, {bebida_id});\n")
    for _ in range(1000):
        restaurante_id = random.choice(restauranteUsado)
        comida_id = random.choice(restaurant_food_ids)
        tuplasUsables.append((restaurante_id, comida_id))
        con.write(
            f"INSERT INTO ServicioProducto VALUES ({restaurante_id}, {comida_id});\n")

    id_cuentaServicio = 8
    for _ in range(50000):
        id_cuentaServicio += 1
        tupla = random.choice(tuplasUsables)
        fecha = datetime.now() - timedelta(days=random.randint(0, 365*4))
        description = f"El servicio {tupla[0]} compro el producto {tupla[1]}"
        reserva = random.randint(1, 200000)
        con.write(
            f"INSERT INTO cuentaServicio VALUES ({id_cuentaServicio},'{description}', TO_DATE('{fecha.strftime('%Y-%m-%d')}', 'YYYY-MM-DD'),  {reserva}, {tupla[1]},{tupla[0]});\n")

# hotelandesJeje()
# generarUsuarios()
# generarTipoHabitacion()
# generarHabitaciones()
# generarPlanConsumo()


generarServiciosYProductos()

con.close()
