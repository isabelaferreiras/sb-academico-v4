package br.edu.fema.domain.curso.model;


import br.edu.fema.infra.framework.annotations.MateriaValidation;
import br.edu.fema.infra.framework.annotations.NameValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(of = {"id", "nomeCurso", "materias", "periodo"})
@EqualsAndHashCode(of = {"id"})
public class Curso {

    @NotBlank(message = "ID deve ser informado")
    private String id;

    //colocar o namevalidation
    @NotBlank(message = "Nome do curso deve ser informado")
    @NameValidation
    private String nomeCurso;
    @NotEmpty(message = "Matérias devem ser informadas")
    @MateriaValidation
    private List<String> materias;
    @NotBlank(message = "Período deve ser informado")
    private String periodo;

    public Curso(String id, String nomeCurso, List<String> materias, String periodo) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.materias = materias;
        this.periodo = periodo;
    }
}
