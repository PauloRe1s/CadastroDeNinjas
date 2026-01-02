package dev.kisuk1.CadastroDeNinjas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//TODO: Entity - Transforma a classe em uma entidade no Banco de Dados (Tabela)
@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    //TODO: Atributos - Colunas da tabrla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String dificuldade;

    //@OneToMany - Uma unica Missão Para varios Ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
