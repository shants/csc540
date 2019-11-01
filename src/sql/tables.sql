CREATE TABLE facility_classification(
classification_id NUMBER(10) NOT NULL,
classification_type VARCHAR2(50) NOT NULL);

ALTER TABLE facility_classification ADD (
CONSTRAINT classification_key PRIMARY KEY(classification_id));

CREATE SEQUENCE fc_cls_seq START WITH 1;

CREATE OR REPLACE TRIGGER classification_trigger
BEFORE INSERT ON FACILITY_CLASSIFICATION
FOR EACH ROW
BEGIN
  SELECT fc_cls_seq.NEXTVAL
  INTO   :new.classification_id
  FROM   dual;
END;
/

CREATE TABLE street(
street_id NUMBER(10) NOT NULL,
street_name VARCHAR2(50) NOT NULL);

ALTER TABLE street ADD (
CONSTRAINT street_key PRIMARY KEY(street_id));

CREATE SEQUENCE street_seq START WITH 1;

CREATE OR REPLACE TRIGGER street_trigger
BEFORE INSERT ON street
FOR EACH ROW

BEGIN
  SELECT street_seq.NEXTVAL
  INTO   :new.street_id
  FROM   dual;
END;
/

CREATE TABLE city(
city_id NUMBER(10) NOT NULL,
city_name VARCHAR2(50) NOT NULL);

ALTER TABLE city ADD (
CONSTRAINT city_key PRIMARY KEY(city_id));

CREATE SEQUENCE city_seq START WITH 1;

CREATE OR REPLACE TRIGGER city_trigger
BEFORE INSERT ON city
FOR EACH ROW

BEGIN
  SELECT city_seq.NEXTVAL
  INTO   :new.city_id
  FROM   dual;
END;
/

CREATE TABLE state(
state_id NUMBER(10) NOT NULL,
state_name VARCHAR2(50) NOT NULL);

ALTER TABLE state ADD (
CONSTRAINT state_key PRIMARY KEY(state_id));

CREATE SEQUENCE state_seq START WITH 1;

CREATE OR REPLACE TRIGGER state_trigger
BEFORE INSERT ON state
FOR EACH ROW

BEGIN
  SELECT state_seq.NEXTVAL
  INTO   :new.state_id
  FROM   dual;
END;
/

CREATE TABLE country(
country_id NUMBER(10) NOT NULL,
country_name VARCHAR2(50) NOT NULL);

ALTER TABLE country ADD (
CONSTRAINT country_key PRIMARY KEY(country_id));

CREATE SEQUENCE country_seq START WITH 1;

CREATE OR REPLACE TRIGGER country_trigger
BEFORE INSERT ON country
FOR EACH ROW

BEGIN
  SELECT country_seq.NEXTVAL
  INTO   :new.country_id
  FROM   dual;
END;
/

CREATE TABLE certification(
certification_id NUMBER(10) NOT NULL,
certification_name VARCHAR2(50) NOT NULL);

ALTER TABLE certification ADD (
CONSTRAINT certification_key PRIMARY KEY(certification_id));

CREATE SEQUENCE certification_seq START WITH 1;

CREATE OR REPLACE TRIGGER certification_trigger
BEFORE INSERT ON certification
FOR EACH ROW

BEGIN
  SELECT certification_seq.NEXTVAL
  INTO   :new.certification_id
  FROM   dual;
END;
/

CREATE TABLE facility_address(
facility_address_id NUMBER(10) NOT NULL,
street_num VARCHAR2(50) NOT NULL,
street_id NUMBER(10) NOT NULL,
city_id NUMBER(10) NOT NULL,
state_id NUMBER(10) NOT NULL,
country_id NUMBER(10) NOT NULL,
CONSTRAINT facility_address_key PRIMARY KEY (facility_address_id),
CONSTRAINT fk_fa_street FOREIGN KEY (street_id) REFERENCES street(street_id),
CONSTRAINT fk_fa_city FOREIGN KEY (city_id) REFERENCES city(city_id),
CONSTRAINT fk_fa_state FOREIGN KEY (state_id) REFERENCES state(state_id),
CONSTRAINT fk_fa_country FOREIGN KEY (country_id) REFERENCES country(country_id)
);

CREATE SEQUENCE facility_address_seq START WITH 1;

CREATE OR REPLACE TRIGGER facility_address_trigger
BEFORE INSERT ON facility_address
FOR EACH ROW

BEGIN
  SELECT facility_address_seq.NEXTVAL
  INTO   :new.facility_address_id
  FROM   dual;
END;
/

