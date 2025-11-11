//Èñ¼ÒÇà·Ä
#include <stdio.h>
typedef struct {
	int row;
	int col;
	int value;

}element;

typedef struct SpareMatrix {
	element data[MAX_TERMS];
	int rows;
	int cols;
	int terms;

}SparseMatrix;

