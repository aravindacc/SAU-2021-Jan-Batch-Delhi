import java.util.*;  

class SortedList {  
    public static void main(String[] args)   
        {  
            List<String> ans = new ArrayList<String>();  
            ans.add("2");  
            ans.add("4");  
            ans.add("1");  
            ans.add("3");  
            ans.add("5");  
            Collections.sort(ans);   
            for(String str: ans)   
            System.out.print(" "+str);  
        }  
}
