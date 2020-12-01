import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> input = new ArrayList<Integer>();
		while (in.hasNextInt()) {
		    input.add(in.nextInt());
		}
		boolean found = false;
		while (!found) {
		    int num = 2020 - input.get(0);
		    /* For finding 2 nums
		    found = input.contains(num);
		    if (found) {
		       System.out.println(input.get(0) * num);
		       break;
		    } else {
		        input.remove(input.get(0));
		    } */
		    
		    // For finding 3 nums
		    for (int i = 1; i < input.size(); i++) {
		        int num2 = num - input.get(i);
		        found = input.contains(num2);
		        if (found) {
		            System.out.printf("%d, %d, %d, ", input.get(0), num - num2, num2);
		            System.out.println(input.get(0) * (num - num2) * num2);
		            break;
		        }
		    }
		    if (found) break;
		    else input.remove(input.get(0));
		}
	}
}
