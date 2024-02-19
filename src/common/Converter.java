package common;

import java.util.Arrays;
import java.util.HashMap;


public class Converter {
    private final HashMap<String, String> morseTranslator; //Recommends final here and string under as well
    private final String endOfProgram = "Closing...";
    private final String wrongInput = "Wrong input, try again";

    public Converter() {
        morseTranslator = new HashMap<>();
        morseTranslator.put("A", "*-"); //Added " " after each morse for easy separation, definitely possible to
        morseTranslator.put("B", "-***"); //add " " in get method instead but could not properly solve it...
        morseTranslator.put("C", "-*-*");
        morseTranslator.put("D", "-**");
        morseTranslator.put("E", "*");
        morseTranslator.put("F", "**-*");
        morseTranslator.put("G", "--*");
        morseTranslator.put("H", "****");
        morseTranslator.put("I", "**");
        morseTranslator.put("J", "*---");
        morseTranslator.put("K", "-*-");
        morseTranslator.put("L", "*-**");
        morseTranslator.put("M", "--");
        morseTranslator.put("N", "-*");
        morseTranslator.put("O", "---");
        morseTranslator.put("P", "*--*");
        morseTranslator.put("Q", "--*-");
        morseTranslator.put("R", "*-*");
        morseTranslator.put("S", "***");
        morseTranslator.put("T", "-");
        morseTranslator.put("U", "**-");
        morseTranslator.put("V", "***-");
        morseTranslator.put("W", "*--");
        morseTranslator.put("X", "-**-");
        morseTranslator.put("Y", "-*--");
        morseTranslator.put("Z", "--**");
        morseTranslator.put("1", "*----");
        morseTranslator.put("2", "**---");
        morseTranslator.put("3", "***--");
        morseTranslator.put("4", "****-");
        morseTranslator.put("5", "*****");
        morseTranslator.put("6", "-****");
        morseTranslator.put("7", "--***");
        morseTranslator.put("8", "---**");
        morseTranslator.put("9", "----*");
        morseTranslator.put("0", "-----");
        morseTranslator.put(".", "*-*-*-");
        morseTranslator.put(",", "--**--");
        morseTranslator.put("?", "**--**");

        morseTranslator.put(" ", "/");  //Idea from practice lesson to use / as space between words
        morseTranslator.put("/", " ");  //Opposite translation here

        morseTranslator.put("*-", "A");
        morseTranslator.put("-***", "B");
        morseTranslator.put("-*-*", "C");
        morseTranslator.put("-**", "D");
        morseTranslator.put("*", "E");
        morseTranslator.put("**-*", "F");
        morseTranslator.put("--*", "G");
        morseTranslator.put("****", "H");
        morseTranslator.put("**", "I");
        morseTranslator.put("*---", "J");
        morseTranslator.put("-*-", "K");
        morseTranslator.put("*-**", "L");
        morseTranslator.put("--", "M");
        morseTranslator.put("-*", "N");
        morseTranslator.put("---", "O");
        morseTranslator.put("*--*", "P");
        morseTranslator.put("--*-", "Q");
        morseTranslator.put("*-*", "R");
        morseTranslator.put("***", "S");
        morseTranslator.put("-", "T");
        morseTranslator.put("**-", "U");
        morseTranslator.put("***-", "V");
        morseTranslator.put("*--", "W");
        morseTranslator.put("-**-", "X");
        morseTranslator.put("-*--", "Y");
        morseTranslator.put("--**", "Z");
        morseTranslator.put("*----", "1");
        morseTranslator.put("**---", "2");
        morseTranslator.put("***--", "3");
        morseTranslator.put("****-", "4");
        morseTranslator.put("*****", "5");
        morseTranslator.put("-****", "6");
        morseTranslator.put("--***", "7");
        morseTranslator.put("---**", "8");
        morseTranslator.put("----*", "9");
        morseTranslator.put("-----", "0");
        morseTranslator.put("*-*-*-", ".");
        morseTranslator.put("--**--", ",");
        morseTranslator.put("**--**", "?");
    }

    public String getMorse(String characters) {
        if (!characters.equals("!")) { //if input from user is not ! run code, if it is return "";

            characters = characters.toUpperCase();
            String[] charactersArray = new String[characters.length()]; //Array to be able to separate words into string "characters"
            StringBuilder morse = new StringBuilder(); //Auto generated to help build words from arrays

            for (int i = 0; i < characters.length(); i++) { //forLoop to separate words into single string-"characters"
                charactersArray[i] = String.valueOf(characters.charAt(i)); //Take each letter at position i and put it in the array
                morse.append(" "); // Add "space" to each character
                morse.append(morseTranslator.get(charactersArray[i])); //Translate each character at position i and put it into
                //a String using .append
            }

            if (!morse.toString().contains("null")) { //if the translated morse is not "null" return the translation
                return morse.toString().trim(); //Return the whole string that has been converted from characters to morse minus the " " at the end
            }
            return wrongInput; //if input is invalid return error message

        }
        return endOfProgram;
    }

    public String getCharacters(String morse) {

        if (!morse.equals("!")) { // if input from user is not ! run code, if it is return "";

            String[] morseArray = morse.split(" "); //Separate morse at every " " and put it in an array
            StringBuilder characters = new StringBuilder();

            for (int i = 0; i < morseArray.length; i++) {
                characters.append(morseTranslator.get(morseArray[i]));
            }
            if (!characters.toString().contains("null")) { //if the translated characters is not "null" return the translation
                return characters.toString(); // Tried changing to return "Translation + characters.toString(); but prefer having
                //the flavor text printed out in main, since testcases become weird with "translation: " added to expected
            }
            return wrongInput; //if input is invalid return error message
        }
        return endOfProgram;
    }

}