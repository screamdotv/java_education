package java_education.service;

public final class PersonServiceConnection {

    private static PersonService personServiceInstance;

    private PersonServiceConnection() {
        this.personServiceInstance = personServiceInstance;
    }

    public static PersonService getPersonService() {
        if (personServiceInstance == null) {
            personServiceInstance = new PersonService();
        }
        return personServiceInstance;
    }
}
