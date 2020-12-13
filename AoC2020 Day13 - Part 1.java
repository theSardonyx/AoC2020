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
		int arrive = Integer.parseInt(in.nextLine());
		String[] ids = Arrays.asList(in.nextLine().split(",")).stream()
		                                                      .filter(str -> !str.equals("x"))
		                                                      .toArray(String[]::new);
		List<Integer> diff = new ArrayList<Integer>();
		for (String s: ids) {
		    int bus = Integer.parseInt(s);
		    diff.add(bus - (arrive % bus));
		}
		int min = Collections.min(diff);
		System.out.println(min * Integer.parseInt(ids[diff.indexOf(min)]));
	}
}
