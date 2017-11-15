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
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.livro | type: TABLE --
-- DROP TABLE IF EXISTS public.livro CASCADE;
CREATE TABLE public.livro(
	id_livro serial NOT NULL,
	titulo character varying NOT NULL,
	subtitulo character varying NOT NULL,
	qtd_paginas integer,
	estoque integer,
	data_publicacao date,
	id_estante integer,
	id_genero integer,
	CONSTRAINT pk_livro PRIMARY KEY (id_livro)

);
-- ddl-end --
COMMENT ON TABLE public.livro IS 'tabela de livros';
-- ddl-end --
COMMENT ON CONSTRAINT pk_livro ON public.livro  IS 'primary key tabela livro';
-- ddl-end --
ALTER TABLE public.livro OWNER TO postgres;
-- ddl-end --

-- object: public.autor | type: TABLE --
-- DROP TABLE IF EXISTS public.autor CASCADE;
CREATE TABLE public.autor(
	id_autor serial NOT NULL,
	nome_completo character varying NOT NULL,
	data_nascimento date,
	data_obito date,
	CONSTRAINT pk_autor PRIMARY KEY (id_autor)

);
-- ddl-end --
COMMENT ON TABLE public.autor IS 'tabela de autores';
-- ddl-end --
ALTER TABLE public.autor OWNER TO postgres;
-- ddl-end --

-- object: public.autores_livros | type: TABLE --
-- DROP TABLE IF EXISTS public.autores_livros CASCADE;
CREATE TABLE public.autores_livros(
	id_autor integer,
	id_livro integer,
	CONSTRAINT autores_livros_pk PRIMARY KEY (id_autor,id_livro)

);
-- ddl-end --

-- object: autor_fk | type: CONSTRAINT --
-- ALTER TABLE public.autores_livros DROP CONSTRAINT IF EXISTS autor_fk CASCADE;
ALTER TABLE public.autores_livros ADD CONSTRAINT autor_fk FOREIGN KEY (id_autor)
REFERENCES public.autor (id_autor) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: livro_fk | type: CONSTRAINT --
-- ALTER TABLE public.autores_livros DROP CONSTRAINT IF EXISTS livro_fk CASCADE;
ALTER TABLE public.autores_livros ADD CONSTRAINT livro_fk FOREIGN KEY (id_livro)
REFERENCES public.livro (id_livro) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: public.estante | type: TABLE --
-- DROP TABLE IF EXISTS public.estante CASCADE;
CREATE TABLE public.estante(
	id_estante serial NOT NULL,
	descricao character varying,
	posicao_horizontal character varying,
	posicao_vertical character varying,
	CONSTRAINT pk_estante PRIMARY KEY (id_estante)

);
-- ddl-end --
COMMENT ON TABLE public.estante IS 'tabela de estante';
-- ddl-end --
ALTER TABLE public.estante OWNER TO postgres;
-- ddl-end --

-- object: estante_fk | type: CONSTRAINT --
-- ALTER TABLE public.livro DROP CONSTRAINT IF EXISTS estante_fk CASCADE;
ALTER TABLE public.livro ADD CONSTRAINT estante_fk FOREIGN KEY (id_estante)
REFERENCES public.estante (id_estante) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.genero | type: TABLE --
-- DROP TABLE IF EXISTS public.genero CASCADE;
CREATE TABLE public.genero(
	id_genero serial NOT NULL,
	titulo character varying NOT NULL,
	descricao character varying,
	CONSTRAINT pk_genero PRIMARY KEY (id_genero)

);
-- ddl-end --
ALTER TABLE public.genero OWNER TO postgres;
-- ddl-end --

-- object: genero_fk | type: CONSTRAINT --
-- ALTER TABLE public.livro DROP CONSTRAINT IF EXISTS genero_fk CASCADE;
ALTER TABLE public.livro ADD CONSTRAINT genero_fk FOREIGN KEY (id_genero)
REFERENCES public.genero (id_genero) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.aluno | type: TABLE --
-- DROP TABLE IF EXISTS public.aluno CASCADE;
CREATE TABLE public.aluno(
	id_aluno serial NOT NULL,
	nome_completo character varying NOT NULL,
	data_nascimento date,
	ativo boolean NOT NULL DEFAULT true,
	CONSTRAINT pk_aluno PRIMARY KEY (id_aluno)

);
-- ddl-end --
COMMENT ON TABLE public.aluno IS 'tabela de aluno';
-- ddl-end --
ALTER TABLE public.aluno OWNER TO postgres;
-- ddl-end --

