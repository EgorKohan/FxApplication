package fx.project.model;

import fx.project.util.DateUtil;
import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty city;
    private StringProperty street;
    private IntegerProperty postalCode;
    private ObjectProperty<LocalDate> birthday;

    public Person() {
        this(null,null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.city = new SimpleStringProperty("Some city");
        this.street = new SimpleStringProperty("Some street");
        this.postalCode = new SimpleIntegerProperty(155);
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(2001, 9, 14));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(DateUtil.parse(birthday));
    }
}
