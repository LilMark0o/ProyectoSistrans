-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 22:40:20 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE acompanante (
    id         INTEGER NOT NULL,
    nombre     VARCHAR2(4000),
    usuario_id INTEGER NOT NULL
);

ALTER TABLE acompanante ADD CONSTRAINT acompanante_pk PRIMARY KEY ( id );

CREATE TABLE bar (
    id        INTEGER NOT NULL,
    estilo    VARCHAR2(4000),
    capacidad INTEGER,
    hotel_id  INTEGER NOT NULL
);

ALTER TABLE bar ADD CONSTRAINT bar_pk PRIMARY KEY ( id );

CREATE TABLE cuentagimnasio (
    cuentatotal_id INTEGER NOT NULL,
    gimnasio_id    INTEGER NOT NULL
);

ALTER TABLE cuentagimnasio ADD CONSTRAINT relation_44_pk PRIMARY KEY ( cuentatotal_id,
                                                                       gimnasio_id );

CREATE TABLE cuentainternet (
    internet_id    INTEGER NOT NULL,
    cuentatotal_id INTEGER NOT NULL
);

ALTER TABLE cuentainternet ADD CONSTRAINT relation_49_pk PRIMARY KEY ( internet_id,
                                                                       cuentatotal_id );

CREATE TABLE cuentalavado (
    cuentatotal_id INTEGER NOT NULL,
    lavado_id      INTEGER NOT NULL
);

ALTER TABLE cuentalavado ADD CONSTRAINT relation_41_pk PRIMARY KEY ( cuentatotal_id,
                                                                     lavado_id );

CREATE TABLE cuentapiscina (
    piscina_id     INTEGER NOT NULL,
    cuentatotal_id INTEGER NOT NULL
);

ALTER TABLE cuentapiscina ADD CONSTRAINT relation_39_pk PRIMARY KEY ( piscina_id,
                                                                      cuentatotal_id );

CREATE TABLE cuentaprestamo (
    cuentatotal_id INTEGER NOT NULL,
    prestamo_id    INTEGER NOT NULL
);

ALTER TABLE cuentaprestamo ADD CONSTRAINT relation_53_pk PRIMARY KEY ( cuentatotal_id,
                                                                       prestamo_id );

CREATE TABLE cuentaproducto (
    cuentatotal_id INTEGER NOT NULL,
    producto_id    INTEGER NOT NULL
);

ALTER TABLE cuentaproducto ADD CONSTRAINT relation_51_pk PRIMARY KEY ( cuentatotal_id,
                                                                       producto_id );

CREATE TABLE cuentaproductospa (
    cuentatotal_id INTEGER NOT NULL,
    productospa_id INTEGER NOT NULL
);

ALTER TABLE cuentaproductospa ADD CONSTRAINT relation_52_pk PRIMARY KEY ( cuentatotal_id,
                                                                          productospa_id );

CREATE TABLE cuentatotal (
    id             INTEGER NOT NULL,
    fecha          DATE,
    tiposervicio   VARCHAR2(4000) NOT NULL,
    piscina_id     INTEGER NOT NULL,
    bar_id         INTEGER NOT NULL,
    restaurante_id INTEGER NOT NULL,
    tienda_id      INTEGER NOT NULL,
    spa_id         INTEGER NOT NULL,
    gimnasio_id    INTEGER NOT NULL,
    lavado_id      INTEGER NOT NULL,
    internet_id    INTEGER NOT NULL,
    habitacion_id  INTEGER NOT NULL
);

ALTER TABLE cuentatotal ADD CONSTRAINT cuentatotal_pk PRIMARY KEY ( id );

CREATE TABLE dotacion (
    id            INTEGER NOT NULL,
    nombre        VARCHAR2(4000),
    costo         FLOAT,
    cobro         NUMBER,
    habitacion_id INTEGER NOT NULL
);

ALTER TABLE dotacion ADD CONSTRAINT dotacion_pk PRIMARY KEY ( id );

CREATE TABLE gimnasio (
    id         INTEGER NOT NULL,
    horainicio INTEGER,
    horafin    INTEGER,
    secobra    NUMBER,
    hotel_id   INTEGER NOT NULL
);

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( id );

