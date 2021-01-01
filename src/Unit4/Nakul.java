package Unit4;

public class Nakul {
}

    /** QUESTION #1 **/

    /** The method longestStreak is intended to determine the longest substring of consecutive identical characters in the parameter str and print the result.
        For example, the call longestStreak("CCAAAAATTT!") should print the result "A 5" because the longest substring of consecutive identical characters is "AAAAA". **/

class Consecutive{

    public Consecutive() { // Default constructor so as to not return any erros
    }

    public void longestStreak(String str) {
        int temp = 0;
        String character = "";
        int length = str.length();
        int totalConsecutive = 0;

        for (int i = 0; i < length-1; i++) {
            String first = str.substring(i, i+1);
            String second = str.substring(i+1, i+2);

            if (first.equals(second)){
                temp++;
            }
            else {
                temp++;
                if (temp > totalConsecutive) {
                    totalConsecutive = temp;
                    temp = 0;
                    character = first;
                }
            }

        }
        System.out.println(character + " " + totalConsecutive);
    }

    public static void main (String[] args){
        Consecutive consecutive = new Consecutive();
        consecutive.longestStreak("GGSJJJFKKASKASKASSSSSS");
    }

}

    /** QUESTION #2 **/

    /** This question involves a simulation of a two-player game.
        In the game, two simulated players each start out with an equal number of coins. In each round, each player chooses to spend either 1, 2, or 3 coins.
        Coins are then awarded to each player according to the following rules.
        Same rule: If both players spend the same number of coins, player 2 gains 1 coin.
        Off-by-one rule: If the players do not spend the same number of coins and the positive difference between the number of coins spent by the two players is 1, player 2 is awarded 1 coin.
        Off-by-two rule: If the players do not spend the same number of coins and the positive difference between the number of coins spent by the two players is 2, player 1 is awarded 2 coins.
        The game ends when the specified number of rounds have been played or when a player’s coin count is less than 3 at the end of a round. **/

class CoinGame {

    private int startingCoins; // starting number of coins
    private int maxRounds; // maximum number of rounds played


    public CoinGame(int s, int r) {
        startingCoins = s;
        maxRounds = r;
    }


    /** Returns the number of coins (1, 2, or 3) that player 1 will spend **/

    public int getPlayer1Move() {
        int result = (int) (Math.random() * 3) + 1;
        return result;
        // I just made this return a random integer value from 1 to 3 because there is no strategy
        // or implementation CollegeBoard requires for player one
    }


    /** Returns the number of coins (1, 2, or 3) that player 2 will spend **/

    /** PART (a): You will write method getPlayer2Move, which returns the number of coins that player 2 will spend in a given round of the game.
        In the first round of the game, the parameter round has the value 1, in the second round of the game, it has the value 2, and so on.
        The method returns 1, 2, or 3 based on the following rules.
        If round is divisible by 3, then return 3.
        If round is not divisible by 3 but is divisible by 2, then return 2.
        If round is not divisible by 3 and is not divisible by 2, then return 1. **/

    public int getPlayer2Move(int round) {
        int result = 0;

        if ((round % 3) == 0){
            result = 3;
        }
        else if ((round % 2) == 0){
            result = 2;
        }
        else {
            result = 1;
        }

        return result;
    }


    /** Plays a simulated game between two players **/

    /** PART (b): Write the method playGame, which simulates a game between player 1 and player 2, based on the rules and example shown at the beginning of the question.

        Both player 1 and player 2 start the game with startingCoins coins.
        Computer player 1 spends 1, 2, or 3 coins based on the value returned by the method getPlayer1Move().
        Computer player 2 spends 1, 2, or 3 coins based on the value returned by the method getPlayer2Move().

        The game ends when maxRounds rounds have been played or when a player’s coin count is less than 3 at the end of a round.
        At the end of the game, the winner is determined according to the following rules.

        If both players have the same number of coins at the end of the game, the method prints "tie game".
        If player 1 has more coins than player 2, the method prints "player 1 wins".
        If player 2 has more coins than player 1, the method prints "player 2 wins". **/

    public void playGame() {
        int CoinsP1 = startingCoins;  // Initializing P1 starting coins
        int CoinsP2 = startingCoins;  // Initializing P2 starting coins

        int Player1Move; // Initializing variables for P1 coin spending
        int Player2Move; // Initializing variables for P2 coin spending

        int round; // Initializing variable to save current round number while playing

        // This "for loop" below is the main body of the program and this iterates through the max number of rounds and
        // the loop will stop once the max number of rounds has been reached and played
        for (round = 1; round <= maxRounds; round++) {
            Player1Move = getPlayer1Move();        // Gets the coins that player 1 spends for that round
            Player2Move = getPlayer2Move(round);   // Gets the coins that player 2 spends for that round

            // The bottom set of "if statements" calculates the positive different between how much each player spends
            // and then depending on whether it is 0, 1, or 2, executes different operations while calculating
            // the final total of each players coins at the end of the round.
            if (Math.abs(Player1Move - Player2Move) == 0) {
                CoinsP1 = CoinsP1 - Player1Move;
                CoinsP2 = CoinsP2 - Player2Move + 1;
            }
            else if (Math.abs(Player1Move - Player2Move) == 1) {
                CoinsP1 = CoinsP1 - Player1Move;
                CoinsP2 = CoinsP2 - Player2Move + 1;
            }
            else if (Math.abs(Player1Move - Player2Move) == 2) {
                CoinsP1 = CoinsP1 - Player1Move + 2;
                CoinsP2 = CoinsP2 - Player2Move;
            }

            // The outer "if statement" is for if any player has less than three coins at the end of
            // this round. If true is returned, the program will execute the inner set of "if statements" which
            // check to see which player won, or if they tied using the win conditions given by CollegeBoard
            if ((CoinsP1 < 3 || CoinsP2 < 3)) {
                if (CoinsP1 > CoinsP2) {
                    System.out.println("player 1 wins");
                    System.exit(0);
                }
                else if (CoinsP2 > CoinsP1) {
                    System.out.println("player 2 wins");
                    System.exit(0);
                }
                else {
                    System.out.println("tie game");
                    System.exit(0);
                }
            }
        }

        // The bottom set of "if statements" are exactly the same as the inner set of "if statements" above, inside
        // the "for loop". It has to be placed again here in the event that none of the players have less than three coins
        // after the max number of rounds have been played. Again, it is for checking who won using given win conditions.
        if (CoinsP1 > CoinsP2) {
            System.out.println("player 1 wins");
            System.exit(0);
        }
        else if (CoinsP2 > CoinsP1) {
            System.out.println("player 2 wins");
            System.exit(0);
        }
        else {
            System.out.println("tie game");
            System.exit(0);
        }
    }

    public static void main(String[] args){
        CoinGame coinGame = new CoinGame(20, 10); // Initializes the starting coins to be 20 and the max rounds to be 10
        coinGame.playGame(); // Executes the playGame method which simulates the game. As the number of coins that player one
                             // spends is completely random, the winner for each game will be completely random as well
    }

}
