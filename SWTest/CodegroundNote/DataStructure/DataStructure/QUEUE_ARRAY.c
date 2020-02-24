/*
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<stdbool.h>

struct queue {
	int *data;
	int front, rear;
	int maxsize;
	int size;
};

void queue_init(struct queue *q, int sz) {
	q->maxsize = sz;
	q->front = 0;
	q->rear = 0;
	q->size = 0;
	q->data = (int*)malloc(q->maxsize * sizeof(int));
}

int queue_size(struct queue *q) {
	return q->size;
}

bool queue_empty(struct queue *q) {
	return queue_size(q) == 0;
}

bool queue_full(struct queue *q) {
	return queue_size(q) == q->maxsize;
}

void queue_enqueue(struct queue *q, int val) {
	assert(!queue_full(q));		//queue가 full이면 프로그램 중단
	q->data[q->rear] = val;
	q->rear = (q->rear + 1) % q->maxsize;
	q->size++;
}

void queue_dequeue(struct queue *q) {
	assert(!queue_empty(q));	//queue가 empty면 프로그램 중단
	q->front = (q->front + 1) % q->maxsize;
	q->size--;
}

int queue_front(struct queue *q) {
	assert(!queue_empty(q));	//queue가 empty면 프로그램 중단
	return q->data[q->front];
}

int N, val;
char cmd[16];
int main() {
	
	struct queue q;
	scanf("%d",&N);
	queue_init(&q, N);
	for (int i = 0; i < N; i++) {
		scanf("%s", cmd);
		if (cmd[0] == 's') {
			printf("%d\n",queue_size(&q));
		}
		else if (cmd[0] == 'e') {
			scanf("%d", &val);
			queue_enqueue(&q, val);
		}
		else if (cmd[0] == 'd') {
			queue_dequeue(&q);
		}
		else if (cmd[0] == 'f') {
			printf("%d\n",queue_front(&q));
		}
	}

	return 0;
}
*/