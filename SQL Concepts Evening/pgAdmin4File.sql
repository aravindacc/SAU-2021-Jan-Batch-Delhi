create database Student;
create table StudentBasicInformation(
	StudentName varchar(20),
	StudentSurName varchar(10),
	StudentRollNo int primary key,
	StudentAddress varchar(50),
	StudentEmail varchar(20),
	DOB varchar(30),
	StudentBranch varchar(20)	
);



Insert into StudentBasicInformation(StudentName,StudentSurname,StudentRollNo,StudentAddress,StudentEmail,DOB,StudentBranch)
 VALUES
 ('Abhishek','Sah',1,'Delhi','abc@xyz','23-01-1998','CS'),
 ('Aman','Kumar',2,'Mumbai','abc1@xyz','03-01-1997','CS'),
 ('Shivam','Bharti',3,'Delhi','abc2@xyz','23-01-1998','ME'),
 ('Alok','Kumar',4,'Mumbai','abc3@xyz','03-01-1997','CS'),
 ('Naman','Grover',5,'Delhi','abc4@xyz','23-01-1998','IT'),
 ('Chirag','Sharma',6,'Mumbai','abc5@xyz','03-01-1997','EE'),
 ('Arvind','Kumar',7,'Delhi','abc6@xyz','23-01-1998','ME'),
 ('Anshul','Garg',8,'Mumbai','abc7@xyz','03-01-1997','CS'),
 ('Rahul','Gupta',9,'Delhi','abc8@xyz','23-01-1998','IT'),
 ('Aayush','Jha',10,'Mumbai','abc9@xyz','03-01-1997','CS'),
 ('Abhinav','Chauhan',11,'Delhi','abc0@xyz','23-01-1998','ME'),
 ('Saket','Singh',12,'Mumbai','abc1@xyz','23-01-1998','CS');


Select * from StudentBasicInformation;

create table StudentAdmissionPaymentDetails(
	StudentRollNo int primary key references StudentBasicInformation(StudentRollNO),
	AmountPaid int,
	AmountBalance int,
	ModeOfPayment varchar(20),
	TransactionID varchar(20),
	BankName varchar(20),
	BankAccountNo varchar(20)
);

Insert into StudentAdmissionPaymentDetails(StudentRollNo,AmountPaid,AmountBalance,ModeOfPayment,TransactionID,BankName,BankAccountNo)
 VALUES
 (1,4000,1000,'RTGS','TXN123','SBI','A12'),
 (2,2000,3000,'NEFT','TXN223','HDFC','B12'),
 (3,3000,2000,'OFFLINE','TXN323','AXIS','C12'),
 (4,3000,2000,'NEFT','TXN423','HDFC','D12'),
 (5,3000,2000,'NEFT','TXN523','HDFC','t12'),
 (6,3000,2000,'NEFT','TXN623','AXIS','B12'),
 (7,3000,2000,'NEFT','TXN723','HDFC','T12'),
 (8,3000,2000,'RTGS','TXN823','SBI','Y12'),
 (9,3000,2000,'NEFT','TXN923','SBI','Z12'),
 (10,3000,2000,'RTGS','TXN263','AXIS','O12'),
 (11,3000,2000,'RTGS','TXN193','ICICI','P12'),
 (12,3000,2000,'OFFLINE','TXN153','ICICI','W12');
 
Select * from StudentAdmissionPaymentDetails;

create table StudentSubjectInformation(
	SubjectOpted varchar(20),
	StudentRollNo int references StudentBasicInformation(StudentRollNo),
	StudentTotalMarks int,
	SubjectObtainedMarks int,
	StudentMarksPercentage decimal(4,2),
	Grade varchar(2)
);

