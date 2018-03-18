public class StringMethods {
  public static String interchangeableLetters(String s) {
		String interchanged = s;
		char[] interchangedChars = interchanged.toCharArray();
    if ( s.length() <= 1 ) {
      return s;
    }
    else {
      if (s.length()%2 != 0){
        for (int i=0; i<s.length()-1; i++){
          if (i%2!=0) {
            interchangedChars[i] = s.charAt(i-1);
          }
          else{
            interchangedChars[i] = s.charAt(i+1);
          }
        }
      }
      else {
        for (int i=0; i<s.length(); i++){
          if (i%2!=0) {
            interchangedChars[i] = s.charAt(i-1);
          }
          else{
            interchangedChars[i] = s.charAt(i+1);
          }
        }
      }
      interchanged = String.valueOf(interchangedChars);
      return interchanged;
    }
  }
	public static boolean isSubsequence(String s, String t){
		int subIndex = 0;
    if (s.equals("")) {
      return true;
    }
    else{
  		for (int i=0; i<t.length(); i++){
  			if (s.charAt(subIndex) == t.charAt(i)){
  				subIndex += 1;
  				if (subIndex == s.length()){
  					return true;
  				}
  			}
  		}
      return false;
    }
	}
}
