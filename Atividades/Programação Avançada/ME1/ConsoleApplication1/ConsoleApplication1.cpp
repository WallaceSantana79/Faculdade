#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
struct regcontato
{
    char nome[40], telefone[14], email[30], idade[3];
    int existe;
};

void incluir();
void listar();
void alterar();
void excluir();


int main(int argc, char** argv) {
    /*incluir();
    listar();
    alterar();
    excluir();*/

    int op;
    do {
        do {
            system("cls");
            cout << "\n\n\t\t+--------------------------------+\n";
            cout << "\t\t|             MENU               |\n";
            cout << "\t\t+--------------------------------+\n";
            cout << "1- Incluir contato na agenda" << endl;
            cout << "2- Listar contatos da agenda" << endl;
            cout << "3- Alterar dados do contato" << endl;
            cout << "4- Excluir contato" << endl;
            cout << "0- Sair da agenda" << endl;
            cout << endl;
            cout << "Informe a opcao desejada: ";
            cin >> op;
        } while (op < 0 || op>4);
        if (op == 1)
            incluir();
        else
            if (op == 2)
                listar();
            else
                if (op == 3)
                    alterar();
                else
                    if (op == 4)
                        excluir();

    } while (op != 0);

}

void incluir()
{
    regcontato reg;
    FILE* agenda;

    agenda = fopen("Agenda.txt", "a");
    if (agenda == NULL)
        agenda = fopen("Agenda.txt", "w");
    system("cls");
    cout << "\t\tDigite os dados do contato:" << endl;
    cout << "\tNome: ";
    cin >> reg.nome;
    cout << "\tTelefone: ";
    cin >> reg.telefone;
    cout << "\tE-mail: ";
    cin >> reg.email;
    cout << "\tIdade:";
    cin >> reg.idade;
    reg.existe = 1;
    fwrite(&reg, sizeof(reg), 1, agenda);
    fclose(agenda);
}

void listar()
{
    FILE* agenda;
    int op, n;
    regcontato reg;
    agenda = fopen("Agenda.txt", "r");

    if (agenda == NULL)
        cout << "A agenda esta vazia";
    else
    {
        system("cls");
        n = 0;
        fread(&reg, sizeof(reg), 1, agenda);

        while (feof(agenda) == 0)
        {
            n++;
            if (reg.existe == 1)
            {
                cout << "\n\t\t     Dados do contato " << endl;

                cout << "\tRegistro: " << n << endl;
                cout << "\tNome: " << reg.nome << endl;
                cout << "\tTelefone: " << reg.telefone << endl;
                cout << "\tE-mail: " << reg.email << endl;
                cout << "\tIdade: " << reg.idade;
                cout << "\n______________________________________________________\n";
            }
            fread(&reg, sizeof(reg), 1, agenda);

        }
        system("pause");
        fclose(agenda);
    }


}

void alterar()
{
    FILE* agenda;
    regcontato reg;
    int n, op;
    system("cls");
    agenda = fopen("Agenda.txt", "r+");
    if (agenda == NULL)
        cout << "ERRO!!! A agenda está vazia! Volte ao menu e selecione a opção ''Incluir''" << endl;
    else
    {
        cout << "Informe o codigo do contato a alterar: ";
        cin >> n;
        if (fseek(agenda, (n - 1) * sizeof(reg), SEEK_SET) == 0)
        {
            fread(&reg, sizeof(reg), 1, agenda);
            if (reg.existe == 1)
            {
                cout << "\n\t\t     Dados do contato " << endl;
                cout << "\tNome: " << reg.nome << endl;
                cout << "\tTelefone: " << reg.telefone << endl;
                cout << "\tE-mail: " << reg.email << endl;
                cout << "\tIdade: " << reg.idade << "\n\n";

                cout << "\t***Informe os novos dados do contato***" << endl;

                cout << "\n\t\tDigite os dados do contato:" << endl;
                cout << "\tNome: ";
                cin >> reg.nome;
                cout << "\tTelefone: ";
                cin >> reg.telefone;
                cout << "\tE-mail: ";
                cin >> reg.email;
                cout << "\tIdade:";
                cin >> reg.idade;

                fseek(agenda, (n - 1) * sizeof(reg), SEEK_SET);
                fwrite(&reg, sizeof(reg), 1, agenda);
            }
            else
            {
                cout << "\nERRO!!! Contato inexistente\n";
                system("pause");
            }
        }
        else
        {
            cout << "\nERRO!!! Contato inexistente\n";
            system("pause");
        }
        fclose(agenda);
    }
}



void excluir()
{
    FILE* agenda;
    regcontato reg;
    int n, op;
    system("cls");
    agenda = fopen("Agenda.txt", "r+");
    if (agenda == NULL)
        cout << "ERRO!!! A agenda está vazia! Volte ao menu e selecione a opção ''Incluir''" << endl;
    else
    {
        cout << "Informe o codigo do contato a EXCLUIR: ";
        cin >> n;
        if (fseek(agenda, (n - 1) * sizeof(reg), SEEK_SET) == 0)
        {
            fread(&reg, sizeof(reg), 1, agenda);

            if (reg.existe == 1)
            {
                cout << "\n\t\t     Dados do contato " << endl;
                cout << "\tNome: " << reg.nome << endl;
                cout << "\tTelefone: " << reg.telefone << endl;
                cout << "\tE-mail: " << reg.email << endl;
                cout << "\tIdade: " << reg.idade << "\n\n";

                cout << "Para EXCLUIR o contato digite <0> ou <1> para voltar ao MENU: ";
                cin >> op;
                if (op == 0)
                {
                    reg.existe = 0;
                    fseek(agenda, (n - 1) * sizeof(reg), SEEK_SET);
                    fwrite(&reg, sizeof(reg), 1, agenda);
                }
            }
            else
            {
                cout << "\nERRO!!! Contato inexistente\n";
                system("pause");
            }
        }
        else
        {
            cout << "\nERRO!!! Contato inexistente\n";
            system("pause");
        }
        fclose(agenda);
    }
}
