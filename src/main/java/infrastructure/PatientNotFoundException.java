package infrastructure;

public class PatientNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Nie znaleziono pacjenta.";
    }
}
