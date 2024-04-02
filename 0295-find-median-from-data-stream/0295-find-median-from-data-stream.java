class MedianFinder {
    public PriorityQueue<Integer> q1;
    public PriorityQueue<Integer> q2;
    public MedianFinder() {
        q1 = new PriorityQueue<Integer>();
        q2 = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        q2.offer(num);
        q1.offer(q2.poll());
        if(q1.size() > q2.size()) {
            q2.offer(q1.poll());
        }
    }
    
    public double findMedian() {
        return q1.size() == q2.size() ? (double) (q1.peek() + q2.peek())/2 : q2.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */