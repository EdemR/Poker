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
    private int totalMoneyToPlay;
    private Player lastPlayer;
    private HandChecker handChecker;

    public Game() {
        this.playerList = new ArrayList<>();
        this.smallBlind = 500;
        this.bigBlind = 1000;
        this.totalMoneyToPlay = this.bigBlind;
    }

    public void play() {
        playRound();
    }

    public void playRound() {
        prepareGame();
        while (true) {
            nextPlayerDecide();
            getNextPlayerInOrder();
            if (getActivePlayers() < 2 || (this.actualPlayer.getName().equalsIgnoreCase(this.lastPlayer.getName()) && this.actualPlayer.getMoneyInPot() == this.totalMoneyToPlay)) {
                break;
            }
        }
        showHands();
        showMoneyOfPlayers();
    }

    private int getActivePlayers() {
        int count = 0;
        for (Player player: playerList) {
            if (player.isActive()) {
                count++;
            }
        }

        return count;
    }

    public void nextPlayerDecide() {
        if (this.actualPlayer.isActive()) {
            if (this.actualPlayer.getMoneyInPot() != this.totalMoneyToPlay) {
                System.out.println(this.actualPlayer.getName() + ":");
                while (true) {
                    System.out.println("Please choose an option:\n1: Raise\n2: Call (" + (this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot()) + "Ft)\n3: Fold\n4: Check(Not Available Now)");
                    String input = new Scanner(System.in).nextLine();
                    if (input.equals("1") || input.equals("2") || input.equals("3")) {
                        moveByInput(input);
                        break;
                    }
                }
            } else {
                System.out.println(this.actualPlayer.getName() + ":");
                while (true) {
                    System.out.println("Please choose an option:\n1: Raise\n2: Call(Not Available Now)\n3: Fold(Not Available Now)\n4: Check");
                    String input = new Scanner(System.in).nextLine();
                    if (input.equals("1") || input.equals("4")) {
                        moveByInput(input);
                        break;
                    }
                }
            }
            showMoneyOfPlayers();
        }
    }

    public void moveByInput(String input) {
        switch (input) {
            case "3":
                this.actualPlayer.setActive(false);
                break;
            case "2":
                this.actualPlayer.changeWallet("-",(this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot()));
                this.moneyPool += (this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot());
                this.actualPlayer.addMoneyPot(this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot());
                break;
            case "1":
                System.out.println("Call: " + (this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot()) + "Ft");
                this.actualPlayer.changeWallet("-",(this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot()));
                this.moneyPool += (this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot());
                this.actualPlayer.addMoneyPot(this.totalMoneyToPlay - this.actualPlayer.getMoneyInPot());
                int raiseAmount = askPlayerToRaise();
                this.actualPlayer.changeWallet("-",(raiseAmount));
                this.moneyPool += raiseAmount;
                this.totalMoneyToPlay += raiseAmount;
                this.actualPlayer.addMoneyPot(raiseAmount);
                this.lastPlayer = this.actualPlayer;
                break;
            default:
                System.out.println(this.actualPlayer.getName() + "IS CHECKED!");
        }
    }

    private int askPlayerToRaise() {
        while (true) {
            System.out.println("How much you want to raise?");
            System.out.println("Your Wallet is: " + this.actualPlayer.getWallet() + "Ft");
            int input = isNumber(new Scanner(System.in).nextLine());
            if (input > 0 && input < this.actualPlayer.getWallet()) {
                return input;
            }
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public void showMoneyOfPlayers() {
        System.out.println("The dealer is " + this.firstPlayer.getName());
//        getNextPlayerInOrder();
//        System.out.println("Small blind(" + this.smallBlind +"Ft) from " + this.actualPlayer.getName());
//        getNextPlayerInOrder();
//        System.out.println("Big blind(" + this.bigBlind + "Ft) from " + this.actualPlayer.getName());
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

        getNextPlayerInOrder();
        this.actualPlayer.changeWallet("-", this.smallBlind);
        this.actualPlayer.addMoneyPot(this.smallBlind);
        getNextPlayerInOrder();
        this.actualPlayer.changeWallet("-", this.bigBlind);
        this.actualPlayer.addMoneyPot(this.bigBlind);
        this.lastPlayer = this.actualPlayer;
        this.moneyPool += this.bigBlind + this.smallBlind;
        getNextPlayerInOrder();
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