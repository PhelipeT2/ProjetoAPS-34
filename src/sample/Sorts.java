package sample;

public class Sorts {

    public static class Sort {

        public int[] shellSort(int arr[]) {
            int n = arr.length;

            // Start with a big gap, then reduce the gap
            for (int gap = n / 2; gap > 0; gap /= 2) {
                // Do a gapped insertion sort for this gap size.
                // The first gap elements a[0..gap-1] are already
                // in gapped order keep adding one more element
                // until the entire array is gap sorted
                for (int i = gap; i < n; i += 1) {
                    // add a[i] to the elements that have been gap
                    // sorted save a[i] in temp and make a hole at
                    // position i
                    int temp = arr[i];

                    // shift earlier gap-sorted elements up until
                    // the correct location for a[i] is found
                    int j;
                    for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                        arr[j] = arr[j - gap];

                    // put temp (the original a[i]) in its correct
                    // location
                    arr[j] = temp;
                }
            }
            return arr;
        }

        public int[] bogoSort(int[] a) {
            // if array is not sorted then shuffle the
            // array again
            while (bogoIsSorted(a) == false)
                bogoShuffle(a);
            return a;
        }

        // To generate permuatation of the array
        void bogoShuffle(int[] a) {
            // Math.random() returns a double positive
            // value, greater than or equal to 0.0 and
            // less than 1.0.
            int n = 0;
            for (int i = 1; i <= n; i++)
                bogoSwap(a, i, (int) (Math.random() * i));
        }

        // Swapping 2 elements
        void bogoSwap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // To check if array is sorted or not
        boolean bogoIsSorted(int[] a) {
            for (int i = 1; i < a.length; i++)
                if (a[i] < a[i - 1])
                    return false;
            return true;
        }

        public int[] InserionSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
            return arr;
        }

        public int[] HeapSort(int[] arr, int i, int i1) {
            int n = arr.length;

            // Build heap (rearrange array)
            for (i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            // One by one extract an element from heap
            for (i = n - 1; i >= 0; i--) {
                // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // call max heapify on the reduced heap
                heapify(arr, i, 0);
            }
            return arr;
        }

        public int[] BubbleSort(int[] vet) {
            int aux;
            int i;
            for (i = 0; i < vet.length - 1; i++) {
                for (int j = 0; j < vet.length - i - 1; j++) {
                    if (vet[j] > vet[j + 1]) {
                        aux = vet[j];
                        vet[j] = vet[j + 1];
                        vet[j + 1] = aux;
                    }
                }
            }
            return vet;
        }

        public int[] SelectionSort(int[] arr) {
            int n = arr.length;

            // One by one move boundary of unsorted subarray
            for (int i = 0; i < n - 1; i++) {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i + 1; j < n; j++)
                    if (arr[j] < arr[min_idx])
                        min_idx = j;

                // Swap the found minimum element with the first
                // element
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
            return arr;
        }

        public int[] MergeSort(int[] vetor) {
            return MergeSortsort(vetor, 0, vetor.length - 1);
        }

        public int[] QuickSort(int[] vetor) {
            return QuickSortsort(vetor, 0, vetor.length - 1);
        }

        public int[] HeapSort(int[] vetor) {
            return HeapSort(vetor, 0, vetor.length - 1);
        }
    }

    static int[] MergeSortsort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            MergeSortsort(arr, l, m);
            MergeSortsort(arr, m + 1, r);

            // Merge the sorted halves
            MergeSortmerge(arr, l, m, r);
        }
        return arr;
    }

    static void MergeSortmerge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static int[] QuickSortsort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = QuickSortpartition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            QuickSortsort(arr, low, pi - 1);
            QuickSortsort(arr, pi + 1, high);
        }
        return arr;
    }

    static int QuickSortpartition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

enum sortingAlgorithm {
    shellSort, bogoSort, InsertionSort, HeapSort, BubbleSort, SelectionSort, MergeSort, QuickSort;
}
