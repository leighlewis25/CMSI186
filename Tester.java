public class Tester {
  public static void main(String[] args){
    // testleastCommonMultiple();
    // testdigitSum();
    // testInterchangeableLetters();
    // testIsSubsequence();
    testCalendarStuff();
  }
  public static void testleastCommonMultiple(){
    System.out.println(HelpfulMethods.leastCommonMultiple(12, 8)==24);
    System.out.println(HelpfulMethods.leastCommonMultiple(8, 12)==24);
    System.out.println(HelpfulMethods.leastCommonMultiple(7, 15)==105);
    System.out.println(HelpfulMethods.leastCommonMultiple(1, 3)==3);
    System.out.println(HelpfulMethods.leastCommonMultiple(1, 1)==1);
    // System.out.println(HelpfulMethods.leastCommonMultiple(0, 12)==0);
    System.out.println(HelpfulMethods.leastCommonMultiple(16, 16)==16);
  }
  public static void testdigitSum(){
    System.out.println(HelpfulMethods.digitSum(0)==0);
    System.out.println(HelpfulMethods.digitSum(1)==1);
    System.out.println(HelpfulMethods.digitSum(3)==3);
    System.out.println(HelpfulMethods.digitSum(12)==3);
    System.out.println(HelpfulMethods.digitSum(321)==6);
  }
  public static void testInterchangeableLetters(){
    System.out.println(StringMethods.interchangeableLetters("").equals(""));
    System.out.println(StringMethods.interchangeableLetters("apple").equals("palpe"));
    System.out.println(StringMethods.interchangeableLetters("jackson").equals("ajkcosn"));
    System.out.println(StringMethods.interchangeableLetters("a").equals("a"));
    System.out.println(StringMethods.interchangeableLetters("12234").equals("21324"));
  }
  public static void testIsSubsequence(){
    System.out.println(StringMethods.isSubsequence("", "") == true);
    System.out.println(StringMethods.isSubsequence("an", "jackson") == true);
    System.out.println(StringMethods.isSubsequence("bac", "bbabbabacab") == true);
    System.out.println(StringMethods.isSubsequence("jon", "jaco") == false);
  }
  public static void testCalendarStuff(){
    System.out.println("TESTING is Leap Year");
    System.out.println(CalendarStuff.isLeapYear(2004));
    System.out.println(!CalendarStuff.isLeapYear(2003));
    System.out.println(!CalendarStuff.isLeapYear(1700));
    System.out.println(!CalendarStuff.isLeapYear(1900));
    System.out.println(CalendarStuff.isLeapYear(1600));
    System.out.println("TESTING Days in Month");
    System.out.println(CalendarStuff.daysInMonth(1, 1998) == 31);
    System.out.println(CalendarStuff.daysInMonth(2, 2004) == 29);
    System.out.println(CalendarStuff.daysInMonth(2, 1900) == 28);
    System.out.println(CalendarStuff.daysInMonth(3, 1700) == 31);
    System.out.println(CalendarStuff.daysInMonth(4, 2004) == 30);
    System.out.println(CalendarStuff.daysInMonth(5, 2004) == 31);
    System.out.println(CalendarStuff.daysInMonth(6, 1900) == 30);
    System.out.println(CalendarStuff.daysInMonth(7, 2004) == 31);
    System.out.println(CalendarStuff.daysInMonth(8, 2004) == 31);
    System.out.println(CalendarStuff.daysInMonth(9, 1700) == 30);
    System.out.println(CalendarStuff.daysInMonth(10, 2004) == 31);
    System.out.println(CalendarStuff.daysInMonth(11, 2001) == 30);
    System.out.println(CalendarStuff.daysInMonth(12, 2004) == 31);
    System.out.println("TESTING Days Between");
    System.out.println(CalendarStuff.daysBetween(2, 1, 2004, 3, 5, 2008) == 1494);
    System.out.println(CalendarStuff.daysBetween(2, 29, 2003, 3, 5, 2008));
    // NEED VARIETY CASES
    System.out.println(CalendarStuff.daysBetween(3, 1, 2005, 2, 28, 1998) == 2558);
    System.out.println(CalendarStuff.daysBetween(3, 1, 2005, 2, 28, 2005) == 1);
  }
}
