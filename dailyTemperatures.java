// TC: O(n*m) where n is the time to traverse whole array and m is the distance between the 2 elements
// SC: O(n)

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] x = new int[T.length];
//         int index = 0, count = 0;
        
//         boolean flag = false;
//         for(int i=0; i<T.length; i++){
//             index = i;
//             int val = T[i];
//             Stack<Integer> s = new Stack<Integer>();
                
//             while(index < T.length){   
//                 s.push(T[index]);
//                 if(s.peek() > val){
//                     count = s.size()-1;
//                     T[i] = count;
//                     flag = true;
//                     break;
//                 }                
//                 index++;
//             }
//             if(!flag){
//                 T[i] = 0;
//             }
//             flag = false;
//         }
        Stack<Integer> stack = new Stack();
        
        for (int i = T.length - 1; i >= 0; --i) {
            // Checking if stack is not empty and the ith element is greater than or equal to the topmost element
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) 
                stack.pop();
            // By the above we pop all the stack elements are lesser than the current element by which we get empty stack of element index that is greater than the current element index
            x[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // push the indexes to the stack
            stack.push(i);
        }
        return x;
    }

}