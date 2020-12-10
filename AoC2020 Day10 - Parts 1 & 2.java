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
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		while (in.hasNext()) list.add(in.nextInt());
		
		Collections.sort(list);
		int diff1 = 0;
		int diff3 = 1; //because your device is always +diff3
		for (int i = 1; i < list.size(); i++) {
		    int diff = list.get(i) - list.get(i - 1);
		    if (diff == 1) diff1++;
		    else if (diff == 3) diff3++;
		}
		System.out.println(diff1 * diff3);
		
		//list.add(list.get(list.size() - 1) + 3);
        
        double[] dp = new double[list.get(list.size() - 1) + 1];
        dp[0] = 1;
        for (Integer n : list) {
            try {
                dp[n] += dp[n - 1];
            } catch (Exception e) {}
            try {
                dp[n] += dp[n - 2];
            } catch (Exception e) {}
            try {
                dp[n] += dp[n - 3];
            } catch (Exception e) {}
        }
        
        System.out.println(dp[dp.length - 1]);
	}
}
