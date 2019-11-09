INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('PRIMARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('SECONDARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('TERTIARY');

INSERT INTO staff_department_type(type_name) values ('MEDICAL');
INSERT INTO staff_department_type(type_name) values ('NONMEDICAL');

insert into priority(type) values('HIGH');
insert into priority(type) values('NORMAL');
insert into priority(type) values('QUARANTINE');

insert into symptom(SYMPTOM_NAME) values('PAIN');
insert into symptom(SYMPTOM_NAME) values('DIARRHEA');
insert into symptom(SYMPTOM_NAME) values('FEVER');
insert into symptom(SYMPTOM_NAME) values('PHYSICAL EXAM');

-- Store codes as well, change the schema
insert into body_part(name) values('LEFT ARM');
insert into body_part(name) values('RIGHT ARM');
insert into body_part(name) values('ABDOMINAL');
insert into body_part(name) values('EYE');
insert into body_part(name) values('HEART');
insert into body_part(name) values('CHEST');
insert into body_part(name) values('HEAD');

-- will have new code for body part after above fix
insert into symptom_body_part(symptom_code, body_part_code) values('SYM2','BP3');

execute create_new_facility('WOLF VILLAGE WAY BOX 7220','RALEIGH', 'NC', 'US', '2650', 'WOLF HOSPITAL','TERTIARY', 300);
execute create_new_facility('SACRAMENTO','SANTA CRUZ', 'CA', 'US', '2500', 'CALIFORNIA HEALTHCARE','SECONDARY', 150);
execute create_new_facility('FIRST AVENUE 10001','NEW YORK', 'NEW YORK', 'US', '489', 'WOLF HOSPITAL','PRIMARY', 10);

insert into staff_1(name, hire_date, type_id) values ('MEDICAL ROBOT', TO_DATE('2019/06/21', 'yyyy/mm/dd'), 1);
insert into staff_1(name, hire_date, type_id) values ('MUSCULAR ROB', TO_DATE('1983/10/12', 'yyyy/mm/dd'), 1);
insert into staff_1(name, hire_date, type_id) values ('MECHANICAL ROBOTO', TO_DATE('2019/06/21', 'yyyy/mm/dd'), 1);
insert into staff_1(name, hire_date, type_id) values ('MISCELLANEOUS ROBOTOR', TO_DATE('2014/08/19', 'yyyy/mm/dd'), 2);
insert into staff_1(name, hire_date, type_id) values ('MUSICIAN ROOT', TO_DATE('2017/10/18', 'yyyy/mm/dd'), 2);
insert into staff_2(name, hire_date, type_id) values ('MUSICAL ROBERT', TO_DATE('2018/08/29', 'yyyy/mm/dd'), 1);
insert into staff_2(name, hire_date, type_id) values ('MILLENNIUM ROBERTEN', TO_DATE('2018/09/20', 'yyyy/mm/dd'), 1);
insert into staff_2(name, hire_date, type_id) values ('MISSIONARY ROBINSON', TO_DATE('1993/10/01', 'yyyy/mm/dd'), 1);
insert into staff_3(name, hire_date, type_id) values ('MASSAGING ROBIN', TO_DATE('1990/12/10', 'yyyy/mm/dd'), 1);

INSERT INTO certification(certification_name) values ('COMPREHENSIVE STROKE CERTIFICATION');
INSERT INTO certification(certification_name) values ('ISO CERTIFICATION');
INSERT INTO certification(certification_name) values ('PRIMARY STROKE CERTIFICATION');

insert into service_department(service_dept_code, name) values('ER000', 'EMERGENCY ROOM');
insert into service_department(service_dept_code, name) values('GP000', 'GENERAL PRATICE DEPARTMENT');
insert into service_department(service_dept_code, name) values('GP001', 'GENERAL PRATICE DEPARTMENT');
insert into service_department(service_dept_code, name) values('OP000', 'OPTOMETRY');
insert into service_department(service_dept_code, name) values('SE000', 'SECURITY');

-- ER001 missing director and department
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('GP000',2);
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('OP000',1);
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('SE000',4);
insert into fc_has_serv_dept_2(service_dept_code, director_id) values('ER000',1);
insert into fc_has_serv_dept_2(service_dept_code, director_id) values('GP001',2);

insert into serv_dept_spec_1(service_dept_code, body_part_code) values('OP000','BP4');

