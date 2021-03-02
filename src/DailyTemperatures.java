import java.util.Stack;

/*
 * The Time complexity of the algorithm is O(n) where n is no of elements.
 * The Space complexity of the algorithm is O(n) where n is no of elements.
 */

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {

		int[] result = new int[T.length];

		if (T.length == 0 || T == null)
			return result;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < T.length; i++) {

			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {

				int idx = stack.pop();
				result[idx] = i - idx;

			}

			stack.push(i);

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
