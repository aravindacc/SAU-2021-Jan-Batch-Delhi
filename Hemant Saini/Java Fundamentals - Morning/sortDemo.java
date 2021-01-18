import java.util.*;

public class sortDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 10; i++)
			list.add(random.nextInt(100));
		System.out.println("Unsorted List : "+list); 
		Collections.sort(list);
        System.out.println("Sorted List : "+list);
	}

}
