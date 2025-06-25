#include <stdio.h>

void ejinsu(int n) {
	if (n > 1) ejinsu(n / 2);
	printf("%d", n % 2);
}

int pac(int n) {
	if (n <= 1) return 1;
	else return n * pac(n - 1);
}

int fivo(int n) {
	if (n < 2) return n;
	else return fivo(n - 1) + fivo(n - 2);
}

long power(int base, int exp) {
	if (exp == 0) return 1;
	else if (exp == 1) return base;
	else return base * power(base, exp - 1);
}

int main(void) {



	int a = 1, b = 2;
	float result;

	result = a * b;
	printf("%f\n", result);



}