INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('PRIMARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('SECONDARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('TERTIARY');

INSERT INTO STREET(street_name) VALUES('Baker Street');
INSERT INTO CITY(city_name) VALUES('LONDON');
INSERT INTO STATE(state_name) VALUES('LONDON');
INSERT INTO COUNTRY(country_name) VALUES('UK');

execute create_new_facility('BAKER STREET','LONDON', 'LONDON', 'UK', '221B', 'SHANTS HOSPITAL','PRIMARY', 200);
execute create_new_facility('BAKER STREET','LONDON', 'LONDON', 'UK', '221B', 'SHANTS2 HOSPITAL','PRIMARY', 50);
execute create_new_facility('BAKER STREET','LONDON', 'LONDON', 'UK', '221B', 'SHANTS3 HOSPITAL','PRIMARY', 40);

execute create_new_patient_tables();
execute create_new_staff_tables();
execute create_new_visit_tables();
execute create_facility_service_dept();
execute create_staff_serv_dept();
execute new_serv_dept_spec();
execute create_new_service();
execute new_symptoms_table();
execute new_patient_symptoms();
execute new_rules_tables();
execute create_new_report();

INSERT INTO staff_department_type(type_name) values ('MEDICAL');
INSERT INTO staff_department_type(type_name) values ('NONMEDICAL');

INSERT INTO certification(certification_name) values ('ISO-9011');
INSERT INTO certification(certification_name) values ('ISO-9012');

insert into staff(name, hire_date, type_id, facility_id) values ('DR A', TO_DATE('2019/10/26', 'yyyy/mm/dd'),  1,1);
insert into staff(name, hire_date, type_id, facility_id) values ('DR B', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 1,1);
insert into staff(name, hire_date, type_id, facility_id) values ('ABC', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 2,1);

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,1,TO_DATE('2019/10/26', 'yyyy/mm/dd'), TO_DATE('2029/10/25', 'yyyy/mm/dd'));

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,2,TO_DATE('2019/10/20', 'yyyy/mm/dd'), TO_DATE('2020/10/25', 'yyyy/mm/dd'));

insert into service_department(SERVICE_DEPT_CODE, NAME)
values ('GY-OB', 'GYNEC AND OBS');

insert into priority(type) values('HIGH');
insert into priority(type) values('NORMAL');
insert into priority(type) values('QUARANTINE');

execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','SHANTANU', 'SHARMA','2019/10/24',9193333333);
execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','RAVINDERSINGH', 'RAJPAL','2019/10/24',9193333333);
execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','TAPAS', 'MALLICK','2019/10/24',9193333333);
execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','PARDHA', 'KESHWAR','2019/10/24',9193333333);

insert into symptom(SYMPTOM_NAME) values('COUGH');
insert into symptom(SYMPTOM_NAME) values('FEVER');
insert into symptom(SYMPTOM_NAME) values('HEADACHE');
insert into symptom(SYMPTOM_NAME) values('HEART ATTACK');
insert into symptom(SYMPTOM_NAME) values('GENERIC');

insert into body_part(name) values('NECK');
insert into body_part(name) values('HEAD');
insert into body_part(name) values('HAND');
insert into body_part(name) values('BODY');
insert into body_part(name) values('LEG');
insert into body_part(name) values('HEART');

insert into service_department(service_dept_code, name) values('CRDLY', 'CARDIOLOGY');
insert into service_department(service_dept_code, name) values('NRLY', 'NEUROLOGY');
insert into service_department(service_dept_code, name) values('PHCY', 'PHARMACY');
insert into service_department(service_dept_code, name) values('EMRCY', 'EMERGENCY');

insert into fc_has_serv_dept(facility_id, service_dept_code, director_id) values(1, 'CRDLY',1);
insert into fc_has_serv_dept(facility_id, service_dept_code, director_id) values(1, 'NRLY',1);
insert into fc_has_serv_dept(facility_id, service_dept_code, director_id) values(1, 'PHCY',3);
insert into fc_has_serv_dept(facility_id, service_dept_code, director_id) values(1, 'EMRCY',2);

insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('CRDLY', 1, 'Y');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('CRDLY', 2, 'N');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('NRLY', 1, 'N');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('NRLY', 2, 'Y');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('PHCY', 3, 'Y');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('EMRCY', 1, 'N');
insert into staff_in_serv_dept(service_dept_code,staff_id, is_primary) values('EMRCY', 2, 'Y');

insert into serv_dept_spec(service_dept_code, body_part_code) values('CRDLY','BP6');
insert into serv_dept_spec(service_dept_code, body_part_code) values('NRLY','BP2');

