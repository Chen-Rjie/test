package 链表;

public class no3 {
    static int[][] dp;
    static int[] inArray;
    static int res = 0;
    public static void main(String[] args) {
        char[] test = {'a','c','d'};
        String str = "cdaefe";
        initArray(test,str);
        dpMethod(dp,test,str);
        System.out.println(res);
    }
    public static void initArray(char[] arr,String str){
        int len = str.length();
        dp = new int[len][len];
        inArray = new int[len];
        for(int i=0;i<len;i++){
            if(containch(arr,str.charAt(i))){
                inArray[i] = 1;
            }
        }
    }
    public static int dpMethod(int[][] dp,char[] array,String str){
        initArray(array,str);
//        int res = 0;
        int len = str.length();
        for(int i=0;i<len-1;i++){
            char first = str.charAt(i);;
            char end = str.charAt(i+1);
            if(inArray[i]==0){
                dp[i][i]=1;
                res = 1;
                if(inArray[i+1]==0&&i<len-1&&end==first){
                    dp[i][i+1] = 1;
                    res = 2;
                }
            }
        }
        if(inArray[len-1]==0){
            dp[len-1][len-1]=1;
        }
        for(int L=3;L<=len;L++){
            for(int i=0;i+L-1<len;i++){
                if(inArray[i]!=0)
                    continue;
                int j=i+L-1;//子串右端点
//                if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==1)
                if(inArray[j]==0&&str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==1)
                {
                    dp[i][j]=1;
                    res = L;//更新最长回文子串长度;
                }
            }
        }
        return res;
    }
    public static boolean containch(char[] array,char key){
        int f = 0;
        for(char ch:array){
            if(key==ch){
                f = 1;
                break;
            }
        }
        return f==1;
    }

}
