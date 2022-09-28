import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {

    ArrayList<String> dataArr = new ArrayList<String>();

    // Read file and store data in an array
    try {
        File myFile = new File("decorator.dat");
        Scanner reader = new Scanner(myFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            dataArr.add(line);
        }
        reader.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error occured.");
        e.printStackTrace();
    }

    // Get file name to write data to
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Enter filename : ");
    String filename = myScanner.nextLine();


    // THIS IS THE OBJECT
    // Output o = new StreamOutput(filename);

    // Output menu of decorators
    System.out.println("Which decorators would you like to apply?\nEnter the numbers (no spaces or commas inbetween numbers)\nof the decorators you would like to apply.");
    System.out.println("*** Decorator Menu ***");
    System.out.println("1 - LineOutput");
    System.out.println("2 - NumberedOutput");
    System.out.println("3 - TeeOutput");
    System.out.println("4 - FilterOutput");

    // Take user input
    System.out.println("\nEnter Decorators : ");
    String decoratorInput = myScanner.nextLine();
    myScanner.close();

    // Use user input to call decorators
    ArrayList<Integer> decoratorsChosen = new ArrayList<Integer>();

    char[] chars = decoratorInput.toCharArray();
    for (char c : chars) {
        if(Character.isDigit(c)) {
            int a = Integer.parseInt(String.valueOf(c));
            decoratorsChosen.add(a);
        } else {
            System.out.println("You entered " + c + " which is not a decorator option.");
        }
    }

    OutputDecorator d = new NumberedOutput(new LineOutput(new StreamOutput(filename)));
    
    // Print strings to file
    for (int j = 0; j < dataArr.size(); j++) {
        d.writeData(dataArr.get(j));
    }
  }
}