package vetauhoa.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.HibernateIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.TaiKhoanDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

@Repository("taiKhoanDao")
public class TaiKhoanDaoImpl implements TaiKhoanDao {
    private static final Logger logger = LoggerFactory.getLogger(ChoDatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addTaiKhoan(TaiKhoan taiKhoan){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(taiKhoan);
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
    public void updateTaiKhoan(TaiKhoan taiKhoan){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t =session.beginTransaction();
        try {
            session.merge(taiKhoan);
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
    public void deleteTaiKhoan(String maTaiKhoan){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        TaiKhoan taiKhoan= (TaiKhoan) session.load(TaiKhoan.class,maTaiKhoan);
        Transaction t=session.beginTransaction();
        try {
            session.delete(taiKhoan);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            if (session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    public TaiKhoan getTaiKhoanById(String maTaiKhoan){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        TaiKhoan taiKhoan=new TaiKhoan();
        try {
            taiKhoan = (TaiKhoan) session.load(TaiKhoan.class, maTaiKhoan);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  taiKhoan;
    }
    @Override
    @Transactional
    public TaiKhoan getTaiKhoanByUsername(String username){
        String sql="Select distinct tk From TaiKhoan tk Where tk.username=:username";
        Session session =sessionFactory.openSession();;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
        System.out.println("get tk by username in dao impl:"+ username);
        TaiKhoan taiKhoan=new TaiKhoan();
        try {
            taiKhoan =(TaiKhoan) session.createQuery(sql).setParameter("username", username).uniqueResult();
        }catch (HibernateException e){
            System.out.println("Loi ccmnr:"+ e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  taiKhoan;
    }
    @Override
    @Transactional
    public List<TaiKhoan> getTaiKhoanByTrangThai(boolean trangThai){
        String sql="Select tk from TaiKhoan tk Where tk.TrangThai= :trangThai";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TaiKhoan> taiKhoans=new ArrayList<>();
        try {
            taiKhoans = session.createQuery(sql).setParameter("trangThai", trangThai).list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  taiKhoans;
    }
    @Override
    @Transactional
    public List<TaiKhoan> getAllTaiKhoans(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TaiKhoan> taiKhoans=new ArrayList<>();
        try {
            taiKhoans = session.createQuery("From TaiKhoan").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  taiKhoans;
    }
    @Override
    public List<String> getAllMaTaiKhoan(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> maTaiKhoanList=new ArrayList<>();
        try {
            maTaiKhoanList = session.createQuery("Select tk.maTaiKhoan From TaiKhoan tk").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return  maTaiKhoanList;
    }
}
