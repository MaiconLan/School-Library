--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-12-13 01:36:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 192 (class 1259 OID 65518)
-- Name: aluguel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aluguel (
    id_aluguel integer NOT NULL,
    multa numeric,
    retirada date NOT NULL,
    devolucao date NOT NULL,
    id_aluno integer,
    id_livro integer
);


ALTER TABLE aluguel OWNER TO postgres;

--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 192
-- Name: TABLE aluguel; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE aluguel IS 'tabela de aluguel de livro';


--
-- TOC entry 191 (class 1259 OID 65516)
-- Name: aluguel_id_aluguel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aluguel_id_aluguel_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aluguel_id_aluguel_seq OWNER TO postgres;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 191
-- Name: aluguel_id_aluguel_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aluguel_id_aluguel_seq OWNED BY aluguel.id_aluguel;


--
-- TOC entry 190 (class 1259 OID 65506)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aluno (
    id_aluno integer NOT NULL,
    nome character varying NOT NULL,
    nascimento date,
    ativo boolean DEFAULT true NOT NULL,
    telefone character varying,
    email character varying,
    endereco character varying
);


ALTER TABLE aluno OWNER TO postgres;

--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 190
-- Name: TABLE aluno; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE aluno IS 'tabela de aluno';


--
-- TOC entry 189 (class 1259 OID 65504)
-- Name: aluno_id_aluno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aluno_id_aluno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aluno_id_aluno_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 189
-- Name: aluno_id_aluno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aluno_id_aluno_seq OWNED BY aluno.id_aluno;


--
-- TOC entry 183 (class 1259 OID 65448)
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE autor (
    id_autor integer NOT NULL,
    nome character varying NOT NULL,
    nascimento date,
    obito date
);


ALTER TABLE autor OWNER TO postgres;

--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 183
-- Name: TABLE autor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE autor IS 'tabela de autores';


--
-- TOC entry 182 (class 1259 OID 65446)
-- Name: autor_id_autor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE autor_id_autor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE autor_id_autor_seq OWNER TO postgres;

--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 182
-- Name: autor_id_autor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE autor_id_autor_seq OWNED BY autor.id_autor;


--
-- TOC entry 184 (class 1259 OID 65457)
-- Name: autores_livros; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE autores_livros (
    id_autor integer NOT NULL,
    id_livro integer NOT NULL
);


ALTER TABLE autores_livros OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 65565)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE endereco (
    id_endereco integer NOT NULL,
    endereco character varying NOT NULL,
    id_aluno integer
);


ALTER TABLE endereco OWNER TO postgres;

--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 194
-- Name: TABLE endereco; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE endereco IS 'tabela de endereco';


--
-- TOC entry 193 (class 1259 OID 65563)
-- Name: endereco_id_endereco_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE endereco_id_endereco_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endereco_id_endereco_seq OWNER TO postgres;

--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 193
-- Name: endereco_id_endereco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE endereco_id_endereco_seq OWNED BY endereco.id_endereco;


--
-- TOC entry 186 (class 1259 OID 65474)
-- Name: estante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE estante (
    id_estante integer NOT NULL,
    descricao character varying,
    posicao_horizontal character varying,
    posicao_vertical character varying
);


ALTER TABLE estante OWNER TO postgres;

--
-- TOC entry 2188 (class 0 OID 0)
-- Dependencies: 186
-- Name: TABLE estante; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE estante IS 'tabela de estante';


--
-- TOC entry 185 (class 1259 OID 65472)
-- Name: estante_id_estante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE estante_id_estante_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estante_id_estante_seq OWNER TO postgres;

--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 185
-- Name: estante_id_estante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estante_id_estante_seq OWNED BY estante.id_estante;


--
-- TOC entry 188 (class 1259 OID 65490)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE genero (
    id_genero integer NOT NULL,
    titulo character varying NOT NULL,
    descricao character varying
);


ALTER TABLE genero OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 65488)
-- Name: genero_id_genero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE genero_id_genero_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE genero_id_genero_seq OWNER TO postgres;

