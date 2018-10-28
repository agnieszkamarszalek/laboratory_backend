package infrastructure;

import javax.persistence.*;

@Entity
public class Patient {
    @GeneratedValue
    @Id
    //TODO name column
    private int id;
    private String firstName = "NN";
    private String lastName = "NN";
    private String pesel = null;
    private String gender = "Inne";
    private String phoneNumber = " ";

    public Patient(String firstName, String lastName, String pesel, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static PatientBuilder builder(){
        return new PatientBuilder();
    }

    public static PatientBuilder builder(Patient patient){return new PatientBuilder();}

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class PatientBuilder{
        private String firstName = "NN";
        private String lastName = "NN";
        private String pesel = "unknown";
        private String gender = "K";
        private String phoneNumber = "";

        public PatientBuilder() {
        }

        public PatientBuilder(Patient patient){
            this.firstName = patient.firstName;
            this.lastName = patient.lastName;
            this.pesel = patient.pesel;
            this.gender = patient.gender;
            this.phoneNumber = patient.phoneNumber;

        }

        public PatientBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PatientBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PatientBuilder pesel(String pesel){
            this.pesel = pesel;
            return this;
        }

        public PatientBuilder gender(String gender){
            this.gender = gender;
            return this;
        }

        public PatientBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Patient build(){return new Patient(firstName, lastName, pesel, gender, phoneNumber);}
    }
}
