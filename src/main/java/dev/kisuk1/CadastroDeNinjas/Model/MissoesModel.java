package dev.kisuk1.CadastroDeNinjas.Model;


import jakarta.persistence.*;

import java.util.List;

//TODO: Entity - Transforma a classe em uma entidade no Banco de Dados (Tabela)
@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    //TODO: Atributos - Colunas da tabrla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String dificuldade;

    //@OneToMany - Uma unica Missão Para varios Ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    //TODO: NoArgrsConstructors
    public MissoesModel() {}

    //TODO: AllArgsConstructors
    public MissoesModel(String nome, String dificuldade, List<NinjaModel> ninjas){
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
    }

    //TODO: Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() { return dificuldade; }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjas() { return ninjas; }
    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
