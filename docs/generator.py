# spring.jpa.hibernate.ddl-auto=none
# spring.jpa.properties.hibernate.hql.bulk_id_strategy.global_temporary.create_tables=false
# spring.datasource.url=jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD
# spring.datasource.username=ISIS2304D25202320
# spring.datasource.password=EbQTnmWmZawE
# spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
# spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
# spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
# spring.jpa.show-sql=true
# spring.mvc.throw-exception-if-no-handler-found=true
# -- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
# --   en:        2023-10-27 13:41:19 COT
# --   sitio:      Oracle Database 11g
# --   tipo:      Oracle Database 11g



# -- predefined type, no DDL - MDSYS.SDO_GEOMETRY

# -- predefined type, no DDL - XMLTYPE

# CREATE TABLE acompanante (
#     id         INTEGER NOT NULL,
#     nombre     VARCHAR2(4000),
#     usuario_id INTEGER NOT NULL
# );

# ALTER TABLE acompanante ADD CONSTRAINT acompanante_pk PRIMARY KEY ( id );

# CREATE TABLE bar (
#     servicio_id INTEGER NOT NULL,
#     estilo      VARCHAR2(4000),
#     capacidad   INTEGER
# );

# ALTER TABLE bar ADD CONSTRAINT bar_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE cuentaservicio (
#     id            INTEGER NOT NULL,
#     fecha         DATE,
#     tiposervicio  VARCHAR2(4000) NOT NULL,
#     servicio_id   INTEGER NOT NULL,
#     habitacion_id INTEGER NOT NULL
# );

# ALTER TABLE cuentaservicio ADD CONSTRAINT cuentaservicio_pk PRIMARY KEY ( id );

# CREATE TABLE dotacion (
#     id            INTEGER NOT NULL,
#     nombre        VARCHAR2(4000),
#     costo         FLOAT,
#     cobro         CHAR(1),
#     habitacion_id INTEGER NOT NULL
# );

# ALTER TABLE dotacion ADD CONSTRAINT dotacion_pk PRIMARY KEY ( id );

# CREATE TABLE gimnasio (
#     servicio_id INTEGER NOT NULL,
#     horainicio  INTEGER,
#     horafin     INTEGER,
#     secobra     CHAR(1)
# );

# ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE habitacion (
#     id                INTEGER NOT NULL,
#     capacidad         INTEGER,
#     costonoche        FLOAT,
#     tipohabitación_id INTEGER NOT NULL
# );

# ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

# CREATE TABLE hotel (
#     id     INTEGER NOT NULL,
#     nombre VARCHAR2(4000)
# );

# ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( id );

# CREATE TABLE internet (
#     servicio_id INTEGER NOT NULL,
#     capacidad   FLOAT,
#     precio      FLOAT
# );

# ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE lavado (
#     servicio_id    INTEGER NOT NULL,
#     precio         FLOAT,
#     cantidadalavar INTEGER
# );

# ALTER TABLE lavado ADD CONSTRAINT lavado_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE maquina (
#     id                   INTEGER NOT NULL,
#     nombre               VARCHAR2(4000),
#     gimnasio_servicio_id INTEGER NOT NULL
# );

# ALTER TABLE maquina ADD CONSTRAINT maquina_pk PRIMARY KEY ( id );

# CREATE TABLE piscina (
#     servicio_id INTEGER NOT NULL,
#     profundidad FLOAT,
#     horainicio  INTEGER,
#     horafin     INTEGER,
#     secobra     CHAR(1)
# );

# ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE planconsumo (
#     id          INTEGER NOT NULL,
#     descripcion VARCHAR2(4000),
#     descuento   INTEGER,
#     hotel_id    INTEGER NOT NULL
# );

# ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( id );

# CREATE TABLE prestamo (
#     servicio_id INTEGER NOT NULL,
#     devuelto    CHAR(1)
# );

# ALTER TABLE prestamo ADD CONSTRAINT prestamo_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE producto (
#     id                      INTEGER NOT NULL,
#     precio                  FLOAT,
#     nombre                  VARCHAR2(4000),
#     bar_servicio_id         INTEGER NOT NULL,
#     restaurante_servicio_id INTEGER NOT NULL,
#     tienda_servicio_id      INTEGER NOT NULL
# );

# ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

# CREATE TABLE productospa (
#     id              INTEGER NOT NULL,
#     duracion        INTEGER,
#     spa_servicio_id INTEGER NOT NULL
# );

# ALTER TABLE productospa ADD CONSTRAINT productospa_pk PRIMARY KEY ( id );

# CREATE TABLE reserva (
#     id            INTEGER NOT NULL,
#     fecha         DATE,
#     cobro         FLOAT,
#     usuario_id    INTEGER NOT NULL,
#     habitacion_id INTEGER NOT NULL
# );

# ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id );

# CREATE TABLE reservasalon (
#     id               INTEGER NOT NULL,
#     fecha            DATE,
#     tiempoespera     INTEGER,
#     salon_service_id INTEGER NOT NULL
# );

# ALTER TABLE reservasalon ADD CONSTRAINT reservasalon_pk PRIMARY KEY ( id );

# CREATE TABLE reservaspa (
#     id              INTEGER NOT NULL,
#     fecha           DATE,
#     hora            INTEGER,
#     spa_servicio_id INTEGER NOT NULL
# );

# ALTER TABLE reservaspa ADD CONSTRAINT reservaspa_pk PRIMARY KEY ( id );

# CREATE TABLE restaurante (
#     servicio_id INTEGER NOT NULL
# );

# ALTER TABLE restaurante ADD CONSTRAINT restaurante_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE salon (
#     service_id          INTEGER NOT NULL,
#     capacidad           INTEGER,
#     tiposalon           VARCHAR2(4000),
#     horasuso            INTEGER,
#     equipocomputacion   CHAR(1),
#     equipoproyeccion    CHAR(1),
#     equipoamplificacion CHAR(1),
#     servicio_id         INTEGER NOT NULL
# );

# ALTER TABLE salon ADD CONSTRAINT salon_pk PRIMARY KEY ( service_id );

# CREATE TABLE servicio (
#     id       INTEGER NOT NULL,
#     nombre   VARCHAR2(4000),
#     secobra  INTEGER,
#     hotel_id INTEGER NOT NULL
# );

# ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( id );

# CREATE TABLE spa (
#     servicio_id INTEGER NOT NULL
# );

# ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE tienda (
#     servicio_id INTEGER NOT NULL
# );

# ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( servicio_id );

# CREATE TABLE tipohabitacion (
#     id         INTEGER NOT NULL,
#     costonoche FLOAT,
#     capacidad  INTEGER,
#     nombre     VARCHAR2(4000)
# );

# ALTER TABLE tipohabitacion ADD CONSTRAINT tipohabitación_pk PRIMARY KEY ( id );

# CREATE TABLE tipousuario (
#     nombre VARCHAR2(4000) NOT NULL
# );

# ALTER TABLE tipousuario ADD CONSTRAINT tipousuario_pk PRIMARY KEY ( nombre );

# CREATE TABLE usuario (
#     id                 INTEGER NOT NULL,
#     nombre             VARCHAR2(4000) NOT NULL,
#     username           VARCHAR2(4000) NOT NULL,
#     password           VARCHAR2(4000) NOT NULL,
#     tipousuario_nombre VARCHAR2(4000) NOT NULL
# );

# ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

# CREATE TABLE utensilio (
#     id                   INTEGER NOT NULL,
#     nombre               VARCHAR2(4000),
#     precio               FLOAT(2),
#     prestamo_servicio_id INTEGER NOT NULL
# );

# ALTER TABLE utensilio ADD CONSTRAINT utensilio_pk PRIMARY KEY ( id );

# ALTER TABLE acompanante
#     ADD CONSTRAINT acompanante_usuario_fk FOREIGN KEY ( usuario_id )
#         REFERENCES usuario ( id );

# ALTER TABLE cuentaservicio
#     ADD CONSTRAINT cuentaservicio_habitacion_fk FOREIGN KEY ( habitacion_id )
#         REFERENCES habitacion ( id );

# ALTER TABLE cuentaservicio
#     ADD CONSTRAINT cuentaservicio_servicio_fk FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE dotacion
#     ADD CONSTRAINT dotacion_habitacion_fk FOREIGN KEY ( habitacion_id )
#         REFERENCES habitacion ( id );

# ALTER TABLE habitacion
#     ADD CONSTRAINT habitacion_tipohabitación_fk FOREIGN KEY ( tipohabitación_id )
#         REFERENCES tipohabitacion ( id );

# ALTER TABLE maquina
#     ADD CONSTRAINT maquina_gimnasio_fk FOREIGN KEY ( gimnasio_servicio_id )
#         REFERENCES gimnasio ( servicio_id );

# ALTER TABLE planconsumo
#     ADD CONSTRAINT planconsumo_hotel_fk FOREIGN KEY ( hotel_id )
#         REFERENCES hotel ( id );

# ALTER TABLE producto
#     ADD CONSTRAINT producto_bar_fk FOREIGN KEY ( bar_servicio_id )
#         REFERENCES bar ( servicio_id );

# ALTER TABLE producto
#     ADD CONSTRAINT producto_restaurante_fk FOREIGN KEY ( restaurante_servicio_id )
#         REFERENCES restaurante ( servicio_id );

# ALTER TABLE producto
#     ADD CONSTRAINT producto_tienda_fk FOREIGN KEY ( tienda_servicio_id )
#         REFERENCES tienda ( servicio_id );

