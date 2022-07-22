package Resume_Desktop_App.JDBC.dao;
import Resume_Desktop_App.JDBC.entity.EmploymentHistory;


import java.util.List;

public interface EmploymentHistoryInterface {
    public List<EmploymentHistory> getAllEmploymentHistory(int id);
}
