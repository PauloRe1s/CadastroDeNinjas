package dev.kisuk1.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/test")
    public  String routeTest() {
        return "Olá, eu sou um Ninja ... Shuuu .";
    }

}
