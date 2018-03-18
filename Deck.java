public class Deck{
  public static void main (string[] args){
    System.out.println(Deck());
    System.out.println(shuffle());
    System.out.println(cardAt(0));
  }
  // the actual deck
  private Card[] deck;

  // number of cards in deck
  private int counter;
  public Deck(){
    // want to make an array with 52 slots, each pointing to a card object - of type card
    // this below creates the array of 52 slots, but it is empty
    deck = new Card[52];
    // suits = new String[]{"DIAMONDS", "HEARTS", "CLUBS", "SPADES"};
    // values = new String[]{"Ace", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    // counter = 0;
    for (int suit = 0; suit < 4; suit++){
      for (int value = 0; value < 13; value++){
        deck[counter] = new Card(value, suit);
        counter++;
      }
    }
  }
  public void shuffle(){
    for (int i = deck.length-1; i>0; i--){
      int random = (int)(Math.random()*(i+1));
      Card placeHolder = deck[i];
      deck[i] = deck[random];
      deck[random] = placeHolder;
    }
  }
  // public String toString(){
  //   Card deckStr = new String[52];
  //   for (int i=0; i<deckStr.length; i++){
  //     deckStr[i] = (values[(deck[i].value)] + "of" + suits[(deck[i].suit)]);
  //   }
  //   return deckStr;
  // }
  public Card cardAt(int i){
    return deck[i];
  }

}
