package uk.ac.ebi.pride.archive.projectstatus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Models a document to in the projectstatuses collection.
 */
@Document(collection = "projectstatuses")
public class ProjectStatus {
  @Id
  private String id;
  private String projectAccession;
  private List<Date> trackHubCreationDates;
  private List<Date> trackHubCreationAttemptDates;
  private List<Date> poGoCreationDates;
  private List<Date> poGoCreationAttemptDates;
  private int totalNumberOfAssays;
  private List<String> assaysMzTabGenerated;
  private List<String> assaysMgfGenerated;
  private List<String> assaysMzTabIndexedPsm;
  private List<String> assaysMzTabIndexedProtein;
  private List<String> assaysMgfIndexed;
  private boolean generatedMgfMztabOnFtp;
  private String trackHubEnsemblReleaseVersion;

  
  // todo subclass / interface for status types?

  /**
   * Sets new projectAccession.
   *
   * @param projectAccession New value of projectAccession.
   */
  public void setProjectAccession(String projectAccession) {
    this.projectAccession = projectAccession;
  }

  /**
   * Sets new id.
   *
   * @param id New value of id.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets projectAccession.
   *
   * @return Value of projectAccession.
   */
  public String getProjectAccession() {
    return projectAccession;
  }

  /**
   * Gets id.
   *
   * @return Value of id.
   */
  public String getId() {
    return id;
  }

  /**
   * Gets track hub creation dates.
   *
   * @return Value of trackHubCreationDates.
   */
  public List<Date> getTrackHubCreationDates() {
    return trackHubCreationDates;
  }

  /**
   * Sets new track hub creation dates.
   *
   * @param trackHubCreationDates New value of trackHubCreationDates.
   */
  public void setTrackHubCreationDates(List<Date> trackHubCreationDates) {
    this.trackHubCreationDates = trackHubCreationDates;
  }

  /**
   * Sets new assaysMzTabIndexedPsm.
   *
   * @param assaysMzTabIndexedPsm New value of assaysMzTabIndexedPsm.
   */
  public void setAssaysMzTabIndexedPsm(List<String> assaysMzTabIndexedPsm) {
    this.assaysMzTabIndexedPsm = assaysMzTabIndexedPsm;
  }

  /**
   * Sets new assaysMgfIndexed.
   *
   * @param assaysMgfIndexed New value of assaysMgfIndexed.
   */
  public void setAssaysMgfIndexed(List<String> assaysMgfIndexed) {
    this.assaysMgfIndexed = assaysMgfIndexed;
  }

  /**
   * Sets new assaysMgfGenerated.
   *
   * @param assaysMgfGenerated New value of assaysMgfGenerated.
   */
  public void setAssaysMgfGenerated(List<String> assaysMgfGenerated) {
    this.assaysMgfGenerated = assaysMgfGenerated;
  }

  /**
   * Gets generatedMgfMztabOnFtp.
   *
   * @return Value of generatedMgfMztabOnFtp.
   */
  public boolean isGeneratedMgfMztabOnFtp() {
    return generatedMgfMztabOnFtp;
  }

  /**
   * Gets assaysMgfGenerated.
   *
   * @return Value of assaysMgfGenerated.
   */
  public List<String> getAssaysMgfGenerated() {
    return assaysMgfGenerated;
  }

  /**
   * Gets assaysMzTabIndexedProtein.
   *
   * @return Value of assaysMzTabIndexedProtein.
   */
  public List<String> getAssaysMzTabIndexedProtein() {
    return assaysMzTabIndexedProtein;
  }

  /**
   * Gets assaysMzTabIndexedPsm.
   *
   * @return Value of assaysMzTabIndexedPsm.
   */
  public List<String> getAssaysMzTabIndexedPsm() {
    return assaysMzTabIndexedPsm;
  }

  /**
   * Gets assaysMgfIndexed.
   *
   * @return Value of assaysMgfIndexed.
   */
  public List<String> getAssaysMgfIndexed() {
    return assaysMgfIndexed;
  }

