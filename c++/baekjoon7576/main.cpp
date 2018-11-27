//  baekjoon_7576
//  Created by 김다영 on 2018. 11. 12..
//  Copyright © 2018년 김다영. All rights reserved.
// http://js1jj2sk3.tistory.com/59
// 처음엔 이중포문 돌면서 1인 애들 찾으려함.\
// 하지만 생깍해보면 이증 포문을 돌 필요가 없음 그냥 값이 1인 애들만 저장해서 그 아이의 동서남북 확인하면 됨
// 동서남북이 0이면 큐에 넣고 1이면 continue -1이어도 continue 하면서 큐 진행
// 0이 없어지면 끝남
#include <iostream>
#include<stdio.h>
#include<algorithm>
#include<queue>
using namespace std;

int input[1002][1002];
int n,m;
int x[4] = {0,0,1,-1};
int y[4] = {1,-1,0,0};
int result=1;
int cnt;
struct col{
    int x,y;
};
queue<col> que;
int main(int argc, const char * argv[]) {
    scanf("%d %d", &m,&n);

    for(int i=0; i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d", &input[i][j]);
            if(input[i][j] == 0) cnt++;
            if(input[i][j] == 1) que.push({i,j});
        }
    }
    if(cnt==0) {printf("0"); return 0;}
//    printf("%d ", cnt);
    while(!que.empty()){
        size_t size = que.size();

        for(int i=0;i<size;i++){
            col c1 = que.front();
            que.pop();
            int minus_cnt=0;
            for(int h=0;h<4;h++){
                int xx = c1.x+x[h]  ;
                int yy = c1.y+y[h] ;
                if (xx < 0 || xx >= n || yy< 0 || yy >= m){
                    minus_cnt++;
                    continue;
                }
                if(input[xx][yy] == 0){
                    input[xx][yy] = 1;
                    que.push({xx,yy});
                    cnt--;
                }
                if(minus_cnt==4) {printf("0\n"); return 0;}
                if(cnt==0) {printf("%d\n", result); return 0;}
            }
        }
        result++;
        
    }
    printf("-1\n");
    return 0;
    
}
    
//    테두리 1로 채우는 코드 0번째와 n+1번째 인덱스 채움
//    for(int i=0; i<=n+1;i++){
//        for(int j=0;j<=m+1;j++){
//            if(i == 0 || i == n+1) input[i][j] = -1;
//            if(j == 0 || j == m+1) input[i][j] = -1;
//        }
//    }

//    for(int i=0; i<=n+1;i++){
//        for(int j=0;j<=m+1;j++){
//            printf("%d ", input[i][j]);
//        }
//        printf("\n");
//    }
////    cnt = (n*m)-cnt;
//    printf("%d\n", cnt);
//    while(true){
//        int one_cnt=0;
//        for(int i=1; i<=n;i++){
//            for(int j=1;j<=m;j++){
//                if(input[i][j]==1){
//                    for(int h=0;h<4;h++){
//                        printf("%d %d\n", i+x[h], j+y[h]);
//                        if(input[i+x[h]][j+y[h]] == 0){input[i+x[h]][j+y[h]]=1;}
//                    }
//                }else if(input[i][j]==0){
//                    int minus_cnt=0;
//                    for(int h=0;h<4;h++){
//                        if(input[i+x[h]][j+y[h]] == -1){minus_cnt++;}
//                    }
//                    if(minus_cnt ==4){
//                        printf("ㄴㄴ %d", result);
//                        return 0;
//                    }
//                }else{continue;}
//            }
//        }
//        for(int i=1; i<=n+1;i++){for(int j=1;j<=m+1;j++){if(input[i][j]==1){one_cnt++;}}}
//                printf("%d %d %d\n", one_cnt, cnt, result);
//        if(one_cnt == cnt){
//            printf("break: %d \n", one_cnt);
//            break;
//        }
//        result++;
//    }
//    for(int i=0; i<=n+1;i++){
//        for(int j=0;j<=m+1;j++){
//            printf("%d ", input[i][j]);
//        }
//        printf("\n");
//    }
//    printf("result: %d", result);
//    return 0;
//}
