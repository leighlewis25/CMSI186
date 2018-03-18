/**
* Creates a class Tuple that will allow users to construct Tuples, clone Tuples,
* add Tuples, Sum the elements of the Tuple, get an Element from the Tuple,
* set Elements of the Tuple, etc
**/
public class Tuple{
  private int k;
  private int[] data;

  /**
  * Test Suite for the constructors and methods in this tuple class
  **/
  public static void main(String[] args){
    testFirstConstructorString();
    testSecondConstructorString();
    testAddMethod();
    testCloneMethod();
    testEqualsMethod();
    testGetElementMethod();
    testSetElementMethod();
    testLengthMethod();
    testSumMethod();
  }
  /**
  * constructs a tuple with a length k that is filled with 0s
  * @param k indicates the length of the tuple
  **/
  public Tuple(int k){
    this.k = k;
    if (this.k < 0){
      throw(new IllegalArgumentException("You cannot have a negative length"));
    }
    else{
      this.data = new int[k];
      for (int i=0; i<k; i++){
        data[i] = 0;
      }
    }
  }
  /**
  * Constructs a tuple from array, data
  * @param data is the array that forms the tuple
  **/
  public Tuple(int[] data){
    this.data = data;
    this.k = data.length;
  }
  /**
  * Returns a tuple constructed from array, data
  * @param data is the array that forms the tuple
  **/
  public static Tuple makeTupleFromData(int[] data){
    Tuple tuple = new Tuple(data);
    return tuple;
  }
  /**
  * Returns a new tuple whose elements are the sums of the respective
  * elements of this tuple and tuple t.
  * Throws an IllegalArgumentException if the tuples are not equal lengths.
  * @param t is the tuple that is added to this tuple.
  **/
  public Tuple add(Tuple t){
    if (! (t.length() == this.length())){
      throw(new IllegalArgumentException("The lengths of both Tuples must be equal"));
    }
    else{
      Tuple newTuple = new Tuple(this.k);
      for (int i=0; i<this.k; i++){
         newTuple.setElement(i, (this.data[i]+t.getElement(i)));
      }
      return newTuple;
    }
  }
  /**
  * Returns an exact copy of this tuple
  **/
  public Tuple clone(){
    Tuple newTuple = new Tuple(this.k);
    for (int i=0; i<this.k; i++){
       newTuple.setElement(i, (this.data[i]));
    }
    return newTuple;
  }
  /**
  * Returns true iff obj is a tuple which has the same length and elements, respectively,
  * of this tuple.
  * @param obj indicates the object that we want to know if this tuple is equal to.
  **/
  public boolean equals(Object obj){
    if (!(obj instanceof Tuple)){
      return false;
    }
    Tuple x = (Tuple) obj;
    if (!(x.length() == this.length())){
      return false;
    }
    else{
      for (int i=0; i<this.length(); i++){
        if (!(x.getElement(i) == this.getElement(i))){
          return false;
        }
      }
      return true;
    }
  }

  /**
  * Returns the value of the i-th element of this tuple (zero-based indexing)
  * Throws an IllegalArgumentException if i is inappropriate
  * @param i indicates the index of the element that we will return
  **/
  public int getElement(int i){
    if (i<0 || i>this.k-1){
      throw(new IllegalArgumentException("You cannot have a negative index of a tuple"));
    }
    else{
      return this.data[i];
    }
  }

  /**
  * Sets the value of the i-th element of this tuple (zero-based indexing)
  * Throws an IllegalArgumentException if i is inappropriate
  * @param i indicates the index of the element that we hope to set a value to
  * @param value indicates the value given to the ith element
  **/
  public void setElement(int i, int value){
    if (i<0 || i>this.k-1){
      throw(new IllegalArgumentException("i must be within the bounds of this tuple's length"));
    }
    else{
      this.data[i] = value;
    }
  }

  /**
  * Returns the number of elements in this tuple
  **/
  public int length(){
    return this.k;
  }

  /**
  * Returns the sum of the elements in this tuple
  **/
  public int sum(){
    int sum = 0;
    for (int i=0; i<this.length(); i++){
      sum += this.getElement(i);
    }
    return sum;
  }

