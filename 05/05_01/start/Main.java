import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> deckOfCards = new Stack();

        String card1 = "Jack : Diamonds";
        String card2 = "8 : Hearts";
        String card3 = "3 : Clubs";

        deckOfCards.push(card1);
        deckOfCards.push(card2);
        deckOfCards.push(card3);

        System.out.println(deckOfCards);

        // See what's on top w/o removal
        String top = deckOfCards.peek();
        System.out.println("Top: " + top);

        // See size
        System.out.println("Size of Stack: " + deckOfCards.size());
        System.out.println();

        // Remove
        String removedItem = deckOfCards.pop();
    }

}












