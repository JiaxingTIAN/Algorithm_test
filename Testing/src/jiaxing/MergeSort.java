package jiaxing;

public class MergeSort {
	int[] array;
	
	
	public MergeSort(int[] array){
		this.array = array;
	}
	

	//Recursive top down approach
	public void mergeSort(int low, int high){
		if(low>=high) return;
		
		int mid = (low + high)/2;
		mergeSort(low, mid);
		mergeSort(mid+1, high);
		merge(low, mid, high);
		
	}
	
	public void merge(int low, int mid, int high){
		int[] tmp = new int[array.length];
		int i = 0;
		int highPtr = mid + 1;
		int lowPtr = low;
		
		while(lowPtr <= mid && highPtr <= high){
			if(array[lowPtr]<array[highPtr])
				tmp[i++] = array[lowPtr++];
			else
				tmp[i++] = array[highPtr++];
			
		}
		while(lowPtr<=mid)
			tmp[i++] = array[lowPtr++];
		while(highPtr<=high)
			tmp[i++] = array[highPtr++];
		
		for(int n:tmp)
			array[low++] = n;
		
	}
	
	public void quickSort(int low, int high){
		if(low>=high) return;
		int pivot = array[high];
		int i = low;
		int j = high;
		while(i<j){
			
			if(array[i++]>pivot) swap(--i, --j);
			
		}
		swap(i,high);
		quickSort(low,i-1);
		quickSort(i+1,high);
	}
	
	public void swap(int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
