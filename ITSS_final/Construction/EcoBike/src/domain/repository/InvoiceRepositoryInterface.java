package domain.repository;

import java.sql.SQLException;

import domain.entity.invoice.Invoice;

public interface InvoiceRepositoryInterface{
    public void creatNewInvoiceDB(Invoice invoice) throws SQLException;
}