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

execute create_new_facility('BAKER STREET','LONDON', 'LONDON', 'UK', '221B', 'SHANTS HOSPITAL','PRIMARY', 200);


INSERT INTO staff_department_type(type_name) values ('MEDICAL');
INSERT INTO staff_department_type(type_name) values ('NONMEDICAL');

INSERT INTO certification(certification_name) values ('ISO-9011');
INSERT INTO certification(certification_name) values ('ISO-9012');

insert into staff_1(name, hire_date, designation, type_id) values ('dr A', TO_DATE('2019/10/26', 'yyyy/mm/dd'), 'Admin', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('dr B', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'vp', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('abc', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'office', 2);

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,1,TO_DATE('2019/10/26', 'yyyy/mm/dd'), TO_DATE('2029/10/25', 'yyyy/mm/dd'));

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,2,TO_DATE('2019/10/20', 'yyyy/mm/dd'), TO_DATE('2020/10/25', 'yyyy/mm/dd'));

insert into service_department(SERVICE_DEPT_CODE, NAME)
values ('GY-OB', 'GYNEC AND OBS');

insert into priority(type) values('HIGH');
insert into priority(type) values('NORMAL');
insert into priority(type) values('QUARANTINE');

execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','SHANTANU', 'SHARMA','2019/10/24',9193333333)
insert into symptom(SYMPTOM_CODE, SYMPTOM_NAME) values('sym01','cough');
insert into symptom(SYMPTOM_CODE, SYMPTOM_NAME) values('sym02','fever');
insert into symptom(SYMPTOM_CODE, SYMPTOM_NAME) values('sym03','headache');
