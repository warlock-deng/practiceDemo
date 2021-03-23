package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 198
 * https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * ***********************************************************************************************************************
 * <p>
 * 状态定义：f(i) 考虑偷i个房屋，使得金额最大
 * f(i) = f(i-1) 或 f(i-2) + i;
 * <p>
 * 状态转移方程：
 * 即：f(i) = max(f(i-1),f(i-2)+i)
 *
 * @author warlock.deng
 * Created at 2021/3/19
 */
public class HouseRobber {

    private static int[] memo;

    public static void main(String[] args) {

        List<Integer> testList1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(1);
            }
        };

        List<Integer> testList2 = new ArrayList<Integer>() {
            {
                add(2);
                add(7);
                add(9);
                add(3);
                add(1);
            }
        };

        memo = new int[testList2.size() + 1];
        int res = tryRobMemo(testList2, 0);
        int res3 = dynamicProgramming(testList2);
        int res4 = leetCode(testList2.toArray(new Integer[0]));
        String aaaa = "";
    }

    private static int tryRob(List<Integer> numbers, int index) {
        if (index >= numbers.size()) {
            return 0;
        }

        int res = 0;
        for (int i = index; i < numbers.size(); i++) {
            res = Math.max(res, (numbers.get(i) + tryRob(numbers, i + 2)));
        }
        return res;
    }

    private static int tryRobMemo(List<Integer> numbers, int index) {
        if (index >= numbers.size()) {
            return 0;
        }

        if (memo[index] != 0) {
            return memo[index];
        }

        for (int i = index; i < numbers.size(); i++) {
            memo[i] = Math.max(memo[i], (numbers.get(i) + tryRobMemo(numbers, i + 2)));
        }
        return memo[index];
    }

    private static int dynamicProgramming(List<Integer> numbers) {
        int n = numbers.size();
        int[] memo = new int[numbers.size() + 1];
        memo[n - 1] = numbers.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], numbers.get(j) + ((j + 2) < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    private static int leetCode(Integer[] nums) {
        int[] res = new int[nums.length + 1];
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[n - 1];
    }

}
