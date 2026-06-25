-- CREATE TABLES

CREATE TABLE Customers (
CustomerID NUMBER PRIMARY KEY,
Name VARCHAR2(100),
DOB DATE,
Balance NUMBER,
LastModified DATE
);

CREATE TABLE Loans (
LoanID NUMBER PRIMARY KEY,
CustomerID NUMBER,
LoanAmount NUMBER,
InterestRate NUMBER,
StartDate DATE,
EndDate DATE
);

CREATE TABLE Accounts (
AccountID NUMBER PRIMARY KEY,
CustomerID NUMBER,
AccountType VARCHAR2(20),
Balance NUMBER
);

CREATE TABLE Employees (
EmployeeID NUMBER PRIMARY KEY,
Name VARCHAR2(100),
Department VARCHAR2(50),
Salary NUMBER
);

 -- SAMPLE DATA

INSERT INTO Customers
VALUES (42, 'Rohan Gupta',
TO_DATE('1958-04-15','YYYY-MM-DD'),
18000, SYSDATE);

INSERT INTO Customers
VALUES (45, 'Sneha Verma',
TO_DATE('1996-09-20','YYYY-MM-DD'),
9000, SYSDATE);

INSERT INTO Loans
VALUES (1001, 42, 5000, 10, SYSDATE, SYSDATE + 20);

INSERT INTO Loans
VALUES (1002, 45, 7000, 8, SYSDATE, SYSDATE + 40);

INSERT INTO Accounts
VALUES (1, 42, 'Savings', 12000);

INSERT INTO Accounts
VALUES (2, 45, 'Savings', 6000);

INSERT INTO Employees
VALUES (1, 'Aditya', 'IT', 55000);

INSERT INTO Employees
VALUES (2, 'Priya', 'HR', 60000);

COMMIT;


-- PROCEDURE 1 : MONTHLY INTEREST

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
UPDATE Accounts
SET Balance = Balance * 1.01
WHERE AccountType = 'Savings';

```
COMMIT;

DBMS_OUTPUT.PUT_LINE('Monthly interest applied.');
```

END;
/

BEGIN
ProcessMonthlyInterest;
END;
/

 -- PROCEDURE 2 : EMPLOYEE BONUS

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
p_department IN VARCHAR2,
p_bonus_percent IN NUMBER
)
AS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_bonus_percent / 100)
WHERE Department = p_department;

```
COMMIT;

DBMS_OUTPUT.PUT_LINE('Employee bonus updated.');
```

END;
/

BEGIN
UpdateEmployeeBonus('IT', 10);
END;
/


 -- PROCEDURE 3 : FUND TRANSFER

CREATE OR REPLACE PROCEDURE TransferFunds(
p_from_account IN NUMBER,
p_to_account IN NUMBER,
p_amount IN NUMBER
)
AS
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = p_from_account;

```
IF v_balance >= p_amount THEN

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Fund transfer completed successfully.');

ELSE
    DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient balance.');
END IF;
```

END;
/

BEGIN
TransferFunds(1, 2, 500);
END;
/
