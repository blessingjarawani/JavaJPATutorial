package zw.employee.selfservice.jpa;

import zw.employee.selfservice.dataaccess.models.Company;
import zw.employee.selfservice.dataaccess.models.Department;
import zw.employee.selfservice.dataaccess.models.Employees;
import zw.employee.selfservice.dictionaries.Dictionaries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import  java.util.*;

public class JPATester {

    private static final String PERSISTENCE_UNIT_NAME = "manager";
    public static void createNewEntity() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Department department = new Department();
        department.setName("IT");
        department.setActive(true);
        department.setCreatedDate(new Date());
        department.setUpdatedDate(new Date());
        em.persist(department);

        Company company =new Company();
        company.setName("Testing");
        company.setActive(true);
        company.setCreatedDate(new Date());
        company.setUpdatedDate(new Date());
        em.persist(company);

        Employees employee = new Employees();
        employee.setCreatedDate(new Date());
        employee.setUpdatedDate(new Date());
        employee.setFirstName("Blessing");
        employee.setLastName("Jarawani");
        employee.setTitle(Dictionaries.Title.Mr);
        employee.setGender(Dictionaries.Gender.Male);
        employee.setActive(true);
        employee.setDateOfBirth(new Date());
        employee.setEmpCode("003");
        employee.setCompany(company);
        employee.setDepartment(department);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }
    public static void listEntities() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        TypedQuery<Employees> query = em.createQuery("select emp from Employees emp", Employees.class);
                List<Employees> employees = query.getResultList();
        for (Employees employee : employees) {
            System.out.println(employee);
        }
        em.close();
    }
}
