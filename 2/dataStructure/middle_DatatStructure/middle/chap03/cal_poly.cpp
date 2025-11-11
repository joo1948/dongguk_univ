#include <stdio.h>
#define MAX_DEGREE 100
#include <math.h>
typedef struct Polynomial {
    int degree;
    float coef[MAX_DEGREE];
} polynomial;

float evaluate(polynomial p, float x) {
    float result = 0.0;
    int i;

    for (i = p.degree; i >= 0; i--) {
        result += p.coef[i]*(float)pow((double)x, (double)i);
    }

    return result;
}

int main(void)
{
	polynomial a = { 5,{ 3, 6, 0, 0, 0, 10 } };

	
	printf("°ª: %f\n", evaluate(a, 2));
	
	return 0;
}
