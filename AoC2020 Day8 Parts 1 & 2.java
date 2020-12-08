/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    public static List<String> inst;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		inst = new ArrayList<String>();
		while (in.hasNext()) {
		    inst.add(in.nextLine());
		}
		
		int[] ans = execute();
		System.out.println(ans[1]);
		
		for (int pos = 0; pos < inst.size(); pos++) {
		    String s = inst.get(pos);
		    switch (s.substring(0, 3)) {
		        case "acc": break;
		        case "nop": 
		            inst.set(pos, "jmp " + s.substring(4));
		            break;
		        case "jmp": inst.set(pos, "nop " + s.substring(4));
		    }
		    ans = execute();
		    if (ans[0] == 0) break;
		    inst.set(pos, s);
		}
		
		System.out.println(ans[1]);
	}
	
	public static int[] execute() {
	    int acc = 0, pos = 0;
	    boolean[] isDone = new boolean[inst.size()];
	    int[] retVal = {0, acc};
	    while (pos < inst.size()) {
	        String s = inst.get(pos);
	        int num = Integer.parseInt(s.substring(4));
	        if (isDone[pos]) {
	            retVal[0] = 1; //means there's a loop
	            retVal[1] = acc;
	            return retVal;
	        }
	        isDone[pos] = true;
	        switch (s.substring(0, 3)) {
		        case "nop":
		            pos++;
		            break;
		        case "acc": 
		            acc += num;
		            pos++;
		            break;
		        case "jmp": pos += num;
		    }
	    }
	    retVal[1] = acc;
	    return retVal;
	}
}
