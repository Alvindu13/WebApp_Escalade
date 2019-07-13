package com.escalade.data.repository;

import com.escalade.data.model.Topo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TopoRepository extends CrudRepository<Topo, Integer> {


    Topo findByTopoId (int topoId);

    Page<Topo> findAllByUserEscaladCurrentProprio(Integer currentUserEscalad, Pageable pageable);

    Page<Topo> findAll(Pageable pageable);


    @Query (value ="SELECT  * " +
            "FROM topo t \n" +
            "INNER JOIN user_escalad u ON u.user_escalad_id = t.user_escalad_id \n" +
            "WHERE username = ?1 ORDER BY ?#{#pageable}",

            countQuery = "SELECT count(*) \n" +
                    "FROM topo t \n" +
                    "INNER JOIN user_escalad u ON u.user_escalad_id = t.user_escalad_id \n" +
                    "WHERE username = ?1",
            nativeQuery = true)
    Page<Topo> findAllByUserEscaladName (String userName, Pageable pageable);


    @Query(value="SELECT t FROM Topo t " +
            " WHERE t.available = ?1")
    Page<Topo> getAllByAvailableIsTrue(Boolean available, Pageable pageable);


    @Modifying
    @Transactional
    @Query(value="UPDATE topo "+
            "SET currently_user_escalad_id = ?1 "+
            "WHERE topo_id = ?2", nativeQuery = true)
    void setTopoUserNameByUserEscaladId(Integer userEscaladId, Integer topoId);



    @Modifying
    @Transactional
    @Query(value="UPDATE topo "+
            "SET available = ?1 "+
            "WHERE topo_id = ?2", nativeQuery = true)
    void setTopoUnvailableById(Boolean unvailable, Integer topoId);



    @Modifying
    @Transactional
    @Query(value="UPDATE topo "+
            "SET reserve = ?1 "+
            "WHERE topo_id = ?2", nativeQuery = true)
    void setTopoReserveUserIdByTopoId(Boolean reserve, Integer topoId);

}
