package dev.kisuk1.CadastroDeNinjas.Controller;

import dev.kisuk1.CadastroDeNinjas.Model.NinjaModel;
import dev.kisuk1.CadastroDeNinjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/test")
    public  String routeTest() {
        return "Olá, eu sou um Ninja ... Shuuu .";
    }

    @PostMapping("/post")
    public NinjaModel postNinja(@RequestBody NinjaModel newNinja) {
        return ninjaService.createNinja(newNinja);
    }

    @GetMapping("/getAll")
    public List<NinjaModel> getAllNinja() {
        return ninjaService.readAllNinja();
    }

    @GetMapping("/getById/{id}")
    public NinjaModel getByIdNinja(@PathVariable Long id) {
        return ninjaService.readByIdNinja(id);
    }

    @PutMapping("/put/{id}")
    public NinjaModel putNinja(@PathVariable Long id, @RequestBody NinjaModel upNinja) {
        return ninjaService.updateNinja(id, upNinja);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }
}
