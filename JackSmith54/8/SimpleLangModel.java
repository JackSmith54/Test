import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SimpleLangModel{

	static String text = "";
	
	public static void main(String[] args) throws Exception{		
		try{
			BufferedReader in = new BufferedReader(new FileReader("78000.txt"));
			while (in.ready()) { 
				  text =  text + in.readLine() + " "; 
			}
			in.close();
		}
		 catch (FileNotFoundException ex) {
			System.out.printf("Error: %s/n", ex);
		}
		
		System.out.println("Input sentance followed by a space to view probability: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().toLowerCase();
		scan.close();
		
		ArrayList<String> arr = words(text);
		HashMap<String,Float> hMap = counter(arr);
		
		ArrayList<String> check = words(s);
		ArrayList<Double> arrayProb = checkProb(hMap,check);
		System.out.println( sentenceProb(arrayProb));
	}
	
	//Breaks string of text up into arraylist of individual word strings
	public static ArrayList<String> words(String s){
		s = s.toLowerCase();
		String newS = s.replaceAll("[^a-zA-Z ]", "");
		ArrayList<String> arrayList = new ArrayList<String>();
		String currWord = "";

		for(int i = 0; i < newS.length(); i ++){
			char c = newS.charAt(i);

			if (Character.isLetter(c) == false){
				arrayList.add(currWord);
				currWord = "";
			}else{
				currWord = currWord + c;
			}
		}
		for(int i = 0; i < arrayList.size(); i++){
			if (arrayList.get(i) == ""){
				arrayList.remove(i);
			}
		}
		for (int x = 0; x < arrayList.size(); x++){
			if(arrayList.get(x) == ""){
				arrayList.remove(x);
			}
		}
		return arrayList;
	}
	
	// Maps each string to a counter
	public static HashMap<String,Float> counter(ArrayList<String> arr){

		HashMap<String,Float> map = new HashMap<String,Float>();
			for(String s : arr){
				if (map.keySet().contains(s)){
					map.put(s, map.get(s)+1);
				}else{
					map.put(s, (float) 1);
				}
			}
			return map;	
	}
	
	//checks the probability of individual words in an arraylist and out puts the probabilities in new arraylist
	static ArrayList<Double> checkProb(HashMap<String,Float> map, ArrayList<String> check) throws Exception{
		ArrayList<Double> arrayProb = new ArrayList<Double>();
		double d = 1;
		
		 for (int i = 0; i < check.size(); i++){
			 if (map.containsKey(check.get(i))){
				 d = map.get(check.get(i))/78000;
				 arrayProb.add(d);
			 }else{
				 throw new Exception("File does not contain word " + check.get(i));
			 }
		 }
		 return arrayProb;
	}
	
	//multiplies probabilities in arraylist
	static double sentenceProb(ArrayList<Double> arrayProb){
		double count = 1;
		for (int i = 0; i < arrayProb.size(); i++){
			count = count * arrayProb.get(i);
		}
		return count;
	}
}
