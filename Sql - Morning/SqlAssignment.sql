create database Student;

create table
StudentBasicInformation(
	StudentName varchar(30),
	StudentSurname varchar(20),
	StudentRollNo int primary key,
	StudentAddress varchar(30),
	AppledForScholarship boolean
);

create table
StudentAdmissionPaymentDetails(
	StudentRollNo int primary key,
	AmountPaid int,
	AmountBalance int,
    Foreign key(StudentRollNo) references StudentBasicInformation(StudentRollNo)
);

create table
StudentSubjectInformation(
	SubjectOpted varchar(20),
	StudentRollNo int primary key,
    SubjectTotalMarks int,
	SubjectObtainedMarks int,
	StudentMarksPercentage float,
    Foreign key(StudentRollNo) references StudentBasicInformation(StudentRollNo)
);

create table
SubjectScholarshipInformation(
	StudentRollNo int primary key,
	ScholarshipName varchar(20),
	ScholarshipDescription varchar(30),
	ScholarshipAmount int,
	ScholarshipCategory varchar(30),
    Foreign key(StudentRollNo) references StudentBasicInformation(StudentRollNo)
);

--ScreenShots of all the tables are present in the screenshot folder

-- I updated 5 records of StudentBasicInformation Table

update studentbasicinformation set StudentName='Anirudh',StudentSurname='Mittal' where StudentRollNo=102;
update studentbasicinformation set StudentName='Amar',StudentSurname='Shrivastav' where StudentRollNo=103;
update studentbasicinformation set StudentName='Rahul',StudentSurname='Dubey' where StudentRollNo=104;
update studentbasicinformation set StudentName='Deewan',StudentSurname='Mittal' where StudentRollNo=105;
update studentbasicinformation set StudentName='Ajeet',StudentSurname='Singh' where StudentRollNo=106;

--Screeshot of this updated table is also present in the ScreenShots folder

--Q-Select the student details records who has received the scholarship more than 5000Rs/- 
select * from studentbasicinformation where StudentRollNo in (select StudentRollNo from subjectscholarshipinformation where ScholarshipAmount>5000);

--Select the students who opted for scholarship but has not got the scholarship
select * from studentbasicinformation where AppledForScholarship = 1 and StudentRollNo not in (select StudentRollNo from subjectscholarshipinformation);

--Fill in data for the percentage column i.e. StudentMarksPercentage in the table StudentSubjectInformation by creating and using the stored procedure created
DELIMITER //
create procedure calculate_percentage()
begin
DECLARE rollNo int;
DECLARE finished INTEGER DEFAULT 0;
DECLARE totalMarks int;
DECLARE marksObtained int;
DECLARE percentage float4;
declare c_rollno cursor for select StudentRollNo from studentsubjectinformation;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
open c_rollno;
getroolno:loop
FETCH c_rollno INTO rollNo;
		IF finished = 1 THEN 
			LEAVE getroolno;
		END IF;
		
        select SubjectTotalMarks, SubjectObtainedMarks  into totalMarks, marksObtained from studentsubjectinformation where StudentRollNo=rollNo;
        
        set percentage = (marksObtained*100.0/totalMarks);
        
        update studentsubjectinformation set StudentMarksPercentage=percentage where StudentRollNo=rollNo;
        
	END LOOP getroolno;
	CLOSE c_rollno;
end //
DELIMITER ;

call calculate_percentage();

--Create the View which shows balance amount to be paid by the student along with the student detailed information (use join)
create view StudentBalanceDetails as select a.StudentRollNo,b.StudentName,b.StudentSurname,b.StudentAddress,b.StudentContactNo,a.AmountBalance from 
studentadmissionpaymentdetails a inner join studentbasicinformation b on a.StudentRollNo=b.StudentRollNo; 

--Get the details of the students who haven’t got any scholarship (use joins/subqueries)
select * from studentbasicinformation where StudentRollNo not in (select StudentRollNo from subjectscholarshipinformation);

--Create Stored Procedure which will be return the amount balance to be paid by the student as per the student roll number passed through the stored procedure as the input
DELIMITER //
create procedure getBalance(IN rollno int, OUT Balance int)
begin
select AmountBalance into Balance from studentadmissionpaymentdetails where StudentRollNo=rollno;
end //
DELIMITER ;

call getBalance(107,@Balance);
select @Balance as Balance;

--Retrieve the top five student details as per the StudentMarksPercentage values
select a.StudentRollNo,a.StudentName,a.StudentSurname,a.StudentAddress,a.StudentContactNo,b.StudentMarksPercentage
from studentbasicinformation a inner join studentsubjectinformation b on a.StudentRollNo=b.StudentRollNo order by b.StudentMarksPercentage desc limit 5;

--Try to use all the three types of join learned today in a relevant way, and explain the same 
--why you thought of using that particular join for your selected scenarios (try to cover relevant and real time scenarios for all the three studied joins)

select a.*,b.studentMarksPercentage from studentinfo a left join studentSubjectInfo b on a.RollNo=b.RollNo where b.studentMarksPercentage>90;

select a.Name,b.* from studentinfo a right join studentAdmissionPay b on a.RollNo=b.RollNo where b.AmountBalance>25000;

select a.*,b.scholarshipAmount from studentinfo a inner join subjectScholarshioInfo b on a.RollNo=b.RollNo where b.scholarshipAmount>50000;


--Get the count of the Scholarship category which is highly been availed by the students,i.e.  
--get the count of the total number of students corresponding to the each scholarships category
select ScholarshipCategory,count(*) as Total_Students from subjectscholarshipinformation group by ScholarshipCategory;

--Along with the assignment no. 17 try to retrieve the maximum used scholarship category
select ScholarshipCategory,count(*) as Total_Students from subjectscholarshipinformation group by ScholarshipCategory 
having count(*) = (select max(maxcount) from (select count(*) as maxcount from subjectscholarshipinformation group by ScholarshipCategory) as newTable);

