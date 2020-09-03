import java.io.*;
import java.util.*;
class BracketSequences{
    private static final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String [] args) throws IOException{
        try{
            int openBraceCount = 0, closeBraceCount = 0;
            String braceString = bufferedreader.readLine();
            int count = 0;
            for(int i = 0; i < braceString.length(); i++){
                if(braceString.charAt(i) == '('){
                    openBraceCount++;
                }
                else if(braceString.charAt(i) == ')'){
                    closeBraceCount++;
                }
            }
            if(openBraceCount != closeBraceCount){
                System.out.println(0);
                return;
            }
            StringBuilder build = new StringBuilder(braceString);
            for(int i = 0; i < braceString.length(); i++){
            	char temp = build.charAt(0);
            	build.deleteCharAt(0);
            	build.append(temp);
            	if(balancedBrackets(build.toString().toCharArray()))
            	 	count++;
            }
            System.out.println(count);
        }
        catch(Exception e){System.out.println(e);}
    }

    public static boolean balancedBrackets(char[] charArray){
    	char[] array = new char[charArray.length];
    	int top = 0;
    	if(charArray[0] == ')')
    		return false;
    	else if(charArray[charArray.length-1] == '(')
    		return false;
    	for(int i = 0; i < charArray.length; i++){
    		if(top > -1){
    			if(charArray[i] == '(')
    			array[top++] = '(';
	    		else
	    			top--;
    		}
    		else
    			return false;
    		
    	}
    	if(top == 0)
    		return true;
    	return false;
    }
}
