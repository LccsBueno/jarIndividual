CREATE DATABASE cineguardian;
USE cineguardian;

CREATE TABLE tb_users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE tb_address (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cep VARCHAR(255),
    neighborhood VARCHAR(255),
    number VARCHAR(255),
    street VARCHAR(255),
    compl VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE tb_companies (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_address INTEGER,
    name VARCHAR(255),
    cnpj VARCHAR(255),
    FOREIGN KEY (id_address) REFERENCES tb_address (id)
);

CREATE TABLE tb_cpu (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE tb_disk (
    id VARCHAR(255) PRIMARY KEY,
    model VARCHAR(255)
);

CREATE TABLE tb_computers (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_cpu VARCHAR(255),
    id_disk VARCHAR(255),
    hostname VARCHAR(255),
    maker VARCHAR(255),
    system_info VARCHAR(255),
    FOREIGN KEY (id_cpu) REFERENCES tb_cpu (id),
    FOREIGN KEY (id_disk) REFERENCES tb_disk (id)
);


CREATE TABLE tb_statistics (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_computer INTEGER,
    temperature DOUBLE,
    cpu_usage DOUBLE,
    ram_usage DOUBLE,
    ram_available DOUBLE,
    ram_total DOUBLE,
    disk_total DOUBLE,
    disk_usage DOUBLE,
    FOREIGN KEY (id_computer) REFERENCES tb_computers (id)
);

CREATE TABLE tb_network (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_computer INTEGER,
    name VARCHAR(255),
    mac_address VARCHAR(255),
    packages_received INTEGER,
    packages_sent INTEGER,
    FOREIGN KEY (id_computer) REFERENCES  tb_computers (id)
);

SELECT * FROM tb_computers;
SELECT * FROM tb_cpu;
SELECT * FROM tb_disk;
SELECT * FROM tb_statistics;
SELECT * FROM tb_network;

