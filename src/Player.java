public class Player {
    private String name;
    private int hand;
    private int wallet = 10;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHand() {
        return hand;
    }

    public void setHand(int hand) {
        this.hand = hand;
    }

    public int getWallet() {
        return wallet;
    }
}
