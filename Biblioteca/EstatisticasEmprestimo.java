import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EstatisticasEmprestimo {
    
    private Set<Emprestimo> emprestimos;

    public EstatisticasEmprestimo(){
        this.emprestimos = new HashSet<Emprestimo>();
    }

    public int totalEmprestimos(){
        return emprestimos.size();
    }

    public int emprestimosAtrasados(){
        return (int) emprestimos.stream()
            .filter(e -> e.isAtrasado())
            .count();
    }

    public int emprestimosEmAberto(){
        return (int) emprestimos.stream()
            .filter(e -> !e.isAtrasado())
            .count();
    }

    public double percentualDevolucaoNoPrazo(){
        double devolvidosNoPrazo = emprestimos.stream()
            .filter(e -> e.isDevolvido())
            .filter(e -> !e.isAtrasado())
            .count();

        double totalDevolvidos = emprestimos.stream()
            .filter(e -> e.isDevolvido())
            .count(); 
            
            if(totalDevolvidos == 0){
                return 0.0;
            }
            return (devolvidosNoPrazo * 100) / totalDevolvidos;
    }

    public List<Livro> livrosMaisEmprestados(){
        return emprestimos.stream()
           .collect(Collectors.groupingBy(Emprestimo::getLivros, Collectors.counting())) // Agrupa e conta
           .entrySet().stream()
           .sorted((e1,e2) -> Long.compare(e2.getValue(), e1.getValue())) // Ordena por contagem decrescente
           .map(Map.Entry::getKey) // Extrai os livros (chave do mapa)
           .collect(Collectors.toList());
    }

    public List<Cliente> clientesMaisEmprestimos(){
        return emprestimos.stream()
            .collect(Collectors.groupingBy(Emprestimo::getClientes, Collectors.counting()))
            .entrySet().stream()
            .sorted((e1,e2) -> Long.compare(e2.getValue(), e1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

}
