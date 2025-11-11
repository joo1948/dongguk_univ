#include <stdio.h>
#include <math.h>

#define MAX_DEGREE 100


typedef struct Poynomial{
	int degree;
	float coef[MAX_DEGREE];
} polynomial;


float evalute(polynomial p, float x) {
	float result = 0.0;
	
	for (int i = p.degree; i >= 0; i--) {
		printf("%d\n", i);
		printf("%f\n", p.coef[i]);
		printf("%f\n", p.coef[i] * (float)pow((double)x, (double)i));
		result += p.coef[i] * (float)pow((double)x, (double)i);
	}

	return result;
}

int main(void) {
	polynomial a = { 5, {3,6,0,0,0,10} };
	printf("°ª : %f", evalute(a, 2));
	return 0;
}