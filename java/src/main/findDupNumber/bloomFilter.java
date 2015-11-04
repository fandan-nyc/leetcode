public class Solution {
    private static final List<Integer> primes = Arrays.asList(31,37,41,43,47,53,59,101);
    private static final int bit = 5000000;
    private boolean[] bitMasks = new boolean[bit];

    public int findDuplicate(int[] nums) {
        // use bloom filter
        for(int i: nums)
        {
            if(duplicateData(i) == false)
            {
                setBitMasks(i);
            }
            else 
            {
                return i;
            }
        }
        return -1;
    }
    
    
    private int hashFunc(int x, int hashNumber)
    {
        int prime = primes.get(hashNumber);
        String number = Integer.toString(x);
        long result  = 0;
        for(char i: number.toCharArray())
        {
             result = result * prime + i;
        }
        result %= bit;
        return result > 0? (int)result: ((int)(result + bit)) % bit;
    }
    
    private void setBitMasks(int x)
    {
        int  i = -1;
        while(++i <=7)
        {
            int hashNum = hashFunc(x, i);
            bitMasks[hashNum] = true;
            
        }
    }
    
    private boolean duplicateData(int x)
    {
        int i = -1 ;
        boolean result = true ;
        while(++i <= 7)
        {
            int hashNum = hashFunc(x,i);
            result = result && bitMasks[hashNum];
        }
        return result;
    }
}
