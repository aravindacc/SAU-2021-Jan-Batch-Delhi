public class ExeceptionHandling {
    static void check() throws ArithmeticException
    { 
        int a=16;
        if(a<0)
            throw new ArithmeticException("Not Eligible for voting");  
	    else  
	   System.out.println("Eligible for voting"); 
        
    }
    public static void main(String[] args)throws ArithmeticException{
        check();
        System.out.println("Exception Handled by Complier");
   } 
}
