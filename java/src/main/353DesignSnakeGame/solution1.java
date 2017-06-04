public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    private Set<SnakeNode> pos ;
    private Deque<SnakeNode> snake;
    private Queue<SnakeNode> food;
    private int score;
    private int height ; 
    private int width;

     class SnakeNode{
        public int col;
        public int row;
        
        SnakeNode(int row, int col){
            this.col = col;
            this.row = row;
        }
        
        @Override 
        public boolean equals(Object a){
            if( a== this){
                return true;
            }
            if(!(a instanceof SnakeNode)){
                return false;
            }
            SnakeNode b = (SnakeNode)a;
            return b.row == this.row && b.col == this.col;
        }
        
        @Override 
        public int hashCode(){
            int result = 17;
            result += 31 * row;
            result += 31 * col;
            return result;
        }
        
        @Override 
        public String toString(){
            return "row: " + this.row + ", col: " + this.col;
        }
    }
    
    public SnakeGame(int width, int height, int[][] food) {
        pos = new HashSet<SnakeNode>();
        snake = new LinkedList<SnakeNode>();
        SnakeNode head = new SnakeNode(0,0);
        pos.add(head);
        snake.addFirst(head);
        this.food = new LinkedList<SnakeNode>();
        for(int[] data: food){
            this.food.add(new SnakeNode(data[0], data[1]));
        }
        score = 0;
        this.width = width;
        this.height = height;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        SnakeNode potentialHead = nextPos(snake.peek(), direction);
        if(potentialHead.equals(food.peek())){
            pos.add(potentialHead);
            snake.addFirst(potentialHead);
            food.remove();
            return ++score;
        }else if(hitWall(potentialHead)){
            return -1;
        }else {
            pos.remove(snake.removeLast());
            // bite self
            if(pos.add(potentialHead) == false){
                return -1;
            }
            snake.addFirst(potentialHead);
            return score;
        }
    }
    
    private SnakeNode nextPos(SnakeNode node, String direction){
        if(direction.equals("U")){
            return new SnakeNode(node.row-1, node.col);
        }else if(direction.equals("D")){
            return new SnakeNode(node.row+1, node.col);
        }else if(direction.equals("L")){
            return new SnakeNode(node.row, node.col-1);
        }else if(direction.equals("R")){
            return new SnakeNode(node.row, node.col+1);
        }else {
            throw new IllegalArgumentException("direction: " + direction + " does not exists, try, L, R, U, D");
        }
    }
    
    private boolean hitWall(SnakeNode node){
        return node.row < 0 || node.row >= height || node.col < 0 || node.col >= width;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
