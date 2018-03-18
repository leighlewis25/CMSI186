// javac is the compiler command - when you type javac then the file name, if you see something, then there is something wrong with your program
// java HelloWorld will run your code -- (drop extension, so drop .java)

// public - means any file can use it; main - name of the function - a function/method called main - java starts at main
// two first public lines will most likely always be there; whatever you call the "class" after public class, will be what you name the file

// System.out.println(); - this is similar to console.log; don't forget ";"
// args[0] is whatever you type in commandline after java HelloWorld - accepts arguments directly from commandline

// int in a for loop in java
// you declare variables in java by name and type: int x or String[] y
// wants to know what type of data you plan to store in a variable
// Integer.parseInt(args[i]) - will turn a string into an int

// THIS WILL ADD NUMBERS IN AN ARRAY
// it will still break if you enter letters/words because you are attempting to do a parseInt on something that isn't a NUMBERS
// use a try catch to check for a mistake like this
// *** how do we make sure to make the error message friendlier than an error message if we don't type arguments??? Use another try catch
// ** the catch argument will be whatever is in the error statement
// try catch will tell the user what went wrong in a more clear way


public class HelloWorld {
  public static void main(String[] args) {
    try {
      int total = 0;
      for (int i=0; i<args.length; i++) {
        total = total + Integer.parseInt(args[i]);
      }
      System.out.println(total);
    } catch(NumberFormatException nfexc) {
      System.out.println("Please supply all numbers as input");
    }
}
}
