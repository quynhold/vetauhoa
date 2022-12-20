package vetauhoa.dao.impl;

import org.hibernate.*;
import vetauhoa.dao.ChoDatDao;
import vetauhoa.entity.ChoDat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("choDatDao")
public class ChoDatDaoImpl implements ChoDatDao {
    private static final Logger logger = LoggerFactory.getLogger(ChoDatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addChoDat(ChoDat choDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction transaction=session.beginTransaction();
        try {
            session.persist(choDat);
            transaction.commit();
        }catch (HibernateException e){
            System.out.println(e);
            transaction.rollback();
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void updateChoDat(ChoDat choDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(choDat);
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
    public void deleteChoDat(String maChoDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        ChoDat choDat= (ChoDat) session.load(ChoDat.class,maChoDat);
        Transaction t=session.beginTransaction();
        try{
            session.delete(choDat);
        }catch (HibernateException e){
            System.out.println();
            t.rollback();
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public ChoDat getChoDatById(String maChoDat){
        Session session=sessionFactory.openSession();
        try {
            session = sessionFactory.getCurrentSession();
            System.out.println(session.isOpen());
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction transaction= session.beginTransaction();
        ChoDat choDat=new ChoDat();
        try{
            choDat = (ChoDat) session.load(ChoDat.class,maChoDat);
            transaction.commit();
        }catch (HibernateException e) {
            System.out.println("truy van cho dat that bai");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return choDat;
    }
    @Override
    public List<ChoDat> getChoDatsByToaId(String maToa){
        String hql= "Select cd From ChoDat cd Where cd.toaByMaToa.maToa=:maToa";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<ChoDat> choDatList=new ArrayList<>();
        try{
        Query query= session.createQuery(hql);
        query.setParameter("maToa",maToa);
        choDatList=query.list();
        }
        catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return choDatList;
    }
    @Override
    public List<ChoDat> getChoDatsByTauId(String maTau){
        String hql= "Select cd From ChoDat cd, Toa t Where cd.toaByMaToa.maToa=t.maToa and t.tauByMaTau.maTau=:maTau";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<ChoDat> choDatList=new ArrayList<>();
        try{
            Query query= session.createQuery(hql);
            query.setParameter("maTau",maTau);
            choDatList=query.list();
        }
        catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return choDatList;
    }
    @Override
    public List<ChoDat> getAllChoDats(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<ChoDat> choDatList=new ArrayList<>();
        try {
            choDatList = session.createQuery("From ChoDat").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        logger.info("Person loaded successfully");
        return choDatList;
    }

}
