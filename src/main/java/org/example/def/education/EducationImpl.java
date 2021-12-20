package org.example.def.education;

import org.example.def.course.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
    public Education getById(int id) {
        return em.find(Education.class,id);
    }

    @Override
    public List<Education> getEducationName(String educationName) {
        TypedQuery<Education> queryName = em.createQuery("SELECT n FROM Education n WHERE educationName = :fullName",Education.class);
        queryName.setParameter("fullName",educationName);
        return queryName.getResultList();
    }

    @Override
    public List<Education> getEducationId(long educationID) {
        TypedQuery<Education> queryID = em.createQuery("SELECT i FROM Education i WHERE i.educationID = :Id",Education.class);
        queryID.setParameter("Id",educationID);
        return queryID.getResultList();
    }

    @Override
    public List<Education> getByParticipants(int participants) {
        TypedQuery<Education> participantsAmount = em.createQuery("SELECT p FROM Education p ORDER BY p.participants DESC",Education.class);
        return participantsAmount.getResultList();
    }

    @Override
    public List<Education> getCourses(Course course) {
        TypedQuery<Education> queryCourses = em.createQuery("SELECT courseList FROM Education",Education.class);
        return queryCourses.getResultList();
    }
}
