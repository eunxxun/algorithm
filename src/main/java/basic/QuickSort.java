package basic;

public class QuickSort {
    /*public static List<Integer> quickSort(final List<Integer> nums){
        if(nums.size() < 2) return nums;

        final Integer pivot = nums.get(0);
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();

        for( int i = 1; i < nums.size(); i++){
            if(nums.get(i) < pivot ) low.add(nums.get(i));
            else high.add(nums.get(i));
        }

        final List<Integer> sorted = quickSort(low);

        sorted.add(pivot);
        sorted.addAll(quickSort(high));

        return sorted;
    }*/
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition2(arr, start, end); //나눈 파티션의 오른쪽방 첫번째 값을 받아온다.
        if (start < part2 - 1) {
            quickSort(arr, start, part2 -1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static int partition2(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);
        for (int j = left; j < right; ++j) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }

        int pivotPos = i+1;
        swap(arr, pivotPos, right);
        return pivotPos;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
