//Daily Temperatures
// Time Complexity : O(2n)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Stack solution 
// Whenever prev indexed temperature is less than next indexed temp then subtract prev index and next index and store it in result
//push all index to stack and then return result.