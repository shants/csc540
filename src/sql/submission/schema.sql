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

CREATE TABLE negative_experience(
neg_exp_id NUMBER(10) NOT NULL,
exp_name VARCHAR(150) NOT NULL,
CONSTRAINT negative_experience_key PRIMARY KEY(neg_exp_id)
);

CREATE SEQUENCE neg_exp_seq START WITH 1;

CREATE OR REPLACE TRIGGER neg_exp_trigger
BEFORE INSERT ON negative_experience
FOR EACH ROW
BEGIN
  SELECT  neg_exp_seq.NEXTVAL
  INTO   :new.neg_exp_id
  FROM   dual;
END;
/

/* create new patient_<facility_id> table and patient_address_<facility_id> */

CREATE OR REPLACE PROCEDURE create_new_patient_tables
AUTHID CURRENT_USER IS
new_query varchar2(5000);
BEGIN
new_query := 'CREATE TABLE patient_address(
patient_address_id NUMBER(10) NOT NULL,
street_num VARCHAR2(50) NOT NULL,
street_id NUMBER(10) NOT NULL,
city_id NUMBER(10) NOT NULL,
state_id NUMBER(10) NOT NULL,
country_id NUMBER(10) NOT NULL,
CONSTRAINT patient_address_key PRIMARY KEY (patient_address_id),
CONSTRAINT fk_pa_street FOREIGN KEY (street_id) REFERENCES street(street_id),
CONSTRAINT fk_pa_city FOREIGN KEY (city_id) REFERENCES city(city_id),
CONSTRAINT fk_pa_state FOREIGN KEY (state_id) REFERENCES state(state_id),
CONSTRAINT fk_pa_country FOREIGN KEY (country_id) REFERENCES country(country_id)
)';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE patient_address_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER patient_address_trigger
BEFORE INSERT ON patient_address
FOR EACH ROW
BEGIN
  SELECT patient_address_seq.NEXTVAL
  INTO   :new.patient_address_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE patient
                    (patient_id NUMBER(10) NOT NULL,
                     facility_id NUMBER(10) NOT NULL,
                    first_name VARCHAR2(30) NOT NULL,
                    last_name VARCHAR2(30) NOT NULL,
                    date_of_birth DATE NOT NULL,
                    phone_number NUMBER(10) NOT NULL,
                    patient_address_id NUMBER(30) NOT NULL,
                    CONSTRAINT patient_key PRIMARY KEY (patient_id),
                    CONSTRAINT fk_pt_pa FOREIGN KEY (patient_address_id) REFERENCES patient_address (patient_address_id),
                    CONSTRAINT fk_pt_fa FOREIGN KEY (facility_id) REFERENCES facility (facility_id))';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE patient_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER patient_trigger
BEFORE INSERT ON patient
FOR EACH ROW
BEGIN
  SELECT patient_seq.NEXTVAL
  INTO   :new.patient_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_patient_tables;
/

/* sign_up for patient */

CREATE OR REPLACE PROCEDURE sign_up_new_patient

(v_facility_id number, v_street_name varchar2, v_city_name varchar2,  v_state_name varchar2,
v_country_name varchar2, v_street_number varchar2, v_first_name varchar2, v_last_name varchar2,
v_date_of_birth varchar2, v_phone_number number)

AUTHID CURRENT_USER IS

new_query varchar2(5000);
v_street_id number;
v_city_id number;
v_state_id number;
v_country_id number;
v_patient_address_id number;
v_patient_id number;
BEGIN
new_query := 'INSERT INTO STREET(street_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STREET WHERE STREET_NAME = :b2)';
execute immediate new_query using v_street_name,v_street_name;
SELECT street_id into v_street_id from STREET where street_name = v_street_name;
DBMS_OUTPUT.PUT_LINE('Street_id:' || to_char(v_street_id));

new_query := 'INSERT INTO CITY(city_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM CITY WHERE CITY_NAME = :b2)';
execute immediate new_query using v_city_name,v_city_name;
SELECT city_id into v_city_id from CITY where city_name = v_city_name;
DBMS_OUTPUT.PUT_LINE('City_id:' || to_char(v_city_id));

new_query := 'INSERT INTO STATE(state_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STATE WHERE STATE_NAME = :b2)';
execute immediate new_query using v_state_name,v_state_name;
SELECT state_id into v_state_id from STATE where state_name = v_state_name;
DBMS_OUTPUT.PUT_LINE('State_id:' || to_char(v_state_id));

