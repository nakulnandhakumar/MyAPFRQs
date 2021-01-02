package Unit4.Andrew;


import java.util.Random;

public class Andrew {
    public static void main(String[] args) {
        LongStreak longStreak = new LongStreak("CCAAAAATTT!");
        CoinGame coinGame = new CoinGame(10,5);

    }
}

class LongStreak
{
    String streak;
    LongStreak(String pass)
    {
        this.streak = pass;
        Consectuive();
    }
    private void Consectuive()
    {
        int currentsum= 1;
        int prevsum =0;
        char index = ' ';
        for (int i=0; i<streak.length()-1;i++)
        {
            if (streak.charAt(i) == streak.charAt(i+1))
            {

                currentsum++;
                if (prevsum<currentsum)
                {
                    index=  streak.charAt(i);
                }
            }
            else
            {
                currentsum=1;
            }
            prevsum = Math.max(currentsum,prevsum);
        }
        System.out.println(prevsum +" "+  index );
    }

}

class CoinGame
{

    private int startingCoins; // starting number of coins

    private int maxRounds; // maximum number of rounds played



    public CoinGame(int s, int r)

    {

        startingCoins = s;

        maxRounds = r;
        playGame();

    }



    /** Returns the number of coins (1, 2, or 3) that player 1 will spend.

     */

    public int getPlayer1Move()

    {

        Random random = new Random(System.currentTimeMillis()/20);

        /* implementation not shown. */
        return random.nextInt(3)+1;

    }



    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).

     */

    public int getPlayer2Move(int round)
    {

        /* to be implemented in part (a) */
        if (round%3==0)
        {
            return 3;
        }
        else if(round%2==0)
        {
            return 2;
        }
        else
            return 1;

    }



    /** Plays a simulated game between two players, as described in part (b).

     */

    public void playGame()

    {
        int player1coins = startingCoins;
        int player2coins = startingCoins;
        for (int i =1; i<=maxRounds; i++)
        {
            if (player1coins<3)
            {
                break;
            }
            if (player2coins<3)
            {
                break;
            }

            int player1move = getPlayer1Move();
            int player2move = getPlayer2Move(i);
            if (Math.abs((player1move-player2move))==0)
            {
                player1coins-= player1move;
                player2coins-=player2move-1;
            }
            else if (Math.abs(player1move-player2move)==1)
            {
                player1coins-=player1move;
                player2coins-=player2move-1;
            }
            else
            {
                player1coins-=player1move-2;
                player2coins-=player2move;
            }
        }
        if (player1coins>player2coins)
        {
            System.out.println("player one wins");
        }
        if (player2coins>player1coins)
        {
            System.out.println("player two wins");
        }
        else if (player2coins==player1coins)
        {
            System.out.println("tie game");
        }
        /* to be implemented in part (b) */

    }

}



