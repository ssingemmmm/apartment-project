package ApartmentProject.repository;

import ApartmentProject.Model.Apartment;
import ApartmentProject.util.HibernateUtil;
import com.github.fluent.hibernate.H;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentDaoImpl implements ApartmentDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean save(Apartment apartment){
        Transaction transaction = null;
        boolean isSuccessful = true;

        try{
            Session session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction=session.beginTransaction();
            session.save(apartment);
            transaction.commit();
        }catch (Exception e){
            isSuccessful = false;
            if(transaction!=null)
                transaction.rollback();
            logger.error(e.getMessage());
        }

        if(isSuccessful){
            logger.debug(String.format("The apartment %s was inserted into the table.", apartment.toString()));
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Apartment apartment) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try {
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(apartment);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The apartment %s was updated.", apartment.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(String apartmentName) {
        String hql = "DELETE Apartment where name = :apartmentN";
        int deletedCount = 0;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<Apartment> query = session.createQuery(hql);
            query.setParameter("apartmentN", apartmentName);
            deletedCount = query.executeUpdate();
            //Apartment apt = getAmentByName(deptName);
            //session.delete(apt);
            transaction.commit();
            deletedCount = 1;
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The apartment %s was deleted", apartmentName));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<Apartment> getApartments() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM Apartment";
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){

            Query<Apartment> query = session.createQuery(hql);
            //return query.list();
            return query.list();
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }
}
