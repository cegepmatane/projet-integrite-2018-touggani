--
-- PostgreSQL database dump
--

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

CREATE DATABASE "Competition" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE "Competition" OWNER TO postgres;

\connect "Competition"

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

--
-- Name: CreerVainqueur(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "CreerVainqueur"() RETURNS bigint
    LANGUAGE sql
    AS $$

select count (id) as nombreVainqueur from vainqueur

$$;


ALTER FUNCTION public."CreerVainqueur"() OWNER TO postgres;

--
-- Name: creervainqueur(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION creervainqueur() RETURNS bigint
    LANGUAGE sql
    AS $$

select count (id) as nombreVainqueur from vainqueur

$$;


ALTER FUNCTION public.creervainqueur() OWNER TO postgres;

--
-- Name: insererNombre(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION "insererNombre"() RETURNS void
    LANGUAGE sql
    AS $$

insert into memoire(nombre)values (3)

$$;


ALTER FUNCTION public."insererNombre"() OWNER TO postgres;

--
-- Name: inserernombre(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION inserernombre() RETURNS void
    LANGUAGE sql
    AS $$

insert into memoire(nombre)values (3)

$$;


ALTER FUNCTION public.inserernombre() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: distinction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE distinction (
    id integer NOT NULL,
    "idVainqueur" integer,
    titre text,
    description text,
    prix text
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
-- Name: memoire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE memoire (
    id integer NOT NULL,
    nombre integer
);


ALTER TABLE memoire OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE memoire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE memoire_id_seq OWNER TO postgres;

--
-- Name: memoire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE memoire_id_seq OWNED BY memoire.id;


--
-- Name: vainqueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE vainqueur (
    id integer NOT NULL,
    date text,
    entraineur text,
    capitaine text,
    "nomEquipe" text
);


ALTER TABLE vainqueur OWNER TO postgres;

--
-- Name: distinction id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction ALTER COLUMN id SET DEFAULT nextval('distinction_id_seq'::regclass);


--
-- Name: memoire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY memoire ALTER COLUMN id SET DEFAULT nextval('memoire_id_seq'::regclass);


--
-- Data for Name: distinction; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: distinction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('distinction_id_seq', 1, false);


--
-- Data for Name: memoire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO memoire VALUES (1, 3);


--
-- Name: memoire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('memoire_id_seq', 1, true);


--
-- Data for Name: vainqueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO vainqueur VALUES (1, '10 Juin 2018', 'Emery', 'Silva', 'Paris Saint Germain');
INSERT INTO vainqueur VALUES (2, '20 Novembre 1998', 'Youssef', 'Zidane
', 'Equipe de France
');


--
-- Name: distinction distinction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction
    ADD CONSTRAINT distinction_pkey PRIMARY KEY (id);


--
-- Name: memoire memoire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY memoire
    ADD CONSTRAINT memoire_pkey PRIMARY KEY (id);


--
-- Name: vainqueur vainqueur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vainqueur
    ADD CONSTRAINT vainqueur_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

