// https://leetcode.com/problems/single-number/
/**
 * @param {number[]} nums
 * @return {number}
 */

// Sorts the array (asending order) and compare one by one. 
// If the two numbers before and after are equal, skip these two and
// continue comparing until the one that is not equal is found.
var singleNumber = function(nums) {
    nums.sort(); 
    for(let i = 0; i < nums.length; i++){
        if(nums[i] === nums[i+1]){
            i++;
        }
        else {
            return nums[i];
        }
    }
};

var singleNumber1 = function(nums) {
    map={}; 
    for(i = 0; i< nums.length; i++){
        if(map[nums[i]]){
            delete map[nums[i]]; 
        }
        else {
            map[nums[i]] =1; 
        }
    }
    return parseInt(Object.keys(map)[0]); 
};


//converting the set it to an array with Array.from() and getting the [0] element
var singleNumber2 = function(nums) {
    let map = new Set();

    nums.forEach(number => {
      if (!map.has(number)) {
            map.add(number);
      } else {
             map.delete(number);
      }
    });
    return Array.from(map)[0];
  };

  console.log(singleNumber([4,1,2,1,2]))
  console.log(singleNumber1([4,1,2,1,2]))
  console.log(singleNumber2([4,1,2,1,2]))

