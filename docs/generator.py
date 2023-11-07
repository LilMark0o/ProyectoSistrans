
import random
from datetime import datetime, timedelta

# Datas
from data import *

# tipousuario table

# Generate sample data for tipousuario
tipousuario_records = [(name,) for name in tipousuario_data]

pesos = [5, 2, 10, 78, 5]


# Generate sample data for usuario
num_users = 20000

random_names = [f"{random.choice(first_names)} {random.choice(last_names)}" for _ in range(num_users)]

usernames_real = [name.split()[0].lower() + str(i) for i, name in enumerate(random_names, 1)]
passwords_real = [f"pwd_{name.split()[1].lower()[:3]}{i}" for i, name in enumerate(random_names, 1)]


# Assign random tipousuario to each user
user_tipousuario = random.choices(tipousuario_data, weights=pesos, k=num_users)

usuario_records = list(zip(range(1, num_users + 1), random_names, usernames_real, passwords_real, user_tipousuario))

print(usuario_records)

from collections import Counter
c = Counter(random_names)
print(c.most_common(10))


# realistic_hotel_names = [f"{random.choice(adjectives)} {random.choice(names)} Hotel" for _ in range(num_hotels)]

# hotel_realistic_records = list(zip(range(1, num_hotels + 1), realistic_hotel_names))

#now for the rooms



# services 
# Generate sample data for servicio
# For simplicity, we'll use random values for the attributes for each type of service
# num_records_per_service = 5
# # bar
# bar_records = [(service_id, "Estilo_" + str(i), random.randint(50, 200)) for i, (service_id, _, _, _) in enumerate(servicio_realistic_records, 1) for _ in range(num_records_per_service)]

# # gimnasio
# gimnasio_records = [(service_id, random.randint(6, 10), random.randint(18, 22), random.choice(['Y', 'N'])) for service_id, _, _, _ in servicio_realistic_records]

# # internet
# internet_records = [(service_id, random.uniform(10, 100), random.uniform(1, 10)) for service_id, _, _, _ in servicio_realistic_records]

# # lavado
# lavado_records = [(service_id, random.uniform(1, 10), random.randint(1, 50)) for service_id, _, _, _ in servicio_realistic_records]

# # piscina
# piscina_records = [(service_id, random.uniform(1, 10), random.randint(6, 10), random.randint(18, 22), random.choice(['Y', 'N'])) for service_id, _, _, _ in servicio_realistic_records]

# # prestamo
# prestamo_records = [(service_id, random.choice(['Y', 'N'])) for service_id, _, _, _ in servicio_realistic_records]

# # restaurante, spa, tienda (These tables only have a single column, the foreign key to servicio)
# restaurante_records = [(service_id,) for service_id, _, _, _ in servicio_realistic_records]
# spa_records = [(service_id,) for service_id, _, _, _ in servicio_realistic_records]
# tienda_records = [(service_id,) for service_id, _, _, _ in servicio_realistic_records]

# # Create dictionary as requested
# service_related_records_dict = {
#     "bar": bar_records,
#     "gimnasio": gimnasio_records,
#     "internet": internet_records,
#     "lavado": lavado_records,
#     "piscina": piscina_records,
#     "prestamo": prestamo_records,
#     "restaurante": restaurante_records,
#     "spa": spa_records,
#     "tienda": tienda_records
# }
