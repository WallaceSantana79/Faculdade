// Atividade7.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <iostream>
using namespace std;
int main()
{
    float salarioHora;
    int horasTrab;
    float salarioBruto, impRenda, inss, sindicato, salarioLiquido;


    cout << " Quanto você ganha por hora?: ";
    cin >> salarioHora;
    cout << " Quantas horas você trabalhou no mês?: ";
    cin >> horasTrab;
    
    salarioBruto = salarioHora * horasTrab;
    impRenda = salarioBruto * 0.11;
    inss = salarioBruto * 0.08;
    sindicato = salarioBruto * 0.05;
    salarioLiquido = salarioBruto - (impRenda + inss + sindicato);

    cout << " O salário bruto foi de: " << "R$" << salarioBruto << endl;
    cout << " Quanto pagou ao Imposto de Renda: " << "R$" << impRenda << endl;
    cout << " Quanto pagou ao INSS: " << "R$" << inss << endl;
    cout << " Quanto pagou ao Sindicato: " << "R$" << sindicato << endl;
    cout << " O salário líquido foi de: " << "R$" << salarioLiquido << endl;







}

