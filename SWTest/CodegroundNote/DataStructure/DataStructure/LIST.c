/*
#include<stdio.h>
#include<stdlib.h>


typedef struct node {
	struct node* next;
	int value;
}node;

typedef struct list {
	node* head;
	node* last;
	int size;
}list;

void init_list(list* mylist);
void push_back(list* mylist, int value);
int get_idx(list* mylist, int idx);
int count_target(list* mylist, int target);
void clear_list(list* mylist);
void free_node(node* current_node);

int main() {
	
	int n;
	scanf("%d", &n);

	list mylist;
	init_list(&mylist);
	while(n--){
		char command[10];
		scanf("%s",command);
		
		//push, get, size, count, clear
		if (command[0] == 'p') {
			int value;
			scanf("%d", &value);
			push_back(&mylist, value);
		}else if (command[0] == 'g') {
			int idx;
			scanf("%d", &idx);
			printf("%d\n", get_idx(&mylist, idx));
		}else if (command[0] == 's') {
			printf("%d\n",mylist.size);
		}else if (command[1] == 'o') {
			int target;
			scanf("%d",&target);
			printf("%d\n",count_target(&mylist, target));
		}else {
			clear_list(&mylist);
		}
	}

	return 0;
}


void init_list(list* mylist) {
	mylist->head = (node*)malloc(sizeof(node));
	mylist->head->next = NULL;
	mylist->last = mylist->head;
	mylist->size = 0;
}

void push_back(list* mylist, int value) {
	node* new_node = (node*)malloc(sizeof(node));
	new_node->value = value;
	new_node->next = NULL;
	mylist->last->next = new_node;
	mylist->last = new_node;
	mylist->size++;
}

int get_idx(list* mylist, int idx) {
	node* pre_node = mylist->head;
	while (idx--) {
		pre_node = pre_node->next;
	}
	return pre_node->next->value;
}

int count_target(list* mylist, int target) {
	int count = 0;
	for (node* pre_node = mylist->head; pre_node->next != NULL; pre_node = pre_node->next) {
		if (pre_node->next->value == target)
			count++;
	}
	return count;
}

void clear_list(list* mylist) {
	free_node(mylist->head);
	init_list(mylist);
}

void free_node(node* current_node) {
	if (current_node->next != NULL) {
		free_node(current_node->next);
	}
	free(current_node);
}
*/