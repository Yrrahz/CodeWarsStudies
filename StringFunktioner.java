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
}
