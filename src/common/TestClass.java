package common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void testConverterAtoMorse() {
        String testdata = "A"; //Testing a single "char" (used to be a char)
        Converter converter = new Converter();
        String expected = "*-";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterBtoMorse() {
        String testdata = "B";
        Converter converter = new Converter();
        String expected = "-***";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterZtoMorse() {
        String testdata = "Z";
        Converter converter = new Converter();
        String expected = "--**";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverter1toMorse() {
        String testdata = "1"; //Testing non-letter character
        Converter converter = new Converter();
        String expected = "*----";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterHItoMorse() {
        String testdata = "HI"; //Testing more than a char, had to change everything to string after this test.
        Converter converter = new Converter();
        String expected = "**** **";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterH3LL0toMorse() {
        String testdata = "H3LL0"; // Three and zero instead of letters
        Converter converter = new Converter();
        String expected = "**** ***-- *-** *-** -----";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterHIKENtoMorse() {
        String testdata = "HI KEN"; // Sentence with "space" included
        Converter converter = new Converter();
        String expected = "**** ** / -*- * -*"; //idea from practice to use / as space
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterHiKenToMorse() {
        String testdata = "Hi Ken"; // Sentence with "space" included + lowercase
        Converter converter = new Converter();
        String expected = "**** ** / -*- * -*"; //idea from practice to use / as space
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterMorseToA() {
        String testdata = "*-"; //Testing first morse, had problem with ET ("*" + "-" getting returned instead of "A")
        Converter converter = new Converter();
        String expected = "A";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterMorseToABC() {
        String testdata = "*- -*** -*-*"; //Testing several morse at the same time
        Converter converter = new Converter();
        String expected = "ABC";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterMorseToH3LL0() {
        String testdata = "**** ***-- *-** *-** ----- **--**"; //Testing several morse at the same time with different characters
        Converter converter = new Converter();
        String expected = "H3LL0?"; //Mix of characters
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterMorseToHIKEN() {
        String testdata = "**** ** / -*- * -*"; //Testing several morse and if / gets translated to " "
        Converter converter = new Converter();
        String expected = "HI KEN";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
     }


    @Test
    public void testConverterSpecialCharacters() {
        String testdata = "¤"; //Testing characters that are not supposed to be translated
        Converter converter = new Converter();
        String expected = "Wrong input, try again";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterFakeMorse() {
        String testdata = "*****-"; //Testing fake morse
        Converter converter = new Converter();
        String expected = "Wrong input, try again";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);

    }

    @Test
    public void testConverterEmpty() {
        String testdata = ""; //Testing if "nothing" gets translated
        Converter converter = new Converter();
        String expected = "Wrong input, try again";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testConverterSpaceToSlash() {
        String testdata = " "; //Testing if "space" gets translated
        Converter converter = new Converter();
        String expected = "/";
        String actual = converter.getMorse(testdata); //Does not work with getCharacters, bc of split " "
        assertEquals(expected, actual);

    }

    @Test
    public void testConverterExclamationGetCharacters() {
        String testdata = "!"; //Testing if ! returns end of program message in morse converter
        Converter converter = new Converter();
        String expected = "Closing...";
        String actual = converter.getCharacters(testdata);
        assertEquals(expected, actual);

    }
    @Test
    public void testConverterExclamationGetMose() {
        String testdata = "!"; //Testing if ! returns end of program message in characters converter
        Converter converter = new Converter();
        String expected = "Closing...";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);

    }

}
