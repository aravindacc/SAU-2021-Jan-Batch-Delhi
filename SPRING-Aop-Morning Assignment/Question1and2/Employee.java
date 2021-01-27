package Question1;

import java.util.* ; 

public class Employee {
	HashSet<Work> work1 ;
	HashMap<Integer , Work> work_in_year ;
	Work workA ;


	public void setProjectA(Work workA)
	 {
		this.workA = workA;
	}

	public HashSet<Work> getWork1()

	 {
	 	return  work1;
	}


	public Work getWorkA()

	 {
	 	return workA;
	}




	public void setWork1(HashSet<Work> work1) 
	{
		this.work1 =  work1;
	}
	
	public void printWork1(){
		for(Work ww:  work1){
			System.out.println("Work ID: " + ww.getId() +
			 " Work Name: " + ww.getName()) ;
		}
	}
	
	public void printWork_in_year()
	{
		for(int year : work_in_year.keySet())
		{
			       System.out.println("Work Year : " + year +
			        " Work ID: "
					+ work_in_year.get(year).getId() +
					  " Work Name: "
					+ work_in_year.get(year).getName()) ;
		}
	}
	
	public void showWorkA()
	{
		        System.out.println(
				"This is WorkA : " + workA.id + " " + workA.name) ;
	}

	public HashMap<Integer, Work> getWork_in_year() {
		return work_in_year;
	}

	public void setWork_in_year(
		HashMap<Integer, Work> work_in_year) {
		this.work_in_year = work_in_year;
	}
	
}
