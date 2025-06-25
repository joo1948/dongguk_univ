#include <stdio.h>
int main(void) {

	int number;
	double mul=1;

	printf("Enter a number: ");
	scanf_s_s_s("%d", &number);

	// 5! = 1*2*3*4*5

	for (int i = 1; i <= number; i++) {
		mul *= i;
	}

	printf("%.lf", mul);

	return 0;
}