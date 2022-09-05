
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.math.BigInteger;
/**
 * Write a description of class Matriser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matriser
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Matriser
     */
    public Matriser(){
    }

    /**
     * Square Matrix Addition
     * | array.length * array[0].length | Tip
     * 
     * @param  x, y   Two square Matrixes.
     * @return     The resulting matrix.
     */
    public int[][] squareMatrixAddition(int[][] x, int[][] y){
        
        for(int i = 0; i < x.length ; i++){
            for(int ii = 0; ii < x[0].length ; ii++){
                x[i][ii] = x[i][ii] + y[i][ii];
            }
        }
        
        return x;
    }
    
    public static int[] sortTheOddArray(int[] array){
        if(array.length == 0){
            return array;
        }
        
        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        for(int x : array){
            if(x%2 != 0){
                sortedArray.add(x);
            }
        }
        Collections.sort(sortedArray);
        
        int ii = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]%2 != 0){
                array[i] = sortedArray.get(ii);
                ii++;
            }
        }
        
        return array;
    }
    
    // Works but slow.
    public static int repeats(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        int result = 0;
        for(int x : arr){
            if(set.contains(x)){
                result = result - x;
            }else{
                set.add(x);
                result = result + x;
            }
        }
        
        return result;
    }
    
    /**
     * This is a function challange from Codewars.com
     * The idea is that you go around inside the matrix
     * and return an array with all the elements.
     * The Matrix is guaranteed to be square, meaning 
     * its size is always side^2. Ex;
     * ________
     * |→|→|┐|
     * |┌|→|↓|
     * |↑|←|┘|
     * --------
     * Difficulty: 4
     */
    public static int[] snailMatrix(int[][] array){
        // Cell-ID = R * maxC + C
        if(array[0].length == 0){
            return new int[]{};
        }
        int mLength = array[0].length, resultIndex = 0;
        int[] result = new int[mLength * mLength];
        //Set<Integer> set = new HashSet<Integer>();
        
        //boolean keepGoing = true, rowOrCol = true, upOrDown = true;
        boolean goBackWards = false;
        int row = 0, col = 0, x = mLength, y = mLength-1, tmp;
        while(x != 0 || y != 0){
            if(x > y){
                tmp = x;
                while(x != 0){
                    result[resultIndex] = array[row][col];
                    resultIndex++;
                    x--;
                    if(goBackWards && x != 0){
                        col--;
                    }else if(x != 0){
                        col++;
                    }else if(goBackWards && x == 0){
                        row--;
                    }else{
                        row++;
                    }
                }
                x = tmp-1;
            }else{
                tmp = y;
                while(y != 0){
                    result[resultIndex] = array[row][col];
                    resultIndex++;
                    y--;
                    if(goBackWards && y != 0){
                        row--;
                    }else if(y != 0){
                        row++;
                    }else if(goBackWards && y == 0){
                        col++;
                    }else{
                        col--;
                    }
                }
                y = tmp-1;
                goBackWards = !goBackWards;
            }
        }
        return result;
    }
    
    /**
     * Array combinations.
     * For example: solve([[1,2],[4],[5,6]]) = 4, because it results in only 4 possiblites.
     * They are [1,4,5],[1,4,6],[2,4,5],[2,4,6].
     */
    public static int arrCombinations(final List<List<Integer>> data){
        int listNr = 1;
        for(List<Integer> lists : data){
            System.out.println("List "+listNr);
            for(Integer i : lists){
                System.out.print(i+" ");
            }
            System.out.println();
            listNr++;
        }
        return 0;
    }
    
    /**
     * Sorts an array by two rules.
     * #1 - Most frequency first
     * #2 - If same frequency, sort by value. Lowest first.
     * 
     * Difficulty: 6
     */
    public static int[] sortByFrequency(int[] array){
        TreeMap<Integer, Integer> sortFreqMap = new TreeMap<Integer, Integer>();
        int[] result = new int[array.length];
        int resultIndex = 0;
        for(int x : array){
            if(sortFreqMap.containsKey(x)){
                sortFreqMap.put(x,sortFreqMap.get(x)+1);
            }else{
                sortFreqMap.put(x,1);
            }
        }
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        ArrayList<Integer> valueSorted = new ArrayList<Integer>();
        int previousValue = 0; // value cannot be lower than 1
        for(Map.Entry<Integer, Integer> mapElement : sortFreqMap.entrySet()){
            valueSorted.add(mapElement.getValue());
        }
        
        for(int i = 0; i < arrList.size(); i++){
            result[i] = arrList.get(i);
        }
        /*
        HashMap<Integer, Integer> sortFreqMap  = new HashMap<Integer, Integer>();
        
        for(int x : array){
            if(sortFreqMap.containsKey(x)){
                sortFreqMap.put(x,sortFreqMap.get(x)+1);
            }else{
                sortFreqMap.put(x,1);
            }
        }
        
        int arrPosition = 0;
        int[] result = new int[array.length];
        int[] mapValues = new int[sortFreqMap.size()];
        for(Integer i : sortFreqMap.values()){
            mapValues[arrPosition] = i;
            arrPosition++;
        }
        Arrays.sort(mapValues);
        arrPosition = 0;
        
        int compare = -1;
        ArrayList<Integer> sortSubArray = new ArrayList<Integer>();
        for(int x = mapValues.length-1; x >= 0; x--){
            for(Integer key : sortFreqMap.keySet()){
                if(x == sortFreqMap.get(key)){
                    sortSubArray.add(key);
                    sortFreqMap.put(key, null);
                    break;
                }
            }
            Collections.sort(sortSubArray);
        }*/
        
        return result;
    }
    
    public static int findDeletedNumber(int[] arr, int[] mixedArr) {
        Set<Integer> set = new HashSet<Integer>();
        int missing = 0;
        for(int x : mixedArr){
            set.add(x);
        }
        
        for(int x : arr){
            if(!set.contains(x)){
                missing = x;
            }
        }
        
        return missing;
    }
    
    /**
     * Find the odd int - Difficulty 6
     * 
     * Given an array of integers, find the one that appears an odd number of times.
     * There will always be only one integer that appears an odd number of times.
     */
    public static int findOddInt(int[] arr){
        int odd = -1;
        TreeMap<Integer, Integer> findOddFreq = new TreeMap<Integer, Integer>();
        
        for(int x : arr){
            if(findOddFreq.containsKey(x)){
                findOddFreq.put(x,findOddFreq.get(x)+1);
            }else{
                findOddFreq.put(x,1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : findOddFreq.entrySet()){
            if(entry.getValue() % 2 == 1){
                odd = entry.getKey();
                break;
            }
        }
        
        return odd;
        
        /* // Best Answer :
         * public static int findIt(int[] A) {
         *   int odd=0;
         *   for (int item: A)
         *     {
         *       odd = odd ^ item;// XOR will cancel out everytime you XOR with the same number so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
         *     }
         *   
         *   return odd;
         * }
         */
    }
    
    /**
     * Difficulty 5
    *In this kata, you will write a function that returns the positions and the values of the
    *"peaks" (or local maxima) of a numeric array.
    *
    *For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value
    *of 5 (since arr[3] equals 5).
    *
    *The output will be returned as a ``Map<String,List>with two key-value pairs:"pos"
    *and "peaks".
    *If there is no peak in the given array, simply return{"pos" => [], "peaks" => []}`.
    *
    *Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return
    *{pos: [3, 7], peaks: [6, 3]}
    */
    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        // Your code here!
        Map<String,List<Integer>> peaks = new HashMap<String,List<Integer>>();
        ArrayList<Integer> positions = new ArrayList<Integer>();
        ArrayList<Integer> peakValues = new ArrayList<Integer>();
        int tmp;
        for(int i = 1; i < arr.length-1 ; i++){
            if(arr[i-1] < arr[i] && arr[i+1] < arr[i]){
                // it's a peak
                positions.add(i);
                peakValues.add(arr[i]);
                i++; // no need to check next point as it is definetly not a peak.
            }else if(arr[i-1] < arr[i] && arr[i+1] == arr[i]){
                // It's a plateu
                tmp = i;
                do{
                    if(arr[i+1] > arr[i]){
                        // NOT a peak-plateu.
                        break;
                    }else if(arr[i+1] < arr[i]){
                        // IT'S a peak-plateu.
                        peakValues.add(arr[i]);
                        positions.add(tmp);
                        break;
                    }
                    i++;
                }while(i < arr.length-1);
            }
        }
        
        peaks.put("pos",positions);
        peaks.put("peaks",peakValues);
        
        return peaks;
        
        /* // Best answer
        Map<String,List<Integer>> ans = new HashMap<String,List<Integer>>() {{
            put("pos",   new ArrayList<Integer>() );
            put("peaks", new ArrayList<Integer>() );
        }};
        int posMax = 0;
        boolean matchAsc = false;
        
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i-1] < arr[i]) {
                matchAsc = true;
                posMax = i;
            }
            if (matchAsc && arr[i-1] > arr[i]) {
                matchAsc = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
         */
    }
    
    public static int[] sumParts(int[] ls) {
      // your code
      int[] answer = new int[ls.length+1];
      int max = 0, i = 0;
      for(int x : ls){
          max = max + x;
      }

      answer[i] = max;
      i++;
      for(int x : ls){
          max = max - x;
          answer[i] = max;
          i++;
      }
      return answer;
      
      /* // Best answer - (Fill it from behind)
       * int[] result = new int[ls.length+1];
       * for(int i = ls.length-1; i >= 0; --i) {
       *     result[i] = result[i+1] + ls[i];
       * }
       * return result;
       */
    }
    
    private static BigInteger binomialCoefficient(long x, long y){
        long xy = x-y;
        BigInteger factorialX = new BigInteger("1");
        BigInteger factorialY = new BigInteger("1");
        
        if(xy < y){
            // Run only xy amount of times, divided by xy!
            for(int i = 2; i <= xy; i++){
                factorialY = factorialY.multiply(BigInteger.valueOf(i));
            }
            while(xy != 0){
                factorialX = factorialX.multiply(BigInteger.valueOf(x));
                x--;xy--;
            }
        }else{
            // Run only y amount of times, divided by y!
            for(int i = 2; i <= y; i++){
                factorialY = factorialY.multiply(BigInteger.valueOf(i));
            }
            while(y != 0){
                factorialX = factorialX.multiply(BigInteger.valueOf(x));
                x--;y--;
            }
        }
        
        return factorialX.divide(factorialY);
    }
    
    public static BigInteger padovanNr(long power){
        long m = (power+2) / 2, n = power%2;
        BigInteger bigI = new BigInteger("0");
        
        do{
            bigI = bigI.add(binomialCoefficient(m,n));
            m--;n += 2;
        }while(m >= n);
        
        return bigI;
    }

    /**
     * Difficulty: 6
     * TenMinWalk - You live in the city of Cartesia where all roads are laid out in a
     * perfect grid. You arrived ten minutes too early to an appointment, so you decided
     * to take the opportunity to go for a short walk. The city provides its citizens
     * with a Walk Generating App on their phones -- everytime you press the button it
     * sends you an array of one-letter strings representing directions to walk
     * (eg. ['n', 's', 'w', 'e']).
     * You always walk only a single block for each letter (direction) and you know it
     * takes you one minute to traverse one city block, so create a function that will
     * return true if the walk the app gives you will take you exactly ten minutes
     * (you don't want to be early or late!) and will, of course, return you to your
     * starting point. Return false otherwise. (Arrays will not have to be checked)
     */
    public static boolean tenMinWalk(char[] walk){
        if(walk.length != 10){
            return false;
        }
        byte x = 0, y = 0;
        for(char c : walk){
            switch(c){
                case 'n':
                    y++;
                    break;
                case 'e':
                    x++;
                    break;
                case 's':
                    y--;
                    break;
                case 'w':
                    x--;
                    break;
                default:
                    System.out.println("Reached Default");
            }
        }
        return x == 0 && y == 0;
        /*
        My solution was the best solution! But here is another "clever" solution:
        public static boolean TenMinWalk(char[] walk) {
            String s = new String(walk);
            return s.chars().filter(p->p=='n').count()==s.chars().filter(p->p=='s').count()&&
                s.chars().filter(p->p=='e').count()==s.chars().filter(p->p=='w').count()&&s.chars().count()==10;
        }
         */
    }
}