  /**
  * Returns the string that denotes this tuple
  **/
  public String toString(){
    String result = "[";
    for (int i=0; i<this.length(); i++){
      if (i < this.length()-1){
        result = result + this.data[i] + ",";
      }
      else{
        result = result + this.data[i];
      }
    }
    result = result + "]";
    return result;
  }

  /**
  * Tests that the Tuple constructor that constructs a tuple of length k with 0s
  * works properly, and it also tests the toString method on the constructed tuples.
  * Tests that this method throws an IllegalArgumentException for a negative k.
  **/
  public static void testFirstConstructorString(){
    System.out.println();
    System.out.println("TESTING CONSTRUCTOR BY LENGTH WITH 0");
    {
      Tuple t = new Tuple(4);
      System.out.println(t.toString().equals("[0,0,0,0]"));
    }

    {
      Tuple t = new Tuple(0);
      System.out.println(t.toString().equals("[]"));
    }

    {
      Tuple t = new Tuple(1);
      System.out.println(t.toString().equals("[0]"));
    }

    {
      Tuple t = new Tuple(10);
      System.out.println(t.toString().equals("[0,0,0,0,0,0,0,0,0,0]"));
    }

    {
      try{
        Tuple t = new Tuple(-2);
      }
      catch(IllegalArgumentException exc){
        System.out.println(true);
      }
    }
  }

  /**
  * Tests that the Tuple constructor that constructs a tuple of specific data
  * works properly, and it also tests the toString method on these constructed tuples.
  **/
  public static void testSecondConstructorString(){
    System.out.println("TESTING CONSTRUCTOR BY DATA");

    {
      Tuple t = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.toString().equals("[1,2,3,4]"));
    }

    {
      Tuple t = new Tuple(new int[] {2, 1, 2, 1});
      System.out.println(t.toString().equals("[2,1,2,1]"));
    }

