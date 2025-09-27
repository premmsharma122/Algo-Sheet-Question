class Solution {
    private int help(int[] nums) {
    ArrayList<Integer> lis = new ArrayList<>();
    for(int num : nums) {
        int idx = Collections.binarySearch(lis, num);
        if(idx < 0) idx = -(idx+1);

        if(idx == lis.size()) lis.add(num);
        else lis.set(idx, num);
    }
    return lis.size();
}

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]) {
                return b[1]-a[1];
            }
            return a[0]- b[0];
        });

        // int last[] = envelopes[0];
        // int c=1;
        // for(int n[] : envelopes){
        // int w1 = last[0], h1=last[1];
        // int w2 = n[0], h2= n[1];
        // if(w1<w2 && h1<h2){
        //     c++;
        //     last = n;
        // }
        // }
       
        // return c;
        // 2nd Fully corrected approach->
        int arr[] = new int[envelopes.length];
        int idx=0;
        for(int n[] : envelopes){
            arr[idx++] = n[1];
        }
        return help(arr);
    }
}
