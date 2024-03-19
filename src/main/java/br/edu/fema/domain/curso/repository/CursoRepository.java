package br.edu.fema.domain.curso.repository;

import br.edu.fema.domain.curso.exceptions.CursoDuplicatedException;
import br.edu.fema.domain.curso.exceptions.CursoNotFoundException;
import br.edu.fema.domain.curso.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CursoRepository {

    private final Map<String, Curso> CURSOS =
            new LinkedHashMap<>();

    public List<Curso> findALL() {
        //select * from cursos
        return List.copyOf(CURSOS.values());
    }

    public Curso findByID(String id) {
        //select * from alunos where ra = ?
        final Curso cursoRecuperado = Optional.ofNullable(CURSOS.get(id))
                .orElseThrow(() -> new CursoNotFoundException(id));
        return cursoRecuperado;
    }

    public Curso insert(Curso curso) {
        if (CURSOS.containsKey(curso.getId())) {
            throw new CursoDuplicatedException(curso.getId());
        }
        CURSOS.put(curso.getId(), curso);
        return curso;
    }

    public Curso delete(String id) {
        final Curso cursoParaDeletar = Optional.ofNullable(CURSOS.get(id))
                .orElseThrow(() -> new CursoNotFoundException(id));

         return CURSOS.remove(id);
    }

}
