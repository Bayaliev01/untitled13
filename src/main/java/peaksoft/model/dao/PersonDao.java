package peaksoft.model.dao;

import peaksoft.model.Person;

import java.util.List;

public interface PersonDao {
    void savePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getAllPerson();

    void updatePerson(Long id, Person person);

    void deletePersonId(Long id);

    Person getPersonByName(String name);

}
