import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int wallet = 50000;

    public Player(String name) {
        hand = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card getHand(int index) {
        return hand.get(index);
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

}
