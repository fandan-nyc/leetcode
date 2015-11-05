public class Solution {
    public int candy(int[] ratings) {
         if(ratings == null || ratings.length == 0)
         {
             return 0;
         }
         if(ratings.length == 1)
         {
             return 1;
         }
         int result = 1;
         int tmp = 1;
         for( int i = 1; i < ratings.length;i++)
         {
             if(ratings[i] == ratings[i-1])
             {
                 tmp = 1;
                 result += tmp ;
             }
             else if(ratings[i] > ratings[i-1])
             {
                 tmp ++;
                 result += tmp ;
             }
             else
             {
                 int count = 1;
                 while(i < ratings.length && ratings[i] < ratings[i-1])
                 {
                     i++;
                     count += 1 ; 
                 }
                 result += ( count > tmp) ?((1+ count)*count/2 - tmp) : (count -1 )*(count) /2 ;
                 tmp = 1;
                 i--;
             }
         }
         return result ;
}
}
