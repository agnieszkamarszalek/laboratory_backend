package infrastructure;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements domain.port.PatientRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void addPatient(Patient patient) {
        //TODO pesels can't be repeated
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Patient findPatientByPesel(String pesel) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT p from Patient p where p.pesel = :pesel ");
        query.setParameter("pesel", pesel);
        Patient patient = (Patient) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return patient;
    }

    public List<Patient> findPatientByFirstAndSecondName(String firstName, String lastName) throws Exception {
        entityManager.getTransaction().begin();
        List<Patient> resultList = new ArrayList<Patient>();
        try {
            Query query = entityManager.createQuery("SELECT p from Patient p where p.firstName = :firstName and p.lastName = :lastName");
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            resultList = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            try {
                entityManager.getTransaction().rollback();
            } catch (RuntimeException rollbackException) {
            }
            throw new PatientNotFoundException();
        } finally {
            entityManager.close();
        }
        return resultList;
    }

    public void upadatePatient(Patient patient) {
        int id = patient.getId();
        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createQuery("SELECT p from Patient p where p.id = :id");
            query.setParameter("id", id);
            Patient patientFound = (Patient) query.getSingleResult();
            patientFound.setFirstName(patient.getFirstName());
            patientFound.setLastName(patient.getLastName());
            patientFound.setPesel(patient.getPesel());
            patientFound.setGender(patient.getGender());
            patientFound.setPhoneNumber(patient.getPhoneNumber());
            entityManager.getTransaction().commit();
        } catch (HibernateException he) {
            try {
                entityManager.getTransaction().rollback();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            he.printStackTrace();
        } finally {
            entityManager.close();
        }

    }


}
