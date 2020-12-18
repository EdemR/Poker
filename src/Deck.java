public class Deck {
    private final Card[] cards = new Card[52];

    public Deck() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                Card card = new Card(Card.COLORS[i], j);
                cards[temp++] = card;
            }
        }
    }

    public Card[] getCards() {
        return cards;
    }
}