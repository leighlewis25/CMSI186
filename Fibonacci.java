public class Fibonacci{
  public static void main(String[] args){
    if (args.length == 0){
      throw(new IllegalArgumentException("Illegal Argument"));
    }
    for (int i=0; i<args.length; i++){
      if (new BigInteger(args[i]).isNegative()){
        throw(new IllegalArgumentException("Illegal Argument"));
      }
    }
    try{
      for(int i=0; i<args.length; i++){
        Integer.parseInt(args[i]);
      }
    }
    catch(NumberFormatException nfe){
      throw(new IllegalArgumentException("Malformed Arg"));
    }
    BigInteger val = new BigInteger(args[0]);
    System.out.println(fibonacci(val));
  }

  public static BigInteger fibonacci(BigInteger val){
    BigInteger x = new BigInteger("0");
    BigInteger y = new BigInteger("1");
    BigInteger z = new BigInteger("1");
    if (val.compareTo(new BigInteger("1")).equals(new BigInteger("1"))){
      return val;
    }
    else{
      for (BigInteger i = new BigInteger("0"); i.compareTo(val).equals(val); i=i.add(new BigInteger("1"))){
        x = y;
        y = z;
        z = x.add(y);
      }
    }
    return x;
  }
}
