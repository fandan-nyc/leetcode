public class MedianFinder {

    // Adds a number into the data structure.
    List<Integer> store = new ArrayList<Integer>();

    public void addNum(int num) {
        int start = 0; 
        int end = store.size()-1;
        while(start <= end){
            int middle = start + (end-start) /2; 
            int middleVal = store.get(middle);
            if( middleVal == num){
                store.add(middle, middleVal);x
                return;
            }else if( middleVal < num){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        store.add(start, num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int len = store.size();
        if(len == 0){
            return 0;
        }
        if(len%2 ==0){
            return (store.get(len/2) + store.get(len/2-1))/2.0;
        }
        return (double)(store.get(len/2));
    }
};
