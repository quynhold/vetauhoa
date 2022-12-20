package vetauhoa.dao.impl;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import vetauhoa.dao.LichTrinhDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vetauhoa.entity.LichTrinh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("lichTrinhDao")
public class LichTrinhDaoImpl implements LichTrinhDao {
    private static final Logger logger = LoggerFactory.getLogger(ChoDatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public void addLichTrinh(LichTrinh lichTrinh){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.persist(lichTrinh);
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
    public void updateLichTrinh(LichTrinh lichTrinh){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        Transaction t=session.beginTransaction();
        try {
            session.saveOrUpdate(lichTrinh);
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
    public void deleteLichTrinh(String maLichTrinh){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        LichTrinh lichTrinh = (LichTrinh) session.load(LichTrinh.class, maLichTrinh);
        Transaction t=session.beginTransaction();
        try {
            session.delete(lichTrinh);
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
    public LichTrinh getLichTrinh(String maLichTrinh){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        LichTrinh lichTrinh=new LichTrinh();
        try {
            lichTrinh = (LichTrinh) session.load(LichTrinh.class, maLichTrinh);
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return lichTrinh;
    }
    @Override
    public List<LichTrinh> getAllLichTrinhs(){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        List<LichTrinh> lichTrinhList=new ArrayList<>();
        try {
            lichTrinhList = session.createQuery("From LichTrinh").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return  lichTrinhList;
    }
    @Override
    public List<String> getAllMaLichTrinh(){
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        List<String> maLichTrinhList=new ArrayList<>();
        try {
            maLichTrinhList = session.createQuery("Select lt.maLichTrinh From LichTrinh lt").list();
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return  maLichTrinhList;
    }
    @Override
    public List<LichTrinh> searchLichTrinhs(String tenGaDi, int giaTriGaToi, String ngayDi){
        String sql="Select l.*\n" +
                "From LichTrinh l,\n" +
                "(SELECT DISTINCT lt2.*\n" +
                "FROM(SELECT DISTINCT lt.*, g.khoangCach\n" +
                "From LichTrinh lt ,Ga g\n" +
                "Where lt.maGaXuatPhat=g.maGa\n" +
                "and DAY(lt.thoiGianXuatPhat)=DAY(:ngayDi)\n" +
                "and g.tenGa=:tenGaDi) as lt2, Ga g2\n" +
                "Where lt2.maGaCuoi = g2.maGa\n" +
                "and ((:giaTri between lt2.khoangCach and g2.khoangCach) \n" +
                "or (:giaTri between g2.khoangCach and lt2.khoangCach))) l1\n" +
                "Where l.maLichTrinh=l1.maLichTrinh";
        Session session;
        try{
            session=sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            session=sessionFactory.openSession();
        }
        List<LichTrinh> lichTrinhList=new ArrayList<>();
        try {
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(LichTrinh.class);
            query.setParameter("tenGaDi", tenGaDi);
            query.setParameter("giaTri", giaTriGaToi);
            query.setParameter("ngayDi", ngayDi);
            System.out.println(tenGaDi);
            System.out.println(giaTriGaToi);
            System.out.println(ngayDi);
            lichTrinhList = (List<LichTrinh>) query.list();
            System.out.println(lichTrinhList.isEmpty());
            System.out.println(lichTrinhList.size());
        }catch (HibernateException e){
            System.out.println(e);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
        return lichTrinhList;
    }
}
