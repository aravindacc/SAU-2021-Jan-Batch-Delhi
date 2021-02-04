package pragya.codeNet;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class CollectionSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] number = new Integer[] { 15, 11, 9, 55, 47, 18, 1123, 520, 366, 420 };
		List<Integer> numList = Arrays.asList(number);
		 
		//Sort the list
		Collections.sort(numList);
		 
		//Print list to confirm
		System.out.println(numList);
	}

}
