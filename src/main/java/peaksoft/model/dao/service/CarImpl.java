package peaksoft.model.dao.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.db.Util;
import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.model.dao.CarDao;

import java.util.ArrayList;
import java.util.List;

public class CarImpl implements CarDao {
    SessionFactory sessionFactory = Util.creatSessionFactory();

    @Override
    public void saveCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.getTransaction().commit();
            return car;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getCarsByPersonId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Person> personList = session.createQuery("SELECT  p FROM  Person  p WHERE p.id = :id", Person.class)
                    .setParameter("id", id).list();
            Person person = personList.get(0);
            List<Car> cars = new ArrayList<>(person.getCars());
            session.getTransaction().commit();
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getCarsByPersonName(String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Person> personList = session.createQuery("SELECT p FROM Person p where  p.name=:name")
                    .setParameter("name",name).list();

            Person person = null;
            for (Person i : personList) {
                if (i.getName().equals(name)) {
                    List<Person> personList2 = session.createQuery
                                    ("select c from Person c where c.id = :id", Person.class)
                            .setParameter("id", i.getId()).list();
                    person = personList2.get(0);
                }
            }
            List<Car> cars = new ArrayList<>(person.getCars());
            session.getTransaction().commit();
            return cars;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
return null;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
             cars = session.createQuery("SELECT c FROM  Car c ").list();
            session.getTransaction().commit();
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCarById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.remove(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void assignCarToPerson(Long id, Long personId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            Person person = session.get(Person.class, personId);
            car.setPerson(person);
            person.setCars(List.of(car));
            session.persist(car);
            session.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
