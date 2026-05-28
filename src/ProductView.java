import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductView extends JFrame {
    private JPanel mainPanel;
    private JTable productsTable;
    private JTextField productNameButton;
    private JTextField productAmountButton;
    private JTextField productPriceButton;
    private JButton addProductButton;
    private JLabel totalAmountText;

    private ProductDAO productDAO;

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.setRowCount(0);

        for (Product p : productDAO.getProducts()) {
            model.addRow(new Object[]{p.getId(), p.getNazwa(), p.getIlosc(), p.getCena()});
        }
    }

    public boolean isInt(String str) {
        if (str == null) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    ProductView() {
        setContentPane(mainPanel);
        setTitle("DAO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        productDAO = new ProductDAO();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id", "Nazwa", "Ilość", "Cena"});
        productsTable.setModel(model);

        refreshTable();

        addProductButton.addActionListener(e -> {
            String name = productNameButton.getText();
            if (name == null || name.isEmpty()) {
                return;
            }

            int amount = isInt(productAmountButton.getText()) ? Integer.parseInt(productAmountButton.getText()) : 1;
            double price = isDouble(productPriceButton.getText()) ? Double.parseDouble(productPriceButton.getText()) : 1;
            int nextId = productDAO.getNextId() + 1;

            Product product = new Product(nextId, name, amount, price);
            productDAO.addProduct(product);

            refreshTable();

            totalAmountText.setText("Łączna wartość magazynu: " + productDAO.getTotalValue() + "zł");
        });

        setVisible(true);
    }

    static void main(String[] args) {
        new ProductView();
    }
}
