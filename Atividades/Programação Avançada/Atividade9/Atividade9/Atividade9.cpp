// Atividade9.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <stdio.h>
#include <iostream>
#include <locale.h>

using namespace std;

int main()
{
    double salario;
    double preReajuste, posReajuste;
    double grupo;
  

    cout << "Digite o seu salário: ";
    cin >> salario;
    if (salario <= 280) {
        grupo = salario;
        preReajuste = grupo * 0.20;
        posReajuste = preReajuste + grupo;
        cout << "O salário antes do reajuste foi de: " << salario << endl;
        cout << "Teve um aumento de 20%" << endl;
        cout << "O valor do aumento foi:  " << preReajuste << endl;
        cout << "O novo salário agora é: " << posReajuste << endl;
        
    }
    if (salario > 280 and salario <= 700) {
        grupo = salario;
        preReajuste = grupo * 0.15;
        posReajuste = preReajuste + grupo;
        cout << "O salário antes do reajuste foi de: " << salario << endl;
        cout << "Teve um aumento de 15%" << endl;
        cout << "O valor do aumento foi:  " << preReajuste << endl;
        cout << "O novo salário agora é: " << posReajuste << endl;
    }
    if (salario > 700 and salario <= 1500) {
        grupo = salario;
        preReajuste = grupo * 0.10;
        posReajuste = preReajuste + grupo;
        cout << "O salário antes do reajuste foi de: " << salario << endl;
        cout << "Teve um aumento de 10%" << endl;
        cout << "O valor do aumento foi:  " << preReajuste << endl;
        cout << "O novo salário agora é: " << posReajuste << endl;

    }
    if (salario > 1500) {
        grupo = salario;
        preReajuste = grupo * 0.05;
        posReajuste = preReajuste + grupo;
        cout << "O salário antes do reajuste foi de: " << salario << endl;
        cout << "Teve um aumento de 5%" << endl;
        cout << "O valor do aumento foi:  " << preReajuste << endl;
        cout << "O novo salário agora é: " << posReajuste << endl;
    }
}
