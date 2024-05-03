-- Para la tabla alumnos
INSERT INTO alumnos (id, apellido, ciclo, nombre, user_id) 
VALUES 
    (1, 'Apellido1', 1, 'Nombre1', 1),
    (2, 'Apellido2', 2, 'Nombre2', 2),
    (3, 'Apellido3', 3, 'Nombre3', 3),
    (4, 'Apellido4', 4, 'Nombre4', 4),
    (5, 'Apellido5', 5, 'Nombre5', 5);

-- Para la tabla alumnos_cursos
INSERT INTO public.alumnos_cursos (id, alumno_id, curso_id) 
VALUES 
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5);

-- Para la tabla asesores
INSERT INTO public.asesores (id, apellido, experiencia, nombre, tarifa, canal_contacto, user_id) 
VALUES 
    (1, 'Apellido1', 'Experiencia1', 'Nombre1', 100, 1, 1),
    (2, 'Apellido2', 'Experiencia2', 'Nombre2', 200, 2, 2),
    (3, 'Apellido3', 'Experiencia3', 'Nombre3', 300, 3, 3),
    (4, 'Apellido4', 'Experiencia4', 'Nombre4', 400, 4, 4),
    (5, 'Apellido5', 'Experiencia5', 'Nombre5', 500, 5, 5);

-- Para la tabla asesores_cursos
INSERT INTO public.asesores_cursos (id, disponibilidad, nivel_dominio, asesor_id, curso_id) 
VALUES 
    (1, NOW(), 1, 1, 1),
    (2, NOW(), 2, 2, 2),
    (3, NOW(), 3, 3, 3),
    (4, NOW(), 4, 4, 4),
    (5, NOW(), 5, 5, 5);

-- Para la tabla asesorias (suponiendo llaves foráneas válidas)
INSERT INTO public.asesorias (id, calificacion_alumno, calificacion_asesor, duracion, estado, fecha_realizado, fecha_registro, hora_fin, hora_inicio, monto_cobrado, tarifa_pactadas, alumno_id, asesor_id, curso_id) 
VALUES 
    (1, 80, 90, 60, 1, NOW(), NOW(), '12:00:00', '10:00:00', 100.00, 90.00, 1, 1, 1),
    (2, 85, 95, 60, 1, NOW(), NOW(), '12:00:00', '10:00:00', 150.00, 120.00, 2, 2, 2),
    (3, 90, 100, 60, 1, NOW(), NOW(), '12:00:00', '10:00:00', 200.00, 150.00, 3, 3, 3),
    (4, 95, 100, 60, 1, NOW(), NOW(), '12:00:00', '10:00:00', 250.00, 180.00, 4, 4, 4),
    (5, 100, 100, 60, 1, NOW(), NOW(), '12:00:00', '10:00:00', 300.00, 200.00, 5, 5, 5);

-- Para las tablas restantes, repite el proceso de inserción con datos de ejemplo.
-- Para la tabla authorities
INSERT INTO public.authorities (id, name) 
VALUES 
    (1, 'Authority1'),
    (2, 'Authority2'),
    (3, 'Authority3'),
    (4, 'Authority4'),
    (5, 'Authority5');

-- Para la tabla canal_contactos
INSERT INTO public.canal_contactos (id, email, linkedin, telefono, url, canal_contacto) 
VALUES 
    (1, 'email1@example.com', 'linkedin.com/user1', '123456789', 'example.com', 1),
    (2, 'email2@example.com', 'linkedin.com/user2', '987654321', 'example.com', 2),
    (3, 'email3@example.com', 'linkedin.com/user3', '111222333', 'example.com', 3),
    (4, 'email4@example.com', 'linkedin.com/user4', '444555666', 'example.com', 4),
    (5, 'email5@example.com', 'linkedin.com/user5', '777888999', 'example.com', 5);

-- Para la tabla cursos
INSERT INTO public.cursos (id, ciclo, nombre) 
VALUES 
    (1, 1, 'Curso1'),
    (2, 2, 'Curso2'),
    (3, 3, 'Curso3'),
    (4, 4, 'Curso4'),
    (5, 5, 'Curso5');

-- Para la tabla horarios
INSERT INTO public.horarios (id, dia, hora_fin, hora_inicio, asesor_id) 
VALUES 
    (1, 'Lunes', '12:00:00', '10:00:00', 1),
    (2, 'Martes', '12:00:00', '10:00:00', 2),
    (3, 'Miércoles', '12:00:00', '10:00:00', 3),
    (4, 'Jueves', '12:00:00', '10:00:00', 4),
    (5, 'Viernes', '12:00:00', '10:00:00', 5);

-- Para la tabla opiniones
INSERT INTO public.opiniones (id, comentario, fecha, user_id) 
VALUES 
    (1, 'Comentario1', NOW(), 1),
    (2, 'Comentario2', NOW(), 2),
    (3, 'Comentario3', NOW(), 3),
    (4, 'Comentario4', NOW(), 4),
    (5, 'Comentario5', NOW(), 5);

-- Para la tabla users
INSERT INTO public.users (id, enabled, password, password_last_update, user_name) 
VALUES 
    (1, true, 'password1', NOW(), 'user1'),
    (2, true, 'password2', NOW(), 'user2'),
    (3, true, 'password3', NOW(), 'user3'),
    (4, true, 'password4', NOW(), 'user4'),
    (5, true, 'password5', NOW(), 'user5');

-- Para la tabla users_authorities (suponiendo llaves foráneas válidas)
INSERT INTO public.users_authorities (user_id, authority_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);
