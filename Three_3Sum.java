import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_3Sum {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
            return null;
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int indx0 = 0; indx0+2< nums.length ; indx0++)
        {
            if(indx0 >0 && nums[indx0] == nums[indx0 -1])
                continue;
            int indx1 = indx0 + 1;
            int indx2 = nums.length - 1;
            while(indx1<indx2)
            {
                int sum = nums[indx0] + nums[indx1] + nums[indx2];
                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[indx0] , nums[indx1] , nums[indx2]));
                    indx2--;
                    while(indx1<indx2 && nums[indx2] == nums[indx2 + 1])
                        indx2--;

                } else if (sum > 0)
                    indx2--;
                else
                    indx1++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums == null || nums.length < 3)
            return null;
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int indx0 = 0; indx0+2< nums.length ; indx0++)
        {
            if(indx0 >0 && nums[indx0] == nums[indx0 -1])
                continue;
            int indx1 = indx0 + 1;
            int indx2 = nums.length - 1;
            while(indx1<indx2)
            {
                int sum = nums[indx0] + nums[indx1] + nums[indx2];
                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[indx0] , nums[indx1] , nums[indx2]));
                    indx2--;
                    while(indx1<indx2 && nums[indx2] == nums[indx2 + 1])
                        indx2--;

                } else if (sum > 0)
                {
                    while((nums[indx0] + nums[indx1] + nums[indx2])>0 && indx1<indx2)
                    {
                    int mid = indx1 + (indx2 - indx1) / 2;
                    if(nums[indx0] + nums[indx1] + nums[mid]>0)
                        indx2 = mid;
                    }
                    indx2--;
                }
                else
                    indx1++;
            }
        }
        return res;
    }
    
}
