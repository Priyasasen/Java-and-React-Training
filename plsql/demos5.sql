create or replace function factorial(n in number) return number is
    result number := 1;
    i number;
begin
if n < 0 then
return 0; 
end if;
for i in 1..n loop
result := result * i;
end loop;
return result;
end;
/