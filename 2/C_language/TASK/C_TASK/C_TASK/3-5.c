#include <stdio.h>
int main(void) {
	//TODO - 다시 확인하기
	int n1 = 0;
	int n2 = 0;
	int n3 = 0;
	int result = 0;
	printf("세 개의 정수를 입력하세요.: ");
	scanf_s_s_s("%d %d %d", &n1, &n2, &n3);

	if (n1 < n2) {
		if (n3 < n1) result = n3;
		else if (n3 < n2) result = n1;
		else result = n1;
	
	}
	else {//n1> n2
		if (n1 < n3) result = n2;
		else if (n3 < n2) result = n3;
		else result = n2;
	}

	if (result % 2 == 0) printf("가장 작은 수는 %d이고, 짝수입니다.\n", result);
	else printf("가장 작은 수는 %d이고, 홀수입니다.\n", result);
	


	return 0;
}