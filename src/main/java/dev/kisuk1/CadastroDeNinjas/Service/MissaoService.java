package dev.kisuk1.CadastroDeNinjas.Service;

import dev.kisuk1.CadastroDeNinjas.DTO.MissaoDTO;
import dev.kisuk1.CadastroDeNinjas.Mapper.MissaoMapper;
import dev.kisuk1.CadastroDeNinjas.Model.MissaoModel;
import dev.kisuk1.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO createMissao(MissaoDTO newMissaoDTO) {
        MissaoModel newMissaoModel = missaoMapper.map(newMissaoDTO);
        MissaoModel missaoModelSave = missaoRepository.save(newMissaoModel);
        return missaoMapper.map(missaoModelSave);
    }

    public List<MissaoDTO> readAllMissao() {
        List<MissaoModel> listMissaoModel = missaoRepository.findAll();
        return listMissaoModel.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO readByIdMissao(Long id) {
        Optional<MissaoModel> missaoExists  = missaoRepository.findById(id);
        return missaoExists.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO updateMissao(Long id, MissaoDTO upMissaoDTO) {
        Optional<MissaoModel> missaoExists = missaoRepository.findById(id);
        if (missaoExists.isPresent()) {
            MissaoModel upMissaoModel = missaoMapper.map(upMissaoDTO);
            upMissaoDTO.setId(id);
            MissaoModel missaoModelSave = missaoRepository.save(upMissaoModel);
            return missaoMapper.map(missaoModelSave);
        }
        return null;
    }

    public void deleteMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
