import java.util.*;
public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			int temp = sc.nextInt();
			arr.add(temp);
		}
		System.out.println("Before Sorting:");
		for(int i = 0;i<n;i++)
			System.out.print(arr.get(i)+" ");
		System.out.println();
		Collections.sort(arr);
		System.out.println("After Sorting:");
		for(int i = 0;i<n;i++)
			System.out.print(arr.get(i)+" ");
	}

}
