INSERT INTO usuarios (username, password, eneable, nombre, apellido, email) VALUES ('miguel', '$2a$10$VvtdK6TyFz9UmKEuFd9u7e9LWzNXN.licjfHS.nxT2oPJXZqysDPm', 1, 'Miguel', 'Enriquez', 'miguel@gmail.com');
INSERT INTO usuarios (username, password, eneable, nombre, apellido, email) VALUES ('usuario', '$2a$10$RhNfNQWNmeVnYki8Gm49Ce6jF3H7MFUeA.gjegPp7wQcRKU8gdZF6', 1, 'Nombre', 'Apellido', 'usuario@gmail.com'); 

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 1);