package common;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scan = new Scanner(System.in);
        String translation;
        String text = "";
        while (!text.equals("!")) { // Exit while loop if user input is "!", further check in logic class
            System.out.println("Please enter either morse (* -) or text to translate: ");
            System.out.println("(type \"!\" to stop)");
            text = scan.nextLine();

                if (text.contains("*") || text.contains("-")) {
                    translation = converter.getCharacters(text);
                } else {
                    translation = converter.getMorse(text);
                }
                System.out.println(translation);
        }
    }
}
