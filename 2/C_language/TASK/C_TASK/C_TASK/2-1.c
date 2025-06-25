#include <stdio.h>

int main(void) {

	int number;


	printf("Enter a number (2-9): ");
	scanf_s_s_s("%d", &number);

	while (number < 2 || number > 9) {
		printf("Enter a number (2-9): ");
		scanf_s_s_s("%d", &number);
	}

	for (int i = 1; i < 10; i++) {
		printf("%d x %d = %d\n", number, i, number * i);
	}

	return 0;

}