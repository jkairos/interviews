package com.studies.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
	
	public static final char LEFT_PAR = '('; 
	public static final char RIGHT_PAR = ')';
	
	private static Map<Character, Integer> precedence = null;
	
	static{
		precedence = new HashMap<Character, Integer>();
		precedence.put(LEFT_PAR, -1);
		precedence.put(RIGHT_PAR, -1);
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
	}
	
	public String convertInfixToPosFix(String infix){
		StringBuilder str = new StringBuilder();
		char[] infixChar = infix.toCharArray();
		Stack<Character> operatorStack = new Stack<Character>();
		
		for (char c : infixChar) {
			if(!isOperator(c)){
				str.append(c);
			}else{
				if(operatorStack.size() == 0){
					operatorStack.push(c);
				}else if((c == LEFT_PAR || hasHigherPrecedence(c, operatorStack.peek())) && c != RIGHT_PAR){
					operatorStack.push(c);
				}else if (c == RIGHT_PAR){
					char ch = operatorStack.pop();
					str.append(ch);
					
					while(ch!=LEFT_PAR){
						ch = operatorStack.pop();
						if(ch!=LEFT_PAR){
							str.append(ch);
						}
					}
				}else{
					str.append(operatorStack.pop());
					operatorStack.push(c);
				}
			}
		}
		
		while(operatorStack.size() > 0 ){
			str.append(operatorStack.pop());
		}
		
		return str.toString();
	}
	
	private boolean hasHigherPrecedence(char ch1, char ch2){
		if(ch1 == '\u0000' || ch2 =='\u0000' ){
			return false;
		}else{
			return precedence.get(ch1) > precedence.get(ch2); 
		}
	}
	
	private boolean isOperator(char ch){
		return precedence.get(ch)!=null;
	}
}
