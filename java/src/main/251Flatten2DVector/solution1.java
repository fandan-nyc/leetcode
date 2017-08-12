public class Vector2D implements Iterator<Integer> {

    private List<List<Integer>> data ; 
    private int listPos ;
    private int elePos ;
    
    public Vector2D(List<List<Integer>> vec2d) {
        data = vec2d;
        listPos = 0;
        elePos = 0;
    }

    @Override
    public Integer next() {
        return data.get(listPos).get(elePos++);
    }

    @Override
    public boolean hasNext() {
        while(listPos < data.size()){
            if(elePos < data.get(listPos).size()){
                return true;
            }else{
                listPos ++;
                elePos = 0;
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
