// Atividade10.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <stdio.h>
#include <iostream>
#include <locale.h>

using namespace std;

int main()
{
    setlocale(LC_ALL, "Portuguese");
    
    int quantProdutos, cont;
    float valorFinal;
    cout << " Quantos produtos o cliente está levando: ";
    cin >> quantProdutos;
    while (quantProdutos > 50 or quantProdutos < 0) {
        cout << " Essa quantidade de produtos é inválida, digite novamente:  ";
        cin >> quantProdutos;        
    }
    cont = 0;
    valorFinal = 0;
    for (int i = quantProdutos; i > 0; i--) {
        valorFinal = valorFinal + 1.99;
        cont = cont + 1;
        cout << cont << " - " << valorFinal << endl;
        quantProdutos = quantProdutos - 1;

    }
}
   