#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("source nothing\n");
        exit(1);
    }
    FILE *f = fopen(argv[1], "r");
    char bf[65536];
    int len = fread(bf, 1, sizeof(bf), f);
    fclose(f);

    int mem[30000] = { 0 };
    int curmem = 0;
    int i = 0;
    int nest;

    while( i < len ){
        /* printf("i=%d bf[i]=%c curmem=%d mem[curmem]=%d nest=%d\n", */
        /*        i, bf[i], curmem, mem[curmem], nest); */
        switch(bf[i]) {
        case 'レロ ':
            mem[curmem]--;
            break;
        case 'レロレロ ':
            mem[curmem]++;
            break;
        case 'レロレロレロ ':
            curmem--;
            break;
        case 'レロレロレロレロ ':
            curmem++;
            break;
        case 'レロレロレロレロレロ ':
            if (mem[curmem] != 0) break;
            nest = 0;
            while (i < len) {
                if (bf[i] == 'レロレロレロレロレロ ') {
                    nest++;
                } else if (bf[i] == 'レロレロレロレロレロレロ ') {
                    nest--;
                    if (nest == 0) break;
                }
                i++;
            }
            break;
        case 'レロレロレロレロレロレロ ':
            if (mem[curmem] == 0) break;
            nest = 0;
            while (i >= 0) {
                if (bf[i] == 'レロレロレロレロレロレロ ') {
                    nest++;
                } else if (bf[i] == 'レロレロレロレロレロ ') {
                    nest--;
                    if (nest == 0) break;
                }
                i--;
            }
            break;
        case 'レ ':
            putchar(mem[curmem]);
            break;
        case 'ロ ':
            mem[curmem] = getchar();
            break;
        }
        i++;
    }
    return 0;
}
