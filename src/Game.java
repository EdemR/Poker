import java.util.*;

public class Game {
    List<Player> playerList = new ArrayList<>();
    List<Card> currentDeck = new ArrayList<>();

    public void createPlayer() {
        System.out.println("Give your name:");
        playerList.add(new Player(new Scanner(System.in).nextLine()));
    }

    public void play() {
        currentDeck = Arrays.asList(new Deck().getCards());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < playerList.size(); j++) {
                int index = new Random().nextInt(currentDeck.size());
                playerList.get(j).addCard(currentDeck.get(index));
//                currentDeck.remove(index);
            }
        }

        showHands();
    }

    public void showHands() {
        for (int i = 0; i < playerList.size(); i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(playerList.get(i).getHand(j));
            }
            System.out.println();
            System.out.println(playerList.get(i).getName());
        }
    }
}
