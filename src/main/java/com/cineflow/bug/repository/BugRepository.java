package com.cineflow.bug.repository;
import com.cineflow.bug.entity.Bug; import java.util.*; import org.springframework.data.jpa.repository.*;
public interface BugRepository extends JpaRepository<Bug, UUID>, JpaSpecificationExecutor<Bug> { boolean existsByBugKeyAndDeletedFalse(String key); boolean existsByBugKeyAndIdNotAndDeletedFalse(String key, UUID id); Optional<Bug> findByIdAndDeletedFalse(UUID id); }
