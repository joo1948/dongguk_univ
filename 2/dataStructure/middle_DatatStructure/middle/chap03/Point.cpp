
#include <stdio.h>
#include <math.h>

typedef struct {
	int x, y;
} Point;


Point p1={1,2};
Point p2={9,8};

double get_distance(Point p1, Point p2){
	double dis = sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	
	return dis;
}

int main(void)
{
	printf("°Å¸®: %f\n", get_distance({1,2}, {9,8}));
	return 0;
}

