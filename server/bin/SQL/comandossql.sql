-- creo el schema
CREATE DATABASE `tip-instituto` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;

-- selecciono schema
use `tip-instituto`;

-- consulta para traer los alumnos  correspondientes a un curso especifico

SELECT student.surname, student.name, student.dni, student.mail, student.tel_principal, student.tel_secundario, student_course.course_id
FROM student_course
INNER JOIN student ON student_course.student_id = student.id
WHERE student_course.course_id = 1
ORDER BY student.surname;

