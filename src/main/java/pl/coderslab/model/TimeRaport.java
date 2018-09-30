package pl.coderslab.model;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.TimeRaportDao;

import java.time.LocalDate;
import java.util.List;

public class TimeRaport {

    List<String[]> list;
    LocalDate start;
    LocalDate end;

    public TimeRaport(String start, String end) {
        setStart(start);
        setEnd(end);
    }

    public List<String[]> getList() {
        return list;
    }

    public void setList() {
        this.list = TimeRaportDao.getTimeRaport(this);
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
}
