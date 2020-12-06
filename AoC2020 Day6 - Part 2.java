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
		Map<String, Integer> questions = new HashMap<String, Integer>();
		int total = 0;
		int group = 0;
		while (in.hasNext()) {
		    String line = in.nextLine();
		    if (line.isEmpty()) {
		        total += Collections.frequency(new ArrayList<Integer>(questions.values()), group);
		        questions.clear();
		        group = 0;
		    } else {
		        group++;
		        for (char c : line.toCharArray())
		            questions.put ("" + c, questions.getOrDefault("" + c, 0) + 1);
		    }
		}
		total += Collections.frequency(new ArrayList<Integer>(questions.values()), group);
		System.out.println(total);
	}
}