-- object: public.aluguel | type: TABLE --
-- DROP TABLE IF EXISTS public.aluguel CASCADE;
CREATE TABLE public.aluguel(
	id_aluguel serial NOT NULL,
	multa numeric,
	data_retirada date NOT NULL,
	data_devolucao date NOT NULL,
	id_aluno integer,
	id_livro integer,
	CONSTRAINT pk_aluguel PRIMARY KEY (id_aluguel)

);
-- ddl-end --
COMMENT ON TABLE public.aluguel IS 'tabela de aluguel de livro';
-- ddl-end --
ALTER TABLE public.aluguel OWNER TO postgres;
-- ddl-end --

-- object: aluno_fk | type: CONSTRAINT --
-- ALTER TABLE public.aluguel DROP CONSTRAINT IF EXISTS aluno_fk CASCADE;
ALTER TABLE public.aluguel ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno)
REFERENCES public.aluno (id_aluno) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: aluguel_uq | type: CONSTRAINT --
-- ALTER TABLE public.aluguel DROP CONSTRAINT IF EXISTS aluguel_uq CASCADE;
ALTER TABLE public.aluguel ADD CONSTRAINT aluguel_uq UNIQUE (id_aluno);
-- ddl-end --

-- object: livro_fk | type: CONSTRAINT --
-- ALTER TABLE public.aluguel DROP CONSTRAINT IF EXISTS livro_fk CASCADE;
ALTER TABLE public.aluguel ADD CONSTRAINT livro_fk FOREIGN KEY (id_livro)
REFERENCES public.livro (id_livro) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: aluguel_uq1 | type: CONSTRAINT --
-- ALTER TABLE public.aluguel DROP CONSTRAINT IF EXISTS aluguel_uq1 CASCADE;
ALTER TABLE public.aluguel ADD CONSTRAINT aluguel_uq1 UNIQUE (id_livro);
-- ddl-end --

-- object: public.telefone | type: TABLE --
-- DROP TABLE IF EXISTS public.telefone CASCADE;
CREATE TABLE public.telefone(
	id_telefone serial NOT NULL,
	telefone character varying NOT NULL,
	id_aluno integer,
	CONSTRAINT pk_telefone PRIMARY KEY (id_telefone)

);
-- ddl-end --
COMMENT ON TABLE public.telefone IS 'tabela de telefone';
-- ddl-end --
ALTER TABLE public.telefone OWNER TO postgres;
-- ddl-end --

-- object: public.email | type: TABLE --
-- DROP TABLE IF EXISTS public.email CASCADE;
CREATE TABLE public.email(
	id_email serial NOT NULL,
	email character varying NOT NULL,
	id_aluno integer,
	CONSTRAINT pk_email PRIMARY KEY (id_email)

);
-- ddl-end --
COMMENT ON TABLE public.email IS 'tabela de email';
-- ddl-end --
ALTER TABLE public.email OWNER TO postgres;
-- ddl-end --

-- object: public.endereco | type: TABLE --
-- DROP TABLE IF EXISTS public.endereco CASCADE;
CREATE TABLE public.endereco(
	id_endereco serial NOT NULL,
	endereco character varying NOT NULL,
	id_aluno integer,
	CONSTRAINT pk_endereco PRIMARY KEY (id_endereco)

);
-- ddl-end --
COMMENT ON TABLE public.endereco IS 'tabela de endereco';
-- ddl-end --
ALTER TABLE public.endereco OWNER TO postgres;
-- ddl-end --

-- object: aluno_fk | type: CONSTRAINT --
-- ALTER TABLE public.email DROP CONSTRAINT IF EXISTS aluno_fk CASCADE;
ALTER TABLE public.email ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno)
REFERENCES public.aluno (id_aluno) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: aluno_fk | type: CONSTRAINT --
-- ALTER TABLE public.endereco DROP CONSTRAINT IF EXISTS aluno_fk CASCADE;
ALTER TABLE public.endereco ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno)
REFERENCES public.aluno (id_aluno) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: aluno_fk | type: CONSTRAINT --
-- ALTER TABLE public.telefone DROP CONSTRAINT IF EXISTS aluno_fk CASCADE;
ALTER TABLE public.telefone ADD CONSTRAINT aluno_fk FOREIGN KEY (id_aluno)
REFERENCES public.aluno (id_aluno) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


