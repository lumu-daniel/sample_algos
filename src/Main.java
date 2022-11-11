import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(Arrays.toString(answerOne(new int[]{5, 7, 8, 10, 12, 4, 1})));
        System.out.println(answerTwo(new int[]{6, 8, 5, 12, 1, 10}));
        System.out.println(answerTwo(new int[]{7, 8, 17, 32, 6, 21}));
        System.out.println(answerTwo(new int[]{4, 21, 33, 6}));
        System.out.println(answerTwo(new int[]{18, 7, 12, 31, 26, 11}));
        System.out.println(answerTwo(new int[]{19, 12, 32, 4}));
        System.out.println(answerTwo(new int[]{19, 7, 12, 32, 11}));
        System.out.println(answerTwo(new int[]{11, 14, 12, 31, 5}));
        System.out.println(answerTwo(new int[]{19, 20}));
        System.out.println(answerThree(new int[]{5, 4, 3, 2, 3, 4, 6, 1}));
        System.out.println(answerThree(new int[]{11, 11}));
        System.out.println(answerThree(new int[]{7, 2, 18}));
        System.out.println(answerThree(new int[]{7, 10, 12, 14}));
    }

    //Let a = {5, 7, 8, 10, 12, 4, 1}. Then b[0] = 5, b[1] = 7, b[2] = 5 + 8 = 13, b[3] = 10, b[4] =
    //5 + 8 + 12 = 25, b[5] = 4 and b[6] = 5 + 8 + 12 + 1 = 26.

    //Question One
    private static int[] answerOne(int[] data){
        int[] result = new int[data.length];
        for (int i = 0; i< data.length; i++){
            if(i%2==0){
                int evenSum = 0;
                for (int j = 0;j<=i;j++){
                    if(j%2==0){
                        evenSum+=data[j];
                    }
                }
                result[i] = evenSum;
            }else{
                result[i] = data[i];
            }
        }
        return result;
    }


    //(2) Every odd number other than the last item is followed by at least one even
    //number.
    //(3) Every odd number other than the first item is preceded by at least one even
    //number.

    //Question two
    private static int answerTwo(int [] a) {
        int result = 0;
        if((a[0]%2==0&&a[a.length-1]%2==0)||(a[0]%2!=0&&a[a.length-1]%2!=0)){
            for (int i=0; i<a.length-1;i++){
                if(i>0){
                    if(a[i]%2!=0){
                        if(a[i-1]%2==0&&a[i+1]%2==0){
                            result = 1;
                        }
                    }
                }else{
                    if(a[i+1]%2==0&&a[a.length-2]%2==0){
                        result = 1;
                    }
                }
            }
            if((a[a.length-1]%2!=0&&a[a.length-2]%2==0)&&(a[0]%2!=0&&a[1]%2==0)){
                result = 1;
            }
        }
        return result;
    }

    //Question 3
    //(1) It has even number of elements
    //(2) Sum of all the numbers in the first half of the array is equal to the sum of all numbers
    //in the second half of the array.
    private static int answerThree(int [] a){
        int result = 0;
        if(a.length%2==0){
            int sum1 = 0;
            int sum2 = 0;
            for (int i=0; i<a.length; i++){
                if(i<a.length/2){
                    sum1+=a[i];
                }else{
                    sum2+=a[i];
                }
            }
            if(sum1==sum2){
                result = 1;
            }
        }
        return result;
    }
}