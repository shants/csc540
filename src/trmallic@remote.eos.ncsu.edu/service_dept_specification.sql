/* create service_department_specification_<facility_id> */

CREATE OR REPLACE PROCEDURE new_serv_dept_spec
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE serv_dept_spec_'|| to_char(facility_id) || '(
service_dept_code VARCHAR2(20) NOT NULL,
body_part_code VARCHAR2(20) NOT NULL,

CONSTRAINT new_serv_dept_spec_'|| to_char(facility_id) || '_key PRIMARY KEY (service_dept_code, body_part_code),
CONSTRAINT fk_serv_dept_spec_'|| to_char(facility_id) || ' FOREIGN KEY (service_dept_code) REFERENCES fc_has_serv_dept_' || to_char(facility_id) || '(service_dept_code),
CONSTRAINT fk_body_part_code_' || to_char(facility_id) || ' FOREIGN KEY(body_part_code) REFERENCES body_part(body_part_code))';

EXECUTE IMMEDIATE new_query;
end new_serv_dept_spec;
/