
CREATE DATABASE IF NOT EXISTS ex10;

USE ex10;

CREATE TABLE IF NOT EXISTS account (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50) NOT NULL,
     amount DOUBLE NOT NULL
);
