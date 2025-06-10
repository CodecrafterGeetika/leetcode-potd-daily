class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        List<Integer> oddFreq = new ArrayList<>();
        List<Integer> evenFreq = new ArrayList<>();
        
        for (int count : freq) {
            if (count == 0) continue;
            if (count % 2 == 1) {
                oddFreq.add(count);
            } else {
                evenFreq.add(count);
            }
        }
        
        if (oddFreq.isEmpty() || evenFreq.isEmpty()) {
            return 0;
        }
        
        int maxOdd = Collections.max(oddFreq);
        int minEven = Collections.min(evenFreq);
        
        return maxOdd - minEven;
    }
}