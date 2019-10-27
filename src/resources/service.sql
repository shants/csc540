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

 )';

EXECUTE IMMEDIATE new_query;
end create_new_staff_tables;
/