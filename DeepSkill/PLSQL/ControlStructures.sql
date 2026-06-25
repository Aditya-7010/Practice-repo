

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
EndDate DATE,
FOREIGN KEY (CustomerID)
REFERENCES Customers(CustomerID)
);


INSERT INTO Customers
VALUES (11, 'Aditya Sharma',
TO_DATE('1958-03-12','YYYY-MM-DD'),
18000, SYSDATE);

INSERT INTO Customers
VALUES (76, 'Priya Singh',
TO_DATE('1994-08-22','YYYY-MM-DD'),
9000, SYSDATE);

INSERT INTO Loans
VALUES (1001, 11, 5000, 10, SYSDATE, SYSDATE + 25);

INSERT INTO Loans
VALUES (1002, 76, 7000, 8, SYSDATE, SYSDATE + 45);

COMMIT;



-- SCENARIO 1

DECLARE
v_customer_age NUMBER;
BEGIN
FOR customer_rec IN (
SELECT CustomerID, DOB
FROM Customers
)
LOOP
v_customer_age :=
FLOOR(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);

```
    IF v_customer_age > 60 THEN
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = customer_rec.CustomerID;
    END IF;
END LOOP;

COMMIT;
```

END;
/


-- SCENARIO 2

ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

BEGIN
FOR customer_rec IN (
SELECT CustomerID, Balance
FROM Customers
)
LOOP
IF customer_rec.Balance > 10000 THEN
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE CustomerID = customer_rec.CustomerID;
ELSE
UPDATE Customers
SET IsVIP = 'FALSE'
WHERE CustomerID = customer_rec.CustomerID;
END IF;
END LOOP;

```
COMMIT;
```

END;
/


-- SCENARIO 3

SET SERVEROUTPUT ON;

BEGIN
FOR loan_rec IN (
SELECT LoanID,
CustomerID,
EndDate
FROM Loans
WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
)
LOOP
DBMS_OUTPUT.PUT_LINE(
'Reminder: Loan ' || loan_rec.LoanID ||
' for Customer ' || loan_rec.CustomerID ||
' is due on ' ||
TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY')
);
END LOOP;
END;
/
