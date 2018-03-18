public class CalendarStuff{
  public static void main(String[] args){
    long year = Long.parseLong(args[0]);
    System.out.println(isLeapYear(year));
  }
  public static boolean isLeapYear(long year){
    if (year < 0){
      throw new IllegalArgumentException();
    }
    if (year%4 != 0 || (year%100 == 0 && year%400!=0)) {
      return false;
    }
    else {
      return true;
    }
  }
  public static long daysInMonth(long month, long year) {
    if (month > 12 || month < 1 || year < 0){
      throw new IllegalArgumentException();
    }
    if (month == 2){
      if (isLeapYear(year)){
        return 29;
      }
      else{
        return 28;
      }
    }
    if (month == 11 || month == 4 || month == 6 || month == 9){
      return 30;
    }
    else{
      return 31;
    }
  }
  public static long getJulianDate(long month, long day, long year){
    // Julian date formula from http://scienceworld.wolfram.com/astronomy/JulianDate.html
    long x = (14-month) / 12;
    long y = year+4800 - x;
    long m = month + 12 * x - 3;
    long julianDate = day + (153 * m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
    return julianDate;
  }
  public static long daysBetween(long month0, long day0, long year0, long month1, long day1, long year1){
    if (month0 > 12 || month0 < 1 || month1 > 12 || month1 < 1 || year0 < 0 || year1 < 0 || day0 < 1 || day1 < 1 || day0 > daysInMonth(month0, year0) || day1 > daysInMonth(month1, year1)){
      throw new IllegalArgumentException();
    }
    if (year1 > year0 || (year1 == year0 && month1>month0) || (year1 == year0 && month0 == month1 && day1>day0)){
      return (getJulianDate(month1, day1, year1) - getJulianDate(month0, day0, year0));
    }
    if (year1 < year0 || (year1 == year0 && month0>month1) || (year1 == year0 && month0 == month1 && day0>day1)){
      return (getJulianDate(month0, day0, year0) - getJulianDate(month1, day1, year1));
    }
    return 0;
  }
}
