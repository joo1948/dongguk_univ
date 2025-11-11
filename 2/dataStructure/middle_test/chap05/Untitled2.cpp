#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_STACK_SIZE 100

typedef struct {
    char stack[MAX_STACK_SIZE];
    int top;
} StackType;

// 스택 초기화 함수
void init(StackType* s) {
    s->top = -1;
}

// 공백 상태 검출 함수
int is_empty(StackType* s) {
    return (s->top == -1);
}

// 포화 상태 검출 함수
int is_full(StackType* s) {
    return (s->top == (MAX_STACK_SIZE - 1));
}

// 삽입함수
void push(StackType* s, char item) {
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        exit(1);
    }
    else
        s->stack[++(s->top)] = item;
}

// 삭제함수
char pop(StackType* s) {
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    else
        return s->stack[(s->top)--];
}

int palindrome(char in_str[]) {
    StackType s;
    int i;
    char ch, chs;
    int len = strlen(in_str);

    init(&s);
    for (i = 0; i < len; i++) {
        ch = in_str[i];
       
        
        push(&s, ch);
    }

    for (i = 0; i < len; i++) {
        ch = in_str[i];
        
        chs = pop(&s);
        if (ch != chs) return 0; // 실패
    }
    return 1;  // 성공
}

int main() {
    char input[] = "madam";
    if (palindrome(input))
        printf("%s is a palindrome.\n", input);
    else
        printf("%s is not a palindrome.\n", input);
    return 0;
}
