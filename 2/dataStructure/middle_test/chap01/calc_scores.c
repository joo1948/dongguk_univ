#define MAX_ELEMENTS 100
int scores[MAX_ELEMENTS];	// 占쌘료구占쏙옙

int get_max_score(int n) 	// 占싻삼옙占쏙옙 占쏙옙占쌘댐옙 n
{
	int i, largest;
	largest = scores[0];	// 占싯곤옙占쏙옙占쏙옙
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
