INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('PRIMARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('SECONDARY');
INSERT INTO FACILITY_CLASSIFICATION(classification_type) VALUES('TERTIARY');

INSERT INTO STREET(street_name) VALUES('Baker Street');
INSERT INTO CITY(city_name) VALUES('LONDON');
INSERT INTO STATE(state_name) VALUES('LONDON');
INSERT INTO COUNTRY(country_name) VALUES('UK');

execute create_new_facility('BAKER STREET','LONDON', 'LONDON', 'UK', '221B', 'SHANTS HOSPITAL','PRIMARY', 200);


INSERT INTO staff_department_type(type_name) values ('MEDICAL');
INSERT INTO staff_department_type(type_name) values ('NONMEDICAL');

INSERT INTO certification(certification_name) values ('ISO-9011');
INSERT INTO certification(certification_name) values ('ISO-9012');

insert into staff_1(name, hire_date, designation, type_id) values ('dr A', TO_DATE('2019/10/26', 'yyyy/mm/dd'), 'Admin', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('dr B', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'vp', 1);
insert into staff_1(name, hire_date, designation, type_id) values ('abc', TO_DATE('2019/10/25', 'yyyy/mm/dd'), 'office', 2);

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,1,TO_DATE('2019/10/26', 'yyyy/mm/dd'), TO_DATE('2029/10/25', 'yyyy/mm/dd'));

insert into facility_certificates(facility_id, certification_id, start_date, end_date)
values (1,2,TO_DATE('2019/10/20', 'yyyy/mm/dd'), TO_DATE('2020/10/25', 'yyyy/mm/dd'));

insert into service_department(SERVICE_DEPT_CODE, NAME)
values ('GY-OB', 'GYNEC AND OBS');

insert into priority(type) values('HIGH');
insert into priority(type) values('NORMAL');
insert into priority(type) values('QUARANTINE');

execute sign_up_new_patient(1,'BAKER STREET','LONDON', 'LONDON', 'UK', '221B','SHANTANU', 'SHARMA','2019/10/24',9193333333)
insert into symptom(SYMPTOM_NAME) values('COUGH');
insert into symptom(SYMPTOM_NAME) values('FEVER');
insert into symptom(SYMPTOM_NAME) values('HEADACHE');

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

insert into fc_has_serv_dept_1(service_dept_code, director_id) values('CRDLY',1);
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('NRLY',1);
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('PHCY',3);
insert into fc_has_serv_dept_1(service_dept_code, director_id) values('EMRCY',2);

insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('CRDLY', 1, 'Y');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('CRDLY', 2, 'N');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('NRLY', 1, 'N');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('NRLY', 2, 'Y');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('PHCY', 3, 'Y');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('EMRCY', 1, 'N');
insert into staff_in_serv_dept_1(service_dept_code,staff_id, is_primary) values('EMRCY', 2, 'Y');

insert into serv_dept_spec_1(service_dept_code, body_part_code) values('CRDLY','BP6');
insert into serv_dept_spec_1(service_dept_code, body_part_code) values('NRLY','BP2');

insert into service_1(service_code, service_dept_code, equipment, name) values('SR1','NRLY','MACHINE', 'CT_SCAN');
insert into service_1(service_code, service_dept_code, equipment, name) values('SR2','CRDLY','MACHINE', 'ECG');
insert into service_1(service_code, service_dept_code, equipment, name) values('SR3','EMRCY','WARD', 'WARD');

insert into symptom_body_part(symptom_code, body_part_code) values('SYM1','BP1');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM2','BP3');
insert into symptom_body_part(symptom_code, body_part_code) values('SYM3','BP3');

insert into symptom_severity_1(type, symptom_code, staff_id) values('RANGE', 'SYM1', 1);
insert into symptom_severity_1(type, symptom_code, staff_id) values('ENUM', 'SYM2', 1);
insert into symptom_severity_1(type, symptom_code, staff_id) values('ENUM', 'SYM3', 2);

insert into severity_scale_1(symptom_severity_id,index_number,value) values(1,1,'1');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(1,2,'2');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(1,3,'3');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(1,4,'4');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(1,5,'5');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(2,1,'LOW');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(2,2,'MID');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(2,3,'HIGH');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(3,1,'LOW');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(3,2,'MID');
insert into severity_scale_1(symptom_severity_id,index_number,value) values(3,3,'HIGH');

insert into visit_1(patient_id) values(1);

insert into patient_symptoms_1(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(1, 'SYM1', '2', 'POST EATING SWEETS', 'N', 2);
insert into patient_symptoms_1(visit_id,symptom_code,severity_value,post_event,is_recurring ,duration)
values(1, 'SYM2', 'MID', 'POST EATING SWEETS', 'N', 2);

update visit_1 set start_time = to_timestamp('2012/07/18 13:27', 'YYYY/MM/DD HH24:MI') , bp_low = 80, bp_high = 160,
body_temperature  = 120, priority_id =  2 where visit_id = 1;


/* last statement always*/
execute commit ;
