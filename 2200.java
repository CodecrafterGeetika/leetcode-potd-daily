class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();
        Set<Integer> resultSet = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                keyIndices.add(j);
            }
        }
        for (int j : keyIndices) {
            for (int i = Math.max(0, j - k); i <= Math.min(nums.length - 1, j + k); i++) {
                resultSet.add(i);
            }
        }
      return new ArrayList<>(resultSet);
    }
}
