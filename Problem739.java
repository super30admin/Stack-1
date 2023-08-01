package problems.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

//TC=O(2n)=O(n)
//SC=O(n)
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int[] result=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty() && temperatures[i]>temperatures[stk.peek()]){
                int popped=stk.pop();
                result[popped]=i-popped;
            }
            stk.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Problem739 problem739=new Problem739();
        System.out.println(Arrays.toString(problem739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
