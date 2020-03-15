package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Certification;
import com.whiteboardfederal.resumaker.services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/certification")
public class CertificationController {

    @Autowired
    CertificationService certificationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Certification create(Certification certification) throws InvalidFormException {
        return certificationService.save(certification);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Certification read(@PathVariable final Long id) throws EntityNotFoundException {
        return certificationService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Certification", id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Certification update(@RequestBody Certification certification) throws EntityNotFoundException, InvalidFormException {
        return certificationService.update(certification);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable final Long id) throws EntityNotFoundException {
        certificationService.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Certification> query() {
        return certificationService.findAll();
    }
}
