import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SamladeFunktionerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SamladeFunktionerTest{
    private SamladeFunktioner sf;
    /**
     * Default constructor for test class SamladeFunktionerTest
     */
    public SamladeFunktionerTest(){
        this.sf = new SamladeFunktioner();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        //System.out.println("Running a new test...");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
        //System.out.println("Test Completed.");
    }
    
    @Test
    public void testConsecutivePairs(){
        assertEquals(3,sf.simpleConsecutivePairs(new int[]{1,2,5,8,-4,-3,7,6,5}));
        assertEquals(2,sf.simpleConsecutivePairs(new int[]{21,20,22,40,39,-56,30,-55,95,94}));
    }
    
    @Test
    public void testWieghtSort(){
        assertEquals("2000 103 123 4444 99", sf.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
            sf.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        assertEquals("34 134 19 28 64 722 5555", sf.orderWeight("722 134 64 5555 34 28 19"));
    }
    
    @Test
    public void testHighAndLow(){
        assertEquals("42 -9", sf.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        assertEquals("3 3", sf.highAndLow("3"));
    }
    
    @Test
    public void testDigital_root(){
        assertEquals(6, sf.digital_root(123));
        assertEquals(6, sf.digital_root(12345));
        assertEquals(9, sf.digital_root(123456789));
    }
    
    @Test
    public void testRangeExtraction(){
        assertEquals("",SamladeFunktioner.rangeExtraction(new int[]{}));
        
        assertEquals("7", SamladeFunktioner.rangeExtraction(new int[]{7}));
        
        assertEquals("7,11", SamladeFunktioner.rangeExtraction(new int[]{7,11}));
        
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20",
           SamladeFunktioner.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
                
        assertEquals("-3--1,2,10,15,16,18-20",
           SamladeFunktioner.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
    }

    @Test
    public void testAthleticAssociation(){
        assertEquals("Range: 01|01|18 Average: 01|38|05 Median: 01|32|34",
            SamladeFunktioner.statAthleticAssociation("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
    }

    @Test
    public void testTheOffice_part1_Outed1(){
        Person[] meet = new Person[] {
                new Person("tim", 0),
                new Person("jim", 2),
                new Person("randy", 0),
                new Person("sandy", 7),
                new Person("andy", 0),
                new Person("katie", 5),
                new Person("laura", 1),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 0)
        };
        assertEquals("Get Out Now!", SamladeFunktioner.outed(meet, "laura"));
    }

    @Test
    public void testTheOffice_part1_Outed2(){
        Person[] meet = new Person[] {
                new Person("tim", 1),
                new Person("jim", 3),
                new Person("randy", 9),
                new Person("sandy", 6),
                new Person("andy", 7),
                new Person("katie", 6),
                new Person("laura", 9),
                new Person("saajid", 9),
                new Person("alex", 9),
                new Person("john", 9),
                new Person("mr", 8)
        };
        assertEquals("Nice Work Champ!", SamladeFunktioner.outed(meet, "katie"));
    }

    @Test
    public void testTheOffice_part1_Outed3(){
        Person[] meet = new Person[] {
                new Person("tim", 2),
                new Person("jim", 4),
                new Person("randy", 0),
                new Person("sandy", 5),
                new Person("andy", 8),
                new Person("katie", 6),
                new Person("laura", 2),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 8),
        };
        assertEquals("Get Out Now!", SamladeFunktioner.outed(meet, "john"));
    }

    @Test
    public void testTheOffice_part2_Boredom() {
        assertEquals("party time!!", SamladeFunktioner.boredom(new Person[] {
                new Person("tim", "accounts"),
                new Person("jim", "accounts"),
                new Person("randy", "pissing about"),
                new Person("sandy", "finance"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "IS"),
                new Person("saajid", "canteen"),
                new Person("alex", "pissing about"),
                new Person("john", "retail"),
                new Person("mr", "pissing about")
        }));
    }

    @Test
    public void testTheOffice_part5_MeetingRoom1() {
        Room[] rooms = new Room[] {
                new Room("XXX", 3),
                new Room("XXXXX", 6),
                new Room("XXXXXX", 9)
        };
        assertArrayEquals(new int[] {0, 1, 3}, (int[]) SamladeFunktioner.meeting(rooms, 4));
    }

    @Test
    public void testTheOffice_part5_MeetingRoom2() {
        Room[] rooms = new Room[] {
                new Room("XXX", 1),
                new Room("XXXXXX", 6),
                new Room("X", 2),
                new Room("XXXXXX", 8),
                new Room("X", 3),
                new Room("XXX", 1)
        };
        assertArrayEquals(new int[] {0, 0, 1, 2, 2}, (int[]) SamladeFunktioner.meeting(rooms, 5));
    }

    @Test
    public void testPageDigits(){
        assertEquals(261, SamladeFunktioner.pageDigits(123));
        assertEquals(7, SamladeFunktioner.pageDigits(7));
        assertEquals(11, SamladeFunktioner.pageDigits(10));
        assertEquals(1, SamladeFunktioner.pageDigits(1));
        assertEquals(3829, SamladeFunktioner.pageDigits(1234));
    }
}
