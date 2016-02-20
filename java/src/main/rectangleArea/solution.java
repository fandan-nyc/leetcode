public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (D-B) * (C-A) + (H - F ) * (G-E);
        return total - getOverlap(A,B,C,D,E,F,G,H);
    }
    
    private int getOverlap(int A, int B, int C, int D, int E, int F, int G, int H){
        if(E > C || G < A ||B > H || D < F){
            return 0;
        }
        return (Math.min(G,C) - Math.max(E, A)) * ( Math.min(D,H) - Math.max(B,F));
    }
}
