package com.silveirasolutions.dsmovie.repositories;

import com.silveirasolutions.dsmovie.entities.Score;
import com.silveirasolutions.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}