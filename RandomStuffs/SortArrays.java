package RandomStuffs;
public class SortArrays {
    public static void main(String[] args) {
        int[] arr = { 23,54,67,32,55,11,23,54};
        Sort sort = new Sort();
        Search search = new Search();

        System.out.println(search.linearSearch(arr, 67));
        System.out.println(search.binarySearch(arr, 67));
        sort.countSort(arr);
        System.out.println(search.linearSearch(arr, 67));
        System.out.println(search.binarySearch(arr, 67));
    }
}
