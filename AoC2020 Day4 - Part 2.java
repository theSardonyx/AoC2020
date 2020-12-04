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
		        fields = 0;
		    } else {
		        List<String> values = Arrays.asList(curr.split(":| "));
		        //System.out.println(values);
		        for (int i = 0; i < keys.length; i++) {
		            if (curr.contains(keys[i])) {
		                String val = values.get(values.indexOf(keys[i]) + 1);
		                switch (i) {
		                    //validate byr
		                    case 0:
		                        if (Integer.parseInt(val) >= 1920 &&
		                            Integer.parseInt(val) <= 2002)
		                            fields++;
		                        break;
		                    //validate iyr
		                    case 1:
		                        if (Integer.parseInt(val) >= 2010 &&
		                            Integer.parseInt(val) <= 2020)
		                            fields++;
		                        break;
		                    //validate eyr
		                    case 2:
		                        if (Integer.parseInt(val) >= 2020 &&
		                            Integer.parseInt(val) <= 2030)
		                            fields++;
		                        break;
		                    //validate hgt
		                    case 3:
		                        if (((val.matches("([0-9]{2})in") &&
		                            (Integer.parseInt(val.replaceAll("\\D+", "")) >= 59 &&
		                             Integer.parseInt(val.replaceAll("\\D+", "")) <= 76))) ||
		                           ((val.matches("([0-9]{3})cm") &&
		                            (Integer.parseInt(val.replaceAll("\\D+", "")) >= 150 &&
		                             Integer.parseInt(val.replaceAll("\\D+", "")) <= 193))))
		                             fields++;
		                        break;
		                    //validate hcl
		                    case 4:
		                        if (val.matches("^#([a-fA-F0-9]{6})$"))
		                            fields++;
		                        break;
		                    //validate ecl
		                    case 5:
		                        if (val.matches("amb|blu|brn|gry|grn|hzl|oth"))
		                            fields++;
		                        break;
		                    //validate pid
		                    case 6:
		                        if (val.matches("[0-9]{9}"))
		                            fields++;
		                }
		                //System.out.println(fields);
		            }
		        }
		    }
		}
		
		if (fields == keys.length) valid++;
		System.out.println(valid);
	}
}
