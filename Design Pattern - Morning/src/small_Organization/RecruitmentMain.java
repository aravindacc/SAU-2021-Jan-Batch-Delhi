package small_Organization;

public class RecruitmentMain{
	public static void main(String args[]){  
	      Employee e1=new Analyst(102,"Mahendra Kumar","zxc@gmail.com","Hapur",12655, 25000.0,"MAIL");  
	      Employee e2=new Swe_intern(101,"Rahul","asabc@gmail.com","Delhi",147852, 20000.0,"SMS");  
	      Employee e3=new Senior_Analyst(103,"Jitendra","sasnm@gmail.com","Jaipur",78955, 30000.0,"SMS");   
	      Employee director=new Director(100,"Dishant Vashistha","fghj@gmail.com","Banglore",152252,202021.0,"EMAIL");  
	      					
	          director.add(e1);  
	          director.add(e2);  
	          director.add(e3);  
	          director.print();
	          System.out.println("Notifications sent for the salary updation: ");
	          director.Notify();
	        }  
}
