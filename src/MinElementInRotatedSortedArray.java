public class MinElementInRotatedSortedArray {

    public static void main(String[] args) {
        int[] case1 = new int[]{60,70,80,90,10,20,30,40,50};
        System.out.println(getMinElement(case1));

        int[] case2 = new int[] {20,30,40,50,60,70,80,90,10};
        System.out.println(getMinElement(case2));

        int[] case3 = new int[] {90,10,20,30,40,50,60,70,80};
        System.out.println(getMinElement(case3));
    }

    private static int getMinElement(int[] arr) {
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        while (leftPointer < rightPointer) {
            int mid = (leftPointer + rightPointer) / 2;

            if (arr[mid] < arr[mid-1]) { // means mid-index is pointing to the smallest element
                return arr[mid];
            } else if (arr[mid] > arr[mid+1]) { // means next index of the mid has the smallest element
                return arr[mid+1];
            } else if (arr[mid] >= arr[rightPointer]) { // means right side sub-array has the smallest element
                leftPointer = mid + 1;
            } else if (arr[mid] <= arr[leftPointer]) { // means left side sub-array has the smallest element
                rightPointer = mid -1;
            }
        }
        return arr[leftPointer];
    }

}
