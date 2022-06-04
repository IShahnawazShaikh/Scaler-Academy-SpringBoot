import beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
    public static void main(String...x){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        var student=(Student)context.getBean("student");
        System.out.println(student);

    }
}
