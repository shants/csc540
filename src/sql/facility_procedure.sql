/* create new facility entry and relevant address entries */

CREATE OR REPLACE PROCEDURE create_new_facility
(v_street_name varchar2, v_city_name varchar2,  v_state_name varchar2,  v_country_name varchar2,
v_street_number varchar2, v_name varchar2, v_classification varchar2, v_capacity number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);
v_street_id number;
v_classification_id number;
v_city_id number;
v_state_id number;
v_country_id number;
v_facility_address_id number;
v_facility_id number;

BEGIN
new_query := 'INSERT INTO STREET(street_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STREET WHERE STREET_NAME = :b2)';
execute immediate new_query using v_street_name,v_street_name;
SELECT street_id into v_street_id from STREET where street_name = v_street_name;
DBMS_OUTPUT.PUT_LINE('Street_id:' || to_char(v_street_id));

new_query := 'INSERT INTO CITY(city_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM CITY WHERE CITY_NAME = :b2)';
execute immediate new_query using v_city_name,v_city_name;
SELECT city_id into v_city_id from CITY where city_name = v_city_name;
DBMS_OUTPUT.PUT_LINE('City_id:' || to_char(v_city_id));

new_query := 'INSERT INTO STATE(state_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM STATE WHERE STATE_NAME = :b2)';
execute immediate new_query using v_state_name,v_state_name;
SELECT state_id into v_state_id from STATE where state_name = v_state_name;
DBMS_OUTPUT.PUT_LINE('State_id:' || to_char(v_state_id));

new_query := 'INSERT INTO COUNTRY(country_name) SELECT :b1 FROM DUAL WHERE NOT EXISTS(SELECT * FROM COUNTRY WHERE COUNTRY_NAME = :b2)';
execute immediate new_query using v_country_name,v_country_name;
SELECT country_id into v_country_id from COUNTRY where country_name = v_country_name;
DBMS_OUTPUT.PUT_LINE('Country_id:' || to_char(v_country_id));

SELECT classification_id into v_classification_id from FACILITY_CLASSIFICATION where classification_type = v_classification;
DBMS_OUTPUT.PUT_LINE('Classification_id:' || to_char(v_classification_id));

INSERT INTO FACILITY_ADDRESS (street_num,street_id,city_id,state_id,country_id)
VALUES(v_street_name, v_street_id, v_city_id, v_state_id, v_country_id) returning facility_address_id into v_facility_address_id;
DBMS_OUTPUT.PUT_LINE('Facility_address_id:' || to_char(v_facility_address_id));

INSERT INTO FACILITY(facility_name,capacity,classification_id,facility_address_id)
VALUES(v_name, v_capacity, v_classification_id, v_facility_address_id) returning facility_id into v_facility_id;
DBMS_OUTPUT.PUT_LINE('Facility_id:' || to_char(v_facility_id));

end create_new_facility;
/

/*
exec create_new_facility('Baker Street','London', 'London', 'UK', '221B','SHANTS HOSPITAL', 'PRIMARY', 300)
*/
