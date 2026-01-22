package dev.kisuk1.CadastroDeNinjas.Repository;

import dev.kisuk1.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
