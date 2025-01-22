import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Biblioteca {
    Scanner dados = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Livro l = new Livro();
    Cliente c = new Cliente();
    private Set<Emprestimo> emprestimos;

    public Biblioteca(){
        this.emprestimos = new HashSet<Emprestimo>();
    }

    public void emprestarLivro(){
        if(l.isDisponivel()){

            try{
                System.out.println("Informe o nome do cliente que deseja fazer o empréstimo:");
                String nome = dados.nextLine();

                if(nome.isEmpty() || nome.matches("//d+")){
                    throw new IllegalArgumentException("O nome do cliente deve conter letras e não pode ser vazio ou apenas números.");
                }

                System.out.println("Informe o titulo do livro que deseja realizar o empréstimo: ");
                String titulo = dados.nextLine();

                if(titulo.isEmpty() || titulo.matches("//d+")){
                    throw new IllegalArgumentException("O título do livro de conter letras e não pode ser vazio ou apenas números.");
                }

                System.out.println("Informe a data do empréstimo: (dd/MM/yyyy)");
                String dataEmprestimo = dados.nextLine();




            }catch(IllegalArgumentException e){
                System.out.println("Erro. " + e.getMessage());
            }catch(Exception e){
                System.out.println("Erro ao emprestar o livro. Verifique os campos e tente novamente.");
            }
          
            
            l.setIsDisponivel(false);
            System.out.println("Livro emprestado com sucesso.");
        }
        System.out.println("Livro indisponível para emprestimo.");
    }

    // public void emprestarLivro(Cliente c, Livro l, LocalDate dataEmprestimo, LocalDate prazo){
    //     if(l.isDisponivel()){
    //         Emprestimo e = new Emprestimo(c, l, dataEmprestimo, prazo);
    //         emprestimos.add(e);
    //         l.setIsDisponivel(false);
    //         System.out.println("Livro emprestado com sucesso.");
    //     }
    //     System.out.println("Livro indisponível para emprestimo.");
    // }


}
