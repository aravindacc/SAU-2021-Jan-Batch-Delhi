import java.io.*;
class excepthrows {
  public static void mat() throws ArithmeticException {
      int a = 0, b = 10;
      int c = b/a;
      System.out.println(c);
  }

  public static void main(String[] args) {
    try{
      mat();
    } catch(ArithmeticException e){
      System.out.println(e);
    }
  }
}
