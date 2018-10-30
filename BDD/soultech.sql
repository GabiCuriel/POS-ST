create database soultech;

use soultech


create table clientes(
    ID_CL      varchar(13)  primary key,
    NOMBRE_CL  varchar(30)  not null,
    AP_CL      varchar(30)  not null,
    AM_CL     varchar(30)  not null,
    TEL_CL     varchar(15)  not null,
    RFC_CL     varchar(20)  not null,
    PAYBACK_CL    double    not null,
    ID_D       varchar(10)  not null,) ;

create table empleados(
    ID_ E    varchar(13) primary key,
    NOMBRE_CL  varchar(30)  not null,
    AP_CL      varchar(30)  not null,
    AM_CL     varchar(30)  not null,
    TEL_CL     varchar(15)  not null,
    RFC_CL     varchar(20)  not null,
    CURP_E     varchar(20)  not null,
    ID_D       varchar(13)  not null,
    ID_B       varchar(13)  not null,
    NSS_E      varchar(20)  not null,);

create table ventas(
    ID_V  varchar(13) primary key,
    ID_US varchar(13) not null,
    ID_CL varchar(13) not null,
    FECHA_V varchar(15) not null,
    IVA_V  double       not null,
    IMPORTE_V double    NOT NULL,
    DECUENTO_v BOLEAN   NOT NULL,);

create table direciones(
    ID_D varchar(13) primary key,
    CALLE_D varchar(30) not null,
    COL_D   varchar(30) NOT NULL,
    NO_INT_D varchar(10) not null,
    NO_EXT_D varchar(10) NOT NULL,
    CP_D     VARCHAR(5)  NOT NULL,
    CD_D    varchar(20)  NOT null,
    EDO_D   VARCHAR(20)  NOT NULL,);

create table productos(
    ID_P  VARCHAR(13)  PRIMARY KEY,
    NOMBRE_p VARCHAR(30) NOT NULL,
    TIPO_P   VARCHAR(20) NOT NULL,
    MARCA_P  VARCHAR(20) NOT NULL,
    SKU_p    VARCHAR(20) NOT NULL,
    PRECIO   double      NOT  NULL,);


create table usuarios(
    ID_US  VARCHAR(13)  PRIMARY KEY,
    USERNAME_ US VARCHAR(15) NOT  NULL,
    PASSWORD_US  TEXT        NOT NULL,
    TIPO_USUARIO VARCHAR(20) NOT NULL,
    ID_E         VARCHAR(13) NOT NULL,);

create table datosbanco(
    ID_CP    VARCHAR(13)  PRIMARY KEY,
    NOMBRE_B VARCHAR(20)  NOT NULL,
    NO_CUENTA VARCHAR(20) NOT NULL,);

create table probedores(
    ID_PR  VARCHAR(13) PRIMARY KEY,
    NOMBRE_PR VARCHAR(30)  NOT NULL,
    ID_D  VARCHAR(13) NOT NULL,
    TEL_PR VARCHAR(15) NOT NULL,
    EMAIL_PR VARCHAR(15) NOT NULL,);

create table compras(
    ID_CO VARCHAR(13)  PRIMARY KEY,
    ID_US VARCHAR(13)  NOT NULL,
    FECHA_CO VARCHAR(15) NOT NULL,
    IMPORTE_CO DOUBLE    NOT NULL,
    ID_PR      VARCHAR(13) NOT NULL,
    IVA_CO      DOUBLE     NOT NULL,);
    
create table ferreteria(
    ID_F  VARCHAR(13) PRIMARY KEY,
    ID_E  VARCHAR(13) NOT NULL,
    ID_D  VARCHAR(13) NOT NULL,);

create table facturas(
    ID_FA VARCHAR(13) PRIMARY KEY,
    ID_CL VARCHAR(13) PRIMARY KEY,
    ID_US VARCHAR(13) PRIMARY KEY,
    ID_F VARCHAR(13) PRIMARY KEY,
    ID_Y VARCHAR(13) PRIMARY KEY,);


create table vemtas_productos(
    DI_CP VARCHAR(13)  PRIMARY KEY,
    ID_CO  VARCHAR(13) NOT NULL,
    PRECIO_CP DOUBLE NOT NULL,
    ID_P  VARCHAR(13) NOT NULL,
    CANTIDAD_CP INT   NOT NULL,);

create table ferreteria_productos(
    ID_FP   VARCHAR(13)  PRIMARY KEY,
    ID_F    VARCHAR(13)  NOT NULL,
    ID_P    VARCHAR(13)  NOT NULL,
    EXIZTENCIA_FP INT    NOT NULL);

create table empleados_ferreteria(
    ID_EF VARCHAR(13) PRIMARY KEY,
    ID_E  VARCHAR(13) NOT NULL,
    ID_F  VARCHAR(13) NOT NULL,);

create table ventas_ferreteria(
    ID_VF  VARCHAR(13)  PRIMARY KEY
    ID_V   VARCHAR(13)  NOT NULL,
    ID_F   VARCHAR(13)  NOT NULL,);