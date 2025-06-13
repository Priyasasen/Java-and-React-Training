declare
  n number := &n;
  i number;
begin
  if n <= 1 then
    dbms_output.put_line('not prime');
    return;
  end if;
  for i in 2..n-1 loop
    if mod(n,i)=0 then
      dbms_output.put_line('not prime');
      return;
    end if;
  end loop;
  dbms_output.put_line('prime');
end;
/