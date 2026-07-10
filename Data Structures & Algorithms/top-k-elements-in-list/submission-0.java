
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. count frequencies (hashing) — your familiar pattern
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : count.keySet()) {
            int freq = count.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

       
        int[] result = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] != null) {
                for (int num : buckets[f]) {
                    result[idx] = num;
                    idx++;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }
}
