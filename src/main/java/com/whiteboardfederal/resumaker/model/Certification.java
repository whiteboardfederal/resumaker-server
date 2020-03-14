package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "This certification tied to the person")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated certification ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @ApiModelProperty(notes = "The person tied to the certification")
    private Person person;

    @ApiModelProperty(notes = "The date the certification was achieved")
    private Date dateCertified;

//    @OneToOne
//    @JoinColumn(name = "ref_certification_id")
//    private RefCertification refCertification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDateCertified() {
        return dateCertified;
    }

    public void setDateCertified(Date dateCertified) {
        this.dateCertified = dateCertified;
    }

//    public RefCertification getRefCertification() {
//        return refCertification;
//    }
//
//    public void setRefCertification(RefCertification refCertification) {
//        this.refCertification = refCertification;
//    }
}


