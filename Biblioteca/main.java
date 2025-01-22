import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);


        int opcao;
        Biblioteca b = new Biblioteca();
        GestaoClientes clientes = new GestaoClientes();
        GestaoLivros livros = new GestaoLivros();
        Emprestimo e = new Emprestimo(null, null, null, null);


        do{

            System.out.println("MENU DE OPÇÕES");

            System.out.println("(1) Cadastrar cliente");
            System.out.println("(2) Cadastrar livro");
            System.out.println("(3) Buscar livro");
            System.out.println("(4) Emprestar livro");
            System.out.println("(5) Devolver livro");
            System.out.println("(6) Listar clientes");
            System.out.println("(7) Listar livros");
            System.out.println("(8) Remover livro");
            System.out.println("(9) Sair");
            opcao = dados.nextInt();

            switch(opcao){
                case 1:
                    clientes.cadastrarCliente();
                    break;
                case 2:
                    livros.cadastrarLivro();
                    break;
                case 3:
                    livros.buscarLivroPorNome();
                    break;
                case 4:
                    b.emprestarLivro();
                    break;
                case 5:
                    e.devolverLivro(e);
                    break;
                case 6:
                    clientes.listarClientes();
                    break;
                case 7:
                    livros.listarLivros();
                    break;
                case 8:
                    livros.removerLivro();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                     break;                                 
            }

        }while(opcao != 9);
    }
}
