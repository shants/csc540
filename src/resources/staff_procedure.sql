/* create table staff_<facility_id> */

CREATE OR REPLACE PROCEDURE create_new_staff_tables
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE staff_'|| to_char(facility_id) || '(
staff_id NUMBER(10) NOT NULL,
name VARCHAR2(50) NOT NULL,
hire_date DATE,
designation VARCHAR2(50) NOT NULL,
type_id NUMBER(10) NOT NULL,
CONSTRAINT staff_id_'|| to_char(facility_id) || '_key PRIMARY KEY (staff_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE staff_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER staff_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON staff_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT staff_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.staff_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_staff_tables;
/