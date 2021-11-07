import com.*;
import com.senla.api.Facade;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = Application.run("com", new HashMap<>(Map.of(Facade.class, com.senla.controller.Facade.class)));
        Facade facade = context.getObject(com.senla.controller.Facade.class);
        facade.createProvider("colla");

    }
}
