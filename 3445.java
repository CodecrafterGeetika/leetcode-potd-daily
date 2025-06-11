import java.util.*;

class Solution {
    public int func(int x, int y, int k, List<List<Integer>> pref) {
        int[][] trackMin = new int[2][2];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(trackMin[i], (int) 1e5);
        }

        List<Integer> xpref = pref.get(x);
        List<Integer> ypref = pref.get(y);
        int n = xpref.size();

        int i = 0, j = k;
        int ans = Integer.MIN_VALUE;

        while (j < n) {
            if (!ypref.get(j).equals(ypref.get(i))) {
                while (j - i >= k) {
                    int xp = xpref.get(i) % 2;
                    int yp = ypref.get(i) % 2;
                    trackMin[xp][yp] = Math.min(trackMin[xp][yp], xpref.get(i) - ypref.get(i));
                    i++;
                }
            }

            int xp = xpref.get(j) % 2;
            int yp = ypref.get(j) % 2;
            int max_at_j = xpref.get(j) - ypref.get(j) - trackMin[1 ^ xp][yp];
            ans = Math.max(ans, max_at_j);
            j++;
        }

        return ans;
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        List<List<Integer>> pref = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(0); // Initial 0 prefix sum
            pref.add(row);
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            for (int j = 0; j < 5; j++) {
                int last = pref.get(j).get(pref.get(j).size() - 1);
                if (j == digit) {
                    pref.get(j).add(last + 1);
                } else {
                    pref.get(j).add(last);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < 5; x++) {
            if (pref.get(x).get(n) == 0) continue;
            for (int y = 0; y < 5; y++) {
                if (x == y || pref.get(y).get(n) == 0) continue;
                ans = Math.max(ans, func(x, y, k, pref));
            }
        }

        return ans;
    }
}