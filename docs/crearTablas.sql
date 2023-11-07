-- Generated by Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   at:        2023-11-05 16:42:13 COT
--   site:      Oracle Database 12c
--   type:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE acompanante (
    id         INTEGER NOT NULL,
    nombre     VARCHAR2(4000),
    usuario_id INTEGER NOT NULL
);

ALTER TABLE acompanante ADD CONSTRAINT acompanante_pk PRIMARY KEY ( id );

CREATE TABLE cuentaservicio (
    id          INTEGER NOT NULL,
    descripcion VARCHAR2(4000),
    fecha       DATE,
    reserva_id  INTEGER NOT NULL,
    producto_id INTEGER NOT NULL,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE cuentaservicio ADD CONSTRAINT cuentaserviciov1_pk PRIMARY KEY ( id );

CREATE TABLE habitacion (
    id                INTEGER NOT NULL,
    hotel_id          INTEGER NOT NULL,
    tipohabitacion_id INTEGER NOT NULL,
    descripcion       VARCHAR2(4000)
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( id );

CREATE TABLE hotel (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(4000)
);

ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( id );

CREATE TABLE planconsumo (
    id          INTEGER NOT NULL,
    descripcion VARCHAR2(4000),
    descuento   FLOAT(2),
    hotel_id    INTEGER NOT NULL
);

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( id );

CREATE TABLE producto (
    id       INTEGER NOT NULL,
    precio   FLOAT(2),
    nombre   VARCHAR2(4000),
    duracion INTEGER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id );

CREATE TABLE reserva (
    id            INTEGER NOT NULL,
    checkin       DATE,
    checkout      DATE,
    precio        FLOAT(2) NOT NULL,
    habitacion_id INTEGER NOT NULL,
    usuario_id    INTEGER NOT NULL
);

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( id );

CREATE TABLE reservaservicio (
    id          INTEGER NOT NULL,
    horainicio  INTEGER,
    horafin     INTEGER,
    servicio_id INTEGER NOT NULL
);

ALTER TABLE reservaservicio ADD CONSTRAINT reservaservicio_pk PRIMARY KEY ( id );

CREATE TABLE servicio (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(4000),
    precio      FLOAT(2),
    descripcion VARCHAR2(4000),
    hotel_id    INTEGER NOT NULL
);

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( id );

CREATE TABLE servicioproducto (
    servicio_id INTEGER NOT NULL,
    producto_id INTEGER NOT NULL
);

ALTER TABLE servicioproducto ADD CONSTRAINT relation_16_pk PRIMARY KEY ( servicio_id,
                                                                         producto_id );

CREATE TABLE tipohabitacion (
    id         INTEGER NOT NULL,
    costonoche FLOAT(2),
    capacidad  INTEGER,
    nombre     VARCHAR2(4000)
);

ALTER TABLE tipohabitacion ADD CONSTRAINT tipohabitacion_pk PRIMARY KEY ( id );

CREATE TABLE tipousuario (
    nombre VARCHAR2(4000) NOT NULL
);

ALTER TABLE tipousuario ADD CONSTRAINT tipousuario_pk PRIMARY KEY ( nombre );

CREATE TABLE usuario (
    id                 INTEGER NOT NULL,
    nombre             VARCHAR2(4000),
    username           VARCHAR2(4000) NOT NULL,
    password           VARCHAR2(4000) NOT NULL,
    tipousuario_nombre VARCHAR2(4000) NOT NULL,
    hotel_id           INTEGER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

ALTER TABLE acompanante
    ADD CONSTRAINT acompanante_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE cuentaservicio
    ADD CONSTRAINT cuentaserviciov1_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE cuentaservicio
    ADD CONSTRAINT cuentaserviciov1_reserva_fk FOREIGN KEY ( reserva_id )
        REFERENCES reserva ( id );

ALTER TABLE cuentaservicio
    ADD CONSTRAINT cuentaserviciov1_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipohabitacion_fk FOREIGN KEY ( tipohabitacion_id )
        REFERENCES tipohabitacion ( id );

ALTER TABLE planconsumo
    ADD CONSTRAINT planconsumo_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE servicioproducto
    ADD CONSTRAINT relation_16_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( id );

ALTER TABLE servicioproducto
    ADD CONSTRAINT relation_16_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( id );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE reservaservicio
    ADD CONSTRAINT reservaservicio_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( id );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hotel ( id );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipousuario_fk FOREIGN KEY ( tipousuario_nombre )
        REFERENCES tipousuario ( nombre );

-- ALTER TABLE reservaServicio
--     ADD CONSTRAINT usuario_tipousuario_fk FOREIGN KEY ( tipousuario_nombre )
--         REFERENCES tipousuario ( nombre );


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            13
-- CREATE INDEX                             0
-- ALTER TABLE                             28
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
