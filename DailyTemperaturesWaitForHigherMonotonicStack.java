import java.util.Stack;
import java.util.Scanner;

public class DailyTemperaturesWaitForHigherMonotonicStack {

        // Monotonic increasing/ decreasing stack - Time O(n) and Space O(n)

        public int[] dailyTemperatures(int[] temperatures) {

            Stack<Integer> stackIdx = new Stack<>();     // O(n) space

            int tl = temperatures.length;

            int[] answer = new int[tl];

            // iterate over temperatures
            for(int i = 0; i < tl; i++) {       // O(n)

                // if top element in stack is less than current temperature, answer for top element is found and hence is removed from stack
                while(!stackIdx.isEmpty() && temperatures[stackIdx.peek()] < temperatures[i]) {

                    // stack is monotonically decreasing from the bottom, so just check the top stack value with current temperature and then go to next
                    int popIdx = stackIdx.pop();

                    // number of wait days is the difference in indices
                    answer[popIdx] = i - popIdx;

                }

                // once temperature is checked with stack peek (top) values, push current temperature into stack
                stackIdx.push(i);
            }

            // last element will be zero by default
            return answer;
        }

        public static void main(String[] args) {

            DailyTemperaturesWaitForHigherMonotonicStack obj = new DailyTemperaturesWaitForHigherMonotonicStack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Temperatures array length: ");
            int t = scanner.nextInt();

            int[] temperatures = new int[t];

            System.out.println("Temperatures array: ");
            for(int i = 0; i < t; i++) {

                temperatures[i] = scanner.nextInt();
            }

            int[] answer = obj.dailyTemperatures(temperatures);

            System.out.println("Wait period array for warmer day: ");

            for(int i = 0; i < t; i++) {

                System.out.print(answer[i] + " ");
            }
        }



}

/*
Monotonically increasing/ decreasing stack

TIME COMPLEXITY = O(n)

worst case = O(2n) = each element (except the last) visited twice in case of descending order till the last but element and the last being the highest element

0(n) [Iterate the temperature array] + 0(n) [Iterate the stack (Worst Case)]

SPACE COMPLEXITY = O(n)

Stack space will be O(n) = O(n-1) = worst case mentioned above, all elements except the last go in stack

Brute Force way = O(n*n) = check each next element until higher element is found
*/