package cursach.dto;

import java.util.Objects;

public class Book {
    private String ID;
    private String contractNumber;
    private String title;
    private String circulation;
    private String printDate;
    private String costPrice;
    private String cost;
    private String fee;

    public Book(String ID, String contractNumber, String title,
                String circulation, String printDate, String costPrice,
                String cost, String fee) {
        this.ID = ID;
        this.contractNumber = contractNumber;
        this.title = title;
        this.circulation = circulation;
        this.printDate = printDate;
        this.costPrice = costPrice;
        this.cost = cost;
        this.fee = fee;
    }

    public String getID() {
        return ID;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getCirculation() {
        return circulation;
    }

    public String getPrintDate() {
        return printDate;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public String getCost() {
        return cost;
    }

    public String getFee() {
        return fee;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book books = (Book) o;
        return Objects.equals(ID, books.ID) &&
                Objects.equals(contractNumber, books.contractNumber) &&
                Objects.equals(title, books.title) &&
                Objects.equals(circulation, books.circulation) &&
                Objects.equals(printDate, books.printDate) &&
                Objects.equals(costPrice, books.costPrice) &&
                Objects.equals(cost, books.cost) &&
                Objects.equals(fee, books.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, contractNumber, title, circulation, printDate,
                costPrice, cost, fee);
    }
}
