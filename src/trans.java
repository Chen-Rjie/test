/**
 * Created by Chen
 * 2021/6/13 10:12
 */
public class trans {
    public int trans(String str){
        int res = 0;
        if(str.length()==0)
            return 0;
        boolean flagZ = str.charAt(0)=='+'||str.charAt(0)=='-';
        if(!flagZ&&(str.charAt(0)>'0'&&str.charAt(0)<'9'))
        {
            System.out.println("非法");
            return 0;
        }
        for(int i=0;i<str.length();i++){
//            boolean flag1 = str.charAt(i)>'0'&&str.charAt(i)<'9';
            if(i==0&&flagZ)
                continue;
//            boolean flag2 = str.charAt()
            res = res*10 + (-'0');
        }
        if(flagZ){
            return str.charAt(0)=='+'?res:-res;
        }
        return res;
    }
}
