/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.LoaiBLL;
import BLL.ThongKeSPBLL;
import Entity.loai;
import Entity.thongkeSP;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
  

/**
 *
 * @author ACER
 */
public class ThongKeSPGUI extends JPanel{
    ThongKeSPBLL tkBLL = new ThongKeSPBLL();
    private LoaiBLL loaiBLL = new LoaiBLL();
    private int DEFAUTL_WIDTH;
    private JLabel lbDateStart,lbDateEnd, lbLoai;
    private JPanel panel;
    private JComboBox cmbLoai;
    private JTextField txtLoai;

    JDateChooser txtDateStart = new JDateChooser();
    JDateChooser txtDateEnd = new JDateChooser();
    
    public ThongKeSPGUI(int width) {
        this.DEFAUTL_WIDTH = width;
        init();
    }
    
    public void init(){   
    setSize(DEFAUTL_WIDTH, 700);
    setBackground(new Color(247, 241, 227));
    setLayout(null);
    
    Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
    Font font1 = new Font("Segoe UI", Font.BOLD, 13);
    
    LoaiModel loaiModel = listLoai();
		
    panel = new JPanel();
    panel.setBounds(350, 65, 700, 450);
    panel.setBackground(new Color(247, 241, 227));
    
    lbDateStart = new JLabel("Ngày Bắt Đầu:");
    lbDateStart.setFont(font0);
    lbDateStart.setBounds(20, 100, 100, 30);
    txtDateStart.setBounds(new Rectangle(120, 100, 190, 30));
    txtDateStart.setDateFormatString("dd/MM/yyyy");
    add(lbDateStart);
    add(txtDateStart);
        
    
    lbDateEnd = new JLabel("Ngày Kết Thúc:");
    lbDateEnd.setFont(font0);
    lbDateEnd.setBounds(20, 150, 100, 30);
    txtDateEnd.setBounds(new Rectangle(120, 150, 190, 30));
    txtDateEnd.setDateFormatString("dd/MM/yyyy");
    add(lbDateEnd);
    add(txtDateEnd);
    
    JLabel lbLoai = new JLabel("Loại");
    lbLoai.setBounds(new Rectangle(0, 180, 40, 30));
    lbLoai.setFont(font1);
    cmbLoai = new JComboBox<>(loaiModel);
    cmbLoai.setFont(font0);
    cmbLoai.setBounds(new Rectangle(100, 180, 110, 30));
        
    JButton btnSubmit = new JButton("Thống kê");
    //set font chu
    Font font = new Font("Tahoma", Font.PLAIN, 18);
    btnSubmit.setFont(font);
    btnSubmit.setForeground(Color.WHITE);
    //set mau sac
    Color color = new Color(255, 218, 121);
    btnSubmit.setBackground(color);
    btnSubmit.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
    //set vi tri
    btnSubmit.setBounds(120, 230, 120, 35);
    add(btnSubmit);
    
    btnSubmit.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        hienthichart();
    }
});
    add(panel);
    
    }
    
    public LoaiModel listLoai() {
        if (loaiBLL.getList() == null) {
            loaiBLL.list();
        }
        loai[] l = new loai[loaiBLL.getList().size() + 1];
        loai all = new loai();
        all.setId_Loai(0);
        all.setName("Loại sản phẩm");
        int i = 0;
        l[i] = all;
        for (loai lo : loaiBLL.getList()) {
            i++;
            l[i] = lo;
        }
        LoaiModel model = new LoaiModel(l);
        return model;
    }
    
    public void hienthichart(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        //validation
        if(cmbLoai.getSelectedItem().toString().equals("Loại sản phẩm")){
            JOptionPane.showMessageDialog(null ,"Vui lòng chọn loại sản phẩm !!!", "Warning", 
                        JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<thongkeSP> tks = tkBLL.getChart(cmbLoai.getSelectedItem().toString());
        for(thongkeSP tk : tks){
            dcd.setValue(tk.getSoLuong(), "soluong", tk.getNameSP());
            System.out.println(tk.getNameSP());
        }
        JFreeChart jchart = ChartFactory.createBarChart("Số lượng sản phẩm", "Tên Sản Phẩm", "tổng số", dcd, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(jchart);

        panel.removeAll();
        panel.add(chartPanel);
    }
}
    
