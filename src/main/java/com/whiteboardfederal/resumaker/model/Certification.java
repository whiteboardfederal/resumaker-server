package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date dateCertified;

//    @OneToOne
//    @JoinColumn(name = "ref_certification_id")
//    private RefCertification refCertification;

}


