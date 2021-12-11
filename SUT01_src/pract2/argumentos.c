#include <stdio.h>

int main(int argc, char *argv[]) {   
     int numArg = argc;
     printf("Número de argumentos = %d\n", numArg);

     int i = 0;

     while (i < numArg) 
     {
          printf("Argumento %d es %s\n", i, argv[i]);
          i++;
     }

}

