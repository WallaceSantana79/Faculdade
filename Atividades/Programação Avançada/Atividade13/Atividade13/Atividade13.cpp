#include <iostream>
#include <locale.h>
#include <string>


using namespace std;

int somaVotos(int arrayInput[], int qtdElementos);

int main()
{
    setlocale(LC_ALL, "Portuguese");
    int arrayResp[6] = {};
    int voto = -1;
    while (voto != 0) {
        cout << "Qual o melhor Sistema Operacional para uso em servidores? \n" <<
            "1 - Windows Server \n2 - Unix \n3 - Linux \n4 - Netware \n5 - Mac OS \n6 - Outro \n0- Sair \n Voto: ";
        cin >> voto;
        switch (voto) {
        case 0:
            break;
        case 1:
            arrayResp[0] = arrayResp[0] + 1;
            break;
        case 2:
            arrayResp[1] = arrayResp[1] + 1;
            break;
        case 3:
            arrayResp[2] = arrayResp[2] + 1;
            break;
        case 4:
            arrayResp[3] = arrayResp[3] + 1;
            break;
        case 5:
            arrayResp[4] = arrayResp[4] + 1;
            break;
        case 6:
            arrayResp[5] = arrayResp[5] + 1;
            break;
        default:
            cout << "Voto nulo.\n";
            break;
        }
    }

    int somaV = somaVotos(arrayResp, 6);


    cout << "Sistema Operacional Votos % \n" <<
        "Windows Server " << arrayResp[0] << " votos, " << round((double)arrayResp[0] / somaV * 100) << "%\n" <<
        "Unix " << arrayResp[1] << " votos, " << round((double)arrayResp[1] / somaV * 100) << "%\n" <<
        "Linux " << arrayResp[2] << " votos, " << round((double)arrayResp[2] / somaV * 100) << "%\n" <<
        "Netware " << arrayResp[3] << " votos, " << round((double)arrayResp[3] / somaV * 100) << "%\n" <<
        "Mac OS " << arrayResp[4] << " votos, " << round((double)arrayResp[4] / somaV * 100) << "%\n" <<
        "Outro " << arrayResp[5] << " votos, " << round((double)arrayResp[5] / somaV * 100) << "%\n";
}


int somaVotos(int arrayInput[], int qtdElementos) {
    int soma = 0;
    for (int i = 0; i < qtdElementos; i++) {
        soma += arrayInput[i];
    }
    return soma;
}
