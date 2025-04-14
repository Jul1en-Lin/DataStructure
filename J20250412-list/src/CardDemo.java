import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[] SUITS = {"♣","♦","♠","♥"};

    //生成卡牌
    public static final List<Card> createCard () {
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j,SUITS[i]);
                list.add(card);
            }
        }
        return list;
    }
    //随机洗牌
    public static final void shuffle (List<Card> cards) {
        Random random = new Random();
        /*for (int i = 0; i < cards.size()-1; i++) {
            int index = random.nextInt();
        }*/
        for (int i = cards.size()-1; i > 0 ; i--) {
            int index = random.nextInt(i);//[0,i)
            swap(cards,i,index);
        }
    }
    public static void swap(List<Card> list,int x,int index) {
        Card tmp = list.get(x);
        list.set(x,list.get(index));
        list.set(index,tmp);
    }
    //三个人，每个人轮流拿五张牌
    public static void main(String[] args) {
        List<Card> cards = createCard();
        List<List<Card>> hands = new ArrayList<>();
        List<Card> person1 = new ArrayList<>();
        List<Card> person2 = new ArrayList<>();
        List<Card> person3 = new ArrayList<>();
        hands.add(person1);
        hands.add(person2);
        hands.add(person3);
        shuffle(cards);
        for (int i = 0; i < hands.size() ; i++) {
            for (int j = 0; j < 5; j++) {
                hands.get(i).add(cards.remove(0));
            }
        }
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
    public static void main1(String[] args) {
        List<Card> cards = createCard();
        System.out.println(cards);
        System.out.println("=======");
        shuffle(cards);
        System.out.println(cards);
    }
}
