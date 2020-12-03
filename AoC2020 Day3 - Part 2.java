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
		int[] count = new int[5];
		int[][] slopes = {{1, 1},
		                  {3, 1},
		                  {5, 1},
		                  {7, 1},
		                  {1, 2}};
		String curr = in.nextLine();
		int[] x = new int[5];
		int y = 0;
		do {
		    curr = in.nextLine();
		    y++;
		    for (int i = 0; i < 5; i++) {
		        if (y % slopes[i][1] == 0) {
    		        if (curr.charAt((x[i] + slopes[i][0]) % curr.length()) == '#')
    		            count[i]++;
    		        x[i] += slopes[i][0];
		        }
		    }
		} while (in.hasNext());
		
		int prod = 1;
		for (int num: count) prod *= num;
		System.out.println(prod);
	}
}
