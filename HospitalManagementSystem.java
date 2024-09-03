import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    // Patient class to store patient details
    static class Patient {
        private int id;
        private String name;
        private int age;
        private String gender;
        private String contactInfo;

        public Patient(int id, String name, int age, String gender, String contactInfo) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.contactInfo = contactInfo;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact Info: " + contactInfo;
        }
    }

    // ArrayList to store registered patients
    private ArrayList<Patient> patients;
    private int nextId = 1;

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
    }

    // Method to register a new patient
    public void registerPatient(String name, int age, String gender, String contactInfo) {
        Patient newPatient = new Patient(nextId++, name, age, gender, contactInfo);
        patients.add(newPatient);
        System.out.println("Patient registered successfully with ID: " + newPatient.getId());
    }

    // Method to view all registered patients
    public void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    // Method to delete a patient by ID
    public void deletePatient(int id) {
        Patient patientToRemove = null;
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                patientToRemove = patient;
                break;
            }
        }

        if (patientToRemove != null) {
            patients.remove(patientToRemove);
            System.out.println("Patient with ID " + id + " has been removed.");
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem hms = new HospitalManagementSystem();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter contact info: ");
                    String contactInfo = scanner.nextLine();
                    hms.registerPatient(name, age, gender, contactInfo);
                    break;
                case 2:
                    hms.viewAllPatients();
                    break;
                case 3:
                    System.out.print("Enter patient ID to delete: ");
                    int id = scanner.nextInt();
                    hms.deletePatient(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
