#include<stdio.h>

void dijkstras();
int c[10][10], n, src;

void main() {
    int i,j;
    
    printf("\nEnter the num of vertices: \t");
    scanf("%d", &n);
    printf("\nEnter the cost matrix: \n");
    for(i = 1; i <= n; i++) {
    for(j = 1; j <= n; j++) {
        scanf("%d", &c[i][j]);
    }
    }
    printf("\nEnter the source node: \t");
    scanf("%d", &src);
    dijkstras();
}

void dijkstras() {
    int vis[10], dist[10], prev[10], u, j, count, min;
    for(j = 1; j <= n; j++) {
        dist[j] = c[src][j];
        prev[j] = src;
    }
    for(j = 1; j <= n; j++) {
        vis[j] = 0;
    }
    dist[src] = 0;
    vis[src] = 1;
    count = 1;
    while(count != n) {
        min = 9999;
        for(j = 1; j <= n; j++) {
            if(dist[j] < min && vis[j] != 1) {
                min = dist[j];
                u = j;
            }
        }
        vis[u] = 1;
        count++;
        for(j = 1; j <= n; j++) {
            if(min + c[u][j] < dist[j] && vis[j] != 1) {
                dist[j] = min + c[u][j];
                prev[j] = u;
            }
        }
    }
    for(j = 1; j <= n; j++) {
        printf("\nThe shortest distance is:: \n");
        printf("%d----->%d = %d", src, j, dist[j]);
        printf("\nThe path is:");
        if(j != src){
            int k = j;
            printf("\n");
            printf("%d<-", j);
            while(prev[k] != src) {
                printf("%d<-", prev[k]);
                k = prev[k];
            }
            printf("%d", src);
            printf("\n");
        }
    }
}