--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 187
-- Name: genero_id_genero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE genero_id_genero_seq OWNED BY genero.id_genero;


--
-- TOC entry 181 (class 1259 OID 65425)
-- Name: versao_base; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE versao_base (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE versao_base OWNER TO postgres;

--
-- TOC entry 2032 (class 2604 OID 65521)
-- Name: id_aluguel; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluguel ALTER COLUMN id_aluguel SET DEFAULT nextval('aluguel_id_aluguel_seq'::regclass);


--
-- TOC entry 2030 (class 2604 OID 65509)
-- Name: id_aluno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno ALTER COLUMN id_aluno SET DEFAULT nextval('aluno_id_aluno_seq'::regclass);


--
-- TOC entry 2027 (class 2604 OID 65451)
-- Name: id_autor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autor ALTER COLUMN id_autor SET DEFAULT nextval('autor_id_autor_seq'::regclass);


--
-- TOC entry 2033 (class 2604 OID 65568)
-- Name: id_endereco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco ALTER COLUMN id_endereco SET DEFAULT nextval('endereco_id_endereco_seq'::regclass);


--
-- TOC entry 2028 (class 2604 OID 65477)
-- Name: id_estante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estante ALTER COLUMN id_estante SET DEFAULT nextval('estante_id_estante_seq'::regclass);


--
-- TOC entry 2029 (class 2604 OID 65493)
-- Name: id_genero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genero ALTER COLUMN id_genero SET DEFAULT nextval('genero_id_genero_seq'::regclass);


--
-- TOC entry 2048 (class 2606 OID 65533)
-- Name: aluguel_uq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluguel
    ADD CONSTRAINT aluguel_uq UNIQUE (id_aluno);


--
-- TOC entry 2050 (class 2606 OID 65540)
-- Name: aluguel_uq1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluguel
    ADD CONSTRAINT aluguel_uq1 UNIQUE (id_livro);


--
-- TOC entry 2040 (class 2606 OID 65461)
-- Name: autores_livros_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autores_livros
    ADD CONSTRAINT autores_livros_pk PRIMARY KEY (id_autor, id_livro);


--
-- TOC entry 2052 (class 2606 OID 65526)
-- Name: pk_aluguel; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluguel
    ADD CONSTRAINT pk_aluguel PRIMARY KEY (id_aluguel);


--
-- TOC entry 2046 (class 2606 OID 65515)
-- Name: pk_aluno; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT pk_aluno PRIMARY KEY (id_aluno);


--
-- TOC entry 2038 (class 2606 OID 65456)
-- Name: pk_autor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autor
    ADD CONSTRAINT pk_autor PRIMARY KEY (id_autor);


--
-- TOC entry 2054 (class 2606 OID 65573)
-- Name: pk_endereco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT pk_endereco PRIMARY KEY (id_endereco);


--
-- TOC entry 2042 (class 2606 OID 65482)
-- Name: pk_estante; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estante
    ADD CONSTRAINT pk_estante PRIMARY KEY (id_estante);


--
-- TOC entry 2044 (class 2606 OID 65498)
-- Name: pk_genero; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genero
    ADD CONSTRAINT pk_genero PRIMARY KEY (id_genero);


--
-- TOC entry 2035 (class 2606 OID 65433)
-- Name: versao_base_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY versao_base
    ADD CONSTRAINT versao_base_pk PRIMARY KEY (installed_rank);


--
-- TOC entry 2036 (class 1259 OID 65434)
-- Name: versao_base_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX versao_base_s_idx ON versao_base USING btree (success);


--
-- TOC entry 2056 (class 2606 OID 65527)
-- Name: aluno_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluguel
    ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2057 (class 2606 OID 65579)
-- Name: aluno_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno) MATCH FULL ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2055 (class 2606 OID 65462)
-- Name: autor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autores_livros
    ADD CONSTRAINT autor_fk FOREIGN KEY (id_autor) REFERENCES autor(id_autor) MATCH FULL ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-12-13 01:36:54

--
-- PostgreSQL database dump complete
--

