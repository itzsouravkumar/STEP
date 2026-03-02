import java.util.*;

class Patient {
    String patientId;
    String patientName;
    int age;
    String gender;
    String contactInfo;
    String[] medicalHistory;
    String[] currentTreatments;

    public Patient(String patientId, String patientName, int age, String gender, String contactInfo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = new String[10];
        this.currentTreatments = new String[10];
    }

    public void updateTreatment(String treatment) {
        for (int i = 0; i < currentTreatments.length; i++) {
            if (currentTreatments[i] == null) {
                currentTreatments[i] = treatment;
                break;
            }
        }
    }

    public void dischargePatient() {
        Arrays.fill(currentTreatments, null);
    }
}

class Doctor {
    String doctorId;
    String doctorName;
    String specialization;
    String[] availableSlots;
    int patientsHandled;
    double consultationFee;

    public Doctor(String doctorId, String doctorName, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.availableSlots = new String[]{"10:00", "12:00", "15:00"};
        this.patientsHandled = 0;
    }
}

class Appointment {
    String appointmentId;
    Patient patient;
    Doctor doctor;
    String appointmentDate;
    String appointmentTime;
    String status; // Scheduled, Cancelled, Completed
    String type;   // Consultation, Follow-up, Emergency

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String appointmentDate, String appointmentTime, String type) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = "Scheduled";
        this.type = type;
    }
}

class Hospital {
    static int totalPatients = 0;
    static int totalAppointments = 0;
    static String hospitalName = "CityCare Hospital";
    static double totalRevenue = 0.0;

    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();

    public static Appointment scheduleAppointment(Patient patient, Doctor doctor, String date, String time, String type) {
        String id = "APT" + (++totalAppointments);
        Appointment appt = new Appointment(id, patient, doctor, date, time, type);
        appointments.add(appt);
        doctor.patientsHandled++;
        if (!patients.contains(patient)) {
            patients.add(patient);
            totalPatients++;
        }
        return appt;
    }

    public static void cancelAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.appointmentId.equals(appointmentId)) {
                a.status = "Cancelled";
                break;
            }
        }
    }

    public static double generateBill(Appointment appt) {
        double amount = appt.doctor.consultationFee;
        if (appt.type.equalsIgnoreCase("Follow-up")) {
            amount *= 0.5;
        } else if (appt.type.equalsIgnoreCase("Emergency")) {
            amount *= 1.5;
        }
        totalRevenue += amount;
        appt.status = "Completed";
        return amount;
    }

    public static void generateHospitalReport() {
        System.out.println("---- Hospital Report ----");
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Revenue: " + totalRevenue);
    }

    public static void getDoctorUtilization() {
        System.out.println("---- Doctor Utilization ----");
        for (Doctor d : doctors) {
            System.out.println(d.doctorName + " (" + d.specialization + ") handled " + d.patientsHandled + " patients.");
        }
    }

    public static void getPatientStatistics() {
        System.out.println("---- Patient Statistics ----");
        System.out.println("Total Registered Patients: " + patients.size());
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("D1", "Dr. Sharma", "Cardiology", 1000);
        Doctor d2 = new Doctor("D2", "Dr. Mehta", "Neurology", 1200);
        Hospital.doctors.add(d1);
        Hospital.doctors.add(d2);

        Patient p1 = new Patient("P1", "Ayush", 21, "Male", "1234567890");
        Patient p2 = new Patient("P2", "Riya", 25, "Female", "9876543210");

        Appointment a1 = Hospital.scheduleAppointment(p1, d1, "2025-09-05", "10:00", "Consultation");
        Appointment a2 = Hospital.scheduleAppointment(p2, d2, "2025-09-06", "12:00", "Emergency");

        double bill1 = Hospital.generateBill(a1);
        double bill2 = Hospital.generateBill(a2);

        System.out.println("Bill for " + a1.patient.patientName + ": " + bill1);
        System.out.println("Bill for " + a2.patient.patientName + ": " + bill2);

        Hospital.generateHospitalReport();
        Hospital.getDoctorUtilization();
        Hospital.getPatientStatistics();
    }
}