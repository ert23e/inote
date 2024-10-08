
-----------------------------------------------------------------------------------------------------------------------------
drop table if exists m_code;
create table m_code (
 code varchar(255) not null,
 name varchar(255),
 PRIMARY KEY (code)
);
-----------------------------------------------------------------------------------------------------------------------------
drop table if exists m_search_condi;
create table m_search_condi (
 id int not null,
  title varchar,
 condi varchar not null,
 PRIMARY KEY (id)
);
-----------------------------------------------------------------------------------------------------------------------------
drop table if exists t_note;
create table t_note(
  note_id int not null,
  note_banch int not null,
  title varchar,
  contents varchar,
  created_at TEXT DEFAULT (DATETIME('now', 'localtime')),
  deleted_at TEXT ,
   PRIMARY KEY (note_id,note_banch)
);


-----------------------------------------------------------------------------------------------------------------------------
drop table if exists t_note_code_map;

create table t_note_code_map(
  note_id int not null,
  code varchar(255) not null,
   PRIMARY KEY (note_id,code)
);

drop view if exists v_note_list;
create view v_note_list as 
 select
    a.note_id
    , a.title
    , a.note_banch
    , a.contents
    , a.created_at
    , a.deleted_at
    , b.tags 
 from
    t_note a 
    left join ( 
        select
            note_id
            , string_agg(b.name, ',') As tags 
        from
            t_note_code_map a 
            left join m_code b 
                on a.code = b.code 
        group by
            a.note_id
    ) b 
        on a.note_id = b.note_id;

-----------------------------------------------------------------------------------------------------------------------------
delete from m_code;
insert into m_code(code, name) values
('001', 'project'),
('001001', 'DALIAS'),
('002', 'task'),
('003', 'memo'),
('004', 'status'),
('005', 'excel'),
('004001', '未対応'),
('004002', '対応中'),
('004003', '完了');

-----------------------------------------------------------------------------------------------------------------------------
delete from t_note;
insert into t_note(note_id, note_banch,title,contents) values ((select ifnull(max(note_id),0)+1 from t_note), 0,'sample','sample contents');
insert into t_note(note_id, note_banch,title,contents) values ((select ifnull(max(note_id),0)+1 from t_note), 0,'sample02','sample02 contents');

-----------------------------------------------------------------------------------------------------------------------------
delete from t_note_code_map;
insert into t_note_code_map(note_id,code) values
(1,'001001'),
(1,'004001'),
(1,'004'),
(1,'003'),
(2,'005'),
(2,'002');
-----------------------------------------------------------------------------------------------------------------------------


