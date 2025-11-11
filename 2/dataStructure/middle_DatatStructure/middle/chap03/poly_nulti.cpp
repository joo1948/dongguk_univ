#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX_TERMS 100

typedef struct {
    float coef;
    int exponX, exponY;
} term;

term A[MAX_TERMS];
term B[MAX_TERMS];
term product[MAX_TERMS * MAX_TERMS];
int a_terms = 0, b_terms = 0, p_terms = 0;

void addTerm(term *poly, int *n, float coef, int exponX, int exponY) {
    for (int i = 0; i < *n; i++) {
        if (poly[i].exponX == exponX && poly[i].exponY == exponY) {
            poly[i].coef += coef;
            if(poly[i].coef == 0) { // If the coefficient becomes 0, remove the term
                for(int j = i; j < *n - 1; j++) {
                    poly[j] = poly[j + 1];
                }
                (*n)--;
            }
            return;
        }
    }
    poly[*n].coef = coef;
    poly[*n].exponX = exponX;
    poly[*n].exponY = exponY;
    (*n)++;
}

void multiplyPolynomials() {
    for (int i = 0; i < a_terms; i++) {
        for (int j = 0; j < b_terms; j++) {
            float coef = A[i].coef * B[j].coef;
            int exponX = A[i].exponX + B[j].exponX;
            int exponY = A[i].exponY + B[j].exponY;
            addTerm(product, &p_terms, coef, exponX, exponY);
        }
    }
}

void printPolynomial(term *poly, int n) {
    if (n == 0) {
        printf("0\n");
        return;
    }
    for (int i = 0; i < n; i++) {
        if (i > 0) { // 첫 항이 아닌 경우
            if (poly[i].coef < 0) printf(" - ");
            else printf(" + ");
        } else { // 첫 항인 경우
            if (poly[i].coef < 0) printf("-");
        }
        
        if (poly[i].exponX == 0 && poly[i].exponY == 0) { // 상수항 처리
            printf("%.2f", fabs(poly[i].coef));
        } else { // 상수항이 아닌 경우
            if (fabs(poly[i].coef) != 1) printf("%.2f", fabs(poly[i].coef)); // 계수가 1이 아닐 경우에만 계수 출력
            if (poly[i].exponX > 0) printf("x^%d", poly[i].exponX); // x 변수 처리
            if (poly[i].exponY > 0) printf("y^%d", poly[i].exponY); // y 변수 처리
        }
    }
    printf("\n");
}
int main() {
    // Initialize polynomial A: 3y^7 + 4x^4 - 1
    addTerm(A, &a_terms, 3, 0, 7);  // 3y^7
    addTerm(A, &a_terms, 4, 4, 0);  // 4x^4
    addTerm(A, &a_terms, -1, 0, 0); // -1 (constant term)

    // Initialize polynomial B: 5x^4 - 3y^2 + 7
    addTerm(B, &b_terms, 5, 4, 0);  // 5x^4
    addTerm(B, &b_terms, -3, 0, 2); // -3y^2
    addTerm(B, &b_terms, 7, 0, 0);  // 7 (constant term)

    // Multiply polynomials
    multiplyPolynomials();

    // Print result
    printf("Product: ");
    printPolynomial(product, p_terms);

    return 0;
}
