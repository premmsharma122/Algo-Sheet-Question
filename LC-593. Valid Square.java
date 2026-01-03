// class Solution {
//     public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
//         HashSet<Integer> hs = new HashSet<>();
//         hs.add(Math.abs(p1[0]));
//         hs.add(Math.abs(p1[1]));
//         hs.add(Math.abs(p2[0]));
//         hs.add(Math.abs(p2[1]));
//         hs.add(Math.abs(p3[0]));
//         hs.add(Math.abs(p3[1]));
//         hs.add(Math.abs(p4[0]));
//         hs.add(Math.abs(p4[1]));
//         return (hs.size()==2) ? true : false;
//     }
// }
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] pts = {p1, p2, p3, p4};
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int d = dist(pts[i], pts[j]);
                if (d == 0) return false;   
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }

        return map.size() == 2 &&
               map.containsValue(4) &&
               map.containsValue(2);
    }

    private int dist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
