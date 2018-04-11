public class BigInteger{
  private String val;
  private boolean negative;
  public static final BigInteger ZERO = new BigInteger("0");
  public static final BigInteger ONE = new BigInteger("1");

  //test suite for big integer
  public static void main(String[] args){
    testIsNegative();
    testToString();
    testAbsValue();
    testEquals();
    testAddMethod();
    testSubtractmethod();
    testHalf();
    testIsEven();
    testMultiply();
    testDivide();
    testRemainder();
  }

  //big integer constructor
  public BigInteger(String val){
    this.val = val;
    if (this.val.substring(0,1).equals("-")){
      this.negative = true;
    }
    else{
      this.negative = false;
    }
  }

  //returns true if the big integer is negative and false if it is positive
  public boolean isNegative(){
    return this.negative;
  }

  //returns the big integer as a string
  public String toString(){
    return this.val;
  }

  //returns true if two big integers are equal and false if they are not equal
  public boolean equals(Object x){
    if (!(x instanceof BigInteger)){
      return false;
    }
    BigInteger obj = (BigInteger) x;
    return ((obj.val).equals(this.val));
  }

  //returns the absolute value of the big integer
  public BigInteger absoluteValue(){
    if (this.isNegative() == false){
      return new BigInteger(this.val);
    }
    else{
      return new BigInteger(this.val.substring(1, this.val.length()));
    }
  }

  //finds the bigger big integer of two big integers and returns the bigger one
  public BigInteger compareTo(BigInteger val){
    String bigInt1 = this.val.toString();
    String bigInt2 = val.toString();
    if (bigInt1.charAt(0)==('-')){
      bigInt1 = this.absoluteValue().toString();
    }
    if (bigInt2.charAt(0)==('-')){
        bigInt2 = val.absoluteValue().toString();
    }
    if (bigInt1.length()>bigInt2.length()){
      return new BigInteger(bigInt1);
    }
    if (bigInt2.length()>bigInt1.length()){
      return new BigInteger(bigInt2);
    }
    for (int i=0; i<bigInt1.length(); i++){
      if (Character.getNumericValue(bigInt1.charAt(i)) > Character.getNumericValue(bigInt2.charAt(i))){
        return new BigInteger(bigInt1);
      }
      if (Character.getNumericValue(bigInt2.charAt(i)) > Character.getNumericValue(bigInt1.charAt(i))){
        return new BigInteger(bigInt2);
      }
    }
    return new BigInteger("0");
  }

  //reverses an array
  public int[] reverse(int[] x){
    int[] result = new int[x.length];
    int count = 0;
    for (int i=x.length-1; i>0; i--){
      result[count] = x[i];
      count++;
    }
    return result;
  }

  //add method for big integer class
  public BigInteger add ( BigInteger val ){
    String bigInt1 = this.val.toString();
    String bigInt2 = val.toString();
    int carry = 0;
    int largerLength = 0;
    int differenceInLength = 0;
    int count = 0;
    String result = "";

    //if both bigInts are negative
    if (new BigInteger(bigInt1).isNegative() && new BigInteger(bigInt2).isNegative()){
      bigInt1 = bigInt1.substring(1,bigInt1.length());
      bigInt2 = bigInt2.substring(1,bigInt2.length());
    }

    //if bigInt1 is negative and bigInt2 is positive
    if (this.isNegative() && !(val.isNegative())){
      return (val.subtract(this.absoluteValue()));
    }

    //if bigInt2 is negative and bigInt1 is positive
    if (!(this.isNegative()) && val.isNegative()){
      return(this.subtract(val.absoluteValue()));
    }

    if (bigInt1.length() > bigInt2.length()){
      largerLength = bigInt1.length();
      differenceInLength = bigInt1.length()-bigInt2.length();
    }
    else{
      largerLength = bigInt2.length();
      differenceInLength = bigInt2.length()-bigInt1.length();
    }
    int[] topArray = new int[largerLength];
    int[] bottomArray = new int[largerLength];
    if (bigInt1.length() > bigInt2.length()){
      for (int i=0; i<bigInt1.length(); i++){
        topArray[i] = Character.getNumericValue(bigInt1.charAt(i));
      }
      for (int i=differenceInLength; i<bigInt2.length()+differenceInLength; i++){
        bottomArray[i] = Character.getNumericValue(bigInt2.charAt(count));
        count++;
      }
    }
    else{
      for (int i=0; i<bigInt2.length(); i++){
        topArray[i] = Character.getNumericValue(bigInt2.charAt(i));
      }
      for (int i=differenceInLength; i<bigInt1.length()+differenceInLength; i++){
        bottomArray[i] = Character.getNumericValue(bigInt1.charAt(count));
        count++;
      }
    }
    int temp = 0;
    for (int i=largerLength-1; i>=0; i--){
      temp = topArray[i] + bottomArray[i] + carry;
      if (temp > 9){
        if (i != 0){
          result = (temp-10) + result;
        }
        else{
          result = temp + result;
        }
      }
      else{
        result = temp + result;
      }
      carry = temp/10;
    }

    //if both are negative
    if (this.isNegative() && val.isNegative()){
      result = "-" + result;
    }
    return new BigInteger(result);
  }

  //checks numbers in the two arrays being subtracted to make sure the numbers on top are bigger than on bottom
  public boolean checkNumbers(int[] top, int[] bottom){
    for (int i=0; i<top.length; i++){
      if (top[i] < bottom[i]){
        return false;
      }
    }
    return true;
  }

  //Subtract method for big integer class
  public BigInteger subtract(BigInteger val){
    String value1 = this.val.toString();
    String value2 = val.toString();
    String bigInt1;
    String bigInt2;
    int largerInt = 0;
    int index = 0;
    int x = 0;
    String difference = new String("");

    if (new BigInteger(value1).compareTo(new BigInteger(value2)).equals(new BigInteger(value2))){
      if ((value2.charAt(0)==('-'))){
        largerInt = value2.length()-1;
      }
      else{
        largerInt = value2.length();
      }
    }
    else{
      if (value1.charAt(0)==('-')){
        largerInt = value1.length()-1;
      }
      else{
        largerInt = value1.length();
      }
    }

    int[] arrayBigger = new int[largerInt];
    int[] arraySmaller = new int[largerInt];
    int[] result = new int[largerInt];
    int[] differenceArray = new int[largerInt];

    if (new BigInteger(value1).compareTo(new BigInteger(value2)).equals(new BigInteger(value2))){
      bigInt2 = value1;
      bigInt1 = value2;
    }
    else{
      bigInt1 = value1;
      bigInt2 = value2;
    }
    //both are negative
    if (this.isNegative() && val.isNegative()){
      return this.add(val.absoluteValue());
    }
    //first is negative and second is positive
    if (this.isNegative() && !(val.isNegative())){
      String temporary = "-" + this.absoluteValue().add(val.absoluteValue()).toString();
      return new BigInteger(temporary);
    }
    //second negative and first positive
    if (!(this.isNegative()) && val.isNegative()){
      return this.add(val.absoluteValue());
    }
    if (new BigInteger(bigInt1).compareTo(new BigInteger(bigInt2)).equals(new BigInteger(bigInt1))){
      for (int i=0; i<bigInt1.length(); i++){
        arrayBigger[i] = Character.getNumericValue(bigInt1.charAt(i));
      }
      for (int i=0; i<(bigInt1.length()-bigInt2.length()); i++){
        arraySmaller[i] = 0;
      }
      for (int i=(bigInt1.length()-bigInt2.length()); i<largerInt; i++){
        arraySmaller[i] = Character.getNumericValue(bigInt2.charAt(i-(bigInt1.length()-bigInt2.length())));
      }
    while (checkNumbers(arrayBigger, arraySmaller) == false){
      for (int i=0; i<arrayBigger.length; i++){
        if (arrayBigger[i]<arraySmaller[i]){
          if (i != 0){
            index=i-1;
          }
          while (arrayBigger[index] == 0){
            index--;
          }
          arrayBigger[index] -= 1;
          while (index != i){
            index++;
            if (index == i){
              arrayBigger[index] += 10;
            }
            else{
              arrayBigger[index] += 9;
            }
          }
        }
      }
    }
    for (int i=0; i<result.length; i++){
      result[i] = arrayBigger[i] - arraySmaller[i];
    }
  }


  for (int i=0; i<result.length; i++){
    difference += result[i];
  }
  String differenceStr = String.valueOf(difference);
  while (Character.getNumericValue(differenceStr.charAt(0)) == 0 && differenceStr.length()>1){
    differenceStr = differenceStr.substring(1, differenceStr.length());
  }
  if (this.isNegative() && val.isNegative() && !(new BigInteger(value1).compareTo(new BigInteger(value2)).equals(new BigInteger(value2)))){
    differenceStr = "-" + differenceStr;
  }
  else{
    if (!(this.isNegative()) && !(val.isNegative()) && new BigInteger(value1).compareTo(new BigInteger(value2)).equals(new BigInteger(value2))){
      differenceStr = "-" + differenceStr;
    }
    else{
      differenceStr = differenceStr;
    }
  }

  if (this.toString().equals(val.toString())){
    differenceStr = Integer.toString(0);
  }
  BigInteger subtract = new BigInteger(differenceStr);
  return subtract;
}

//halves a big integer
public BigInteger half(){
  String bigInt = this.toString();
  String bigInt0 = "0" + bigInt;
  String result = "";
  for (int i=0; i<bigInt0.length()-1; i++){
    if (Character.getNumericValue(bigInt0.charAt(i))%2 == 0){
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 0 || (Character.getNumericValue(bigInt0.charAt(i+1)) == 1)){
        result = result + "0";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 2 || (Character.getNumericValue(bigInt0.charAt(i+1)) == 3)){
        result = result + "1";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 4 || (Character.getNumericValue(bigInt0.charAt(i+1)) == 5)){
        result = result + "2";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 6 || (Character.getNumericValue(bigInt0.charAt(i+1)) == 7)){
        result = result + "3";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 8 || (Character.getNumericValue(bigInt0.charAt(i+1)) == 9)){
        result = result + "4";
      }
    }
    else{
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 0 || Character.getNumericValue(bigInt0.charAt(i+1)) == 1){
        result = result + "5";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 2 || Character.getNumericValue(bigInt0.charAt(i+1)) == 3){
        result = result + "6";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 4 || Character.getNumericValue(bigInt0.charAt(i+1)) == 5){
        result = result + "7";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 6 || Character.getNumericValue(bigInt0.charAt(i+1)) == 7){
        result = result + "8";
      }
      if (Character.getNumericValue(bigInt0.charAt(i+1)) == 8 || Character.getNumericValue(bigInt0.charAt(i+1)) == 9){
        result = result + "9";
      }
    }
  }
  while (Character.getNumericValue(result.charAt(0)) == 0 && result.length()>1){
    result = result.substring(1, result.length());
  }
  return (new BigInteger(result));
}

