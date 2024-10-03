// Bruteforce Solution
// TC: O(n2)
// SC: O(1)
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int i = 0; i<temperatures.length;i++) {
            for(int j = i+1;j<temperatures.length;j++){
                if(temperatures[j] > temperatures[i]) {
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}


// Push the elements to stack and resolve then whenever you get a greater element
// TC - O(n)
// SC - O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int popped = stack.pop();
                answer[popped] = i - popped;
            }
            stack.push(i);
        }
        return answer;
    }
}