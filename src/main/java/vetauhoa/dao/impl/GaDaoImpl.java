package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.GaDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.ChoDat;
import vetauhoa.entity.Ga;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository("gaDao")
public class GaDaoImpl implements GaDao {
    private static final Logger logger = LoggerFactory.getLogger(GaDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addGa(Ga ga){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(ga);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void updateGa(Ga ga){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.update(ga);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }

    }
    @Override
    @Transactional
    public void deleteGa(String maGa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Ga ga= (Ga) session.load(Ga.class,maGa);
        Transaction t=session.beginTransaction();
          try {
            session.delete(ga);
            t.commit();
            }catch (HibernateException e){
              System.out.println(e);
              t.rollback();
          }finally {
              if(session.isOpen()){
                  session.close();
              }
          }
    }
    @Override
    @Transactional
    public Ga getGaById(String maGa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Ga ga=new Ga();
        try {
            ga = (Ga) session.load(Ga.class, maGa);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return ga;
    }
    @Override
    @Transactional
    public List<Ga> getAllGas(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Ga> gaList=new ArrayList<>();
        try {
            gaList = session.createQuery("From Ga").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return gaList;

    }
    @Override
    @Transactional
    public Ga getGaByTenGa(String tenGa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        String hql= "FROM Ga g WHERE g.tenGa = :tenGa";
        Ga ga=new Ga();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("tenGa", tenGa);
            ga = (Ga) query.uniqueResult();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return ga;
    }
}
