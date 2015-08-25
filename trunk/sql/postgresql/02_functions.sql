--
-- PostgreSQL - Route-Nova zipcode stored functions.
-- @version     $Id: 02_functions.sql 8 2007-01-21 19:09:17Z mikhail.branicki $
-- 
-- Before use please install Pl/pgSQL to your database and
-- change %YOURSCHEME% string to your database scheme name.
--

-- FUNCTION get_zipradius(zip "varchar", radius float8);

CREATE OR REPLACE FUNCTION %YOURSCHEME%.get_zipradius(zip "varchar", radius float8)
  RETURNS refcursor AS
$BODY$
DECLARE
lon_data float8;
lat_data float8;
zip_data varchar;
zips refcursor;
BEGIN
    SELECT lat,lon INTO lat_data,lon_data FROM zipcode WHERE zipcode=zip;
    open zips for
    SELECT zipcode FROM zipcode WHERE (POW((111.3*(lon- lon_data)*cos(lat_data/57.3)),2)+POW((111.3*(lat- lat_data)),2))<(radius*radius);
    RETURN zips;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE;

