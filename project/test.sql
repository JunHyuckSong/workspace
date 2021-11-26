select * from all_tables;




create table projboard(
   bid int primary key,
   writer varchar(20) not null,
   title varchar(30) not null,
   content varchar(50) not null
);

select * from PROJBOARD;

insert into PROJBOARD values (1,'바이','아케인','넷플릭스오리지널')
delete from PROJBOARD where bid = 1 


create table login(
	id varchar(10),
	password int 
);

select * from login;
insert into login values ('westjun49', 1234)
insert into login values ('black237w', 1234)


