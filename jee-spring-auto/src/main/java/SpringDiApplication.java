import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.PersonService;


public class SpringDiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);



        PersonService person = context.getBean(PersonService.class);
        System.out.println(person.getPersonRepository().getClass().getName());



        context.close();


    }

}
