#include <stdio.h> 
#define TAM_CADENA 200

main() {
    // Puntero a caracter para copiar las cadenas
    char *p1, *p2;

    // A) Definir las variables cadena y cadena2 
    char cadena[TAM_CADENA];
    char cadena2 [TAM_CADENA];
    char str[TAM_CADENA];
    // B) Leer cadena de consola 
    printf("Escribe una palabra:");
    scanf("Introduce cadena 1 y 2: %s%s\n", &cadena, &cadena2);
    scanf("%[^\n]s", str);
    // C) Convertir a mayúsculas
    p1 = cadena;
    p2 = cadena2;
    while (*p1 != '\0') {
        //  Copiar p1 a p2 restando 32
        &p2 = &p1 - 32;
    }

    // Acordarse de poner el cero final en cadena2
    cadena2 = strcat(cadena2, "0");
    // D) Sacar por consola la cadena2.
    printf("%s\n", cadena2);
    return (0);
}

