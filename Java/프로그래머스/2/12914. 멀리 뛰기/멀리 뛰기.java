class Solution {
    public long solution(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        long[] array = new long[n+1];
        array[1] = 1;
        array[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1234567;
        }
        
        return array[n];
    }
}