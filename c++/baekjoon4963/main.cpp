//
//  main.cpp
//  baekjoon4963
//
//  Created by 김다영 on 2018. 12. 4..
//  Copyright © 2018년 김다영. All rights reserved.
// https://www.acmicpc.net/problem/4963

#include <iostream>
#include<algorithm>
using namespace std;
int n,m;
int input[51][51];

int main(int argc, const char * argv[]) {
    // insert code here...
    
    while(true){
        cin >> n,m;
        if(n ==0 && m==0)
            return 0;
        
        for(int i =0; i<n;i++){
            for(int j=0;j<m;j++){
                cin >> input[i][j];
            }
        }
    }

    
    return 0;
}
