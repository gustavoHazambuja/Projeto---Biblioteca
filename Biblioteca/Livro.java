public class Livro {
    
    private String titulo;
    private String genero;
    private String autor;
    private int anoPublicacao;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String genero, String autor, int ano, String isbn){
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.anoPublicacao = ano;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setIsDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("\nTítulo: %s" + "\nGênero: %s" + "\nAutor: %s" + "\nAno de publicação: %d" + "\nISBN: %s"
        , titulo, genero, autor, anoPublicacao, isbn);
    }

}
