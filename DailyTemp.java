class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] answers = new int[n];
        Stack<Integer> q = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            int temp = temperatures[i];
            while(!q.isEmpty() && temp > temperatures[q.peek()]){
                int idx = q.pop();
                answers[idx] = i - idx;
            }
            q.push(i);
            
        }

        return answers;

    }
}