public class daysInMonth{
  public static void main(String[] args){
    long month = Long.parseLong(args[0]);
    long year = Long.parseLong(args[1]);
    System.out.println(CalendarStuff.daysInMonth(month, year));
  }
}
