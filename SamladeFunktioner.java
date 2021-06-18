import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Collection of functions from CodeWars.
 * 
 * @author Yrrah 
 * @version 1.0
 */
public class SamladeFunktioner
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SamladeFunktioner
     */
    public SamladeFunktioner(){
    }

    /**
     * Is a number prime?
     * 
     * @param  n   Integer
     * @return     True if x is a prime. 
     */
    public boolean is_prime(int n){
        if(n < 2){
            return false;
        }
        double y = Math.floor(Math.sqrt(n));
        
        // Not completed yet... Obviously.
        // Check all primes up to y

        return true;
    }
    
    public int digital_root(int n){
        int i, result = 0;
        String x = String.valueOf(n);
        
        int[] digitArray = new int[x.length()];
        for (i = 0; i < x.length(); i++){
            digitArray[i] = x.charAt(i) - '0'; // magic
        }
        
        for(i = 0; i < digitArray.length ; i++){
            result = result + digitArray[i];
        }
        
        if(result > 9){
            result = digital_root(result);
        }
        
        //for(char ch : x.toCharArray()){ }
        return result;
    }
    
    /**
     * Weight for weight - challange at codewars
     * @param  string   Initial string to be sorted.
     * @return  string  Sorted String according to description.
     */
    public String orderWeight(String string){
        int charValue;
        String[] splitted = string.trim().split(" ");
        String[] result = new String[splitted.length];
        int[] pointsSorted = new int[splitted.length];
        int[] pointsUnSorted = new int[pointsSorted.length];
        
        // Get the value of every string, to sort later.
        for(int i = 0; i < splitted.length; i++){ // for every String
            for(int ii = 0 ; ii < splitted[i].length(); ii++){ // for every digit
                charValue = splitted[i].charAt(ii) - '0';
                pointsSorted[i] = pointsSorted[i] + charValue;
            }
            pointsUnSorted[i] = pointsSorted[i]; // Copy array
        }
        Arrays.sort(pointsSorted); // Now PointsSorted is in the right order. 
        
        for(int i = 0 ; i < pointsSorted.length ; i++){
            for(int ii = 0 ; ii < pointsUnSorted.length ; ii++){
                // Find out where in Splitted[] the numbers are.
                // Then place them in sorted order in result[] corresponding to PointsSorted
                if(pointsUnSorted[ii] == pointsSorted[i]){
                    result[i] = splitted[ii];
                    pointsUnSorted[ii] = -1;
                    break;
                }
            }
        }
        
        int compare = -1;
        ArrayList<String> sortSubArray = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // Build the return String...
        for(int i = 0 ; i < pointsSorted.length; i++){
            if(compare == -1){
                sortSubArray.add(result[0]);
                compare = pointsSorted[0];
            }else if(compare == pointsSorted[i]){
                sortSubArray.add(result[i]);
            }else{
                Collections.sort(sortSubArray);
                for(String s : sortSubArray){
                    sb.append(s).append(" ");
                }
                compare = pointsSorted[i];
                sortSubArray.clear();
                sortSubArray.add(result[i]);
            }
            if(i == pointsSorted.length -1){
                Collections.sort(sortSubArray);
                for(String s : sortSubArray){
                    sb.append(s).append(" ");
                }
            }
        }
        
        return sb.toString().trim(); // Remove the last trailing space..
    }
    
    public int simpleConsecutivePairs(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length ; i = i+2){
            if(i != arr.length-1 && (arr[i] == arr[i+1]+1 || arr[i] == arr[i+1]-1)){
                count++;
            }
        }
        return count;
    }
    
    public String highAndLow(String numbers){
        String[] splittedNumbers = numbers.trim().split(" ");
        int highest = Integer.parseInt(splittedNumbers[0]),
            lowest = Integer.parseInt(splittedNumbers[0]);
        for(int i = 1 ; i < splittedNumbers.length ; i++){
            int stringNumber = Integer.parseInt(splittedNumbers[i]);
            if(stringNumber > highest){
                highest = stringNumber;
            }
            if(stringNumber < lowest){
                lowest = stringNumber;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(highest).append(" ").append(lowest);
        return sb.toString();
    }
    
    public String whatCentury(int year){
        StringBuilder sb = new StringBuilder();
        double y = Math.ceil(year/100.0);
        sb.append((int)y);
        int x = year%1000;
        if(x < 100){
            if((year > 1000 && year <= 1100) || (x == 0)){
                sb.append("th");
            }else{
                sb.append("st");
            }
        }else if(x < 200){
            if(year > 1100 && year <= 1200){
                sb.append("th");
            }else{
                sb.append("nd");
            }
        }else if(x < 300){
            if(year > 1200 && year <= 1300){
                sb.append("th");
            }else{
                sb.append("rd");
            }
        }else{
            sb.append("th");
        }
        return sb.toString();
    }
    
    /**
     * Difficulty 4
     * A format for expressing an ordered list of integers is to use a comma separated list
     * of individual integers or a range of integers denoted by the starting integer
     * separated from the end integer in the range by a dash, '-'.
     * The range includes all integers in the interval including both endpoints. 
     * It is not considered a range unless it spans at least 3 numbers.
     * For example "12,13,15-17"
     */
    public static String rangeExtraction(int[] arr) {
        if(arr == null || arr.length == 0){
            return "";
        }else if(arr.length == 1){
            return String.valueOf(arr[0]);
        }else if(arr.length == 2){
            return String.valueOf(arr[0])+","+String.valueOf(arr[1]);
        }
        
        ArrayList<Integer> rangeNumbers = new ArrayList<Integer>();
        
        rangeNumbers.add(arr[0]);
        rangeNumbers.add(arr[1]);
        boolean initRange = false;
        int upperRange = 0;
        
        for(int i = 2; i < arr.length; i++){
            if(initRange){
                while(i < arr.length){
                    if(arr[i] == arr[i-1]+1){
                        upperRange = arr[i];
                        i++;
                    }else{
                        break;
                    }
                }
                // Add numbers
                rangeNumbers.add(upperRange);
                if(i < arr.length){
                    rangeNumbers.add(arr[i]);
                }
                initRange = false;
            }else if(arr[i] == arr[i-1]+1 && arr[i] == arr[i-2]+2){
                // Initiate range compression
                upperRange = arr[i];
                rangeNumbers.set(rangeNumbers.size()-1,null); // The null will represent a dash
                initRange = true;
                if(i == arr.length-1){
                    rangeNumbers.add(arr[i]);
                }
            }else{
                // Isolated number, simply add it.
                rangeNumbers.add(arr[i]);
            }
        }
        StringBuilder strBldr = new StringBuilder();
        String prefix = "";
        for(Integer x : rangeNumbers){
            if(x == null){
                strBldr.append("-");
                prefix = "";
            }else{
                strBldr.append(prefix);
                strBldr.append(x);
                prefix = ",";
            }
        }
        return strBldr.toString();
        
        /* // Best Solution
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            int j = i;
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) j++;
            if (i + 1 < j) {
                i = j;
                sb.append("-");
                sb.append(arr[i]);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
         */
    }

    // Statistics for an Athletic Association
    /** Clock, Difficulty 6
     * To compare the results of the teams you are asked for giving three statistics;
     * range, average and median.
     * The task is to return a string giving these 3 values. For the example given,
     * "01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"
     * the string result will be
     * "Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"
     *
     * of the form: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"
     * where hh, mm, ss are integers (represented by strings) with each 2 digits.
     *
     * Remarks:
     * if a result in seconds is ab.xy... it will be given truncated as ab.
     * if the given string is "" you should return "".
     */
    public static String statAthleticAssociation(String strg){
        if(strg.isEmpty() || strg == null){
            return "";
        }
        int range, average, median;
	String[] extractVariables = strg.split("[,|\\|]");
	int[] extractSecounds = new int[extractVariables.length/3];
	int max = 0, min = Integer.MAX_VALUE;

	int c = 1, i = 0, val = 0;
	for(String s : extractVariables){
	    Integer number = Integer.valueOf(s.trim());

	    switch(c){
	        case 1:
	           val = val + number*60*60;
	           c++;
	           break;
	        case 2:
	           val = val + number*60;
	           c++;
	           break;
	        case 3:
	           val = val + number;
	           extractSecounds[i] = val;
	           if(max < val){
	               max = val;
	           }
	           if(min > val){
	               min = val;
	           }
	           c = 1; val = 0; i++;
	    }
	}
	range = max - min;

	for(int x : extractSecounds){
	    val = val + x;
	}
	average = val / extractSecounds.length;

	Arrays.sort(extractSecounds);
	if(extractSecounds.length % 2 == 1){
	    median = extractSecounds[extractSecounds.length/2];
	}else{
	    median = (extractSecounds[extractSecounds.length/2]
	           + extractSecounds[extractSecounds.length/2 -1])/2;
	}

	return buildStatResponse(range, average, median);
	/* // Best Solution (No extra methods)
        public static String stat(String strg) {
            List<Integer> stats = new ArrayList<Integer>();
            int Mean = 0;
            for(String time:strg.split(",")){
              time = time.trim();
              int t = Integer.parseInt(time.substring(0, time.indexOf('|')))*60*60 +
                  Integer.parseInt(time.substring(time.indexOf('|')+1,time.lastIndexOf('|')))*60 +
                  Integer.parseInt(time.substring(time.lastIndexOf('|')+1));
              Mean+=t;
              stats.add(t);
            }
            Collections.sort(stats);
            int Range = Collections.max(stats) - Collections.min(stats);
            Mean /= stats.size();
            int Median = stats.size()%2 == 0? (stats.get((stats.size()/2)-1) + stats.get(stats.size()/2))/2 : stats.get((stats.size()/2));

            return String.format("Range: %02d|%02d|%02d Average: %02d|%02d|%02d Median: %02d|%02d|%02d",
                Range/3600,(Range%3600)/60,Range%60,Mean/3600,(Mean%3600)/60,Mean%60,Median/3600,(Median%3600)/60,Median%60);
            }
	 */
    }

    private static String buildStatResponse(int range, int average, int median){
        int hr, min, sec;
        StringBuilder strBldr = new StringBuilder();
        // =============================
        strBldr.append("Range: ");
        hr = range/3600;
        strBldr.append(addDigit(hr));

        strBldr.append("|");
        min = (range-(range/3600)*3600)/60;
        strBldr.append(addDigit(min));

        strBldr.append("|");
        sec = range - hr*3600 - min*60;
        strBldr.append(addDigit(sec));
        // =============================
        strBldr.append(" Average: ");
        hr = average/3600;
        strBldr.append(addDigit(hr));

        strBldr.append("|");
        min = (average-(average/3600)*3600)/60;
        strBldr.append(addDigit(min));

        strBldr.append("|");
        sec = average - hr*3600 - min*60;
        strBldr.append(addDigit(sec));
        // =============================
        strBldr.append(" Median: ");
        hr = median/3600;
        strBldr.append(addDigit(hr));

        strBldr.append("|");
        min = (median-(median/3600)*3600)/60;
        strBldr.append(addDigit(min));

        strBldr.append("|");
        sec = median - hr*3600 - min*60;
        strBldr.append(addDigit(sec));
        // =============================
        return strBldr.toString();
    }

    private static String addDigit(int d){
        if(d < 10){
            return "0"+String.valueOf(d);
        }
        return String.valueOf(d);
    }

    // The Office - part 1 - Outed
    /*
        Difficulty 7.
        This challenge is only to calculate an average score
     */
    public static String outed(Person[] meet, String boss) {
        double totalHappiness = 0;
        for(Person p : meet){
            totalHappiness = totalHappiness + p.happiness;
            if(p.name.equals(boss)){
                totalHappiness = totalHappiness + p.happiness;
            }
        }
        totalHappiness = totalHappiness / meet.length;

        if(totalHappiness > 5){
            return "Nice Work Champ!";
        }else{
            return "Get Out Now!";
        }
    }
    /* // Best Practice
      private static final String GOOD = "Nice Work Champ!";
      private static final String BAD = "Get Out Now!";

      public static String outed(Person[] meet, String boss) {
        double rating = Arrays.stream(meet)
                              .mapToInt(person ->
                                person.name.equals(boss) ? person.happiness * 2
                                                         : person.happiness)
                              .average()
                              .orElse(0.0);
        return (rating > 5) ? GOOD : BAD;
      }
     */
}
