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
		int max = 0;
		while (in.hasNext()) {
		    String curr = in.next().replaceAll("F|L", "0")
		                           .replaceAll("B|R", "1");
		    int id = Integer.parseInt(curr, 2);
		    if (id > max) max = id;
		}
		System.out.println(max);
	}
}
