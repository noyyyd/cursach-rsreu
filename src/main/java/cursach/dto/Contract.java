package cursach.dto;

import java.util.Objects;

public class Contract {
    private String ID;
    private String dateOfConclusion;
    private String terminationDate;
    private String term;
    private String status;

    public Contract(String ID, String dateOfConclusion, String terminationDate,
                    String term, String status) {
        this.ID = ID;
        this.dateOfConclusion = dateOfConclusion;
        this.terminationDate = terminationDate;
        this.term = term;
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public String getDateOfConclusion() {
        return dateOfConclusion;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public String getTerm() {
        return term;
    }

    public String getStatus() {
        return status;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDateOfConclusion(String dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(ID, contract.ID) &&
                Objects.equals(dateOfConclusion, contract.dateOfConclusion) &&
                Objects.equals(terminationDate, contract.terminationDate) &&
                Objects.equals(term, contract.term) &&
                Objects.equals(status, contract.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, dateOfConclusion, terminationDate, term, status);
    }
}
