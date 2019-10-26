/* create new patient_<facility_id> table and patient_address_<facility_id> */

CREATE OR REPLACE PROCEDURE create_new_patient_tables
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);
BEGIN
new_query := 'CREATE TABLE patient_address_'|| to_char(facility_id) || '(
patient_address_id NUMBER(10) NOT NULL,
street_num VARCHAR2(50) NOT NULL,
street_id NUMBER(10) NOT NULL,
city_id NUMBER(10) NOT NULL,
state_id NUMBER(10) NOT NULL,
country_id NUMBER(10) NOT NULL,
patient_id NUMBER(10) NOT NULL,
CONSTRAINT patient_address_'|| to_char(facility_id) || '_key PRIMARY KEY (patient_address_id),
CONSTRAINT fk_pa_street_'|| to_char(facility_id) || ' FOREIGN KEY (street_id) REFERENCES street(street_id),
CONSTRAINT fk_pa_city_'|| to_char(facility_id) || ' FOREIGN KEY (city_id) REFERENCES city(city_id),
CONSTRAINT fk_pa_state_'|| to_char(facility_id) || ' FOREIGN KEY (state_id) REFERENCES state(state_id),
CONSTRAINT fk_pa_country_'|| to_char(facility_id) || ' FOREIGN KEY (country_id) REFERENCES country(country_id)
)';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE patient_address_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER patient_address_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON patient_address_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT patient_address_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.patient_address_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE patient_'|| to_char(facility_id) ||
                    ' (patient_id NUMBER(10) NOT NULL, ' ||
                    ' first_name VARCHAR2(30) NOT NULL, ' ||
                    ' last_name VARCHAR2(30) NOT NULL, ' ||
                    ' date_of_birth DATE NOT NULL, ' ||
                    ' phone_number NUMBER(10) NOT NULL, ' ||
                    ' patient_address_id NUMBER(30) NOT NULL, ' ||
                    'CONSTRAINT patient_'|| to_char(facility_id) || '_key PRIMARY KEY (patient_id),' ||
                    ' CONSTRAINT fk_pt_pa_'|| to_char(facility_id) || ' FOREIGN KEY (patient_address_id) REFERENCES patient_address_'
                    || to_char(facility_id) || ' (patient_address_id))';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE patient_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER patient_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON patient_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT patient_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.patient_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
new_query := 'ALTER TABLE patient_address_'|| to_char(facility_id) || ' ADD (
CONSTRAINT fk_pa_p_'|| to_char(facility_id) || ' FOREIGN KEY (patient_id) REFERENCES patient_'|| to_char(facility_id) || '(patient_id)) ON DELETE CASCADE';
EXECUTE IMMEDIATE new_query;
end create_new_patient_tables;
/