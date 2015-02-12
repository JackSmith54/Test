import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class RPNCalc {

	static String input;
		public static void main(String[] args) throws IOException{		
			try{
				BufferedReader in = new BufferedReader(new FileReader("RPNCalc.txt"));
				while (in.ready()) { 
					input =  in.readLine() + " "; 
					System.out.println(RPNCalc.rpnCalc(input));
				}
				in.close();
			}
			 catch (FileNotFoundException ex) {
				System.out.printf("Error: %s/n", ex);
			}
			

		}
		
		static int rpnCalc(String s){
			Stack<Integer> stack = new Stack<Integer>();
			String[] arrayString = s.split(" ");
			
			for (int i = 0; i < arrayString.length; i ++){
				if (isInteger(arrayString[i])){
					stack.push( Integer.parseInt(arrayString[i]));		
				}else stack.push(evaluate(stack.pop(),stack.pop(), arrayString[i]));
			}
			return stack.pop();
		}
		
		static int evaluate(int a, int b, String operator){
			if (operator.equals("+")){
				return a + b;
			}else if ( operator.equals("*")){
				return a * b;
			}else if (operator.equals("-")){
				return b - a;
			}else if (operator.equals("/")){
				return b / a;
			}else return b % a;		
		}
		
		public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException ex) { 
		        return false; 
		    }
		    return true;
		}
}