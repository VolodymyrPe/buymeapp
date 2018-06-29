package dao;

import model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class DaoTestUtil {

    public static final String PERSISTENCE_TEST_UNIT = "hibernate-test-unit";


    public static void DeleteAllData(EntityManagerFactory factory, String className){

        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("DELETE FROM " + className);

        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();

        em.close();
    }

    public static void createAllEllements(Dao dao, List<BaseEntity> entities){

        entities.forEach(e -> dao.create(e));

    }
}