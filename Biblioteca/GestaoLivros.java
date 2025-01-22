import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GestaoLivros {
    Scanner dados = new Scanner(System.in);

    private Set<Livro> livros;

    public GestaoLivros(){
        this.livros = new HashSet<Livro>();
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void cadastrarLivro(){

        try{
            System.out.println("Informe o título do livro");
            String titulo = dados.nextLine();

            if(titulo.isEmpty() || titulo.matches("//d+")){
                throw new IllegalArgumentException("O nome não pode ser vazio ou conter somente números.");
            }

            System.out.println("Informe o autor do livro:");
            String autor = dados.nextLine();

            if(autor.isEmpty() || autor.matches("//d+")){
                throw new IllegalArgumentException("O nome não pode ser vazio ou conter somente números.");
            }

            System.out.println("Informe o gênero do livro:");
            String genero = dados.nextLine();

            if(genero.isEmpty() || genero.matches("//d+")){
                throw new IllegalArgumentException("O nome não pode ser vazio ou conter somente números.");
            }

            System.out.println("Informe o ano de publicação do livro:");
            int ano = dados.nextInt();

            System.out.println("Informe o ISBN do livro:");
            String isbn = dados.nextLine();

            if(isbn.isEmpty()){
                throw new IllegalArgumentException("O ISBN não pode ser vazio.");
            }

            dados.nextLine();
            
            Livro l = new Livro(titulo, genero, autor, ano, isbn);
            livros.add(l);

        } catch(NumberFormatException e){
            System.out.println("Erro. Número inválido");
        } catch(IllegalArgumentException e){
            System.out.println("Erro. " + e.getMessage());
        } catch(Exception e){
            System.out.println("Erro ao cadastrar o livro Verifique os campos e tente novamente.");
        }
    }

    public Livro buscarLivroPorNome(){

        System.out.println("Informe o nome do livro:");
        String titulo = dados.nextLine().toLowerCase();

        Livro livroEncontardo = livros.stream()
            .filter(l -> l.getTitulo().toLowerCase().contains(titulo))
            .findFirst()
            .orElse(null);

            if(livroEncontardo == null){
                System.out.println("Livro não encontrado.");
            }

            return livroEncontardo;
    }

    public void removerLivro(){

        System.out.println("Informe o título do livro para remover: ");
        String titulo = dados.nextLine().toLowerCase();

        for(Livro l: livros){
            if(l.getTitulo().toLowerCase().contains(titulo)){
                System.out.println("Livro removido " + l);
                livros.remove(l);
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
        }
        else{
            for(Livro l: livros){
                System.out.println(l);
            }
        }
    }
}
