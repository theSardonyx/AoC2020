/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static Set<String> list = new HashSet<String>();
    static List<String> lines;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		lines = new ArrayList<String>();
		while (in.hasNext()) lines.add(in.nextLine());
		
		find("shiny gold");
		//less one because they also count the shiny gold bag
		System.out.println (list.size() - 1);
		System.out.println(count("shiny gold") - 1);
	}
	
	public static void find (String color) {
	    for (String s: lines) {
	        if (s.contains(color)) {
	            list.add(color);
	            String[] temp = s.split(" ");
	            if (!s.substring(0, color.length()).equals(color))
	                find (temp[0] + " " + temp[1]);
	        }
	    }
	}
	
	public static int count (String color) {
	    int total = 1;
	    for (String s: lines) {
	        if (s.substring(0, color.length()).equals(color)) {
	            String[] temp = s.split(" ");
	            for (int i = 4; i < temp.length; i+=4) {
	                if (temp[i].matches("\\d+"))
	                    total += Integer.parseInt(temp[i]) * count (temp[i + 1] + " " + temp[i + 2]);
	            }
	        }
	    }
	    return total;
	}
}
