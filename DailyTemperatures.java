import java.util.Stack;

/*
For Brute force:

Time complexity:  method dailyTemperatures: O(n^2)
Space complexity: O(1) No auxilary space used to compute, res is a the result so not counted

Optimal using stack:
Time complexity: dailyTemperaturesOptimal: O(n) loop through array in one go and build using for loop, so at the max O(n) stack size
Sapce complexity: Worst case space could go O(n); i.e descending elements are in array so stack will have all indices 
*/
class DailyTemperatures{
    //Brute force
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
         for(int i = 0; i < temperatures.length; i++){
             for(int j = i+1; j < temperatures.length; j++){
                 if(temperatures[j] > temperatures[i]){
                     res[i] = j-i;
                     break;
                 }
             }
         }
         return res;
     }

    public static int[] dailyTemperaturesOptimal(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] temp = new int[]{73,74,75,71,69,72,76,73};
        temp = dailyTemperaturesOptimal(temp);
        for(int i : temp) System.out.println(" "+i);
    } 
}