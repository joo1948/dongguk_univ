#include <stdio.h>

int is_triangle(int n1, int n2, int n3) {
	int result = 0;

	int cnt = 0;
	
	if (n1 + n2 > n3 && n1 + n3 > n2 && n2 + n3 > n1) {
		return 1;
	}
	else {
		return 0;
	}
}

void triangle_type() {

	int n1 = 0;
	int n2 = 0;
	int n3 = 0;

	printf("세 변의 길이를 입력하세요: ");
	scanf_s_s_s("%d %d %d", &n1, &n2, &n3);

	if (!is_triangle(n1, n2, n3)) {
		printf("삼각형을 만들 수 없습니다.\n");
		return;
	}


	if (n1 == n2 && n2 == n3) {
		printf("삼각형 가능: 정삼각형\n");
	}
	else if (n1 == n2 || n2 == n3 || n1==n3 ) {
		printf("삼각형 가능: 이등변삼각형\n");
	}
	else {
		printf("삼각형 가능: 삼각형\n");
	}
}

int main(void) {

	triangle_type();
	
	return 0;
}