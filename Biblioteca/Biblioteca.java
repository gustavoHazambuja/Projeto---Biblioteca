import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    
    private Set<Emprestimo> emprestimos;

    public Biblioteca(){
        this.emprestimos = new HashSet<Emprestimo>();
    }

    public void emprestarLivro(Cliente c, Livro l, LocalDate dataEmprestimo, LocalDate prazo){
        if(l.isDisponivel()){
            Emprestimo e = new Emprestimo(c, l, dataEmprestimo, prazo);
            emprestimos.add(e);
            l.setIsDisponivel(false);
            System.out.println("Livro emprestado com sucesso.");
        }
        System.out.println("Livro indisponível para emprestimo.");
    }


}
