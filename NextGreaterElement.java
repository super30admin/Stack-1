// Time Complexity: O(2n) -> O(n)
// Space Complexity: O(2n) -> O(n)
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length ==2)
            return nums1;
    
        Stack<Integer> st = new Stack<>(); // contains the no
        Map<Integer, Integer> map = new HashMap<>(); // stores the next greater element value for each num
        // next greater for nums2
        for(int i = 0 ; i < nums2.length; i++)
        {
            while(!st.isEmpty() && st.peek() < nums2[i])
            {
                map.put(st.pop(), nums2[i]);
            }   
            st.push(nums2[i]);
        }
        
        for(int i = 0 ; i < nums1.length; i ++)
        {
            int val = map.getOrDefault(nums1[i], -1);
            nums1[i] = val;
        }
        
        return nums1;
    }
}
