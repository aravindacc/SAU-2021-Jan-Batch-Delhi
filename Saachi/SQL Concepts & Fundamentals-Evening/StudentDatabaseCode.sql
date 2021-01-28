/*	Submitted by- Saachi
	Email- saachi.r@accolitedigital.com
*/

/*1. Creating Student Database*/
create database Student;

/*Using Database Student for creating tables and performing operations*/
use Student;

/*2. Creating Required tables*/
/*Create Course details table*/
create table CourseDetails(
	CourseId enum("IP101","IP102","IP103","IP104","IP105") primary key,
    CourseName varchar(20) not null,
    CourseFee decimal(8,2) not null
);

/*Create Subject details table*/
create table SubjectDetails(
	SubjectCode int primary key,
    SubjectName varchar(20) not null
);

/*Create Student Basic Information details table*/
create table StudentBasicDetails(
	FirstName varchar(20) not null,
	LastName varchar(20),
    RollNo int primary key,
    Address varchar(255) not null,
    Email varchar(40),
    ContactNo char(10) not null,
    DOB date not null,
    Gender enum("Male", "Female", "Unknown"),
    ScholarshipOpted bool,
	AdmissionDate date not null,
	CourseId enum("IP101","IP102","IP103","IP104","IP105") not null,
    foreign key(CourseId) references CourseDetails(CourseId),
    constraint ContactNo check (ContactNo not like '%[^0-9]%')
);

/*Create Student Admission Payment Information details table*/
create table StudentPaymentDetails(
	ReceiptId varchar(6) primary key,
    RollNo int not null,
    CourseId enum("IP101","IP102","IP103","IP104","IP105") not null,
    AmountPaid decimal(8,2) not null,
    PaymentMode enum("Online","Offline"),
    PaymentDate date not null,
    foreign key(RollNo) references StudentBasicDetails(RollNo),
    foreign key(CourseId) references CourseDetails(CourseId)
);

/*Create Student Subject Information details table*/
create table StudentSubjectDetails(
	SubjectCode int not null,
    CourseId enum("IP101","IP102","IP103","IP104","IP105") not null,
    RollNo int not null,
    TotalMarks decimal(5,2) default 0.00,
    MarksObtained decimal(5,2) default 0.00,
    primary key(Rollno,SubjectCode),
    foreign key(SubjectCode) references SubjectDetails(SubjectCode),
    foreign key(RollNo) references StudentBasicDetails(RollNo),
    foreign key(CourseId) references CourseDetails(CourseId)
);

/*Create Student Scholarship Information details table*/
create table StudentScholarshipDetails(
	ScholarshipId int primary key,
    ScholarshipName varchar(100) not null,
    RollNo int not null,
    ScholarshipDesc varchar(300),
    FundingOrgName varchar(50),
    Amount decimal not null,
    Category varchar(100),
    unique key(Rollno, ScholarshipId),
    foreign key(RollNo) references StudentBasicDetails(RollNo)
);

/*3. and 4. Inserting Values in tables*/

insert into CourseDetails values("IP101", "PCM", 44000);
insert into CourseDetails values("IP102", "Arts", 25000);
insert into CourseDetails values("IP103", "Humanities", 35000);
insert into CourseDetails values("IP104", "PCMB",54000);
insert into CourseDetails values("IP105", "Commerce", 40000);

Select * from CourseDetails;


insert into SubjectDetails values("201", "Physics");
insert into SubjectDetails values("202", "Chemsitry");
insert into SubjectDetails values("203", "Maths");
insert into SubjectDetails values("204", "English");
insert into SubjectDetails values("205", "History");
insert into SubjectDetails values("206", "Biology");
insert into SubjectDetails values("207", "PoliticalScience");
insert into SubjectDetails values("208", "Hindi");
insert into SubjectDetails values("209", "IT");
insert into SubjectDetails values("210", "Accounts");
insert into SubjectDetails values("211", "Economics");
insert into SubjectDetails values("212", "Psychology");

select * from SubjectDetails;


