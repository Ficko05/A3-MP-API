insert into student(student_id, name, mail) values(101, 'Alice', 'al@mail.dk');
insert into student(student_id, name, mail) values(102, 'Bob', 'bo@mail.dk');
insert into student(student_id, name, mail) values(103, 'Caroline', 'ca@mail.dk');
insert into student(student_id, name, mail) values(104, 'Daniel', 'da@mail.dk');


insert into subject(subject_id, name, classroom) values(1, 'System Integration', '2.62');
insert into subject(subject_id, name, classroom) values(2, 'LSD', '2.62');
insert into subject(subject_id, name, classroom) values(3, 'Test', '2.62');


insert into subject_students values(1, 101);
insert into subject_students values(1, 102);
insert into subject_students values(1, 103);
insert into subject_students values(1, 104);