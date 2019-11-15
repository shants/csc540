/* create service_department_specification_<facility_id> */

CREATE OR REPLACE PROCEDURE new_serv_dept_spec
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE serv_dept_spec(
service_dept_code VARCHAR2(20) NOT NULL,
body_part_code VARCHAR2(20) NOT NULL,

CONSTRAINT new_serv_dept_spec_key PRIMARY KEY (service_dept_code, body_part_code),
CONSTRAINT fk_serv_dept_spec_ FOREIGN KEY (service_dept_code) REFERENCES fc_has_serv_dept(service_dept_code),
CONSTRAINT fk_body_part_code_ FOREIGN KEY(body_part_code) REFERENCES body_part(body_part_code))';

EXECUTE IMMEDIATE new_query;
end new_serv_dept_spec;
/