package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Livro;
import application.repository.AutorRepository;
import application.repository.GeneroRepository;
import application.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository generoRepo;
    @Autowired
    private AutorRepository autorRepo;

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("autores", autorRepo.findAll());
        return "/livros/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("id_genero") long id_genero,
        @RequestParam("autores") long[] ids_autores) {

        Optional<Genero> genero = generoRepo.findById(id_genero);

        if(genero.isPresent()) {
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setGenero(genero.get());

            livroRepo.save(livro);
        }

        return "redirect:/livros/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("livros", livroRepo.findAll());

        return "/livros/list";
    }
}
