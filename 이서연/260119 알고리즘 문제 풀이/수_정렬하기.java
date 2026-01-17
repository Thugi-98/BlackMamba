import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 수_정렬하기 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        
        int[] arr = new int[total];
        for(int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < total; i++) {
            result.append(arr[i]).append("\n");
        }

        System.out.println(result);
    }
}