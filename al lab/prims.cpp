#include <bits/stdc++.h>
using namespace std;
#define INF 9999;
void prim(int cost[10][10],int n) {
    int visited[10];
    int i,j,min=0,ne=0,mincost=0,u,v;
    for(i=0;i<n;i++) {
        visited[i]=0;
    }
    visited[0]=1;
    cout << "min spanning tree \n";
    while (ne <n-1) {
        min = INF;
        for(i=0;i<n;i++) {
            if(visited[i]) {
                for (j=0;j<n;j++) {
                    if(!visited[j] && cost[i][j] < min) {
                        min = cost[i][j];
                        u = i;
                        v=j;
                    }
                }
            }
        }
        cout << u << " to " << v <<"=" << min << endl;
        visited[v]=1;
        mincost += min;
        ne++;
    }
    cout << "cost"<< " = " << mincost <<endl;
}
int main() {
	// your code goes here
	int n,i,j;
	int cost[10][10];
    cout << "no of vertices\n";
    cin >> n;
    cout << "matrix \n";
    for (i=0;i<n;i++) {
        for (j=0;j<n;j++) {
            cin >> cost[i][j];
        }
    }
    prim(cost,n);
    return 0;
}
