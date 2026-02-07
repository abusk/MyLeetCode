class NumMatrix {

    /** Segment tree for an array */
    public class SegmentTree{
        int[] sgTree; 
        int n ; 

        /** Constructor : initialise & build ST */
        SegmentTree(int[] nums){
            n = nums.length; 
            sgTree = new int[ 4*n + 1];
            buildST(nums);
        }

        public void buildST(int[] nums){
            build(0, 0, n-1, nums);
        }

        /** Build ST Recursively : O(N), max O(4N) */
        public void build(int idx, int low, int high, int[] nums){
            /** Single element , Hence ST node -> sgTree[idx] = num[low] or num[high] */
            if(low == high){
                sgTree[idx] = nums[low];
                return; 
            }

            int mid = low + (high-low)/2;

            /** Build tree recursively on left & right */
            build(2*idx+1, low, mid, nums);
            build(2*idx+2, mid+1, high, nums);

            /** Update current segmentTree node value by taking from left & right */
            sgTree[idx] = merge(sgTree[2*idx+1],sgTree[2*idx+2]);

        }

        public int merge(int left, int right){
            return left + right; 
        }

        public int sumRange(int lRange, int rRange){
            return sumRange(0, 0, n-1, lRange, rRange);
        } 

        /** Gives sum range for lRange to rRange : Complexity = O(log N),
        Max it can go for 2x or 3x of logN */
        public int sumRange(int idx, int low, int high,int lRange,int rRange){
            
            /** No overlapping : low & high out of range of [lRange,rRange] */
            if(lRange > high || rRange < low)
                return 0; 
            
            /** Complete overlapping : low & high in range of [lRange,rRange] 
            Hence return current ST node value */
            if(lRange <= low && high <= rRange)
                return sgTree[idx];
            
            /** Partial overlap */
            int mid = low + (high-low)/2;

            int leftSum = sumRange(2*idx+1, low, mid, lRange, rRange);
            int rightSum = sumRange(2*idx+2, mid+1, high, lRange, rRange);

            /** Return merge of both left * right, in case of partial overlapping */
            return merge(leftSum, rightSum);
        }

        public void update(int updateIdx, int updateVal){
            update(0, 0, n-1, updateIdx, updateVal);
        }

        /** Update the value at updateIdx : Complexity = O(logN) */
        public void update(int idx, int low, int high,int updateIdx,int updateVal){

            /** Single element, found the index to be updated */
            if(low == high){
                sgTree[idx] = updateVal; 
                return; 
            }

            int mid = low + (high-low)/2;
            
            /** Move left in case updateIdx <= mid, else move right */
            if(updateIdx <= mid)
                update(2*idx+1 , low, mid, updateIdx, updateVal);
            else 
                update(2*idx+2, mid+1, high, updateIdx, updateVal);
            
            /** Once the child node is updated, Update the current node
            by using left & right child value */
            sgTree[idx] = merge(sgTree[2*idx+1], sgTree[2*idx+2]);
        }

    }

    /** Stores segmentTree for each row */
    SegmentTree[] sgTreeList; 

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length ;
        int cols = matrix[0].length; 

        if(rows == 0 || cols == 0){
            sgTreeList = new SegmentTree[0];
            return; 
        }

        sgTreeList = new SegmentTree[rows];

        /** Build segment tree for each row */
        for(int i=0; i<rows; i++){
            sgTreeList[i] = new SegmentTree(matrix[i]);
        }
    }
    

    public void update(int row, int col, int val) {
        /** Update on row index at column location of sgTreeList */
        sgTreeList[row].update(col, val);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = 0; 

        /** from row1 to row2 : calculate sum in the range of (col2, col2)  */
        for(int i=row1 ;i<= row2; i++){
            int rowSum = sgTreeList[i].sumRange(col1, col2);
            totalSum += rowSum;
        }

        return totalSum; 
    }
}