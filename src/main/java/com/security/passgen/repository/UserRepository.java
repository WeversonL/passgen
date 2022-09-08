package com.security.passgen.repository;


import com.security.passgen.model.dao.AccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AccountDAO, Long> {

    @Query("SELECT a FROM AccountDAO a WHERE a.serviceName LIKE CONCAT('%',:serviceName,'%')")
    List<AccountDAO> findAllByServiceName(@Param("serviceName") String serviceName);

}
