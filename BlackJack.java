
import java.lang.reflect.AnnotatedWildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJack {
    public static void main(String[] args) {
        BlackJackGame BlackJackGame = new BlackJackGame();
        // Deck deck = new Deck();
        // Player player =new Player();
        // Player player1 = new Player();
        // Player player2 = new Player();
        // deck.checkCards();
        // player.getCards();
        BlackJackGame.Play();

    }
}

class Card {
    private int value; // (2 - 14)
    private String suit; // "trefla","inima neagra",...

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "<<" + this.value + " " + this.suit + ">>";
    }
}

class CardGame {
    protected List<Card> deck;

    private void initializeDeck() {
        // initializare/pregatire date
        String[] suits = { "🔷", "♥️", "♣️", "🖤" };
        // actiuni
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                System.out.println("cartea " + suit + i);
                deck.add(new Card(i, suit));
            }
        }

    }
}

class Player {
    protected String name;
    protected List<Card> hand;
    protected List<Card> wonCards;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.wonCards = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    public void addWonCards(List<Card> cards) {
        wonCards.addAll(cards);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getScore() { // numarul de carti castigate / 2 = runde castigate
        return wonCards.size();
    }
}

class BlackJackGame extends CardGame {

    private Player humanPlayer;
    private Player aiPlayer;

    public BlackJackGame() {
        this.deck = new ArrayList<>();
        this.humanPlayer = new Player("Andrei");
        this.aiPlayer = new Player("AI Dealer");

    }

    private void initializeDeck() {
        // initializare/pregatire date
        String[] suits = { "🔷", "♥️", "♣️", "🖤" };
        // actiuni
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                System.out.println("cartea " + suit + i);
                deck.add(new Card(i, suit));
            }
        }
        // vad ce returnez
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void dealCards() {
        ArrayList<String> maxCards = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            maxCards.add(deck.get(i));

        }

    }

    public void Play() {
        // System.out.println(initializeDeck());
    }

}

// avem 52 de carti
// shuffle carti
// se da o carte la dealer intoarsa invers(doar dealer ul o vede), dupa o carte
// la jucator, iar la dealer, iar la juctaor
// se face suma(suma totala la ai o stie doar dealer ul)
// 21 inseamna blackjack si castigi instant
// daca ai peste 21 pierzi
// daca ai sub, poti cere inca o carte pe care o bagi la suma(prima oara human,
// dupa care dealer ul)
// cartea as poate lua valoarea 1 sau 11
