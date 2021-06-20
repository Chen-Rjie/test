package tips;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Chen
 * 2021/6/19 16:40
 */
public class StreamSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
//        IntStream.of(nums).boxed().sorted((a,b)->b-a).mapToInt(Integer::intValue).toArray();
        nums = Arrays.stream(nums).boxed().sorted((a,b)->b-a).mapToInt(Integer::intValue).toArray();
        for (int num:nums) {
            System.out.println(num);
        }
    }
}
