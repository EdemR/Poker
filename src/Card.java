public class Card {
    final static String[] COLORS = new String[]{"Heart", "Clubs", "Diamond", "Spades"};
    private final String[] cardASCII;
    private String color;
    private int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
        cardASCII = new String[9];
        storeCardInArray();
    }

    private void storeCardInArray() {
        String cardValue = this.value == 11 ? "J" : this.value == 12 ? "Q" : this.value == 13 ? "K" : this.value == 14 ? "A" : String.valueOf(this.value);
//        String cardColor = color.equals("Heart") ? "♥" : color.equals("Clubs") ? "♣" : color.equals("Spades") ? "♠" : "♦";
        String cardColor = this.color.equals("Heart") ? " Heart " : this.color.equals("Clubs") ? " Clubs " : this.color.equals("Spades") ? " Spades" : "Diamond";
        cardASCII[0] = "┌───────────┐";
        cardASCII[1] = "│ " + (this.value != 10 ? cardValue + " " : cardValue) + "        │";
        cardASCII[2] = "│           │";
        cardASCII[3] = "│           │";
        cardASCII[4] = "│  " + cardColor + "  │";
        cardASCII[5] = "│           │";
        cardASCII[6] = "│           │";
        cardASCII[7] = "│        " + (this.value != 10 ? " " + cardValue : cardValue) + " │";
        cardASCII[8] = "└───────────┘";
    }

    public String[] getCardASCII() {
        return cardASCII;

    }

    public String valueToString() {
        return this.value == 11 ? "J" : this.value == 12 ? "Q" : this.value == 13 ? "K" : this.value == 14 ? "A" : String.valueOf(this.value);
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}