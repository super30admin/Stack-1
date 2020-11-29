class Solution {//Time and space of O(n)
    public int[] dailyTemperatures(int[] T) {
        //Base case 
        if(T == null || T.length == 0){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        
        //Iterate throught the array
        for(int i = 0 ; i< T.length ; i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        // while(!stack.isEmpty()){
        //     result[stack.pop()] = 0;
        // }
        return result;
    }
}