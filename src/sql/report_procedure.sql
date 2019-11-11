/* create table report_<facility_id> */

/*service code is not added(as this table is not created ) in the */

CREATE OR REPLACE PROCEDURE create_new_report
(facility_id number)
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE report_'|| to_char(facility_id) || '(
report_id NUMBER(10) NOT NULL,
neg_exp_id NUMBER(10) NOT NULL,
negative_experience_text VARCHAR2(100) NOT NULL,
treatment VARCHAR2(50) NOT NULL,
visit_id NUMBER(10) NOT NULL,
discharge_status VARCHAR2(50) NOT NULL,
CONSTRAINT report_id_'|| to_char(facility_id) ||'_key PRIMARY KEY (report_id),
CONSTRAINT fk_report_visit_'|| to_char(facility_id) ||' FOREIGN KEY (visit_id) REFERENCES visit_'|| to_char(facility_id) ||' (visit_id),
CONSTRAINT fk_report_neg_exp_'|| to_char(facility_id) ||' FOREIGN KEY (neg_exp_id) REFERENCES negative_experience(neg_exp_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE report_'|| to_char(facility_id) ||'_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER report_'|| to_char(facility_id) ||'_trigger
BEFORE INSERT ON report_'|| to_char(facility_id) ||'
FOR EACH ROW
BEGIN
  SELECT report_'|| to_char(facility_id) ||'_seq.NEXTVAL
  INTO   :new.report_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral_'|| to_char(facility_id) || '(
report_id NUMBER(10) NOT NULL,
staff_id NUMBER(10) NOT NULL,
CONSTRAINT report_referral_'|| to_char(facility_id) || '_key PRIMARY KEY (report_id,staff_id),
CONSTRAINT fk_report_ref_rep_id_'|| to_char(facility_id) || ' FOREIGN KEY (report_id ) REFERENCES report_' || to_char(facility_id) || '(report_id),
CONSTRAINT fk_report_ref_staff_id_'|| to_char(facility_id) ||' FOREIGN KEY(staff_id) REFERENCES staff_' || to_char(facility_id) || '(staff_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral_reason_'|| to_char(facility_id) || '(
reason_id NUMBER(10) NOT NULL,
report_id NUMBER(10) NOT NULL,
reason_code NUMBER(10) NOT NULL,
reason_description VARCHAR2(100) NOT NULL,
service_code NUMBER(10) NOT NULL,
CONSTRAINT report_referral_reason_'|| to_char(facility_id) || '_key PRIMARY KEY (report_id,reason_id),
CONSTRAINT fk_report_ref_res_rep_id_'|| to_char(facility_id) || ' FOREIGN KEY (report_id ) REFERENCES report_'|| to_char(facility_id) ||'(report_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE report_referral_reason_'|| to_char(facility_id) || '_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER report_referral_reason_'|| to_char(facility_id) || '_trigger
BEFORE INSERT ON patient_'|| to_char(facility_id) || '
FOR EACH ROW
BEGIN
  SELECT report_referral_reason_'|| to_char(facility_id) || '_seq.NEXTVAL
  INTO   :new.reason_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_report;
/