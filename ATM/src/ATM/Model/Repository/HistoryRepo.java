package ATM.Model.Repository;

import ATM.Model.Pojo.History;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepo {


    public List<History> getHistoryByAccountID(int id){
        List<History> historyList=new ArrayList<>();


        Connection con= ConnectionJDBC.getConnection();
        String query="select *\n"
            + "from SuperGruppen.History\n"
            + "inner join SuperGruppen.Account\n"
            + "on History.AccountId = Account.id\n"
            + "where AccountId=?\n"
            + "having transactionDate>DATE_ADD(NOW(), INTERVAL -30 DAY);";
        try {
            PreparedStatement   preparedStatement=con.prepareStatement(query);

            preparedStatement.setString(1,id+"");
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                History history = new History();
                history.setId(resultSet.getInt("id"));
                history.setBalance(resultSet.getDouble("balance"));
                history.setTransactionAmount(resultSet.getDouble("transactionAmount"));
                history.setTransationDate(resultSet.getDate("transactionDate"));
                historyList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }


}
