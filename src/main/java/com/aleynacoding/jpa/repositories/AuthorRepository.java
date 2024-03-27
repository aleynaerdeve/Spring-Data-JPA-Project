package com.aleynacoding.jpa.repositories;

import com.aleynacoding.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age")int age);
    List<Author> findByNamedQuery(@Param("age") int age);
    @Transactional
    @Modifying //Hibernate will understand that it is an update query
    @Query("update Author a set a.age=:age where a.id=:id")
    int updateAuthor(int age, int id);
    @Transactional //use with modify
    @Modifying //Hibernate will understand that it is an update query
    @Query("update Author a set a.age=:age")
    void updateAllAuthorsAges(int age);



    //select * from author where firstname=
    List<Author> findAllByFirstname(String fn); //change first letter to a capitol letter

    List<Author> findAllByFirstnameIgnoreCase(String fn);

    //select * from author where firstname like '%al'
    List<Author> findAllByFirstnameContainingIgnoreCase(String fn);

    //select * from author where firstname like 'al%'
    List<Author> findAllByFirstnameStartsWithIgnoreCase(String fn);

    //select * from author where firstname like '%al'
    List<Author> findAllByFirstnameEndsWithIgnoreCase(String fn);

    //select * from author where firstname in ('aleyna', 'erdeve', 'coding')
    List<Author> findAllByFirstnameInIgnoreCase(List<String> firstnames);

}
