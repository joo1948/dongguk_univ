#include <stdio.h>
#include <string.h>



int main() {
	
	char array1[100];
	char array2[50];

	printf("첫 번째 문자열 입력: ");
	if (fgets(array1, sizeof(array1), stdin) != NULL) {
		array1[strcspn(array1, "\n")] = '\0';
	}

	printf("두 번째 문자열 입력 : ");
	if (fgets(array2, sizeof(array2), stdin) != NULL) {
		array2[strcspn(array2, "\n")] = '\0';
	}

	size_t total_length = strlen(array1) + strlen(array2);
	if (total_length < sizeof(array1)) {
		strcat(array1, array2);
	}
	else {
		printf("문자열 결합 시 크기 초과 발생 ! 최대 %zu 바이트  ! ", sizeof(array1) - 1);
		return 1;
	}
	printf("결합된 문자열 : %s\n", array1);
	return 0;
}