Insert into StudentSubjectInformation(SubjectOpted,StudentRollNo,StudentTotalMarks,SubjectObtainedMarks,StudentMarksPercentage,Grade)
 VALUES
 ('Maths',1,100,67,75.72,'A'),
 ('Physics',2,100,60,70.65,'B'),
 ('Chemistry',3,100,87,85.20,'A'),
 ('Biology',4,100,57,50.65,'D'),
 ('Chemistry',5,100,74,75.27,'A'),
 ('Biology',6,100,65,75.98,'B'),
 ('Maths',7,100,60,85.28,'A'),
 ('Chemistry',8,100,67,75.10,'A'),
 ('Maths',9,100,72,75.78,'A'),
 ('Chemistry',10,100,64,65.06,'C'),
 ('Biology',11,100,88,86.24,'A'), 
 ('Maths',12,100,87,80.78,'A');
 
 Select * from StudentSubjectInformation;
 

create table StudentScholarshipInformation(
	StudentRollNo int  primary key references StudentBasicInformation(StudentRollNO),
	ScholarshipName varchar(20),
	ScholarshipDescription varchar(30),
	ScholarshipAmount int,
	ScholarshipCategory varchar(20)
);

 Insert into StudentScholarshipInformation(StudentRollNo,ScholarshipName,ScholarshipDescription,ScholarshipAmount,ScholarshipCategory)
 VALUES
 (1,'Education','For Education',6000,'Study'),
 (2,'Finance','For Finance',4000,'Living'),
 (3,'Fellowship','For Fellowship',3000,'Study'),
 (4,'Finance','For Finance',8000,'Study'),
 (5,'Finance','For Finance',9000,'Study'),
 (6,'Education','For Education',2000,'Study'),
 (7,'Education','For Education',8000,'Study'),
 (8,'Finance','For Finance',5000,'Study'),
 (9,'Finance','For Finance',7000,'Study'),
 (10,'Fellowship','For Fellowship',6000,'Study'),
 (11,'Education','For Education',9000,'Study'),
 (12,'Fellowship','For Fellowship',4000,'Study');
 
 Select * from StudentScholarshipInformation;


 







 
 Update StudentBasicInformation set DOB = '01-10-1999' where StudentRollNo = 3;
 Update StudentBasicInformation set StudentBranch = 'IT' where StudentRollNo = 2;
 Update StudentAdmissionPaymentDetails set ModeOfPayment = 'RTGS' where StudentRollNo = 4;
 Update StudentSubjectInformation set SubjectOpted = 'DS-Algo' where StudentRollNo = 6 ;
 Update StudentSubjectInformation set SubjectOpted = 'DBMS' where StudentRollNo = 10;


Select * from StudentBasicInformation;


Select * from StudentAdmissionPaymentDetails;


Select * from StudentSubjectInformation;
 
 

 

Select * from StudentBasicInformation SB JOIN StudentScholarshipInformation SS ON 
SB.StudentRollNo = SS.StudentRollNo where SS.ScholarshipAmount>=5000;
   
Create or replace procedure percentage() language plpgsql as $$
begin 
update StudentSubjectInformation
set StudentMarksPercentage = (SubjectObtainedMarks/StudentTotalMarks)*100;
commit;
end;$$

Create or replace procedure category() language plpgsql as $$
begin 
update StudentScholarshipInformation
set StudentMarksPercentage = (SubjectObtainedMarks/StudentTotalMarks)*100;
commit;
end;$$

Create View balanceamount AS Select basic.StudentName, basic.StudentRollNo, payment.AmountBalance
		 
Select StudentName from StudentBasicInformation where StudentRollNo Not IN (Select StudentRollNo from StudentScholarshipInformation);


Select * from StudentSubjectInformation order by StudentMarksPercentage desc limit 5;

Select ScholarshipCategory, count(*) from StudentScholarshipInformation group by ScholarshipCategory;

Select ScholarshipCategory, count(*) as noOfStudents from StudentScholarshipInformation
group by ScholarshipCategory order by count(*) desc limit 1;

Select * from StudentScholarshipInformation as ssi inner join StudentSubjectInformation as ssinf 
on ssinf.StudentRollNo = ssi.StudentRollNo order by ssi.ScholarshipAmount desc,
ssinf.StudentMarksPercentage desc;



























