select * from all_tables;

create table test(
	a int,
	b varchar(10)
);

insert into test values(10,'티모');
insert into test values(20,'소나');
insert into test values(30,'타릭');
insert into test values(40,'자이라');
insert into test values(50,'징크스');
insert into test values(60,'바이');

select * from test;

select * from TEST where b like '%소%';

drop table test;
