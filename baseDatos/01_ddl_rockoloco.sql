/*==============================================================*/
/* Table: artistas                                              */
/*==============================================================*/
create table artistas
(
   cod_artista          int not null auto_increment  comment '',
   nombre_artista       varchar(200) not null  comment '',
   nacionalidad_artista varchar(200) not null  comment '',
   primary key (cod_artista)
);

/*==============================================================*/
/* Table: canciones                                             */
/*==============================================================*/
create table canciones
(
   cod_cancion          int not null auto_increment  comment '',
   cod_decada           int not null  comment '',
   cod_genero           int not null  comment '',
   cod_artista          int  comment '',
   nombre_cancion       varchar(200) not null  comment '',
   primary key (cod_cancion)
);

/*==============================================================*/
/* Table: decadas                                               */
/*==============================================================*/
create table decadas
(
   cod_decada           int not null auto_increment  comment '',
   nombre_decada        varchar(100) not null  comment '',
   primary key (cod_decada)
);

/*==============================================================*/
/* Table: generos                                               */
/*==============================================================*/
create table generos
(
   cod_genero           int not null auto_increment  comment '',
   nombre_genero        varchar(150) not null  comment '',
   primary key (cod_genero)
);

alter table canciones add constraint fk_cancione_reference_decadas foreign key (cod_decada)
      references decadas (cod_decada) on delete restrict on update cascade;

alter table canciones add constraint fk_cancione_reference_generos foreign key (cod_genero)
      references generos (cod_genero) on delete restrict on update cascade;

alter table canciones add constraint fk_cancione_reference_artistas foreign key (cod_artista)
      references artistas (cod_artista) on delete restrict on update cascade;

