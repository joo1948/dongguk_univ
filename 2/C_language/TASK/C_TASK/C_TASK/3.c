#include <stdio.h>
int main(void) {

	int price, VIP, fee, total;// VIP는 1인 경우
	
	printf("Enter food cost: ");
	scanf_s_s_s("%d", &price);

	printf("Enter VIP status (0 or 1): ");
	scanf_s_s_s("%d", &VIP);


	if (VIP) {
		fee = 0;
	}
	else if (price <= 15000) {
		fee = 3000;
	}
	else if (price > 15000) {
		fee = 1000;
	}

	total = price + fee;
	
	printf("\n");
	printf("Totla cost: %d", total);

	return 0;
}