package be.technocite.oneToOneUni.idString;

import javax.persistence.*;

@Entity
@Table(name = "medical_case")
public class MedicalCase {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @Basic(optional = false)
    @Column(updatable = false)
    private PatientData address;

    @OneToMany(cascade = CascadeType.ALL)
    @Basic(optional = false)
    private String illnessId;

    protected MedicalCase() {
    }

    public MedicalCase(PatientData address, String illnessId) {
        this.address = address;
        this.illnessId = illnessId;
    }
}
