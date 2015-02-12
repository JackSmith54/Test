import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class WorkerMinimisation {
	
	
	static LinkedList<String> teacherSubjectList = new LinkedList<String>();
	static String subjectString = "";
	static LinkedList<String> teacherList = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException{
		
		try{
			BufferedReader teachers = new BufferedReader(new FileReader("teachers.txt"));
			BufferedReader subjects = new BufferedReader(new FileReader("subjects.txt"));
			while (teachers.ready()) {
										
				String tempSubjectList = teachers.readLine().replaceAll("\\s+","").toLowerCase(); 
				String tempTeachers;
				int dashIndex = tempSubjectList.indexOf("-");
				tempTeachers = tempSubjectList.substring(0, dashIndex);
				tempSubjectList = tempSubjectList.substring(dashIndex + 1, tempSubjectList.length());
				teacherList.add(tempTeachers);
				teacherSubjectList.add(tempSubjectList); 
			}
			teachers.close();
			while (subjects.ready()){
				 subjectString = subjects.readLine().replaceAll("\\s+","").toLowerCase(); 
			}
			subjects.close();
		}
		 catch (FileNotFoundException ex) {
			System.out.printf("Error: %s/n", ex);
		}

		LinkedList<String> subjectList = stringToList(subjectString);
		while(subjectList.size() != 0){
			String bestteacherSubjects = bestTeacherSubjects(teacherSubjectList,subjectList);
			System.out.println(teacherPicked(teacherList,bestteacherSubjects,teacherSubjectList));
			removeSubjects(subjectList,bestteacherSubjects);
		}                          
	}
	
	//Turns String into List of String Subjects
	static LinkedList<String> stringToList(String subjects){
		String[] temp = subjects.split(",");
		LinkedList<String> subjectList = new LinkedList<String>();
		for (int i = 0; i < temp.length; i++){
			subjectList.add(temp[i]);
		}
		return subjectList;
	}
	
	//returns best teacher's subjects
	static String bestTeacherSubjects(LinkedList<String> teacherSubjectList, LinkedList<String> subjectList){
		String teacher = "";
		int highestCount = 0;
		
		for(String teach : teacherSubjectList){
			int iCount = 0;
			for(String sub : subjectList){
				if (teach.contains(sub)){
					iCount++;
					if (iCount > highestCount){
						highestCount = iCount;
						teacher = teach;		
					}
				}
			}	
		}		
		return teacher;
	}
	
	static String teacherPicked(LinkedList<String> teacherList, String teacherSubjects,LinkedList<String> teacherSubjectList){
		
		String teacherPicked = "";
		for (int i = 0; i < teacherList.size(); i++){
			if(teacherSubjectList.get(i).contains(teacherSubjects)){
				teacherPicked = teacherList.get(i);
			}
		}
		return teacherPicked;
	}
	
	//removes best teachers subjects from subject list
	static LinkedList<String> removeSubjects(LinkedList<String> subjectList, String teacherSubjects){
		
		Iterator<String> iter = subjectList.iterator();
		while(iter.hasNext()){
			String s = iter.next();
			if(teacherSubjects.contains(s)){
				iter.remove();
			}
		}
		return subjectList;
	}
}


