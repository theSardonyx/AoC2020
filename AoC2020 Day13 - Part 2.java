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
		in.nextLine();
		String[] ids = in.nextLine().split(",");
		List<Long> buses = new ArrayList<Long>();
		List<Long> diff = new ArrayList<Long>();
		for (int i = 0; i < ids.length; i++) {
		    if (!ids[i].equals("x")) {
		        long curr = Long.parseLong(ids[i]);
		        buses.add(curr);
		        diff.add(curr - i);
		    }
		}
		long t = crt(buses, diff);
		System.out.println(t);
	}
	
	public static long crt(List<Long> n, List<Long> a) {
 
        long prod = n.stream().reduce((long) 1, (i, j) -> i * j);
 
        long p, sm = 0;
        for (int i = 0; i < n.size(); i++) {
            p = prod / n.get(i);
            sm += a.get(i) * mulInv(p, n.get(i)) * p;
        }
        return sm % prod;
    }
	
	private static long mulInv(long a, long b) {
        long b0 = b;
        long x0 = 0;
        long x1 = 1;
 
        if (b == 1)
            return 1;
 
        while (a > 1) {
            long q = a / b;
            long amb = a % b;
            a = b;
            b = amb;
            long xqx = x1 - q * x0;
            x1 = x0;
            x0 = xqx;
        }
 
        if (x1 < 0)
            x1 += b0;
 
        return x1;
    }
}
