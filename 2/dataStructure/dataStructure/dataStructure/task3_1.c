#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
int N;
#define swap(x,y,t) ((t)=(x),(x)=(y),(y)=(t))

typedef struct {
    char* str;
    int i_n_i;
}element;

element *randarr; 


double Time_d[5];
long long Compare_d[5];
long long Swap_d[5];
char* Name_Data[5] = { "Bubble Sort","Insert Sort","Quick Sort" ,"Merge Sort","Heap Sort" };
int stable[5];


void rand_char(void);
int check_stable(element arr[]);
void setting_arr(element x[], element y[]);
void Setting_Merge_Sort_Func(element arr[], element tmp[], int l, int r);
void Bubble_Sort(element arr[]);
void Bubble_Sort_Func(element arr[]);
void Insert_Sort(element arr[]);
void Insert_Sort_Func(element arr[]);
void Quick_Sort(element arr[]);
void Quick_Sort_Func(element arr[], int l, int r);
void Merge_Sort(element arr[]);
void Merge_Sort_Func(element arr[], element tmp[], int l, int r);
void Heap_Sort(element arr[]);
void Heap_Sort_Func(element arr[]);

int main(int argc, char *argv[]) {
    
    if (argc != 2) {
        printf("Usage: %s <N>\n", argv[0]);
        printf("Example: %s 100000\n", argv[0]);
        return 1;
    }
    N = atoi(argv[1]);
    if (N <= 0) {
        printf("N must be a positive integer.\n");
        return 1;
    }

   
    randarr = malloc(sizeof(element) * N);
    if (randarr == NULL) {
        printf("Memory allocation failed for randarr (N=%d).\n", N);
        return 1;
    }

    srand((unsigned)time(NULL));
    rand_char();
    printf("Number of Instances: %d\n", N);
    
    
    setting_arr(randarr, randarr);
    Bubble_Sort(randarr);
    
   
    setting_arr(randarr, randarr);
    Insert_Sort(randarr);
    
    
    setting_arr(randarr, randarr);
    Quick_Sort(randarr);
    
    
    setting_arr(randarr, randarr);
    Merge_Sort(randarr);
    
    
    setting_arr(randarr, randarr);
    Heap_Sort(randarr);


    printf("====Sorting Result Summary ===\n");
    printf("Algorithm     | Tims(s)   | Compare             | Swap                 | Stable\n");
    printf("--------------------------------------------------------------------------\n");
    for (int i = 0; i < 5; i++) {
        printf("%-13s", Name_Data[i]);
        printf("|%-12lf", Time_d[i]);
        printf("|%-22lld", Compare_d[i]);
        printf("|%-22lld", Swap_d[i]);
        if (stable[i])printf("|YES\n");
        else printf("|NO\n");
    }

    for (int i = 0; i < N; i++)free(randarr[i].str);
    free(randarr); 
    return 0;
}

void Heap_Sort(element arr[]){
    FILE* fp = fopen("heap_sort.out", "w");
    printf("=> Starting - Heap Sort\n");
    clock_t s, f;
    double dur;
    s = clock();

    Heap_Sort_Func(arr);
    for (int i = 0; i < N; i++) {
        fprintf(fp, "%s ", arr[i].str);
    }

    f = clock();
    dur = (double)(f - s) / CLOCKS_PER_SEC;
    printf("=> Finished\n");
    Time_d[4] = dur;
    fclose(fp);
    printf("=> Created - heap_sort.out\n");
    stable[4] = check_stable(arr);
}

void Heap_Sort_Func(element arr[]) {
    
    element *heap = malloc(sizeof(element) * (N + 1));
    if (heap == NULL) return; 

    element S_TEMP; 
    
    int i_n_i = 1;
    
    for (int i = 0; i < N; i++) {
        heap[i_n_i] = arr[i];
        for (int j = i_n_i; j / 2 > 0; j /= 2) {
            Compare_d[4]++;
            
            if (strcmp(heap[j].str, heap[j / 2].str) < 0 || (strcmp(heap[j].str, heap[j / 2].str) == 0 && heap[j].i_n_i < heap[j / 2].i_n_i)){
                swap(heap[j], heap[j / 2], S_TEMP);
                Swap_d[4]++;
            }
            else break;
        }
        i_n_i++;
    }
    
    
    for (int i = 0; i < N; i++) {
        arr[i] = heap[1];
        swap(heap[1], heap[i_n_i - 1], S_TEMP);
        
        Swap_d[4]++;
        i_n_i--;

        int j = 1;
        while (j * 2 < i_n_i) {
            int child = j * 2;
            Compare_d[4]++; 
            
            if (child + 1 < i_n_i && (strcmp(heap[child + 1].str, heap[child].str) < 0 || (strcmp(heap[child + 1].str, heap[child].str) == 0 && heap[child + 1].i_n_i < heap[child].i_n_i))) {
                child++;
            }

            
            if (strcmp(heap[j].str, heap[child].str) > 0 || (strcmp(heap[j].str, heap[child].str) == 0 && heap[j].i_n_i > heap[child].i_n_i)) {
                swap(heap[j], heap[child], S_TEMP);
                Compare_d[4]++; 
                Swap_d[4]++;
                j = child;
            }
            else break;
        }
    }
    free(heap); 
}

