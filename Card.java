public class Card{
  private int suit;
  private int value;
  public Card(int value, int suit) {
    this.value = value;
    this.suit = suit;
  }
  public long getSuit(){
    return this.suit;
  }
  public long getValue(){
    return this.value;
  }

  public String toString(){
    String[] suits = new String[]{"DIAMONDS", "HEARTS", "CLUBS", "SPADES"};
    String[] values = new String[]{"Ace", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    deckStr = new Card[52];
    for (int i=0; i<deckStr.length; i++){
      deckStr[i] = (values[this.value] + "of" + suits[this.suit]);
    }
    return deckStr;
  }
}
