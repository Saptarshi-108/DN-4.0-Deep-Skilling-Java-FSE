-- create customers table
create table Customers (
  CustomerID number primary key,
  Name varchar2(100),
  Age number,
  Balance number,
  IsVIP varchar2(5)
);
/

-- create loans table
create table Loans (
  LoanID number primary key,
  CustomerID number,
  InterestRate number(5,2),
  DueDate date,
  foreign key (CustomerID) references Customers(CustomerID)
);
/

-- insert sample customers
insert into Customers values (1, 'Alice', 65, 15000, 'FALSE');
insert into Customers values (2, 'Bob', 45, 8000, 'FALSE');
insert into Customers values (3, 'Charlie', 70, 20000, 'FALSE');
insert into Customers values (4, 'David', 30, 9500, 'FALSE');
/

-- insert sample loans
insert into Loans values (101, 1, 7.5, sysdate + 10);
insert into Loans values (102, 2, 6.0, sysdate + 40);
insert into Loans values (103, 3, 8.0, sysdate + 5);
insert into Loans values (104, 4, 9.0, sysdate + 25);
/

commit;

select * from Customers;

begin
  for cust in (select CustomerID from Customers where Age > 60) loop
    update Loans
    set InterestRate = InterestRate - 1
    where CustomerID = cust.CustomerID;
  end loop;
  commit;
end;
/

-- view updated loan interest rates
select * from Loans;

begin
  for cust in (select CustomerID from Customers where Balance > 10000) loop
    update Customers
    set IsVIP = 'TRUE'
    where CustomerID = cust.CustomerID;
  end loop;
  commit;
end;
/

-- view updated vip status
select * from Customers;

begin
  for loan_rec in (
    select L.LoanID, L.CustomerID, C.Name, L.DueDate
    from Loans L
    join Customers C on L.CustomerID = C.CustomerID
    where L.DueDate <= sysdate + 30
  ) loop
    dbms_output.put_line('Reminder: Loan ID ' || loan_rec.LoanID ||
                         ' for Customer ' || loan_rec.Name ||
                         ' is due on ' || to_char(loan_rec.DueDate, 'DD-MON-YYYY'));
  end loop;
end;
/