CREATE TABLE facility(
facility_id NUMBER(10) NOT NULL,
facility_name VARCHAR2(50) NOT NULL,
capacity NUMBER(20) NOT NULL,
classification_id NUMBER(10) NOT NULL,
facility_address_id NUMBER (10) NOT NULL,
CONSTRAINT facility_key PRIMARY KEY (facility_id),
CONSTRAINT fk_f_cs FOREIGN KEY (classification_id) REFERENCES facility_classification(classification_id),
CONSTRAINT fk_f_fa FOREIGN KEY (facility_address_id) REFERENCES facility_address(facility_address_id)
);

CREATE SEQUENCE facility_seq START WITH 1;

CREATE OR REPLACE TRIGGER facility_trigger
BEFORE INSERT ON facility
FOR EACH ROW

BEGIN
  SELECT facility_seq.NEXTVAL
  INTO   :new.facility_id
  FROM   dual;
END;
/

CREATE TABLE symptom(
symptom_code VARCHAR2(20) NOT NULL,
symptom_name VARCHAR2(50) NOT NULL
);
ALTER TABLE symptom ADD (
CONSTRAINT symptom_key PRIMARY KEY(symptom_code));

CREATE SEQUENCE symptom_seq START WITH 1;

CREATE OR REPLACE TRIGGER symptom_trigger
BEFORE INSERT ON SYMPTOM
FOR EACH ROW
BEGIN
  SELECT  'SYM' || to_char(symptom_seq.NEXTVAL)
  INTO   :new.symptom_code
  FROM   dual;
END;
/

CREATE TABLE staff_department_type(
type_id NUMBER(10) NOT NULL,
type_name VARCHAR2(50) NOT NULL
);

ALTER TABLE staff_department_type ADD (
CONSTRAINT staff_department_type_key PRIMARY KEY(type_id))

CREATE SEQUENCE staff_department_type_seq START WITH 1;

CREATE OR REPLACE TRIGGER staff_department_type_trigger
BEFORE INSERT ON staff_department_type
FOR EACH ROW
BEGIN
  SELECT staff_department_type_seq.NEXTVAL
  INTO   :new.type_id
  FROM   dual;
END;
/

/*
create facility_certification table
*/


CREATE TABLE facility_certificates(
facility_id NUMBER(10) NOT NULL,
certification_id NUMBER(10) NOT NULL,
start_date DATE NOT NULL ,
end_date DATE NOT NULL
);
ALTER TABLE facility_certificates ADD (
CONSTRAINT facility_certification_key PRIMARY KEY(facility_id, certification_id),
CONSTRAINT fk_fac_cert_facility_id FOREIGN KEY (facility_id) REFERENCES facility(facility_id),
CONSTRAINT fk_fac_cert_certification_id FOREIGN KEY (certification_id)
REFERENCES certification(certification_id));

/* create service_department */

CREATE TABLE service_department(
service_dept_code VARCHAR2(10) NOT NULL,
name VARCHAR2(50) NOT NULL
);

ALTER TABLE service_department ADD (
CONSTRAINT service_dept_key PRIMARY KEY(service_dept_code));

/* create priority */

CREATE TABLE priority(
priority_id NUMBER(5) NOT NULL,
type VARCHAR2(50) NOT NULL,
CONSTRAINT priority_key PRIMARY KEY (priority_id));

CREATE SEQUENCE priority_seq START WITH 1;

CREATE OR REPLACE TRIGGER priority_trigger
BEFORE INSERT ON PRIORITY
FOR EACH ROW
BEGIN
  SELECT priority_seq.NEXTVAL
  INTO   :new.priority_id
  FROM   dual;
END;
/

/* body part */
CREATE TABLE body_part(
body_part_code VARCHAR2(20) NOT NULL,
name VARCHAR2(50)
);

ALTER TABLE body_part ADD (
CONSTRAINT body_part_key PRIMARY KEY(body_part_code));

CREATE SEQUENCE bp_seq START WITH 1;

CREATE OR REPLACE TRIGGER bp_trigger
BEFORE INSERT ON BODY_PART
FOR EACH ROW
BEGIN
  SELECT  'BP' || to_char(bp_seq.NEXTVAL)
  INTO   :new.body_part_code
  FROM   dual;
END;
/

CREATE TABLE symptom_body_part(
symptom_code VARCHAR2(20) NOT NULL,
body_part_code VARCHAR2(10) NOT NULL,
CONSTRAINT symptom_body_part_key PRIMARY KEY(symptom_code,body_part_code),
CONSTRAINT fk_symp_bp_1_key FOREIGN KEY (symptom_code) REFERENCES symptom(symptom_code),
CONSTRAINT fk_symp_bp_2_key FOREIGN KEY (body_part_code) REFERENCES body_part(body_part_code)
);

