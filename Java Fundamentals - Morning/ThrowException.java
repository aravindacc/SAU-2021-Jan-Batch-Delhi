//Java program to throw arithmetic exception using “throw” and “throws”
import java.lang.*;
import java.util.*;
import java.io.*; 
public class ThrowException
{   
    public static void throwsException(int m,int n) throws ArithmeticException{
        
        if(n==0){
            System.out.println("Number can not be Divided Exception is -");
            throw new ArithmeticException("Divide by Zero");//throw Exception
        }
        else{
            System.out.println("Number can be Divided and the result is "+ (double)m/n);
        }
        
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		int m,n;
		
		m=sc.nextInt();
		n=sc.nextInt();
		
		try{
		    
		    throwsException(m,n);
		    
		}
		catch(ArithmeticException e){
		    System.out.println(e.getMessage());
		}

	}
}
