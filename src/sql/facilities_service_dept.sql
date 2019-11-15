/* create service_dept_<facility_id> */

CREATE OR REPLACE PROCEDURE create_facility_service_dept
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE fc_has_serv_dept(
service_dept_code VARCHAR2(20) NOT NULL,
facility_id NUMBER(10) NOT NULL,
director_id NUMBER(10) NOT NULL,
CONSTRAINT fc_serv_dept_key PRIMARY KEY (service_dept_code),
CONSTRAINT fk_fac_s_dep_fa FOREIGN KEY (facility_id) REFERENCES facility (facility_id),
CONSTRAINT fk_fc_dept_sd FOREIGN KEY (service_dept_code) REFERENCES service_department(service_dept_code),
CONSTRAINT fk_fc_dept_staff FOREIGN KEY (director_id) REFERENCES staff(staff_id)
)';

EXECUTE IMMEDIATE new_query;
end create_facility_service_dept;
/