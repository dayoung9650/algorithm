//
//  main.cpp
//  baekjoon_13458
//
//  Created by 김다영 on 2018. 11. 27..
//  Copyright © 2018년 김다영. All rights reserved.
//

#include <iostream>
#include<algorithm>
using namespace std;

int student[1000001];
int n, b, c;

int main(int argc, const char * argv[]) {
    
    cin >> n;
    
    for(int i=0; i < n; i++){
        cin >> student[i];
    }
    cin >> b;
    cin >> c;
    
    long long cnt=0;
    for(int i=0;i<n;i++){
        cnt++;
        int sub = (student[i]-b);
        if(sub >= 1){
            cnt += (sub/c);
            if( sub %c != 0) cnt++;
        }
    }
    cout << cnt;
    return 0;
}
