package peaksoft;

import peaksoft.db.Util;
import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.model.SocialMedia;
import peaksoft.model.dao.service.CarImpl;
import peaksoft.model.dao.service.PersonImpl;
import peaksoft.model.dao.service.SocialMediaImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println(Util.creatSessionFactory());
        PersonImpl personImpl = new PersonImpl();
        CarImpl car = new CarImpl();

        Person person = new Person("beka", "beka@gmail.com", 21);
        Person person2 = new Person("jaka", "beka@gmail.com", 21);
        Person person3 = new Person("adi", "beka@gmail.com", 21);
        Person person4 = new Person("joni", "beka@gmail.com", 21);
//        personImpl.savePerson(person);
//        personImpl.savePerson(person2);
//        personImpl.savePerson(person3);
//        personImpl.savePerson(person4);
//        personImpl.assignCarToPerson(5l,5l);
//        personImpl.deletePersonId(1l);
//        personImpl.deletePersonId(2l);
//        personImpl.getPersonById(1l);
//        personImpl.getPersonByName("beka");
//        personImpl.updatePerson(3l,new Person("janysh","2gmsil.com",23));


        Car cars = new Car("BMW", 10000000, "Black");
        Car cars2 = new Car("Audi", 5000000, "Black");
        Car cars3 = new Car("Honda", 6000000, "Black");
        Car cars4 = new Car("Kia", 1000000, "Black");
//        car.saveCar(cars);
//        car.saveCar(cars2);
//        car.saveCar(cars3);
//        car.saveCar(cars4);
//        System.out.println(car.getCarsByPersonId(1l));
//car.deleteCarById(2l);
//        car.deleteCarById(3l);
//        car.getCarsByPersonId(2l);
//        car.getCarsByPersonName("adi");
        SocialMediaImpl socialMedia = new SocialMediaImpl();
        SocialMedia socialMedia1 = new SocialMedia("Instagram");
//        socialMedia.saveMedia(socialMedia1);
//        socialMedia.deleteSocialMedia(1l);
//        System.out.println(socialMedia.getAllMedia());
//        socialMedia.getSocialMedia(2l);


    }
}

