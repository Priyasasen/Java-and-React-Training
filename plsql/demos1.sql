 
create or replace procedure ValidAge(age in  number) as
 
begin
 
 
   if age>=18then
 
DBMS_OUTPUT.PUT_LINE( 'valid ' );
 
else

DBMS_OUTPUT.PUT_LINE( 'Not valid ' );
 
end if;

end;

/
 