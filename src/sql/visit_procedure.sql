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
