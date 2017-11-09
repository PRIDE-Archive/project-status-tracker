package uk.ac.ebi.pride.archive.projectstatus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.ebi.pride.archive.projectstatus.model.ProjectStatus;
import uk.ac.ebi.pride.archive.projectstatus.service.repository.ProjectStatusesRepository;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Service to save project resubmissions to the database.
 */
@Service
public class ProjectStatusKeepService {

  @Resource
  private ProjectStatusesRepository projectStatusesRepository;

  /**
   * Default constructor.
   */
  public ProjectStatusKeepService() {
  }

  /**
   * Constructor, includes setting the projectStatusesRepository.
   * @param projectStatusesRepository the projectStatusesRepository to set.
   */
  public ProjectStatusKeepService(ProjectStatusesRepository projectStatusesRepository) {
    this.projectStatusesRepository = projectStatusesRepository;
  }

  /**
   * Saves the projectStatus to the collection.
   * @param projectStatus the projectStatus to track.
   */
  @Transactional
  public void save(ProjectStatus projectStatus) {
    projectStatusesRepository.save(projectStatus);
  }

  /**
   * Saves a list of projectStatuses to the collection.
   * @param projectStatuses the projectStatuses to track.
   */
  @Transactional
  public void save(Iterable<ProjectStatus> projectStatuses) {
    if (projectStatuses==null || !projectStatuses.iterator().hasNext()) {
      projectStatusesRepository.save(projectStatuses);
    }
  }
  /**
   * Saves a collection of projectStatuses to the collection.
   * @param projectStatuses the projectStatus to track.
   */
  @Transactional
  public Iterable<ProjectStatus> save(Collection<ProjectStatus> projectStatuses) {
    return projectStatusesRepository.save(projectStatuses);
  }

  /**
   * Delete a projectStatus in the collection.
   * @param projectStatus the projectStatus to delete.
   */
  @Transactional
  public void delete(ProjectStatus projectStatus) {
    projectStatusesRepository.delete(projectStatus);
  }

  /**
   * Delete an iterable of projectStatuses in the collection.
   * @param projectStatuses the projectStatuses to delete.
   */
  @Transactional
  public void delete(Iterable<ProjectStatus> projectStatuses) {
    if (projectStatuses==null || !projectStatuses.iterator().hasNext()) {
      projectStatusesRepository.delete(projectStatuses);
    }
  }

  /**
   * Delete all the documents from the collection.
   */
  @Transactional
  public void deleteAll() {
    projectStatusesRepository.deleteAll();
  }

  /**
   * Delete all the documents from the collection by project accession.
   */
  @Transactional
  public void deleteByProjectAccession(String projectAccession) {
    //Possible improvement, retrieve the ids to be deleted instead of the objects
    projectStatusesRepository.delete(projectStatusesRepository.findByProjectAccession(projectAccession));
  }

  /**
   * Sets new projectStatusesRepository.
   *
   * @param projectStatusesRepository New value of projectStatusesRepository.
   */
  public void setProjectStatusesRepository(ProjectStatusesRepository projectStatusesRepository) {
    this.projectStatusesRepository = projectStatusesRepository;
  }
}
