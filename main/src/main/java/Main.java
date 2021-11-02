import com.*;
import com.senla.api.IFacade;
import com.senla.controller.Facade;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        ApplicationContext context = Application.run("com", new HashMap<>(Map.of(IFacade.class, Facade.class)));
        IFacade facade = context.getObject(Facade.class);
        facade.createProvider("colla");


    }
}
