#include <stdio.h>
#include <math.h>

//점을 나타내는 두개의 구조체 변수를 받아서 점 사이의 거리를 계산하는 함수 get_distance(Point p1, Point p2)를 작성해보자.

typedef struct {
    int x, y;

} Point;

Point p1 = { 1,2 };
Point p2 = { 9,8 };

double get_distance(Point p1, Point p2) {
    double distance = sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    double distance_power = sqrt(pow(p1.x-p2.x,2) + pow(p1.y - p2.y,2));
        return distance_power;
}

int main(void) {

    printf("점과 점사이의 거리 :: %f\n", get_distance(p1, p2));


    return 0;
}