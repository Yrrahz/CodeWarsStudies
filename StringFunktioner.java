import java.util.ArrayList;
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
}
