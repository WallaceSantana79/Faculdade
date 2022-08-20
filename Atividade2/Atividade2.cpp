// Atividade2.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
using namespace std;
int main()
{
    float c;
    float f;

    cout << "Digite a temperatura em celsius: ";
    cin >> c;

    cout << "A temperatura em farenheit é: " << (c * 9 / 5) + 3;
}

