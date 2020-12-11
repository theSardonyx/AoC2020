/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
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
	                boolean[] adjacency = new boolean[8];
	                boolean[] seen = new boolean[4];
	                for (int k = 0; k < seats.size(); k++) {
	                    for (int l = 0; l < seats.get(i).length; l++) {
	                        if (k == i && l == j) continue;
	                        if ((k - i) == (l - j)) { //diagonal to current seat like this \
	                            if (k < i) {
	                                if (prev.get(k)[l] > 0)
	                                    adjacency[0] = (prev.get(k)[l] == 2);
	                            } else {
	                                if (!seen[0] && prev.get(k)[l] > 0) {
	                                    adjacency[4] = (prev.get(k)[l] == 2);
	                                    seen[0] = !seen[0];
	                                }
	                            }
	                        } else if (Math.abs(k - i) == Math.abs(l - j)) { //diagonal to current seat like this /
	                            if (k < i) {
	                                if (prev.get(k)[l] > 0)
	                                    adjacency[2] = (prev.get(k)[l] == 2);
	                            } else {
	                                if (!seen[1] && prev.get(k)[l] > 0) {
	                                    adjacency[6] = (prev.get(k)[l] == 2);
	                                    seen[1] = !seen[1];
	                                }
	                            }
	                        }
	                        if (k == i) { //horizontal
	                            if (l < j) {
	                                if (prev.get(k)[l] > 0)
	                                    adjacency[7] = (prev.get(k)[l] == 2);
	                            } else {
	                                if (!seen[2] && prev.get(k)[l] > 0) {
	                                    adjacency[3] = (prev.get(k)[l] == 2);
	                                    seen[2] = !seen[2];
	                                }
	                            }
	                        }
	                        if (l == j) { //vertical
	                            if (k < i) {
	                                if (prev.get(k)[l] > 0)
	                                    adjacency[1] = (prev.get(k)[l] == 2);
	                            } else {
	                                if (!seen[3] && prev.get(k)[l] > 0) {
	                                    adjacency[5] = (prev.get(k)[l] == 2);
	                                    seen[3] = !seen[3];
	                                }
	                            }
	                        }
	                    }
	                }
	                for (boolean b : adjacency) if (b) adj++;
	                
	                if (prev.get(i)[j] == 1 && adj == 0) {
	                    seats.get(i)[j]++;
	                    ret[0]++;
	                    ret[1]++;
	                } else if (prev.get(i)[j] == 2 && adj >= 5) {
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
