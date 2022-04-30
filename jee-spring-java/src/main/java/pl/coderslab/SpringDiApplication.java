package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.ScopePrototype;
import pl.coderslab.beans.ScopeSingleton;
import pl.coderslab.beans.Ship;

public class SpringDiApplication {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //nazwa metody
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.hello();

        Ship ship = context.getBean("blackPearl", Ship.class);
        ship.getCapitan().startSailing();

        ScopePrototype sp= context.getBean("scopePrototype", ScopePrototype.class);
        ScopePrototype sp1= context.getBean("scopePrototype", ScopePrototype.class);

        ScopeSingleton ss= context.getBean("scopeSingleton", ScopeSingleton.class);
        ScopeSingleton ss1= context.getBean("scopeSingleton", ScopeSingleton.class);



        ScopeSingleton singleton1 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton1);
        ScopeSingleton singleton2 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton2);
        System.out.println((singleton1 == singleton2) + ": ten sam obiekt\n");
        ScopePrototype prototype1 = context.getBean(ScopePrototype.class);
        System.out.println(prototype1);
        ScopePrototype prototype2 = context.getBean(ScopePrototype.class);
        System.out.println(prototype2);
        System.out.println((prototype1 == prototype2) + ": dwa różne obiekty");



        context.close();


    }
}
