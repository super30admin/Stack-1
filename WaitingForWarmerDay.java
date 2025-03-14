//Time Complexity - O(n)
//Space Complexity - O(1)
class WaitingForWarmerDay {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[] {};
        }

        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = 0; i<temperatures.length; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int popped = s.pop();
                result[popped] = i - popped;
            }
            s.push(i);
        }
        return result;
    }
}
