package org.example.def.education;

import org.example.def.course.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EducationImpl implements EducationDao{

    private EntityManagerFactory emf;
    private EntityManager em;

    public EducationImpl(){
        this.emf = Persistence.createEntityManagerFactory("Slutprojekt");
        this.em = emf.createEntityManager();
    }

    @Override
    public void insert(Education education) {
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Education education) {
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void update(Education education) {
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public List<Education> getAll() {
        return em.createQuery("SELECT e FROM Education e",Education.class).getResultList();
    }

    @Override
    public List<Education> getEducationName(String name) {
        return null;
    }

    @Override
    public List<Education> getEducationId(long Id) {
        return null;
    }

    @Override
    public List<Education> getByParticipants(int participants) {
        return null;
    }

    @Override
    public List<Education> getCourses(Course course) {
        return null;
    }
}
