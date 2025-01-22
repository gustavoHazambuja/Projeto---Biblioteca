public class Cliente{
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, String email, String tel){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = tel;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString(){
        return String.format("\nNome: %s" + "\nCPF: %s" + "\nEmail: %s" + "\nTelefone: %s"
        ,nome, cpf, email, telefone);
    }
}