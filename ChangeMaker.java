public class ChangeMaker{
  public static void main(String[] args){
    try{
      for(int i=0; i<args.length; i++){
        Integer.parseInt(args[i]);
      }
    }
    catch(NumberFormatException nfe){
      throw(new IllegalArgumentException("Malformed Arg"));
    }
    for (int i=0; i<args.length-2; i++){
      for (int j=args.length-2; j>0; j--){
        if (i!=j && Integer.parseInt(args[i]) == Integer.parseInt(args[j])){
          throw(new IllegalArgumentException("Duplicated Denomination"));
        }
      }
    }
    if (args.length < 2){
      throw(new IllegalArgumentException("Insufficient Args"));
    }
    else{
      for(int i=0; i<args.length; i++){
        if (Integer.parseInt(args[i])<0){
          throw(new IllegalArgumentException("Negative Amount"));
        }
        if (Integer.parseInt(args[i]) == 0){
          throw(new IllegalArgumentException("Zero-denominated coin"));
        }
      }
    }
    int amountIndex = args.length - 1;
    int amount = Integer.parseInt(args[amountIndex]);
    Tuple denominations = new Tuple(amountIndex);
    Tuple emptyTuple = new Tuple(0);

    for (int i=0; i<amountIndex; i++){
      denominations.setElement(i, (Integer.parseInt(args[i])));
    }

    Tuple[][] table = new Tuple[amount+1][amountIndex];
    for (int i=0; i<amountIndex; i++){
      for (int j=0; j<=amount; j++){
        if (j==0){
          table[j][i] = new Tuple(denominations.length());
        }
        else{
          if (i==0){
            if (denominations.getElement(i)>j){
              table[j][i] = new Tuple(0);
            }
            else{
              table[j][i] = new Tuple(denominations.length());
              if ((table[j-(denominations.getElement(i))][i]).equals(emptyTuple)){
                table[j][i] = new Tuple(0);
              }
              else{
                Tuple tuple = new Tuple(amountIndex);
                tuple.setElement(i, 1);
                table[j][i] = table[j-(denominations.getElement(i))][i].add(tuple);
              }
            }
          }
          else{
            if (denominations.getElement(i)>j){
              table[j][i] = table[j][i-1];
            }
            else{
              table[j][i] = new Tuple(denominations.length());
              if ((table[j-(denominations.getElement(i))][i]).equals(emptyTuple)){
                table[j][i] = table[j][i-1];
              }
              else{
                Tuple tuple = new Tuple(amountIndex);
                tuple.setElement(i, 1);
                table[j][i] = table[j-(denominations.getElement(i))][i].add(tuple);
                if (!(table[j][i-1].equals(emptyTuple)) && table[j][i].sum() > table[j][i-1].sum()){
                  table[j][i] = table[j][i-1];
                }
              }
            }
          }
        }
      }
    }
    System.out.println(formatResult(denominations, amountIndex, amount, table));
  }

  public static String formatResult(Tuple denominations, int amountIndex, int amount, Tuple[][] table){
    String result = "";
    for (int i=0; i<denominations.length(); i++){
      if (table[amount][amountIndex-1].length()!=0){
        result = result + table[amount][amountIndex-1].getElement(i) + " " + denominations.getElement(i) + "-cent coins\n";
      }
      else{
        result = "IMPOSSIBLE";
      }
    }
    if (table[amount][amountIndex-1].length()!=0){
      result = result + table[amount][amountIndex-1].sum() + " total coins";
    }
    return result;
  }
}
