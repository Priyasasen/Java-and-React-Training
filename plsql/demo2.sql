SET SERVEROUTPUT ON;
 
DECLARE
  name VARCHAR2(20) := 'Asha Gupta';
  age NUMBER(3) := 21;
  department VARCHAR(30):='CSE';
BEGIN
  DBMS_OUTPUT.PUT_LINE('Your name is ' || name);
  DBMS_OUTPUT.PUT_LINE('Your age is ' || age);
  DBMS_OUTPUT.PUT_LINE('Your department is ' || department);
END;
/