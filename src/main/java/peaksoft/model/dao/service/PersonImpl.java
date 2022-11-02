package peaksoft.model.dao.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.db.Util;
import peaksoft.model.Car;
import peaksoft.model.Person;

import peaksoft.model.dao.PersonDao;

import java.util.List;

public class PersonImpl implements PersonDao {
     SessionFactory sessionFactory = Util.creatSessionFactory();

    public void savePerson(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person getPersonById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.getTransaction().commit();
            return person;
        }
    }

    public List<Person> getAllPerson() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Person> personList = session.createQuery("SELECT u FROM Person u").list();
            session.getTransaction().commit();
            session.close();
            return personList;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void updatePerson(Long id, Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person1 = session.get(Person.class, id);
            person1.setName(person.getName());
            person1.setEmail(person.getEmail());
            person1.setAge(person.getAge());
            session.saveOrUpdate(person1);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deletePersonId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Person getPersonByName(String name) {
        try (Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            Person persons = (Person) session.createQuery("select u from Person u where u.name = : name")
                            .setParameter("name",name).getSingleResult();
                                session.getTransaction().commit();

            return persons;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void assignCarToPerson(Long id, Long personId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            Person person = session.get(Person.class, personId);
           car.setPerson(person);
           person.setCars(List.of(car));
            session.persist(person);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

