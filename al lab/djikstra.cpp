include <bits/stdc++.h>
#define INF 9999;
using namespace std;

void djikstra(int cost[10][10],int n,int start) {
    int dist[10],visited[10];
    int i,j,min,u;
    for (i=0;i<n;i++) {
        dist[i]=cost[start][i];
        visited[i]=0;
    }
    dist[start]=0;
    visited[start]=1;
    for(i=0;i<n;i++) {
        min=INF;
        for(j=0;j<n;j++) {
            if(!visited[j] && dist[j]<min) {
                min = visited[j];
                u=j;
            }
        }
        visited[u]=1;
        for (j=0;j<n;j++) {
            if(!visited[j] && dist[u]+cost[u][j] < dist[j]) {
                dist[j] = dist[u]+cost[u][j];
        }
    }
    }
    cout<< "Shortest path \n";
    for (i=0;i<n;i++) {
        cout << "to"<< i << "=" << dist[i]<<endl;
    }
}
int main() {
	// your code goes here
    int cost[10][10];
    int n,start,i,j;
    cout << "enter no of vertices \n";
    cin>> n;
    cout<< "enter cost matrix \n";
    for (i=0;i<n;i++) {
        for (j=0;j<n;j++) {
            cin >> cost[i][j];
        }
    }
    cout << "start\n";
    cin>> start;
    djikstra(cost,n,start);
    return 0;
}
