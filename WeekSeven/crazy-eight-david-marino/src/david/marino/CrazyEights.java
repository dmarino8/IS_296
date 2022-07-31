package david.marino;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class CrazyEights extends MyWindow {
    private Deck deck = new Deck();
    private Hand myHand = new Hand();
    private Hand computerHand = new Hand();
    private Card discard;
    private ArrayList<Card> discardPile = new ArrayList<Card>();
    private Random rand = new Random();
    private char activeSuit = ' ';
    private int countHearts = 0;
    private int countDiamonds = 0;
    private int countClubs = 0;
    private int countSpades = 0;

    public CrazyEights () {
        for (int i = 0; i < 7; i++) {
            Card card1 = deal();
            myHand.add(card1);
            Card card2 = deal();
            computerHand.add(card2);
        }
        discard = deal();
        if (discard.getRank() == '8') {
            activeSuit = discard.getSuit();
        } else {
            activeSuit = ' ';
        }
        int turn = rand.nextInt(2);
        if (turn == 1) {
            print("Computer goes first.");
            playComputerCard();
        } else {
            print("You go first.");
        }

        boolean done = false;
        while (!done) {
            playMyCard();
            if (myHand.size() == 0) {
                done = true;
            } else {
                playComputerCard();
                if (computerHand.size() == 0) {
                    done = true;
                }
            }
        }
        print();
        if (myHand.size() == 0) {
            if (myHand.size() == 0) {
                print("Congratulations! You won! The computer still had " + computerHand.size() + " cards.");
            } else {
                print("Sorry, you lost. You still had " + myHand.size() + " cards.");
                print("My Hand : " + myHand);
                print("Discard: " + discard);
            }
        }
    }
    private Card deal() {
        if (deck.size() == 0) {
            deck.reuse(discardPile);
            deck.shuffle();
            discardPile.clear();
            print();
            print("Reshuffled the discard pile.");
        }
        Card card = deck.deal();
        return card;
    }

    public void showStatus() {
        print();
        print("Computer has " + computerHand.size() + " cards.");
        print("Discard: " + discard);
        print("My Hand : " + myHand);
        if (discard.getRank() == '8') {
            print("Suit is " + activeSuit);
        }
    }

    public boolean isValidPlay(String rankSuit) {
        boolean validPlay = true;
        Card card = new Card(rankSuit);
        if (!card.isValid()) {
            print(rankSuit + " is not a valid card");
            validPlay = false;
        } else if (!myHand.contains(card)) {
            print(rankSuit + " is not in your hand");
            validPlay = false;
        } else if (card.getRank() != '8') {
            System.out.println("got here");
            if (discard.getRank() == '8') {
                if (card.getSuit() != activeSuit) {
                    print(rankSuit + " cannot be played on " + discard + " because the suit was set to " + activeSuit);
                    validPlay = false;
                }
            } else if ((card.getSuit() != discard.getSuit()) && (card.getRank() != discard.getRank())) {
                System.out.println(rankSuit = " cannot be played on " + discard + ".");
                validPlay = false;
            }
        }
        return validPlay;
    }
    private void playMyCard() {
        showStatus();
        boolean validPlay = false;
        while (!validPlay) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which card do you want to play (or D to draw)?");
            String rankSuit = input.nextLine();
            if (rankSuit.equals("D")) {
                drawMyCard();
                validPlay = true;
            } else if (isValidPlay(rankSuit)) {
                Card selectedCard = new Card(rankSuit);
                discardMyCard(selectedCard);
                validPlay = true;
            }
        }
    }
    public void drawMyCard() {
        //Card drewCard = new Card("8H");
        Card drewCard = deal();
        System.out.println("");
        System.out.println("You drew " + drewCard);
        myHand.add(drewCard);

        if (isValidPlay(drewCard.toString())) {
            System.out.println("You played " + drewCard);
            discardMyCard(drewCard);
        }
    }

    private void discardMyCard (Card myCard) {
        myHand.remove(myCard);
        discardPile.add(discard);
        discard = myCard;
        if (myCard.getRank() == '8') {
            activeSuit = promptForSuit();
        }
    }

    private void discardComputerCard(Card computerCard) {
        computerHand.remove(computerCard);
        discard = computerCard;
        if (discard.getRank() == '8') {
            int highestCount = countHearts;
            activeSuit = 'H';
            if (countDiamonds > highestCount) {
                highestCount = countDiamonds;
                activeSuit = 'D';
            }
            if (countClubs > highestCount) {
                highestCount = countClubs;
                activeSuit = 'C';
            }
            if (countSpades > highestCount) {
                highestCount = countSpades;
                activeSuit = 'S';
            }
        }
    }
    private void playComputerCard() {
        System.out.println("Computer hand: " + computerHand);
        ArrayList<Card> playableCards = new ArrayList<Card>();
        ArrayList<Card> eights = new ArrayList<Card>();
        countHearts = 0;
        countDiamonds = 0;
        countClubs = 0;
        countSpades = 0;

        for (int i = 0; i < computerHand.size(); i++) {
            Card card = computerHand.cardAt(i);
            if (card.getRank() == '8') {
                eights.add(card);
            } else {
                switch(card.getSuit()) {
                    case 'H':
                        countHearts++;
                        break;
                    case 'D':
                        countDiamonds++;
                        break;
                    case 'C':
                        countClubs++;
                        break;
                    case 'S':
                        countSpades++;
                        break;
                }
            }
        }
        for (int i = 0; i < computerHand.size(); i++) {
            Card card = computerHand.cardAt(i);
            if (discard.getRank() == '8') {
                if (card.getSuit() == activeSuit) {
                    playableCards.add(card);
                }
            }
            if (card.getSuit() == (discard.getSuit()) || card.getRank() == (discard.getRank())) {
                playableCards.add(card);
            }
        }
        int numberOfPlayableCards = playableCards.size();
        if (numberOfPlayableCards > 0) {
            int pick = rand.nextInt(numberOfPlayableCards);
            Card playedCard = playableCards.get(pick);
            discardComputerCard(playedCard);
        } else if (eights.size() > 0) {
            Card playedCard = eights.get(0);
            discardComputerCard(playedCard);
        } else {
            Card drewCard = deal();
            computerHand.add(drewCard);
            System.out.println("");
            System.out.println("Computer draw a card.");
            if (drewCard.getSuit() == discard.getSuit() || drewCard.getRank() == discard.getRank()) {
                discardComputerCard(drewCard);
            }
        }
    }
    private char promptForSuit() {
        char suit = ' ';
        boolean validSuit = false;
        while (!validSuit) {
            suit = promptForChar("Change the suit to H, D, C, or S?");
            suit = Character.toUpperCase(suit);
            if (Card.isValidSuit(suit)) {
                validSuit = true;
            }
        }
        return suit;
    }
    public static void main(String[] args) {
        new CrazyEights();
    }
}