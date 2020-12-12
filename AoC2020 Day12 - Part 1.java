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
		int dir = 0;
		int x = 0;
		int y = 0;
		while (in.hasNext()) {
		    String curr = in.nextLine();
		    int num = Integer.parseInt(curr.substring(1));
		    switch (curr.charAt(0)) {
		        case 'N': y += num; break;
		        case 'S': y -= num; break;
		        case 'E': x += num; break;
		        case 'W': x -= num; break;
		        case 'L': dir = Math.floorMod(dir + (num / 90), 4); break;
		        case 'R': dir = Math.floorMod(dir - (num / 90), 4); break;
		        case 'F':
		            switch (dir) {
		                case 0: x += num; break;
		                case 1: y += num; break;
		                case 2: x -= num; break;
		                case 3: y -= num;
		            }
		    }
		    //System.out.printf("(%d, %d) facing %d\n", x, y, dir);
		}
		System.out.println(Math.abs(x) + Math.abs(y));
	}
}
