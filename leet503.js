TC - O(N)
SC - O(N)

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {
     var st=new Array(nums.length).fill(-1);
    var arr=[];
    var i=0;
    for(var i=0;i<2*nums.length;i++)
    {
      while(arr.length>0 && nums[i%nums.length]>nums[arr[arr.length-1]]){
          st[arr.pop()]=nums[i%nums.length];
      }
      arr.push(i%nums.length);
    }
    
    return st;
};