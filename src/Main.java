import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = readArrayFromF("array.txt");
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] readArrayFromF(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        int n = scan.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        return mas;
    }

    private static void quickSort(int[] mas, int start, int finish){
        if(start>=finish)
            return;
        int p = partition(mas, start, finish);
        quickSort(mas, start, p);
        quickSort(mas, p+1, finish);
    }

    private static int partition(int[] mas, int start, int finish) {
        int pivot = mas[start+(finish-start)/2];
        int i=start;
        int j=finish;
        int tmp;
        while (true){
            while(i<=finish && mas[i]<pivot )
                i++;
            while (j>=start && mas[j]>pivot )
                j--;
            if(i<j) {
                tmp = mas[i];
                mas[i] = mas[j];
                mas[j] = tmp;
            }
            else
                return j;
        }
    }

}