package dev.kisuk1.CadastroDeNinjas.Controller;

import jakarta.persistence.*;

//TODO: Entity - Transforma a classe em uma entidade no Banco de Dados (Tabela)
@Entity
@Table(name = "tb_cadastro")
public class NinjaController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;

    public NinjaController() {}

    public NinjaController(Long id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

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
