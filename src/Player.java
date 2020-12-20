import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardsInHand;
    private int wallet;

    public Player(String name, int wallet) {
        this.cardsInHand = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
    }

    public void addCard(Card card) {
        this.cardsInHand.add(card);
    }

    public String printHand() {
        String cardsInHand = this.name +"'s cards and Money: " + this.wallet + "\n";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                cardsInHand += this.cardsInHand.get(j).getCardASCII()[i] + " ";
            }
            cardsInHand += "\n";
        }
        return cardsInHand;
    }

    public String getName() {
        return name;
    }

    public Card getCardInHandByIndex(int index) {
        return cardsInHand.get(index);
    }

    public int getWallet() {
        return wallet;
    }

    public void changeWallet(String operator, int money) {
        if (operator.equalsIgnoreCase("+")) {
            this.wallet += money;
        } else if (operator.equalsIgnoreCase("-")) {
            this.wallet -= money;
        }
    }
}
