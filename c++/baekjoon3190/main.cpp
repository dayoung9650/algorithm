// 뱀
//  main.cpp
//  baekjoon3190
#include <iostream>
#include<stdio.h>
#include<algorithm>
#include<stack>
using namespace std;

int sec;
int map[101][101] ={0};
int n,k,L,x;
char c;

int main(int argc, const char * argv[]) {
    
    scanf("%d", &n);
    scanf("%d", &k);
    for(int i=0;i<k; i++){//사과
        int x,y=0;
        scanf("%d %d",&x,&y);
        map[x][y] =1;
    }
    scanf("%d", &L);
    
    while(true){
        sec++;
        
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(map[i][j] == 1){
                
            }else{
                
            }
        }
    }
    
    
    return 0;
}
