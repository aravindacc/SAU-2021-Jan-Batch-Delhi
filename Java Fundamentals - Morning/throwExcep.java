import java.io.*;
class throwExcep 
{ 
    static void th() 
    { 
        try
        { 
            throw new ArithmeticException("/ by zero"); 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.println("ArithmeticException"); 
            throw e;
        } 
    } 
  
    public static void main(String args[]) 
    { 
        try
        { 
            th(); 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 
