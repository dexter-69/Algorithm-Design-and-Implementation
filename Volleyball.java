import java.util.Scanner;


public class Solution {

	public static final long MOD = 1000000007;
	
	static long pow(long a, long n) {
		long res = 1;
		while(n > 0) {
			if (n % 2 == 1) res = res * a % MOD;
			a = a * a % MOD;
			n /= 2;
		}
		return res;
	}
	
	static long f[];
	
	static long inv(long n) {
		return pow(n, MOD - 2);
	}
	static long choose(long n, long k) {
		return f[(int)n] * inv(f[(int)k]) % MOD * inv(f[(int)(n - k)]) % MOD;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
	
		f = new long[50];
		f[0] = 1;
		for (int i=1; i<f.length; i++)
			f[i] = f[i - 1] * i % MOD;
		
		long a = cin.nextLong();
		long b = cin.nextLong();
		if (a < b) {
			long c = a; 
			a = b;
			b = c;
		}
		
		if (Math.max(a, b) < 25) System.out.println(0);
		else if (a == 25) {
			if (b >= 24) System.out.println(0);
			else System.out.println(choose(a - 1 + b, b));
		} else {
			if (b != a - 2) System.out.println(0);
			else {
				long res = choose(48, 24);
				res = res * pow(2, a - 24 - 2) % MOD;
				System.out.println(res);
			}
		}
		
		cin.close();
	}

}
