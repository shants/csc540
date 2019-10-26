DELETE FROM FACILITY;
DELETE FROM FACILITY_ADDRESS;
DELETE FROM FACILITY_CLASSIFICATION;
DELETE FROM STREET;
DELETE FROM CITY;
DELETE FROM STATE;
DELETE FROM COUNTRY;
DELETE FROM SYMPTOM;
DELETE FROM CERTIFICATION;


DROP sequence fc_cls_seq;
CREATE SEQUENCE fc_cls_seq START WITH 1;

DROP sequence street_seq;
CREATE SEQUENCE street_seq START WITH 1;

DROP sequence city_seq;
CREATE SEQUENCE city_seq START WITH 1;

DROP sequence state_seq;
CREATE SEQUENCE state_seq START WITH 1;

DROP sequence country_seq;
CREATE SEQUENCE country_seq START WITH 1;

DROP sequence facility_address_seq;
CREATE SEQUENCE facility_address_seq START WITH 1;

DROP sequence facility_seq;
CREATE SEQUENCE facility_seq START WITH 1;

DROP sequence staff_department_type_seq;
CREATE SEQUENCE staff_department_type_seq START WITH 1;

DROP sequence certification_seq;
CREATE SEQUENCE certification_seq START WITH 1;

INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('PRIMARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('SECONDARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('TERTIARY');

INSERT INTO STREET(street_name) VALUES('Baker Street');
INSERT INTO CITY(city_name) VALUES('LONDON');
INSERT INTO STATE(state_name) VALUES('LONDON');
INSERT INTO COUNTRY(country_name) VALUES('UK');

INSERT INTO FACILITY_ADDRESS(street_num,street_id,city_id,state_id,country_id) VALUES('221B',1,1,1,1);
INSERT INTO FACILITY(facility_name,capacity,classification_id,facility_address_id) VALUES('SHANTS HOSPITAL', 200, 1, 1);


INSERT INTO SYMPTOM(symptom_code, symptom_name) values (1,'PAIN');
INSERT INTO SYMPTOM(symptom_code, symptom_name) values (2, 'FEVER');
INSERT INTO SYMPTOM(symptom_code, symptom_name) values (3, 'DIZZYNESS');

INSERT INTO staff_department_type(type_name) values ('MEDICAL');
INSERT INTO staff_department_type(type_name) values ('NONMEDICAL');

INSERT INTO certification(certification_name) values ('ISO-9011');
INSERT INTO certification(certification_name) values ('ISO-9012');

execute create_new_staff_tables(1);

insert into staff_1(name, hire_date, designation, type_id) values ('dr A', TO_DATE('2019/10/26', 'yyyy/mm/dd'), 'Admin', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('dr B', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'vp', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('abc', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'office', 2);
