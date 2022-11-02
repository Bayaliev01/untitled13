package peaksoft.model.dao.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.db.Util;
import peaksoft.model.Car;
import peaksoft.model.Person;
import peaksoft.model.SocialMedia;

import java.util.List;

public class SocialMediaImpl {
    private SessionFactory sessionFactory = Util.creatSessionFactory();

    public void saveMedia(SocialMedia socialMedia) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(socialMedia);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SocialMedia getSocialMedia(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SocialMedia socialMedia = session.get(SocialMedia.class, id);
            session.getTransaction().commit();
            return socialMedia;
        }
    }

    public List<SocialMedia> getAllMedia() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<SocialMedia> socialMediaList = session.createQuery("SELECT s FROM SocialMedia s").list();
            session.getTransaction().commit();
            session.close();
            return socialMediaList;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void updateSocialMedia(Long id, SocialMedia socialMedia) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SocialMedia newMedia = session.get(SocialMedia.class, id);
            newMedia.setName(socialMedia.getName());
            session.saveOrUpdate(newMedia);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void deleteSocialMedia(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            SocialMedia socialMedia = session.get(SocialMedia.class, id);

            for (Person i : socialMedia.getPersonList()) {
                i.setSocialMedia(null);
            }

            session.delete(socialMedia);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public SocialMedia getSocialMediaByName(String name) {
        try (Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            List<SocialMedia> socialMedia = session.createQuery("select u from SocialMedia u").list();
            session.getTransaction().commit();
            for (SocialMedia i : socialMedia) {
                if (i.getName().equals(name)) {
                    return i;
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
