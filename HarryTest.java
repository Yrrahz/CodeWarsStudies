import java.math.BigInteger;
import java.util.*;
/**
 * Testing functions from SamladeFunktioner.
 * 
 * @author Yrrah 
 * @version 1.0
 */
public class HarryTest
{
    // instance variables - replace the example below with your own
    private SamladeFunktioner sf;
    private Matriser matris;

    /**
     * Constructor for objects of class HarryTest
     */
    public HarryTest(){
        this.sf = new SamladeFunktioner();
        this.matris = new Matriser();
    }

    /**
     * 
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void testIs_prime(){
        // Not finished
    }
    
    public void testDigital_root(){
        System.out.print("The Digital root of 123 is: ");
        System.out.println(sf.digital_root(123));
        System.out.print("The Digital root of 12345 is: ");
        System.out.println(sf.digital_root(12345));
        System.out.print("The Digital root of 123456789 is: ");
        System.out.println(sf.digital_root(123456789));
    }
    
    public void testMatriser_squareMatrixAddition(){
        System.out.println("SquareMatrix x = {1,2,3;3,2,1;1,1,1}");
        System.out.println("SquareMatrix y = {2,2,1;3,2,3;1,1,3}");
        System.out.println("Result is : ");
        int[][] x = matris.squareMatrixAddition(
            new int[][]{{1,2,3},{3,2,1},{1,1,1}},
            new int[][]{{2,2,1},{3,2,3},{1,1,3}});
        System.out.print("{");
        for(int i = 0 ; i < x.length ; i++){
            for(int ii = 0 ; ii < x.length ; ii++){
                System.out.print(x[i][ii]);
                if(ii != x.length-1){
                    System.out.print(",");
                }
            }
            if(i != x.length-1){
                System.out.print(";");
            }
        }
        System.out.println("}");
    }
    
    public void testOrderWeight(){
        System.out.println("Original String : 722 134 64 5555 34 28 19");
        System.out.println("Resulting String : " + sf.orderWeight("722 134 64 5555 34 28 19"));
        System.out.println("Should be : 34 134 19 28 64 722 5555");
    }
    
    public void testConsecutivePairs(){
        System.out.print("Testing {1,2,5,8,-4,-3,7,6,5}, answer should be 3\nResult is : ");
        System.out.println(sf.simpleConsecutivePairs(new int[]{1,2,5,8,-4,-3,7,6,5}));
    }
    
    public static void testSortOddNumbersInArray(){
        int[] test1 = Matriser.sortTheOddArray(new int[]{1,2,5,8,4,3,7,6,5});
        System.out.println("Testing {1,2,5,8,4,3,7,6,5} - Should be {1,2,3,8,4,5,5,6,7}");
        System.out.print("Result : {");
        for(int x : test1){
            System.out.print(x + ",");
        }
        System.out.println("}");
    }
    
    public static void testSnail(){
        Matriser.snailMatrix(new int[][]{{}});
    }
    
    public static int[] testSortByFreq(){
        return Matriser.sortByFrequency(new int[]{2,3,3,4,2,4,3,1,3,2});
    }
    
    public static void testArrCombinations(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(7);
        
        List<List<Integer>> data = new ArrayList<>();
        data.add(list1);
        data.add(list2);
        data.add(list3);
        
        Matriser.arrCombinations(data);
    }
    
    public static void testPeaks(){
        int[] arr = {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3, 3, 3, 1};
        List<Integer> positions = Matriser.getPeaks(arr).get("pos");
        List<Integer> peakValues = Matriser.getPeaks(arr).get("peaks");
        
        System.out.println("Positions:\n"+positions+"\n");
        System.out.println("Values:\n"+peakValues);
    }
    
    public String rangeExtractionTest(){
        return sf.rangeExtraction(new int[]{-7,-6,-5,-3,-2,-1,0,2,3,5,6,7});
    }
    
    public static void testPadovan(){
        long pNr= 17500;
        long startTime = System.currentTimeMillis();

        Matriser.padovanNr(pNr);
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Test with PadovanNr: "+ pNr + " took " + (endTime - startTime) + " milliseconds");
    }
}