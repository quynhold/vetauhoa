package vetauhoa.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.TrangThaiChoDatDao;
import vetauhoa.entity.Toa;
import vetauhoa.entity.TrangThaiChoDat;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository("trangThaiChoDatDao")
public class TrangThaiChoDatDaoImpl implements TrangThaiChoDatDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addTrangThai(TrangThaiChoDat trangThaiChoDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(trangThaiChoDat);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            System.out.println("AddTrangThaiThanhCong");
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void updateTrangThai(TrangThaiChoDat trangThaiChoDat){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.merge(trangThaiChoDat);
            t.commit();
        }catch (HibernateException e){
            System.out.println(e);
            t.rollback();
        }finally {
            System.out.println("Xoa Trang Thai Xong");
            if(session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public void deleteTrangThai(String maLichTrinh,String maChoDat){
        String hql="Select tt From TrangThaiChoDat tt Where tt.lichTrinhByMaLichTrinh.maLichTrinh= :maLichTrinh and tt.choDatByMaChoDat.maChoDat= :maChoDat";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TrangThaiChoDat> trangThaiChoDats=new ArrayList<>();
        TrangThaiChoDat trangThaiChoDat=new TrangThaiChoDat();
        try {
            Query query = (Query) session.createQuery(hql);
            query.setParameter("maLichTrinh", maLichTrinh);
            query.setParameter("maChoDat", maChoDat);
            trangThaiChoDats = query.getResultList();
            if(!trangThaiChoDats.isEmpty()){
            trangThaiChoDat=trangThaiChoDats.get(0);
            session.delete(trangThaiChoDat);
            }
        }catch (HibernateException e){
            System.out.println("Update xong");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    @Transactional
    public void deleteTrangThai(String maTrangThai){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Toa toa= (Toa) session.load(Toa.class,maTrangThai);
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
    public TrangThaiChoDat getTrangThaiByMaLTCD(String maLichTrinh,String maChoDat){
        String hql="Select tt From TrangThaiChoDat tt Where tt.lichTrinhByMaLichTrinh.maLichTrinh=:maLichTrinh and tt.choDatByMaChoDat.maChoDat=:maChoDat";
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TrangThaiChoDat> trangThaiChoDats=new ArrayList<TrangThaiChoDat>();
        TrangThaiChoDat trangThaiChoDat=new TrangThaiChoDat();
        try {
            trangThaiChoDat =(TrangThaiChoDat) session.createQuery(hql).setParameter("maLichTrinh", maLichTrinh).setParameter("maChoDat", maChoDat).uniqueResult();
        }catch (HibernateException e){
            System.out.println("Check");
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return trangThaiChoDat;
    }
    @Override
    @Transactional
    public TrangThaiChoDat getTrangThaiByMaTrangThai(String maTrangThai){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        TrangThaiChoDat trangThaiChoDat=new TrangThaiChoDat();
        try {
            trangThaiChoDat = (TrangThaiChoDat) session.load(Toa.class, maTrangThai);
        }catch (HibernateException e) {
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return trangThaiChoDat;
    }
    public List<TrangThaiChoDat> getAllTrangThai(){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TrangThaiChoDat> trangThaiChoDats=new ArrayList<>();
        try {
            trangThaiChoDats = session.createQuery("From TrangThaiChoDat").list();
        } catch ( HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return trangThaiChoDats;
    }
    public List<TrangThaiChoDat> getAllTrangThaiByMaLichTrinh(String maLichTrinh){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<TrangThaiChoDat> trangThaiChoDats=new ArrayList<>();
        try {
            trangThaiChoDats = session.createQuery("From TrangThaiChoDat tt Where tt.lichTrinhByMaLichTrinh.maLichTrinh=:maLichTrinh")
                    .setParameter("maLichTrinh",maLichTrinh).list();
        } catch ( HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return trangThaiChoDats;
    }
}
