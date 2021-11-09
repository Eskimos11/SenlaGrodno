
import com.senla.controller.ProviderController;
import com.senla.controller.configuration.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        ProviderController providerController = context.getBean("providerController", ProviderController.class);

        //Create
        providerController.createProvider("{\"id\":\"1\",\"title\":\"Pepsi\"}");
        providerController.createProvider("{\"id\":\"2\",\"title\":\"Cola\"}");


        //Read
        System.out.println(providerController.getProvider(1));

        //Delete
        providerController.deleteProvider("{\"id\":\"2\",\"title\":\"Cola\"}");

        //Update
        providerController.updateProvider(1, "{\"id\":\"1\",\"title\":\"Mirinda\"}");
        //Read
        System.out.println(providerController.getProvider(1));


        context.close();
    }
}






