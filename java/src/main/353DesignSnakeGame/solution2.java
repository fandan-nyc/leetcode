public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    private Deque<Integer> snake ;
    private int headRow;
    private int headCol;
    private Set<Integer> body;
    private int[][] food;
    private int nextFood;
    private int width;
    private int height;
    private int score;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        nextFood = 0;
        headRow = 0;
        headCol = 0;
        body = new HashSet<Integer>();
        snake = new LinkedList<>();
        snake.addFirst(17);
        body.add(17);
        score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        moveHelper(direction);
        if(hitWall()){
            return -1;
        } 
        int curr = 17 + headRow * 31  + headCol;
        if(eatingFood()){
            snake.addFirst(curr);
            body.add(curr);
            score++;
            return score;
        }else{
            int tail = snake.removeLast();
            body.remove(tail);
            if(body.contains(curr)){
                // bite self
                return -1;
            }
            body.add(curr);
            snake.addFirst(curr);
            return score;
        }
    }
    
    private boolean eatingFood(){
        if(nextFood < food.length && headCol == food[nextFood][1] && headRow == food[nextFood][0]){
            nextFood++;
            return true;
        }else{
            return false;
        }
    }
    
    private boolean hitWall(){
        return headRow < 0 || headRow >= this.height || headCol < 0 || headCol >= this.width;
    }
    
    private void moveHelper(String direction){
        switch(direction){
            case "U":
                headRow--;
                break;
            case "D":
                headRow++;
                break;
            case "L":
                headCol--;
                break;
            case "R":
                headCol++;
                break;
            default:
                throw new IllegalArgumentException("direction " + direction + " does not exist");
        }
    }
    
    
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