insert into StudentBasicDetails values('Sachin','Kumar', 2030, '47-JanakPuri Delhi', 'sachin@gmail.com',9874658381, '1999-03-27','Male',true,'2016-03-16','IP101');
insert into StudentBasicDetails values('Sagar','Kumar', 2031, '44/23 GTB Delhi', 'sagar@gmail.com',9834568381, '1999-04-17','Male',false,'2016-05-1','IP101');
insert into StudentBasicDetails values('Aachal','Pawar', 2032, '06/19 JanakPuri Delhi', 'aachal@gmail.com',9874645333, '1998-05-21','Female',true,'2015-03-16','IP103');
insert into StudentBasicDetails values('Rohit','Sharma', 2033, '51, Isha Puram Ghaziabad', 'rohit@gmail.com',9999258381, '1999-03-06','Male',true,'2015-04-16','IP102');
insert into StudentBasicDetails values('Tej','Gupta', 2034, 'Noida', 'tej@gmail.com',9723658381, '1997-06-27','Male',false,'2015-02-16','IP102');
insert into StudentBasicDetails values('Abhishek','Kumar', 2035, '16-Kalash nagar Delhi', 'abhi@gmail.com',9823558394, '1998-05-11','Male',true,'2016-03-25','IP105');
insert into StudentBasicDetails values('Komal','Tiwari', 2036, 'GTB Delhi', 'komal@gmail.com',9945658385, '1998-09-07','Female',false,'2015-06-06','IP104');
insert into StudentBasicDetails values('Payal','Khanna', 2037, 'Noida', 'payal@gmail.com',9896758381, '1998-08-27','Female',true,'2016-03-16','IP103');
insert into StudentBasicDetails values('Aarushi','Tomar', 2038, 'Ghaziabad', 'aarushi@gmail.com',9974658374, '1997-04-27','Female',true,'2016-04-16','IP104');
insert into StudentBasicDetails values('Raghav','Tandon', 2039, '32-JanakPuri Delhi', 'raghav@gmail.com',9955658384, '1999-03-05','Male',true,'2016-03-16','IP105');

select * from StudentBasicDetails;

insert into StudentPaymentDetails values('2S4T6',2033,'IP102',5000,'Online', '2015-05-05');
insert into StudentPaymentDetails values('324T6',2032,'IP103',5000,'Online', '2016-10-05');
insert into StudentPaymentDetails values('6Y4T6',2031,'IP101',5000,'Online', '2016-09-05');
insert into StudentPaymentDetails values('8E4T6',2030,'IP101',23000,'Online', '2017-04-05');
insert into StudentPaymentDetails values('94WT6',2036,'IP104',3000,'Offline', '2018-05-05');
insert into StudentPaymentDetails values('24BT6',2034,'IP102',6400,'Online', '2016-05-05');
insert into StudentPaymentDetails values('2F8T6',2037,'IP103',15000,'Offline', '2017-06-07');
insert into StudentPaymentDetails values('6S0T6',2035,'IP105',5000,'Online', '2018-05-04');
insert into StudentPaymentDetails values('2N7T6',2039,'IP105',5000,'Online', '2016-05-05');
insert into StudentPaymentDetails values('75RT6',2038,'IP104',5000,'Online', '2018-04-05');

select * from StudentPaymentDetails;

insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('201','IP101',2030,100,67);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('203','IP101',2030,200,120);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('211','IP105',2035,100,87);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('204','IP103',2032,70,55);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('202','IP104',2036,150,67);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('212','IP103',2037,100,96);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('202','IP101',2031,150,90);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('204','IP102',2033,70,59);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('205','IP102',2034,100,69);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('206','IP104',2038,100,86);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('203','IP104',2038,200,135);
insert into StudentSubjectDetails (SubjectCode,CourseId,RollNo,TotalMarks,MarksObtained) values('202','IP101',2030,150,80);

select * from StudentSubjectDetails;

insert into StudentScholarshipDetails values(123,'KP DasGupta Scholarship', 2033, 'Given to outstanding Student','Maitri',4000,'Education');
insert into StudentScholarshipDetails values(912,'Kanya Vidhya Scholarship', 2032, 'Given to meritorious girl child','Maitri',6000,'Girl Child');
insert into StudentScholarshipDetails values(436,'Junior Research Scholarship', 2033, 'Given for research','RajivGandhi',60000,'Higher Education');
insert into StudentScholarshipDetails values(789,'Coders Scholarship', 2038, 'Given to technolgy enthusiast','Maitri',30000,'Technology');
insert into StudentScholarshipDetails values(425,'KP DasGupta Scholarship', 2035, 'Given to outstanding Student','Maitri',4000,'Education');
insert into StudentScholarshipDetails values(764,'Coders Scholarship', 2039, 'Given to technolgy enthusiast','Maitri',30000,'Technology');
insert into StudentScholarshipDetails values(347,'KP DasGupta Scholarship', 2032, 'Given to outstanding Student','Maitri',4000,'Education');
insert into StudentScholarshipDetails values(453,'Junior Research Scholarship', 2038, 'Given for research','RajivGandhi',60000,'Higher Education');
insert into StudentScholarshipDetails values(421,'KP DasGupta Scholarship', 2030, 'Given to outstanding Student','Maitri',4000,'Education');
insert into StudentScholarshipDetails values(346, 'Merit Scholarship', 2030 , 'Given to student with highest marks ', 'University', 80000, 'Merit');

