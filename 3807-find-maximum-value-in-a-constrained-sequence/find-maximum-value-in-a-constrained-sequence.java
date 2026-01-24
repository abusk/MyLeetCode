class Solution {
    public int findMaxVal(int n, int[][] res, int[] diff) {
        int ans[]=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        for(int i=0;i<res.length;i++){
            ans[res[i][0]]=res[i][1];
        }
        //finding upper bound left->right
        for(int i=1;i<n;i++){
            ans[i]=Math.min(ans[i],ans[i-1]+diff[i-1]);
        }
        
        //finding upper bound right->left
        for(int i=n-2;i>=0;i--){
            ans[i]=Math.min(ans[i],ans[i+1]+diff[i]);
        }
        int max=0;
        for(int i=0;i<ans.length;i++){
            max=Math.max(max,ans[i]);
        }
        
        
        return max;
    }
}