import java.util.Stack;

public class DailyTemperature {
	public int[] dailyTemperatures(int[] T) {

		int[] result = new int[T.length];

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < T.length; i++) {

			while (!st.isEmpty() && T[st.peek()] < T[i]) {
				int index = st.pop();
				result[index] = i - index;
			}
			st.push(i);

		}
		return result;
	}

	public static void main(String[] args) {
		DailyTemperature dt = new DailyTemperature();

		dt.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
	}
}