    {
      Tuple t = new Tuple(new int[] {2, 3, 3, 2, 1, 2, -1});
      System.out.println(t.toString().equals("[2,3,3,2,1,2,-1]"));
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});
      System.out.println(t.toString().equals("[1,1,-3,2,0,2,4]"));
    }

    {
      Tuple t = new Tuple(new int[] {3, 4, 0, 4, 1, 4, 3});
      System.out.println(t.toString().equals("[3,4,0,4,1,4,3]"));
    }

    {
      Tuple t = new Tuple(new int[] {3, 3, 5, 5});
      System.out.println(t.toString().equals("[3,3,5,5]"));
    }

    {
      Tuple t = new Tuple(new int[] {});
      System.out.println(t.toString().equals("[]"));
    }
  }

  /**
  * Tests that the add method works properly.
  **/
  public static void testAddMethod(){
    System.out.println("TESTING ADD METHOD");

    { Tuple t = new Tuple(4);
      Tuple t2 = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.add(t2).equals(t2));
    }

    { Tuple t = new Tuple(0);
      Tuple t2 = new Tuple(new int[] {});
      System.out.println(t.add(t2).equals(t2));
    }

    { Tuple t = new Tuple(4);
      Tuple t2 = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.add(t2).equals(t2));
    }

    { Tuple t = new Tuple(new int[] {2, 1, 2, 1});
      Tuple t2 = new Tuple(new int[] {1, 2, 3, 4});
      Tuple t3 = new Tuple(new int[] {3, 3, 5, 5});
      System.out.println(t.add(t2).equals(t3));
    }

    { Tuple t = new Tuple(new int[] {2, 3, 3, 2, 1, 2, -1});
      Tuple t2 = new Tuple(7);
      System.out.println(!(t.add(t2).equals(t2)));
      System.out.println(t.add(t2).equals(t));
    }

    { Tuple t = new Tuple(new int[] {2, 3, 3, 2, 1, 2, -1});
      Tuple t2 = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});
      Tuple t3 = new Tuple(new int[] {3, 4, 0, 4, 1, 4, 3});
      System.out.println(t.add(t2).equals(t3));
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});;
      Tuple t2 = new Tuple(new int[] {1, 2, 3, 4});
      try{
        t2.add(t);
      }
      catch(IllegalArgumentException e){
        System.out.println(true);
      }
    }
  }

  /**
  * Tests that the clone method works properly
  **/
  public static void testCloneMethod(){
    System.out.println("TESTING CLONE METHOD");
    {
      Tuple t = new Tuple(4);
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(0);
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(1);
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(10);
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(new int[] {2, 1, 2, 1});
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(new int[] {2, 3, 3, 2, 1, 2, -1});
      System.out.println(t.clone().equals(t));
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});
      System.out.println(t.clone().equals(t));
    }
  }

  /**
  * Tests that the equals method works properly
  **/
  public static void testEqualsMethod(){
    System.out.println("TESTING EQUALS METHOD");
    {
      Tuple t = new Tuple(new int[] {});
      System.out.println(t.equals(t));
    }

    {
      Tuple t = new Tuple(new int[] {3, 3, 5, 5});
      Tuple t2 = new Tuple(new int[] {3, 3, 5, 5});
      System.out.println(t.equals(t2));
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});
      Tuple t2 = new Tuple(new int[] {1, 1, -3, 2, 0, 0, 2, 4});
      System.out.println(!(t.equals(t2)));
    }
  }

  /**
  * Tests that the getElement method works properly
  * makes sure that IllegalArgumentExceptions are thrown for inappropriate i's
  **/
  public static void testGetElementMethod(){
    System.out.println("TESTING GET ELEMENT METHOD");

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 2, 4});
      System.out.println(t.getElement(3) == 2);
    }

    {
      Tuple t = new Tuple(new int[] {3, 3, 5, 5});
      System.out.println(t.getElement(3) == 5);
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 0, 2, 4});
      System.out.println(t.getElement(0) == 1);
    }

    {
      Tuple t = new Tuple(new int[] {});
      try{
        t.getElement(0);
      }
      catch(IllegalArgumentException e){
        System.out.println(true);
      }
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 0, 2, 4});
      try{
        t.getElement(-1);
      }
      catch(IllegalArgumentException e){
        System.out.println(true);
      }
    }
  }

  /**
  * Tests to make sure the setElement method works properly.
  * Makes sure IllegalArgumentExceptions are thrown for inappropriate i's
  **/
  public static void testSetElementMethod(){
    System.out.println("TESTING SET ELEMENT METHOD");
    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 0, 2, 4});
      t.setElement(1, 4);
      System.out.println(t.toString().equals("[1,4,-3,2,0,0,2,4]"));
    }

    {
      Tuple t = new Tuple(new int[] {3, 3, 5, 5});
      t.setElement(0, -5);
      System.out.println(! t.toString().equals("3,3,5,5"));
      System.out.println(t.toString().equals("[-5,3,5,5]"));
    }

    {
      Tuple t = new Tuple(new int[] {});
      try{
        t.setElement(0, -2);
      }
      catch(IllegalArgumentException e){
          System.out.println(true);
      }
    }

    {
      Tuple t = new Tuple(new int[] {1});
      try{
        t.setElement(1, 4);
      }
      catch(IllegalArgumentException e){
          System.out.println(true);
      }
    }

    {
      Tuple t = new Tuple(new int[] {1, 2, 3, 4});
      try{
        t.setElement(-2, 1);
      }
      catch(IllegalArgumentException e){
        System.out.println(true);
      }
    }
  }

  /**
  * Tests that the length method works properly
  **/
  public static void testLengthMethod(){
    System.out.println("TESTING LENGTH METHOD");
    {
      Tuple t = new Tuple(new int[] {});
      System.out.println(t.length() == 0);
    }

    {
      Tuple t = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.length() == 4);
    }

    {
      Tuple t = new Tuple(new int[] {1, 1, -3, 2, 0, 0, 2, 4});
      System.out.println(t.length() == 8);
    }
  }

  /**
  * Tests that the sum method works properly
  **/
  public static void testSumMethod(){
    System.out.println("TESTING SUM METHOD");
    {
      Tuple t = new Tuple(new int[] {});
      System.out.println(t.sum() == 0);
    }

    {
      Tuple t = new Tuple(new int[] {3, 3, 5, 5});
      System.out.println(t.sum() == 16);
    }

    {
      Tuple t = new Tuple(new int[] {2, 1, 2, 1});
      System.out.println(t.sum() == 6);
    }

    {
      Tuple t = new Tuple(4);
      System.out.println(t.sum() == 0);
    }

    {
      Tuple t = new Tuple(new int[] {1, 2, 3, 4});
      System.out.println(t.sum() == 10);
    }
  }
}
