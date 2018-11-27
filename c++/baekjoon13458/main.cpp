//
//  main.cpp
//  baekjoon_13458
//
//  Created by 김다영 on 2018. 11. 27..
//  Copyright © 2018년 김다영. All rights reserved.
//

#include <iostream>
#include<stdio.h>
#include<algorithm>
using namespace std;

int student[1000000];
int n, b, c;

int main(int argc, const char * argv[]) {
    
    scanf("%d ",&n);
    
    for(int i=0; i < n; i++){
        scanf("%d", &student[i]);
    }
    scanf("%d %d", &b, &c);
    
    int cnt=0;
    for(int i=0;i<n;i++){
        cnt++;
        cnt += ((student[i]-b)/c);
        if( (student[i]-b)%c != 0) cnt++;
    }
    printf("%d", cnt);
}
