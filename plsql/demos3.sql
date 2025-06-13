set serveroutput on;
CREATE OR REPLACE PROCEDURE FindTotalSalary(salary NUMBER) AS
    bonus NUMBER;
    tot_salary NUMBER;
BEGIN
    IF salary <= 5000 THEN
        bonus := salary * 0.05;
    ELSE
        bonus := salary * 0.1;
    END IF;
    tot_salary := salary + bonus;
    DBMS_OUTPUT.PUT_LINE('Total salary is : ' || tot_salary);
END;
/