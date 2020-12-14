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
		String mask = "";
		Map<Integer, Long> mem = new HashMap<Integer, Long>();
		while(in.hasNext()) {
		    String[] curr = in.nextLine().split(" ");
		    if (curr[0].equals("mask")) {
		        mask = curr[2];
		    } else {
		        int address = Integer.parseInt(curr[0].substring(4, curr[0].length() - 1));
		        String s = Integer.toBinaryString(Integer.parseInt(curr[2]));
		        s = String.format("%36s", s).replaceAll(" ", "0");
		        for (int i = 0; i < mask.length(); i++) {
		            if (mask.charAt(i) != 'X' && mask.charAt(i) != s.charAt(i)) {
		                try {
		                    s = s.substring(0, i) + mask.charAt(i) + s.substring(i + 1);
		                } catch (Exception e) {
		                    s = mask.charAt(i) + s.substring(i + 1);
		                }
		            }
		        }
		        mem.put(address, Long.parseLong(s, 2));
		    }
		}
		long sum = mem.values().stream().reduce((long) 0, (x, y) -> x + y);
		System.out.println(sum);
	}
}
