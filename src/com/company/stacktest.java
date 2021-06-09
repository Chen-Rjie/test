package com.company;
import java.util.ArrayList;
public class stacktest {
    public static void main(String[] args)
    {
        int[] pushtest = new int[]{1,2,3,4,5};
        int[] poptest = new int[]{3,5,4,2,1};
        boolean res = new Solution3().IsPopOrder(pushtest,poptest);
}
}

class Solution3 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        int[] sup = new int[len];
        int index = -1;
        int indexpushA = 0;
        for(int i=0;i<len;i++)
        {
            int top = popA[i];
            if(index==-1)
            {
                ++index;
                while(index<len&&indexpushA<len&&pushA[indexpushA]!=top)
                {
                    sup[index] = pushA[indexpushA];
                    ++index;
                    ++indexpushA;
                }
                if(indexpushA==len)
                    return false;
                --index;
                ++indexpushA;//表示从下一个位置开始往后压栈
            }
            else
            {
                if(sup[index]==top)
                {
                    --index;
                }
                else{
                    while(indexpushA<len&&pushA[indexpushA]!=top)
                    {
                        ++index;
                        sup[index] = pushA[indexpushA];
                        ++indexpushA;
                    }
                    if(indexpushA==len)
                        return false;
                    ++indexpushA;
                }
            }

        }
        return true;
    }
}
