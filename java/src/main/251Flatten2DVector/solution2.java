public class Vector2D implements Iterator<Integer> {

    Queue<Iterator<Integer>> queue;
    Iterator<Integer> curr ;
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<>();
        for(List<Integer> i: vec2d){
            queue.add(i.iterator());
        }
        curr = queue.poll();
    }

    @Override
    public Integer next() {
        if(curr.hasNext()){
            return curr.next();
        }
        while(queue.isEmpty() == false){
            curr = queue.poll();
            if(curr.hasNext()){
                return curr.next();
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if(curr != null && curr.hasNext()){
            return true;
        }
        while(queue.isEmpty() == false){
            curr = queue.poll();
            if(curr.hasNext()){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
