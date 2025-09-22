package task6;

import org.hibernate.Session;

public class task6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        int addressId = 1;
        Address addressAdd = new Address("Nez", "Dol", "Iva", 1);
        session.save(addressAdd);
        Address addressRead =  session.get(Address.class, addressId);
        System.out.println(addressRead);
        Address addressUpdate = session.get(Address.class, addressId);
        addressUpdate.setCity("Lviv");
        addressUpdate.setStreet("Gazova");
        addressUpdate.setState("Lvivska");
        System.out.println(addressUpdate);
        Address addressDelete = session.get(Address.class, addressId);
        session.delete(addressDelete);

        Address existingAddress = session.get(Address.class, addressId);
        Person personAdd = new Person("Dan", 19, existingAddress, 1);
        session.save(personAdd);
        Person personRead =  session.get(Person.class, addressId);
        System.out.println(personRead);
        Person personUpdate = session.get(Person.class, addressId);
        personUpdate.setName("Azov");
        personUpdate.setAge(30);
        System.out.println(personUpdate);
        Person personDelete = session.get(Person.class, 1);
        session.delete(personDelete);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
