import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class BracketCheck {
	static String text = "";
	public static void main(String[] args) throws IOException{
		try{
			BufferedReader in = new BufferedReader(new FileReader("bracketCheck.txt"));
			while (in.ready()) { 
				text = in.readLine(); 
				System.out.println(bracketCheck(text));
			}
			in.close();
		}
		 catch (FileNotFoundException ex) {
			System.out.printf("Error: %s/n", ex);
		}

	}
	
	public static boolean bracketCheck(String string ){
		
		Stack<Character> stack = new Stack<Character>();
		char c;
		
		for (int i = 0; i < string.length(); i++){
			c = string.charAt(i);
			
			if (c == '('){
				stack.push(c);
			} else if (c == ')'){
				if (stack.isEmpty()){
					return false;
				} else if ( stack.peek() == '('){
					stack.pop();
				}
			}
			
		}
		
		if (!stack.isEmpty()){
			return false;
		};
		return true;
	}
}
