import java.util.Scanner;

/* 1-4. 로봇 청소기
1. 문제 링크
	14503. 로봇 청소기
2. 알고리즘 분류
	시뮬레이션
3. 소요 시간
    2시간
    고친시간까지 2시간 반
4. 풀이 결과 (성공, 실패, 제한시간 초과 등)
    테스트케이스는 성공하였으나 제출 시 실패
    됏다..
    벽이랑 청소한 구역을 동일하게 두고 풀었더니 안됨 ㅜㅜ
    그래서 1과 0 과 3 이렇게 나눠서 풀었음
    나머지 테두리는 2로 두고 예외 만들고
    이걸 큐로 만드는 사람도 있도라 리스펙
*/

public class baekjoon_14503 {
    public static void main(String[] args) {

        /*입력*/
        Scanner sc = new Scanner(System.in);

        short n = sc.nextShort();
        short m = sc.nextShort();
        sc.nextLine();
        short r = (short)(sc.nextShort() + 1);
        short c = (short)(sc.nextShort() +1);
        short d = sc.nextShort();
        sc.nextLine();

        short[][] room = new short[n + 2][m + 2];

        for(int i=1; i< n+1; i++) {
            for (int j = 1; j <= m; j++) {
                room[i][j] = sc.nextShort();
            }
            sc.nextLine();
        }

        /*테두리 2로 채움 */
        for (int k = 0; k < n + 2; k++) {
            if (k == 0 || k == n+1) {
                for (int j = 0; j < m + 2; j++) room[k][j] = 2;
            } else {
                room[k][0] = 2;
                room[k][m+1] = 2;
            }
        }
//        for(int i=0;i<n+2;i++){
//            for(int j=0;j<m+2;j++){
//                System.out.print(room[i][j]+ " ");
//            }
//            System.out.println();
//        }

        int cnt = 0;
        while (true) {
            if(room[r][c] == 0) {
                room[r][c] = 3;
                cnt++;
//                System.out.println(r +" " +c);
            }
            /* 3,4 번 케이스 */
            if ((room[r-1][c] !=  0) &
                    (room[r + 1][c] != 0)&
                    (room[r][c-1] != 0)&
                    (room[r][c + 1] != 0)) {
                if (d == 0) {
                    if (room[r+1][c] == 3 ) {r =(short)( r + 1); continue;}
                    else break;
                } else if (d == 1) {
                    if (room[r][c - 1] == 3) {c = (short)(c - 1); continue;}
                    else break;
                } else if (d == 2) {
                    if (room[r - 1][c] == 3) {r = (short)(r - 1); continue;}
                    else break;
                } else {
                    if (room[r][c + 1] == 3) {c = (short)(c + 1); continue;}
                    else break;
                }
            }
            /* 1,2 번 케이스*/
            if (d == 0) {
                d = 3;
                if (room[r][c - 1] == 0) {c = (short)(c - 1); continue;}
                else continue;
            } else if (d == 1) {
                d = 0;
                if (room[r-1][c] == 0) {r = (short)(r -  1); continue;}
                else continue;
            } else if (d == 2) {
                d = 1;
                if (room[r][c+1] == 0){ c = (short)(c + 1); continue;}
                else continue;
            } else if(d ==3){
                d = 2;
                if (room[r + 1][c] ==0 ) {r = (short)(r + 1);continue;}
                else continue;
            }
        }
        System.out.println(cnt);

    }

}