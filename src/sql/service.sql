/* create table service_<facility_id> */
/*
facilitiy_id, service_code,service_dept_code, equipment, name
@paaji  service_code ??
 */
CREATE OR REPLACE PROCEDURE create_new_service
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE service_'|| to_char(facility_id) || '(
service_code VARCHAR2(20) NOT NULL,
service_dept_code VARCHAR2(20) NOT NULL,
equipment VARCHAR2(30) NOT NULL,
name VARCHAR2(30) NOT NULL,
CONSTRAINT pk_service_'|| to_char(facility_id) || '_key PRIMARY KEY (service_code, service_dept_code),
CONSTRAINT fk_serv_servdept_'|| to_char(facility_id) || '_key FOREIGN KEY (service_dept_code) REFERENCES
fc_has_serv_dept_'|| to_char(facility_id) || '(service_dept_code)
 )';

EXECUTE IMMEDIATE new_query;
end create_new_service;
/