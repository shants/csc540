/* create service_dept_<facility_id> */

CREATE OR REPLACE PROCEDURE create_facility_service_dept
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE fc_has_serv_dept_'|| to_char(facility_id) || '(
service_dept_code VARCHAR2(20) NOT NULL,
director_id NUMBER(10) NOT NULL,
CONSTRAINT fc_serv_dept_'|| to_char(facility_id) || '_key PRIMARY KEY (service_dept_code),
CONSTRAINT fk_fc_dept_sd'|| to_char(facility_id) || ' FOREIGN KEY (service_dept_code) REFERENCES service_department(service_dept_code),
CONSTRAINT fk_fc_dept_staff'|| to_char(facility_id) || ' FOREIGN KEY (director_id) REFERENCES staff_' || to_char(facility_id) || '(staff_id)
)';

EXECUTE IMMEDIATE new_query;
--new_query := 'CREATE SEQUENCE fc_serv_dept_'|| to_char(facility_id) || '_seq START WITH 1';
--EXECUTE IMMEDIATE new_query;
--new_query := 'CREATE OR REPLACE TRIGGER fc_serv_dept_'|| to_char(facility_id) || '_trigger
--BEFORE INSERT ON fc_serv_dept_'|| to_char(facility_id) || '
--FOR EACH ROW
--BEGIN
--  SELECT fc_serv_dept_'|| to_char(facility_id) || '_seq.NEXTVAL
--  INTO   :new.fc_serv_dept_id
--  FROM   dual;
--END;';
--EXECUTE IMMEDIATE new_query;
end create_facility_service_dept;
/