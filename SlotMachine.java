package SlotMachine;
import java.util.*;
public class SlotMachine {
    
    private String[] chosenShapes;
    private final String[] shapeList;
    private Scanner input;
    
    public SlotMachine()
    {
        chosenShapes = new String[3];
        input = new Scanner(System.in);
        shapeList = new String[]{"Triple Bar","Cherry","Single Bar","Lemon","Double Bar","Bell","Seven","Orange","Watermelon","Plum"};
    }
        
    public double runGame(double wager)
    {
        System.out.print("Press Enter to Run ");
        input.nextLine();
        getShapes();
        System.out.println(chosenShapes[0] + " " + chosenShapes[1] + " " + chosenShapes[2]);
        return calculateEarnings(wager);
    }
    
    private double calculateEarnings(double wager)
    {
        for(int i = 0; i < chosenShapes.length;i++)
        {
            addToWager(chosenShapes[i],wager);
        }
        if(getMatchAmount().equals("All Equal"))
        {
            wager *= 1.75;
        }
        else if(getMatchAmount().equals("Some Equal"))
        {
            wager *= 1.25;
        }
        else
        {
            wager *= 0.8;
        }
        return wager;
    }
    
    private double addToWager(String shape, double wager)
    {
        switch(shape)
        {
            case "Triple Bar":
                wager += 1;
                break;              
            case "Cherry":
                wager += 0.05;
                break;
            case "Single Bar":
                wager += 0.33;
                break;
            case "Lemon":
                wager += 0.15;
                break;
            case "Double Bar":
                wager += 0.66;
                break;
            case "Bell":
                wager += 0.5;
                break;
            case "Seven":
                wager += 2;
                break;
            case "Orange":
                wager += 0.2;
                break;
            case "Watermelon":
                wager += 0.25;
                break;
            case "Plum":
                wager += 0.1;
                break;
        }
        return wager;
    }
    
    private void getShapes()
    {
        for(int i = 0; i < chosenShapes.length; i++)
        {
            int num = (int)(Math.random()*10);
            for(int b = 0; b < shapeList.length; b++)
            {
                if(b == num)
                {
                    chosenShapes[i] = shapeList[i];
                    break;
                }
            }
        }
    }
    
    private String getMatchAmount()
    {
        if(chosenShapes[0].equals(chosenShapes[1])&&chosenShapes[0].equals(chosenShapes[2]))
        {
            return "All Equal";
        }
        else if((!chosenShapes[0].equals(chosenShapes[1])&&!chosenShapes[0].equals(chosenShapes[2]))&&!chosenShapes[1].equals(chosenShapes[2]))
        {
            return "Not Equal";
        }
        else
        {
            return "Some Equal";
        }
    }
}