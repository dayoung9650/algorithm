import java.util.Scanner;

/* 1-3. 2048문제
1. 문제 링크
    12100. 2048(easy)
2. 알고리즘 분류
	시뮬레이션
3. 소요 시간
    거의 3일..

4. 풀이 결과 (성공, 실패, 제한시간 초과 등)
    실패
*/
public class baekjoon_12100 {
    static short n;
    static int[][] input;
    static int[][] hello;
    static int max = -1;

    public static void main(String[] args) {
        /*입력*/
        Scanner sc = new Scanner(System.in);
        n = sc.nextShort();
        sc.nextLine();

        input = new int[n][n];
        hello = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = sc.nextInt();
                hello[i][j] = input[i][j];
            }
            sc.nextLine();
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(input[i][j]+ " ");
//            }
//            System.out.println();
//        }

        int[] items = {0, 1, 2, 3}; //동서남북
        int[] bucket = new int[5];

        solution(items, bucket, 5);
        System.out.println(max);
    }

    public static void solution(int[] items, int[] bucket, int k) { //중복 조합
        if (k == 0) {
            /* 5번 돌렸다면 가장 큰 수를 이전과 비교 */
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = (input[i][j] >= max) ? input[i][j] : max;
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    input[i][j] = hello[i][j];
                }
            }

//            if(bucket[0] ==2 & bucket[1] == 2 & bucket[2] ==2 & bucket[3]==2& bucket[4]==2){
//                for(int i=0;i<n;i++){
//                    for(int j=0;j<n;j++){
//                        System.out.print("sss " + input[i][j]+ " ");
//                    }
//                    System.out.println();
//                }
//            }
////
            for(int i=0;i<5;i++){
                System.out.print(bucket[i]+ " ");
            }
            System.out.println();
            System.out.println(max);
            return;
        }
        int lastIndex = bucket.length - k - 1; // 가장 최근에 뽑힌 수가 저장된 위치 index

        for (int i = 0; i < items.length; i++) // candidate items
        {
            bucket[lastIndex + 1] = items[i];

            //서쪽이면
            if (items[i] == 1) {
//                System.out.println("서");
                for (int j = 0; j < n; j++) { //행
                    int empty_cnt = 0;
                    for (int w = 0; w < n; w++) { //열
                        if (input[j][w] == 0) {
                            continue;
                        }
                        for (int h = w - 1; h >= 0; h--) {
//                            System.out.println("s: " + w + " " + h);
                            if(w == 0){
                                continue;
                            }
                            if (input[j][h] == 0) {
                                empty_cnt += 1;
                                continue;
                            }
                            if(empty_cnt != 0 && input[j][h] != 0){
                                input[j][w - empty_cnt] = input[j][w];
                                input[j][w] =0;
                                empty_cnt = 0;
//                                w = w - empty_cnt;
//                                break;
                            }
                            if (input[j][h] != input[j][w]) {
                                break;
                            } else {
                                input[j][h] += input[j][h];
                                input[j][w] = 0;
                            }
                        }
                    }
                }
            }
            //동쪽이면
            if(items[i] ==0) {
//                System.out.println("동");
//                for(int u=0;u<n;u++){
//                    for(int j=0;j<n;j++){
//                        System.out.print(input[u][j]+ " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                for (int j = 0; j < n; j++) { //행
                    int empty_cnt = 0;
                    for (int w = n-1; w >=0; w--) { //열
                        if (input[j][w] == 0) {
                            continue;
                        }
//                        System.out.println(" " + j + " " + w);
                        for (int h = w +1; h < n; h++) {
                            if(w == n-1){
//                                System.out.println("0: " +w);
                                continue;
                            }
                            if (input[j][h] == 0) {
//                                System.out.println("a");
                                empty_cnt += 1;
                                continue;
                            }
                            if(empty_cnt != 0 && input[j][h] != 0){
                                input[j][w + empty_cnt] = input[j][w];
                                input[j][w] =0;
                                empty_cnt = 0;
//                                w = w + empty_cnt;
//                                break;
//                                System.out.println("b");
                            }
                            if (input[j][h] != input[j][w]) {
//                                System.out.println("c");
                                break;
                            } else {
//                                System.out.println("d");
                                input[j][h] += input[j][h];

                                input[j][w] = 0;
//                                System.out.println(input[j][w]+ " " + input[j][h]);
                            }
                        }
                    }
                }
            }
            //남
            if(items[i] ==2) {
//                System.out.println("남");

                for (int j = 0; j < n; j++) { //행
                    int empty_cnt = 0;
                    for (int w = n-1; w >=0; w--) { //열
                        if (input[w][j] == 0) {
                            continue;
                        }
                        for (int h = w +1; h < n; h++) {
                            if(w == n-1){
                                continue;
                            }
                            if (input[h][j] == 0) {
                                empty_cnt += 1;
                                continue;
                            }
                            if(empty_cnt != 0 && input[h][j] != 0){
                                input[w + empty_cnt][j] = input[w][j];
                                input[w][j] =0;
                                empty_cnt = 0;
//                                w = w + empty_cnt;
//                                break;
                            }
                            if (input[h][j] != input[w][j]) {
                                break;
                            } else {
                                input[h][j] += input[h][j];
                                input[w][j] = 0;
                            }
                        }
                    }
                }
            }

            //북
            if(items[i] ==3) {
//                System.out.println("북");
//                for(int u=0;u<n;u++){
//                    for(int j=0;j<n;j++){
//                        System.out.print(input[u][j]+ " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                for (int j = 0; j < n; j++) { //행
                    int empty_cnt = 0;
                    for (int w =0; w <n; w++) { //열
                        if (input[w][j] == 0) {
                            continue;
                        }
                        for (int h = w -1; h >= 0; h--) {
                            if(w == 0){
//                                System.out.println("a");
                                continue;
                            }
                            if (input[h][j] == 0) {
//                                System.out.println("b");
                                empty_cnt += 1;
                                continue;
                            }
                            if(empty_cnt != 0 && input[h][j] != 0){
                                input[w - empty_cnt][j] = input[w][j];
                                input[w][j] =0;
                                empty_cnt = 0;
//                                w = w - empty_cnt;
//                                break;
//                                System.out.println("c");
                            }
                            if (input[h][j] != input[w][j]) {
//                                System.out.println("d");
                                break;
                            } else {
                                input[h][j] += input[h][j];
                                input[w][j] = 0;
//                                System.out.println("e");
                            }
                        }
                    }
                }
            }
            solution(items, bucket, k - 1);
        }
    }

}

