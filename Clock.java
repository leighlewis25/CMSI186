public class Clock{
  private int hours;
  private int minutes;
  private double seconds;
  private double slice;
  public static void main(String args[]){
    Clock clock = new Clock(0, 0, 0, 600.0);
    for (int i = 0; i < 20; i++){
      System.out.println();
      System.out.println(clock.toString());
      clock.advanceTime();
    }
  }
  public Clock(int hours, int minutes, double seconds, double slice){
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    this.slice = slice;
    if (!((this.slice > 0) && (this.slice < 1800))){
      throw (new IllegalArgumentException("Time slice must be between 0 and 1800 seconds"));
    }
  }
  public double slice(){
    return this.slice;
  }
  public int hours(){
    return this.hours;
  }
  public int minutes(){
    return this.minutes;
  }
  public double seconds(){
    return this.seconds;
  }
  public void advanceTime(){
    this.seconds += this.slice % 60;
    this.minutes += (int)this.seconds / 60 + (int)this.slice / 60;
    this.hours += this.minutes / 60;
    this.minutes = this.minutes % 60;
    this.seconds = this.seconds % 60;
  }
  public String toString(){
    return this.hours + ":" + this.minutes + ":" + this.seconds;
  }

}