select * from StudentScholarshipDetails;

/*5. Upadating values based on certain conditions in tables*/

update StudentBasicDetails
set Address='97-Model Town Delhi'
where Rollno=2036;

update StudentBasicDetails
set ContactNo=8799687234
where Rollno=2031;

update StudentSubjectDetails
set MarksObtained=82
where Rollno=2036 and SubjectCode=202;

update StudentSubjectDetails
set SubjectCode=203
where Rollno=2031 and CourseId="IP101";

update SubjectDetails
set SubjectName='Sanskrit'
where SubjectCode=209;

/*6. Snapshots post updation*/

select * from StudentBasicDetails;
select * from StudentSubjectDetails;
select * from SubjectDetails;

/*7. Select the student details records who has received the scholarship more than 5000Rs/-*/
select * 
from StudentBasicDetails
inner join StudentScholarshipDetails
on StudentBasicDetails.RollNo=StudentScholarshipDetails.Rollno
where Amount>5000;

/*8. Select the students who opted for scholarship but has not got the scholarship*/
select *
from StudentBasicDetails
where ScholarshipOpted=True and RollNo not in(select distinct RollNo from StudentScholarshipDetails);

/*9. Fill in data for the percentage column i.e. StudentMarksPercentage in the table StudentSubjectInformation by creating and using the stored procedure created*/
create table StudentResultDetails(
	RollNo int not null,
    CourseId enum("IP101","IP102","IP103","IP104","IP105") not null,
    StudentPercentage decimal(5,2) not null,
    primary key(RollNo, CourseId),
    foreign key(RollNo) references StudentBasicDetails(RollNo),
    foreign key(CourseId) references CourseDetails(CourseId)
);

DELIMITER //
create procedure FillStudentPercentage (roll_no int, course_id enum("IP101","IP102","IP103","IP104","IP105"))
begin
      select sum(MarksObtained),sum(TotalMarks) into @numenator, @denominator from StudentSubjectDetails where (Rollno=roll_no and CourseId=course_id) limit 1;
      set @result= (@numenator/  @denominator)*100;
      insert into StudentResultDetails(RollNo, CourseId, StudentPercentage) values(roll_no, course_id, @result);
end //
DELIMITER ;

call FillStudentPercentage(2030, "IP101");
call FillStudentPercentage(2038, "IP104");
call FillStudentPercentage(2033, "IP102");
call FillStudentPercentage(2036, "IP104");
call FillStudentPercentage(2031, "IP101");
call FillStudentPercentage(2032, "IP103");
call FillStudentPercentage(2034, "IP102");
call FillStudentPercentage(2035, "IP105");

select * from StudentResultDetails;

/*10. Decide the category of the scholarship depending upon the marks/percentage obtained by the student and
 likewise update the ScholarshipCategory column, create a stored procedure in order to handle this operation*/
create table MeritScholarshipCategory(
		ScholarshipName varchar(100) primary key,
        ScholarshipDesc varchar(300),
        ScholarshipCategory varchar(20) not null,
        Amount decimal(8,2)
);

insert into MeritScholarshipCategory values("Einstein Scholarship", "Given to student having percentage above 95%", 'Merit_A1',10000);
insert into MeritScholarshipCategory values("Mary Curie Scholarship", "Given to student having percentage above 85%", 'Merit_A2', 8000);
insert into MeritScholarshipCategory values("First Division Scholarship", "Given to student having percentage above 60%", 'Merit_A3', 5000);

select * from MeritScholarshipCategory;

DELIMITER //
create procedure PercentageBasedScholarshipCategory(roll_no int, sc_id int)
begin
      select StudentPercentage into @Merit from StudentResultDetails
      where RollNo=roll_no;
      if @Merit>=95.00 then
			select ScholarshipDesc, Amount, ScholarshipCategory into @detail, @s_amount, @category from MeritScholarshipCategory where ScholarshipName like '%Einstein Scholarship%';
			insert into StudentScholarshipDetails values(sc_id, 'Einstein Scholarship', roll_no , @detail, 'University', @s_amount, @category);
	  else if @Merit>=85.00 then
			select ScholarshipDesc, Amount, ScholarshipCategory into @detail, @s_amount, @category from MeritScholarshipCategory where ScholarshipName like '%Mary Curie Scholarship%';
			insert into StudentScholarshipDetails values(sc_id, 'Mary Curie Scholarship',roll_no, @detail,'University',@s_amount,@category);
	  else if @Merit>=60.00 then
			select ScholarshipDesc, Amount, ScholarshipCategory into @detail, @s_amount, @category from MeritScholarshipCategory where ScholarshipName like '%First Division Scholarship%';
			insert into StudentScholarshipDetails values(sc_id, 'First Division Scholarship',roll_no, @detail,'University',@s_amount,@category);
	  end if;
  end if;
