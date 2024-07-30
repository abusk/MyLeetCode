class SnakeGame {
    Deque<int[]> foodQ;
    int width;
    int height;
    Deque<int[]> snakeQ;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.score = 0;
        foodQ = new LinkedList<>();
        for(int[] f : food) {
            foodQ.add(f);
        }
        snakeQ = new LinkedList<>();
        snakeQ.add(new int[] {0,0});
    }
    
    public int move(String direction) {
        int[] snakeHead = snakeQ.getLast();
        int[] newHead = snakeHead;
        if("R".equals(direction)) {
            newHead = new int[] {snakeHead[0], snakeHead[1]+1};
            if(newHead[1] == width) {
                return -1;
            }
        } else if("D".equals(direction)) {
            newHead = new int[] {snakeHead[0]+1, snakeHead[1]};
            if(newHead[0] == height) {
                return -1;
            }
        } else if("L".equals(direction)) {
            newHead = new int[] {snakeHead[0], snakeHead[1]-1};
            if(newHead[1] == -1) {
                return -1;
            }
        } else if("U".equals(direction)) {
            newHead = new int[] {snakeHead[0] - 1, snakeHead[1]};
            if(newHead[0] == -1) {
                return -1;
            } 
        }
        moveToPosition(newHead);
        return score;
    }
    public void moveToPosition(int[] pos) {
        int[] foodPos = new int[] {-1, -1};
        if(!foodQ.isEmpty()){
            foodPos = foodQ.getFirst();
        }
        if(foodPos[0] != -1 && foodPos[1] != -1 &&  foodPos[0] == pos[0] && foodPos[1] == pos[1]) {
            foodQ.removeFirst();
            score++;
        } else {
            snakeQ.removeFirst();
        }
        if(eatingSelf(pos)){
            score = -1;
        } else {
            snakeQ.addLast(pos);
        }
    }
    public boolean eatingSelf(int[] pos) {
        return snakeQ.stream().anyMatch(a -> a[0] == pos[0] && a[1]==pos[1]);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */