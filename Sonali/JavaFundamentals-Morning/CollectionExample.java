import java.util.*;
public class CollectionExample{
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		
	
		System.out.println("Enter Array Size :");
		int size = in.nextInt(); 
		System.out.println("Enter "+size+" Elements :");
		for(int i=0;i<size;i++)
		{
			int ele=in.nextInt();
			al.add(ele);
		} 
		System.out.println("Unsorted Order Of Elements :" + al);
		Collections.sort(al); 
		System.out.println("Sorted Order Of Elements :" + al);
		
		
	}
	
}