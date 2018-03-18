// java types, classes, and their objects
// types: byte, short, int, long, float, double, char, boolean
      //bytes, shorts, ints, and longs have to be whole #'s
// classes: String ... --> starts with capital letter
public class GCD {
  //main method - will return nothing
  public static void main(String[] args){
    long x = Long.parseLong(args[0]);
    long y = Long.parseLong(args[1]);
    System.out.println(HelpfulMethods.gcd(x,y));
  }
  //gcd method - this one will return a long - will return a result/value
  //THIS IS A RECURSIVE METHOD
  // static long gcd(long x,long y){
  //   if (x%y == 0) {
  //     return y;
  //   }else {
  //     return gcd(y, x%y);
  //   }
  // }
}
