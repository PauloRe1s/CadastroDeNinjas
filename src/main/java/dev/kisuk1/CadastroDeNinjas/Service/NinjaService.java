package dev.kisuk1.CadastroDeNinjas.Service;

import dev.kisuk1.CadastroDeNinjas.DTO.NinjaDTO;
import dev.kisuk1.CadastroDeNinjas.Mapper.NinjaMapper;
import dev.kisuk1.CadastroDeNinjas.Model.NinjaModel;
import dev.kisuk1.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO createNinja(NinjaDTO newNinjaDTO) {
        NinjaModel newNinjaModel = ninjaMapper.map(newNinjaDTO);
        NinjaModel ninjaSave = ninjaRepository.save(newNinjaModel);
        return ninjaMapper.map(ninjaSave);
    }

    public List<NinjaDTO> readAllNinja() {
        List<NinjaModel> ninjaList = ninjaRepository.findAll();
        return ninjaList.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO readByIdNinja(Long id) {
        Optional<NinjaModel> ninjExists = ninjaRepository.findById(id);
        return ninjExists.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO upNinjaDTO) {
        Optional<NinjaModel> ninjaExists = ninjaRepository.findById(id);
        if (ninjaExists.isPresent()) {
            NinjaModel upNinjaModel = ninjaMapper.map(upNinjaDTO);
            upNinjaDTO.setId(id);
            NinjaModel ninjaSaveModel = ninjaRepository.save(upNinjaModel);
            return ninjaMapper.map(ninjaSaveModel);
        }
        return null;
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
