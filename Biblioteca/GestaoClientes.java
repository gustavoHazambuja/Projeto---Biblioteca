import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class GestaoClientes {
    Scanner dados = new Scanner(System.in);

    private Set<Cliente> clientes;
    
    public GestaoClientes(){
        this.clientes = new HashSet<Cliente>();
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void cadastrarCliente(){

        try{

            System.out.println("Informe o nome do cliente:");
            String nome = dados.nextLine();

            if(nome.isEmpty() || nome.matches("//d+")){
                throw new IllegalArgumentException("O nome do cliente deve conter letras e não pode ser vazio ou apenas números.");
            }

            System.out.println("Informe o CPF do cliente:");
            String cpf = dados.nextLine();

            if(cpf.isEmpty()){
                throw new IllegalArgumentException("O CPF do cliente não pode ser vazio.");
            }

            System.out.println("Informe o email do cliente:");
            String email = dados.nextLine();

            if(email.isEmpty() || isEmailValido(email)){
                throw new IllegalArgumentException("Email inválido.");
            }

            System.out.println("Informe o telefone do cliente");
            String tel = dados.nextLine();

            if(tel.isEmpty()){
                throw new IllegalArgumentException("O telefone do cliente não pode ser vazio.");
            }

            dados.nextLine();

            Cliente c = new Cliente(nome, cpf, email, tel);
            clientes.add(c);

        } catch(IllegalArgumentException e){
            System.out.println("Erro. " + e.getMessage());
        } catch(Exception e){
            System.out.println("Erro ao cadastrar o cliente. Verifique os campos e tente novamente.");
        }
    }

    public static boolean isEmailValido(String email){
         String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public void listarClientes(){
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado");
        }
        else{
            for(Cliente c: clientes){
                System.out.println(c);
            }
        }
    }

}
