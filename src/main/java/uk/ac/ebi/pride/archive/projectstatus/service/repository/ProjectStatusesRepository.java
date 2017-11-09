package uk.ac.ebi.pride.archive.projectstatus.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.ac.ebi.pride.archive.projectstatus.model.ProjectStatus;

import java.util.Collection;
import java.util.List;

/**
 * Repository to query for ProjectStatuses documents.
 */
@Repository
public interface ProjectStatusesRepository extends MongoRepository<ProjectStatus, String> {

  ProjectStatus findById(String id);
  List<ProjectStatus> findByIdIn(Collection<String> id);
  List<ProjectStatus> findByProjectAccession(String projectAccession);

}

