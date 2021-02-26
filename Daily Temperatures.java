/*
# from left to right
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T is None or len(T) == 0:
            return []
        
        result = [0]*len(T)
        stack = []
        for i in range(len(T)):
            while len(stack) > 0 and T[i] > T[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)            
        
        return result

# from right to left
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T is None or len(T) == 0:
            return []
        
        result = [0]*len(T)
        stack = []
        stack.append(len(T)-1)
        for i in range(len(T)-2, -1, -1):
            while len(stack) > 0:
                if T[i] < T[stack[-1]]:
                    result[i] = stack[-1] - i
                    break
                stack.pop()
            stack.append(i)
        
        
        return result
*/

/*
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]  {};
        
        int[] result = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<T.length; i++){
            while (!s.isEmpty() && T[i] > T[s.peek()]){
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
        }
        return result;
    }
}
*/

// time - O(n)
// space - O(n)
// logic - started from right and checked for which index it is smaller than stack and updated it accordingly

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]  {};
        
        int[] result = new int[T.length];
        Stack<Integer> s = new Stack<>();
        s.push(T.length-1);
        for (int i=T.length-2; i >= 0; i--){
            while (!s.isEmpty()){
                if (T[i] < T[s.peek()]){
                    result[i] = s.peek() - i;
                    break;
                }
                s.pop();
            }
            s.push(i);
        }
        return result;
    }
}