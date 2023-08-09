import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;
public class NextGreaterElementCircularArrayMonotonicStack {

        // Monotonic decreasing stack (of indices) for next greater element - Time O(n) and Space O(n)

        public int[] nextGreaterElements(int[] nums) {

            int n = nums.length;
            int[] result = new int[n];

            // default result array is -1
            Arrays.fill(result, -1);

            Stack<Integer> st = new Stack<>();    // O(n) space

            // iterate over nums array twice
            for(int i = 0; i < 2*n; i++) {        // O(n)

                //System.out.println(i);

                // if element at effective index is greater than top index in stack, pop out top index and update result at that index
                while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {

                    int popIdx = st.pop();

                    result[popIdx] = nums[i%n];
                }

                // push elements into stack only once
                if(i < n) {

                    st.push(i);
                }

                // index of the largest element remains in the stack to the last,
                // and if that index is reached again during circular rotation,
                // we can stop as other next indices are already processed with greater element in result array
                if(i > n && i%n == st.peek()) {

                    break;
                }
            }
            // output
            return result;
        }

        public static void main(String[] args) {

            NextGreaterElementCircularArrayMonotonicStack obj =
                    new NextGreaterElementCircularArrayMonotonicStack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("nums array length: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];

            System.out.println("nums array: ");
            for(int i = 0; i < n; i++) {

                nums[i] = scanner.nextInt();
            }

            int[] answer = obj.nextGreaterElements(nums);

            System.out.println("Next greater array for circular nums array: ");

            for(int i = 0; i < n; i++) {

                System.out.print(answer[i] + " ");
            }
        }

}

/*

Monotonic decreasing stack (of indices) for next greater element

TIME COMPLEXITY = O(n)

Circular iteration - O(n)

SPACE COMPLEXITY = O(n)

Stack space - O(n)
*/