void Merge_Sort_Func(element arr[], element tmp[], int l, int r) {
    if (l >= r)return;


    int i_n_i = 0;
    int lower = l;
    int mid = (l + r) / 2;
    int upper = mid + 1;

    Merge_Sort_Func(arr, tmp, l, mid);
    Merge_Sort_Func(arr, tmp, mid + 1, r);


    while (lower <= mid && upper <= r) {
        if (strcmp(arr[lower].str, arr[upper].str) <= 0) {
            Compare_d[3]++;
            tmp[i_n_i] = arr[lower];
            lower++;
        }
        else {
            Compare_d[3]++;
            tmp[i_n_i] = arr[upper];
            upper++;
        }
        i_n_i++;
    }
    
    for (; lower <= mid; lower++) {
        tmp[i_n_i] = arr[lower];
        i_n_i++;
    }
    for (; upper <= r; upper++) {
        tmp[i_n_i] = arr[upper];
        i_n_i++;
    }
    for (i_n_i = 0; l + i_n_i <= r; i_n_i++) {
        arr[l + i_n_i] = tmp[i_n_i];
        Swap_d[3]++; 
    }

}
void Merge_Sort(element arr[]){
    FILE* fp = fopen("merge_sort.out", "w");
    printf("=> Starting - Merge Sort\n");
    clock_t s, f;
    double dur;
    s = clock();
    
  
    element *tmp = malloc(sizeof(element) * N);
    if (tmp == NULL) {
        printf("Memory allocation failed for tmp in Merge Sort.\n");
        fclose(fp);
        return;
    }
    
    Merge_Sort_Func(arr, tmp, 0, N - 1);
    
    free(tmp);
    
    for (int i = 0; i < N; i++) {
        fprintf(fp, "%s ", arr[i].str);
    }

    f = clock();
    dur = (double)(f - s) / CLOCKS_PER_SEC;
    printf("=> Finished\n");
    Time_d[3] = dur;
    fclose(fp);
    printf("=> Created - merge_sort.out\n");
    stable[3] = check_stable(arr);
}
void Quick_Sort_Func(element arr[], int l, int r) {
    if (l >= r)return;
    element S_TEMP; 

    int lower, upper;
    lower = l;
    upper = r + 1;
    while (lower < upper) {
        lower++;
        
        while ((lower <= r) && (strcmp(arr[lower].str, arr[l].str) < 0 ||  (strcmp(arr[lower].str, arr[l].str) == 0 && arr[lower].i_n_i < arr[l].i_n_i))) {
            Compare_d[2]++;
            lower++;
        }
        upper--;
        
        while ((upper >= l + 1) && (strcmp(arr[upper].str, arr[l].str) > 0 || (strcmp(arr[upper].str, arr[l].str) == 0 && arr[upper].i_n_i >= arr[l].i_n_i))) {
            Compare_d[2]++;
            upper--;
        }
        if (lower < upper) {
            Swap_d[2]++;
            swap(arr[lower], arr[upper], S_TEMP);
        }
    }
    swap(arr[upper], arr[l], S_TEMP);
    Swap_d[2]++;
    Quick_Sort_Func(arr, l, upper - 1);
    Quick_Sort_Func(arr, upper + 1, r);
    return;
}
void Quick_Sort(element arr[]) {
    FILE* fp = fopen("quick_sort.out", "w");
    printf("=> Starting - Quick Sort\n");
    clock_t s, f;
    double dur;
    s = clock();

    Quick_Sort_Func(arr, 0, N-1);
    for (int i = 0; i < N; i++) {
        fprintf(fp, "%s ", arr[i].str);
    }

    f = clock();
    dur = (double)(f - s) / CLOCKS_PER_SEC;
    printf("=> Finished\n");
    Time_d[2] = dur;
    fclose(fp);
    printf("=> Created - quick_sort.out\n");
    stable[2] = check_stable(arr);
}
void Insert_Sort_Func(element arr[]) {
    for (int i = 1; i < N; i++) {
        element key = arr[i];
        int j = i-1;
        for (; j >= 0;j--) {
            Compare_d[1]++;
            if (strcmp(arr[j].str, key.str) >0) {
                arr[j + 1] = arr[j];
                Swap_d[1]++;
            }
            else break;
        }
        arr[j + 1] = key;
        Swap_d[1]++; 
    }
}
void Insert_Sort(element arr[]){
    FILE* fp = fopen("insert_sort.out", "w");
    printf("=> Starting - Insert Sort\n");
    clock_t s, f;
    double dur;
    s = clock();

    Insert_Sort_Func(arr);
    for (int i = 0; i < N; i++) {
        fprintf(fp, "%s ", arr[i].str);
    }

    f = clock();
    dur = (double)(f - s) / CLOCKS_PER_SEC;
    printf("=> Finished\n");
    Time_d[1] = dur;
    fclose(fp);
    printf("=> Created - insert_sort.out\n");
    stable[1] = check_stable(arr);
}
void Bubble_Sort_Func(element arr[]) {
    element S_TEMP; 
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - i - 1; j++) {
            Compare_d[0]++;
            if (strcmp(arr[j].str,arr[j+1].str)>0) {
                swap(arr[j], arr[j + 1], S_TEMP);
                Swap_d[0]++;
            }
        }
    }
}
void Bubble_Sort(element arr[]) {
    FILE* fp = fopen("bubble_sort.out", "w");
    printf("=> Starting - Bubble Sort\n");
    clock_t s, f;
    double dur;
    s = clock();

    Bubble_Sort_Func(arr);
    for (int i = 0; i < N; i++) {
        fprintf(fp, "%s ", arr[i].str);
    }

    f = clock();
    dur = (double)(f - s) / CLOCKS_PER_SEC;
    printf("=> Finished\n");
    Time_d[0] = dur;
    fclose(fp);
    printf("=> Created - bubble_sort.out\n");
    stable[0] = check_stable(arr);
}

