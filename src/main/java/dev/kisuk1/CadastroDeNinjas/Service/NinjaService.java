package dev.kisuk1.CadastroDeNinjas.Service;

import dev.kisuk1.CadastroDeNinjas.Model.NinjaModel;
import dev.kisuk1.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel createNinja(NinjaModel newNinja) {
        return ninjaRepository.save(newNinja);
    }

    public List<NinjaModel> readAllNinja() {
        return ninjaRepository.findAll();
    }

    public NinjaModel readByIdNinja(Long id) {
        Optional<NinjaModel> ninjExists = ninjaRepository.findById(id);
        return ninjExists.orElse(null);
    }

    public NinjaModel updateNinja(Long id, NinjaModel upNinja) {
        Optional<NinjaModel> ninjaExists = ninjaRepository.findById(id);
        if (ninjaExists.isPresent()) {
            upNinja.setId(id);
            return ninjaRepository.save(upNinja);
        }
        return null;
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
