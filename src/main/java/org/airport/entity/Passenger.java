package org.airport.entity;

public class Passenger extends AbstractEntity{

    private String fullName;
    private String passportNumber;

    public Passenger(Long id, String fullName, String passportNumber) {
        super(id);
        validate(fullName, passportNumber);
        this.fullName = fullName.trim();
        this.passportNumber = passportNumber.trim();
    }

    private static void validate(String fullName, String passportNumber){
        if(fullName == null || fullName.isBlank()){
            throw new IllegalArgumentException("Некорректное имя");
        }
        if(passportNumber == null || passportNumber.isBlank()){
            throw new IllegalArgumentException("Некорректные паспортные данные");
        }
    }

    public String getFullName() {return fullName;}
    public String getPassportNumber() {return  passportNumber;}

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Некорректное имя");
        }
        this.fullName = fullName.trim();
    }

    public void setPassportNumber(String passportNumber) {
        if (passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException("Некорректные паспортные данные");
        }
        this.passportNumber = passportNumber.trim();
    }

    @Override
    public String toString(){
        return "Пассажир: " + fullName + " " + passportNumber;
    }


}
