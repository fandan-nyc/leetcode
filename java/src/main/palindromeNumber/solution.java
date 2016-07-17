

public class 9PalindromeNumber {
    //This solution is language specific because not all languages has long data type
    public boolean isPalindrome1(int x) {
        if(x<0)
            return false;
    	int original = x;
    	long result = 0;
        while(x!=0){
        	result = result * 10 + x % 10;
        	x = x / 10;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
        	result = 0;
        return result == original;
    }
    //This solution is not language specific, and using iterative method
    public boolean isPalindrome(int x) {
    	if(x<0)
    		return false;
    	if(x==0)
    		return true;
    	int i = x;
    	int div = 1;
    	while(i/10>0){
 			i /= 10;
    		div *= 10;
    	}
    	while(div>0){
    		if(x/div!=x%10)
    			return false;
    		x = (x%div)/10;
    		div /= 10*10;
    	}
    	return true;    	
    }       
}
