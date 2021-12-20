package org.example.def.student;

import org.example.def.course.Course;
import org.example.def.education.Education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentImpl implements StudentDao {
    EntityManagerFactory emf;
    EntityManager em;

    public StudentImpl() {
        this.emf = Persistence.createEntityManagerFactory("Slutprojekt");
        this.em = emf.createEntityManager();
    }


    @Override
    public void insert(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        student.getEducation().getStudentList().remove(student);
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    @Override
    public Student getById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public List<Student> getByName(String name) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE fullName =:name ", Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Student> getByEducation(Education education) {
        return education.getStudentList();
    }

    @Override
    public List<Student> getByAge(int age) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE age =:age", Student.class);
        query.setParameter("age", age);
        return query.getResultList();
    }


}
