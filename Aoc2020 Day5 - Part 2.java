/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		List<Integer> seats = new ArrayList<Integer>();
		while (in.hasNext()) {
		    String curr = in.next().replaceAll("F|L", "0")
		                           .replaceAll("B|R", "1");
		    int id = Integer.parseInt(curr, 2);
		    seats.add(id);
		}
		
		Collections.sort(seats);
		boolean found = false;
		int missing = 0;
		for (int i = 1; i < seats.size() - 1; i++) {
		    if (seats.get(i) - seats.get(i - 1) > 1) {
		        found = true;
		        missing = seats.get(i) - 1;
		        break;
		    }
		}
	    
		System.out.println(missing);
	}
}
