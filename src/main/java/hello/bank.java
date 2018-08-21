package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // This tells Hibernate to make a table out of this class
public class bank {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String schet;

    private Long balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchet() {
        return schet;
    }

    public void setSchet(String schet) {
        this.schet = schet;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}