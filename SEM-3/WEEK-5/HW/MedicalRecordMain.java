import java.time.LocalDate;
import java.util.*;


public class MedicalRecordMain {
    public static void main(String[] args) {
        MedicalRecord record = new MedicalRecord("R123", "DNA-XYZ", new String[]{"Peanuts", "Dust"}, new String[]{"Flu", "Chickenpox"}, LocalDate.of(1990, 5, 15), "O+");
        Patient patient1 = new Patient("Alice", "Bob", "InsuranceCo", 101, "Dr. Smith", record);
        Doctor doctor = new Doctor("DOC123", "Cardiology", Set.of("ACLS", "BLS"));
        Nurse nurse = new Nurse("NUR456", "Night", Arrays.asList("ICU", "ER"));
        Administrator admin = new Administrator("ADM789", Arrays.asList("FullAccess"));

        HospitalSystem system = new HospitalSystem();
        System.out.println(system.admitPatient(patient1, doctor));
        System.out.println(system);

        System.out.println(patient1.getPublicInfo());
        System.out.println(record.isAllergicTo("Peanuts"));
    }
}


final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory, LocalDate birthDate, String bloodType) {
        if (recordId == null || recordId.isEmpty() || patientDNA == null || birthDate == null || bloodType == null) {
            throw new IllegalArgumentException("Invalid medical record data");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies == null ? new String[0] : Arrays.copyOf(allergies, allergies.length);
        this.medicalHistory = medicalHistory == null ? new String[0] : Arrays.copyOf(medicalHistory, medicalHistory.length);
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return Arrays.copyOf(allergies, allergies.length); }
    public String[] getMedicalHistory() { return Arrays.copyOf(medicalHistory, medicalHistory.length); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String a : allergies) {
            if (a.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", birthDate=" + birthDate +
                ", bloodType='" + bloodType + '\'' +
                ", allergies=" + Arrays.toString(allergies) +
                ", history=" + Arrays.toString(medicalHistory) +
                '}';
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    public Patient(String name) {
        this(UUID.randomUUID().toString(), new MedicalRecord(UUID.randomUUID().toString(), "TEMP", null, null, LocalDate.now(), "Unknown"), name, "Unknown", "None", 0, "None");
    }

    public Patient(String name, String contact, String insurance, int room, String physician, MedicalRecord record) {
        this(UUID.randomUUID().toString(), record, name, contact, insurance, room, physician);
    }

    public Patient(String id, MedicalRecord record, String name, String contact, String insurance, int room, String physician) {
        if (id == null || id.isEmpty() || record == null) throw new IllegalArgumentException("Invalid patient data");
        this.patientId = id;
        this.medicalRecord = record;
        this.currentName = name;
        this.emergencyContact = contact;
        this.insuranceInfo = insurance;
        this.roomNumber = room;
        this.attendingPhysician = physician;
    }

    String getBasicInfo() {
        return "PatientID: " + patientId + ", Name: " + currentName + ", Physician: " + attendingPhysician;
    }

    public String getPublicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber;
    }

    public String getPatientId() { return patientId; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public String getCurrentName() { return currentName; }
    public void setCurrentName(String currentName) { this.currentName = currentName; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }
    public String getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(String insuranceInfo) { this.insuranceInfo = insuranceInfo; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String attendingPhysician) { this.attendingPhysician = attendingPhysician; }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + patientId + '\'' +
                ", name='" + currentName + '\'' +
                ", physician='" + attendingPhysician + '\'' +
                ", room=" + roomNumber +
                '}';
    }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certifications);
    }

    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
    public Set<String> getCertifications() { return new HashSet<>(certifications); }

    @Override
    public String toString() {
        return "Doctor{" +
                "license='" + licenseNumber + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = new ArrayList<>(qualifications);
    }

    public String getNurseId() { return nurseId; }
    public String getShift() { return shift; }
    public List<String> getQualifications() { return new ArrayList<>(qualifications); }

    @Override
    public String toString() {
        return "Nurse{" +
                "id='" + nurseId + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = new ArrayList<>(accessPermissions);
    }

    public String getAdminId() { return adminId; }
    public List<String> getAccessPermissions() { return new ArrayList<>(accessPermissions); }

    @Override
    public String toString() {
        return "Administrator{" +
                "id='" + adminId + '\'' +
                ", permissions=" + accessPermissions +
                '}';
    }
}

class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();

    static final String POLICY_PRIVACY = "STRICT_PRIVACY";
    static final String POLICY_AUDIT = "FULL_AUDIT";

    public boolean admitPatient(Object patient, Object staff) {
        if (!(patient instanceof Patient)) return false;
        if (!validateStaffAccess(staff, patient)) return false;
        patientRegistry.put(((Patient) patient).getPatientId(), patient);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        if (staff instanceof Doctor) return true;
        if (staff instanceof Nurse) return true;
        if (staff instanceof Administrator) return true;
        return false;
    }

    Map<String, Object> getRegistrySnapshot() {
        return new HashMap<>(patientRegistry);
    }

    @Override
    public String toString() {
        return "HospitalSystem{" +
                "patients=" + patientRegistry.keySet() +
                '}';
    }
}