/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanVienDAL;
import Entity.Gender;
import Entity.nhanvien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVienBLL {
    
    private List<nhanvien> nvBLL;
    
    public NhanVienBLL() {
        nvBLL = null;
    }
    
    public List<nhanvien> getList() {
        return nvBLL;
    }
    
    public void list() {
        NhanVienDAL nvDAO = new NhanVienDAL();
        nvBLL = new ArrayList<>();
        nvBLL = nvDAO.loadNhanVien();
    }
    
    public nhanvien getEmployeeByPhone(String phone) {
        NhanVienDAL nvDAO = new NhanVienDAL();
        nhanvien nv = nvDAO.getOneByPhone(phone);
        return nv;
    }
    
    public nhanvien getEmployeeByGender(Gender phai) {
        NhanVienDAL nvDAO = new NhanVienDAL();
        nvBLL.add(nvDAO.getOneByGender(phai));
        return nvBLL.get(nvBLL.size());
    }
    
    public nhanvien getEmployeeById(String MaNV) 
    {
        for (nhanvien nv : nvBLL) {
            if (nv.getId_NV() == Integer.parseInt(MaNV)) {
                return nv;
            }
        }
        return null;
    }
    
    public void add(nhanvien nv) {
        NhanVienDAL nvDAO = new NhanVienDAL();
        nvDAO.addNhanVien(nv);
        nvBLL.add(nv);
    }
    
    public void delete(String id) {
        int idNV = Integer.parseInt(id);
        for (nhanvien nv : nvBLL) {
            if (nv.getId_NV() == idNV) {
                NhanVienDAL nvDAO = new NhanVienDAL();
                nvDAO.deleteNhanVien(nv);
                return;
            }
        }
    }
    
    public void set(nhanvien nv) {
        for (int i = 0; i < nvBLL.size(); i++) {
            if (nvBLL.get(i).getId_NV() == nv.getId_NV()) {
                if (nv.getImg().equals("null")) {
                    nv.setImg(nvBLL.get(i).getImg());
                }
                NhanVienDAL nvDAO = new NhanVienDAL();
                nvDAO.updateNhanVien(nv);
                nvBLL.set(i, nvDAO.getOneById(nvBLL.get(i).getId_NV()));
                return;
            }
        }
    }
    
    public boolean check(String manv) {
        for (nhanvien nv : nvBLL) {
            if (String.valueOf(nv.getId_NV()).equals(manv)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<nhanvien> search(int manv, String name, String phone, String phai) {
        ArrayList<nhanvien> search = new ArrayList<>();
        name = name.toLowerCase();
        Gender gender = Gender.female;
        if (!phai.equals("")) {
            if (phai.equals("Nam")) {
                gender = Gender.male;
            } else if (phai.equals("Nữ")) {
                gender = Gender.female;
            }
        }
        for (nhanvien nv : nvBLL) {
            if ((nv.getId_NV() == manv) && nv.getName().toLowerCase().contains(name) && nv.getPhone().contains(phone) && (nv.getGender().toString().equals(gender.toString()) || phai.equals(""))) {
                search.add(nv);
            } else if ((manv == 0) && nv.getName().toLowerCase().contains(name) && nv.getPhone().contains(phone) && (nv.getGender().toString().equals(gender.toString()) || phai.equals(""))) {
                search.add(nv);
            }
        }
        return search;
    }

//    public void export(String excelFilePath){
//    
//    
//    XSSFWorkbook workbook = new XSSFWorkbook();
//    XSSFSheet sheet = workbook.createSheet("Employee");
//
//    XSSFFont font = workbook.createFont();
//    font.setFontHeightInPoints((short) 12);
//    font.setBold(true);
//    
//    font.setColor(IndexedColors.BLUE.getIndex());
//
//    // Create a CellStyle with the font
//    XSSFCellStyle headerCellStyle = workbook.createCellStyle();
//    headerCellStyle.setFont(font);
//
//    // Create a Row
//    Row headerRow = sheet.createRow(0);
//    String[] columns = {
//            "Name",
//            "Age",
//            "Gender",
//            "Address",
//            "Phone",
//            "Start_Day"
//    };
//
//    // Create cells
//    for (int i = 0; i < columns.length; i++) {
//        Cell cell = headerRow.createCell(i);
//        cell.setCellValue(columns[i]);
//        cell.setCellStyle(headerCellStyle);
//    }
//
//    // Create Other rows and cells with employees data
//    int rowNum = 1;
//    list();
//    List<nhanvien> employeeDTOs = getNvBUS();
//    for (nhanvien nv : employeeDTOs) {
//        Row row = sheet.createRow(rowNum++);
//
//        row.createCell(0)
//                .setCellValue(nv.getName());
//
//        row.createCell(1)
//                .setCellValue(nv.getAge());
//        row.createCell(2)
//                .setCellValue(nv.getGender().toString());
//        row.createCell(3)
//                .setCellValue(nv.getAddress());
//        row.createCell(4)
//                .setCellValue(nv.getPhone());
//        row.createCell(5)
//                .setCellValue(nv.getStart_day().toString());
//        
//    }
//
//    for (int i = 0; i < columns.length; i++) {
//        sheet.autoSizeColumn(i);
//    }
//try{
//    OutputStream os = new FileOutputStream(excelFilePath);
//    workbook.write(os);
//
//    // Closing stream
//    workbook.close();
//    
//        } catch ( IOException ex) {
//            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public void importEmployee(File file) throws FileNotFoundException, IOException, ParseException{
//        FileInputStream in = new FileInputStream(file);
//            XSSFWorkbook workbook = new XSSFWorkbook(in);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row;
//            
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            for(int i = 1; i <= sheet.getLastRowNum(); i++){
//                row = sheet.getRow(i);
//                
//                String name = valueOf(row.getCell(0)).trim();
//                String tempAge = valueOf(row.getCell(1)).trim();
//                int age = Integer.valueOf(tempAge);
//                String gender = valueOf(row.getCell(2)).trim();
//                String address = valueOf(row.getCell(3)).trim();
//                String phone = valueOf(row.getCell(4)).trim();
//                String startDateString = valueOf(row.getCell(5)).trim();
//                Date startDate = new Date(formatter.parse(startDateString).getTime());
//                
//                nhanvien nv = new nhanvien();
//                nv.setName(name);
//                nv.setAge(age);
//                nv.setGender(gender);
//                nv.setAddress(address);
//                nv.setPhone(phone);
//                nv.setStart_day(startDate);
//                
//                nhanvien temp = getEmployeeByPhone(nv.getPhone());
//                if(temp != null){
//                    nv.setId_NV(temp.getId_NV());
//                    set(nv);
//                }else {
//                    nvBUS.add(nv);
//                    add(nv);
//                }
//                
//            }
//    }
}
