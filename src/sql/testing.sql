/* create new visit_<facility_id> table */

CREATE OR REPLACE PROCEDURE create_new_visit
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);
BEGIN
new_query := 'CREATE TABLE visit_'|| to_char(facility_id) || '(
visit_id NUMBER(10) NOT NULL,
patient_id NUMBER(10) NOT NULL,
start_time DATE,
end_time DATE,
bp_low NUMBER(10) NOT NULL,
bp_high NUMBER(10) NOT NULL,
body_temperature NUMBER(10) NOT NULL,
priority_id NUMBER(10),
CONSTRAINT visit_'|| to_char(facility_id) || '_key PRIMARY KEY (visit_id),
CONSTRAINT fk_visit_priority_'|| to_char(facility_id) || ' FOREIGN KEY (priority_id) REFERENCES priority(priority_id) ON DELETE SET NULL)';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE visit_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER visit_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON visit_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT visit_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.visit_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;

end create_new_visit;
/
