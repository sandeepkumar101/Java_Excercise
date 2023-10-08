package common;

public class TestTest
{
    public static void main(String[] args) {
        int arr [] = {5,6,1,5,6,9,10,17,5,6};

        int sum = 0;
        int inSection = 0;
        int flag = 0;

        for(int i = 0; i< arr.length;i++)
        {
            inSection = 0;
            if(arr[i] ==5)
            {
                inSection = 0;
                flag = 1;
            }
            if(inSection ==0 && arr[i] ==6)
            {
                if(flag == 1)
                {
                    sum = sum -5;
                    inSection = 1;
                }
                flag = 0;
            }
            if(inSection ==0)
            {
                sum += arr[i];
            }
     
        }

        System.out.println(sum);
    }

}