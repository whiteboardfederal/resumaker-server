package com.whiteboardfederal.resumaker.services;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Certification;
import com.whiteboardfederal.resumaker.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    CertificationRepository certificationRepository;

    public Certification save(Certification certification) throws InvalidFormException {
        return certificationRepository.save(certification);
    }

    public List<Certification> findAll() {
        return certificationRepository.findAll();
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Certification", id));

        certificationRepository.delete(certification);
    }

    public Optional<Certification> findById(Long id) {
        return certificationRepository.findById(id);
    }

    public Certification update(Certification certification) throws EntityNotFoundException, InvalidFormException {
        Long id = certification.getId();
        if (!certificationRepository.existsById(id)) {
            throw new EntityNotFoundException("Certification", id);
        }

        return certificationRepository.save(certification);
    }
}