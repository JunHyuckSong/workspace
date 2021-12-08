select * from all_tables;

create table member(
	mid varchar(20) primary key,
	mpw varchar(20) not null,
	mname varchar(15) not null
);


create table snsboard(
	bid int primary key,
	mid varchar(20) not null,
	msg varchar(50) not null,
	favcnt int default 0 
);

create table reply(
	rid int primary key,
	bid int not null,
	mid varchar(20) not null,
	rmsg varchar(30) not null,
	constraint board_fk foreign key(bid) references snsboard(bid) on delete cascade
);

drop table memver;

select * from snsboard





