package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.NhanVienDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.Ga;
import vetauhoa.entity.LichTrinh;
import vetauhoa.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;

@Repository("nhanVienDao")
public class NhanVienDaoImpl implements NhanVienDao {
    private static final Logger logger = LoggerFactory.getLogger(ChoDatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addNhanVien(NhanVien nhanVien){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(nhanVien);
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
    public void updateNhanVien(NhanVien nhanVien){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(nhanVien);
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
    public void deleteNhanVien(String maNhanVien) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        NhanVien nhanVien= (NhanVien) session.load(Ga.class,maNhanVien);
        Transaction t=session.beginTransaction();
        try{
            session.delete(nhanVien);
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
    public NhanVien getNhanVienById(String maNhanVien){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        NhanVien nhanVien=new NhanVien();
        try{
            nhanVien =(NhanVien) session.load(NhanVien.class,maNhanVien);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if (session.isOpen()){
                session.close();
            }
        }
        return  nhanVien;
    }
    @Override
    @Transactional
    public NhanVien getNhanViensByTaiKhoanId(String maTaiKhoan){
        String hql="SELECT nv From NhanVien nv WHERE nv.taiKhoanByMaTaiKhoan.maTaiKhoan=:maTaiKhoan";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        NhanVien nhanVien=new NhanVien();
        try {
            nhanVien =(NhanVien) session.createQuery(hql).setParameter("maTaiKhoan", maTaiKhoan).uniqueResult();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return nhanVien;
    }
    @Override
    @Transactional
    public List<NhanVien> getAllNhanViens(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<NhanVien> nhanVienList=new ArrayList<>();
        try {
            nhanVienList = session.createQuery("From NhanVien").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return nhanVienList;
    }
    @Override
    public List<String> getAllMaNhanVien(){
        String hql=("Select nv.maNhanVien From NhanVien nv");
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
        NhanVien nhanVien=getNhanViensByTaiKhoanId(maTaiKhoan);
        if(nhanVien==null){
            return false;
        }
        return true;
    }

    @Override
    public  boolean checkEmail(String email){
        String hql=("Select nv From NhanVien nv Where nv.email= :email");
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
}
