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
		Set<String> questions = new HashSet<String>();
		int total = 0;
		while (in.hasNext()) {
		    String line = in.nextLine();
		    if (line.isEmpty()) {
		        total += questions.size();
		        questions.clear();
		    } else {
		        for (char c : line.toCharArray()) questions.add ("" + c);
		    }
		}
		total += questions.size();
		System.out.println(total);
	}
}
