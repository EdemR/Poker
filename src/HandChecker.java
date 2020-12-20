import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandChecker {
    private List<Player> playerList;

    public HandChecker(List<Player> playerList) {
        this.playerList = new ArrayList<>(playerList);
        removeInactivePlayers();
    }

    private void removeInactivePlayers() {
        for (int i = 0; i < playerList.size(); i++) {
            if (!playerList.get(i).isActive()) {
                playerList.remove(i);
                i--;
            }
        }
    }

    public int getStrengthOfHand(Player player) {
        if (isRoyalFlush(player.getCardsInHand())) {
            return 9;
        } else if (isStraightFlush(player.getCardsInHand())) {
            return 8;
        } else if (isQuad(player.getCardsInHand())) {
            return 7;
        } else if (isFullHouse(player.getCardsInHand())) {
            return 6;
        } else if (isFlush(player.getCardsInHand())) {
            return 5;
        } else if (isStraight(player.getCardsInHand())) {
            return 4;
        } else if (isTriple(player.getCardsInHand())) {
            return 3;
        } else if (isTwoPair(player.getCardsInHand())) {
            return 2;
        } else if (isPair(player.getCardsInHand())) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isRoyalFlush(List<Card> cards) {
        List<Integer> valuesInOrder = putValueInListInOrder(cards);
        return valuesInOrder.get(valuesInOrder.size() - 1) == 14 && cardsInHandInOrder(cards) && cardsInHandSameColor(cards);
    }

    private boolean isStraightFlush(List<Card> cards) {
        return cardsInHandInOrder(cards) && cardsInHandSameColor(cards);
    }

    private boolean isQuad(List<Card> cards) {
        List<Integer> listOfCards = putValueInListInOrder(cards);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (listOfCards.get(i).equals(listOfCards.get(2))) {
                count++;
            }
        }

        return count == 4;
    }

    private boolean isFullHouse(List<Card> cards) {
        List<Integer> listOfCards = putValueInListInOrder(cards);

        if (listOfCards.get(2).equals(listOfCards.get(3))) {
            for (int i = 3; i < 5; i++) {
                if (!listOfCards.get(i).equals(listOfCards.get(2))) {
                    return false;
                }
            }
            return listOfCards.get(0).equals(listOfCards.get(1));
        } else {
            for (int i = 1; i >= 0; i--) {
                if (!listOfCards.get(i).equals(listOfCards.get(2))) {
                    return false;
                }
                return listOfCards.get(3).equals(listOfCards.get(4));
            }
        }
        return false;
    }

    private boolean isFlush(List<Card> cards) {
        return cardsInHandSameColor(cards);
    }

    private boolean isStraight(List<Card> cards) {
        return cardsInHandInOrder(cards);
    }

    private boolean isTriple(List<Card> cards) {
        List<Integer> listOfCards = putValueInListInOrder(cards);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (listOfCards.get(i).equals(listOfCards.get(2))) {
                count++;
            }
        }

        return count == 3;
    }

    private boolean isTwoPair(List<Card> cards) {
        List<Integer> listOfCards = putValueInListInOrder(cards);
        int count = 0;
        int db = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (listOfCards.get(i).equals(listOfCards.get(j))) {
                    count++;
                }
                if (count == 2) {
                    listOfCards.set(i, 0);
                    db++;
                    if (db == 2) {
                        return true;
                    }
                }
            }
            count = 0;
        }
        return false;
    }

    private boolean isPair(List<Card> cards) {
        List<Integer> listOfCards = putValueInListInOrder(cards);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (listOfCards.get(i).equals(listOfCards.get(j))) {
                    count++;
                }
                if (count == 2) return true;
            }
            count = 0;
        }
        return false;
    }


    private boolean cardsInHandSameColor(List<Card> cards) {
        String color = cards.get(0).getColor();
        for (int i = 1; i < 5; i++) {
            if (cards.get(i).getColor() != color) {
                return false;
            }
        }
        return true;
    }

    private boolean cardsInHandInOrder(List<Card> cards) {
        List<Integer> valuesInOrder = putValueInListInOrder(cards);
        for (int i = 1; i < 5; i++) {
            if (valuesInOrder.get(i) != valuesInOrder.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> putValueInListInOrder(List<Card> cards) {
        List<Integer> valuesInOrder = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            valuesInOrder.add(cards.get(i).getValue());
        }
        Collections.sort(valuesInOrder);
        return valuesInOrder;
    }
    
}

/*  High Card 0
 *   Pair 1
 *   Two Pairs 2
 *   Three of a Kind 3
 *   Straight 4
 *   Flush 5
 *   Full House 6
 *   Four of a Kind 7
 *   Straight Flush 8
 *   Royal Flush 9
 * */