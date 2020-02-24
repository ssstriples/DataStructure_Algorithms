/*
#include<stack>
#include<iostream>
#include<string>

using namespace std;

int N, val;
string cmd;
int main() {
	stack<int> st;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> cmd;
		if (cmd[0] == 's') {
			cout << st.size() << endl;
		}
		else if (cmd[0] == 'p') {
			if (cmd[1] == 'u') {
				cin >> val;
				st.push(val);
			}
			else if (cmd[1] == 'o') {
				st.pop();
			}
		}
		else if (cmd[0] == 't') {
			cout << st.top() << endl;
		}
	}

	return 0;
}
*/