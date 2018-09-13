-- PostgreSQL database dump
-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;
 --
-- Name: Competition; Type: DATABASE; Schema: -; Owner: postgres
--
 CREATE DATABASE Competition WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';
 ALTER DATABASE Competition OWNER TO postgres;
 \connect Competition
 SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;
 --
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--
 CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
 --
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--
 COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
 SET search_path = public, pg_catalog;
 SET default_tablespace = '';
 SET default_with_oids = false;
 --
-- Name: match; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE match (
    id integer NOT NULL,
	nomEquipe text,
    Entraineur text,
    date text,
    capitaine text
);
 ALTER TABLE match OWNER TO postgres;
 --
-- Data for Name: match; Type: TABLE DATA; Schema: public; Owner: postgres
--
 INSERT INTO match VALUES (2, 'Paris', '2 Mai 2018', 'Blanc', 'Luis');
INSERT INTO match VALUES (1, 'Liverpool', '18 Juin 1985', 'Kloop', 'Salah');
 --
-- Name: match match_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY match
    ADD CONSTRAINT match_pkey PRIMARY KEY (id);
 --
-- PostgreSQL database dump complete
--