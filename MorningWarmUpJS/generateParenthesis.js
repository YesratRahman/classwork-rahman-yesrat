/**
 * @param {number} n
 * @return {string[]}
 */
//current combination will start as an empty string and will have parens added to it on each call
// Base case: a valid combination cannot be more than n x 2 (openPren + closePren) in length
// Once we hit the base case, we know that the current combination is valid and can be added to our answer array
// For the combination to be valid we must add an opening paren first
// Once we've added this paren in the current combination we will add more until reaches the max limit (n)

var generateParenthesis = function(n) {
    let result = [];
    trackParenthesis("", 0, 0 ) ;
    return result;
    
    function trackParenthesis(answer, openPren, closePren){
    if (openPren === n && closePren === n){
       result.push(answer);
       return ;
    }
    if (openPren !== n ){
       trackParenthesis(answer + "(", openPren + 1 , closePren);
    }
    if (openPren > closePren){
       trackParenthesis(answer + ")", openPren, closePren + 1 );
   }
}
  };
      
 var generateParenthesis1 = function(n) {
    
    const result = [];
    backtrack(result, "", 0, 0, n);
    return result;
};

function backtrack(result, current, openPren, closePren, n) {
    if (current.length == n * 2) {
        result.push(current);
        return;
    }
    if (openPren < n)
        backtrack(result, current + "(", openPren + 1, closePren, n);
    if (closePren < openPren)
        backtrack(result, current + ")", openPren , closePren + 1, n);
}

console.log(generateParenthesis(3));
console.log(generateParenthesis1(3));
