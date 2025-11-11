#include <stdio.h>

#define MAX_ELEMENTS 100
int scores[MAX_ELEMENTS];	// �ڷᱸ��

int get_max_score(int n) 	// �л��� ���ڴ� n
{
	int i, largest;
	largest = scores[0];	// �˰�����
	for (i = 1; i<n; i++) {
		if (scores[i] > largest) {
			largest = scores[i];
		}
	}
	return largest;
}

int main() {
 	int score[5] ={1,2,3,4,5};
 	int max;
 	max = get_max_score(score);
 	printf("%d",max);
 	
 	return 0;
} 
