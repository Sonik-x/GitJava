import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;
    private final String PHONE_REGEX = "^([7|8])?(\\d{3})(\\d{3})(\\d{2})(\\d{2}$)";  // спасибо за велосипед =)
    private final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException {
        String[] components = data.split("\\s+");

        if(components.length < 4){
            throw new IllegalArgumentException("Wrong format! Right format example:\n" + Main.addCommand);
        }

        if(!components[2].matches(EMAIL_REGEX)){
            throw new IllegalArgumentException("Wrong Email format!");    //если и телефон, и почта неверные, программа скажет только про почту
        }                                                                 //с другой стороны кто сказал, что это должно быть юзер-френдли...

        if(!components[3].matches(PHONE_REGEX)){
            throw new IllegalArgumentException("Wrong phone format!");
        }




        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
        System.out.println("Client \"" + name + "\" successfully added!");

    }

    public void listCustomers() throws Exception {
        if(storage.isEmpty()){
            throw new Exception("The list is empty.");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws IllegalArgumentException {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Customer \"" + name + "\" does not exist");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}