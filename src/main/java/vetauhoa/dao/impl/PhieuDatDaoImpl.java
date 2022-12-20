package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.PhieuDatDao;

import org.springframework.stereotype.Repository;
import vetauhoa.entity.HoaDon;
import vetauhoa.entity.PhieuDat;

import java.util.ArrayList;
import java.util.List;

@Repository("phieuDatDao")
public class PhieuDatDaoImpl implements PhieuDatDao {
    private static final Logger logger = LoggerFactory.getLogger(PhieuDatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addPhieuDat(PhieuDat phieuDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try{
        session.persist(phieuDat);
        t.commit();
        }
        catch (HibernateException he) {
            System.out.println("Error getting : " + he);
            he.printStackTrace();
        }finally {
            if (session.isOpen()){
                session.close();
            }
        }
        logger.info("Phieu Dat add successfully, Phieu Dat Details="+phieuDat.getMaPhieuDat());
    }
    @Override
    @Transactional
    public void updatePhieuDat(PhieuDat phieuDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(phieuDat);
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
    public void deletePhieuDat(String maPhieuDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        PhieuDat phieuDat= (PhieuDat) session.load(PhieuDat.class,maPhieuDat);
        Transaction t=session.beginTransaction();
        try{
            session.delete(phieuDat);
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
    public PhieuDat getPhieuDatById(String maPhieuDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        PhieuDat phieuDat=new PhieuDat();
        try {
            phieuDat = (PhieuDat) session.load(PhieuDat.class, maPhieuDat);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return phieuDat;
    }
    @Override
    @Transactional
    public List<PhieuDat> getPhieuDatsByHanhKhachId(String maHanhKhach) {
        String hql = ("SELECT pd From PhieuDat pd Where pd.hanhKhachByMaHanhKhach.maHanhKhach= :maHanhKhach");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<PhieuDat> phieuDats=new ArrayList<>();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("maHanhKhach", maHanhKhach);
            phieuDats = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return phieuDats;
    }
    @Override
    @Transactional
    public List<PhieuDat> getPhieuDatsByHoaDonId(String maHoaDon){
        String hql = ("SELECT pd From PhieuDat pd Where pd.hoaDonByMaHoaDon.maHoaDon= :maHoaDon");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<PhieuDat> phieuDats=new ArrayList<>();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("maHoaDon", maHoaDon);
            phieuDats = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return phieuDats;
    }
    @Override
    @Transactional
    public List<PhieuDat> getPhieuDatsByLichTrinhId(String maLichTrinh){
        String hql = ("SELECT pd From PhieuDat pd Where pd.lichTrinhByMaLichTrinh.maLichTrinh=:maLichTrinh");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<PhieuDat> phieuDats=new ArrayList<PhieuDat>();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("maLichTrinh", maLichTrinh);
            phieuDats = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return phieuDats;
    }
    @Override
    @Transactional
    public List<PhieuDat> getAllPhieuDat(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<PhieuDat> phieuDats=new ArrayList<>();
        try {
            Query query = session.createQuery("From PhieuDat");
            phieuDats = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return phieuDats;
    }
    @Override
    @Transactional
    public  List<String> getAllMaPhieuDat(){
        String hql=("Select pd.maPhieuDat From PhieuDat pd");
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<String> list=new ArrayList<>();
        try {
            Query query = session.createQuery(hql);
            list = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return list;
    }
}
