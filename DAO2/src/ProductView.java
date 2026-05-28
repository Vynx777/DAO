import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductView extends JFrame {
    private JPanel mainPanel;
    private JTable productsTable;
    private JTextField productNameButton;
    private JTextField productAmountButton;
    private JTextField productPriceButton;
    private JButton addProductButton;

    private ProductDAO productDAO;

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.setRowCount(0);

        for (Product p : productDAO.getProducts()) {
            model.addRow(new Object[]{p.getId(), p.getNazwa(), p.getIlosc(), p.getCena()});
        }
    }

    ProductView() {
        setContentPane(mainPanel);
        setTitle("DAO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        productDAO = new ProductDAO();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id", "Nazwa", "Ilość", "Cena"});
        productsTable.setModel(model);

        refreshTable();

        addProductButton.addActionListener(e -> {
            String name = productNameButton.getText();
            int amount = Integer.parseInt(productAmountButton.getText());
            double price = Double.parseDouble(productPriceButton.getText());
            int nextId = productDAO.getNextId() + 1;


            Product product = new Product(nextId, name, amount, price);
            productDAO.addProduct(product);

            // TODO:
            productDAO.getTotalValue();
        });

        setVisible(true);
    }

    static void main(String[] args) {
        new ProductView();
    }
}
