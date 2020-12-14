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
		Long mask0 = 0L;
		Long mask1 = 0L;
		Map<Long, Long> mem = new HashMap<Long, Long>();
		
		while(in.hasNext()) {
		    String[] curr = in.nextLine().split(" ");
		    if (curr[0].equals("mask")) {
		        mask0 = Long.parseLong(curr[2].replaceAll("X", "0"), 2);
		        mask1 = Long.parseLong(curr[2].replaceAll("1", "0").replaceAll("X", "1"), 2);
		    } else {
		        Long address = Long.parseLong(curr[0].substring(4, curr[0].length() - 1)) | mask0;
		        Long val = Long.parseLong(curr[2]);
		        List<Long> list = new ArrayList<Long>();
		        list.add(address);
		        
		        Long bit = 1L;
		        while (bit < 0x1000000000L) {
		            if ((mask1 & bit) > 0) {
		                List<Long> temp = new ArrayList<Long>();
		                for (Long l : list) temp.add(l);
		                list.clear();
		                
		                for (Long l : temp) {
		                    list.add(l | bit);
		                    list.add(l & (0xFFFFFFFFFL ^ bit));
		                }
		            }
		            bit <<= 1;
		        }
		        for (Long l : list) mem.put(l, val);
		    }
		}
		
		long sum = mem.values().stream().reduce((long) 0, (x, y) -> x + y);
		System.out.println(sum);
	}
}
