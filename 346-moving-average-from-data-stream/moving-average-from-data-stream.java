class MovingAverage {
    public int size;
    public int average = 0;
    Queue<Integer> q = new LinkedList<>();
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size() < size) {
            q.add(val);
            return calculate();
        } else {
            q.remove();
            q.add(val);
            return calculate();
        }
    }
    private double calculate() {
        int sum = q.stream().mapToInt(a -> a).sum();
        return (double) sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */