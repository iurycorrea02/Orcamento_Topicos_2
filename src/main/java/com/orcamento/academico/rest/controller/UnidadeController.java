package com.orcamento.academico.rest.controller;

import com.orcamento.academico.rest.dto.UnidadeDto;
import com.orcamento.academico.rest.form.unidade.UnidadeForm;
import com.orcamento.academico.rest.form.unidade.UnidadeUpdateForm;
import com.orcamento.academico.service.UnidadeService;
import com.orcamento.academico.service.exceptions.ConstraintException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService UnidadeService;

    @GetMapping
    public ResponseEntity<List<UnidadeDto>> findAll() {
        List<UnidadeDto> unidadeDtoList = UnidadeService.findAll();
        return ResponseEntity.ok().body(unidadeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeDto> find(@PathVariable("id") long id) {
        UnidadeDto unidadeDto = UnidadeService.findById(id);
        return ResponseEntity.ok().body(unidadeDto);
    }

    @PostMapping
    public ResponseEntity<UnidadeDto> insert(@Valid @RequestBody UnidadeForm unidadeForm,
                                             BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());

        UnidadeDto unidadeDto = UnidadeService.insert(unidadeForm);
        return ResponseEntity.ok().body(unidadeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDto> update(@Valid @RequestBody UnidadeUpdateForm unidadeUpdateForm,
                                                   @PathVariable("id") long id, BindingResult br) {
        if (br.hasErrors())
            throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());

        UnidadeDto unidadeDto = UnidadeService.update(unidadeUpdateForm, id);
        return ResponseEntity.ok().body(unidadeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        UnidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

