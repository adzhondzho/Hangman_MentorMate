//zadthat check if a symbol is in ArrayList
package hangman_MentorMate;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner z = new Scanner(System.in);
		char c;

		ArrayList d = new ArrayList();
		d.add('b');
		d.add('v');
		d.add('a');
		d.add('n');

		//for (int i = 0; i < d.size(); i++) {
		//	System.out.print(d.get(i) + " ");
		//}
		System.out.println();
		int attempt = 10;
		boolean p = false;
		while(attempt > 0)
		{
			do {
				System.out.print("Enter a letter ");
				c = z.next().charAt(0);
			} while ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'));
			int  i = 0;
			for (i = 0; i < d.size(); i++) {
				//System.out.print(d.get(i) + " ");
				//System.out.print(c + " ");
				if (d.get(i).equals(c)) {
					System.out.print(d.get(i) + " ");
					p = true;
					break;
				} else {
					p = false;
				}
			}
			if(p == false)
			{
				attempt--;
			}
			//System.out.print(p);
			System.out.println();
			System.out.print(attempt);
			System.out.println();
		}
	
	}

}
