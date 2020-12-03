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
		int count = 0;
		int[] slope = {3, 1};
		String curr = in.nextLine();
		int point = 0;
		do {
		    for (int i = 0; i < slope[1]; i++)
		        curr = in.nextLine();
		    if (curr.charAt((point + slope[0]) % curr.length()) == '#')
		        count++;
		    point += slope[0];
		} while (in.hasNext());
		System.out.println(count);
	}
}
