import java.math.BigInteger;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatriserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatriserTest{
    /**
     * Default constructor for test class MatriserTest
     */
    public MatriserTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
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
    public void testRepeats(){
        assertEquals(15,Matriser.repeats(new int[]{4,5,7,5,4,8}));
        assertEquals(19,Matriser.repeats(new int[]{9,10,19,13,19,13}));
    }
    
    @Test
    public void testSnail(){
        int[] testArray = Matriser.snailMatrix(new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}});
        int checkAnswer = 1;
        for(int i : testArray){
            if(i != checkAnswer){
                assert (false) : "Wrong element at result[] position "+checkAnswer;
            }else{
                checkAnswer++;
            }
        }
        assertTrue(true);
    }
    
    @Test
    public void testSnailEmpty(){
        assertEquals(Matriser.snailMatrix(new int[][]{{}}).length,0);
    }
    
    @Test
    public void testFindDeletedNumber(){
        assertEquals(2, Matriser.findDeletedNumber(new int[]{1,2,3,4,5}, new int[]{3,4,1,5}));
        assertEquals(5, Matriser.findDeletedNumber(new int[]{1,2,3,4,5,6,7,8,9}, new int[]{1,9,7,4,6,2,3,8}));
        assertEquals(0, Matriser.findDeletedNumber(new int[]{1,2,3,4,5,6,7,8,9}, new int[]{5,7,6,9,4,8,1,2,3}));
    }
    
    @Test
    public void findOddIntInArr(){
        assertEquals(5, Matriser.findOddInt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5})); 
        assertEquals(-1, Matriser.findOddInt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5})); 
        assertEquals(5, Matriser.findOddInt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, Matriser.findOddInt(new int[]{10}));
        assertEquals(10, Matriser.findOddInt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, Matriser.findOddInt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
    
    @Test
    public void testSumParts(){
        assertArrayEquals(new int[] {20,20,19,16,10,0}, Matriser.sumParts(new int[]{0,1,3,6,10}));
    }
    
    @Test
    public void testPadovan(){
      assertEquals(new BigInteger("1"),Matriser.padovanNr(1));
      assertEquals(new BigInteger("1"),Matriser.padovanNr(2));
      assertEquals(new BigInteger("2"),Matriser.padovanNr(3));
      assertEquals(new BigInteger("2"),Matriser.padovanNr(4));
      assertEquals(new BigInteger("1177482265857"),Matriser.padovanNr(100));
    }

    @Test
    public void testTenMinWalk(){
        assertTrue("Should return true", Matriser.TenMinWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertFalse("Should return false", Matriser.TenMinWalk(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
    }
}
