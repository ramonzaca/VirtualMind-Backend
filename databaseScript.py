#!/usr/bin/env python3

import pymysql
import names
import random
import string

connection = pymysql.connect(host='localhost',
                             user='root',
                             password='root',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)

print ("[1]. Conexión con el servidor MySQL exitosa.")

cursor = connection.cursor();

cursor.execute("CREATE DATABASE IF NOT EXISTS users;")

print ("[2]. Creación de la base de datos \"users\"")
cursor.execute("USE users;")

cursor.execute("CREATE TABLE IF NOT EXISTS users (id bigint(20) not null primary key auto_increment, name varchar(255) not null , surname varchar(255) not null , email varchar(255) not null , password varchar(255) not null , created_at DATETIME DEFAULT CURRENT_TIMESTAMP not null , updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null );")

print ("[3]. Base de datos creada.")

try:
	for i in range(50):
		cmd = "INSERT INTO users.users (name, surname, email, password) VALUES"
		pas = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10))
		fn = names.get_first_name()
		ln = names.get_last_name()
		cursor.execute(cmd+" ('"+fn+"','"+ln+"','"+fn+ln+"@virtualmind.io','"+pas+"');")
	connection.commit()

	print("[4]. Llenado de la base de datos completa.")
except:
	connection.rollback()
	print("Error durante el llenado de la base de datos. Rollback a un estado seguro.")



print("[4]. Llenado de la base de datos completa.")
connection.close()
print ("[5]. Conexión cerrada. Fin del script.")
