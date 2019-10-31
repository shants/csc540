/*create rules_symptoms_<facility_id>*/

CREATE OR REPLACE PROCEDURE new_rules_tables
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE rules_symptoms_' || to_char(facility_id) || '(
rule_id NUMBER(10) NOT NULL,
staff_id NUMBER(10) NOT NULL,
symptom_code NUMBER(10) NOT NULL,
CONSTRAINT rules_symptoms_'||to_char(facility_id)||'_key PRIMARY KEY (rule_id),
CONSTRAINT fk_rules_staff_id_'|| to_char(facility_id) ||' FOREIGN KEY (staff_id) REFERENCES staff_'|| to_char(facility_id) ||'(staff_id),
CONSTRAINT fk_rules_symptom_code FOREIGN KEY(symptom_code) REFERENCES symptom (symptom_code))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE rules_symptoms_'|| to_char(facility_id) ||'_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER rules_symptoms_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON rules_symptoms_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT rules_symptoms_'|| to_char(facility_id) ||'_seq.NEXTVAL
  INTO   :new.rule_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE asses_rules'|| to_char(facility_id) || '(
rule_id NUMBER(10) NOT NULL,
asses_rule VARCHAR2(50) NOT NULL,
priority_id NUMBER(10) NOT NULL,
CONSTRAINT asses_rules_'||to_char(facility_id)||'_key PRIMARY KEY (rule_id),
CONSTRAINT fk_ass_rules_rule_id_'||to_char(facility_id)||' FOREIGN KEY (rule_id) REFERENCES rules_symptoms_'||to_char(facility_id)||'(rule_id),
CONSTRAINT fk_ass_rules_priority_'|| to_char(facility_id) || ' FOREIGN KEY (priority_id) REFERENCES priority(priority_id) ON DELETE SET NULL)';
EXECUTE IMMEDIATE new_query;
end new_rules_tables;
/