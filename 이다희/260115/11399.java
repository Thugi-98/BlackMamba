import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += time[i] * (N - i);
        }

        System.out.println(sum);
    }
}