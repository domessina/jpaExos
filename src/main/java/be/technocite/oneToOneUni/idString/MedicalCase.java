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

    @Basic(optional = false)
    private Long illnessId;

    protected MedicalCase() {
    }

    public MedicalCase(PatientData address, Long illnessId) {
        this.address = address;
        this.illnessId = illnessId;
    }

    @Override
    public String toString() {
        return "MedicalCase{" +
                "id=" + id +
                ", address=" + address +
                ", illnessId=" + illnessId +
                '}';
    }
}
