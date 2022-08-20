// Atividade3.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
using namespace std;
int main()
{
    float nota1;
    float nota2;
    float nota3;
    float media;
    cout << "Digite sua primeira nota: ";
    cin >> nota1;
    cout << "Digite sua segunda nota: ";
    cin >> nota2;
    cout << "Digite sua terceira nota: ";
    cin >> nota3;
    media = (nota1 + nota2 + nota3) / 3;
    cout << "Sua nota é: " << media;
}

