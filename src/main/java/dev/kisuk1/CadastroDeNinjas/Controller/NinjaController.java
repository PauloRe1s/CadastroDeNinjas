package dev.kisuk1.CadastroDeNinjas.Controller;

import dev.kisuk1.CadastroDeNinjas.DTO.NinjaDTO;
import dev.kisuk1.CadastroDeNinjas.Mapper.NinjaMapper;
import dev.kisuk1.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> postNinja(@RequestBody NinjaDTO newNinjaDTO) {
        NinjaDTO postNinjaResponse = ninjaService.createNinja(newNinjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com Sucesso. Nome: " + postNinjaResponse.getNome());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<NinjaDTO>> getAllNinja() {
        List<NinjaDTO> listNinjaResponse = ninjaService.readAllNinja();
        return ResponseEntity.ok(listNinjaResponse);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdNinja(@PathVariable Long id) {
        NinjaDTO ninjaIdResponse = ninjaService.readByIdNinja(id);
        if (ninjaIdResponse != null) {
            return ResponseEntity.ok(ninjaIdResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não existe em nossa Base de Dados.");
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putNinja(@PathVariable Long id, @RequestBody NinjaDTO upNinjaDTO) {
        if (ninjaService.readByIdNinja(id) != null) {
            NinjaDTO upNinjaResponse = ninjaService.updateNinja(id, upNinjaDTO);
            return ResponseEntity.ok(upNinjaResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não existe em nossa Base de Dados.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {
        if (ninjaService.readByIdNinja(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja Deletado com Sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não existe em nossa Base de Dados.");
        }
    }
}
