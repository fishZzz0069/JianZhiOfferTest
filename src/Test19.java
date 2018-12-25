public class Test19 {
    public boolean isMatch(String s, String p) {



        int sIndex = 0;
        int pIndex = 0;
        int m = s.length();
        int n = p.length();

        if (m==0)
            s= " ";
        return isMatchR(s,sIndex, m,p ,pIndex,n);



    }


    public boolean isMatchR(String s, int sIndex, int m,String p , int pIndex,int n) {
        if (sIndex == m && pIndex == n
                || (sIndex == m && pIndex!=n && pIndex+2 == n
                && p.charAt(pIndex+1)=='*'&&pIndex+1<n))
            return true;

        if (sIndex == m && pIndex < n && (pIndex+1<n &&pIndex+2!=n&&p.charAt(pIndex+1)!='*'
                && pIndex+2<n && p.charAt(pIndex+2)!='.'))
            return false;


        if (pIndex+1 < n && p.charAt(pIndex + 1) == '*') {
            if (sIndex != m && p.charAt(pIndex) == s.charAt(sIndex)
                    || p.charAt(pIndex) == '.' && sIndex!=m) {
                return isMatchR(s, sIndex + 1, m, p, pIndex, n)
                        || isMatchR(s, sIndex + 1, m, p, pIndex + 2, n)
                        || isMatchR(s, sIndex, m, p, pIndex + 2, n);
            } else {
                return isMatchR(s, sIndex, m, p, pIndex + 2, n);
            }
        } else if (pIndex < n && sIndex < m){
            if (s.charAt(sIndex) == p.charAt(pIndex) || (p.charAt(pIndex) == '.')) {
                return isMatchR(s, sIndex+1, m, p, pIndex + 1, n);
            }
        }

        return false;




    }

    public static void main(String[] args){
        System.out.println(new Test19().isMatch("","c*c*"));

    }
}