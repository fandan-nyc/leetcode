package leetcodeTest;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dfan on 8/27/17.
 */
public class test4 extends TestCase {

    @Test
    public void test() {
        BalanceAmongFriends hah = new BalanceAmongFriends();
        assertEquals(1, hah.minTransaction(new int[][]{new int[]{0, 1, 10}, new int[]{1, 0, 1},
                new int[]{1, 2, 5},
                new int[]{2, 0, 5}}));
        assertEquals(1, hah.minTransaction(new int[][]{new int[]{0, 1, 10}}));
    }

    class BalanceAmongFriends {

        public int minTransaction(int[][] inputs) {
            // find the number of people whose final transaction is 0
            // if someone get borrowed x, and lend out x, he will not be involved in the follwoing cal
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] input : inputs) {
                map.putIfAbsent(input[0], 0);
                map.putIfAbsent(input[1], 0);
                map.put(input[0], map.get(input[0]) - input[2]);
                map.put(input[1], map.get(input[1]) + input[2]);
            }
            int count = 0;
            int[] balance = new int[map.size()];
            for (int i : map.values()) {
                if (i != 0) {
                    balance[count++] = i;
                }
            }
            if (count == 0) {
                return 0;
            }
            int[] dp = new int[1 << count];
            Arrays.fill(dp, Integer.MAX_VALUE/2);
            for (int i = 1; i < dp.length; i++) {
                int sum = 0;
                int trans = 0;
                for (int j = 0; j < balance.length; j++) {
                    if ((i & 1 << j) != 0) {
                        sum += balance[j];
                        trans++;
                    }
                }
                if (sum == 0) {
                    dp[i] = trans - 1;
                    for (int j = 1; j < i; j++) {
                        if ((i & j) == j) {
                            dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                        }
                    }
                }
            }
            return dp[dp.length - 1];
        }
    }
}

