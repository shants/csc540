CREATE OR REPLACE PROCEDURE new_symptoms_table
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE symptom_severity_'|| to_char(facility_id) || '(
symptom_severity_id NUMBER(10) NOT NULL,
type VARCHAR2(5) NOT NULL,
symptom_code VARCHAR2(20) NOT NULL,
staff_id NUMBER(10) NOT NULL,
CONSTRAINT symptom_severity_'||to_char(facility_id)||'_key PRIMARY KEY (symptom_severity_id),
CONSTRAINT fk_severity_staff_id_'|| to_char(facility_id) || ' FOREIGN KEY (staff_id) REFERENCES staff_'|| to_char(facility_id) ||' (staff_id),
CONSTRAINT fk_severity_symptom_code FOREIGN KEY(symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE severity_scale_'|| to_char(facility_id) || '(
symptom_severity_id NUMBER(10) NOT NULL,
index_number NUMBER(10) NOT NULL,
value NUMBER(10) NOT NULL,
CONSTRAINT severity_scale_'||to_char(facility_id)||'_key PRIMARY KEY (symptom_severity_id, index_number),
CONSTRAINT fk_sev_scale_sym_sev_id_'||to_char(facility_id)||' FOREIGN KEY (symptom_severity_id) REFERENCES symptom_severity_'||to_char(facility_id)||'(symptom_severity_id))';


EXECUTE IMMEDIATE new_query;
end new_symptoms_table;
/