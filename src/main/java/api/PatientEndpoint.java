package api;

import domain.model.RegistrationOffice;
import infrastructure.Patient;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("patient/{pesel}")
public class PatientEndpoint {
    @GET
    @Produces("text/plain")
    public String getPatient(@PathParam("pesel") String pesel){
        RegistrationOffice registrationOffice = new RegistrationOffice();
        Patient patientByPesel = registrationOffice.findPatientByPesel(pesel);
        ObjectMapper objectMapper = new ObjectMapper();
        String patientString = "";
        try {
            patientString = objectMapper.writeValueAsString(patientByPesel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patientString;

//        return "Hello world";
    }
}
