package br.edu.fema.adapter.in.api;

import br.edu.fema.domain.curso.model.Curso;
import br.edu.fema.domain.curso.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(repository.findALL());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findByID(
            @PathVariable("id") String id) {
        return ResponseEntity.ok(repository.findByID(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<Curso> insert(
            @RequestBody @Valid Curso curso){
        return ResponseEntity.ok(repository.insert(curso));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(repository.delete(id));
    }

}
