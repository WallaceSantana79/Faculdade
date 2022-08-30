// Atividade8.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include <stdio.h>
#include <iostream>
#include <locale.h>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Portuguese");

    float areaPintura, areaPinturaFolga, rendimentoLitro, litrosLata, rendimentoLata,
        precoLata, precoSomenteLatas,
        litrosGalao, precoGalao, rendimentoGalao, precoSomenteGaloes,
        precoLatas, precoGaloes, precoLatasGaloes;
    int qtdSomenteLatas, qtdSomenteGaloes, qtdLatas, qtdGaloes;

    //dados iniciais da Lata
    litrosLata = 18.0;
    precoLata = 80.0;
    rendimentoLitro = 6.0;
    rendimentoLata = rendimentoLitro * litrosLata;

    //dados iniciais do galão
    litrosGalao = 3.6;
    precoGalao = 25.0;
    rendimentoGalao = rendimentoLitro * litrosGalao;

    cout << "Tamanho da área a ser pintada (m2): ";
    cin >> areaPintura;

    areaPinturaFolga = areaPintura * 1.10;

    //cálculo para latas
    qtdSomenteLatas = ceil(areaPinturaFolga / rendimentoLata);
    precoSomenteLatas = qtdSomenteLatas * precoLata;

    printf("Apenas latas de 18L: %i latas, R$ %.2f \n", qtdSomenteLatas, precoSomenteLatas);

    //cálculo para galões
    qtdSomenteGaloes = ceil(areaPinturaFolga / rendimentoGalao);
    precoSomenteGaloes = qtdSomenteGaloes * precoGalao;

    printf("Apenas galões de 3,6L: %i galões, R$ %.2f \n", qtdSomenteGaloes, precoSomenteGaloes);

    //cálculo para latas e galões
    qtdLatas = floor(areaPinturaFolga / rendimentoLata);
    qtdGaloes = ceil((int)areaPinturaFolga % (int)rendimentoLata / rendimentoGalao);
    precoLatas = qtdLatas * precoLata;
    precoGaloes = qtdGaloes * precoGalao;
    precoLatasGaloes = precoLatas + precoGaloes;

    printf("Misturando latas e galões: %i latas, %i galões, R$ %.2f \n", qtdLatas, qtdGaloes, precoLatasGaloes);
}

