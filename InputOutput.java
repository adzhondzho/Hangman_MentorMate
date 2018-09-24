package hangman_MentorMate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class InputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String h = "TemaAboutHangman.txt";
		Scanner c = null;
		Scanner e = null;
		Scanner q = null;
		Scanner z = null;
		ArrayList<String> t = new ArrayList<String>();
		ArrayList<String> y = new ArrayList<String>();
		char[] g;
		try {
			File b = new File(h);
			c = new Scanner(b);
			while (c.hasNextLine()) {
				String d = c.nextLine();
				System.out.printf("%s %n", d);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.print("File " + h + " not found");
		} catch (NullPointerException npe) {
			System.out.print("File " + h + " does not exist");
		} finally {
			if (c != null) {
				c.close();
			}
		}
		try {
			File r = new File(h);
			e = new Scanner(r);
			while (e.hasNextLine()) {
				String kp = e.nextLine();
				g = kp.toCharArray();
				if (g[0] == '_') {
					t.add(kp);
				}
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < t.size(); i++) {
				System.out.print(t.get(i) + " ");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.print("File " + h + " not found");
		} catch (NullPointerException npe) {
			System.out.print("File " + h + " does not exist");
		} finally {
			if (e != null) {
				e.close();
			}
		}
		int attempt = 10, count = 0, score = 0;
		z = new Scanner(System.in);
		System.out.print("Please choose a category: ");
		for (int i = 0; i < t.size(); i++) {
			System.out.print(t.get(i) + " ");
		}
		String d = z.next();
		try {
			File o = new File(h);
			q = new Scanner(o);
			System.out.println();
			String l;
			char[] a;
			boolean hasFoundCategory = false;
			while (q.hasNextLine()) {
				l = q.nextLine();
				a = l.toCharArray();
				if (a[0] == '_' && hasFoundCategory) {
					break;
				}
				if (hasFoundCategory) {
					y.add(l);
				}
				if (l.equals(d)) {
					hasFoundCategory = true;
				}
			}
			for (int i = 0; i < y.size(); i++) {
				System.out.println(y.get(i));
			}
		} catch (FileNotFoundException fnfe) {
			System.out.print("File " + h + " not found");
		} catch (NullPointerException npe) {
			System.out.print("File " + h + " does not exist");
		} finally {
			if (q != null) {
				q.close();
			}
		}
		boolean rt = true;
		Random r = new Random();
		int mn = r.nextInt(y.size());
		System.out.println(mn);
		String tr = y.get(mn);
		System.out.print(tr);
		System.out.println();
		char[] gg = tr.toCharArray();
		char[] k = new char[gg.length];
		for (int i = 0; i < k.length; i++) {
			k[i] = '_';
		}
		System.out.print("Attempts left: " + attempt);
		System.out.println();
		System.out.print("Current word/phrase: ");
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i] + " ");
		}
		System.out.println();
		while (attempt > 0) {
			try {
				char u;

				do {
					System.out.print("Enter a letter ");
					System.out.println();
					System.out.print("> ");
					u = z.next().charAt(0);
				} while ((u < 'A' || u > 'Z') && (u < 'a' || u > 'z'));

				int i = 0;
				boolean p = false;
				for (i = 0; i < gg.length; i++) {
					if (gg[i] == u) {
						k[i] = u;
					}
					p = p || (gg[i] == u);
				}

				if (p == false) {
					System.out.print("This word/phrase does not have this letter.  ");
					attempt--;
				}
				System.out.println();
				int j = 0;

				for (j = 0; j < k.length; j++) {
					System.out.print(k[j] + " ");
				}
				System.out.print("Attempts left: " + attempt);
				System.out.println();
				System.out.print("Current word/phrase: ");
				for (i = 0; i < k.length; i++) {
					System.out.print(k[i] + " ");
				}
				System.out.println();
				int cnt = 0;
				if (attempt == 0) {
					System.out.print("Game over ");
					System.out.println();
					count++;
				} else {
					for (j = 0; j < k.length; j++) {
						if (k[j] == '_') {
							cnt++;
						}
					}
					if (cnt == 0) {
						System.out.print("Congratulations you have revealed the word/phrase: ");
						System.out.println();
						score++;
						System.out.print("Current score: ");
						System.out.print(score);
						System.out.println();
						for (i = 0; i < k.length; i++) {
							System.out.print(k[i] + " ");
						}
						System.out.println();
						System.out.print("Choose a category from: ");
						for (i = 0; i < t.size(); i++) {
							System.out.print(t.get(i) + " ");
						}
						d = z.next();

						rt = true;
						r = new Random();
						mn = r.nextInt(y.size());
						tr = y.get(mn);
						gg = tr.toCharArray();
						k = new char[gg.length];
						for (i = 0; i < k.length; i++) {
							k[i] = '_';
						}
						for (i = 0; i < k.length; i++) {
							System.out.print(k[i] + " ");
						}
					}
				}
			} catch (NullPointerException npe) {
				System.out.print("File " + h + " does not exist");
			}
		}

		System.out.println();

	}

}
