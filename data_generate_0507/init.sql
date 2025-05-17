--liquibase formatted sql

--changeset bruce.jeaung:init
create table if not exists container (
  id bigint primary key,
  name text
);

--changeset bruce.jeaung:init
create table if not exists cluster (
  id bigint primary key,
  name text,
  container_id bigint
);

--changeset bruce.jeaung:init
create table if not exists pack (
  id bigint primary key,
  cluster_id bigint,
  name text
);

--changeset bruce.jeaung:init
create table if not exists eis_measurement (
  id bigserial,
  container_id bigint,
  cluster_id bigint,
  pack_id bigint,
  cell_id bigint,
  real_impedance double precision,
  imaginary_impedance double precision,
  temperature double precision,
  frequency double precision,
  voltage double precision,
  creation_time timestamp without time zone,
  primary key (id, creation_time)
) PARTITION BY RANGE (creation_time);

--changeset bruce.jeaung:init
create table if not exists generated_record (
  id bigserial,
  container_id bigint,
  cluster_id bigint,
  pack_id bigint,
  cell_id text,
  creation_time timestamp without time zone,
  dispersion_coefficient double precision,
  temperature double precision,
  sei_parameter integer,
  dendrites_parameter integer,
  electrolyte_parameter integer,
  polarization_potential double precision,
  conductivity double precision,
  primary key (id, creation_time)
) PARTITION BY RANGE (creation_time);

--changeset bruce.jeaung:init
create table if not exists pack_metrics_record (
  id bigserial,
  container_id bigint,
  cluster_id bigint,
  pack_id bigint,
  dispersion_coefficient double precision,
  safety_rate double precision,
  creation_time timestamp without time zone,
  primary key (id, creation_time)
) PARTITION BY RANGE (creation_time);

--changeset bruce.jeaung:init
create table if not exists scheduled_tasks (
  task_name text not null,
  task_instance text not null,
  task_data bytea,
  execution_time timestamp with time zone not null,
  picked boolean not null,
  picked_by text,
  last_success timestamp with time zone,
  last_failure timestamp with time zone,
  consecutive_failures int,
  last_heartbeat timestamp with time zone,
  version bigint not null,
  priority smallint,
  primary key (task_name, task_instance)
);
create index if not exists execution_time_idx on scheduled_tasks(execution_time);
create index if not exists last_heartbeat_idx on scheduled_tasks(last_heartbeat);
create index if not exists priority_execution_time_idx on scheduled_tasks(priority desc, execution_time asc);

--changeset bruce.jeaung:init
create table if not exists monthly_statistics (
  id bigserial primary key,
  year_month char(7) unique,
  total_inspections integer,
  total_measurements bigint
);

--changeset bruce.jeaung:init
create table if not exists pack_statistics (
    stat_id serial primary key,
    container_id bigint not null,
    cluster_id bigint not null,
    pack_id bigint not null,
    real_time_id timestamp not null,
    abs_impedance_mean real not null,
    impedance_std real not null,
    coefficient_variation real not null,
    dispersion real not null,
    impedance_10000hz real not null,
    impedance_10hz real not null,
    max_abs_impedance real not null,
    min_abs_impedance real not null,
    max_impedance_std real not null,
    min_impedance_std real not null,
    max_coefficient_variation real not null,
    min_coefficient_variation real not null,
    temperature real,
    cellcolors jsonb not null,
    status text not null check (status in ('正常','轻度衰退','严重衰退')),
    suggestion text,
    alert_text text,
    created_at timestamp without time zone default now() not null
);
create index if not exists idx_pack_stats_pack_time on pack_statistics(pack_id, real_time_id);

--changeset bruce.jeaung:init
create table if not exists cell_statistics (
    stat_id serial primary key,
    container_id bigint not null,
    cluster_id bigint not null,
    pack_id bigint not null,
    group_id bigint,
    cell_id bigint not null,
    real_time_id timestamp not null,
    metrics jsonb not null,
    real_part_correlation jsonb not null,
    imag_part_correlation jsonb not null,
    nyquist_plot jsonb not null,
    bode_plot jsonb not null,
    drt_plot jsonb not null,
    equivalent_circuit_diagram jsonb not null,
    realpart10Hz real,
    imagpart10Hz real,
    created_at timestamp without time zone default now() not null
);
create index if not exists idx_cell_stats_pack_cell_time on cell_statistics(pack_id, cell_id, real_time_id);
