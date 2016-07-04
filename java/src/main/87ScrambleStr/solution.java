public class Solution {
    private int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
    
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        
        if(s1.length()  != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        long s1Forward  = 1; 
        long s2Backward = 1 ; 
        long s2Forward  = 1;
        for(int i = 0; i < s1.length(); i++){
            if(i > 0 && s1Forward == s2Forward){
                if(isScramble(s1.substring(0,i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                    return true;
                }
            }
            if( i > 0 && s1Forward == s2Backward){
                if(isScramble(s1.substring(0,i), s2.substring(s1.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s1.length() -i))){
                    return true;
                }
            }
            s1Forward *= prime[s1.charAt(i) - 'a'];
            s2Forward *= prime[s2.charAt(i) - 'a'];
            s2Backward *= prime[s2.charAt(s1.length()-i-1) - 'a'];
        }
        return false;
    }
}
