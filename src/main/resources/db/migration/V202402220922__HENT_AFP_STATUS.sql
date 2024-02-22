create table HENT_AFP_STATUS (
    tenant varchar(20) not null,
    fnr varchar(20) not null,

    retur_fnr varchar(20) null,
    tpid varchar(20) null,
    status_afp varchar(20) null,
    virkningsdato date null,
    belop numeric null,
    dato_sist_regulert date null,

    PRIMARY KEY(
        tenant,
        fnr
    )
)
