create database TIENDA_POKEMON;
USE  TIENDA_POKEMON;

CREATE TABLE POKEMON (
	CODIGO_POKEMON INT PRIMARY KEY,
	NOMBRE VARCHAR(30),
	TIPO VARCHAR(30),
	COLOR VARCHAR(30),
    NUM_EVO INT,
	LEGENDARIO BOOLEAN
);

CREATE TABLE CLIENTE (
	DNI VARCHAR (9) PRIMARY KEY,
	NOMBRE VARCHAR(30),
	APELLIDO VARCHAR(30),
    FECHA_NAC DATE,
    SALDO FLOAT,
    CONTRASENA VARCHAR (30)
);

CREATE TABLE OBTIENE (
	DNI VARCHAR (9),
    CODIGO_POKEMON INT, 
	PRIMARY KEY(DNI,CODIGO_POKEMON),
	FOREIGN KEY (DNI) REFERENCES CLIENTE (DNI),
	FOREIGN KEY (CODIGO_POKEMON) REFERENCES POKEMON (CODIGO_POKEMON)
);

CREATE TABLE OBJETO (
	NOMBRE VARCHAR(30) PRIMARY KEY,
	PRECIO FLOAT,
	TIPO_OBJETO VARCHAR(30),
    STOCK INT
);

CREATE TABLE COMPRA (
	DNI VARCHAR (9),
    NOMBRE VARCHAR(30), 
	PRIMARY KEY(DNI,NOMBRE),
	FOREIGN KEY (DNI) REFERENCES CLIENTE (DNI),
	FOREIGN KEY (NOMBRE) REFERENCES OBJETO (NOMBRE)
);

CREATE TABLE CURAS (
    NOMBRE VARCHAR(30), 
	PRIMARY KEY(NOMBRE), 
	FOREIGN KEY (NOMBRE) REFERENCES OBJETO (NOMBRE)
);

CREATE TABLE POKEBALLS (
    NOMBRE VARCHAR(30), 
	PRIMARY KEY(NOMBRE), 
	FOREIGN KEY (NOMBRE) REFERENCES OBJETO (NOMBRE)
);

CREATE TABLE COMIDA (
    NOMBRE VARCHAR(30), 
	PRIMARY KEY(NOMBRE), 
	FOREIGN KEY (NOMBRE) REFERENCES OBJETO (NOMBRE)
);


INSERT INTO POKEMON VALUES (1,'Bulbasur','Planta','Verde',1,false);
INSERT INTO POKEMON VALUES (2,'Ivysaur','Planta','Verde',2,false);
INSERT INTO POKEMON VALUES (3,'Blastoise','Agua','Azul',3,false);
INSERT INTO POKEMON VALUES (4,'Zapdos','Electrico','Verde',1,true);
INSERT INTO POKEMON VALUES (5,'Mew','Psiquico','Verde',1,true);

INSERT INTO CLIENTE VALUES ('654435632T','Erik','Sanz','1999-08-23',40,'1234E');
INSERT INTO CLIENTE VALUES ('321456789D','María','González','20001-01-17',150,'1234M');
INSERT INTO CLIENTE VALUES ('987654231U','Juan','Martínez','2004-10-04',345,'1234J');
INSERT INTO CLIENTE VALUES ('563423428N','Ana','López','1992-12-29',500,'1234A');

INSERT INTO CLIENTE VALUES ('654435632T','1');
INSERT INTO CLIENTE VALUES ('654435632T','4');
INSERT INTO CLIENTE VALUES ('987654231U','1');
INSERT INTO CLIENTE VALUES ('563423428N','3');

INSERT INTO OBJETO VALUES ('Pocion',20,'Curas',99);
INSERT INTO OBJETO VALUES ('Antiparizador',15,'Curas',200);
INSERT INTO OBJETO VALUES ('Curri',35,'Comida',50);
INSERT INTO OBJETO VALUES ('Baya aranja',5,'Comida',149);
INSERT INTO OBJETO VALUES ('Pokeball',10,'Pokeballs',250);
INSERT INTO OBJETO VALUES ('Ocaso ball',25,'Pokeballs',180);

INSERT INTO COMPRA VALUES ('654435632T','Curri');
INSERT INTO COMPRA VALUES ('987654231U','Antiparizador');
INSERT INTO COMPRA VALUES ('987654231U','Pokeball');
INSERT INTO COMPRA VALUES ('563423428N','Ocaso ball');

INSERT INTO CURAS VALUES ('Pocion');
INSERT INTO CURAS VALUES ('Pocion');

INSERT INTO POKEBALLS VALUES ('Pokeball');
INSERT INTO POKEBALLS VALUES ('Ocaso ball');

INSERT INTO COMIDA VALUES ('Curri');
INSERT INTO COMIDA VALUES ('Baya aranja');


-- Administrador:
CREATE USER adminadmin IDENTIFIED BY 'admin1234';
GRANT ALL PRIVILEGES ON * TO adminadmin;

-- Cliente:
CREATE USER cliente IDENTIFIED BY 'cliente1234';
GRANT SELECT, UPDATE ON * TO cliente;