end if;
end //
DELIMITER ;

call PercentageBasedScholarshipCategory(2037,222);
call PercentageBasedScholarshipCategory(2033,211);
select * from StudentScholarshipDetails;

/*11. Create the View which shows balance amount to be paid by the student along with the student detailed information using join*/
create view BalanceAmount as
select StudentPaymentDetails.RollNo, FirstName, LastName, AdmissionDate, Email, AmountPaid,  (CourseFee-AmountPaid) as PaymentLeft
from  StudentPaymentDetails
inner join CourseDetails
on StudentPaymentDetails.CourseId=CourseDetails.CourseId
inner join StudentBasicDetails 
on StudentPaymentDetails.RollNo=StudentBasicDetails.Rollno;

select * from BalanceAmount;

/*12. Get the details of the students who haven’t got any scholarship (use joins/subqueries)*/
select *  
from StudentBasicDetails 
where RollNo not in (
		select StudentBasicDetails.Rollno
		from StudentBasicDetails
		join StudentScholarshipDetails
		on StudentBasicDetails.RollNo=StudentScholarshipDetails.Rollno
);

/*13. Create Stored Procedure which will be return the amount balance to be paid by the student as per the student roll number 
passed through the stored procedure as the input*/
DELIMITER //
create procedure ReturnAmountBalance (roll_no int, out PaymentLeft decimal(8,2))
begin
		select (CourseFee-AmountPaid) into @PaymentLeft
		from  StudentPaymentDetails
		inner join CourseDetails
		on StudentPaymentDetails.CourseId=CourseDetails.CourseId
		where StudentPaymentDetails.RollNo=roll_no;
        select @PaymentLeft;
end //
DELIMITER ;

call ReturnAmountBalance(2031, @PaymentLeft);

/*14. Retrieve the top five student details as per the StudentMarksPercentage values using subqueries*/
select * 
from StudentBasicDetails 
inner join (select RollNo 
	from StudentResultDetails
	order by StudentPercentage desc
	limit 5) as result
on StudentBasicDetails.RollNo=result.Rollno;
/* NOTE- LIMIT/IN/ALL/ANY are not allowed in MySQL Subqueries*/

/*15. Try to use all the three types of join learned today in a relevant way, and explain the same 
why you thought of using that particular join for your selected scenarios (try to cover relevant and real time scenarios 
for all the three studied joins)*/

/*LEFT JOIN*/
select *
from SubjectDetails
left join StudentSubjectDetails
on  SubjectDetails.SubjectCode=StudentSubjectDetails.SubjectCode;

/*RIGHT JOIN*/
select *
from StudentScholarshipDetails
right join StudentBasicDetails
on  StudentBasicDetails.RollNo=StudentScholarshipDetails.RollNo;

/*16. Mention the differences between the delete, drop and truncate commands*/
/*IN PDF*/

/*17. Get the count of the Scholarship category which is highly been availed by the students, i.e. 
get the count of the total number of students corresponding to the each scholarships category*/
select ScholarshipName, Count(*) as No_Of_Students_Availed
from StudentScholarshipDetails
group by ScholarshipName;

/*18. Along with the assignment no. 17 try to retrieve the maximum used scholarship category*/
select ScholarshipName, Count(*) as No_Of_Students_Availed
from StudentScholarshipDetails
group by ScholarshipName
order by Count(*) desc
limit 1;

/*19. Retrieve the percentage of the students along with students detailed information who has scored the highest 
percentage along with availing the maximum scholarship amount*/
select StudentResultDetails.RollNo, FirstName, LastName, ScholarshipId, ScholarshipName,Amount, Category, MAX(StudentPercentage)
from StudentBasicDetails
join StudentScholarshipDetails on StudentBasicDetails.RollNo=StudentScholarshipDetails.RollNo
join StudentResultDetails on StudentResultDetails.RollNo=StudentScholarshipDetails.RollNo;

/*20. Difference between the Triggers, Stored Procedures, Views and Functions*/
/*IN PDF*/