void rand_char(void) {
    for (int i = 0; i < N; i++) {
        int l = rand() % 20 + 1;
      
        randarr[i].str = malloc(sizeof(char) * (l + 1));
        if (randarr[i].str == NULL) {
           
            fprintf(stderr, "Error: Memory allocation failed in rand_char.\n");
            exit(1); 
        }

        int j = 0;
        char tmp[100];
        for (; j < l; j++) {
            tmp[j] = rand() % ('z' - 'a'+1) + 'a';
        }
        tmp[j] = '\0';
        strcpy(randarr[i].str,tmp);
        randarr[i].i_n_i = i;
    }
    return;
}
int check_stable(element arr[])
{
    for (int i = 0; i < N-1; i++) {
        if (strcmp(arr[i].str, arr[i + 1].str) == 0) {
            if (arr[i].i_n_i > arr[i + 1].i_n_i){
                return 0;
            }
        }
    }
    return 1;
}
void setting_arr(element x[], element y[]) {
    
    element *tmp = malloc(sizeof(element) * N);
    if (tmp == NULL) {
        printf("Memory allocation failed for tmp in setting_arr.\n");
        return;
    }
    Setting_Merge_Sort_Func(x, tmp, 0, N - 1);
    
    free(tmp); 
}
void Setting_Merge_Sort_Func(element arr[], element tmp[], int l, int r) {
    if (l >= r)return;


    int i_n_i = 0;
    int lower = l;
    int mid = (l + r) / 2;
    int upper = mid + 1;

    Setting_Merge_Sort_Func(arr, tmp, l, mid);
    Setting_Merge_Sort_Func(arr, tmp, mid + 1, r);


    while (lower <= mid && upper <= r) {
        if (arr[lower].i_n_i< arr[upper].i_n_i) { 
            tmp[i_n_i] = arr[lower];
            lower++;
        }
        else {
            tmp[i_n_i] = arr[upper];
            upper++;
        }
        i_n_i++;
    }
    for (; lower <= mid; lower++) {
        tmp[i_n_i] = arr[lower];
        i_n_i++;
    }
    for (; upper <= r; upper++) {
        tmp[i_n_i] = arr[upper];
        i_n_i++;
    }
    for (i_n_i = 0; l + i_n_i <= r; i_n_i++) {
        arr[l + i_n_i] = tmp[i_n_i];
    }
}