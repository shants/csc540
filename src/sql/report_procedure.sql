
/*service code is not added(as this table is not created ) in the */

CREATE OR REPLACE PROCEDURE create_new_report
AUTHID CURRENT_USER IS
new_query varchar2(5000);

BEGIN
new_query := 'CREATE TABLE report(
report_id NUMBER(10) NOT NULL,
neg_exp_id NUMBER(10),
negative_experience_text VARCHAR2(100) NOT NULL,
treatment VARCHAR2(50) NOT NULL,
visit_id NUMBER(10) NOT NULL,
discharge_status VARCHAR2(50) NOT NULL,
CONSTRAINT report_id_key PRIMARY KEY (report_id),
CONSTRAINT fk_report_visit FOREIGN KEY (visit_id) REFERENCES visit(visit_id),
)';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE report_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER report_trigger
BEFORE INSERT ON report
FOR EACH ROW
BEGIN
  SELECT report_seq.NEXTVAL
  INTO   :new.report_id
  FROM   dual;
END;';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral(
facility_id NUMBER(10) NOT NULL,
report_id NUMBER(10) NOT NULL,
staff_id NUMBER(10) NOT NULL,
CONSTRAINT report_referral_key PRIMARY KEY (report_id,staff_id),
CONSTRAINT fk_report_ref_fac_id FOREIGN KEY (facility_id) REFERENCES facility(facility_id),
CONSTRAINT fk_report_ref_rep_id FOREIGN KEY (report_id ) REFERENCES report(report_id),
CONSTRAINT fk_report_ref_staff_id FOREIGN KEY(staff_id) REFERENCES staff(staff_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE TABLE report_referral_reason(
reason_id NUMBER(10) NOT NULL,
report_id NUMBER(10) NOT NULL,
reason_code NUMBER(10) NOT NULL,
reason_description VARCHAR2(100) NOT NULL,
service_code VARCHAR2(20) NOT NULL,
CONSTRAINT report_referral_reason_key PRIMARY KEY (report_id,reason_id),
CONSTRAINT fk_report_ref_res_rep_id FOREIGN KEY (report_id) REFERENCES report(report_id))';

EXECUTE IMMEDIATE new_query;
new_query := 'CREATE SEQUENCE rep_refer_rea_seq START WITH 1';
EXECUTE IMMEDIATE new_query;
new_query := 'CREATE OR REPLACE TRIGGER rep_refer_rea_trigger
BEFORE INSERT ON report_referral_reason
FOR EACH ROW
BEGIN
  SELECT rep_refer_rea_seq.NEXTVAL
  INTO   :new.reason_id
  FROM   dual;
END;';
EXECUTE IMMEDIATE new_query;
end create_new_report;
/