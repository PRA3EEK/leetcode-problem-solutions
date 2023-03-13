class Solution {
    public double myPow(double x, int n) {
      
       if(n<0) return (helper(1/x, -n));
       return helper(x,n);
    }

    public double helper(double num, int n)
    {
        if(n == 0) return 1;
        double res = helper(num, n/2);
        return (n%2==0) ? res*res : num*res*res;
    }
}
