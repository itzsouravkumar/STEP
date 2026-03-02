public class CardGame extends Game {
    private int numberOfCards;

    CardGame(String title, int numberOfCards) {
        super(title);
        this.numberOfCards = numberOfCards;
    }

    @Override
    public String toString() {
        return super.toString() + ", CardGame with " + numberOfCards + " cards";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CardGame)) return false;
        if (!super.equals(obj)) return false;
        CardGame c = (CardGame) obj;
        return this.numberOfCards == c.numberOfCards;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + numberOfCards;
    }

    public static void main(String[] args) {
        Game g1 = new Game("Chess");
        Game g2 = new Game("Chess");
        CardGame c1 = new CardGame("Poker", 52);
        CardGame c2 = new CardGame("Poker", 52);

        System.out.println(g1.toString());
        System.out.println(c1.toString());

        System.out.println("g1 equals g2: " + g1.equals(g2));
        System.out.println("c1 equals c2: " + c1.equals(c2));
        System.out.println("g1 equals c1: " + g1.equals(c1));
    }
}

class Game {
    protected String title;

    Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game g = (Game) obj;
        return this.title.equals(g.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}