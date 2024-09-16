package com.app.test.repository;

import com.app.test.model.Child;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ChildRepository extends SimpleJpaRepository<Child, String> {
    private final EntityManager em;
    public ChildRepository(EntityManager em) {
        super(Child.class, em);
        this.em = em;
    }
    @Override
    public List<Child> findAll() {
        return em.createNativeQuery("Select * from \"test\".\"Child\"", Child.class).getResultList();
    }
}