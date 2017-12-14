-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.2
-- PostgreSQL version: 9.5
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: "school-library" | type: DATABASE --
-- -- DROP DATABASE IF EXISTS "school-library";
-- CREATE DATABASE "school-library"
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'Portuguese_Brazil.UTF8'
-- 	LC_CTYPE = 'Portuguese_Brazil.UTF8'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.aluguel_id_aluguel_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.aluguel_id_aluguel_seq CASCADE;
CREATE SEQUENCE public.aluguel_id_aluguel_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.aluguel_id_aluguel_seq OWNER TO postgres;
-- ddl-end --

-- object: public.aluguel | type: TABLE --
-- DROP TABLE IF EXISTS public.aluguel CASCADE;
CREATE TABLE public.aluguel(
	id_aluguel integer NOT NULL DEFAULT nextval('public.aluguel_id_aluguel_seq'::regclass),
	multa numeric,
	retirada date NOT NULL,
	devolucao date NOT NULL,
	id_aluno integer,
	id_livro integer,
	CONSTRAINT id_aluguel_pk PRIMARY KEY (id_aluguel)

);
-- ddl-end --
COMMENT ON TABLE public.aluguel IS 'tabela de aluguel de livro';
-- ddl-end --
ALTER TABLE public.aluguel OWNER TO postgres;
-- ddl-end --

-- object: public.aluno_id_aluno_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.aluno_id_aluno_seq CASCADE;
CREATE SEQUENCE public.aluno_id_aluno_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.aluno_id_aluno_seq OWNER TO postgres;
-- ddl-end --

-- object: public.pessoa | type: TABLE --
-- DROP TABLE IF EXISTS public.pessoa CASCADE;
CREATE TABLE public.pessoa(
	id_pessoa integer NOT NULL DEFAULT nextval('public.aluno_id_aluno_seq'::regclass),
	nome character varying NOT NULL,
	telefone character varying,
	email character varying,
	endereco character varying,
	nascimento date,
	obito date,
	genero char NOT NULL,
	CONSTRAINT id_pessoa_pk PRIMARY KEY (id_pessoa),
	CONSTRAINT check_genero CHECK (genero = 'M' OR genero = 'F')

);
-- ddl-end --
COMMENT ON TABLE public.pessoa IS 'tabela de pessoa';
-- ddl-end --
ALTER TABLE public.pessoa OWNER TO postgres;
-- ddl-end --

-- object: public.autor_id_autor_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.autor_id_autor_seq CASCADE;
CREATE SEQUENCE public.autor_id_autor_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.autor_id_autor_seq OWNER TO postgres;
-- ddl-end --

-- object: public.autor | type: TABLE --
-- DROP TABLE IF EXISTS public.autor CASCADE;
CREATE TABLE public.autor(
	id_autor integer NOT NULL DEFAULT nextval('public.autor_id_autor_seq'::regclass),
	id_pessoa integer,
	CONSTRAINT id_autor_pk PRIMARY KEY (id_autor)

);
-- ddl-end --
COMMENT ON TABLE public.autor IS 'tabela de autores';
-- ddl-end --
ALTER TABLE public.autor OWNER TO postgres;
-- ddl-end --

-- object: public.estante_id_estante_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.estante_id_estante_seq CASCADE;
CREATE SEQUENCE public.estante_id_estante_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.estante_id_estante_seq OWNER TO postgres;
-- ddl-end --

-- object: public.estante | type: TABLE --
-- DROP TABLE IF EXISTS public.estante CASCADE;
CREATE TABLE public.estante(
	id_estante integer NOT NULL DEFAULT nextval('public.estante_id_estante_seq'::regclass),
	descricao character varying,
	horizontal character varying,
	vertical character varying,
	CONSTRAINT id_estante_pk PRIMARY KEY (id_estante)

);
-- ddl-end --
COMMENT ON TABLE public.estante IS 'tabela de estante';
-- ddl-end --
ALTER TABLE public.estante OWNER TO postgres;
-- ddl-end --

-- object: public.genero_id_genero_seq | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.genero_id_genero_seq CASCADE;
CREATE SEQUENCE public.genero_id_genero_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.genero_id_genero_seq OWNER TO postgres;
-- ddl-end --

-- object: public.genero | type: TABLE --
-- DROP TABLE IF EXISTS public.genero CASCADE;
CREATE TABLE public.genero(
	id_genero integer NOT NULL DEFAULT nextval('public.genero_id_genero_seq'::regclass),
	titulo character varying NOT NULL,
	descricao character varying,
	CONSTRAINT pk_genero PRIMARY KEY (id_genero)

);
-- ddl-end --
ALTER TABLE public.genero OWNER TO postgres;
-- ddl-end --

