package ApartmentProject.repository;
import ApartmentProject.Model.PropertyInfo;
import ApartmentProject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PropertyInfoDaoImpl implements PropertyInfoDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean save(PropertyInfo propertyInfo){
        Transaction transaction = null;
        boolean isSuccessful = true;

        try{
            Session session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction=session.beginTransaction();
            session.save(propertyInfo);
            transaction.commit();
        }catch (Exception e){
            isSuccessful = false;
            if(transaction!=null)
                transaction.rollback();
            logger.error(e.getMessage());
        }

        if(isSuccessful){
            logger.debug(String.format("The propertyInfo %s was inserted into the table.", propertyInfo.toString()));
        }
        return isSuccessful;
    }

    @Override
    public boolean update(PropertyInfo propertyInfo) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(propertyInfo);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The propertyInfo %s was updated.", propertyInfo.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(int id) {
        String hql = "DELETE propertyinfo where id = :id1";
        int deletedCount = 0;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query<PropertyInfo> query = session.createQuery(hql);
            query.setParameter("id1", id);
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

        logger.debug(String.format("The propertyInfo %s was deleted", id));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<PropertyInfo> getPropertyInfos() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM PropertyInfo";
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){

            Query<PropertyInfo> query = session.createQuery(hql);
            //return query.list();
            return query.list();
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }
}
