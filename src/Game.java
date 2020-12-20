import java.util.*;

public class Game {
    private final List<Player> playerList;
    private final Deck deck = new Deck();
    private List<Card> currentDeck;
    private int moneyPool = 0;
    private Player firstPlayer;
    private Player actualPlayer;
    private final int smallBlind;
    private final int bigBlind;

    public Game() {
        this.playerList = new ArrayList<>();
        this.smallBlind = 500;
        this.bigBlind = 1000;
    }

    public void play() {
        prepareGame();
        showHands();
        showMoneyOfPlayers();
    }

    public void showMoneyOfPlayers() {
        System.out.println("Big blind(" + this.bigBlind + "Ft) from " + this.firstPlayer.getName());
        System.out.println("Small blind(" + this.smallBlind +"Ft) from " + this.actualPlayer.getName());
        System.out.println("Money in the pot = " + this.moneyPool + "Ft");
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i).getName() + "'s wallet = " + playerList.get(i).getWallet() + "Ft");
        }
    }



    public void prepareGame() {
        currentDeck = new ArrayList<>(deck.getCards());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < playerList.size(); j++) {
                int index = new Random().nextInt(currentDeck.size());
                playerList.get(j).addCard(currentDeck.get(index));
                currentDeck.remove(index);
            }
        }

        this.firstPlayer.changeWallet("-", this.bigBlind);
        getNextPlayerInOrder();
        this.actualPlayer.changeWallet("-", this.smallBlind);
        this.moneyPool += this.bigBlind + this.smallBlind;
    }

    private void getNextPlayerInOrder() {
        if (playerList.indexOf(this.actualPlayer) == playerList.size() - 1) {
            this.actualPlayer = playerList.get(0);
        } else {
            this.actualPlayer = playerList.get(playerList.indexOf(this.actualPlayer) + 1);
        }
    }


    public void createPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(i+1 + ". Player! Give me your name");
            String name = new Scanner(System.in).nextLine();
            playerList.add(new Player(name, 20000));
        }
        int randomIndex = new Random().nextInt(playerList.size());
        this.firstPlayer = playerList.get(randomIndex);
        this.actualPlayer = firstPlayer;
    }

    public void showHands() {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i).printHand());
        }
    }
}
