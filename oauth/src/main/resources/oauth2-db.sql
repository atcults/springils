-- Table: public.oauth_client

-- DROP TABLE public.oauth_client;

CREATE TABLE public.oauth_client
(
  client_id character varying(100) NOT NULL,
  client_secret character varying(100) NOT NULL,
  client_name character varying(100) NOT NULL,
  description character varying(200) NOT NULL,
  client_url character varying(200),
  client_type character varying(20) NOT NULL,
  scope character varying(100),
  redirect_uri character varying(200),
  regdate date,
  CONSTRAINT "PK_clientId" PRIMARY KEY (client_id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.oauth_client
OWNER TO postgres;

-- Table: public.oauth_token

-- DROP TABLE public.oauth_token;

CREATE TABLE public.oauth_token
(
  client_id character varying(100),
  user_id character varying(20),
  access_token character varying(200) NOT NULL,
  refresh_token character varying(200),
  token_type character varying(30),
  scope character varying(100),
  auth_code character varying(200),
  state character varying(100),
  client_type character varying(20),
  at_created timestamp without time zone,
  rt_created timestamp without time zone,
  at_expires_in timestamp without time zone,
  rt_expires_in timestamp without time zone,
  request_source character varying(50),
  request_detail character varying(100),
  CONSTRAINT "PK_token" PRIMARY KEY (access_token),
  CONSTRAINT "UK_refresh_token" UNIQUE (refresh_token)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.oauth_token
OWNER TO postgres;

-- Index: public."IX_user_id"

-- DROP INDEX public."IX_user_id";

CREATE INDEX "IX_user_id"
ON public.oauth_token
USING btree
(user_id COLLATE pg_catalog."default");

-- Table: public.oauth_token_log

-- DROP TABLE public.oauth_token_log;

CREATE TABLE public.oauth_token_log
(
  client_id character varying(100),
  user_id character varying(20),
  access_token character varying(200) NOT NULL,
  refresh_token character varying(200),
  token_type character varying(30),
  scope character varying(100),
  auth_code character varying(200),
  state character varying(100),
  client_type character varying(20),
  at_created timestamp without time zone,
  rt_created timestamp without time zone,
  at_expires_in timestamp without time zone,
  rt_expires_in timestamp without time zone,
  request_source character varying(50),
  request_detail character varying(100),
  token_action character varying(10),
  CONSTRAINT "PK_token_log" PRIMARY KEY (access_token)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.oauth_token_log
OWNER TO postgres;
