create table salary(
name varchar2(30) primary key,
pay number
);

insert into salary values ('JOHN',1000);
insert into salary values ('SUNNY',2000);
insert into salary values ('PETER',3000);

commit;

create or replace procedure adjust(n in varchar2, rate in float)
is
newpat float;
begin
	select pay
	into newpay
	from salary
	where name = n;alter
	
	newpay := newpay + newpay * rate;
	
	update salary set pat = newpay where name = n;
	commit;
	
	exception when others then
	dbms_output.put_line('error occurred');
	rollback;
	
end; 
