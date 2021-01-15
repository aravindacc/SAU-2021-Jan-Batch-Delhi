import java.util.*;
class SortProblem {
 public static void main(String[] args) {
    Set<String> s = new HashSet<>();
    s.add("shubham");
    s.add("sharma");
    s.add("apple");
    s.add("ved");
    s.add("banana");
    System.out.println("Before Sorting");
    for (String s1 : s) {
        System.out.print("  " + s1);
    }
    TreeSet<String> treeSet = new TreeSet<String>(s); 
    System.out.println("\nAfter Sorting");
    for (String set : treeSet) {                
        System.out.print(" " + set);
    }
  }
 }