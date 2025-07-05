
public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result = -1;

        // Step 2: Check for lucky integers
        for (int num : freq.keySet()) {
            if (num == freq.get(num)) {
                result = Math.max(result, num);
            }
        }

        return result;
    }
}
