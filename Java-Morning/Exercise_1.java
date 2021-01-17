package exercise;
import java.util.*;

public class Exercise_1 {
	public static void main(String args[])
	{
		ArrayList<Integer> arr= new ArrayList<Integer>( );
		arr.add(11);
		arr.add(1);
		arr.add(21);
		arr.add(13);
		arr.add(14);
		arr.add(1);
		arr.add(101);
		arr.add(23);
		arr.add(42);
		arr.add(165);
		
		Collections.sort(arr);
		
		for(int i:arr)
		{
			System.out.println(i);
		}
		
	}
}
