
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Tokeniser {	
	static String text = "";
	
	public static void main(String[] args) throws IOException{		
		try{
			BufferedReader in = new BufferedReader(new FileReader("token.txt"));
			while (in.ready()) { 
				
				  text =  text + in.readLine() + " "; 
				 // System.out.println(text); 
			}
			in.close();
			
		}
		 catch (FileNotFoundException ex) {
			System.out.printf("Error: %s/n", ex);
		}
		
		ArrayList<String> arr = words(text);
		HashMap<String,Integer> hMap = counter(arr);
		
		Collection<Integer> values = hMap.values();
		Collection<String> keys = hMap.keySet();
		Iterator<Integer> itr = values.iterator();
		Iterator<String> itr2 = keys.iterator();
		FileWriter fw = new FileWriter("tokenOutput.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		while (itr.hasNext()){
			pw.println(itr2.next() + "	" + itr.next());
		}
		pw.close();
	}
	
	//Breaks string of text up into arraylist of individual word strings
	public static ArrayList<String> words(String s){
		s = s.toLowerCase().replaceAll("[^a-zA-Z ]", "");
		ArrayList<String> arrayList = new ArrayList<String>();
		String currWord = "";

		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if (Character.isLetter(c) == false){
				arrayList.add(currWord);
				currWord = "";
			}else{
				currWord = currWord + c;
			}
		}
		arrayList = removeSpaces(arrayList);
		return arrayList;
	}
	
	public static ArrayList<String> removeSpaces(ArrayList<String> arrayList){
		ArrayList<String> newArray = new ArrayList<String>();
		for(int i = 0; i < arrayList.size(); i++){
			if(arrayList.get(i) != "" && arrayList.get(i) != " "){
				newArray.add(arrayList.get(i));
			}
		}
		return newArray;
	}
	
	// Maps each string to a counter
	public static HashMap<String,Integer> counter(ArrayList<String> arr){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
			for(String s : arr){
				if (map.keySet().contains(s)){
					map.put(s, map.get(s)+1);
				}else{
					map.put(s, 1);
				}
			}
			return map;	
	}
}