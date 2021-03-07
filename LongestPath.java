//Given a string representing the file system, return the path.

package practiceProblems;

import java.util.regex.Pattern;

public class LongestPath {

	private static String[] split(String fs, int level) {
		StringBuilder regex = new StringBuilder();
	    regex.append("\\f\\t{");
	   regex.append(level);
	   regex.append("}(?=[^\\t])");
	    Pattern pattern = Pattern.compile(regex.toString());
	    return pattern.split(fs);
	  }

	private static String longestPath(String fs, int level) {
	    String[] tokens = split(fs, level);

	    if (tokens == null) {
	      return "";
	    }

	    String root = tokens[0];

	    String longest = "";
	    for (int i = 1; i < tokens.length; i++) {
	      String path = longestPath(tokens[i], level + 1);
	      if (path.length() > longest.length()) {
	        longest = path;
	      }
	    }

	    return longest == "" ? root : root + "/" + longest;
	  }

	  private static String longestPath(String fs) {
	    String[] tokens = split(fs, 0);
	    String longest = "";
	    for (String token : tokens) {
	      String path = longestPath(token, 1);
	      if (path.length() > longest.length()) {
	        longest = path;
	      }
	    }
	    return longest;
	  }
	
	public static void main(String[] args) {
		 String[] filesystems = new String[] { "user\n\tpictures\n\tdocuments\n\t\tnotes.txt\nREADME.txt",
			        "user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\t\t\timages\n\t\t\t\tnew_york.png\n\t\t\t\tlos_angeles.png\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt\nREADME.txt",
			        "user1\n\tpictures\n\tdocuments\n\t\tnotes.txt\nuser2\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt\nREADME.txt",
			        "user1\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\t\t\timages\n\t\t\t\tnew_york.png\n\t\t\t\tlos_angeles.png\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt\nuser2\n\tpictures\n\tdocuments\n\t\tnotes.txt\nREADME.txt" };

			    for (String fs : filesystems) {
			      System.out.println(fs);
			      System.out.println("-------------------------------");
		
			      String longest_path = longestPath(fs);
			      System.out.printf("Longest path is:\n%s of length %d\n", longest_path, longest_path.length());
			      System.out.println("===============================");
			    }
			  }
}


