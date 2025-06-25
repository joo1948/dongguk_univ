#include <stdio.h>


int main() {

	//파일 열기
	FILE* fp = fopen("C:\\Users\\jooyo\\Desktop\\hi.txt", "r");
	char text[100];
	if (fp == NULL) {
		printf("파일 열기 실패\n");
	}

	while(fgets(text,sizeof(text), fp) != NULL){

	
		printf("%s\n", text);
	
	}

	fclose(fp);

	return 0;
}