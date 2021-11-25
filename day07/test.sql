create table webtoon(
	day varchar(10),
	webtoon_name varchar(200)
);

select * from WEBTOON;

insert into WEBTOON values('요일','웹툰명');

delete from WEBTOON where day = 'mon';
drop table webtoon;