insert into service(service_code, service_dept_code, equipment, name) values('SR1','NRLY','MACHINE', 'CT_SCAN');
insert into service(service_code, service_dept_code, equipment, name) values('SR2','CRDLY','MACHINE', 'ECG');
insert into service(service_code, service_dept_code, equipment, name) values('SR3','EMRCY','WARD', 'WARD');

insert into symptom_body_part(symptom_code, body_part_code) values('SYM1','BP1');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM2','BP3');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM3','BP2');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM4','BP6');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM5','BP4');


insert into symptom_severity(type, symptom_code, staff_id) values('RANGE', 'SYM1', 1);
insert into symptom_severity(type, symptom_code, staff_id) values('ENUM', 'SYM2', 1);
insert into symptom_severity(type, symptom_code, staff_id) values('ENUM', 'SYM3', 2);

insert into severity_scale(symptom_severity_id,index_number,value) values(1,1,'1');
insert into severity_scale(symptom_severity_id,index_number,value) values(1,2,'2');
insert into severity_scale(symptom_severity_id,index_number,value) values(1,3,'3');
insert into severity_scale(symptom_severity_id,index_number,value) values(1,4,'4');
insert into severity_scale(symptom_severity_id,index_number,value) values(1,5,'5');
insert into severity_scale(symptom_severity_id,index_number,value) values(2,1,'LOW');
insert into severity_scale(symptom_severity_id,index_number,value) values(2,2,'MID');
insert into severity_scale(symptom_severity_id,index_number,value) values(2,3,'HIGH');
insert into severity_scale(symptom_severity_id,index_number,value) values(3,1,'LOW');
insert into severity_scale(symptom_severity_id,index_number,value) values(3,2,'MID');
insert into severity_scale(symptom_severity_id,index_number,value) values(3,3,'HIGH');

insert into visit(facility_id, patient_id, start_time) values(1, 1, to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI'));
insert into visit(facility_id, patient_id, start_time) values(1, 2, to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI'));
insert into visit(facility_id, patient_id, start_time) values(1, 3, to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI'));
insert into visit(facility_id, patient_id, start_time) values(1, 4, to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI'));

insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(1, 'SYM3', '2', 'POST EATING SWEETS', 'N', 2);
insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(1, 'SYM4', 'MID', 'POST EATING SWEETS', 'N', 2);

insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(2, 'SYM1', '2', 'POST EATING SWEETS', 'N', 2);
insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(2, 'SYM2', 'MID', 'POST EATING SWEETS', 'N', 2);

insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(3, 'SYM1', '2', 'POST EATING SWEETS', 'N', 2);
insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(3, 'SYM3', 'MID', 'POST EATING SWEETS', 'N', 2);

insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(4, 'SYM2', '2', 'POST EATING SWEETS', 'N', 2);
insert into patient_symptoms(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(4, 'SYM4', 'MID', 'POST EATING SWEETS', 'N', 2);

update visit set end_time = to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI') , bp_low = 80, bp_high = 160,
body_temperature  = 120, priority_id =  2 where visit_id = 1;

update visit set end_time = to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI') , bp_low = 80, bp_high = 160,
body_temperature  = 120, priority_id =  2, is_treated = 'Y' where visit_id = 2;

insert into negative_experience(exp_name) values('Misdiagnosis');
insert into negative_experience(exp_name) values('Acquired infection during stay');

insert into rules_symptoms(staff_id, symptom_code) values(1, 'SYM1');
insert into rules_symptoms(staff_id, symptom_code) values(1, 'SYM2');
insert into rules_symptoms(staff_id, symptom_code) values(1, 'SYM3');
insert into rules_symptoms(staff_id, symptom_code) values(1, 'SYM4');

insert into asses_rules(rule_id, asses_rule, priority_id) values(1,'Value greater than 3', 1);
insert into asses_rules(rule_id, asses_rule, priority_id) values(2,'Value is MID', 2);
insert into asses_rules(rule_id, asses_rule, priority_id) values(2,'Value is HIGH', 1);
insert into asses_rules(rule_id, asses_rule, priority_id) values(3,'Value is HIGH', 1);

insert into report(neg_exp_id, negative_experience_text, treatment, visit_id, discharge_status) values(1, 'demo neg exp text', 'demo treatment', 2, 'referred');
insert into report_referral(facility_id, report_id, staff_id) values(2,1,1);
insert into report_referral_reason(report_id, reason_code, reason_description, service_code) values(1, 1, 'SERVICE UNAVAILABLE', 'SR3');

/* last statement always*/
execute commit ;
