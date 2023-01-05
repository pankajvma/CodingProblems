// https://www.hackerrank.com/challenges/java-stack/problem
package hackerrank.warmupChallenges.java.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackInJava {
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(isBalanced(input.toCharArray()));
		}
		
	}
    
    public static boolean isBalanced(char[] stack){
        List<Character> openBracketList = new ArrayList<>();
        openBracketList.add('{');
        openBracketList.add('(');
        openBracketList.add('[');
        Stack<Character> newStack = new Stack<>();
        for(int i = 0; i < stack.length; i++){
            if(openBracketList.contains(stack[i])){
                newStack.push(stack[i]);
            }else if(!newStack.empty() &&
                ((newStack.peek() == '{' && stack[i] == '}')
                    ||
                (newStack.peek() == '(' && stack[i] == ')')
                    ||
                (newStack.peek() == '[' && stack[i] == ']')
            )){
                newStack.pop();
            }else return false;        
        }
        return newStack.empty();
    }
}