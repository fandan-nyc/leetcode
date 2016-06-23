public class MedianFinder {

    // Adds a number into the data structure.
    List<Integer> store = new ArrayList<Integer>();

    public void addNum(int num) {
        int start = 0; 
        int end = store.size()-1;
        if(end == -1){
            store.add(num);
            return;
        }
        if(num <= store.get(0)){
            store.add(0, num);
            return;
        }
        if(num >= store.get(store.size()-1)){
            store.add(num);
            return;
        }
        while(start <= end){
            int middle = start + (end-start) /2; 
            int middleVal = store.get(middle);
            if( middleVal == num){
                store.add(middle, middleVal);
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

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
