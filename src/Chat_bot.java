import java.util.*;
import java.io.*;

public class Chat_bot {
	 
	public static void main(String[] args) {
		
		Set<String> hedgeSet = new HashSet<String>();
		Set<String> qualifierSet = new HashSet<String>();
		Map<String,String> replacementMap = new HashMap<String,String>();
		
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("It is getting late, maybe we had better quit");
		
		qualifierSet.add("Why do you say that");
		qualifierSet.add("You seem to think that");
		qualifierSet.add("So, you are concerned that");
		
		replacementMap.put("i", " you");
		replacementMap.put("me", " you");
		replacementMap.put("my", " your");
		replacementMap.put("am", " are");
		
		ArrayList<String> file_s = new ArrayList<String>();
		File file = new File("myfile.txt");
		
		
		System.out.println("Good day. What is your problem?");
		System.out.println("Enter your response here or Quit to quit:");
		
		file_s.add("Good day. What is your problem?");
		file_s.add("Enter your response here or Quit to quit:");
		
		//String loop = "N";
		String input = "None";
		Scanner scn = new Scanner(System.in);
		Random rand = new Random();
		
		int keep_track = 0;
		
		
		while(!input.equals("Quit"))
		{
			input = scn.nextLine();		
			if(input.equals("Quit"))
			{
				//System.out.println("1");
				break;
			}
			String selected =" ";
			file_s.add(input);
			if(keep_track%2!=0)
			{
				int index = rand.nextInt(hedgeSet.size());
				Iterator<String> iter = hedgeSet.iterator();
				//System.out.println(index);
				for (int i = 0; i <= index; i++) {
					selected = iter.next();
					//System.out.println(iter.next());
				}
				System.out.println(selected);
				file_s.add(selected);
			}
			
			else if(keep_track%2==0)
			{
				int index = rand.nextInt(qualifierSet.size());
				Iterator<String> iter = qualifierSet.iterator();
				//System.out.println(index);
				for (int i = 0; i <= index; i++) {
					selected =iter.next();
					//System.out.println(iter.next());
				}
				System.out.print(selected +" ");
				
				String p= "";
				StringTokenizer sk= new StringTokenizer(input);
				 while (sk.hasMoreTokens()) {
					 String s = sk.nextToken();
					 if(s.equals("i"))
					 {
						 p+=replacementMap.get("i") + " ";
						 System.out.print(replacementMap.get("i") + " ");
					 }
					 else if(s.equals("me"))
					 {
						 p+=replacementMap.get("me") + " ";
						 System.out.print(replacementMap.get("me") + " ");
					 }
					 else if(s.equals("my"))
					 {
						 p+=replacementMap.get("my") + " ";
						 System.out.print(replacementMap.get("my") + " ");
					 }
					 else if(s.equals("am"))
					 {
						 p+=replacementMap.get("am") + " ";
						 System.out.print(replacementMap.get("am") + " ");
					 }
					 else
					 {
						 p+=s + " ";
						 System.out.print(s+ " ");
					 }
			     }
				 
				 file_s.add(selected +" "+p);
				 
				 /*
				if(input.contains("i"))
				{
					input = input.replace("i", replacementMap.get("i"));
				}
			    if(input.contains("me"))
				{
					input = input.replace("me", replacementMap.get("me"));
				}
				if(input.contains("my"))
				{
					input = input.replace("my", replacementMap.get("my"));
				}
				if(input.contains("am"))
				{
					input = input.replace("am", replacementMap.get("am"));
				}
				
				System.out.print(input);
				*/
				 
				 
			}
			
			
			System.out.println("Enter your response here or Quit to quit:");
			
			keep_track++;
			
		}
		
		Iterator<String> iter1 = file_s.iterator();
		/*for (int i = 0; i < file_s.size(); i++) {
			System.out.println(iter1.next());
		}*/
		
		PrintWriter writer=null;
		 try {
		     writer = new PrintWriter(new File("output.txt"));
		     for (int i = 0; i < file_s.size(); i++) {
					//selected = iter1.next();
		    	 	String s=iter1.next();
		    	 	writer.println(s);
		    	 	System.out.println(s);
				}
		 } catch (FileNotFoundException e) {
		     System.out.println("File not found");
		 }
		 //close the print writer
		 writer.close();
		
	}

}
