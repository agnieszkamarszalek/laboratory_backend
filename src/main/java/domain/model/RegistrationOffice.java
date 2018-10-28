package domain.model;

import domain.port.PatientRepository;
import domain.port.TestRepository;
import infrastructure.Patient;

import java.util.List;

public class RegistrationOffice {

    private PatientRepository patientRepository = new infrastructure.PatientRepository();
    private TestRepository testRepository;

    public void registratePatient(Patient patient) {
        patientRepository.addPatient(patient);

    }

    public Patient findPatientByPesel(String pesel) {
        return patientRepository.findPatientByPesel(pesel);
    }

    public List<Patient> findPatientByFirstAndSecondName(String firstName, String lastName) throws Exception {
        return patientRepository.findPatientByFirstAndSecondName(firstName, lastName);
    }

    public Patient editPatient(Patient patient) {
        patientRepository.upadatePatient(patient);

        return null;
    }
}
