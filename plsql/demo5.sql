set serveroutput on;
 
declare
 
salary number := &salary;
bonus number;
total_salary number;
 
begin

if salary<=5000 then
  bonus:=salary*5/100;
else
  bonus:=salary*10/100;
end if;
 

 
total_salary := bonus + salary;
 
dbms_output.put_line('Your base salary is : ' || salary);
dbms_output.put_line('Bonus is : ' || bonus);
dbms_output.put_line('Total salary is : ' || total_salary);
 
end;
/