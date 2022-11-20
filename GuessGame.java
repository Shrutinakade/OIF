import java.lang.Math;
import java.util.*;

class GuessGame {
	public static void main(String st[]) {
		int min = 1;
		int max = 100;
		int range = max - min + 1;
		int u;

		int n = (int) (Math.random() * range) + min;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your guess number :");

		u = sc.nextInt();

		do {
			if (u > n) {
				System.out.println("Enter lower number");
			} else {
				System.out.println("Enter higher number");
			}

			u = sc.nextInt();
			if (u == n) {
				System.out.println(" Congraulations!!!!!!!!!!! its right " + u);
			}

		} while (u != n);

	}
}
