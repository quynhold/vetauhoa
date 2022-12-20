package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.HanhKhachDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.ChoDat;
import vetauhoa.entity.HanhKhach;

import java.util.ArrayList;
import java.util.List;

@Repository("hanhKhachDao")
public class HanhKhachDaoImpl implements HanhKhachDao {
    private static final Logger logger = LoggerFactory.getLogger(HanhKhachDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addHanhKhach(HanhKhach hanhKhach){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(hanhKhach);
            t.commit();
        }
        catch (HibernateException he) {
            System.out.println("Error getting: " + he);
            he.printStackTrace();
            t.rollback();
        }finally {
            if (session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void updateHanhKhach(HanhKhach hanhKhach){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
        session.merge(hanhKhach);
        t.commit();
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
    public void deleteHanhKhach(String maHanhKhach){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        HanhKhach hanhKhach= (HanhKhach) session.load(HanhKhach.class,maHanhKhach);
        System.out.println(hanhKhach.getEmail());
        Transaction t=session.beginTransaction();
        try{
            session.delete(hanhKhach);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public HanhKhach getHanhKhachById(String maHanhKhach){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        HanhKhach hanhKhach=new HanhKhach();
        try {
            hanhKhach = (HanhKhach) session.load(HanhKhach.class, maHanhKhach);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hanhKhach;
    }
    @Override
    @Transactional
    public HanhKhach getHanhKhachsByTaiKhoanId(String maTaiKhoan){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        HanhKhach hanhKhach=new HanhKhach();
        try {
            hanhKhach =(HanhKhach) session.createQuery("From HanhKhach hk Where hk.taiKhoanByMaTaiKhoan.maTaiKhoan=:maTaiKhoan").setParameter("maTaiKhoan", maTaiKhoan).uniqueResult();
        }catch (HibernateException e){
            System.out.println(e);
            System.out.println("Sai trong hql");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hanhKhach;
    }
    @Override
    @Transactional
    public HanhKhach getHanhKhachsByCccd(String cccd){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        HanhKhach hanhKhach=new HanhKhach();
        try {
            hanhKhach =(HanhKhach) session.createQuery("Select distinct hk From HanhKhach hk Where hk.cccd=:cccd").setParameter("cccd", cccd).uniqueResult();
        }catch (HibernateException e){
            System.out.println(e);
            System.out.println("Sai trong hql");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hanhKhach;
    }
    @Override
    @Transactional
    public HanhKhach getHanhKhachsByEmail(String email){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        HanhKhach hanhKhach=new HanhKhach();
        try {
            hanhKhach =(HanhKhach) session.createQuery("Select distinct hk From HanhKhach hk Where hk.email=:email").setParameter("email", email).uniqueResult();
        }catch (HibernateException e){
            System.out.println(e);
            System.out.println("Sai Email trong hql");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hanhKhach;
    }
    @Override
    @Transactional
    public List<HanhKhach> getAllHanhKhachs(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<HanhKhach> hanhKhachList= new ArrayList<>();
        try {
            hanhKhachList = session.createQuery("From HanhKhach").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hanhKhachList;
    }
    @Override
    public  List<String> getAllMaHanhKhach(){
        String hql=("Select hk.maHanhKhach From HanhKhach hk");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> list=new ArrayList<>();
        try {
        Query query=session.createQuery(hql);
        list= query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return list;
    }
    @Override
    public  boolean checkMaTaiKhoan(String maTaiKhoan){
        String hql=("Select hk.maHanhKhach From HanhKhach hk Where hk.taiKhoanByMaTaiKhoan.maTaiKhoan= :maTaiKhoan");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> list=new ArrayList<>();
        try {
            Query query=session.createQuery(hql);
            query.setParameter("maTaiKhoan",maTaiKhoan);
            list= query.list();
        }catch (HibernateException e){
            System.out.println(e);
            return false;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        if(list.isEmpty()){
            return false;
        }
        return true;
    }
    @Override
    public  boolean checkEmail(String email){
        String hql=("Select hk From HanhKhach hk Where hk.email= :email");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> list=new ArrayList<>();
        try {
            Query query=session.createQuery(hql);
            query.setParameter("email",email);
            list= query.list();
        }catch (HibernateException e){
            System.out.println(e);
            return false;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        if(list.isEmpty()){
            return false;
        }
        return true;
    }
    @Override
    public  boolean checkCccd(String cccd){
        String hql=("Select hk From HanhKhach hk Where hk.cccd= :cccd");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> list=new ArrayList<>();
        try {
            Query query=session.createQuery(hql);
            query.setParameter("cccd",cccd);
            list= query.list();
        }catch (HibernateException e){
            System.out.println(e);
            return false;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        if(list.isEmpty()){
            return false;
        }
        return true;
    }
}
