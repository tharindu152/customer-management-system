package lk.dce.interview.repository;

import javax.persistence.EntityManager;

public interface SuperRepository {
    void setEntityManager(EntityManager em);
}
