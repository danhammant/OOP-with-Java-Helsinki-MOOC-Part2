import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hand implements Comparable<Hand>{
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        for (Card card : this.hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(this.hand);
    }

    public int compareTo(Hand hand) {
        return this.totalSum() - hand.totalSum();
    }

    public void sortAgainstSuit() {
        SortAgainstSuitAndValue sort = new SortAgainstSuitAndValue();
        Collections.sort(hand, sort);
    }

    private int totalSum() {
        int totalSum = 0;

        for (Card card : this.hand) {
            totalSum += card.getValue();
        }

        return totalSum;
    }
}
