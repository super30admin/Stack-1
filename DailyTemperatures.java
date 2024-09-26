// idea: 
// a) As we iterate through the array, we push the element's index onto a stack 
// b) meanwhile we check whether the array element is greater than last pushed element on to the stack
// c) When we find the array element is greater than the last pushed element, we pop out the element, 
// d) The next high temperature of the popped element is the difference between the element's index and the current element's index in array iteration
// e) we repeat the iteration until we find there is no element in stack whose temperature is less than the current element.
// Time complexity: o(n)
// space complexity: o(n)

// did it run on leetcode: yes


class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<T.length;i++) {
            while (!s.isEmpty() && T[i]> T[s.peek()]) {
                int j = s.pop();
                res[j] = i - j;
            }
            s.push(i);
        }
        return res;
    }
}


