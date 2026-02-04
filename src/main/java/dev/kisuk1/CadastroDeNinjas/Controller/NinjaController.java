package dev.kisuk1.CadastroDeNinjas.Controller;

import dev.kisuk1.CadastroDeNinjas.DTO.NinjaDTO;
import dev.kisuk1.CadastroDeNinjas.Mapper.NinjaMapper;
import dev.kisuk1.CadastroDeNinjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/test")
    public  String routeTest() {
        return "Olá, eu sou um Ninja ... Shuuu .";
    }

    @PostMapping("/post")
    public NinjaDTO postNinja(@RequestBody NinjaDTO newNinjaDTO) {
        return ninjaService.createNinja(newNinjaDTO);
    }

    @GetMapping("/getAll")
    public List<NinjaDTO> getAllNinja() {
        return ninjaService.readAllNinja();
    }

    @GetMapping("/getById/{id}")
    public NinjaDTO getByIdNinja(@PathVariable Long id) {
        return ninjaService.readByIdNinja(id);
    }

    @PutMapping("/put/{id}")
    public NinjaDTO putNinja(@PathVariable Long id, @RequestBody NinjaDTO upNinjaDTO) {
        return ninjaService.updateNinja(id, upNinjaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }
}
