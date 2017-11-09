package uk.ac.ebi.pride.archive.projectstatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.projectstatus.model.ProjectStatus;
import uk.ac.ebi.pride.archive.projectstatus.service.repository.ProjectStatusesRepository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Service for looking up projects that have been recorded as being resubmissions,
 * by either document IDs or project accessions.
 */
@Service
public class ProjectStatusSearchService {

  @Resource
  private ProjectStatusesRepository projectStatusesRepository;

  @Autowired
  private MongoOperations mongoOperations;

  public ProjectStatusSearchService() {
  }

  /**
   * Constructor, includes setting the projectStatusesRepository.
   * @param projectStatusesRepository the projectStatusesRepository to set.
   */
  public ProjectStatusSearchService(ProjectStatusesRepository projectStatusesRepository) {
    this.projectStatusesRepository = projectStatusesRepository;
  }

  public ProjectStatus findById(String id) {
    return projectStatusesRepository.findOne(id);
  }

  public List<ProjectStatus> findByIdIn(Collection<String> ids) {
    return projectStatusesRepository.findByIdIn(ids);
  }

  public List<ProjectStatus> findByProjectAccession(String projectAccession) {
    return projectStatusesRepository.findByProjectAccession(projectAccession);
  }

  public List<ProjectStatus> findAll() {
    return projectStatusesRepository.findAll();
  }

  /**
   * Sets new projectStatusesRepository.
   *
   * @param projectStatusesRepository New value of projectStatusesRepository.
   */
  public void setResubmissionRepository(ProjectStatusesRepository projectStatusesRepository) {
    this.projectStatusesRepository = projectStatusesRepository;
  }
}
