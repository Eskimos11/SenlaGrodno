
import com.senla.api.dao.CustomerDao;
import com.senla.controller.CustomerController;
import com.senla.controller.configuration.ContextConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        CustomerController customerController = context.getBean("customerController", CustomerController.class);
//        customerController.getCustomer(0);

        CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
        System.out.println(customerDao.getByIdWith(0));
        context.close();
    }
}






