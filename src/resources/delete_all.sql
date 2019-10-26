drop table facility_address cascade constraints;
drop table facility cascade constraints;
drop table facility_classification cascade constraints;
drop table street cascade constraints;
drop table city cascade constraints;
drop table state cascade constraints;
drop table country cascade constraints;
drop table certification cascade constraints;
drop table symptom cascade constraints;
drop table staff_department_type cascade constraints;
drop table staff cascade constraints;


drop sequence fc_cls_seq;
drop sequence street_seq;
drop sequence city_seq;
drop sequence state_seq;
drop sequence country_seq;
drop sequence certification_seq;
drop sequence facility_address_seq;
drop sequence facility_seq;
drop sequence staff_department_type_seq;

/*
BEGIN

  --Bye Sequences!
  FOR i IN (SELECT us.sequence_name
              FROM USER_SEQUENCES us) LOOP
    EXECUTE IMMEDIATE 'drop sequence '|| i.sequence_name ||'';
  END LOOP;

  --Bye Tables!
  FOR i IN (SELECT ut.table_name
              FROM USER_TABLES ut) LOOP
    EXECUTE IMMEDIATE 'drop table '|| i.table_name ||' CASCADE CONSTRAINTS ';
  END LOOP;

END;
/

*/