package dev.kisuk1.CadastroDeNinjas.Repository;

import dev.kisuk1.CadastroDeNinjas.Model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}
