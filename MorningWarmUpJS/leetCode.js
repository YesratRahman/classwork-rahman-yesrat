

  //Definition for a binary tree node.

  function TreeNode(val, left, right) {
      this.val = (val===undefined ? 0 : val)
      this.left = (left===undefined ? null : left)
      this.right = (right===undefined ? null : right)
 }
 
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
var mergeTrees = function(root1, root2) {
    // If any of the nodes is null then use the other node as the merged node
  if (root1 == null) return root2;
  if (root2 == null) return root1;

// Add the values of the current node for each step if they are not null
let newRoot = new TreeNode(root1.val + root2.val);
 
//Check the child nodes next from left to right 
newRoot.left = mergeTrees(root1.left, root2.left);
newRoot.right = mergeTrees(root1.right, root2.right);

return newRoot;
};

var mergeTrees = function(root1, root2) {
    if(root1 == null && root2 == null)
       return null;
     
     if(root2 == null)
       return new TreeNode(root1.val, mergeTrees(root1.left, null), mergeTrees(root1.right, null)); 
     
       if(root1 == null)
         return new TreeNode(root2.val, mergeTrees(root2.left, null), mergeTrees(root2.right,null));
 
         let left = mergeTrees(root1.left, root2.left);
         let right = mergeTrees(root1.right, root2.right); 
         let answer = new TreeNode(root1.val + root2.val, left, right);
         return answer; 
       
     
 };


//https://leetcode.com/problems/intersection-of-two-arrays/submissions/

var intersection = function(nums1, nums2) {
    const nums1Set = new Set(nums1);
    const nums2Set = new Set(nums2);
    let result = [];
    
    for (let value of nums1Set) {
        if (nums2Set.has(value)) {
          result.push(value)
        }
      }
    return result;
    };
    
    /**
     * @param {number[]} nums1
     * @param {number[]} nums2
     * @return {number[]}
     */
    var intersection = function(nums1, nums2) {
        let answer = []; 
        for(let num of nums1){
            if(!answer.includes(num) && nums2.includes(num)){
        answer.push(num); 
        } 
    } 
    
    return answer; 
    };
    
    //https://projecteuler.net/problem=1
    
    let projectEuler1 = function(){ 
        let answer = 0; 
        for(let x = 1; x < 1000; x++){ 
            if(x % 3 === 0 || x % 5 === 0){
                answer += x; 
            } 
        } 
        return answer; 
    }
    
    //https://projecteuler.net/problem=2
    let pe2 = function(){
        let sum = 0; 
        let a = 0; 
        let b = 1; 
        while(b <= 4000000){
            if(b % 2 === 0){
                sum += b; 
            }
            let nextB = a + b; 
            a = b; 
            b = nextB; 
        } 
        return sum; 
    } 
    
    
    
    //https://projecteuler.net/problem=4
    
    let pe4 = function(){
        let largest = -1; 
        for(let x = 100; x < 1000; x++){
            for(let y = x; y < 1000; y++){
                let product = x * y; 
                if(product > largest){
                    let reverse = reverseDigits(product); 
                    if(product === reverse) {
                        largest = product; 
                    }
                }
            }
        } return largest; 
    }
    
    
    let reverseDigits = function(toReverse){
     
      let rev = 0; 
      while(toReverse > 0){
        rev *= 10; 
        let digit = toReverse % 10; 
        toReverse = Math.trunc(toReverse/ 10); 
        rev += digit; 
      }
      return rev;
    }
    //console.log(reverseDigits(1234)); 
    console.log(pe4())
    
    
    // Different version
    let pe4 = function(){
        let largest = -1; 
        for(let x = 100; x < 1000; x++){
            for(let y = x; y < 1000; y++){
                let product = x * y; 
                if(product > largest){
                    let reverse = reverseDigits(product); 
                    if(product === reverse) {
                        largest = product; 
                    }
                }
            }
        } return largest; 
    }
    
    
    let reverseDigits = function(toReverse){
     
     let rev = 0; 
     let digits = []; 
      while(toReverse > 0){
        let digit = toReverse % 10; 
        toReverse = Math.trunc(toReverse / 10); 
        digits.push(digit);
      }
    
      for(let i = 0; i < digits.length; i++){
        rev *= 10; 
        rev += digits[i]; 
      }
      return rev;
    }
    
    console.log(pe4())
    
    
    //attempt 1:
//generate a random number (between 1023-9876)
//if it's got an repeated digits, throw it out
//and try again

const guessingGameGen = function(){
    //Math.random() will give us a random number
    //between 0 and 0.9999999...
  
    let allUnique = false;
  
    let attempt = NaN;
    let num = NaN;
  
    while( !allUnique ) {
  
      attempt = Math.trunc(Math.random() * (9877 - 1023) + 1023);
  
      const digits = [];
  
      num = attempt;
      while( attempt > 0 ){
        let digit = attempt % 10;
        attempt = Math.trunc(attempt / 10);
        digits.push( digit );
      }
  
      const betterDigits = new Set( digits );
  
      allUnique = betterDigits.size === 4;
    }
  
    return num;
    
  }
  
  const betterGGGen = function(){
  
    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  
    let answer = digits.splice( Math.trunc(Math.random() * (digits.length - 1) + 1 ), 1)[0];
  
    for( let i = 1; i < 4; i++ ){
  
      let randomIndex = Math.trunc(Math.random() * digits.length);
  
      let digit = digits.splice(randomIndex,1)[0];
      answer *= 10;
      answer += digit;
  
      //digits.splice(  )
  
  
    }
  
    return answer;
  
  }
  
  
  //https://leetcode.com/problems/minimum-area-rectangle/  
    
  var minAreaRect = function(points) {

    let minimumArea = Number.MAX_SAFE_INTEGER
      
      const str = []
      for (const point of points) {
        str.push(point.join(','))
      }
      for (let i = 0; i < points.length; i++) {
        for (let j = i + 1; j < points.length; j++) {
          const leftTop = points[i]
          const rightBottom = points[j]
          if (leftTop[0] !== rightBottom[0] && leftTop[1] !== rightBottom[1]) {
            const rightTop = rightBottom[0] + ',' + leftTop[1]
            const leftBottom = leftTop[0] + ',' + rightBottom[1]
            if (str.includes(rightTop) && str.includes(leftBottom)) {
              let area = Math.abs(leftTop[1] - rightBottom[1]) * Math.abs(leftTop[0] - rightBottom[0])
              minimumArea = area < minimumArea ? area : minimumArea
            }
          }
        }
      }
      return minimumArea === Number.MAX_SAFE_INTEGER ? 0 : minimumArea
    
    };
    console.log(minAreaRect([[1,1],[1,3],[3,1],[3,3],[2,2]]);
    
    
    