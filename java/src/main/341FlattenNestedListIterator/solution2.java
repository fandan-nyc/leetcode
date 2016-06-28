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
    Queue<NestedInteger> store = new LinkedList<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
       if(nestedList != null){
           for(NestedInteger i: nestedList){
               store.add(i);
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
        if(hasNext() == false){
            return null;
        }
        if(head.isEmpty()){
            NestedInteger tmp = store.poll();
            putNestedIntegerToQueue(tmp);
        }
        return head.poll();
    }

    @Override
    public boolean hasNext() {
        return !(store.isEmpty() && head.isEmpty());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
