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
-- Name: journaliser(); Type: FUNCTION; Schema: public; Owner: postgres
--
 CREATE FUNCTION journaliser() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 
	description text;
	objetAvant text;
    objetApres text;
	operation text;
BEGIN
	objetAvant := '';
	objetApres := '';
    IF TG_OP = 'UPDATE' THEN
    	objetAvant := '{'||OLD.nomEquipe||','||OLD.date||','||OLD.entraineur||'}';
   		objetApres := '{'||NEW.nomEquipe||','||NEW.date||','||NEW.entraineur||'}';
        operation := 'MODIFIER';
    END IF;
	IF TG_OP = 'INSERT' THEN
		objetAvant := '{}';
			objetApres := '{'||NEW.nomEquipe||','||NEW.date||','||NEW.entraineur||'}';
        operation := 'AJOUTER';
    END IF;
	IF TG_OP = 'DELETE' THEN
    	objetAvant := '{'||OLD.nomEquipe||','||OLD.date||','||OLD.entraineur||'}';
		objetApres := '{}';
        operation := 'EFFACER';
    END IF;
 	description := objetAvant || ' -> ' || objetApres;
    -- https://www.postgresql.org/docs/9.1/static/plpgsql-trigger.html
	INSERT into journal(moment, operation, objet, description) VALUES(NOW(), operation, 'vainqueur', description);
	IF TG_OP = 'DELETE' THEN
		return OLD;
	END IF; 
	return NEW;
END
$$;
 ALTER FUNCTION public.journaliser() OWNER TO postgres;

 
 SET default_tablespace = '';
 SET default_with_oids = false;
 
 
 --
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE journal (
    id integer NOT NULL,
    moment timestamp with time zone NOT NULL,
    operation text NOT NULL,
    description text,
    objet text NOT NULL
);
 ALTER TABLE journal OWNER TO postgres;
 --
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
 CREATE SEQUENCE journal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ALTER TABLE journal_id_seq OWNER TO postgres;
 --
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
 ALTER SEQUENCE journal_id_seq OWNED BY journal.id;

 
 --
-- Name: distinction; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE distinction (
    id serial NOT NULL,
    annee integer,
    titre text,
    detail text,
    vainqueur integer
);
 ALTER TABLE distinction OWNER TO postgres;
 --
-- Name: distinction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

 
 --
-- Name: vainqueur; Type: TABLE; Schema: public; Owner: postgres
--
 CREATE TABLE vainqueur (
	nomEquipe text,
    Entraineur text,
    date text,
    capitaine text,
	id bigserial NOT NULL
);
 ALTER TABLE vainqueur OWNER TO postgres;
 insert into vainqueur(nomEquipe, Entraineur, date, capitaine) values('coucou','nana', 'juin', 'moi');
 ALTER TABLE vainqueur OWNER TO postgres;
 insert into vainqueur(nomEquipe, Entraineur, date, capitaine) values('coucou','nana', 'juin', 'moi');
 --
-- Name: vainqueur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
 
--
-- Name: distinction id; Type: DEFAULT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY distinction ALTER COLUMN id SET DEFAULT nextval('distinction_id_seq'::regclass);

 --
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY journal ALTER COLUMN id SET DEFAULT nextval('journal_id_seq'::regclass);
 
 
 INSERT INTO distinction VALUES (1, 2017, 'Meilleur equipe', NULL, 2);
INSERT INTO distinction VALUES (2, 2015, 'Equipe a prendre le moins de but', NULL, 2);
INSERT INTO distinction VALUES (3, 2016, 'Equipe a mettre le plus de but', NULL, 1);
INSERT INTO distinction VALUES (4, 2016, 'Meilleur entraineur de la competition', NULL, 2);
 

 --
-- Data for Name: distinction; Type: TABLE DATA; Schema: public; Owner: postgres
--
 --
-- Name: distinction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
 SELECT pg_catalog.setval('distinction_id_seq', 4, true);
 
 --
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--
 INSERT INTO journal VALUES (1, '2018-09-20 10:30:34.923266-04', 'AJOUTER', '{Paris, 2016-06-01}', 'vainqueur');
 INSERT INTO journal VALUES (11, '2018-09-20 10:59:36.967935-04', 'AJOUTER', '{Manchester, 2016-06-01}', 'vainqueur');
INSERT INTO journal VALUES (12, '2018-09-20 11:00:58.498813-04', 'AJOUTER', '{Madrid, 2016-06-01}', 'vainqueur');
INSERT INTO journal VALUES (13, '2018-09-20 11:04:32.144692-04', 'AJOUTER', '{Bayern}', 'vainqueur');
INSERT INTO journal VALUES (14, '2018-09-20 11:06:51.817885-04', 'AJOUTER', '{lille}', 'vainqueur');
INSERT INTO journal VALUES (15, '2018-09-20 11:23:48.700641-04', 'INSERT', '{Paris} -> {Paris}', 'vainqueur');
INSERT INTO journal VALUES (16, '2018-09-20 11:29:06.004611-04', 'INSERT', ' -> {Paris,Mai,Emery}', 'vainqueur');
INSERT INTO journal VALUES (17, '2018-09-20 11:30:33.415524-04', 'INSERT', ' -> {Paris,Mai,Emery}', 'vainqueur');

INSERT INTO journal VALUES (19, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (20, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (21, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (22, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} ->{Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (23, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (24, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (25, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (26, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (27, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (28, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Paris, 2016-06-01} -> {Bayern,Juin,Klopp}', 'vainqueur');
INSERT INTO journal VALUES (29, '2018-09-20 11:39:37.70787-04', 'EFFACER', '{Bayern,Juin,Klopp} -> ', 'vainqueur');
INSERT INTO journal VALUES (30, '2018-09-20 11:40:48.312734-04', 'EFFACER', '{Bayern,Juin,Klopp} -> {}', 'vainqueur');
INSERT INTO journal VALUES (31, '2018-09-20 11:42:43.235306-04', 'EFFACER', '{Bayern,Janvier,Robben} -> {}', 'vainqueur');

 --
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--
 SELECT pg_catalog.setval('journal_id_seq', 31, true);

 
--
-- Data for Name: vainqueur; Type: TABLE DATA; Schema: public; Owner: postgres
--
	
--
-- Name: vainqueur vainqueur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

--
-- Name: vainqueur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction
    ADD CONSTRAINT distinction_pkey PRIMARY KEY (id);
ALTER TABLE ONLY vainqueur    ADD CONSTRAINT vainqueur_pkey PRIMARY KEY (id);
	
ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);
	
--
-- Name: fki_one_vainqueur_to_many_distinction; Type: INDEX; Schema: public; Owner: postgres
--
 CREATE INDEX fki_one_vainqueur_to_many_distinction ON distinction USING btree (vainqueur);
 

 --
-- Name: distinction one_vainqueur_to_many_distinction; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
 ALTER TABLE ONLY distinction
    ADD CONSTRAINT one_vainqueur_to_many_distinction FOREIGN KEY (vainqueur) REFERENCES vainqueur(id);
