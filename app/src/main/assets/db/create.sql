CREATE TABLE fonte (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);
CREATE TABLE categoria (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);
CREATE TABLE credor (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,	nome TEXT NOT NULL);
CREATE TABLE favorecido (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,	nome TEXT NOT NULL);
CREATE TABLE despesa (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, data DATE NOT NULL, valor REAL NOT NULL, id_fonte INTEGER NOT NULL, id_categoria INTEGER NOT NULL, id_credor INTEGER, id_favorecido INTEGER, FOREIGN KEY (id_fonte) REFERENCES fonte(id), FOREIGN KEY (id_categoria) REFERENCES categoria(id), FOREIGN KEY (id_credor) REFERENCES credor(id), FOREIGN KEY (id_favorecido) REFERENCES favorecido(id));