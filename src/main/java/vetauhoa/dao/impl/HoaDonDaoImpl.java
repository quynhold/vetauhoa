package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.dao.HoaDonDao;
import org.springframework.stereotype.Repository;
import vetauhoa.entity.HoaDon;

import java.util.ArrayList;
import java.util.List;

@Repository("hoaDonDao")
public class HoaDonDaoImpl implements HoaDonDao {
    private static final Logger logger = LoggerFactory.getLogger(HoaDonDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void addHoaDon(HoaDon hoaDon){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try{
        session.persist(hoaDon);
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
    public void updateHoaDon(HoaDon hoaDon){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try{
        session.update(hoaDon);
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
    public void deleteHoaDon(String maHoaDon){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        HoaDon hoaDon= (HoaDon) session.load(HoaDon.class,maHoaDon);
        Transaction t=session.beginTransaction();
        try{
            session.delete(hoaDon);
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
    public HoaDon getHoaDon(String maHoaDon){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        HoaDon hoaDon=new HoaDon();
        try {
            hoaDon = (HoaDon) session.load(HoaDon.class, maHoaDon);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hoaDon;
    }
    @Override
    public List<HoaDon> getHoaDonByNhanVienId(String maNhanVien){
        String hql= "From HoaDon hd Where hd.nhanVienByMaNhanVien.maNhanVien=:maNhanVien";
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        List<HoaDon> hoaDonList=new ArrayList<>();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("maNhanVien", maNhanVien);
            hoaDonList = query.list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hoaDonList;
    }
    @Override
    public List<HoaDon> getAllHoaDons(){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        List<HoaDon> hoaDonList=new ArrayList<>();
        try {
            hoaDonList = session.createQuery("From HoaDon").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return hoaDonList;
    }
    @Override
    public  List<String> getAllMaHoaDon(){
        String hql=("Select hd.maHoaDon From HoaDon hd");
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
