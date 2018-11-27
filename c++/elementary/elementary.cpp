#include<stdio.h>
#include<iostream>
#include<algorithm>
using namespace std;
//2007 초등부 koi 2번 색종이

int x[201];
int y[201];
int x_pos[201];
int y_pos[201];
int len_x = 1;
int len_y = 1;
int result;

int main(){
    int N = 0;
    int x_input[201] = {0};
    int y_input[201] = {0};
    int cnt=0;
    scanf("%d", &N);

    for(int i=1; i<= N; i++){
        scanf("%d %d", &x[i], &y[i]);
        x_input[i] = x[i];
        y_input[i] = y[i];
        x[i+N] = x[i] + 10;
        y[i+N] = y[i] + 10;
    }
    sort(x, x + 2*N+1);
    sort(y, y + 2*N+1);
    
    for(int i=1;i<=2*N;i++){
        if(x[i] != x[i-1]){
            x_pos[len_x++] = x[i];
        }
        if(y[i] != y[i-1]){
            y_pos[len_y++] = y[i];
        }
    }

    for(int i=0; i<len_x-1; i++){
        for(int j=0; j<len_y-1;j++){
            cnt=0;
            for(int m=1; m<=N; m++){
                if(x_input[m] <= x_pos[i] && x_input[m]+10 >= x_pos[i+1]
                   && y_input[m] <= y_pos[j] && y_input[m]+10  >= y_pos[j+1]){cnt++;}
            }
            if(cnt>=2){
                printf("%d %d %d %d \n ", x_pos[i], x_pos[i+1], y_pos[j], y_pos[j+1]);
                result += (x_pos[i+1]-x_pos[i])*(y_pos[j+1]-y_pos[j]);
                printf("%d \n",result);
            }
        }
    }
    printf("%d", result);
    return 0;
}
