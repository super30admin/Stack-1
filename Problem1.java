//Brute Force
//TC - O(n^2)
//SC - O(1)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int count=0;
        for(int i =0;i<T.length;i++)
        {
            for(int j=i+1;j<T.length;j++)
            {
                if(T[j]>T[i])
                {
                    result[i] = count+1;
                    count=0;
                    break;
                }
                else
                {
                    count++;
                    result[i]=0;
                }  
            }
            count=0;
        }
        result[T.length-1]=0;
        return result;
    }
}


//Brute Force with HashMap
//TC - O(n^2)
//SC - O(n)

class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int[] dailyTemperatures(int[] T) {
        //out list
        int[] res = new int[T.length];
        
        //edge case
        if(T == null || T.length == 0) return res;
        
        map.put(T[T.length-1], T.length-1);
        
        for(int i = T.length - 2; i >= 0 ; --i)
        {
            int val = T[i];

            int findIdx = -1;
            int minndiff = Integer.MAX_VALUE;
            
            for(int key : map.keySet())
            {
                if(key > val && (map.get(key) - i) < minndiff)
                {
                    findIdx = map.get(key);
                    minndiff = map.get(key) - i;
                }
            }
            
            if(findIdx != -1)
                res[i] = findIdx - i;
            
            map.put(T[i], i);
        }
        
        return res;
    }
}


//Optimal with Stack
//TC - O(n)
//SC - O(n)

class Solution {
    class Pair{
        int idx;
        int val;
        
        Pair(int i, int v)
        {
            this.idx = i;
            this.val = v;
        }
    }
    public int[] dailyTemperatures(int[] T) {
        //out list
        int[] res = new int[T.length];
        
        //edge case
        if(T == null || T.length == 0) return res;
        
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(0, T[0]));
            
        for(int i = 1; i < T.length; ++i)
        {
            Pair prev = stk.peek();
            
            if(T[i] > prev.val)
            {
                while(!stk.isEmpty() && T[i] > stk.peek().val)
                {
                    int id = stk.pop().idx;
                    res[id] = i - id;
                }
            }
            
            stk.push(new Pair(i, T[i]));
        }
        
        return res;
    }
}
