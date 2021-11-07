-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: ./changelog-master.xml
-- Ran at: 07.11.2021, 11:28
-- Against: postgres@jdbc:postgresql://localhost:5432/AZS
-- Liquibase version: 4.2.0
-- *********************************************************************

SET SEARCH_PATH TO public;

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = 'DESKTOP-VOF02QI (192.168.100.4)', LOCKGRANTED = '2021-11-07 11:28:40.868' WHERE ID = 1 AND LOCKED = FALSE;

SET SEARCH_PATH TO public;

-- Release Database Lock
SET SEARCH_PATH TO public;

UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

SET SEARCH_PATH TO public;

