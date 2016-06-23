public class MedianFinder {

    // Adds a number into the data structure.
    PriorityQueue<Integer> lessThanMedium =  new PriorityQueue<Integer>(10, Collections.reverseOrder());
    PriorityQueue<Integer> moreThanMedium = new PriorityQueue<Integer>();
    
    public void addNum(int num) {
        if(lessThanMedium.isEmpty()){
            lessThanMedium.add(num);
            return;
        }
        if(num < lessThanMedium.peek()){
            lessThanMedium.add(num);
        }else{
            moreThanMedium.add(num);
        }
        int diff = lessThanMedium.size() - moreThanMedium.size();
        if(diff >= -1 && diff <= 1){
            return;
        }else if( diff <-1){
            lessThanMedium.add(moreThanMedium.poll());
        }else{
            moreThanMedium.add(lessThanMedium.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(lessThanMedium.size() == moreThanMedium.size()){
            return (lessThanMedium.peek()+moreThanMedium.peek())/2.0;
        }else if(lessThanMedium.size() < moreThanMedium.size()){
            return moreThanMedium.peek();
        }else{
            return lessThanMedium.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
