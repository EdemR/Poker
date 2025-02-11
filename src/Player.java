import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardsInHand;
    private int wallet;
    private int moneyInPot;
    private boolean isActive;

    public Player(String name, int wallet) {
        this.cardsInHand = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
        this.isActive = true;
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
        return this.name;
    }

    public List<Card> getCardsInHand() {
        return this.cardsInHand;
    }

    public int getWallet() {
        return this.wallet;
    }

    public void changeWallet(String operator, int money) {
        if (operator.equalsIgnoreCase("+")) {
            this.wallet += money;
        } else if (operator.equalsIgnoreCase("-")) {
            this.wallet -= money;
        }
    }

    public int getMoneyInPot() {
        return this.moneyInPot;
    }

    public void addMoneyPot(int moneyInPot) {
        this.moneyInPot += moneyInPot;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
