package data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;
import domain.entity.invoice.Invoice;
import domain.repository.InvoiceRepositoryInterface;

public class InvoiceRepositoryImpl extends BaseRepository implements InvoiceRepositoryInterface {

    @Override
    public void creatNewInvoiceDB(Invoice invoice) throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        String orderID = Integer.toString(invoice.getOrder().getId());
        String totalAmount = Integer.toString(invoice.getAmount());
        String content = "\'" + invoice.getContents() + "\'";

        stm.execute("INSERT INTO Invoice(content, totalAmount, orderID) VALUES (" + content + "," + totalAmount + "," + orderID + ");");

        int id = -1;
        ResultSet res = stm.executeQuery("SELECT id from Invoice");
        while (res.next()) {
            id = res.getInt("id");
        }
        invoice.setId(id);
    }
    
}
