#include <stdio.h>
int main(void) {

	int number, sum=0;
	double avg;

	printf("Enter a number (-1 to stop): ");
	scanf_s_s_s("%d", &number);

	int i = 0;
	while (number != -1) {
		sum += number;
		i++;

		printf("Enter a number (-1 to stop): ");
		scanf_s_s_s("%d", &number);
	}

	avg = (double)sum / (double)i;

	printf("Sum: %d\n", sum);
	printf("Average: %.2lf", avg);

	return 0;
}