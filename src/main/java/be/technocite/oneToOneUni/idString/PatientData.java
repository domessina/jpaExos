package be.technocite.oneToOneUni.idString;

public class PatientData {

    private String NISS;
    private String bloodType;
    private String gender;

    protected PatientData() {
    }

    public PatientData(String NISS, String bloodType, String gender) {
        this.NISS = NISS;
        this.bloodType = bloodType;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PatientData{" +
                "NISS='" + NISS + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