  /**
   * Gets totalNumberOfAssays.
   *
   * @return Value of totalNumberOfAssays.
   */
  public int getTotalNumberOfAssays() {
    return totalNumberOfAssays;
  }

  /**
   * Sets new totalNumberOfAssays.
   *
   * @param totalNumberOfAssays New value of totalNumberOfAssays.
   */
  public void setTotalNumberOfAssays(int totalNumberOfAssays) {
    this.totalNumberOfAssays = totalNumberOfAssays;
  }

  /**
   * Gets assaysMzTabGenerated.
   *
   * @return Value of assaysMzTabGenerated.
   */
  public List<String> getAssaysMzTabGenerated() {
    return assaysMzTabGenerated;
  }

  /**
   * Sets new assaysMzTabIndexedProtein.
   *
   * @param assaysMzTabIndexedProtein New value of assaysMzTabIndexedProtein.
   */
  public void setAssaysMzTabIndexedProtein(List<String> assaysMzTabIndexedProtein) {
    this.assaysMzTabIndexedProtein = assaysMzTabIndexedProtein;
  }

  /**
   * Sets new assaysMzTabGenerated.
   *
   * @param assaysMzTabGenerated New value of assaysMzTabGenerated.
   */
  public void setAssaysMzTabGenerated(List<String> assaysMzTabGenerated) {
    this.assaysMzTabGenerated = assaysMzTabGenerated;
  }

  /**
   * Sets new generatedMgfMztabOnFtp.
   *
   * @param generatedMgfMztabOnFtp New value of generatedMgfMztabOnFtp.
   */
  public void setGeneratedMgfMztabOnFtp(boolean generatedMgfMztabOnFtp) {
    this.generatedMgfMztabOnFtp = generatedMgfMztabOnFtp;
  }

  /**
   * Sets new poGoCreationDates.
   *
   * @param poGoCreationDates New value of poGoCreationDates.
   */
  public void setPoGoCreationDates(List<Date> poGoCreationDates) {
    this.poGoCreationDates = poGoCreationDates;
  }

  /**
   * Sets new trackHubCreationAttemptDates.
   *
   * @param trackHubCreationAttemptDates New value of trackHubCreationAttemptDates.
   */
  public void setTrackHubCreationAttemptDates(List<Date> trackHubCreationAttemptDates) {
    this.trackHubCreationAttemptDates = trackHubCreationAttemptDates;
  }

  /**
   * Sets new poGoCreationAttemptDates.
   *
   * @param poGoCreationAttemptDates New value of poGoCreationAttemptDates.
   */
  public void setPoGoCreationAttemptDates(List<Date> poGoCreationAttemptDates) {
    this.poGoCreationAttemptDates = poGoCreationAttemptDates;
  }

  /**
   * Gets poGoCreationAttemptDates.
   *
   * @return Value of poGoCreationAttemptDates.
   */
  public List<Date> getPoGoCreationAttemptDates() {
    return poGoCreationAttemptDates;
  }

  /**
   * Gets trackHubCreationAttemptDates.
   *
   * @return Value of trackHubCreationAttemptDates.
   */
  public List<Date> getTrackHubCreationAttemptDates() {
    return trackHubCreationAttemptDates;
  }

  /**
   * Gets poGoCreationDates.
   *
   * @return Value of poGoCreationDates.
   */
  public List<Date> getPoGoCreationDates() {
    return poGoCreationDates;
  }

  /**
   * Sets new trackhubEnsemblReleaseVersion.
   *
   * @param trackHubEnsemblReleaseVersion New value of trackhubEnsemblReleaseVersion.
   */
  public void setTrackHubEnsemblReleaseVersion(String trackHubEnsemblReleaseVersion) {
    this.trackHubEnsemblReleaseVersion = trackHubEnsemblReleaseVersion;
  }

  /**
   * Gets trackHubEnsemblReleaseVersion.
   *
   * @return Value of trackHubEnsemblReleaseVersion.
   */
  public String getTrackHubEnsemblReleaseVersion() {
    return trackHubEnsemblReleaseVersion;
  }
}