//returns true if a big integer is even and false if it is odd
public boolean isEven(){
  return (Character.getNumericValue(this.toString().charAt(this.toString().length()-1))%2 ==0);
}

//multiply method for big integer class
public BigInteger multiply(BigInteger val){
  BigInteger result = new BigInteger("0");
  String bigInt1 = this.toString();
  String bigInt2 = val.toString();
  if (new BigInteger(bigInt1).isNegative()){
    bigInt1 = bigInt1.substring(1,bigInt1.length());
  }
  if (new BigInteger(bigInt2).isNegative()){
    bigInt2 = bigInt2.substring(1,bigInt2.length());
  }
  BigInteger value = new BigInteger(bigInt2);
  BigInteger halves = new BigInteger(bigInt1);
  if (val.compareTo(this).equals(val)){
    halves = new BigInteger(bigInt2);
    value = new BigInteger(bigInt1);
  }
  if (bigInt1.equals("0") || bigInt2.equals("0")){
    return new BigInteger("0");
  }
  else{
    while (!(halves.equals(new BigInteger("0")))){
      if (!(halves.isEven())){
        result = result.add(value);
      }
      value = value.add(value);
      halves = halves.half();
    }
  }
  while (Character.getNumericValue(result.toString().charAt(0)) == 0 && result.toString().length()>1){
    result = new BigInteger (result.toString().substring(1, result.toString().length()));
  }
  if ((this.isNegative() && !val.isNegative()) || (val.isNegative() && !this.isNegative())){
    result = new BigInteger("-" + result.toString());
  }
  return result;
}

