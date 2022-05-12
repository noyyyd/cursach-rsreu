package cursach.dto;

import java.util.Objects;

public class Author {
    private String ID;
    private String name;
    private String lastName;
    private String patronymic;
    private String phone;
    private String passportSeries;
    private String passportNumber;
    private String email;

    @Override
    public String toString() {
        return "Autor{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", pasportNumber='" + passportNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Author(String ID, String name, String lastName,
                  String patronymic, String phone, String passportSeries,
                  String passportNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(ID, author.ID) && Objects.equals(name, author.name) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(patronymic, author.patronymic) &&
                Objects.equals(phone, author.phone) &&
                Objects.equals(passportSeries, author.passportSeries) &&
                Objects.equals(passportNumber, author.passportNumber) &&
                Objects.equals(email, author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, lastName, patronymic, phone,
                passportSeries, passportNumber, email);
    }
}
