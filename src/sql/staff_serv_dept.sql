/* create staff_serv_dept_<facility_id> */

/*
oracle does not have bool, so use char(1)
*/

CREATE OR REPLACE PROCEDURE create_staff_serv_dept
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE staff_in_serv_dept_'|| to_char(facility_id) || '(
service_dept_code VARCHAR2(20) NOT NULL,
staff_id NUMBER(10) NOT NULL,
is_primary char(1) NOT NULL,
CONSTRAINT staff_serv_dept_'|| to_char(facility_id) || '_key PRIMARY KEY (service_dept_code,staff_id),
CONSTRAINT fk_staff_serv_dept_'|| to_char(facility_id) || ' FOREIGN KEY (staff_id) REFERENCES staff_' || to_char(facility_id) || '(staff_id),
CONSTRAINT fk_st_serv_dept_'|| to_char(facility_id) || ' FOREIGN KEY (service_dept_code) REFERENCES service_department(service_dept_code)
)';

EXECUTE IMMEDIATE new_query;
end create_staff_serv_dept;
/