new_query := 'INSERT INTO COUNTRY(country_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM COUNTRY WHERE COUNTRY_NAME = :b2)';
execute immediate new_query using v_country_name,v_country_name;
SELECT country_id into v_country_id from COUNTRY where country_name = v_country_name;
DBMS_OUTPUT.PUT_LINE('Country_id:' || to_char(v_country_id));

new_query := 'INSERT INTO PATIENT_ADDRESS(street_num,street_id,city_id,state_id,country_id)
VALUES(:b1, :b2, :b3, :b4, :b5) returning patient_address_id into :b6';
execute immediate new_query using v_street_number, v_street_id, v_city_id, v_state_id, v_country_id returning into v_patient_address_id;
DBMS_OUTPUT.PUT_LINE('Patient_address_id:' || to_char(v_patient_address_id));

new_query := 'INSERT INTO PATIENT(first_name,last_name,date_of_birth,phone_number,patient_address_id, facility_id)
VALUES(:b1, :b2, :b3, :b4, :b5,:b6) returning patient_id into :b7';
execute immediate new_query using v_first_name, v_last_name, to_date(v_date_of_birth, 'yyyy/mm/dd'), v_phone_number, v_patient_address_id, v_facility_id returning into v_patient_id;
DBMS_OUTPUT.PUT_LINE('Patient_id:' || to_char(v_patient_id));

end sign_up_new_patient;
/

/*
exec sign_up_new_patient(1,'Baker Street','London', 'London', 'UK', '221B','Shantanu', 'Sharma','2019/10/24',9193333333)
*/

/* create table staff_<facility_id> */

