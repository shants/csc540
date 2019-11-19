CREATE OR REPLACE PROCEDURE create_new_service
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE service(
service_code VARCHAR2(20) NOT NULL,
service_dept_code VARCHAR2(20) NOT NULL,
equipment VARCHAR2(40),
name VARCHAR2(30) NOT NULL,
CONSTRAINT pk_service_key PRIMARY KEY (service_code, service_dept_code),
CONSTRAINT fk_serv_sdept_key FOREIGN KEY (service_dept_code) REFERENCES fc_has_serv_dept(service_dept_code)
 )';

EXECUTE IMMEDIATE new_query;
end create_new_service;
/