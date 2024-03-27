package com.aleynacoding.jpa.repositories;

import com.aleynacoding.jpa.JpaApplication;
import com.aleynacoding.jpa.models.Video;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VideoRepository extends JpaRepository<Video, Integer> {
}
