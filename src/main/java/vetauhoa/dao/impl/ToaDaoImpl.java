package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.ToaDao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.Toa;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("toaDao")
public class ToaDaoImpl implements ToaDao {
    private static final Logger logger = LoggerFactory.getLogger(ToaDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addToa(Toa toa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(toa);
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
    public void updateTao(Toa toa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(toa);
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
    public void deleteToa(String maToa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Toa toa= (Toa) session.load(Toa.class,maToa);
        Transaction t=session.beginTransaction();
        try{
            session.delete(toa);
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
    public Toa getToaById(String maToa){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Toa toa=new Toa();
        try {
            toa = (Toa) session.load(Toa.class, maToa);
        }catch (HibernateException e) {
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return toa;
    }
    @Override
    @Transactional
    public List<Toa> getToasByTauId(String maTau) {
        String sql="Select t.* From Toa t Where t.maTau= :maTau";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Toa> toaList =new ArrayList<>();
        try {
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.addEntity(Toa.class);
            sqlQuery.setParameter("maTau", maTau);
            toaList = (List<Toa>) sqlQuery.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  toaList;
    }
    @Override
    @Transactional
    public List<Toa> getToasByLoaiCho(String maTau,String loaiCho){
        String sql="From Toa t Where t.tauByMaTau.maTau= :maTau and t.LoaiCho= :loaiCho";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Toa> toaList= new ArrayList<>();
        try {
            Query query = (Query) session.createQuery(sql);
            query.setParameter("maTau", maTau);
            query.setParameter("loaiCho", loaiCho);
            toaList = query.getResultList();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  toaList;
    }
    @Override
    @Transactional
    public List<Toa> getAllToas(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Toa> toaList=new ArrayList<>();
        try {
            toaList = session.createQuery("From Toa").list();
        } catch ( HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  toaList;
    }
}
