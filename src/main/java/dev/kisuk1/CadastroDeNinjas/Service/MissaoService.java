package dev.kisuk1.CadastroDeNinjas.Service;

import dev.kisuk1.CadastroDeNinjas.Model.MissaoModel;
import dev.kisuk1.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel createMissao(MissaoModel newMissao) {
        return missaoRepository.save(newMissao);
    }

    public List<MissaoModel> readAllMissao() {
        return missaoRepository.findAll();
    }

    public MissaoModel readByIdMissao(Long id) {
        Optional<MissaoModel> missaoExists  = missaoRepository.findById(id);
        return missaoExists.orElse(null);
    }

    public MissaoModel updateMissao(Long id, MissaoModel upMissao) {
        Optional<MissaoModel> missaoExists = missaoRepository.findById(id);
        if (missaoExists.isPresent()) {
            upMissao.setId(id);
            return missaoRepository.save(upMissao);
        }
        return null;
    }

    public void deleteMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
