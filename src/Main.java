import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int k=0;

    public static void main(String[] args) throws FileNotFoundException {
        //int[] arr = readArrayFromF("INPUT");
        int[] arr = genRandArray(100);
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        //quickSort(arr, 0, arr.length-1);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(k);
    }

    //сделать функцию, которая создает массив случайных целых чисел
    //диапазона от 0 до 99. Аргумент функции - длина массива
    public static int[] genRandArray(int size)
    {
        int[] ar = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            ar[i] = random.nextInt(100);
        }
        return ar;
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
        quickSort(mas, start, p-1);
        quickSort(mas, p+1, finish);
    }

    private static int partition(int[] mas, int start, int finish) {
        int pivot = mas[start+(finish-start)/2];
        int i=start;
        int j=finish;
        int tmp;
        while (true){
            k++;
            while(i<=finish && mas[i]<pivot )
            {    i++;   k++;}
            k++;
            while (j>=start && mas[j]>pivot )
            {    j--;   k++;}
            if(i<j) {
                if(mas[i] == mas[j])
                    i++;
                else {
                    tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            }
            else
                return j;
        }
    }

}