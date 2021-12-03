create table note(
num number primary key,
name varchar2(30) not null,
passwd varchar2(10) not null,
subject varchar2(60) not null,
content varchar2(4000) not null,
email varchar2(60), 
reg_date date not null
);
create sequence note_seq;