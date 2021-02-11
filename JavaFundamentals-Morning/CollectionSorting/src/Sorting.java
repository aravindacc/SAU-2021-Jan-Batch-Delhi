import java.util.*;
public class Sorting {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();  
		System.out.println("Enter number of inputs");
		int n = scn.nextInt();
		System.out.println("Enter the list values");
		for(int i=0;i<n;i++) {
			int num = scn.nextInt();
			list.add(num);
		}
		
		//Sorting list using priorityQueue which is a part of a collection
		//sorts array list  
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.addAll(list);
		list= new ArrayList<>();
		while(!pq.isEmpty()){
		    list.add(pq.poll());
		}
		//printing the sorted list
		System.out.println("The sorted list is:");
        System.out.println(list);
        }
	}
