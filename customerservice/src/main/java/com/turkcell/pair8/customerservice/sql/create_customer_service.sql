CREATE TABLE IF NOT EXISTS public.accounts
(
    id serial NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "number" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    status character varying(50) COLLATE pg_catalog."default" NOT NULL,
    type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    customer_id integer,
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.addresses
(
    id serial NOT NULL,
    city character varying(255) COLLATE pg_catalog."default" NOT NULL,
    street character varying(255) COLLATE pg_catalog."default" NOT NULL,
    house_number character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    customer_id integer,
    CONSTRAINT addresses_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.customers
(
    id serial NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(50) COLLATE pg_catalog."default",
    mother_name character varying(255) COLLATE pg_catalog."default",
    father_name character varying(255) COLLATE pg_catalog."default",
    birth_date date NOT NULL,
    nationality_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    home_phone_number character varying(255) COLLATE pg_catalog."default",
    mobile_phone_number character varying(255) COLLATE pg_catalog."default",
    fax_number character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customers_pkey PRIMARY KEY (id),
    CONSTRAINT customers_nationality_id_key UNIQUE (nationality_id)
);

ALTER TABLE IF EXISTS public.accounts
    ADD CONSTRAINT accounts_customer_id_fkey FOREIGN KEY (customer_id)
    REFERENCES public.customers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;


ALTER TABLE IF EXISTS public.addresses
    ADD CONSTRAINT addresses_customer_id_fkey FOREIGN KEY (customer_id)
    REFERENCES public.customers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

END;