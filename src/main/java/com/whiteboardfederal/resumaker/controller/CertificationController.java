package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.Certification;
import com.whiteboardfederal.resumaker.repository.CertificationRepository;
import com.whiteboardfederal.resumaker.utils.EntityMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/certification")
public class CertificationController {

    @Autowired
    CertificationRepository certificationRepository;

    @PostMapping
    Certification create(Certification certification) {
        return certificationRepository.save(certification);
    }

    @GetMapping(value = "/{id}")
    Certification read(@PathVariable final Long id) {
        return certificationRepository.findById(id)
                .orElseThrow(() -> new EntityMissingException("certification", id));
    }

    @PutMapping(value = "/:id")
    Certification update(@PathVariable final Long id, @RequestBody Certification certification) {
        certification.setId(id);
        return certificationRepository.save(certification);
    }

    @DeleteMapping(value = "/:id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable final Long id) {
        certificationRepository.deleteById(id);
    }

    @GetMapping
    List<Certification> query() {
        return certificationRepository.findAll();
    }
}
