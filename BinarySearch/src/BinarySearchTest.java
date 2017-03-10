
public class BinarySearchTest {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 11, 23, 55, 80, 81, 82, 100, 111 };
		BinarySearchTest b = new BinarySearchTest();
		int idx = b.binarySearch(arr, 82);
		
		//System.out.println(arr[idx] + " is located in " + idx);
		System.out.println(idx);
	}
	
	public int binarySearch(int[] arr, int value) {
		int arrSize = arr.length;
		int low=0, high=arrSize-1, mid;
		
		while(low <= high) {
			mid = (low+high) / 2;
			System.out.println("low : " + arr[low] + " high : " + arr[high] + " mid : " + arr[mid]);
			
			if(arr[mid] > value) {
				high = mid-1;
			} else if(arr[mid] < value) {
				low = mid+1;
			} else {
				return mid;
			}		
		}
		
		return -1;
	}
}
