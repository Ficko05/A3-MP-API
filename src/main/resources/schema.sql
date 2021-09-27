DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS subject_students;

CREATE TABLE student
(
    student_id LONG PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    mail VARCHAR(25) NOT NULL

);

CREATE TABLE subject
(
    subject_id LONG PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    classroom VARCHAR(25) NOT NULL
);

CREATE TABLE subject_students
(
    subject_id LONG NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id),
    student_id LONG NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(student_id)
)