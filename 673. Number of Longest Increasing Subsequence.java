class Solution {
    // public int help2(int[] arr, int idx, int prev) {
    // if (idx == arr.length) return 0;

    // int notTake = help2(arr, idx + 1, prev);
    // int take = 0;
    // if (prev == -1 || arr[idx] > arr[prev]) {
    //     take = 1 + help2(arr, idx + 1, idx);
    // }
    // return Math.max(take, notTake);
//}

    // public int help(int arr[], int idx, int last , int trg, int dp[][][]){
    //     if(trg == 0) return 1;
    //     if(idx == arr.length) return 0;
    //     if (dp[idx][last+1][trg] != -1) return dp[idx][last+1][trg];
    //     int c=0;
    //     c+= help(arr, idx+1, last, trg,dp);
    //     if(last == -1 || arr[last]< arr[idx]){
    //         c+= help(arr,idx+1, idx, trg-1,dp);
    //     }
    //     return dp[idx][last+1][trg] = c;
    // }
    public int findNumberOfLIS(int[] nums) {
        // int len = help2(nums,0,-1);
        // int dp[][][] = new int[nums.length+1][nums.length+1][len+1];
        // for (int i = 0; i <= nums.length; i++) {
        //     for (int j = 0; j <= nums.length; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return help(nums,0,-1,len,dp);
        int t[] = new int[nums.length];
        int cnt[] = new int[nums.length];
        Arrays.fill(t,1);
        Arrays.fill(cnt,1);

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    if(t[j]+1==t[i]){
                        cnt[i]+=cnt[j];
                    }else if(t[j]+1>t[i]){
                        t[i] = t[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
        }
        int max= Integer.MIN_VALUE;
        for(int n : t) max= Math.max(max,n);
        int ans=0;
        for(int i=0; i<t.length; i++) {
            if(t[i]==max) ans+=cnt[i];
        }
        return ans;

    }
}
