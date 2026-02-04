package dev.kisuk1.CadastroDeNinjas.Controller;

import dev.kisuk1.CadastroDeNinjas.DTO.MissaoDTO;
import dev.kisuk1.CadastroDeNinjas.Model.MissaoModel;
import dev.kisuk1.CadastroDeNinjas.Service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/post")
    public MissaoDTO postMissao(@RequestBody MissaoDTO newMissaoDTO) {
        return missaoService.createMissao(newMissaoDTO);
    }

    @GetMapping("/getAll")
    public List<MissaoDTO> getAllMissao() {
        return missaoService.readAllMissao();
    }

    @GetMapping("/getById/{id}")
    public MissaoDTO getByIdMissao(@PathVariable Long id) {
        return missaoService.readByIdMissao(id);
    }

    @PutMapping("/put/{id}")
    public MissaoDTO putMissao(@PathVariable Long id, @RequestBody MissaoDTO upMissaoDTO) {
        return missaoService.updateMissao(id, upMissaoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMissao(@PathVariable Long id) {
        missaoService.deleteMissao(id);
    }
}
