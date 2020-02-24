/*
#include<stdio.h>

#define MAX 5005

int heap[MAX];

void swap(int* a, int* b) {
	int t = *a;
	*a = *b;
	*b = t;
}

int main() {

	int n;

	scanf("%d",&n);

	for (int i = 1; i <= n; i++) {
		int m;

		scanf("%d",&m);
		heap[i] = m;

		for (int j = i; j > 1; j /= 2) {
			if (heap[j] > heap[j / 2]) {
				swap(&heap[j],&heap[j/2]);
			}
		}
	}
	
	for (int i = 1; i <= n; i++) {
		swap(&heap[1], &heap[n - i + 1]);

		for (int j = 1;;) {
			int k = j * 2;

			if (k > n - i) break;

			if (k + 1 <= n - i && heap[k] < heap[k + 1]) k++;

			if (heap[j] < heap[k]) {
				swap(&heap[j], &heap[k]);
				j = k;
			}
			else break;
		}
	}

	for (int i = 1; i <= n; i++)
		printf("%d ",heap[i]);

	return 0;
}
*/