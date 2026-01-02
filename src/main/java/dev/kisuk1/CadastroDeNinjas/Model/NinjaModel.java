package dev.kisuk1.CadastroDeNinjas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


//TODO: Entity - Transforma a classe em uma entidade no Banco de Dados (Tabela)
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    //TODO: Atributos - Colunas da tabrla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @Column(unique = true) // Personaliza o atributo 'Email' para ser Unico
    private String email;
    private int idade;

    // @ManyToOne - Muitos ninjas Para Uma unica Missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // ForeingKey ou Chave Estrangeira
    private List<MissoesModel> missoes;

}
