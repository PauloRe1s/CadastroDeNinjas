package dev.kisuk1.CadastroDeNinjas.Controller;

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
    public MissaoModel postMissao(@RequestBody MissaoModel newMissao) {
        return missaoService.createMissao(newMissao);
    }

    @GetMapping("/getAll")
    public List<MissaoModel> getAllMissao() {
        return missaoService.readAllMissao();
    }

    @GetMapping("/getById/{id}")
    public MissaoModel getByIdMissao(@PathVariable Long id) {
        return missaoService.readByIdMissao(id);
    }

    @PutMapping("/put/{id}")
    public MissaoModel putMissao(@PathVariable Long id, @RequestBody MissaoModel upMissao) {
        return missaoService.updateMissao(id, upMissao);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMissao(@PathVariable Long id) {
        missaoService.deleteMissao(id);
    }
}
