public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i =1; i < ratings.length; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                candies[i] = candies[i-1] +1;
            }
        }
        for(int i = ratings.length -2; i >=0 ; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                candies[i] = Math.max(candies[i],candies[i+1] +1);
            }
        }
        int result  = ratings.length;
        for(int i: candies)
        {
            result += i;
        }
        return result ;
    }
}
