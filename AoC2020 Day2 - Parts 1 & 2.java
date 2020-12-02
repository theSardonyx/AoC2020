import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int valid = 0;
		while (in.hasNext()) {
		    String[] curr = in.nextLine().split(" ");
		    String[] indices = curr[0].split("-");
		    int min = Integer.parseInt(indices[0]);
		    int max = Integer.parseInt(indices[1]);
		    
		    /* Part One
		    long count = curr[2].chars().filter(ch -> ch == curr[1].charAt(0)).count();
		    if (count >= min && count <= max) valid++;
		    */
		    
		    // Part Two
		    if (curr[2].charAt(min - 1) == curr[1].charAt(0) ^ curr[2].charAt(max - 1) == curr[1].charAt(0))
		        valid++;
		}
		System.out.println(valid);
	}
}