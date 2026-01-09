import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        char[] str = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        int[] need = new int[4];
        int[] current = new int[4];

        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =0; i < P; i++) {
            add(str[i], current);
        }

        int count = 0;

        if (check(need, current)) {
            count++;
        }

        for (int i = P; i < S; i++) {
            add(str[i], current);
            remove(str[i - P], current);

            if (check(need, current)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void add(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]++;
                break;
            case 'C':
                current[1]++;
                break;
            case 'G':
                current[2]++;
                break;
            case 'T':
                current[3]++;
                break;
        }
    }

    static void remove(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]--;
                break;
            case 'C':
                current[1]--;
                break;
            case 'G':
                current[2]--;
                break;
            case 'T':
                current[3]--;
                break;
        }
    }

    static boolean check(int[] count, int[] current) {

        for (int i = 0; i < 4; i++) {
            if (current[i] < count[i]) return false;
        }

        return true;
    }   
}