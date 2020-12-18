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
        String tempNumber = this.value == 11 ? "J" : this.value == 12 ? "Q" : this.value == 13 ? "K" : this.value == 14 ? "A" : String.valueOf(this.value);

        String tempColor = this.color.equals("Heart") ? "\u2665" : this.color.equals("Clubs") ? "\u2663" : this.color.equals("Spades") ? "\u2660" : "\u2666";
        return "  -------------\n" +
                "  | " + (this.value != 10 ? tempNumber + " " : tempNumber) + "        |\n" +
                "  |           |\n" +
                "  |           |\n" +
                "  |     " + tempColor + "     |\n" +
                "  |           |\n" +
                "  |           |\n" +
                "  |        " + (this.value != 10 ? " " + tempNumber : tempNumber) + " |\n" +
                "  -------------";
    }
}