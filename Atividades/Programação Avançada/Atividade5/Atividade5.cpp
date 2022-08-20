// Atividade5.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Portuguese");
    int galoes;
    double litros;

    cout << "Entre com a qtd de galões: ";
    cin >> galoes;

    litros = galoes * 3.7854;

    cout << litros << "Litros ";
}
