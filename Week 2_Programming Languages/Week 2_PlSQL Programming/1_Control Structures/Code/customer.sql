--Scenario 1
BEGIN
  FOR c IN (
    SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    IF (MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = c.LoanID;
    END IF;
  END LOOP;
  
  COMMIT;
END;
/

--Scenario 2
ALTER TABLE Customers ADD (IsVIP VARCHAR2(5));
BEGIN
  FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF c.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = c.CustomerID;
    ELSE
      UPDATE Customers
      SET IsVIP = 'FALSE'
      WHERE CustomerID = c.CustomerID;
    END IF;
  END LOOP;

  COMMIT;
END;
/

--Scenario 3
SET SERVEROUTPUT ON;
BEGIN
  FOR l IN (
    SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || l.Name || 
      ' (CustomerID: ' || l.CustomerID || ') has a loan (LoanID: ' || l.LoanID || 
      ') due on ' || TO_CHAR(l.EndDate, 'YYYY-MM-DD') );
  END LOOP;
END;
/