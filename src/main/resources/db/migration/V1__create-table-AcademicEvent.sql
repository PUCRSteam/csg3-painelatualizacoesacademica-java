create table academic_event
(
    id          serial primary key,
    nome        varchar(100) not null,
    data_inicio date         not null,
    data_fim    date         not null,
    event_type  varchar(20)  not null,
    local       varchar(100) not null
);