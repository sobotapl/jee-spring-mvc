package pl.coderslab.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.beans.PersonRepository;

//@Component
@Service
public class PersonService {

    private PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
