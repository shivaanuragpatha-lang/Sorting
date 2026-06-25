import java.util.Arrays;

public class RadixSort {

    // Function to get the largest element from an array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static void countingSort(int[] array, int place) {
        int size = array.length;
        int[] output = new int[size];
        int max = 9; // Since digits range from 0 to 9

        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            int digit = (array[i] / place) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the output array to array[], so that array[] now contains sorted numbers
        System.arraycopy(output, 0, array, 0, size);
    }

    public static void radixsort(int[] array) {
        int max = getMax(array);
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, place);
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {121, 432, 564, 23, 1, 45, 788};
        radixsort(array);
        printArray(array);
    }
}
