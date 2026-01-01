package dev.kisuk1.CadastroDeNinjas.Model;

import jakarta.persistence.*;


//TODO: Entity - Transforma a classe em uma entidade no Banco de Dados (Tabela)
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    //TODO: Atributos - Colunas da tabrla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //TODO: NoArgsConstructors
    public NinjaModel() {}

    //TODO: AllArgsConstructors
    public NinjaModel(Long id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    //TODO: Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() { return idade; }
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
