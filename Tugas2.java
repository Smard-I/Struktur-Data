public class Tugas2 {
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 =mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid =  (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void countingSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] count = new int[max - min + 1];
        for (int num : arr) count[num - min]++;
        int idx = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            while (count[i] > 0) {
                arr[idx++] = i + min;
                count[i]--;
            }
        }
    }

    public static void cetakArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : "\n"));
        }
    }

    public static void main(String[] args) {
        int a1 = 05, a2 = 84, a3 = 40, a4 = 03, a5 = 69, a6 = 21, a7 = 01, a8 = 97;

        // Merge Sort
        int[] arr1 = {a1, a2, a3, a4, a5, a6, a7, a8};
        System.out.println("=== MERGE SORT (Descending) ===");
        System.out.print("Sebelum: "); cetakArray(arr1);
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.print("Sesudah: "); cetakArray(arr1);

        // Counting Sort
        int[] arr2 = {a1, a2, a3, a4, a5, a6, a7,a8};
        System.out.println("=== COUNTING SORT (Descending) ===");
        System.out.print("Sebelum: "); cetakArray(arr2);
        countingSort(arr2);
        System.out.print("Sesudah: "); cetakArray(arr2);
    }
}
