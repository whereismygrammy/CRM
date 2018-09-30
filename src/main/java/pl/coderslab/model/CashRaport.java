package pl.coderslab.model;

import pl.coderslab.dao.CashRaportDao;
import pl.coderslab.dao.TimeRaportDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CashRaport {

    double cash;
    LocalDate start;
    LocalDate end;

    public CashRaport(String start, String end) {
        setStart(start);
        setEnd(end);
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = LocalDate.parse(start);
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = LocalDate.parse(end);
    }

    public double getCash() {
        return cash;
    }

    public void setCash() {
        this.cash = CashRaportDao.getCashInTime(this);
    }
}
