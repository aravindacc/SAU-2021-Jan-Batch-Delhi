package Q1;

import java.util.* ; 

public class Student {
	HashMap<Integer , Subject> subjectAndYear ; 
	HashSet<Subject> subjects ;
	Subject subject ; 

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public HashSet<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(HashSet<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void printSubjects(){
		for(Subject subj: subjects)
		{
			System.out.println("Subject Id:" + subj.getId() + " Subject Name: " + subj.getName()) ; 
		}
	}
	
	public void printSubjectAndYear(){
		for(int year : subjectAndYear.keySet())
		{
			System.out.println("Subject Year :" + year + " Subject Name: " + subjectAndYear.get(year).getName()) ; 
		}
	}
	
	public void showSubject(){
		System.out.println("Subject Information: " + subject.id + " " + subject.name) ; 
	}

	public HashMap<Integer, Subject> getSubjectAndYear() {
		return subjectAndYear;
	}

	public void setSubjectAndYear(HashMap<Integer, Subject> subjectAndYear) {
		this.subjectAndYear = subjectAndYear;
	}
	
}
