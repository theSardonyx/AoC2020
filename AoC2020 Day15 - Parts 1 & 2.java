/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
	    int index = 0;
	    int last = 0;
	    while(in.hasNextInt()) {
	        int curr = in.nextInt();
	        mem.put(curr, index);
	        index++;
	        last = curr;
	    }
		
		// -1 because 0-indexed
		// int max = 2019
		int max = 29999999;
	    for (int i = --index; i < max; i++) {
	        int curr = 0;
	        if (mem.containsKey(last)) {
	            curr = i - mem.get(last);
	        }
	        mem.put(last, i);
	        last = curr;
	    }
	    System.out.println(last);
	}
}
