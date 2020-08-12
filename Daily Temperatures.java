//Timr Complexity: O(n) where n is the num of elements
//Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {

        if(T == null || T.length == 0) return new int [0];

        int[] result = new int[T.length];

        Stack<Integer> s = new Stack();

        for(int i=0; i< T.length; i++){

            while(!s.isEmpty() && T[i] > T[s.peek()]){ // seeing if the current day is warmer than the previous day
                int index = s.pop(); // taking out the element of the previous day
                result[index] = i - index; // prev day - current warmern than prev day
            }

            s.push(i); // the current unresolved day
        } 

        return result;

    }
}