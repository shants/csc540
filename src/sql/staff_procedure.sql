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