# ALTER TABLE productospa
#     ADD CONSTRAINT productospa_spa_fk FOREIGN KEY ( spa_servicio_id )
#         REFERENCES spa ( servicio_id );

# ALTER TABLE reserva
#     ADD CONSTRAINT reserva_habitacion_fk FOREIGN KEY ( habitacion_id )
#         REFERENCES habitacion ( id );

# ALTER TABLE reserva
#     ADD CONSTRAINT reserva_usuario_fk FOREIGN KEY ( usuario_id )
#         REFERENCES usuario ( id );

# ALTER TABLE reservasalon
#     ADD CONSTRAINT reservasalon_salon_fk FOREIGN KEY ( salon_service_id )
#         REFERENCES salon ( service_id );

# ALTER TABLE reservaspa
#     ADD CONSTRAINT reservaspa_spa_fk FOREIGN KEY ( spa_servicio_id )
#         REFERENCES spa ( servicio_id );

# ALTER TABLE restaurante
#     ADD CONSTRAINT restaurante_servicio_fk FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE servicio
#     ADD CONSTRAINT servicio_hotel_fk FOREIGN KEY ( hotel_id )
#         REFERENCES hotel ( id );

# ALTER TABLE lavado
#     ADD CONSTRAINT servicio_id FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE bar
#     ADD CONSTRAINT servicio_idv2 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE tienda
#     ADD CONSTRAINT servicio_idv3 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE internet
#     ADD CONSTRAINT servicio_idv4 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE piscina
#     ADD CONSTRAINT servicio_idv5 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE salon
#     ADD CONSTRAINT servicio_idv6 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE gimnasio
#     ADD CONSTRAINT servicio_idv7 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE prestamo
#     ADD CONSTRAINT servicio_idv8 FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE spa
#     ADD CONSTRAINT spa_servicio_fk FOREIGN KEY ( servicio_id )
#         REFERENCES servicio ( id );

# ALTER TABLE usuario
#     ADD CONSTRAINT usuario_tipousuario_fk FOREIGN KEY ( tipousuario_nombre )
#         REFERENCES tipousuario ( nombre );

# ALTER TABLE utensilio
#     ADD CONSTRAINT utensilio_prestamo_fk FOREIGN KEY ( prestamo_servicio_id )
#         REFERENCES prestamo ( servicio_id );



# -- Informe de Resumen de Oracle SQL Developer Data Modeler: 
# -- 
# -- CREATE TABLE                            27
# -- CREATE INDEX                             0
# -- ALTER TABLE                             55
# -- CREATE VIEW                              0
# -- ALTER VIEW                               0
# -- CREATE PACKAGE                           0
# -- CREATE PACKAGE BODY                      0
# -- CREATE PROCEDURE                         0
# -- CREATE FUNCTION                          0
# -- CREATE TRIGGER                           0
# -- ALTER TRIGGER                            0
# -- CREATE COLLECTION TYPE                   0
# -- CREATE STRUCTURED TYPE                   0
# -- CREATE STRUCTURED TYPE BODY              0
# -- CREATE CLUSTER                           0
# -- CREATE CONTEXT                           0
# -- CREATE DATABASE                          0
# -- CREATE DIMENSION                         0
# -- CREATE DIRECTORY                         0
# -- CREATE DISK GROUP                        0
# -- CREATE ROLE                              0
# -- CREATE ROLLBACK SEGMENT                  0
# -- CREATE SEQUENCE                          0
# -- CREATE MATERIALIZED VIEW                 0
# -- CREATE MATERIALIZED VIEW LOG             0
# -- CREATE SYNONYM                           0
# -- CREATE TABLESPACE                        0
# -- CREATE USER                              0
# -- 
# -- DROP TABLESPACE                          0
# -- DROP DATABASE                            0
# -- 
# -- REDACTION POLICY                         0
# -- 
# -- ORDS DROP SCHEMA                         0
# -- ORDS ENABLE SCHEMA                       0
# -- ORDS ENABLE OBJECT                       0
# -- 
# -- ERRORS                                   0
# -- WARNINGS                                 0
import random
from datetime import datetime, timedelta

# Datas
from data import *

# tipousuario table

# Generate sample data for tipousuario
tipousuario_records = [(name,) for name in tipousuario_data]



# Generate sample data for usuario
num_users = 10000

random_names = [f"{random.choice(first_names)} {random.choice(last_names)}" for _ in range(num_users)]

usernames_real = [name.split()[0].lower() + str(i) for i, name in enumerate(random_names, 1)]
passwords_real = [f"pwd_{name.split()[1].lower()[:3]}{i}" for i, name in enumerate(random_names, 1)]


# Assign random tipousuario to each user
user_tipousuario = [random.choice(tipousuario_data) for _ in range(num_users)]

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
