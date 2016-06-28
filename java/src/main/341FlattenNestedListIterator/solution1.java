/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> head = new LinkedList<Integer>();
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList != null){
            for(NestedInteger i: nestedList){
                putNestedIntegerToQueue(i);
            }
        }
    }
    
    private void putNestedIntegerToQueue(NestedInteger input){
        if(input.isInteger()){
            head.add(input.getInteger());
            return;
        }
        for(NestedInteger i: input.getList()){
            putNestedIntegerToQueue(i);
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return head.poll();
        }
        return null;
        
    }

    @Override
    public boolean hasNext() {
        return !head.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