-- object: public.login | type: TABLE --
-- DROP TABLE IF EXISTS public.login CASCADE;
CREATE TABLE public.login(
	id_login serial NOT NULL,
	id_pessoa integer,
	tipo_login char NOT NULL,
	usuario character varying NOT NULL,
	senha character varying NOT NULL,
	CONSTRAINT id_login_pk PRIMARY KEY (id_login),
	CONSTRAINT check_tipo_login CHECK (tipo_login = 'A' OR tipo_login = 'C')

);
-- ddl-end --
ALTER TABLE public.login OWNER TO postgres;
-- ddl-end --

-- object: pessoa_fk | type: CONSTRAINT --
-- ALTER TABLE public.login DROP CONSTRAINT IF EXISTS pessoa_fk CASCADE;
ALTER TABLE public.login ADD CONSTRAINT pessoa_fk FOREIGN KEY (id_pessoa)
REFERENCES public.pessoa (id_pessoa) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: login_uq | type: CONSTRAINT --
-- ALTER TABLE public.login DROP CONSTRAINT IF EXISTS login_uq CASCADE;
ALTER TABLE public.login ADD CONSTRAINT login_uq UNIQUE (id_pessoa);
-- ddl-end --

-- object: pessoa_fk | type: CONSTRAINT --
-- ALTER TABLE public.autor DROP CONSTRAINT IF EXISTS pessoa_fk CASCADE;
ALTER TABLE public.autor ADD CONSTRAINT pessoa_fk FOREIGN KEY (id_pessoa)
REFERENCES public.pessoa (id_pessoa) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: autor_uq | type: CONSTRAINT --
-- ALTER TABLE public.autor DROP CONSTRAINT IF EXISTS autor_uq CASCADE;
ALTER TABLE public.autor ADD CONSTRAINT autor_uq UNIQUE (id_pessoa);
-- ddl-end --

-- object: public.livro | type: TABLE --
-- DROP TABLE IF EXISTS public.livro CASCADE;
CREATE TABLE public.livro(
	id_livro serial NOT NULL,
	titulo character varying NOT NULL,
	subtitulo character varying NOT NULL,
	paginas integer NOT NULL,
	exemplares integer NOT NULL,
	lancamento date,
	id_estante integer,
	id_genero integer,
	CONSTRAINT id_livro_pk PRIMARY KEY (id_livro)

);
-- ddl-end --
ALTER TABLE public.livro OWNER TO postgres;
-- ddl-end --

-- object: livro_fk | type: CONSTRAINT --
-- ALTER TABLE public.aluguel DROP CONSTRAINT IF EXISTS livro_fk CASCADE;
ALTER TABLE public.aluguel ADD CONSTRAINT livro_fk FOREIGN KEY (id_livro)
REFERENCES public.livro (id_livro) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.many_livro_has_many_autor | type: TABLE --
-- DROP TABLE IF EXISTS public.many_livro_has_many_autor CASCADE;
CREATE TABLE public.many_livro_has_many_autor(
	id_livro integer,
	id_autor_autor integer,
	CONSTRAINT many_livro_has_many_autor_pk PRIMARY KEY (id_livro,id_autor_autor)

);
-- ddl-end --

-- object: livro_fk | type: CONSTRAINT --
-- ALTER TABLE public.many_livro_has_many_autor DROP CONSTRAINT IF EXISTS livro_fk CASCADE;
ALTER TABLE public.many_livro_has_many_autor ADD CONSTRAINT livro_fk FOREIGN KEY (id_livro)
REFERENCES public.livro (id_livro) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: autor_fk | type: CONSTRAINT --
-- ALTER TABLE public.many_livro_has_many_autor DROP CONSTRAINT IF EXISTS autor_fk CASCADE;
ALTER TABLE public.many_livro_has_many_autor ADD CONSTRAINT autor_fk FOREIGN KEY (id_autor_autor)
REFERENCES public.autor (id_autor) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: estante_fk | type: CONSTRAINT --
-- ALTER TABLE public.livro DROP CONSTRAINT IF EXISTS estante_fk CASCADE;
ALTER TABLE public.livro ADD CONSTRAINT estante_fk FOREIGN KEY (id_estante)
REFERENCES public.estante (id_estante) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: genero_fk | type: CONSTRAINT --
-- ALTER TABLE public.livro DROP CONSTRAINT IF EXISTS genero_fk CASCADE;
ALTER TABLE public.livro ADD CONSTRAINT genero_fk FOREIGN KEY (id_genero)
REFERENCES public.genero (id_genero) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


