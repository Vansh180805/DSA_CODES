import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47PermutationsII {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], ans);
        return ans;
    }

    void backtrack(int[] nums, List<Integer> temp,
                   boolean[] used, List<List<Integer>> ans) {

        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            // Skip duplicate choices at the same level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, temp, used, ans);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    
}
