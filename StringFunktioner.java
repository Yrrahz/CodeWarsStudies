import java.util.ArrayList;
import java.util.Arrays;

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
}
