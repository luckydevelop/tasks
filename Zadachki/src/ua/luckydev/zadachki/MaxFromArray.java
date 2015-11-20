package ua.luckydev.zadachki;

/**
 * Created by Lucky on 22.09.2015.
 */
public class MaxFromArray
{
    public static void main(String[] args)
    {
       // 1 2 3 4 5 6 5 4 3 2 1
        int arr[] = {1, 30, 40, 50, 60, 70, 23, 20};
        int max = findMaximum(arr, 0, 7);
        System.out.println(max);
    }
    static int findMaximum(int arr[], int low, int high)
    {
       // if (low == high) return arr[low];
        if ((high == low + 1) && arr[low] >= arr[high]) return arr[low];
        if ((high == low + 1) && arr[low] < arr[high])  return arr[high];
        int mid = (low + high)/2;
        if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])  return arr[mid];
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])  return findMaximum(arr, low, mid-1);
        else   return findMaximum(arr, mid + 1, high);
    }
}
