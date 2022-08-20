// Atividade4.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Portuguese");
    double metro;
    double decimetro;
    double centimetro;
    double milimetro;

    cout << "Entre com o valor em metro: ";
    cin >> metro;

    decimetro = metro * 10;
    centimetro = metro * 100;
    milimetro = metro * 1000;

    cout << "Valor em decímetro: " << decimetro << "\n";
    cout << "Valor em centímetro: " << centimetro << "\n";
    cout << "Valor em milímetro: " << milimetro << "\n";
}

