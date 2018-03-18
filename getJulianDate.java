public class getJulianDate{
  public static void main(String[] args){
    long month = Long.parseLong(args[0]);
    long day = Long.parseLong(args[1]);
    long year = Long.parseLong(args[2]);
    System.out.println(CalendarStuff.getJulianDate(month, day, year));
  }
}
