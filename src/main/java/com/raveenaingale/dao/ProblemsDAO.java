package com.raveenaingale.dao;

import com.raveenaingale.models.Problem;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProblemsDAO extends DAO{

    @Override
    public List list() throws Exception {
        try {
            // Fetch all user objects from the database
            begin();
            Query query = getSession().createQuery("from Problem");
            List<Problem> problemList = query.list();
            commit();
            close();

            return problemList;
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not fetch user list", e);
            throw new Exception("Exception while getting problem list: " + e.getMessage());
        }
    }

    public Problem create(Problem problem) throws Exception {
        try {

            // save user object in the database
            begin();
            getSession().save(problem);
            commit();
            close();

            return problem;
        } catch (HibernateException e) {
            rollback();
            // throw new AdException("Could not create user " + username, e);
            throw new Exception("Exception while creating problem: " + e.getMessage());
        }
    }

    @Override
    public List search(Map<String, String> criteria) throws Exception {
        return null;
    }
}
