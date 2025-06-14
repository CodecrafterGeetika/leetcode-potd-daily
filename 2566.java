class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        
        // Find the first non-9 digit for max value
        char maxDigit = '9';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                maxDigit = s.charAt(i);
                break;
            }
        }
        String maxStr = s.replace(maxDigit, '9');
        int maxNum = Integer.parseInt(maxStr);
        
        // Find the first digit for min value
        char minDigit = s.charAt(0);
        String minStr = s.replace(minDigit, '0');
        int minNum = Integer.parseInt(minStr);
        
        return maxNum - minNum;
    
        
    }
}