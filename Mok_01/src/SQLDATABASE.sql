CREATE DATABASE hospital;
USE hospital;

CREATE TABLE specialty(
id_specialty int auto_increment primary key,
name varchar(40) not null,
description varchar(200) not null
);


CREATE TABLE doctor(
id_doctor int auto_increment primary key,
name varchar(40) not null,
surname varchar(40) not null,
specialty_id int not null,
FOREIGN KEY (specialty_id) REFERENCES specialty (id_specialty)
);

CREATE TABLE patient(
id_patient int auto_increment primary key,
name varchar(40) not null,
surname varchar(40) not null,
birthdate date not null,
identification_document varchar(40) not null
);




CREATE TABLE appointment(
id_appointment int auto_increment primary key,
appointment_date date not null,
appointment_hour time not null,
motive varchar(200) not null,
patient_id int not null,
doctor_id int not null,
FOREIGN KEY (patient_id) REFERENCES patient (id_patient),
FOREIGN KEY (doctor_id) REFERENCES doctor (id_doctor)
);

INSERT INTO specialty (name,description) VALUES ("Otolaryngologies","Check your nose");
INSERT INTO doctor (name,surname,specialty_id) VALUES ("Pepo","G",1);
INSERT INTO patient (name,surname,birthdate,identification_document) VALUES ("Alejandro","Magno","2004-06-01","AE1021");
INSERT INTO appointment (appointment_date,appointment_hour,motive,patient_id,doctor_id) VALUES ("2024-10-10","13:01","Pain in the nose",1,1);
