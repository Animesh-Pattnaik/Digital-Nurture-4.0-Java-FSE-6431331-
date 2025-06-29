--Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = acc.Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;
  END LOOP;

  COMMIT;
END;
/

--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_Department IN VARCHAR2,
  p_BonusPercent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_BonusPercent/100)
  WHERE Department = p_Department;

  COMMIT;
END;
/

BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/

--Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_FromAccountID IN NUMBER,
  p_ToAccountID   IN NUMBER,
  p_Amount        IN NUMBER
) AS
  v_FromBalance NUMBER;
BEGIN
  SELECT Balance INTO v_FromBalance
  FROM Accounts
  WHERE AccountID = p_FromAccountID
  FOR UPDATE;

  IF v_FromBalance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
  ELSE
    UPDATE Accounts
    SET Balance = Balance - p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts
    SET Balance = Balance + p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_ToAccountID;

    COMMIT;
  END IF;
END;
/

BEGIN
  TransferFunds(1, 2, 200);
END;
/