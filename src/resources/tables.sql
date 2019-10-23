CREATE TABLE facility_classification(
classification_id NUMBER(10) NOT NULL,
classification_type VARCHAR2(50) NOT NULL);

ALTER TABLE facility_classification ADD (
CONSTRAINT classification_key PRIMARY KEY(classification_id));

CREATE SEQUENCE fc_cls_seq START WITH 1;

CREATE OR REPLACE TRIGGER classification_trigger
BEFORE INSERT ON facility_classification
FOR EACH ROW

BEGIN
  SELECT fc_cls_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE TABLE street(
street_id NUMBER(10) NOT NULL,
street_name VARCHAR2(50) NOT NULL);

ALTER TABLE street ADD (
CONSTRAINT street_key PRIMARY KEY(street_id));

CREATE SEQUENCE street_seq START WITH 1;

CREATE OR REPLACE TRIGGER street_trigger
BEFORE INSERT ON street
FOR EACH ROW

BEGIN
  SELECT street_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE TABLE city(
city_id NUMBER(10) NOT NULL,
city_name VARCHAR2(50) NOT NULL);

ALTER TABLE city ADD (
CONSTRAINT city_key PRIMARY KEY(city_id));

CREATE SEQUENCE city_seq START WITH 1;

CREATE OR REPLACE TRIGGER city_trigger
BEFORE INSERT ON city
FOR EACH ROW

BEGIN
  SELECT city_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE TABLE state(
state_id NUMBER(10) NOT NULL,
state_name VARCHAR2(50) NOT NULL);

ALTER TABLE state ADD (
CONSTRAINT state_key PRIMARY KEY(state_id));

CREATE SEQUENCE state_seq START WITH 1;

CREATE OR REPLACE TRIGGER state_trigger
BEFORE INSERT ON state
FOR EACH ROW

BEGIN
  SELECT state_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

CREATE TABLE country(
country_id NUMBER(10) NOT NULL,
country_name VARCHAR2(50) NOT NULL);

ALTER TABLE country ADD (
CONSTRAINT country_key PRIMARY KEY(country_id));

CREATE SEQUENCE country_seq START WITH 1;

CREATE OR REPLACE TRIGGER country_trigger
BEFORE INSERT ON country
FOR EACH ROW

BEGIN
  SELECT country_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;

