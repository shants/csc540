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