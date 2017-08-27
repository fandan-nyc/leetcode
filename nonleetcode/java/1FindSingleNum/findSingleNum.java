package leetcodeTest;

import junit.framework.TestCase;
import org.junit.Test;

public class test extends TestCase {

    @Test
    public void test() {
        Solution t = new Solution();
        assertEquals(7, t.getSingle(new int[]{1, 1, 7, 8, 8}));
    }

    @Test
    public void test2() {
        Solution t = new Solution();
        assertEquals(7, t.getSingle(new int[]{7, 1, 1, 8, 8}));
    }

    @Test
    public void test3() {
        Solution t = new Solution();
        assertEquals(7, t.getSingle(new int[]{1, 1, 8, 8, 7}));
    }

    @Test
    public void test4() {
        Solution t = new Solution();
        assertEquals(-1, t.getSingle(null));
    }

    @Test
    public void test5() {
        Solution t = new Solution();
        assertEquals(-1, t.getSingle(new int[]{}));
    }

    @Test
    public void test6() {
        Solution t = new Solution();
        assertEquals(77, t.getSingle(new int[]{77}));
    }

    @Test
    public void test7() {
        Solution t = new Solution();
        assertEquals(77, t.getSingle(new int[]{77, 11, 11}));
    }

    //  8 8 7 7 1  9 9, find 1
    class Solution {
        public int getSingle(int[] input) {
            if (input == null || input.length == 0) {
                return -1;
            }
            int start = 0;
            int end = input.length;
            while (start < end) {
                int middle = start + (end - start) / 2;
                if (middle % 2 == 1) {
                    if (input[middle] == input[middle - 1]) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                } else {
                    if (middle == input.length - 1) {
                        return input[middle];
                    }
                    if (input[middle] != input[middle + 1]) {
                        end = middle;
                    } else {
                        start = middle + 2;
                    }

                }
            }
            return input[start];
        }
    }
}

