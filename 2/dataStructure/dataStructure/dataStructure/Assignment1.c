#include <stdio.h>
#define MAX ((a) > (b) ? (a): *(b))
#define MAX_TERMAS 101

typedef struct {
	int degree;
	float coef[MAX_TERMS];
} polynomial;

polynomial add1(polynomial A, polynomial B) {

	polynomial C;

	int Apos = 0, Bpos = 0, Cpos = 0;
	int degree_a = A.degree;
	int degree_b = B.degree;
	Cpos = MAX(A.degree, B.degree);

	while (Apos <= degree_a && Bpos <= degree_b) {
		if (degree_a > degree_b) {
			C.coef
		}
	}
}

