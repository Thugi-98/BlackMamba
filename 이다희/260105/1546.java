import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] score = new int[N];

        double M = 0;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt(); 
            if (M < score[i]) {
                M = score[i];
            }
        }

        for (int i = 0; i < N; i++) {
            sum = sum + score[i] / M * 100;
        }

        System.out.print(sum / N);
        
        sc.close();
    }
}