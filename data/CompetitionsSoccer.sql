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
-- Name: distinction; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE distinction (
    id integer NOT NULL,
    annee integer,
    titre text,
    detail text,
    mouton integer
);
 ALTER TABLE distinction OWNER TO postgres;
 --
-- Name: distinction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
 CREATE SEQUENCE distinction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ALTER TABLE distinction_id_seq OWNER TO postgres;
 --
-- Name: distinction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
 ALTER SEQUENCE distinction_id_seq OWNED BY distinction.id;

 
 --
-- Name: vainqueur; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE vainqueur (
	nomEquipe text,
    Entraineur text,
    date text,
    capitaine text,
	id integer NOT NULL
);
 ALTER TABLE vainqueur OWNER TO postgres;
 
 --
-- Name: vainqueur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
 CREATE SEQUENCE vainqueur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ALTER TABLE vainqueur_id_seq OWNER TO postgres;
 --
-- Name: vainqueur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
 ALTER SEQUENCE vainqueur_id_seq OWNED BY vainqueur.id;
 
 --
-- Name: distinction id; Type: DEFAULT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY distinction ALTER COLUMN id SET DEFAULT nextval('distinction_id_seq'::regclass);

 
 
 --
-- Name: vainqueur id; Type: DEFAULT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY vainqueur ALTER COLUMN id SET DEFAULT nextval('vainqueur_id_seq'::regclass);

 
 --
-- Data for Name: distinction; Type: TABLE DATA; Schema: public; Owner: postgres
--
 --
-- Name: distinction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
 SELECT pg_catalog.setval('distinction_id_seq', 1, false);

 
 --
-- Data for Name: vainqueur; Type: TABLE DATA; Schema: public; Owner: postgres
--
	
 --
-- Name: vainqueur vainqueur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

INSERT INTO vainqueur VALUES ('Real', '11 Mai 2013', 'Makelele', 'Benzema', 1);
INSERT INTO vainqueur VALUES ('Bayern', '25 Juin 2011', 'Guardiola', 'Robben', 2);
INSERT INTO mouton VALUES ('Coucou', 'Noir', '5', '2016', 6);

 --
-- Name: vainqueur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
 SELECT pg_catalog.setval('vainqueur_id_seq', 13, true);

ALTER TABLE ONLY distinction
    ADD CONSTRAINT distinction_pkey PRIMARY KEY (id);
    ADD CONSTRAINT vainqueur_pkey PRIMARY KEY (id);
	
	
	--
-- Name: fki_one_mouton_to_many_distinction; Type: INDEX; Schema: public; Owner: postgres
--
 CREATE INDEX fki_one_mouton_to_many_distinction ON distinction USING btree (mouton);
 --
-- Name: distinction one_mouton_to_many_distinction; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY distinction
    ADD CONSTRAINT one_mouton_to_many_distinction FOREIGN KEY (mouton) REFERENCES mouton(id);

 --
-- PostgreSQL database dump complete
--