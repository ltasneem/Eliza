import org.junit.* ;
import static org.junit.Assert.* ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Eliza_test {
	
	  @Test
	   public void test_hedge() {
	      Chat_bot E = new Chat_bot() ;
	      Set<String> hedgeSet = new HashSet<String>();
		  Set<String> qualifierSet = new HashSet<String>();
		  Map<String,String> replacementMap = new HashMap<String,String>();
		  E.initialize(hedgeSet, qualifierSet, replacementMap);
		  String s1="Please tell me more";
		  String s2="Many of my patients tell me the same thing";
		  String s3="It is getting late, maybe we had better quit";
	      assertTrue(E.hedge(hedgeSet,0).equals(s3)||E.hedge(hedgeSet,1).equals(s1)||E.hedge(hedgeSet,2).equals(s2)) ;
	      //assertTrue(E.hedge(hedgeSet,0).equals(s1)||E.hedge(hedgeSet,1).equals(s2)||E.hedge(hedgeSet,2).equals(s3)) ;
	   }
	  
	  @Test
	   public void test_qualifier() {
	      Chat_bot E = new Chat_bot() ;
	      Set<String> hedgeSet = new HashSet<String>();
		  Set<String> qualifierSet = new HashSet<String>();
		  Map<String,String> replacementMap = new HashMap<String,String>();
		  E.initialize(hedgeSet, qualifierSet, replacementMap);
		  String input = "Why do you say that your teacher hates you";
		  String s1="Why do you say that";
		  String s2="You seem to think that";
		  String s3="So, you are concerned that";
	      assertTrue(E.qualifier(qualifierSet,replacementMap,input,0).contains(s3)||E.qualifier(qualifierSet,replacementMap,input,1).contains(s1)||E.qualifier(qualifierSet,replacementMap,input,2).contains(s2)) ;
	      //assertTrue(E.hedge(hedgeSet,0).equals(s1)||E.hedge(hedgeSet,1).equals(s2)||E.hedge(hedgeSet,2).equals(s3)) ;
	   }
	  
	  /*public static void main(String[] args) {
		  	test_hedge();
	  }*/

}
