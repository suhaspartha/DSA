import java.util.Arrays;

public class MinRewards {
	public static void main(String[] args) {
		int[] array = new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 };
		System.out.println(minRewards(array));
	}

	public static int minRewards(int[] scores) {
		int len = scores.length;
		if (len == 1)
			return 1;
		int[] rewards = new int[len];
		Arrays.fill(rewards, 1);
		for (int i = 1; i < len; i++) {
			if (scores[i] > scores[i - 1]) {
				rewards[i] = rewards[i - 1] + 1;
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			if (scores[i] > scores[i + 1]) {
				rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
			}
		}
		return Arrays.stream(rewards).map(Integer::valueOf).sum();
	}
}