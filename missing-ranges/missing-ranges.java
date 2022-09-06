class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (Integer integer : nums) {
            set.add(integer);
        }

        int i = lower;
        while (i <= upper) {
            if (!set.contains(i)) {
                boolean flag = false;
                int k = i;
                for (int j = 0; j < nums.length; j++) {
                    if (i < nums[j]) {
                        flag = true;
                        if (nums[j] - i > 1) {
                            res.add(i + "->" + (nums[j] - 1));
                        } else {
                            res.add(i + "");
                        }
                        i = nums[j] - 1;
                        break;
                    }
                }
                if (!flag) {
                    if (upper - k >= 1) {
                        res.add(k + "->" + (upper));
                    } else {
                        res.add(k + "");
                    }
                    i = upper;
                }
            }
            i++;
        }

        System.out.println(res);
        return res;
    }
}