package base;

public class MaxOnesCount {
    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 22, 3, 4, 1,1,1,1,1,1,1 ,9, 7, 6, 1, 1, 1, 1, 1, 1};
        countMaxOnesOccurance(arr);
    }

    public static void countMaxOnesOccurance(int [] arr) {
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }

        System.out.println(maxCount);
    }
}
