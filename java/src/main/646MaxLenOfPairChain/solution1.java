class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int counter = 0;
        int lastEnd;
        for(int i = 0; i < pairs.length; i++){
            counter ++;
            lastEnd = pairs[i][1];
            while(i+1 < pairs.length && pairs[i+1][0] <= lastEnd){
                i++;
            }
        }
        return counter;
    }
}
