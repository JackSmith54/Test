import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class SubCipher {
	static String s1 = "";
	static String s2 = "";
	static BufferedReader buffCipher,buffTextToDecipher;
	
	public static void main(String[] args) throws IOException{
		
		buffCipher = new BufferedReader(new FileReader("cipher.text"));
		buffTextToDecipher = new BufferedReader(new FileReader("testCase.text"));
		
		String textToDecipher = readFile(s1,buffTextToDecipher);
		String cipherString = readFile(s2,buffCipher);
		
		HashMap<String, Integer> testCaseMap = mapLetters(textToDecipher);	
		HashMap<String, Integer> cipherMap = mapLetters(cipherString);
		
		System.out.println(swapValues(testCaseMap,cipherMap,textToDecipher));
	}
	
	//swaps the highest key value in cipher map with the letter that appears most in the cipherText
	static String swapValues(HashMap<String,Integer> textToDecipherMap,HashMap<String,Integer> cipherMap,String textToDecipher){

		textToDecipher = textToDecipher.toLowerCase().replaceAll("[^a-zA-Z ]", "");
		LinkedList<String> input = new LinkedList<String>();
		int numLoops = textToDecipherMap.size();
		for(int i = 0; i< textToDecipher.length(); i++){
			char c = textToDecipher.charAt(i);
			input.add(String.valueOf(c));
		}
		for(int i = 0; i < numLoops; i++){
			String currentLetter = getMaxKey(textToDecipherMap);
			String newLetter = getMaxKey(cipherMap);
			for(int j = 0; j < textToDecipher.length();j++){
				String itr = input.get(j);
				if(currentLetter.equals(itr) && (currentLetter.length() == 1)){
					input.remove(j);
					input.add(j, newLetter + ".");
				}
			}
			removeMaxKey(cipherMap);
			removeMaxKey(textToDecipherMap);
		}
		String cracked = "";
		for(int k = 0; k < input.size();k++){
			cracked = cracked + input.get(k).replaceAll("[^a-zA-Z ]", "");
		}
		return cracked;
	}
	
	static HashMap<String,Integer> removeMaxKey(HashMap<String,Integer> map){
		map.remove(getMaxKey(map));
		return map;
	}
	
	static String getMaxKey(HashMap<String,Integer> map){
		Map.Entry<String,Integer> maxEntry = null;
		for (Map.Entry<String,Integer> entry : map.entrySet()){
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
		        maxEntry = entry;
		    }
		}
		return maxEntry.getKey();
	}
	
	static String readFile(String str, BufferedReader in) throws IOException{
		try{
			while (in.ready()) { 
				  str =  str + in.readLine() + " "; 
			}
			in.close();
		}
		 catch (FileNotFoundException ex) {
			System.out.printf("Error: %s/n", ex);
		}
		return str;
	}

	static HashMap<String,Integer> mapLetters(String input){
		String temp = input.toLowerCase().replaceAll("[^a-z]","");
		String[] letters = temp.split("");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (String s : letters){
			if (map.keySet().contains(s)){
				map.put(s, map.get(s)+1);
			}else{
				map.put(s,1);
			}
		}
		map.remove("");
		return map;
	}
}
