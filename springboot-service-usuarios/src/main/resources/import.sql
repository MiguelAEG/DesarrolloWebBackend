INSERT INTO usuarios (username, password, eneable, nombre, apellido, email) VALUES ('miguel', '12345', 1, 'Miguel', 'Enriquez', 'miguel@gmail.com');
INSERT INTO usuarios (username, password, eneable, nombre, apellido, email) VALUES ('usuario', '12345', 1, 'Nombre', 'Apellido', 'usuario@gmail.com'); 

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 1);