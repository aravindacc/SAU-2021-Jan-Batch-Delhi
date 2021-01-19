import java.util.*;
public class Sorting {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		List<String> list = new ArrayList<String>();  
		System.out.println("Enter number of inputs");
		int n = scn.nextInt();
		
		for(int i=0;i<=n;i++) {
			String str = scn.nextLine();
			list.add(str);
		}
		
		Collections.sort(list);    //sorts array list  
		for(String str: list)   
		System.out.print(" "+str);  
		    }
	}

