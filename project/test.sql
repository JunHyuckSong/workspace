select * from all_tables;




create table projboard(
   bid int primary key,
   writer varchar(20) not null,
   title varchar(30) not null,
   content varchar(50) not null
);