-- create accounts table
create table Accounts (
  AccountID number primary key,
  CustomerName varchar2(100),
  AccountType varchar2(20),
  Balance number
);
/

-- create employees table
create table Employees (
  EmployeeID number primary key,
  Name varchar2(100),
  Department varchar2(50),
  Salary number
);
/

-- insert sample accounts
insert into Accounts values (1, 'Alice', 'Savings', 10000);
insert into Accounts values (2, 'Bob', 'Savings', 15000);
insert into Accounts values (3, 'Charlie', 'Current', 20000);
insert into Accounts values (4, 'David', 'Savings', 8000);
/

-- insert sample employees
insert into Employees values (101, 'John', 'HR', 50000);
insert into Employees values (102, 'Jane', 'Finance', 60000);
insert into Employees values (103, 'Mark', 'HR', 55000);
insert into Employees values (104, 'Lucy', 'IT', 70000);
/

commit;
select * from Accounts;
select * from Employees;

-- scenario 1: process monthly interest for savings accounts
create or replace procedure ProcessMonthlyInterest as
begin
  update Accounts
  set Balance = Balance + (Balance * 0.01)
  where AccountType = 'Savings';
end ProcessMonthlyInterest;
/

-- call the procedure
exec ProcessMonthlyInterest;
select * from Accounts;

-- scenario 2: bonus for employees in a department
create or replace procedure UpdateEmployeeBonus(
  dept_name in varchar2,
  bonus_pct in number
) as
begin
  update Employees
  set Salary = Salary + (Salary * bonus_pct / 100)
  where Department = dept_name;
end UpdateEmployeeBonus;
/

-- call example: 10% bonus for HR
exec UpdateEmployeeBonus('HR', 10);
select * from Employees;

-- scenario 3: transfer funds between accounts
create or replace procedure TransferFunds(
  source_id in number,
  target_id in number,
  amount in number
) as
  insufficient_balance exception;
begin
  declare
    src_balance number;
  begin
    select Balance into src_balance from Accounts where AccountID = source_id;

    if src_balance < amount then
      raise insufficient_balance;
    else
      update Accounts set Balance = Balance - amount where AccountID = source_id;
      update Accounts set Balance = Balance + amount where AccountID = target_id;
    end if;
  end;
exception
  when insufficient_balance then
    dbms_output.put_line('Transfer failed: Insufficient balance in source account.');
  when others then
    dbms_output.put_line('Transfer failed: ' || sqlerrm);
end TransferFunds;
/

-- enable output and call the procedure
exec TransferFunds(1, 2, 2000);
select * from Accounts;
