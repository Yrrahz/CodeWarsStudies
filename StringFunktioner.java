import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a description of class StringFunktioner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringFunktioner{
    
    public StringFunktioner(){
    }
    
    public static String reverseLetter(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
    
    public static String onlyNumbers(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    public static void testArrayList(){
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add("rad 1");
        testArray.add("rad 2");
        testArray.add("rad 3");
        testArray.add(0,"rad 0");
        System.out.println(testArray);
    }
    
    /**
     * Add a comma in between every third number from the right.
     */
    public static String seperateNumber(String number){
        char[] ch = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < ch.length; i++){
            sb.append(ch[ch.length-i-1]);
            if((i+1)%3 == 0 && i+1 != ch.length){
                sb.append(",");
            }
        }
        
        return sb.reverse().toString();
    }

    /**
     * Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
     *
     * Your task is to process a string with "#" symbols.
     */
    public static String cleanString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : chars){
            if(ch != '#'){
                sb.append(ch);
            }else{
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            }
        }
        return sb.toString();

        /* // Best answer
        public String cleanString(String s) {
            while (s.matches(".*[^#]#.*")) s = s.replaceAll("[^#]#", "");
            return s.replaceAll("#","");
         }
        */
    }

    /*
    The Office part 3 - broken
    Replace all '0' to '1' and '1' to '0'.
    Difficulty 7.
     */
    public static String broken(final String x) {
        char[] result = new char[x.length()];
        int i = 0;
        for(char ch : x.toCharArray()){
            if(ch == '1'){
                result[i] = '0';
            }else{
                result[i] = '1';
            }
            i++;
        }
        return new String(result);
    }
    /* // Best solution
    public static String broken(final String x) {
        return x.replace("0"," ").replace("1","0").replace(" ","1");
    }
     */

    /*
    The Office part 4 - Meeting
    Each value represents a meeting room.
    Your job? Find the first empty one and return its index.
        'X' --> busy
        'O' --> empty
    Difficulty 7.
     */
    public static Object meeting(char[] x) {
        int i = 0;
        for(char c : x){
            if(c == 'O'){
                return i;
            }
            i++;
        }
        return "None available!";
    }
    /* // Best Solution
    int i = new String(x).indexOf('O');
    return i < 0 ? "None available!" : i;
     */

    /* Difficulty 6
     *
     * Encoded words consist of lowercase letters and at least one asterisk;
     * There will always be only one appropriate word from vocabulary for every word in speech;
     * speech consists of lowercase letters, spaces and marks ?!,. ;
     * There might be more words in vocabulary than words in speech;
     * The length of an encoded word must be the same as an appropriate word of vocabulary;
     * The minimum length of a word is 3;
     */
    public static String translate(String speech, String[] vocabulary) {
        StringBuilder response = new StringBuilder();
        boolean match;
        String[] words;
        char[] lettersOfWords, lettersOfVocabulary;
        speech = speech.replaceAll("\\*", "A"); // I don't know how to exclude * from the main regex
        words = speech.split("[^\\w']+");

        for (String word : words) {
            lettersOfWords = word.toCharArray();
            for (String s : vocabulary) {
                lettersOfVocabulary = s.toCharArray();
                if (lettersOfWords.length == lettersOfVocabulary.length) {
                    match = true;
                    for (int z = 0; z < lettersOfWords.length; z++) {
                        if (lettersOfWords[z] != 'A' && lettersOfWords[z] != lettersOfVocabulary[z]) {
                            match = false;
                            break;
                        }
                    }
                } else {
                    match = false;
                }
                if (match) {
                    response.append(s);
                }
            }
        }


        int letterCounter = 0;
        char[] responseArray = response.toString().toCharArray();
        char[] speechArray = speech.toCharArray();
        char[] finalResponse = new char[speech.length()];
        for(int i = 0; i < speech.length(); i++){
            if(speechArray[i] == 'A'){
                finalResponse[i] = responseArray[letterCounter];
                letterCounter++;
            }else if(Character.isLetter(speechArray[i])){
                finalResponse[i] = speechArray[i];
                letterCounter++;
            }else{
                finalResponse[i] = speechArray[i];
            }
        }

        return new String(finalResponse);
    }
    /* // Best Solution
    static String translate(String speech, String[] vocab) {
        String words[] = speech.split(" ");
        for (int i = 0; i < words.length; i++) {
          String regex = words[i].replaceAll("[?!,.]", "").replace("*", ".");
          String extra = words[i].replaceAll("[a-z*]", "");
          for (String v : vocab) if (v.matches(regex)) words[i] = v + extra;
        }
        return String.join(" ", words);
    }
     */

    /** Difficulty 5 **
     * A bird flying high above a mountain range is able to estimate the height of
     * the highest peak. Can you?
     * @return The value of the highest peak
     * ex:  ^^^  111
     *      ^^^  121
     *      ^^^  111  = 2
     */
    public static int peakHeight(char[][] mountain){
        int highestPeak = 1, row = mountain.length, col = mountain[0].length;
        boolean peak = false, peakIsHigher = true;

        // HashSet is used to keep track of all cells being tested
        HashSet<Integer> board = new HashSet<>();
        while(peakIsHigher){
            for(int r = 0; r < row; r++){
                for(int c = 0; c < col; c++){
                    if(peak && !board.contains(r*col+c)){ // After all spaces becomes zeros, check the rest...
                        if(r == 0 || c == 0 || r == row-1 || c == col-1){
                            mountain[r][c] = '1';
                            board.add(r*col+c);
                        }else{
                            if(mountain[r-1][c] -48 < highestPeak ||
                                mountain[r+1][c] -48 < highestPeak ||
                                mountain[r][c-1] -48 < highestPeak ||
                                mountain[r][c+1] -48 < highestPeak){
                                mountain[r][c] = (char)(highestPeak + '0');
                                board.add(r*col+c);
                            }
                        }
                    }else{ // This will take all spaces and turn them into zeros
                        if(Character.isSpaceChar(mountain[r][c])){
                            mountain[r][c] = '0';
                            board.add(r*col+c);
                            // I don't actually need to put zeros. It was just easier to visualize.
                        }
                    }
                }
            }
            if(!peak){
                peak = true;
            }else{
                highestPeak++;
            }
            if(board.size() == row*col){
                highestPeak--;
                peakIsHigher = false;
            }
        }

        return highestPeak;
        /* Best Practice
        int height = 0, my = mountain.length, mx = mountain[0].length;
        char[][] arr = new char[my][mx];
        for (int y = 0; y < my; y++) for (int x = 0; x < mx; x++) arr[y][x] = mountain[y][x];

        boolean found;
        do {
          found = false;
          char[][] next = new char[my][mx];
          for (int y = 0; y < my; y++) {
            for (int x = 0; x < mx; x++) {
              next[y][x] = arr[y][x];
              if (arr[y][x] == '^' && (y == 0 ||  x == 0 || y == my-1 || x == mx-1 ||
                arr[y-1][x] == ' ' || arr[y+1][x] == ' ' || arr[y][x-1] == ' ' || arr[y][x+1] == ' ')) {
                found = true;
                next[y][x] = ' ';
              }
            }
          }
          if (found) { height++; arr = next; }

        } while (found);

        return height;
         */
    }

    /** Difficulty 6
     * Write a function that takes in a string of one or more words, and returns the same
     * string, but with all five or more letter words reversed (Just like the name of this
     * Kata). Strings passed in will consist of only letters and spaces.
     * Spaces will be included only when more than one word is present.
     */
    public static String spinWords(String sentence) {
        if(sentence.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] wordsInArray = sentence.split("\\s+");
        String[] result = new String[wordsInArray.length];
        int i = 0;
        for(String s : wordsInArray){
            if(s.length() > 4){
                sb.append(s).reverse();
                result[i] = sb.toString();
                sb.setLength(0);
            }else{
                result[i] = s;
            }
            i++;
        }
        sb.setLength(0);
        for(String s : result){
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
        /* Best solution
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++) {
          if (words[i].length() >= 5) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
          }
        }
        return String.join(" ",words);
         */
    }

    /**
     * The rgb function is incomplete. Complete it so that passing in RGB decimal values
     * will result in a hexadecimal representation being returned. Valid decimal values
     * for RGB are 0 - 255. Any values that fall out of that range must be rounded to the
     * closest valid value.
     *
     * Note: Your answer should always be 6 characters long
     * the shorthand with 3 will not work here.
     */
    public static String rgb(int r, int g, int b){
        StringBuilder hexResponse = new StringBuilder();
        int[] rgbArray = new int[]{r,g,b};
        for(int digit : rgbArray){
            if(digit < 0 ){
                digit = 0;
            }else if(digit > 255){
                digit = 255;
            }
            if(digit < 16){
                hexResponse.append("0");
            }
            hexResponse.append(Integer.toHexString(digit));
        }

        return hexResponse.toString().toUpperCase();
        /* Best Solution
        if(r < 0) r = 0;
        if(g < 0) g = 0;
        if(b < 0) b = 0;
        if(r > 255) r = 255;
        if(g > 255) g = 255;
        if(b > 255) b = 255;

        return String.format("%02X%02X%02X", r, g, b);
         */
    }
}
