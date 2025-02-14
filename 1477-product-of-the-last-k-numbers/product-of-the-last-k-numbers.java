class ProductOfNumbers {
    List<Integer> mul;
    public ProductOfNumbers() {
        mul = new ArrayList<>();
    }
    
    public void add(int num) {
        mul.add(num);
    }
    
    public int getProduct(int k) {
        int s = mul.size() -1;
        int m = 1;
        for(int i = s; i >= Math.max(0, s - k+1); i--) {
            int nm = mul.get(i);
            if(nm == 0) {
                return 0;
            }
            m *= nm;
        }
        return m;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */