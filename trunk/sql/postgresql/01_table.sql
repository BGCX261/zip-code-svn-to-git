--
-- PostgreSQL - Route-Nova zipcode table creation.
-- @version     $Id: 01_table.sql 8 2007-01-21 19:09:17Z mikhail.branicki $
-- 
-- Before use change %YOURSCHEME% to your database scheme name.
--
CREATE SCHEMA %YOURSCHEME%;
CREATE TABLE %YOURSCHEME%.zipcode (
    zipcode character varying NOT NULL,
    lat double precision,
    lon double precision,
    city character varying,
    state character varying,
    county character varying,
    zip_class character varying
)
WITHOUT OIDS;