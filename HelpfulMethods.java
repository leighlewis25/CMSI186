public class HelpfulMethods {
	public static long gcd(long x, long y){
		long result = (x<y)? x: y;
  	while(!(x%result == 0 && y%result == 0)) {
    	result--;
  	}
		return result;
	}
	public static long digitSum(long x) {
		long remainder = 0;
		long sum = 0;
		while (x>0) {
			remainder = x%10;
			sum = sum + remainder;
			x = x/10;
		}
		return sum;
	}
	public static long leastCommonMultiple(long x, long y) {
		long gcd = (x<y)? x: y;
		while (!(x%gcd == 0 && y%gcd == 0)) {
			gcd--;
		}
		long lcm = (x*y)/gcd;
		return lcm;
	}
}
