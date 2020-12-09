/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static int[] fenwick;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> all = new ArrayList<Integer>();
		int pre = 25;
		int nums = 0;
		int weak = -1;
		while (in.hasNext()) {
		    int curr = in.nextInt();
		    if (nums < pre) {
		        list.add(curr);
		        all.add(curr);
		        nums++;
		        continue;
		    }
		    all.add(curr);
		    boolean valid = false;
		    for (Integer i : list) {
		        if (list.contains(curr - i)) {
		            valid = true;
		            break;
		        }
		    }
		    if (!valid) {
		        System.out.println(curr);
		        weak = curr;
		        all.remove(all.size() - 1);
		        break;
		    } else {
		        list.remove(0);
		        list.add(curr);
		    }
		}
		
		constructFenwick(all.stream().mapToInt(Integer::intValue).toArray(), all.size());
		for (int i = 0; i < all.size(); i++) {
		    for (int j = 0; j < all.size(); j++) {
		        if (getRangeSum(i, j) == weak) {
		            int sum = Collections.max(all.subList(i,j + 1)) + Collections.min(all.subList(i,j + 1));
		            System.out.println(sum);
		        }
		    }
		}
	}
	
	public static int getSum(int i) 
    { 
        int sum = 0;
        i++; 
        while(i > 0) { 
            sum += fenwick[i]; 
            i -= i & (-i); 
        } 
        return sum; 
    }
    
    public static int getRangeSum(int a, int b) {
        return getSum(b) - getSum(a - 1);
    }
    
    public static void updateFenwick(int n, int i, int val) 
    { 
        i++; 
        while(i <= n) {
            fenwick[i] += val;
            i += i & (-i); 
        }
    }
    
    public static void constructFenwick(int arr[], int n) 
    {
        fenwick = new int[n + 1];
        for(int i = 0; i < n; i++) 
            updateFenwick(n, i, arr[i]); 
    }
}
