import java.time.LocalDate;

public class Emprestimo{

    private Cliente clientes;
    private Livro livros;
    private LocalDate dataEmprestimo;
    private LocalDate prazoDevolucao;
    private boolean devolvido;

    public Emprestimo(Cliente c, Livro l, LocalDate dataEmprestimo, LocalDate prazo){
        this.clientes = c;
        this.livros = l;
        this.dataEmprestimo = dataEmprestimo;
        this.prazoDevolucao = prazo;
        this.devolvido = false;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public Livro getLivros() {
        return livros;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getPrazoDevolucao() {
        return prazoDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void SetDevolvido(boolean devolvido){
        this.devolvido = devolvido;
    }

    public void devolverLivro(Emprestimo e){
        if(!devolvido){
            this.devolvido = true;
            e.getLivros().setIsDisponivel(true);
            System.out.println("Livro devolvido com sucesso.");
        }
        System.out.println("O livro já foi devolvido.");
    }

    public boolean isAtrasado(){
        return !devolvido && LocalDate.now().isAfter(prazoDevolucao);
    }
}