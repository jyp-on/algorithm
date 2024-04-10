import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			char x = sc.next().charAt(0);
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		char target = sc.next().charAt(0);
		System.out.print(map.getOrDefault(target, 0));
	}
}