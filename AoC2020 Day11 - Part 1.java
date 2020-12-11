/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main
{
    static List<int[]> prev;
    static List<int[]> seats;
    
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		prev = new ArrayList<int[]>();
		String curr = "";
		while ((curr = in.readLine()) != null) {
		    int[] line = new int[curr.length()];
		    for (int i = 0; i < curr.length(); i++) {
		        switch (curr.charAt(i)) {
		            case 'L': line[i] = 1; break;
		            case '.': line[i] = 0; break;
		            case '#': line[i] = 2;
		        }
		    }
		    prev.add(line);
		}
		int[] ans = iterate();
		while (ans[0] != 0) ans = iterate();
		System.out.println(ans[1]);
	}
	
	public static int[] iterate() {
	    seats = new ArrayList<int[]>();
	    for (int[] list : prev) seats.add(list.clone());
	    
	    int[] ret = {0, 0};
	    for (int i = 0; i < seats.size(); i++) {
	        for (int j = 0; j < seats.get(i).length; j++) {
	            if (prev.get(i)[j] == 0) { //floor
	                continue;
	            } else { //seat
	                int adj = 0;
	                for (int k = i - 1; k <= i + 1; k++) {
	                    for (int l = j - 1; l <= j + 1; l++) {
	                        if (k == i && l == j) continue;
	                        try {
	                            if (prev.get(k)[l] == 2) //occupied
    	                            adj++;
    	                    } catch (Exception e) {}
	                    }
	                }
	                if (prev.get(i)[j] == 1 && adj == 0) {
	                    seats.get(i)[j]++;
	                    ret[0]++;
	                    ret[1]++;
	                } else if (prev.get(i)[j] == 2 && adj >= 4) {
	                    seats.get(i)[j]--;
	                    ret[0]++;
	                } else if (prev.get(i)[j] == 2) ret[1]++;
	            }
	        }
	    }
	    prev = new ArrayList<int[]>();
	    for (int[] list : seats) prev.add(list.clone());
	    seats.clear();
	    return ret;
	}
}
