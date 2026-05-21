import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainForm extends JFrame {
    private JButton addBookBtn;
    private JPanel mainPanel;
    private JTable booksTable;

    private BookDAO bookDAO;

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
        model.setRowCount(0);

        for (Book b : bookDAO.getAll()) {
            model.addRow(new Object[]{b.getTitle(), b.getAuthor(), b.getYear()});
        }
    }

    public  MainForm() {
        setContentPane(mainPanel);
        setTitle("DAO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        bookDAO = new BookDAO();

        refreshTable();

        addBookBtn.addActionListener(e ->{
            Book book = new Book("harry poter", "malysz", 2067);

            bookDAO.addBook(book);

            refreshTable();

            System.out.println(bookDAO.getAll());
        });
    }



    public static void main(String[] args) {
        new MainForm();
    }
}
