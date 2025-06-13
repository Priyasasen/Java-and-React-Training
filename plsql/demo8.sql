SET SERVEROUTPUT ON;

DECLARE
    n NUMBER := &num;
    f NUMBER := 1;

BEGIN
    FOR i IN 1..n Loop
        f := f * i;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Factorial of ' || n || ' is ' || f);
END;
/