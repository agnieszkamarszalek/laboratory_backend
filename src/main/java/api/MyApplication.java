package api;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(PatientEndpoint.class);
        return classes;
    }

}
