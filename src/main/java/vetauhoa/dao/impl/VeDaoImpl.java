package vetauhoa.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.VeDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.Toa;
import vetauhoa.entity.Ve;

import java.util.List;

@Repository("veDao")
public class VeDaoImpl implements VeDao {
    private static final Logger logger = LoggerFactory.getLogger(VeDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addVe(Ve ve){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(ve);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            System.out.println("AddVeThanhCong");
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void updateVe(Ve ve){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(ve);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            System.out.println("update ve Xong");
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void deleteVe(String maVe){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Ve ve= (Ve) session.load(Toa.class,maVe);
        String maV=null;
        if(ve != null){
            maV = ve.getMaVe();
            session.delete(ve);
        }
        logger.info("Ve saved successfully,ve Details="+ve.getMaVe());
    }
    @Override
    @Transactional
    public Ve getVeById(String maVe){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Ve ve= (Ve) session.get(Ve.class,maVe);

        return ve;
    }
    @Override
    @Transactional
    public List<Ve> getVesByPhieuDatId(String maPhieuDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Ve> veList=session.createQuery("From Ve v Where v.phieuDatByMaPhieuDat.maPhieuDat= :maPhieuDat").setParameter("maPhieuDat",maPhieuDat).list();
        return veList;
    }
    @Override
    @Transactional
    public List<Ve> getAllVes(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<Ve> veList=session.createQuery("From Ve").list();
        return veList;
    }
}
