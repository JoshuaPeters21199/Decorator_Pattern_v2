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
    System.out.println("Enter filename: ");
    String filename = myScanner.nextLine();
    myScanner.close();

    // Output menu of decorators
    Scanner menuScanner = new Scanner(System.in);
    System.out.println("Which decorators would you like to apply?\nEnter the numbers (no spaces or commas inbetween numbers)\nof the decorators you would like to apply.");
    System.out.println("*** Decorator Menu ***");
    System.out.println("1 - LineOutput");
    System.out.println("2 - NumberedOutput");
    System.out.println("3 - TeeOutput");
    System.out.println("4 - FilterOutput");

    // Take user input
    while (menuScanner.hasNextLine()) {
        String decoratorSelection = menuScanner.nextLine();
    };
    menuScanner.close();

    // Use user input to call decorators
    ArrayList<Integer> decoratorsChosen = new ArrayList<Integer>();

    char[] chars = decoratorSelection.toCharArray();
    for (char c : chars) {
        if(Character.isDigit(c)) {
            int a = Integer.parseInt(String.valueOf(c));
            decoratorsChosen.add(a);
        } else {
            System.out.println("You entered " + c + " which is not a decorator option.");
        }
    }

    System.out.println(decoratorsChosen);
    
    // OutputDecorator o = new LineOutput(new StreamOutput(filename));
    Output o = new StreamOutput(filename);

    for (int i = 0; i < dataArr.size(); i++) {
        o.writeData(dataArr.get(i));
    }
  }
}