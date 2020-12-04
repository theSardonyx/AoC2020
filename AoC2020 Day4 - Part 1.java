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
		String[] keys = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
		int fields = 0;
		int valid = 0;
		while (in.hasNext()) {
		    String curr = in.nextLine();
		    if (curr.isEmpty()) {
		        if (fields == keys.length) valid++;
		        //System.out.println(fields);
		        fields = 0;
		    } else {
		        for (String s : keys) {
		            if (curr.contains(s)) fields++;
		        }
		    }
		}
		//uncomment if input doesn't have newline at the end
		//if (fields == keys.length) valid++;
		System.out.println(valid);
	}
}
