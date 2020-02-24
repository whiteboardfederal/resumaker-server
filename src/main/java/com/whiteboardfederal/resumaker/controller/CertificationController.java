package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.Certification;
import com.whiteboardfederal.resumaker.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/certification")
public class CertificationController {

    @Autowired
    CertificationRepository certificationRepository;

    @PostMapping
    Certification create() {
        return null;
    }

    @GetMapping(value = "/:id")
    Certification read() {
        return null;
    }

    @PutMapping(value = "/:id")
    Certification update() {
        return null;
    }

    @DeleteMapping(value = "/:id")
    Certification delete() {
        return null;
    }

    @GetMapping
    List<Certification> query() {
        return null;
    }
}
