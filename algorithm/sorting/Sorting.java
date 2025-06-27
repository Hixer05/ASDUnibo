package algorithm.sorting;
import java.lang.reflect.Array;
import java.util.Random;

/**
* This class contains various sorting algorithms
*/
public class Sorting {

	/**
	* Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(n<sup>2</sup>)
	* <p>
	* Implements the selectionsort algorithm.
	* <ul>
	* <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	* </ul>
	* @param A the array to be sorted
	* @param <T> class of the object in the array
	*/
	public static <T extends Comparable<T>> void selectionsort(T A[]) {
		// T n = A[A.length-1];
		for(int i = 0; i < A.length; i++){
			int min = i;
			for (int j = i; j<A.length; j++){
				if(A[j].compareTo(A[min]) < 0)
					min = j;
			}
			if (A[min].compareTo(A[i])!=0) {
				swap(A, i, min);
			}
		}
	}

	/**
	* Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	* <p>
	* Implements the selectionsort algorithm.
	* <ul>
	* <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	* </ul>
	* @param A the array to be sorted
	*/
	public static void selectionsort(int A[]) {
		for (int i = 0; i < A.length; i++) {
			int min = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[min])
					min = j;
			}
			if (A[min] != A[i]) {
				swap(A, i, min);
			}
		}
	}

	/**
	* Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>)
	* <p>
	* Implements the insertionsort algorithm.
	* <ul>
	* <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	* <li> Best-case cost: &Theta;(n)
	* </ul>
	* @param A the array to be sorted
	* @param <T> class of the object in the array
	*/
	public static <T extends Comparable<T>> void insertionsort(T A[]) {
		for(int i = 0; i<A.length; i++){
			for (int j = i; j>0; j--){
				if(A[j].compareTo(A[j-1])<0){
					swap(A,j,j-1);
				}else{
					break;
				}
			}
		}
	}

	/**
	* Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	* <p>
	* Implements the insertionsort algorithm.
	* <ul>
	* <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	* <li> Best-case cost: &Theta;(n)
	* </ul>
	* @param A the array to be sorted
	*/
	public static void insertionsort(int A[]) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] < A[j-1]) {
					swap(A, j, j-1);
				} else {
					break;
				}
			}
		}
	}

	/**
	* Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	* <P>
	* Implements the mergesort algorithm.
	* <ul>
	* <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	* </ul>
	* @param A the array to be sorted
	* @param <T> class of the object in the array
	*/
	public static <T extends Comparable<T>> void mergesort(T A[]) {
		mergesort(A, 0, A.length-1);
	}
	private static <T extends Comparable<T>> void mergesort(T A[], int p, int r){
		if (p<r){
			int q = (int) Math.floor(p+((r-p)/2)); //equiv to (p+r)/2
			mergesort(A, p, q);
			mergesort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	private static <T extends Comparable<T>> void merge(T A[], int p, int q, int r) {
		int i = p;
		int j = q+1;
		@SuppressWarnings("unchecked")
		T[] B = (T[]) Array.newInstance(A.getClass().getComponentType(), r-p+1);

		int k = 0;
		while(i<=q && j<=r){
			if (A[i].compareTo(A[j])<0){
				B[k] = A[i];
				i++;
			}
			else{
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while(i<=q)
			B[k++] = A[i++];

		while(j<=r)
			B[k++] = A[j++];

		for(int t = p; t<=r; t++){
			A[t] = B[t-p];
		}
	}

	/**
	* Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	* <p>
	* Implements the mergesort algorithm.
	* <ul>
	* <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	* </ul>
	* @param A the array to be sorted
	*/
	public static void mergesort(int A[]) {
		mergesort(A, 0, A.length-1);
	}
	private static void mergesort(int A[], int p, int r) {
		if (p < r) {
			int q = (int) Math.floor(p + ((r - p) / 2));
			mergesort(A, p, q);
			mergesort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	private static void merge(int A[], int p, int q, int r) {
		int i = p;
		int j = q+1;
		int[] B = new int[(r-p)+1];
		int k = 0;
		while(i<=q && j<=r){
			if (A[i]<A[j]){
				B[k] = A[i];
				i++;
			}
			else{
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while(i<=q)
			B[k++] = A[i++];

		while(j<=r)
			B[k++] = A[j++];

		for(int t = p; t<=r; t++){
			A[t] = B[t-p];
		}
	}
	/**
	* Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>) and O(nlogn) on the average
	* <p>
	* Implements the quicksort algorithm.
	* <ul>
	* <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	* <li> Average/Best-case cost: &Theta;(nlogn)
	* </ul>
	* @param A the array to be sorted
	* @param <T> class of the object in the array
	*/
	public static <T extends Comparable<T>> void quicksort(T A[]) {
		quicksort(A, 0, A.length-1);
	}

	public static <T extends Comparable<T>> void quicksort(T A[], int p, int r) {
		if (p<r){
			int q = partition(A, p, r);
			quicksort(A, p, q-1);
			quicksort(A, q+1, r);
		}
	}

	private static <T extends Comparable<T>> int partition(T A[], int p, int r){
		T pivot = A[r]; // deterministic, TODO random
		int i = p;
		for(int j = p; j<r; j++){
			if (A[j].compareTo(pivot)<0){
				swap(A, j, i);
				i++;
			}
		}
		swap(A,r, i);
		return i;
	}
	/**
	* Sorts the specified array into ascending numerical order in O(n<sup>2</sup>) and O(nlogn) on the average
	* <p>
	* Implements the quicksort algorithm.
	* <ul>
	* <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	* <li> Average/Best-case cost: &Theta;(nlogn)
	* </ul>
	* @param A the array to be sorted
	*/
	public static void quicksort(int A[]) {
		quicksort(A, 0, A.length - 1);
	}
	private static void quicksort(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}
	private static int partition(int A[], int p, int r) {
		int pivot = A[r]; //deterministic, TODO random
		int i = p;
		for (int j = p; j < r; j++) {
			if (A[j] < pivot) {
				swap(A, j, i);
				i++;
			}
		}
		swap(A, r, i);
		return i;
	}

	/**
	* Sorts the specified array into ascending numerical order in &Theta;(n+k)
	* <p>
	* Implements the countingsort algrithm.
	* <ul>
	* <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	* </ul>
	* @param A the array to be sorted
	*/
	public static void countingsort(int A[]) {
	}

	/**
	* Sorts the specified array according to the ordering induced by the compareTo() method in O(n log n)
	* using the heapsort algorithm.
	* <ul>
	* <li> Worst-case: &Theta;(n log n)
	* <li> Best-case: &Theta;(n)
	* </ul>
	* @param A the array to be sorted
	* @param <T> class of the object in the array
	*/
	public static <T extends Comparable<T>> void heapsort(T A[]) {
		heapify(A, A.length - 1, 0);
		for (int c = (A.length - 1); c > 0; c--) {
			T k = findmax(A);
			deletemax(A, c);
			A[c] = k;
		}
	}

	/**
	* Transforms the array A with n elements in an arrayheap.
	* It proceeds recursively by fist creating sub arrayheaps rooted at index i
	*/
	private static <T extends Comparable<T>> void heapify(T A[], int n, int i) {
		if (i >= n) return;
		heapify(A, n, left(i));
		heapify(A, n, right(i));
		fixheap(A, n, i);
	}

	/**
	* Returns the index of the left son
	*/
	private static int left(int i) {
		return ( 2*i + 1 );
	}

	/**
	* Returns the index of the right son
	*/
	private static int right(int i) {
		return ( 2*i + 2 );
	}

	/**
	* Fix the sub arrayheap rooted at position i of a the arrayheap A of length c,
	* assuming only the root can be ill-placed
	*/
	private static <T extends Comparable<T>> void fixheap(T A[], int c, int i) {
		int l = left(i), r = right(i);
		if (l > c) return;
		int max = l;
		if (r <= c && A[l].compareTo(A[r]) < 0)
			max = r;
		if (A[i].compareTo(A[max]) < 0) {
			swap(A, i, max);
			fixheap(A, c, max);
		}
	}

	/**
	* Returns the maximal element from an arrayheap A
	*/
	private static <T> T findmax(T A[]) {
		return A[0];
	}

	/**
	* Removes the maximal element in an arrayheap A of length c
	*/
	private static <T extends Comparable<T>> void deletemax(T A[], int c) {
		if (c <= 0) return;
		A[0] = A[c];
		c--;
		fixheap(A, c, 0);
	}

	/**
	* Swaps the two elements in positions i and j in the array A
	*/
	private static <T> void swap(T A[], int i, int j) {
		T tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	private static <T> void swap(int A[], int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args){
		Integer[] A = new Integer[500000];
		Random rand = new Random();

		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(5000); // Fills with any int value
		}

		System.out.println("Sorting now...");
		Sorting.selectionsort(A);
		System.out.println("Sorted.");
	}
}

