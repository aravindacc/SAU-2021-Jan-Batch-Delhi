public class ThrowError {

    public static double divide(int x, int y){
        if (y == 0) { 
             throw new ArithmeticException();
        }
        return x / y;
    }


    public static void main(String[] args) throws ArithmeticException{
        double x = divide(2, 0);
        System.out.println(x);
    }
}
