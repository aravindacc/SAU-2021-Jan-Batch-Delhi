insert into StudentBasicInformation
(StudentName, StudentSurname, StudentRollNo, StudentAddress, StudentDOB, StudentEmail, StudentClass)
values ('Atul', 'Mehra', 1, '11-C saket Delhi', '2004-01-09', 'atul@abc.com', '10-a'),
('Chirag', 'Vats', 2, 'Laxmi Nagar Delhi', '2003-09-11', 'cvats@abc.com', '10-a'),
('Deepika', 'Kumar', 3, '13 Shahdara Delhi', '2004-06-28', 'dkumar@abc.com', '10-c'),
('Gaurav', 'Bajaj', 4, 'Green Park Delhi', '2002-07-24', 'gauravb@xyz.com', '10-b'),
('Himani', 'Gaur', 5, '102 Dilshad Delhi', '2004-07-10', 'himanigaur@abc.com', '10-b'),
('Isha', 'Patel', 6, '27 INA Delhi', '2004-01-12', 'isha@abc.com', '10-c'),
('Lovely', 'Malhotra', 7, 'karol Bagh Delhi', '2005-02-27', 'lovelym@xyz.com', '10-c'),
('Manish', 'Tripathi', 8, 'Hauz khas Delhi', '2004-10-24', 'manish@abc.com', '10-a'),
('Prerna', 'Mishra', 9, '18-G Saket', '2005-09-06', 'prerna@pqr.com', '10-b'),
('Shruti', 'Jain', 10, '44 jhilmil Delhi', '2003-01-27', 'shrujain@abc.com', '10-a');
select * from StudentBasicInformation;

create table StudentAdmissionPaymentDetails
(
	StudentRollNo int references StudentBasicInformation(StudentRollNo) not null,
	AmountPaid int,
	AmountBalance int, 
	PaymentStatus varchar(15),
	PaymentDate date,
	BankAccount varchar(20),
	NumOfMonths int
);
select * from StudentAdmissionPaymentDetails;

insert into StudentAdmissionPaymentDetails
(StudentRollNo, AmountPaid, AmountBalance, PaymentStatus, PaymentDate, BankAccount, NumOfMonths)
values (1, 6000, 4000, 'half paid', '2021-01-09', 'pnb1234', 3),
(2, 2000, 8000, 'pending', '2020-10-24', 'sbi6789', 1),
(3, 6000, 4000, 'half paid', '2021-01-02', 'axis2346', 3),
(4, 5000, 5000, 'half paid', '2021-01-04', 'pnb4567', 2),
(5, 10000, 0, 'paid', '2021-01-10', 'sbi1236', 6),
(6, 4500, 5500, 'pending', '2020-12-28', 'ici1234', 2),
(7, 8000, 2000, 'half paid', '2021-01-06', 'sbb9876', 4),
(8, 10000, 0, 'paid', '2021-01-07', 'inb0246', 6),
(9, 4000, 6000, 'pending', '2020-12-09', 'axis1234', 2),
(10, 3000, 7000, 'pending', '2020-11-25', 'sbb6077', 2);
select * from StudentAdmissionPaymentDetails;

create table StudentSubjectInformation
(
	SubjectOpted varchar(10) not null,
	StudentRollNo int references StudentBasicInformation(StudentRollNo) not null,
	SubjectTotalMarks int, 
	SubjectObtainedMarks int,
	StudentMarksPercentage int,
	SubjectID int not null
);
select * from StudentSubjectInformation;
insert into StudentSubjectInformation
(SubjectOpted, StudentRollNo, SubjectTotalMarks, SubjectObtainedMarks, SubjectID)
values ('Non med', 1, 70, 55, 008),
('commerce', 2, 100, 83, 003),
('arts', 3, 100, 68, 001),
('medical', 4, 70, 23, 007),
('commerce', 5, 100, 85, 003),
('arts', 6, 100, 98, 001),
('arts', 7, 100, 61, 001),
('medical', 8, 70, 12, 007),
('commerce', 9, 100, 88, 003),
('Non med', 10, 70, 45, 008);
select * from StudentSubjectInformation;
drop table StudentScholarshipInformation;
create table StudentScholarshipInformation
(
	StudentRollNo int references StudentBasicInformation(StudentRollNo) not null,
	ScholarshipName varchar(20),
	ScholarshipDescription varchar(20),
	ScholarshipAmount int,
	ScholarshipCategory varchar(20),
	ScholarshipStatus varchar(10),
	ScholarshipOpted varchar(10)
);
select * from StudentScholarshipInformation;

insert into StudentScholarshipInformation
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipStatus, ScholarshipOpted)
values (1, 'jump-start', 'full career', 10000,'pending', 'yes'),
(2, null, null, 0, null, 'no'),
(3, '10+2', 'high school', 7000, 'paid', 'yes'),
(4, 'jump-start', 'full career', 5000, 'paid', 'yes'),
(5, 'pm scheme', 'finance assitance', 2000, 'pending', 'yes'),
(6, null, null, 0, null, 'no'),
(7, 'pg scholarship', 'higher studies', 15000, 'pending', 'yes'),
(8, '10+2', 'high school', 6000,'paid', 'yes'),
(9, null, null, 0, null, 'no'),
(10, 'college-start', 'govt of india', 3000,'paid', 'yes');

select * from StudentScholarshipInformation where scholarshipAmount > 5000;
select * from StudentScholarShipInformation where scholarshipStatus = 'pending' and scholarshipOpted = 'yes';





select * from StudentSubjectInformation;

