import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SortedCollection {
    public static void main(String[] args) {
         
        // using collection "List" of integer
        List<Integer> list = new ArrayList<>();

        // adding elements
        int countToAdd = 10;
        for (int i =0; i<countToAdd; i++) {
            list.add( (int) (Math.random() * 100));
        }

        // sorting the collection
        // list.sort((x,y)->Integer.compare(x, y));
        // for (int i = 0; i<list.size(); i++) System.out.println(list.get(i));

        // printing sorted 
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
    }
}