/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaestatica;

import java.util.Scanner;

class Pilha {

    int CAPACIDADE = 5; //define o tamanho maximo desta uma pilha.
    private String[] dados = new String[CAPACIDADE];
// vetor para guardar os dados da pilha.
    private int topo = -1; // variável que irá indicar a posição no vetor do topo da pilha.
// este método informa o tamanho da pilha

    public int Tamanho() {
        return topo + 1; // lembre-se que o vetor inicia da posição zero...
    }
// este método retorna true se a pilha estiver vazia

    public boolean Vazia() {
        return Tamanho() == 0;
    }
// este método empilha um valor string na pilha

    public void Empilha(String p_valor) throws Exception {
        if (Tamanho() != CAPACIDADE) {
            topo++;
            dados[topo] = p_valor;
        } else {
            throw new Exception("A pilha está cheia!!!");
        }
    }
// este método desempilha um valor da pilha

    public String Desempilha() throws Exception {
        if (Vazia() == true) {
            throw new Exception("A pilha está vazia!!!");
        } else {
            topo--;
            return dados[topo + 1];
        }
    }
// este método devolve o valor que está no topo

    public String RetornaTopo() throws Exception {
        if (Vazia() == true) {
            throw new Exception("A pilha está vazia!!!");
        } else {
            return dados[topo];
        }
    }
}

class PilhaEstatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        String valor;
        Pilha minhaPilha = new Pilha(); // cria uma instância da classe pilha!

        do {
            try {
                System.out.print("\n "
                        + "Escolha: \n"
                        + "1-> empilha \n"
                        + "2->desempilha \n"
                        + "3->topo \n"
                        + "4-> tamanho \n"
                        + "9-> sair:"
                        + "\n");
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print(">>Digite o valor que deseja empilhar: ");
                        valor = input.next();
                        minhaPilha.Empilha(valor);
                        break;
                    case 2:
                        valor = minhaPilha.Desempilha();
                        System.out.println(">>Desempilhado: " + valor);
                        break;
                    case 3:
                        valor = minhaPilha.RetornaTopo();
                        System.out.println(">>Valor no topo:\n\n " + valor);
                        break;
                    case 4:
                        System.out.println(">>Tamanho da pilha: " + minhaPilha.Tamanho());
                        break;
                    // sai do programa
                    case 9:
                        break;
                    default:
                        break;
                }
            } catch (Exception erro) {
                System.out.println("ERRO: " + erro);
            }
        } while (opcao != 9);
    }
}
