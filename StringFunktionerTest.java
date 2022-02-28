

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StringFunktionerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StringFunktionerTest
{
    /**
     * Default constructor for test class StringFunktionerTest
     */
    public StringFunktionerTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }
    
    @Test
    public void testStringReverseLetter(){
        assertEquals(StringFunktioner.reverseLetter("krishan"), "nahsirk");
        assertEquals(StringFunktioner.reverseLetter("ultr53o?n"), "nortlu");
        assertEquals(StringFunktioner.reverseLetter("ab23c"), "cba");
    }
    
    @Test
    public void testStringOnlyNumber(){
        assertEquals(StringFunktioner.onlyNumbers("1,500,000 IDR"), "1500000");
        assertEquals(StringFunktioner.onlyNumbers(",500,000IDR"), "500000");
        assertEquals(StringFunktioner.onlyNumbers(" ,500,000IDR  "), "500000");
    }
    
    @Test
    public void testSeperateNumber(){
        assertEquals(StringFunktioner.seperateNumber("500000"), "500,000");
        assertEquals(StringFunktioner.seperateNumber("1500000"), "1,500,000");
        assertEquals(StringFunktioner.seperateNumber("500"), "500");
    }

    @Test
    public void testCleanString(){
        //System.out.println("Clean string: a#bc#d");
        assertEquals("bd", StringFunktioner.cleanString("a#bc#d"));
        //System.out.println("Clean string: a#b###c#d#");
        assertEquals("", StringFunktioner.cleanString("a#b###c#d#"));
    }

    @Test
    public void testTheOffice_part3_Broken() {
        // assertEquals("expected", "actual");
        assertEquals("0", StringFunktioner.broken("1"));
        assertEquals("01111111010010000001100110111", StringFunktioner.broken("10000000101101111110011001000"));
        assertEquals("011101", StringFunktioner.broken("100010"));
    }

    @Test
    public void testTheOffice_part4_Meetings1() {
        assertEquals(2, StringFunktioner.meeting(new char[] {'X','X','O','X','X'}));
    }

    @Test
    public void testTheOffice_part4_Meetings2() {
        assertEquals("None available!", StringFunktioner.meeting(new char[] {'X','X','X','X','X'}));
    }

    @Test
    public void testTranslateDiff6(){
        assertEquals("testa,! quert", StringFunktioner.translate("t**ta,! q*ert", new String[]{"testa", "hej", "quert"}));
        assertEquals("hello world!", StringFunktioner.translate("***lo w***d!", new String[]{"hello", "world"}));
        assertEquals("cell, weak!", StringFunktioner.translate("c**l, w*ak!", new String[]{"hell", "cell", "week", "weak"}));
        assertEquals("hello, world!", StringFunktioner.translate("hell*, w***d!", new String[]{"hello", "hell", "word", "world"}));
        assertEquals("mel", StringFunktioner.translate("***", new String[]{"mel", "dell"}));
        assertEquals("", StringFunktioner.translate("", new String[]{"hell", "weak"}));
        assertEquals("bbbb. aaa,", StringFunktioner.translate("****. ***,", new String[]{"aaa", "bbbb"}));
    }

    @Test
    public void testPeakHeight(){
        char[][] mountain = {
                "    ".toCharArray(),
                " ^^^".toCharArray(),
                " ^^^".toCharArray(),
                " ^^^".toCharArray(),
                "    ".toCharArray()
        };
        char[][] mountain2 = {
                "^^^^^^        ".toCharArray(),
                " ^^^^^^^^     ".toCharArray(),
                "  ^^^^^^^     ".toCharArray(),
                "  ^^^^^       ".toCharArray(),
                "  ^^^^^^^^^^^ ".toCharArray(),
                "  ^^^^^^      ".toCharArray(),
                "  ^^^^        ".toCharArray()
        };
        char[][] mountain3 = {
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
                "^^^^^^^^^^^^^^^^^^^^^".toCharArray()
        };
        assertEquals(2, StringFunktioner.peakHeight(mountain));
        assertEquals(3, StringFunktioner.peakHeight(mountain2));
        assertEquals(11, StringFunktioner.peakHeight(mountain3));
    }
}
