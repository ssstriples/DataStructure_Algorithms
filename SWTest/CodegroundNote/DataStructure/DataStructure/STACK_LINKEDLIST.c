/*
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<stdbool.h>

struct stack_node {
	int data;
	struct stack_node *next;
};

struct stack {
	struct stack_node *top;
	int sz;
};

void stack_init(struct stack *st) {
	st->sz = 0;
	st->top = 0;
}

int stack_size(struct stack *st) {
	return st->sz;
}

bool stack_empty(struct stack *st) {
	return stack_size(st) == 0;
}

void stack_push(struct stack *st, int val) {
	struct stack_node *newNode = (struct stack_node*)malloc(sizeof(struct stack_node));
	newNode->data = val;
	newNode->next = st->top;
	st->top = newNode;
	st->sz++;
}

void stack_pop(struct stack *st) {
	assert(!stack_empty(st));	//stack이 empty면 프로그램 중단
	struct stack_node *nextHead = st->top->next;
	free(st->top);
	st->top = nextHead;
	st->sz--;
}

int stack_top(struct stack *st) {
	assert(!stack_empty(st));	//stack이 empty면 프로그램 중단
	return st->top->data;
}

int N, val;
char cmd[16];
int main() {

	struct stack st;
	scanf("%d", &N);
	stack_init(&st);
	for (int i = 0; i < N; i++) {
		scanf("%s", cmd);
		if (cmd[0] == 's') {
			printf("%d\n", stack_size(&st));
		}
		else if (cmd[0] == 'p') {
			if (cmd[1] == 'u') {
				scanf("%d", &val);
				stack_push(&st, val);
			}
			else if (cmd[1] == 'o') {
				stack_pop(&st);
			}
		}
		else if (cmd[0] == 't') {
			printf("%d\n", stack_top(&st));
		}
	}

	return 0;
}
*/