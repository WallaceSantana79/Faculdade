#include <iostream>
#include <locale.h>
#include <string>
#include <stdio.h>
#define TAMANHO 200


char nome[TAMANHO][50];
char telefone1[TAMANHO][16];
char telefone2[TAMANHO][16];
char flagFavorito[TAMANHO];
int listaFavoritos[10] = { };
int op = 0;

using namespace std;
void criarContato();
void buscarContato();
void listaContatos();
void favoritos();
void editarContato();
int main()
{
    setlocale(LC_ALL, "pt_BR.UTF-8");
    int menu = -1;
    while (menu != 0) {
        printf("\nO que deseja fazer?\n1 - Criar contato \n2 - Buscar contato \n3 - Listar contatos\n4 - Favoritos\n5 - Editar algum contato\n0 - Sair\nDigite o número correspondente a função de interesse: ");
        cin >> menu;
        fflush(stdin);
        switch (menu) {
        case 0:
            printf("Aplicação encerrada");
            break;
        case 1:
            criarContato();
            break;
        case 2:
            buscarContato();
            break;
        case 3:
            listaContatos();
            break;
        case 4:
            favoritos();
            break;
        case 5:
            editarContato();
            break;
        default:
            printf("\nComando inválido");
            break;
        }


    }
}

void criarContato() {
    static int linha;
    string op2;
    do {
        printf("\nDigite o nome: ");
        cin >> nome[linha];
        printf("\nDigite o telefone: ");
        cin >> telefone1[linha];
        printf("\nTem um segundo telefone? [S/N] ");
        fflush(stdin);
        cin >> op2;
        while (true) {
            if (op2 == "S" or op2 == "s") {
                printf("\nDigite o segundo telefone: ");
                fflush(stdin);
                cin >> telefone2[linha];
                break;
            }
            if (op2 == "N" or op2 == "n") {
                fflush(stdin);
                break;
            }
            else {
                printf("\nComando inválido tente novamente\n");
                return;
            }
        }
        printf("\nFavorito? [S/N] ");
        fflush(stdin);
        cin >> op2;
        while (true) {
            if (op2 == "S" or op2 == "s") {
                fflush(stdin);
                flagFavorito[linha]++;
                break;
            }
            if (op2 == "N" or op2 == "n") {
                fflush(stdin);
                flagFavorito[linha] = flagFavorito[linha] + 2;
                break;
            }
            else {
                printf("\nComando inválido tente novamente\n");
                return;
            }
        }
        printf("\n Digite 1 para continuar ou outro valor para sair: ");
        fflush(stdin);
        cin >> op;
        linha++;
    } while (op == 1);
}
void buscarContato() {
    char nomePesquisa[50];
    int i;
    do {
        printf("\nDigite o nome do contato que deseja buscar: ");
        cin >> nomePesquisa;
        for (i = 0; i < TAMANHO; i++) {
            if (strcmp(nome[i], nomePesquisa) == 0) {
                if (flagFavorito[i] == 1) {
                    printf("\nNome: %s\nTelefone1: %s\nTelefone2: %s\nContato salvo como favorito ", nome[i], telefone1[i], telefone2[i], flagFavorito[i]);
                }
                if (flagFavorito[i] == 2) {
                    printf("\nNome: %s\nTelefone1: %s\nTelefone2: %s\nContato salvo como não favorito", nome[i], telefone1[i], telefone2[i], flagFavorito[i]);
                }
            }

        }
        printf("\nDigite 1 para continuar ou outro valor para sair: ");
        cin >> op;
        fflush(stdin);
    } while (op == 1);
}
void listaContatos() {
    int i;
    for (i = 0; i < TAMANHO; i++) {
        if (flagFavorito[i] == 1) {
            printf("\nNome: %s\nTelefone1: %s\nTelefone2: %s\nContato salvo como favorito ", nome[i], telefone1[i], telefone2[i], flagFavorito[i]);
        }
        if (flagFavorito[i] == 2) {
            printf("\nNome: %s\nTelefone1: %s\nTelefone2: %s\nContato salvo como não favorito", nome[i], telefone1[i], telefone2[i], flagFavorito[i]);
        }
        else {
            break;
        }

    }

}
void favoritos() {
    char nomePesquisa[50];
    char telefonePesquisa[16];
    int i;
    int op3 = -1;
    while (op3 != 0) {
        printf("\n1 - Tornar um contato favorito\n2 - Retirar um contato dos favoritos\n3 - Listar todos os favoritos\n0- Sair\nDigite a função desejada: ");
        fflush(stdin);
        cin >> op3;
        switch (op3) {
        case 0:
            printf("Aplicação encerrada");
            fflush(stdin);
            break;
        case 1:
            do {
                printf("\nDigite o nome do contato que deseja tornar favorito: ");
                fflush(stdin);
                cin >> nomePesquisa;
                printf("\nDigite o telefone1 do contato que deseja tornar favorito: ");
                fflush(stdin);
                cin >> telefonePesquisa;
                for (i = 0; i < TAMANHO; i++) {
                    if (strcmp(nome[i], nomePesquisa) == 0) {
                        if (strcmp(telefone1[i], telefonePesquisa) == 0) {
                            if (flagFavorito[i] == 2) {
                                flagFavorito[i]--;
                            }
                            else if (flagFavorito[i] == 1) {
                                printf("Esse contato já está definido como favorito");
                            }
                        }
                    }
                }
                printf("\nDigite 1 para continuar ou outro valor para sair: ");
                fflush(stdin);
                cin >> op;
            } while (op == 1);
            break;
        case 2:
            do {
                printf("\nDigite o nome do contato que deseja retirar dos favoritos: ");
                fflush(stdin);
                cin >> nomePesquisa;
                printf("\nDigite o telefone1 do contato que deseja retirar dos favoritos: ");
                fflush(stdin);
                cin >> telefonePesquisa;
                for (i = 0; i < TAMANHO; i++) {
                    if (strcmp(nome[i], nomePesquisa) == 0) {
                        if (strcmp(telefone1[i], telefonePesquisa) == 0) {
                            if (flagFavorito[i] == 1) {
                                flagFavorito[i]++;
                            }
                            else if (flagFavorito[i] == 2) {
                                printf("Esse contato já está definido como não favorito");
                            }
                        }
                    }
                }
                printf("\nDigite 1 para continuar ou outro valor para sair: ");
                fflush(stdin);
                cin >> op;
            } while (op == 1);
            break;
        case 3:
            int i;
            for (i = 0; i < TAMANHO; i++) {
                if (flagFavorito[i] == 1) {
                    printf("\nNome: %s\nTelefone1: %s\nTelefone2: %s\nContato salvo como favorito ", nome[i], telefone1[i], telefone2[i], flagFavorito[i]);
                }
                else {
                    break;
                }
            }
            break;
        default:
            printf("\nComando inválido");
            fflush(stdin);
            break;
        }
    }
}
void editarContato() {
    char nomePesquisa[50];
    char telefonePesquisa[16];
    int i;
    do {
        printf("\nDigite o nome do contato que deseja editar: ");
        fflush(stdin);
        cin >> nomePesquisa;
        printf("\nDigite o telefone1 do contato que deseja editar: ");
        fflush(stdin);
        cin >> telefonePesquisa;
        for (i = 0; i < TAMANHO; i++) {
            if (strcmp(nome[i], nomePesquisa) == 0) {
                if (strcmp(telefone1[i], telefonePesquisa) == 0) {
                    printf("\nDigite o telefone1 para editar: ");
                    fflush(stdin);
                    cin >> telefone1[i];
                    printf("\nDigite o telefone2 para editar: ");
                    fflush(stdin);
                    cin >> telefone2[i];
                }
            }
        }
        printf("\nDigite 1 para continuar ou outro valor para sair: ");
        fflush(stdin);
        cin >> op;
    } while (op == 1);
}