CREATE OR REPLACE PROCEDURE create_new_staff_tables
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE staff(
staff_id NUMBER(10) NOT NULL,
facility_id NUMBER(10) NOT NULL,
name VARCHAR2(50) NOT NULL,
hire_date DATE,
type_id NUMBER(10) NOT NULL,
CONSTRAINT staff_facility_fk FOREIGN KEY (facility_id) REFERENCES facility(facility_id),
CONSTRAINT staff_id_key PRIMARY KEY (staff_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE staff_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER staff_trigger
BEFORE INSERT ON staff
FOR EACH ROW
BEGIN
  SELECT staff_seq.NEXTVAL
  INTO   :new.staff_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_staff_tables;
/

/* create staff_serv_dept_<facility_id> */

/*
oracle does not have bool, so use char(1)
*/

CREATE OR REPLACE PROCEDURE create_staff_serv_dept
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE staff_in_serv_dept(
service_dept_code VARCHAR2(20) NOT NULL,
staff_id NUMBER(10) NOT NULL,
is_primary char(1) NOT NULL,
CONSTRAINT staff_serv_dept_key PRIMARY KEY (service_dept_code,staff_id),
CONSTRAINT fk_staff_serv_dept FOREIGN KEY (staff_id) REFERENCES staff(staff_id),
CONSTRAINT fk_st_serv_dept FOREIGN KEY (service_dept_code) REFERENCES service_department(service_dept_code)
)';

EXECUTE IMMEDIATE new_query;
end create_staff_serv_dept;
/

/* create service_dept_<facility_id> */

CREATE OR REPLACE PROCEDURE create_facility_service_dept
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE fc_has_serv_dept(
service_dept_code VARCHAR2(20) NOT NULL,
facility_id NUMBER(10) NOT NULL,
director_id NUMBER(10) NOT NULL,
CONSTRAINT fc_serv_dept_key PRIMARY KEY (service_dept_code),
CONSTRAINT fk_fac_s_dep_fa FOREIGN KEY (facility_id) REFERENCES facility (facility_id),
CONSTRAINT fk_fc_dept_sd FOREIGN KEY (service_dept_code) REFERENCES service_department(service_dept_code),
CONSTRAINT fk_fc_dept_staff FOREIGN KEY (director_id) REFERENCES staff(staff_id)
)';

EXECUTE IMMEDIATE new_query;
end create_facility_service_dept;
/

/* create service_department_specification_<facility_id> */

CREATE OR REPLACE PROCEDURE new_serv_dept_spec
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE serv_dept_spec(
service_dept_code VARCHAR2(20) NOT NULL,
body_part_code VARCHAR2(20) NOT NULL,

CONSTRAINT new_serv_dept_spec_key PRIMARY KEY (service_dept_code, body_part_code),
CONSTRAINT fk_serv_dept_spec_ FOREIGN KEY (service_dept_code) REFERENCES fc_has_serv_dept(service_dept_code),
CONSTRAINT fk_body_part_code_ FOREIGN KEY(body_part_code) REFERENCES body_part(body_part_code))';

EXECUTE IMMEDIATE new_query;
end new_serv_dept_spec;
/

/* create new visit_<facility_id> table */

CREATE OR REPLACE PROCEDURE create_new_visit_tables
AUTHID CURRENT_USER IS
new_query varchar2(5000);
BEGIN
new_query := 'CREATE TABLE visit(
visit_id NUMBER(10) NOT NULL,
facility_id NUMBER(10) NOT NULL,
patient_id NUMBER(10) NOT NULL,
start_time TIMESTAMP NOT NULL,
end_time TIMESTAMP,
bp_low NUMBER(10),
bp_high NUMBER(10),
body_temperature NUMBER(10),
is_treated CHAR(1),
priority_id NUMBER(10),
CONSTRAINT visit_key PRIMARY KEY (visit_id),
CONSTRAINT fk_vis_fa FOREIGN KEY (facility_id) REFERENCES facility (facility_id),
CONSTRAINT fk_visit_priority_key FOREIGN KEY (priority_id) REFERENCES priority(priority_id) ON DELETE SET NULL)';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE visit_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER visit_trigger
BEFORE INSERT ON visit
FOR EACH ROW
BEGIN
  SELECT visit_seq.NEXTVAL
  INTO   :new.visit_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;

end create_new_visit_tables;
/


CREATE OR REPLACE PROCEDURE create_new_service
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE service(
service_code VARCHAR2(20) NOT NULL,
service_dept_code VARCHAR2(20) NOT NULL,
equipment VARCHAR2(35),
name VARCHAR2(30) NOT NULL,
CONSTRAINT pk_service_key PRIMARY KEY (service_code, service_dept_code),
CONSTRAINT fk_serv_sdept_key FOREIGN KEY (service_dept_code) REFERENCES fc_has_serv_dept(service_dept_code)
 )';

EXECUTE IMMEDIATE new_query;
end create_new_service;
/

/* create new facility entry and relevant address entries */

CREATE OR REPLACE PROCEDURE create_new_facility
(v_street_name varchar2, v_city_name varchar2,  v_state_name varchar2,  v_country_name varchar2,
v_street_number varchar2, v_name varchar2, v_classification varchar2, v_capacity number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);
v_street_id number;
v_classification_id number;
v_city_id number;
v_state_id number;
v_country_id number;
v_facility_address_id number;
v_facility_id number;

BEGIN
new_query := 'INSERT INTO STREET(street_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STREET WHERE STREET_NAME = :b2)';
execute immediate new_query using v_street_name,v_street_name;
SELECT street_id into v_street_id from STREET where street_name = v_street_name;
DBMS_OUTPUT.PUT_LINE('Street_id:' || to_char(v_street_id));

new_query := 'INSERT INTO CITY(city_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM CITY WHERE CITY_NAME = :b2)';
execute immediate new_query using v_city_name,v_city_name;
SELECT city_id into v_city_id from CITY where city_name = v_city_name;
DBMS_OUTPUT.PUT_LINE('City_id:' || to_char(v_city_id));

new_query := 'INSERT INTO STATE(state_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STATE WHERE STATE_NAME = :b2)';
execute immediate new_query using v_state_name,v_state_name;
SELECT state_id into v_state_id from STATE where state_name = v_state_name;
DBMS_OUTPUT.PUT_LINE('State_id:' || to_char(v_state_id));

new_query := 'INSERT INTO COUNTRY(country_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM COUNTRY WHERE COUNTRY_NAME = :b2)';
execute immediate new_query using v_country_name,v_country_name;
SELECT country_id into v_country_id from COUNTRY where country_name = v_country_name;
DBMS_OUTPUT.PUT_LINE('Country_id:' || to_char(v_country_id));

SELECT classification_id into v_classification_id from FACILITY_CLASSIFICATION where classification_type = v_classification;
DBMS_OUTPUT.PUT_LINE('Classification_id:' || to_char(v_classification_id));

INSERT INTO FACILITY_ADDRESS (street_num,street_id,city_id,state_id,country_id)
VALUES(v_street_name, v_street_id, v_city_id, v_state_id, v_country_id) returning facility_address_id into v_facility_address_id;
DBMS_OUTPUT.PUT_LINE('Facility_address_id:' || to_char(v_facility_address_id));

INSERT INTO FACILITY(facility_name,capacity,classification_id,facility_address_id)
VALUES(v_name, v_capacity, v_classification_id, v_facility_address_id) returning facility_id into v_facility_id;
DBMS_OUTPUT.PUT_LINE('Facility_id:' || to_char(v_facility_id));

end create_new_facility;
/

/*
exec create_new_facility('Baker Street','London', 'London', 'UK', '221B','SHANTS HOSPITAL', 'PRIMARY', 300)
*/


CREATE OR REPLACE PROCEDURE new_symptoms_table
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE symptom_severity(
symptom_severity_id NUMBER(10) NOT NULL,
type VARCHAR2(5) NOT NULL,
symptom_code VARCHAR2(20) NOT NULL,
staff_id NUMBER(10) NOT NULL,
CONSTRAINT symptom_severity_key PRIMARY KEY (symptom_severity_id),
CONSTRAINT fk_severity_staff_id FOREIGN KEY (staff_id) REFERENCES staff(staff_id),
CONSTRAINT fk_severity_symptom_code FOREIGN KEY(symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE sym_sev_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER sym_sev_trigger
BEFORE INSERT ON symptom_severity
FOR EACH ROW
BEGIN
  SELECT sym_sev_seq.NEXTVAL
  INTO   :new.symptom_severity_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;

new_query := 'CREATE TABLE severity_scale(
symptom_severity_id NUMBER(10) NOT NULL,
index_number NUMBER(10) NOT NULL,
value VARCHAR2(20) NOT NULL,
CONSTRAINT severity_scale_key PRIMARY KEY (symptom_severity_id, index_number),
CONSTRAINT fk_sev_scale_sym_sev_id FOREIGN KEY (symptom_severity_id) REFERENCES symptom_severity(symptom_severity_id))';

EXECUTE IMMEDIATE new_query;
end new_symptoms_table;
/

CREATE OR REPLACE PROCEDURE add_new_symptom
(sym_staff_id number, new_sym_name varchar2,
sym_body_part varchar2, sym_sev_type varchar2)

AUTHID CURRENT_USER IS
new_query varchar2(5000);
new_sym_code varchar2(20);
bp_code varchar2(20);

BEGIN
new_query := 'INSERT INTO SYMPTOM(symptom_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM SYMPTOM WHERE SYMPTOM_NAME = :b2)';
execute immediate new_query using new_sym_name, new_sym_name;
SELECT symptom_code into new_sym_code from SYMPTOM where symptom_name = new_sym_name;

new_query := 'INSERT INTO BODY_PART(name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM BODY_PART WHERE NAME = :b2)';
execute immediate new_query using sym_body_part, sym_body_part;
SELECT body_part_code into bp_code from BODY_PART where name = sym_body_part;

new_query := 'INSERT INTO SYMPTOM_BODY_PART(symptom_code, body_part_code)
VALUES(:b1, :b2)';
execute immediate new_query using new_sym_code, bp_code;

new_query := 'INSERT INTO SYMPTOM_SEVERITY(type, symptom_code, staff_id)
VALUES(:b1, :b2, :b3)';
execute immediate new_query using sym_sev_type, new_sym_code, sym_staff_id;

end add_new_symptom;
/

/* procedure for adding the severity scale */
CREATE OR REPLACE TYPE sev_scale_array AS VARRAY(100) OF VARCHAR2(40);
/

CREATE OR REPLACE PROCEDURE Add_severity_scale
(sc_staff_id number,
sc_sym_name varchar2, sev_scale_values sev_scale_array )

AS
new_query varchar2(5000);
sym_code varchar2(20);
sev_id number;

BEGIN
SELECT symptom_code into sym_code from SYMPTOM where symptom_name = sc_sym_name;
new_query := 'SELECT symptom_severity_id FROM SYMPTOM_SEVERITY WHERE SYMPTOM_CODE =:b2 AND STAFF_ID =:b3';
execute immediate new_query into sev_id using sym_code,sc_staff_id;
FOR i IN 1..sev_scale_values.COUNT
  LOOP
    new_query := 'INSERT INTO SEVERITY_SCALE(symptom_severity_id, index_number, value) VALUES(:b1, :b2, :b3)';
    execute immediate new_query using sev_id, i, sev_scale_values(i);
  END LOOP;
END Add_severity_scale;
/


CREATE OR REPLACE PROCEDURE new_patient_symptoms
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE patient_symptoms(
visit_id NUMBER(10) NOT NULL,
symptom_code VARCHAR2(20) NOT NULL,
severity_value VARCHAR2(20) NOT NULL,
post_event VARCHAR2(100),
is_recurring CHAR(1),
duration NUMBER(10),
CONSTRAINT patient_symptoms_key PRIMARY KEY (visit_id, symptom_code),
CONSTRAINT fk_pat_symptoms_visit_id FOREIGN KEY (visit_id) REFERENCES visit(visit_id),
CONSTRAINT fk_pat_sym_sym_code FOREIGN KEY (symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
end new_patient_symptoms;
/

CREATE OR REPLACE PROCEDURE new_rules_tables
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE rules_symptoms(
rule_id NUMBER(10) NOT NULL,
staff_id NUMBER(10) NOT NULL,
symptom_code VARCHAR2(20) NOT NULL,
CONSTRAINT rules_symptoms_key PRIMARY KEY (rule_id),
CONSTRAINT fk_rules_staff_id FOREIGN KEY (staff_id) REFERENCES staff(staff_id),
CONSTRAINT fk_rules_symptom_code FOREIGN KEY(symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE rules_symptoms_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER rules_symptoms_trigger
BEFORE INSERT ON rules_symptoms
FOR EACH ROW
BEGIN
  SELECT rules_symptoms_seq.NEXTVAL
  INTO   :new.rule_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE asses_rules(
rule_id NUMBER(10) NOT NULL,
asses_rule VARCHAR2(50) NOT NULL,
priority_id NUMBER(10) NOT NULL,
CONSTRAINT asses_rules_key PRIMARY KEY (rule_id, priority_id),
CONSTRAINT fk_ass_rules_rule_id FOREIGN KEY (rule_id) REFERENCES rules_symptoms(rule_id),
CONSTRAINT fk_ass_rules_priority FOREIGN KEY (priority_id) REFERENCES priority(priority_id) ON DELETE SET NULL)';
EXECUTE IMMEDIATE new_query;
end new_rules_tables;
/


/*service code is not added(as this table is not created ) in the */

CREATE OR REPLACE PROCEDURE create_new_report
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE report(
report_id NUMBER(10) NOT NULL,
neg_exp_id NUMBER(10) NOT NULL,
negative_experience_text VARCHAR2(100) NOT NULL,
treatment VARCHAR2(50) NOT NULL,
visit_id NUMBER(10) NOT NULL,
discharge_status VARCHAR2(50) NOT NULL,
CONSTRAINT report_id_key PRIMARY KEY (report_id),
CONSTRAINT fk_report_visit FOREIGN KEY (visit_id) REFERENCES visit(visit_id),
CONSTRAINT fk_report_neg_exp FOREIGN KEY (neg_exp_id) REFERENCES negative_experience(neg_exp_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE report_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER report_trigger
BEFORE INSERT ON report
FOR EACH ROW
BEGIN
  SELECT report_seq.NEXTVAL
  INTO   :new.report_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral(
report_id NUMBER(10) NOT NULL,
staff_id NUMBER(10) NOT NULL,
CONSTRAINT report_referral_key PRIMARY KEY (report_id,staff_id),
CONSTRAINT fk_report_ref_rep_id FOREIGN KEY (report_id ) REFERENCES report(report_id),
CONSTRAINT fk_report_ref_staff_id FOREIGN KEY(staff_id) REFERENCES staff(staff_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral_reason(
reason_id NUMBER(10) NOT NULL,
report_id NUMBER(10) NOT NULL,
reason_code NUMBER(10) NOT NULL,
reason_description VARCHAR2(100) NOT NULL,
service_code NUMBER(10) NOT NULL,
CONSTRAINT report_referral_reason_key PRIMARY KEY (report_id,reason_id),
CONSTRAINT fk_report_ref_res_rep_id FOREIGN KEY (report_id) REFERENCES report(report_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE rep_refer_rea_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER rep_refer_rea_trigger
BEFORE INSERT ON report_referral_reason
FOR EACH ROW
BEGIN
  SELECT rep_refer_rea_seq.NEXTVAL
  INTO   :new.reason_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_report;
/

