// Atividade6.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
#include <math.h>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Portuguese");
    int num1, num2;
    int soma, produto, quadrado;
    double raiz;

    cout << "Número 1: ";
    cin >> num1;
    cout << "Número 2: ";
    cin >> num2;

    soma = num1 + num2;
    produto = num1 * pow(num2, 2);
    quadrado = pow(num1, 4);
    raiz = sqrt(pow(num1, 2) + pow(num2, 2));

    cout << "Soma: " << soma << "\n";
    cout << "Produto do primeiro número pelo quadrado do segundo: " << produto << "\n";
    cout << "Quadrado do primeiro número: " << quadrado << "\n";
    cout << "Raiz quadrada da soma dos quadrados: " << raiz;

}
