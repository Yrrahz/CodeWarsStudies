

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
}
