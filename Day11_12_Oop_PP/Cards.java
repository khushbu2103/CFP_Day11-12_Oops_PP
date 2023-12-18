package Day11_12_Oop_PP;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
    public static void shuffle(String deck[][])
    {
        List<String[]> al= Arrays.asList(deck);
        Collections.shuffle(al,new Random());
        al.toArray(deck);
    }

    public static void operation(String deck[][], String[][]players)
    {
        int playerCount=players.length;
        int cardsPerPlayer=players[0].length;

        for (int i=0;i<playerCount;i++) {
            for (int j=0;j<cardsPerPlayer;j++) {
                players[i][j]=deck[i*cardsPerPlayer+j][0]+" of "+deck[i*cardsPerPlayer+j][1];
            }
        }
    }
}
class MainCards
{
    public static void main(String[] args)
    {
        String[]suit={"Clubs", "Diamonds", "Hearts", "Spades"};
        String[]rank={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[][]deck=new String[suit.length*rank.length][2];
        int index = 0;
        for (String suit1 : suit) {
            for (String rank1 : rank) {
                deck[index][0] = rank1;
                deck[index][1] = suit1;
                index++;
            }
        }
        Cards ob=new Cards();
        ob.shuffle(deck);
        String player[][]=new String[4][9];
        ob.operation(deck, player);
        for (int i=0;i<player.length;i++) {
            System.out.println("Player "+(i+1)+": "+Arrays.toString(player[i]));
        }
    }
}

