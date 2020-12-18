public class Card {
    final static String[] COLORS = new String[]{"Heart", "Clubs", "Diamond", "Spades"};
    private String color;
    private int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        String temp = this.value == 11 ? "J" : this.value == 12 ? "Q" : this.value == 13 ? "K" : this.value == 14 ? "A" : String.valueOf(this.value);
        return "  -------------\n" +
                "  | " + temp + "         |\n" +
                "  |           |\n" +
                "  |           |\n" +
                "  |   " + this.color + "   |\n" +
                "  |           |\n" +
                "  |           |\n" +
                "  |         " + temp + " |\n" +
                "  -------------";
    }
}