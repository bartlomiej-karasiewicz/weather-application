CREATE TABLE syno
(
    id bigint NOT NULL,
    pressure double precision,
    measure_date date,
    measuare_time integer,
    id_station bigint,
    wind_direction integer,
    wind_speed double precision,
    station character varying(255),
    total_rainfall double precision,
    temperature double precision,
    relative_humidity double precision,
    CONSTRAINT syno_pkey PRIMARY KEY (id)
)