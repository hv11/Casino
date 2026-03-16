import java.util.*;
import SlotMachine.*;
public class CasinoRunner
{
    private double money;
    private Scanner input;
    private String response;
    private double wager;
    
    public static void main(String[] args)
    {
        CasinoRunner runner = new CasinoRunner();
        runner.start();
    }
    
    private void start()
    {
        CasinoRunnerGraphics startScreen = new CasinoRunnerGraphics();
        startScreen.startScreen();
        wager = 0;
        money = 10;
        input = new Scanner(System.in);
        System.out.print("Press enter to start");
        response = input.nextLine();
        menu();
    }
    
    private void menu()
    {
        System.out.println("Which games would you like to play?");
        response = input.nextLine();
        boolean playing = false;
        if(response.equals("Slot Machine"))
        {
            SlotMachine one = new SlotMachine();
            playing = true;
            while(playing)
            {
                System.out.print("How much money do you want to wager?");
                wager = input.nextDouble();
                if(wager>money)
                {
                    System.out.print("Invalid response");
                    wager = input.nextDouble();
                }
                money -= wager;
                money += one.runGame(wager);
                input.nextLine();
                System.out.println("Press Enter to Play Again. Type quit to quit" + money);
                response = input.nextLine();
                if(response.equals("quit"))
                {
                    playing = false;
                }
                
            }
        }
    }
}