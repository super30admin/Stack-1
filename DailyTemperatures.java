
// Time Complexity: O(n) where n is the number of days in the temperatures array.
// Space Complexity: O(n) for the result array that stores the number of days until a warmer temperature.

// Intuition: The problem is to find the number of days until a warmer temperature for each day in the temperatures array.
// We can achieve this by using a two-pointer approach where we maintain a slow pointer for the current day
// and a fast pointer to find the next warmer temperature.
// We iterate through the temperatures array and for each day, we check if the temperature on the next day is warmer.
// If it is, we calculate the difference in days and store it in the result array.
// If the next day is not warmer, we keep incrementing the fast pointer until we find a warmer temperature or reach the end of the array.
// The result array will contain the number of days until a warmer temperature for each day in the temperatures array.

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        int slow = 0;
        int fast = 1;
        for (; slow < temperatures.length - 1; slow++) {
            fast = slow + 1;

            // keep incrementing fast pointer until the value at fast is greater than value
            // at slow
            if (temperatures[fast] <= temperatures[slow]) {
                while (temperatures[fast] <= temperatures[slow] && fast < temperatures.length - 1) {
                    fast++;
                    // break when that happens
                    if (temperatures[slow] < temperatures[fast]) {
                        result[slow] = fast - slow;
                        break;
                    }
                }
            } else // usually when thats not the case, keep adding value in result
                result[slow] = fast - slow;
        }
        return result;
    }
}