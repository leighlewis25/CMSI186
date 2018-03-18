public class ClockSolver{
  public static void main(String args[]){
    double slice;
    if (args.length == 0){
      slice = 60;
    }
    else{
      slice = Double.parseDouble(args[0]);
    }
    Clock clock = new Clock(0, 0, 0.0, slice);
    clock.advanceTime();
    double changeOfAngle = getAngleChange(clock);
    double maximumAngle180 = (180 + changeOfAngle/2);
    double minimumAngle180 = (180 - changeOfAngle/2);
    double maximumAngle270 = (270 + changeOfAngle/2);
    double minimumAngle270 = (270 - changeOfAngle/2);
    double maximumAngle90 = (90 + changeOfAngle/2);
    double minimumAngle90 = (90 - changeOfAngle/2);
    while (clock.hours() < 12){
      if ((getAngleChange(clock) > minimumAngle180 && getAngleChange(clock) < maximumAngle180) || (getAngleChange(clock)> minimumAngle270 && getAngleChange(clock)< maximumAngle270) || (getAngleChange(clock)>minimumAngle90 && getAngleChange(clock)<maximumAngle90)){
        System.out.println(clock.toString());
      }
      clock.advanceTime();
    }
  }
  public static double getAngleChange(Clock clock){
    double minuteHandChange = (clock.seconds() + clock.minutes()*60)*.1;
    double hourHandChange = (minuteHandChange + (clock.hours()*3600)*.1) / 12;
    double angleChange = Math.abs(minuteHandChange - hourHandChange);
    return angleChange;
  }
}
