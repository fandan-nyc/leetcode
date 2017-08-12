public class ZigzagIterator {

    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new  LinkedList<>();
        Iterator<Integer> a = v1.iterator();
        Iterator<Integer> b = v2.iterator();

        if(a.hasNext())
            queue.add(a);
        if(b.hasNext())
            queue.add(b);
    }

    public int next() {
        int res = 0;
        if(queue.peek().hasNext()){
            res = queue.peek().next();
        }
        Iterator<Integer> tmp = queue.remove();
        if(tmp.hasNext()){
            queue.add(tmp);
        }
        return res;
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
