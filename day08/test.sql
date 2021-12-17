select * from board;

create table board(
	bid int primary key,
	writer varchar(20) not null,
   content varchar(50) not null 
);

