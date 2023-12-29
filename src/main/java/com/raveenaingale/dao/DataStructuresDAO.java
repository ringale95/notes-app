package com.raveenaingale.dao;

import com.raveenaingale.models.DataStructure;
import com.raveenaingale.models.Problem;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

@Repository
public class DataStructuresDAO extends DAO{

    @Override
    public List list() throws Exception {
        try {
            // Fetch all user objects from the database
            begin();
            Query query = getSession().createQuery("from DataStructure");
            List<DataStructure> structureList = query.list();
            commit();
            close();

            return structureList;
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not fetch user list", e);
            throw new Exception("Exception while getting problem list: " + e.getMessage());
        }
    }

    public DataStructure create(DataStructure structure) throws Exception {
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

    public DataStructure get(long id) throws Exception {

        try {
            // Fetch user object from the database based on id
            begin();
            DataStructure user = getSession().get(DataStructure.class, id);
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


    public DataStructure update(DataStructure existingStructure) throws Exception {
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

    public void delete(DataStructure existingStructure) throws Exception {
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
}