update StudentSubjectInformation 
set SubjectTotalMarks = 80
where subjectopted = 'arts';

select * from StudentBasicInformation;
update StudentBasicInformation
set studentSurname= 'Padukone' where studentRollNo = 3;
update StudentBasicInformation
set studentaddress= '18-G saket Delhi' where studentRollNo = 9;
select * from StudentAdmissionPaymentDetails;
update StudentAdmissionPaymentDetails set bankaccount= 'pnb0246' where studentRollNo= 8;
update StudentAdmissionPaymentDetails set numofmonths = 3 where studentRollNo= 4;


create procedure calculatePercentage (
	IN rollno int
	)
	language plpgsql
	as $$
	begin 
		update StudentSubjectInformation
		set StudentMarksPercentage= (subjectobtainedmarks * 100)/ subjecttotalmarks 
		where studentRollNo= rollno;
	end; $$
call calculatepercentage(1);
call calculatepercentage(2);
call calculatepercentage(3);
call calculatepercentage(4);
call calculatepercentage(5);
call calculatepercentage(6);
call calculatepercentage(7);
call calculatepercentage(8);
call calculatepercentage(9);
call calculatepercentage(10);
select * from StudentSubjectInformation;
select * from StudentScholarshipInformation;


create procedure scholarshiptype (
	in rollno int
)
language plpgsql
as $$
declare rn int;
begin
select StudentMarksPercentage into rn from StudentSubjectInformation where Studentrollno= rollno;
update StudentScholarshipInformation
set scholarshipcategory= (case 
	when rn >=75 then 'full-time'
	when rn >=50 then 'one-time' 
	else 'not-applicable'
	end) 
where StudentRollNo= rollno;
end; $$







call scholarshiptype(1);
call scholarshiptype(2);
call scholarshiptype(3);
call scholarshiptype(4);
call scholarshiptype(5);
call scholarshiptype(6);
call scholarshiptype(7);
call scholarshiptype(8);
call scholarshiptype(9);
call scholarshiptype(10);
select * from StudentScholarshipInformation;

select StudentBasicInformation.studentrollno, StudentBasicInformation.studentname, StudentBasicInformation.studentsurname, StudentBasicInformation.studentaddress, StudentBasicInformation.studentdob,
StudentBasicInformation.studentemail, StudentAdmissionPaymentDetails.amountbalance from StudentAdmissionPaymentDetails 
left join StudentBasicInformation on StudentAdmissionPaymentDetails.StudentRollno = StudentBasicInformation.StudentRollno
order by StudentAdmissionPaymentDetails.studentrollno;

create view amtbal as select StudentBasicInformation.studentrollno, StudentBasicInformation.studentname, StudentBasicInformation.studentsurname, StudentBasicInformation.studentaddress, StudentBasicInformation.studentdob,
StudentBasicInformation.studentemail, StudentAdmissionPaymentDetails.amountbalance from StudentAdmissionPaymentDetails 
left join StudentBasicInformation on StudentAdmissionPaymentDetails.StudentRollno = StudentBasicInformation.StudentRollno
order by StudentAdmissionPaymentDetails.studentrollno;

select StudentBasicInformation.studentrollno, StudentBasicInformation.studentname, StudentBasicInformation.studentsurname, StudentBasicInformation.studentaddress, StudentBasicInformation.studentdob,
StudentBasicInformation.studentemail, StudentBasicInformation.studentclass, StudentScholarshipInformation.scholarshipstatus from StudentBasicInformation 
left join StudentScholarshipInformation on StudentScholarshipInformation.StudentRollno = StudentBasicInformation.StudentRollno
where StudentScholarshipInformation.scholarshipstatus = 'pending'
order by StudentScholarshipInformation.studentrollno;

drop procedure balancetobepaid;
create procedure balancetobepaid (IN rollno int)
	language plpgsql
	as $$
	declare amt int;
	begin 
		select amountbalance into amt 
		from StudentAdmissionPaymentDetails where studentrollno= rollno;
		raise notice 'amount to be paid is : %', amt;
	end; $$
call balancetobepaid(1);
call balancetobepaid(2);




select * from StudentBasicInformation where studentRollNo in (
	select studentrollno from studentSubjectInformation 
	order by studentmarkspercentage desc limit 5);
	

insert into studentbasicinformation(studentname, studentsurname, studentrollno, studentaddress, studentdob, studentemail)
values ('sidharth', 'singh', 12, '12-C saket delhi', '2003-02-27', 'sidsingh@pqr.com'),
('umang', 'bisht', 15, '12 CP delhi', '2004-06-07', 'umang@abc.com');
	
	
select * from studentbasicinformation left join studentscholarshipinformation 
on studentbasicinformation.studentrollno = studentscholarshipinformation.studentrollno
order by studentbasicinformation.studentrollno desc;
	
select * from studentbasicinformation right join studentscholarshipinformation 
on studentbasicinformation.studentrollno = studentscholarshipinformation.studentrollno;
	
select * from studentbasicinformation full join studentsubjectinformation 
on studentbasicinformation.studentrollno = studentsubjectinformation.studentrollno
order by studentbasicinformation.studentrollno desc;

select scholarshipcategory, count(*) as total 
from studentscholarshipinformation 
group by scholarshipcategory;


select max(scholarshipcategory) as "max received"
from studentscholarshipinformation ;

select *
from studentsubjectinformation, studentscholarshipinformation
where studentsubjectinformation.studentrollno = studentscholarshipinformation.studentrollno
order by studentsubjectinformation.studentmarkspercentage desc, studentscholarshipinformation.scholarshipcategory desc;



