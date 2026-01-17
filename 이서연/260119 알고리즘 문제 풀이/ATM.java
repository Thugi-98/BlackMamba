import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class ATM {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] duration = new int[num];
        for (int i = 0; i < num; i++) {
            duration[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(duration);

        // 합 계산
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum += duration[i] * (num - i);
        }

        System.out.println(sum);
    }
}