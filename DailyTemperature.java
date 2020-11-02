import java.util.*;
/*
Approach 1: Brute Force - Two for loops;
TC: O(N^2) ; N - length of array
SC: O(1)

Approach 2: Using Stacks

TC: O(N) N - length of array
SC: O(N)

1. Keep a stack of indices.
2. If current element is lesser than previously seen elements, store the index in stack. 
3. When we encounter elements greater than previously seen, store the difference in indices in result array. 

Approach 3: Using stack reverse

TC: O(N)
SC: O(W) W - allowed values for temperature

1. Iterate the array from reverse.
2. Pop the indices from stack if current element is greater than all elements ahead in the array.
3. Push the index into stack.


*/

public class DailyTemperature {

    public int[] dailyTemperaturesBF(int[] T) {
        
        if(T == null || T.length == 0) return T;
        int[] result = new int[T.length];
        for(int i = 0 ; i < T.length - 1 ; i++){
            for(int j = i + 1; j < T.length; j++){
                //System.out.println("i: "+i+" j: "+j);
                if(T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }  
            }
        }
        result[T.length - 1] = 0;
        return result;
    }

    public int[] usingStack1(int[] T){
        if(T == null || T.length == 0) return new int[0];
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++){
                while(!stk.isEmpty() && T[i] > T[stk.peek()]){
                    int idx = stk.pop();
                    res[idx] = i - idx;
                }
            stk.push(i);
        }
        return res;
    }


    public int[] usingStack2(int[] T){
        if(T == null || T.length == 0) return new int[0];
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[T.length];

        for(int i = T.length - 1; i >= 0; i--){
            while(!stk.isEmpty() && T[i] >= T[stk.peek()]){
                stk.pop();
            }
            if(!stk.isEmpty()) res[i] = stk.peek() - i;
            stk.push(i);
        }
        return res;
    }


    public static void main(String[] args){
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dt = new DailyTemperature();

        int[] res = dt.dailyTemperaturesBF(temp);
        for(int num : res){
            System.out.print(num + " ");
        }
        System.out.println();
        int res1[] = dt.usingStack1(temp);
        for(int num : res1){
            System.out.print(num + " ");
        }
        
        System.out.println();
        int res2[] = dt.usingStack2(temp);
        for(int num : res2){
            System.out.print(num + " ");
        }
    }
}
