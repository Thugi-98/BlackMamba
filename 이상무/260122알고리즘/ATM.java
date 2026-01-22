import java.io.*;
import java.util.*;


class ATM {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += t[i] * (n - i);
        }

        System.out.println(sum);
    }
}