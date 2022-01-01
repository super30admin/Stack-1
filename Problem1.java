//Time: O(n)
//Space: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> days = new Stack<>();
        Stack<Integer> temps = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i=temperatures.length-1;i>=0;i--){
            if(temps.isEmpty()){
                days.push(i);
                temps.push(temperatures[i]);
                result[i] = 0;
            }
            else if(temperatures[i]<temps.peek()){
                result[i] = days.peek()-i;
                days.push(i);
                temps.push(temperatures[i]);
            }
            else{
                temps.pop();
                days.pop();
                i++;
            }
        }

        return result;
    }
}