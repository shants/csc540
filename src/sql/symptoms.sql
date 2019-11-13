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
CONSTRAINT fk_severity_symptom_code_'|| to_char(facility_id) || ' FOREIGN KEY(symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE sym_sev_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER sym_sev_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON symptom_severity_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT sym_sev_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.symptom_severity_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;

new_query := 'CREATE TABLE severity_scale_'|| to_char(facility_id) || '(
symptom_severity_id NUMBER(10) NOT NULL,
index_number NUMBER(10) NOT NULL,
value VARCHAR2(20) NOT NULL,
CONSTRAINT severity_scale_'||to_char(facility_id)||'_key PRIMARY KEY (symptom_severity_id, index_number),
CONSTRAINT fk_sev_scale_sym_sev_id_'||to_char(facility_id)||' FOREIGN KEY (symptom_severity_id) REFERENCES symptom_severity_'||to_char(facility_id)||'(symptom_severity_id))';

EXECUTE IMMEDIATE new_query;
end new_symptoms_table;
/

CREATE OR REPLACE PROCEDURE add_new_symptom
(sym_facility_id number, sym_staff_id number, new_sym_name varchar2,
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

new_query := 'INSERT INTO SYMPTOM_SEVERITY_'|| to_char(sym_facility_id) ||' (type, symptom_code, staff_id)
VALUES(:b1, :b2, :b3)';
execute immediate new_query using sym_sev_type, new_sym_code, sym_staff_id;

end add_new_symptom;
/

/* procedure for adding the severity scale */
CREATE OR REPLACE TYPE sev_scale_array AS VARRAY(100) OF VARCHAR2(40);
/

CREATE OR REPLACE PROCEDURE Add_severity_scale
(sc_facility_id number, sc_staff_id number,
sc_sym_name varchar2, sev_scale_values sev_scale_array )

AS
new_query varchar2(5000);
sym_code varchar2(20);
sev_id number;

BEGIN
SELECT symptom_code into sym_code from SYMPTOM where symptom_name = sc_sym_name;
new_query := 'SELECT symptom_severity_id FROM SYMPTOM_SEVERITY_'||to_char(sc_facility_id)||
' WHERE SYMPTOM_CODE =:b2 AND STAFF_ID =:b3';
execute immediate new_query into sev_id using sym_code,sc_staff_id;
FOR i IN 1..sev_scale_values.COUNT
  LOOP
    new_query := 'INSERT INTO SEVERITY_SCALE_'||to_char(sc_facility_id)||'(symptom_severity_id, index_number, value) VALUES(:b1, :b2, :b3)';
    execute immediate new_query using sev_id, i, sev_scale_values(i);
  END LOOP;
END Add_severity_scale;
/
