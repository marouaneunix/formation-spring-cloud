package com.naf.collaborator.repository;

import com.naf.collaborator.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    @Query("select c from Collaborator c where c.firstName like %:firstName%")
    List<Collaborator> findByFirstNameQuery(@Param("firstName") String firstName);

    List<Collaborator> findByProjectId(Long projectId);
}
