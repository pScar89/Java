//Feb 26, 2021

//This is program which simulates the core gameplay loop
//of craps. It does not include any betting

import java.util.Scanner;

class Craps
{
    public static void main(String[] args)
    {
      do
      {
        gamePlay();
      } while (morePlay());
    }

    //Method which determines continue condition for the main loop
    public static boolean morePlay()
    {
      Scanner input = new Scanner(System.in);
      System.out.println("\nKeep playing? y/n: ");
      String playMore = input.nextLine();
      playMore = playMore.toLowerCase();
      switch (playMore)
      {
        case "y":
          return true;
        case "n":
          return false;
        default:
          return morePlay();
      }
    }

    public static void gamePlay()
    {
      //Calling method to roll die
      int dieRolls[] = rolling();

      //Check for value and give appropriate response.
      switch (dieRolls[2])
      {
        case 2:
        case 3:
        case 12:
          System.out.println("Craps! You lose.");
          break;
        case 7:
        case 11:
          System.out.println("Natural! You win!");
          break;
        //If a point is set, calls a method for that
        default:
          pointPlay(dieRolls[2]);
      }
    }

    //Recursive method
    public static void pointPlay(int point)
    {
        System.out.println("Point is " + point);
        int pointRolls[] = rolling();
        if (pointRolls[2] == 7)
            System.out.println("7! You lose.");
        else if (pointRolls[2] == point)
            System.out.println("Point! You win.");
        else
            pointPlay(point);
    }

    //Rolls 2 "die" and returns the values of both plus the total
    public static int[] rolling()
    {
        int die1 = (int)(Math.random() * 5 + 1);
        int die2 = (int)(Math.random() * 5 + 1);
        int dieTotal = (die1 + die2);

        System.out.println("You rolled " + die1 + " + " + die2 + " = " + dieTotal + "\n");

        int rolls[] = {die1, die2, dieTotal};

        return rolls;
    }
}