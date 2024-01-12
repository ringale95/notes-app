package com.raveenaingale.dao;

import com.raveenaingale.models.Application;
import com.raveenaingale.models.DataStructure;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicationsDAO extends DAO{

    @Override
    public List list() throws Exception {
        try {
            // Fetch all user objects from the database
            begin();
            Query query = getSession().createQuery("from Application");
            List<Application> structureList = query.list();
            commit();
            close();

            return structureList;
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not fetch user list", e);
            throw new Exception("Exception while getting problem list: " + e.getMessage());
        }
    }

    public Application create(Application structure) throws Exception {
        try {

            // save user object in the database
            begin();
            getSession().save(structure);
            commit();
            close();

            return structure;
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not create user " + username, e);
            throw new Exception("Exception while creating structure: " + e.getMessage());
        }
    }

    public Application get(long id) throws Exception {

        try {
            // Fetch user object from the database based on id
            begin();
            Application user = getSession().get(Application.class, id);
            commit();
            close();

            return user;
        } catch (HibernateException e) {

            rollback();
            // throw new AdException("Could not fetch user with id: " + id, e);
            throw new Exception("Exception while fetching user with id: " + id + ", " + e.getMessage());
        }

    }

    @Override
    public List search(Map<String, String> criteria) throws Exception {
        return null;
    }


    public Application update(Application existingStructure) throws Exception {
        try {
            // Update user object in the database
            begin();
            getSession().update(existingStructure);
            commit();
            close();

            return existingStructure;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while updating structure: " + e.getMessage());
        }
    }

    public void delete(Application existingStructure) throws Exception {
        try {
            // Delete user object from the database
            begin();
            getSession().delete(existingStructure);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while deleting structure: " + e.getMessage());
        }
    }

    public int getTodaysApplicationCount() throws Exception {
        try {
            begin();

            // Construct the query to get the count of applications created today
            Query<Long> query = getSession().createQuery(
                    "select count(*) from Application where creationDate = :today", Long.class);
            query.setParameter("today", LocalDate.now());

            // Execute the query and get the count
            long count = query.uniqueResult();

            commit();
            close();

            return (int) count; // Convert the long count to int
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while getting today's application count: " + e.getMessage());
        }
    }

}