CREATE TABLE habitacion (
    id             INTEGER NOT NULL,
    capacidad      INTEGER,
    costonoche     FLOAT,
    tipohabitacion VARCHAR2(4000),
    hotel_id       INTEGER NOT NULL
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

CREATE TABLE hotel (
    id INTEGER NOT NULL
);

ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    id        INTEGER NOT NULL,
    capacidad FLOAT,
    precio    FLOAT,
    secobra   NUMBER,
    hotel_id  INTEGER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( id );

CREATE TABLE lavado (
    id             INTEGER NOT NULL,
    precio         FLOAT,
    cantidadalavar INTEGER,
    hotel_id       INTEGER NOT NULL
);

ALTER TABLE lavado ADD CONSTRAINT lavado_pk PRIMARY KEY ( id );

CREATE TABLE maquina (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(4000),
    gimnasio_id INTEGER NOT NULL
);

ALTER TABLE maquina ADD CONSTRAINT maquina_pk PRIMARY KEY ( id );

CREATE TABLE piscina (
    id          INTEGER NOT NULL,
    profundidad FLOAT,
    horainicio  INTEGER,
    horafin     INTEGER,
    secobra     NUMBER,
    hotel_id    INTEGER NOT NULL
);

ALTER TABLE piscina ADD CONSTRAINT piscina_pk PRIMARY KEY ( id );

CREATE TABLE planconsumo (
    id          INTEGER NOT NULL,
    descripcion VARCHAR2(4000),
    descuento   INTEGER,
    hotel_id    INTEGER NOT NULL
);

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( id );

CREATE TABLE prestamo (
    id             INTEGER NOT NULL,
    devuelto       NUMBER,
    cuentatotal_id INTEGER NOT NULL,
    hotel_id       INTEGER NOT NULL
);

CREATE UNIQUE INDEX prestamo__idx ON
    prestamo (
        cuentatotal_id
    ASC );

ALTER TABLE prestamo ADD CONSTRAINT prestamo_pk PRIMARY KEY ( id );

CREATE TABLE producto (
    id             INTEGER NOT NULL,
    precio         FLOAT,
    nombre         VARCHAR2(4000),
    restaurante_id INTEGER NOT NULL,
    tienda_id      INTEGER NOT NULL,
    bar_id         INTEGER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE productospa (
    id       INTEGER NOT NULL,
    nombre   VARCHAR2(4000) NOT NULL,
    duracion INTEGER,
    precio   FLOAT,
    spa_id   INTEGER NOT NULL
);

ALTER TABLE productospa ADD CONSTRAINT productospa_pk PRIMARY KEY ( id );

CREATE TABLE reserva (
    id            INTEGER NOT NULL,
    fecha         DATE,
    cobro         FLOAT,
    usuario_id    INTEGER NOT NULL,
    habitacion_id INTEGER NOT NULL
);

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id );

CREATE TABLE reservasalon (
    id           INTEGER NOT NULL,
    fecha        DATE,
    tiempoespera INTEGER,
    salon_id     INTEGER NOT NULL
);

ALTER TABLE reservasalon ADD CONSTRAINT reservasalon_pk PRIMARY KEY ( id );

CREATE TABLE reservaspa (
    id     INTEGER NOT NULL,
    fecha  DATE,
    hora   INTEGER,
    spa_id INTEGER NOT NULL
);

ALTER TABLE reservaspa ADD CONSTRAINT reservaspa_pk PRIMARY KEY ( id );

CREATE TABLE restaurante (
    id       INTEGER NOT NULL,
    hotel_id INTEGER NOT NULL
);

ALTER TABLE restaurante ADD CONSTRAINT restaurante_pk PRIMARY KEY ( id );

CREATE TABLE salon (
    id                  INTEGER NOT NULL,
    capacidad           INTEGER,
    tiposalon           VARCHAR2(4000),
    horasuso            INTEGER,
    equipocomputacion   NUMBER,
    equipoproyeccion    NUMBER,
    equipoamplificacion NUMBER,
    hotel_id            INTEGER NOT NULL
);

ALTER TABLE salon ADD CONSTRAINT salon_pk PRIMARY KEY ( id );

CREATE TABLE spa (
    id       INTEGER NOT NULL,
    hotel_id INTEGER NOT NULL
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( id );

CREATE TABLE tienda (
    id       INTEGER NOT NULL,
    hotel_id INTEGER NOT NULL
);

ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( id );

CREATE TABLE usuario (
    id              INTEGER NOT NULL,
    nombre          VARCHAR2(4000) NOT NULL,
    username        VARCHAR2(4000) NOT NULL,
    password        VARCHAR2(4000) NOT NULL,
    tipousuario     VARCHAR2(4000) NOT NULL,
    hotel_id        INTEGER NOT NULL,
    tipodedocumento VARCHAR2(4000)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

CREATE TABLE utensilio (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(4000),
    precio      FLOAT(2),
    prestamo_id INTEGER NOT NULL
);

CREATE UNIQUE INDEX utensilio__idx ON
    utensilio (
        prestamo_id
    ASC );

ALTER TABLE utensilio ADD CONSTRAINT utensilio_pk PRIMARY KEY ( id );

ALTER TABLE acompanante
    ADD CONSTRAINT acompanante_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE bar
    ADD CONSTRAINT bar_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_bar_fk FOREIGN KEY ( bar_id )
        REFERENCES bar ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasio ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_internet_fk FOREIGN KEY ( internet_id )
        REFERENCES internet ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_lavado_fk FOREIGN KEY ( lavado_id )
        REFERENCES lavado ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_piscina_fk FOREIGN KEY ( piscina_id )
        REFERENCES piscina ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_restaurante_fk FOREIGN KEY ( restaurante_id )
        REFERENCES restaurante ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE cuentatotal
    ADD CONSTRAINT cuentatotal_tienda_fk FOREIGN KEY ( tienda_id )
        REFERENCES tienda ( id );

ALTER TABLE dotacion
    ADD CONSTRAINT dotacion_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE gimnasio
    ADD CONSTRAINT gimnasio_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE internet
    ADD CONSTRAINT internet_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE lavado
    ADD CONSTRAINT lavado_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE maquina
    ADD CONSTRAINT maquina_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasio ( id );

ALTER TABLE piscina
    ADD CONSTRAINT piscina_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE planconsumo
    ADD CONSTRAINT planconsumo_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE prestamo
    ADD CONSTRAINT prestamo_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE prestamo
    ADD CONSTRAINT prestamo_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_bar_fk FOREIGN KEY ( bar_id )
        REFERENCES bar ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_restaurante_fk FOREIGN KEY ( restaurante_id )
        REFERENCES restaurante ( id );

ALTER TABLE producto
    ADD CONSTRAINT producto_tienda_fk FOREIGN KEY ( tienda_id )
        REFERENCES tienda ( id );

ALTER TABLE productospa
    ADD CONSTRAINT productospa_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE cuentapiscina
    ADD CONSTRAINT relation_39_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentapiscina
    ADD CONSTRAINT relation_39_piscina_fk FOREIGN KEY ( piscina_id )
        REFERENCES piscina ( id );

ALTER TABLE cuentalavado
    ADD CONSTRAINT relation_41_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentalavado
    ADD CONSTRAINT relation_41_lavado_fk FOREIGN KEY ( lavado_id )
        REFERENCES lavado ( id );

ALTER TABLE cuentagimnasio
    ADD CONSTRAINT relation_44_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentagimnasio
    ADD CONSTRAINT relation_44_gimnasio_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasio ( id );

ALTER TABLE cuentainternet
    ADD CONSTRAINT relation_49_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentainternet
    ADD CONSTRAINT relation_49_internet_fk FOREIGN KEY ( internet_id )
        REFERENCES internet ( id );

ALTER TABLE cuentaproducto
    ADD CONSTRAINT relation_51_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentaproducto
    ADD CONSTRAINT relation_51_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE cuentaproductospa
    ADD CONSTRAINT relation_52_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentaproductospa
    ADD CONSTRAINT relation_52_productospa_fk FOREIGN KEY ( productospa_id )
        REFERENCES productospa ( id );

ALTER TABLE cuentaprestamo
    ADD CONSTRAINT relation_53_cuentatotal_fk FOREIGN KEY ( cuentatotal_id )
        REFERENCES cuentatotal ( id );

ALTER TABLE cuentaprestamo
    ADD CONSTRAINT relation_53_prestamo_fk FOREIGN KEY ( prestamo_id )
        REFERENCES prestamo ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE reservasalon
    ADD CONSTRAINT reservasalon_salon_fk FOREIGN KEY ( salon_id )
        REFERENCES salon ( id );

ALTER TABLE reservaspa
    ADD CONSTRAINT reservaspa_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( id );

ALTER TABLE restaurante
    ADD CONSTRAINT restaurante_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE salon
    ADD CONSTRAINT salon_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE spa
    ADD CONSTRAINT spa_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE tienda
    ADD CONSTRAINT tienda_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE utensilio
    ADD CONSTRAINT utensilio_prestamo_fk FOREIGN KEY ( prestamo_id )
        REFERENCES prestamo ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            31
-- CREATE INDEX                             2
-- ALTER TABLE                             80
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
