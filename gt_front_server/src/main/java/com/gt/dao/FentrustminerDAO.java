package com.gt.dao;

import static org.hibernate.criterion.Example.create;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gt.dao.comm.HibernateDaoSupport;
import com.gt.entity.Fentrustminer;;

/**
 	* A data access object (DAO) providing persistence and search support for Fasset entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.ruizton.entity.Fasset
  * @author MyEclipse Persistence Tools 
 */

@Repository
public class FentrustminerDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(FentrustminerDAO.class);
		//property constants
	public static final String VERSION = "version";
	public static final String FTOTAL = "ftotal";
	public static final String STATUS = "status";



    
    public void save(Fentrustminer transientInstance) {
        log.debug("saving Fentrustminer instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Fentrustminer persistentInstance) {
        log.debug("deleting Fentrustminer instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Fentrustminer findById( java.lang.Integer id) {
        log.debug("getting Fentrustminer instance with id: " + id);
        try {
        	Fentrustminer instance = (Fentrustminer) getSession()
                    .get("com.gt.entity.Fentrustminer", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Fentrustminer> findByExample(Fentrustminer instance) {
        log.debug("finding Fentrustsnap instance by example");
        try {
            List<Fentrustminer> results = (List<Fentrustminer>) getSession()
                    .createCriteria("com.gt.entity.Fentrustminer")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Fentrustsnap instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Fentrustminer as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Fentrustminer> findByVersion(Object version
	) {
		return findByProperty(VERSION, version
		);
	}
	
	public List<Fentrustminer> findByFtotal(Object ftotal
	) {
		return findByProperty(FTOTAL, ftotal
		);
	}
	
	public List<Fentrustminer> findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all Fentrustminer instances");
		try {
			String queryString = "from Fentrustminer";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Fentrustminer merge(Fentrustminer detachedInstance) {
        log.debug("merging Fentrustminer instance");
        try {
        	Fentrustminer result = (Fentrustminer) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Fentrustminer instance) {
        log.debug("attaching dirty Fentrustminer instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Fentrustminer instance) {
        log.debug("attaching clean Fentrustminer instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<Fentrustminer> getSnaptByDate(int first_result,int max_result,Date endDate){
		
		log.debug("Fentrustminer all Fentrustminer instances");
		try {
			StringBuffer queryString = new StringBuffer("from Fentrustminer where status=1 and ") ;
			
			if(endDate!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
				queryString.append(" DATE_FORMAT(flastUpdatTime,'%Y-%m-%d') ='"+sdf.format(endDate)+"' and ") ;
			}

			queryString.append(" 1=1 ") ;
			
			Query queryObject = getSession().createQuery(queryString.toString());

			queryObject.setFirstResult(first_result) ;
			queryObject.setMaxResults(max_result) ;
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
    
public List<Fentrustminer> list(int first_result,int max_result,String filter, boolean isFY){
		
		log.debug("getFentrustHistory all Fentrustminer instances");
		try {
			StringBuffer queryString = new StringBuffer("from Fentrustminer ") ;
			queryString.append(filter) ;
			
			Query queryObject = getSession().createQuery(queryString.toString());
			if(isFY){
				queryObject.setFirstResult(first_result) ;
				queryObject.setMaxResults(max_result) ;
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}

}