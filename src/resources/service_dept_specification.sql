/* create service_department_sepcification_<facility_id> */

CREATE OR REPLACE PROCEDURE new_serv_dept_spec
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE serv_dept_spec_'|| to_char(facility_id) || '(
fc_serv_dept_id NUMBER(10) NOT NULL,
body_part_code VARCHAR2(5) NOT NULL,

CONSTRAINT new_serv_dept_spec_'|| to_char(facility_id) || '_key PRIMARY KEY (fc_serv_dept_id, body_part_code),
CONSTRAINT fk_serv_dept_spec_'|| to_char(facility_id) || ' FOREIGN KEY (fc_serv_dept_id ) REFERENCES fc_serv_dept_' || to_char(facility_id) || '(fc_serv_dept_id),
CONSTRAINT fk_body_part_code_' || to_char(facility_id) || ' FOREIGN KEY(body_part_code) REFERENCES body_part(body_part_code))';

EXECUTE IMMEDIATE new_query;
end new_serv_dept_spec;
/