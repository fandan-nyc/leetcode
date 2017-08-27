package leetcodeTest;

import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by dfan on 8/27/17.
 */
public class test1 extends TestCase{

    @Test
    public void test1(){
        Solution so = new Solution();
        assertEquals(so.rearrange("aaaab"), null);
        assertEquals(so.rearrange("abbbc"), "bcbab");
        assertEquals(so.rearrange("a"), "a");
        assertEquals(so.rearrange("ttttssss"), "stststst");
    }
    
    class Solution {
        public String rearrange(String input) {
            Map<Character, CharCount> count = new HashMap<>();
            for (char i : input.toCharArray()) {
                count.putIfAbsent(i, new CharCount(i));
                count.get(i).count++;
            }
            PriorityQueue<CharCount> pr = new PriorityQueue<>(10, Collections.reverseOrder());
            for(Map.Entry<Character, CharCount> entry: count.entrySet()){
                pr.add(entry.getValue());
            }
            StringBuilder sb =  new StringBuilder();
            while(pr.isEmpty() == false){
                CharCount cc = pr.remove();
                int len = sb.length();
                if( len == 0 || cc.val != sb.charAt(len-1)){
                    sb.append(cc.val);
                    cc.count--;
                    if(cc.count != 0)
                        pr.add(cc);
                }else{
                    if(pr.isEmpty()){
                        return null;
                    }
                    CharCount tmp = pr.remove();
                    sb.append(tmp.val);
                    tmp.count--;
                    if(tmp.count != 0){
                        pr.add(tmp);
                    }
                    pr.add(cc);
                }
            }
            return sb.toString();
        }
    }

    class CharCount implements  Comparable<CharCount>{
        char val;
        int count = 0 ;

        CharCount(char val) {
            this.val = val;
        }

        @Override
        public String toString(){
            return "val: " + this.val + ", count: " + count;
        }

        @Override
        public int compareTo(@NotNull CharCount o) {
            return this.count - o.count;
        }
    }
}

