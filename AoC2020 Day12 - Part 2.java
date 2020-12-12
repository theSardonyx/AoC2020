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
		int x = 0;
		int y = 0;
		int[] point = {10, 1};
		while (in.hasNext()) {
		    String curr = in.nextLine();
		    int num = Integer.parseInt(curr.substring(1));
		    switch (curr.charAt(0)) {
		        case 'N': point[1] += num; break;
		        case 'S': point[1] -= num; break;
		        case 'E': point[0] += num; break;
		        case 'W': point[0] -= num; break;
		        case 'L':
		            rotate(point, (num / 90), 'L');
		            break;
		        case 'R':
		            rotate(point, (num / 90), 'R');
		            break;
		        case 'F':
		            x += (num * point[0]);
		            y += (num * point[1]);
		    }
		    //System.out.printf("Ship at (%d, %d) facing %d\nWaypoint at (%d, %d)\n", x, y, dir, point[0], point[1]);
		}
		System.out.println(Math.abs(x) + Math.abs(y));
	}
	
	public static void rotate(int[] point, int dir, char rotation) {
	    if (dir == 2) {
            point[0] = point[0] * -1;
            point[1] = point[1] * -1;
        } else if ((rotation == 'L' && dir == 1) || (rotation == 'R' && dir == 3)) {
            int temp = point[0];
            point[0] = point[1] * -1;
            point[1] = temp;
        } else if ((rotation == 'R' && dir == 1) || (rotation == 'L' && dir == 3)){
            int temp = point[0];
            point[0] = point[1];
            point[1] = temp * -1;
        }
	}
}
