// O(N), O(N)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return new int[]{};
        }
        Stack<Integer> s = new Stack<>();
        int[] result = new int[T.length];
        List<Integer> res = new ArrayList<>();
        for(int i=T.length-1;i>=0;i--) {
            if(s.isEmpty()) {
                    res.add(0);
            }
            else if(T[i]<T[s.peek()]){
                res.add(s.peek()-i);
            }
            else if(T[i]>=T[s.peek()]) {
                while(!s.isEmpty()&&T[i]>=T[s.peek()]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    res.add(0);
                }
                else {
                    res.add(s.peek()-i);
                }
            }
            s.push(i);
        }
        for(int i=res.size()-1;i>=0;i--) {
            result[res.size()-1-i]=res.get(i);
        }
        return result;
    }
}
