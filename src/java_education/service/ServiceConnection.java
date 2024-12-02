package java_education.service;

public final class ServiceConnection {

    private static PersonService instance;

    private ServiceConnection() {
        this.instance = instance;
    }

    public static PersonService getInstance() {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }
}
