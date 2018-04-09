package edu.wiki.algorithms;

import java.util.Stack;

public class EvalRPN {
    
    /*
    tokens != null
    tokens have a valid simbol or number
    What return if is not a complete array?
    division by 0;
    the string are only integers valid ints?
    
    
    1) Use a stack of numbers for this, push the number and for every symbol pop the latest 2 numbers 
    when finish the arry just get the number from the stack
    
    time O(n)
    space O(n)
    
    2) iterate and use two index for the numbers and one for the simbols 
    
    */
    
    private static String operators = "+-*/";
    
    public int evalRPN(String[] tokens) {
        if(tokens == null) return 0;
        
        Stack<Integer> numbers = new Stack<Integer>();
        for(String token : tokens){
            // always use helper methods for all logic.
            if(isOperator(token)){
                executeOperator(numbers, token);
            } else {
                numbers.push(Integer.valueOf(token));
            }
            
        }
        
        return numbers.pop();
        
    }
    
    public boolean isOperator(String operator){
        return"+".equals(operator) ||  "-".equals(operator)  || "*".equals(operator) ||  "/".equals(operator) ;
    }
    
    public void executeOperator(Stack<Integer> numbers, String token){
        int operand1 = numbers.pop();
        int operand2 = numbers.pop();

        // User if else instead of switch case or swith case with the 
        switch(operators.indexOf(token)){
        case 0:  numbers.push(operand1 + operand2); break;
        case 1:  numbers.push(operand2 - operand1); break;
        case 2:  numbers.push(operand1 * operand2); break;
        case 3:  numbers.push(operand2 / operand1); break;
        }
    }
    
    public int executeDivison(int dividend, int divisor){
        if(dividend == 0 || divisor == 0) return 0;
        return dividend / divisor;
    }

}