//divide method for big integer class
public BigInteger divide(BigInteger val){
  BigInteger bigInt1 = this;
  BigInteger bigInt2 = val;
  if (bigInt1.isNegative()){
    bigInt1 = bigInt1.absoluteValue();
  }
  if (bigInt2.isNegative()){
    bigInt2 = bigInt2.absoluteValue();
  }
  BigInteger result = new BigInteger("1");
  BigInteger ten = new BigInteger("10");
  BigInteger temp = bigInt2;

  if (bigInt1.compareTo(bigInt2).equals(bigInt2)){
    return new BigInteger("0");
  }
  else{
    while ((temp.multiply(ten)).compareTo(bigInt1).equals(bigInt1)){
      result = result.multiply(ten);
      temp = temp.multiply(ten);
    }
  }
  result = result.add(bigInt1.subtract(temp).divide(bigInt2));
  if ((this.isNegative() && !val.isNegative()) || (val.isNegative() && !this.isNegative())){
    result = new BigInteger("-" + result.toString());
  }
  return result;
}

//remainder method for big integer class
public BigInteger remainder(BigInteger val){
  BigInteger bigInt = this;
  return this.subtract(bigInt.divide(val).multiply(val));
}

//BEGINS TESTS FOR ALL OF THE METHODS
  public static void testIsNegative(){
    System.out.println("TESTING isNegative");
    {
      BigInteger bigInt1 = new BigInteger("12344");
      System.out.println(bigInt1.isNegative() == false);
    }

    {
      BigInteger bigInt1 = new BigInteger("-12344");
      System.out.println(bigInt1.isNegative() == true);
    }
  }
  public static void testToString(){
    System.out.println("TESTING toString");
    {
      BigInteger bigInt1 = new BigInteger("12344");
      System.out.println(bigInt1.toString().equals("12344"));
    }

    {
      BigInteger bigInt1 = new BigInteger("123440997775");
      System.out.println(bigInt1.toString().equals("123440997775"));
    }

    {
      BigInteger bigInt1 = new BigInteger("-123440997775");
      System.out.println(bigInt1.toString().equals("-123440997775"));
    }
  }
  public static void testIsEven(){
    System.out.println("TESTING isEven");
    {
      BigInteger bigInt1 = new BigInteger("12");
      System.out.println(bigInt1.isEven() == true);
    }

    {
      BigInteger bigInt1 = new BigInteger("11");
      System.out.println(bigInt1.isEven() == false);
    }
  }
  public static void testHalf(){
    System.out.println("TESTING half");
    {
      BigInteger bigInt1 = new BigInteger("12");
      System.out.println(bigInt1.half().equals(new BigInteger("6")));
    }

    {
      BigInteger bigInt1 = new BigInteger("1298");
      System.out.println(bigInt1.half().equals(new BigInteger("649")));
    }

    {
      BigInteger bigInt1 = new BigInteger("121");
      System.out.println(bigInt1.half().equals(new BigInteger("60")));
    }
  }
  public static void testAbsValue(){
    System.out.println();
    System.out.println("TESTING AbsVal");

    {
      BigInteger bigInt1 = new BigInteger("12344");
      System.out.println(bigInt1.absoluteValue().equals(new BigInteger("12344")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-12344");
      System.out.println(bigInt1.absoluteValue().equals(new BigInteger("12344")));
    }
  }
  public static void testEquals(){
    System.out.println();
    System.out.println("TESTING Equals");
    {
      BigInteger bigInt1 = new BigInteger("12344");
      BigInteger bigInt2 = new BigInteger("12344");
      System.out.println(bigInt1.equals(bigInt2));
    }
  }
  public static void testAddMethod(){
    System.out.println();
    System.out.println("TESTING Add Method");
    {
      BigInteger bigInt1 = new BigInteger("506");
      BigInteger bigInt2 = new BigInteger("1472");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("1978")));
    }

    {
      BigInteger bigInt1 = new BigInteger("30");
      BigInteger bigInt2 = new BigInteger("192");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("222")));
    }

    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("5");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("10")));
    }

    {
      BigInteger bigInt1 = new BigInteger("20");
      BigInteger bigInt2 = new BigInteger("80");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("100")));
    }

    {
      BigInteger bigInt1 = new BigInteger("30");
      BigInteger bigInt2 = new BigInteger("30");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("60")));
    }

    {
      BigInteger bigInt1 = new BigInteger("3001");
      BigInteger bigInt2 = new BigInteger("22");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("3023")));
    }

    {
      BigInteger bigInt1 = new BigInteger("30000000000000001");
      BigInteger bigInt2 = new BigInteger("200000002");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("30000000200000003")));
    }

    {
      BigInteger bigInt1 = new BigInteger("22");
      BigInteger bigInt2 = new BigInteger("34");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("56")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("3")));
    }

    {
      BigInteger bigInt1 = new BigInteger("0");
      BigInteger bigInt2 = new BigInteger("0");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("0")));
    }

    {
      BigInteger bigInt1 = new BigInteger("123");
      BigInteger bigInt2 = new BigInteger("200");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("323")));
    }

    {
      BigInteger bigInt1 = new BigInteger("123");
      BigInteger bigInt2 = new BigInteger("145");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("268")));
    }

    {
      BigInteger bigInt1 = new BigInteger("123");
      BigInteger bigInt2 = new BigInteger("122");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("245")));
    }

    System.out.println("adding two negatives");
    {
      BigInteger bigInt1 = new BigInteger("-30");
      BigInteger bigInt2 = new BigInteger("-192");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-222")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-2");
      BigInteger bigInt2 = new BigInteger("-1");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-3")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-300");
      BigInteger bigInt2 = new BigInteger("-76");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-376")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-876540");
      BigInteger bigInt2 = new BigInteger("-1");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-876541")));
    }
    System.out.println("adding first negative and second positive");
    {
      BigInteger bigInt1 = new BigInteger("-200");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-199")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-5");
      BigInteger bigInt2 = new BigInteger("10");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("5")));
    }
    System.out.println("adding first positive and second negative");
    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("-10");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("-5")));
    }

    {
      BigInteger bigInt1 = new BigInteger("10");
      BigInteger bigInt2 = new BigInteger("-1");
      System.out.println(bigInt1.add(bigInt2).equals(new BigInteger("9")));
    }
  }
  public static void testSubtractmethod(){
    System.out.println();
    System.out.println("TESTING Subtract Method");
    {
      BigInteger bigInt1 = new BigInteger("10");
      BigInteger bigInt2 = new BigInteger("300");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-290")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2064");
      BigInteger bigInt2 = new BigInteger("2050");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("14")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2000");
      BigInteger bigInt2 = new BigInteger("1000");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("1000")));
    }

    {
      BigInteger bigInt1 = new BigInteger("3001");
      BigInteger bigInt2 = new BigInteger("192");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("2809")));
    }

    {
      BigInteger bigInt1 = new BigInteger("32");
      BigInteger bigInt2 = new BigInteger("16");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("16")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("1")));
    }

    {
      BigInteger bigInt1 = new BigInteger("0");
      BigInteger bigInt2 = new BigInteger("0");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("0")));
    }

    {
      BigInteger bigInt1 = new BigInteger("20000000002341");
      BigInteger bigInt2 = new BigInteger("109476909");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("19999890525432")));
    }

    {
      BigInteger bigInt1 = new BigInteger("23401");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("23400")));
    }

    {
      BigInteger bigInt1 = new BigInteger("230001");
      BigInteger bigInt2 = new BigInteger("101");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("229900")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2305748001");
      BigInteger bigInt2 = new BigInteger("87689908");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("2218058093")));
    }
    System.out.println("subracting two negatives");
    {
      BigInteger bigInt1 = new BigInteger("-2305748001");
      BigInteger bigInt2 = new BigInteger("-87689908");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-2218058093")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-230001");
      BigInteger bigInt2 = new BigInteger("-101");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-229900")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-23401");
      BigInteger bigInt2 = new BigInteger("-1");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-23400")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-23401");
      BigInteger bigInt2 = new BigInteger("-23401");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("0")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-5");
      BigInteger bigInt2 = new BigInteger("-10");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("5")));
    }

    System.out.println("first negative and second positive");
    {
      BigInteger bigInt1 = new BigInteger("-5");
      BigInteger bigInt2 = new BigInteger("10");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-15")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-10");
      BigInteger bigInt2 = new BigInteger("10");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("-20")));
    }
    System.out.println("first positive and second negative");
    {
      BigInteger bigInt1 = new BigInteger("10");
      BigInteger bigInt2 = new BigInteger("-10");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("20")));
    }

    {
      BigInteger bigInt1 = new BigInteger("20");
      BigInteger bigInt2 = new BigInteger("-10");
      System.out.println(bigInt1.subtract(bigInt2).equals(new BigInteger("30")));
    }
  }
  public static void testMultiply(){
     System.out.println("TESTING multiply");
    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("5")));
    }

    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("20");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("100")));
    }

    {
      BigInteger bigInt1 = new BigInteger("9004");
      BigInteger bigInt2 = new BigInteger("200");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("1800800")));
    }

    {
      BigInteger bigInt1 = new BigInteger("23");
      BigInteger bigInt2 = new BigInteger("598");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("13754")));
    }

    {
      BigInteger bigInt1 = new BigInteger("23");
      BigInteger bigInt2 = new BigInteger("8");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("184")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-23");
      BigInteger bigInt2 = new BigInteger("8");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("-184")));
    }

    {
      BigInteger bigInt1 = new BigInteger("23");
      BigInteger bigInt2 = new BigInteger("-8");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("-184")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-23");
      BigInteger bigInt2 = new BigInteger("-8");
      System.out.println(bigInt1.multiply(bigInt2).equals(new BigInteger("184")));
    }
  }
  public static void testDivide(){
    System.out.println("TESTING Divide Method");
    {
      BigInteger bigInt1 = new BigInteger("10");
      BigInteger bigInt2 = new BigInteger("5");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("2")));
    }

    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("10");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("0")));
    }

    {
      BigInteger bigInt1 = new BigInteger("20");
      BigInteger bigInt2 = new BigInteger("4");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("5")));
    }

    {
      BigInteger bigInt1 = new BigInteger("20");
      BigInteger bigInt2 = new BigInteger("5");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("4")));
    }

    {
      BigInteger bigInt1 = new BigInteger("4");
      BigInteger bigInt2 = new BigInteger("2");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("2")));
    }

    {
      BigInteger bigInt1 = new BigInteger("624");
      BigInteger bigInt2 = new BigInteger("36");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("17")));
    }

    {
      BigInteger bigInt1 = new BigInteger("6624");
      BigInteger bigInt2 = new BigInteger("36");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("184")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2064");
      BigInteger bigInt2 = new BigInteger("25");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("82")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-4");
      BigInteger bigInt2 = new BigInteger("2");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("-2")));
    }

    {
      BigInteger bigInt1 = new BigInteger("4");
      BigInteger bigInt2 = new BigInteger("-2");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("-2")));
    }

    {
      BigInteger bigInt1 = new BigInteger("-4");
      BigInteger bigInt2 = new BigInteger("-2");
      System.out.println(bigInt1.divide(bigInt2).equals(new BigInteger("2")));
    }
  }
  public static void testRemainder(){
    System.out.println("TESTING remainder");
    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("2");
      System.out.println(bigInt1.remainder(bigInt2).equals(new BigInteger("1")));
    }

    {
      BigInteger bigInt1 = new BigInteger("2064");
      BigInteger bigInt2 = new BigInteger("25");
      System.out.println(bigInt1.remainder(bigInt2).equals(new BigInteger("14")));
    }

    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("5");
      System.out.println(bigInt1.remainder(bigInt2).equals(new BigInteger("0")));
    }

    {
      BigInteger bigInt1 = new BigInteger("5");
      BigInteger bigInt2 = new BigInteger("1");
      System.out.println(bigInt1.remainder(bigInt2).equals(new BigInteger("0")));
    }
  }
}

