/*Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].
Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.*/
//Code
import java.util.*;
class Solution {
  public int findKthNumber(int n, int k) {
    int curr = 1;
    k = k - 1;//Indexing starts from 1
    while (k > 0) {
      int steps = countSteps(n,curr,curr+1);
      if (steps <= k) {
        k -= steps;
        curr += 1; //Go to next neighbour
      } else {
        k -= 1;
        curr *= 10;//Go to first child
      }
    }
    return curr;
  }
    //Function to find number of numbers between prefix and nextPrefix in the range of [1,n]
    private int countSteps(int n, long prefix, long nextPrefix) {
      int steps = 0;
      while (prefix <= n) {
        steps += Math.min(n+1, nextPrefix) - prefix;
        prefix *= 10;
        nextPrefix *= 10;
      }
      return steps;
    }
  }
