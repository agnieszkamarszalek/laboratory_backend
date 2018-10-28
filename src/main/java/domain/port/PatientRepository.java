package domain.port;

import infrastructure.Patient;
import infrastructure.Patient;

import java.util.List;

public interface PatientRepository {
    void addPatient(Patient patient);
    Patient findPatientByPesel(String pesel);
    List<Patient> findPatientByFirstAndSecondName(String firstName, String lastName) throws Exception;
    void upadatePatient(Patient patient);
}
