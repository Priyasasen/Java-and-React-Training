set serveroutput on;
 
declare
 
salary number := &salary;
bonus number;
total_salary number;
 
begin
 
bonus := salary * 0.05;
 
total_salary := bonus + salary;
 
dbms_output.put_line('Base salary is : ' || salary);
dbms_output.put_line('Bonus is : ' || bonus);
dbms_output.put_line('Total salary is : ' || total_salary);
 
end;
/