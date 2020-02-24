/*
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

struct queue_node {
	int data;
	queue_node* next;
};

struct queue {
	queue_node *front;
	queue_node *rear;
	int sz;
	queue() {
		front = rear = NULL;
		sz = 0;
	}
};

int queue_size(queue& q) {
	return q.sz;
}

bool queue_empty(queue& q) {
	return queue_size(q) == 0;
}

void queue_enqueue(queue& q, int val) {
	queue_node *newNode = (queue_node*)malloc(sizeof(queue_node));
	newNode->data = val;
	newNode->next = 0;
	q.sz++;
	if (q.rear == NULL && q.front == NULL) {
		q.rear = q.front = newNode;
		return;
	}
	q.rear->next = newNode;
	q.rear = newNode;
}

void queue_dequeue(queue& q) {
	assert(!queue_empty(q));	//queue가 empty면 프로그램 중단
	queue_node *nextHead = q.front->next;
	free(q.front);
	if (q.front == q.rear) q.front = q.rear = 0;
	q.front = nextHead;
	q.sz--;
}

int queue_front(queue& q) {
	assert(!queue_empty(q));	//queue가 empty면 프로그램 중단
	return q.front->data;
}

int main() {
	int val;
	queue q;

	for (int i = 0; i < 5; i++) {
		queue_enqueue(q, i);	//input : 0 1 2 3 4
	}
	printf("output : ");
	while (!queue_empty(q)) {
		printf("%d ", queue_front(q));
		queue_dequeue(q);
	}

	return 0;
}
*/