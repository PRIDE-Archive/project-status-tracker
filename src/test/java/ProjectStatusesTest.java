import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.projectstatus.model.ProjectStatus;
import uk.ac.ebi.pride.archive.projectstatus.service.ProjectStatusKeepService;
import uk.ac.ebi.pride.archive.projectstatus.service.ProjectStatusSearchService;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mongo-test-context.xml")
public class ProjectStatusesTest {
  private static Logger logger = LoggerFactory.getLogger(ProjectStatusesTest.class);

  private static final String PXD000001 = "PXD000001";
  private static final String PXD000002 = "PXD000002";
  @Resource
  private ProjectStatusKeepService projectStatusKeepService;

  @Resource
  private ProjectStatusSearchService projectStatusSearchService;

  /**
   * To start, delete any existing test data, and inserts new test data.
   * @throws Exception any problems setting up test data.
   */
  @Before
  public void setUp() throws Exception {
    deleteAllData();
    insertTestData();
  }

  /**
   * Finally tidy up and delete all test data.
   * @throws Exception any problems deleting the test data.
   */
  @After
  public void tearDown() throws Exception {
    deleteAllData();
  }

  /**
   * Deletes all test data from the test database.
   */
  private void deleteAllData() {
    projectStatusKeepService.deleteAll();
  }

  /**
   * Inserts test data ino a test database.
   */
  private void insertTestData() {
    ProjectStatus testData1 = new ProjectStatus();
    testData1.setProjectAccession(PXD000001);
    List<Date> testData1Dates = new ArrayList<>();
    testData1Dates.add(Date.from(Instant.now()));
    testData1.setTrackHubCreationDates(testData1Dates);
    projectStatusKeepService.save(testData1);
    ProjectStatus testData2 = new ProjectStatus();
    testData2.setProjectAccession(PXD000002);
    List<Date> testData2Dates = new ArrayList<>();
    testData2Dates.add(Date.from(Instant.now()));
    testData2.setTrackHubCreationDates(testData2Dates);
    projectStatusKeepService.save(testData2);
    LocalDate past = LocalDate.of(2010, 1, 14);
    testData2Dates.add(Date.from(past.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    projectStatusKeepService.save(testData2);
    logger.info("Successfully tested inserting data");
  }

  /**
   * Tests searching the collection via IDs.
   * @param ids input document IDs to search on.
   */
  private void testSearchById(List<String> ids) {
    assertNotNull(ids);
    assertTrue(ids.size()>0);
    for (String id : ids) {
      ProjectStatus projectStatus = projectStatusSearchService.findById(id);
      assertNotNull(projectStatus);
      assertEquals(projectStatus.getId(), id);
    }
    List<ProjectStatus> resubmissions = projectStatusSearchService.findByIdIn(ids);
    assertNotNull(resubmissions);
    logger.info("Successfully tested searching by document IDs.");
  }

  /**
   * Tests searching the collection via project accessions.
   */
  @Test
  public void testSearchByProjectAccession() {
    List<ProjectStatus> projectStatuses = projectStatusSearchService.findByProjectAccession(PXD000001);
    assertEquals(projectStatuses.size(), 1);
    ProjectStatus resubmission1 = projectStatuses.get(0);
    assertNotNull(resubmission1);
    assertEquals(resubmission1.getProjectAccession(), PXD000001);
    projectStatuses = projectStatusSearchService.findByProjectAccession(PXD000002);
    assertEquals(projectStatuses.size(), 1);
    ProjectStatus resubmission2 = projectStatuses.get(0);
    assertNotNull(resubmission2);
    assertEquals(resubmission2.getProjectAccession(), PXD000002);
    logger.info("Successfully tested searching by project accession.");
    List<String> idsToSerch = new ArrayList<>();
    idsToSerch.add(resubmission1.getId());
    idsToSerch.add(resubmission2.getId());
    testSearchById(idsToSerch);
    List<ProjectStatus> allprojectStatuses = projectStatusSearchService.findAll();
    assertNotNull(allprojectStatuses);
    assertEquals(allprojectStatuses.size(), 2);
  }
}
