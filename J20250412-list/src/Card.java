public class Card {
    public int rank;//牌面值
    public String suit;//花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "{" +
                  rank +
                ", " + suit +
                '}';
    }
}
