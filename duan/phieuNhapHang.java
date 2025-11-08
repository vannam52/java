package duan;

import java.util.Scanner;

public class phieuNhapHang {
    private String maPNH;
    private String maNV;
    private String maNCC;
    private String ngayNhap; // dd/MM/yyyy (chuoi)
    private double tongTien;

    public phieuNhapHang() {}

    public phieuNhapHang(String maPNH, String maNV, String maNCC, String ngayNhap, double tongTien) {
        this.maPNH = maPNH;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public phieuNhapHang(phieuNhapHang other) {
        if (other == null) return;
        this.maPNH = other.maPNH;
        this.maNV = other.maNV;
        this.maNCC = other.maNCC;
        this.ngayNhap = other.ngayNhap;
        this.tongTien = other.tongTien;
    }

    // ... (Getter/Setter giữ nguyên) ...
    public String getMaPNH() { return maPNH; }
    public void setMaPNH(String maPNH) { this.maPNH = maPNH; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }
    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    // input / output
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin phieu nhap hang:");
        System.out.print("Nhap ma phieu nhap: "); 
        this.maPNH = sc.nextLine();
        System.out.print("Nhap ma nhan vien: "); 
        this.maNV = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: "); 
        this.maNCC = sc.nextLine();
        System.out.print("Nhap ngay nhap (dd/MM/yyyy): "); 
        this.ngayNhap = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        try { 
            this.tongTien = Double.parseDouble(sc.nextLine()); 
        } catch (Exception e) { 
            this.tongTien = 0.0; 
        }
        sc.close(); // Thêm vào để giống hệt file donGiaoHang.java
    }

    public void hienThiPhieuNhapHang() {
        System.out.println("Ma phieu nhap: " + maPNH);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Tong tien: " + tongTien + " VND");
    }

    public void Xuat() {
        // Định nghĩa độ rộng cột cho printf
        final int W_LABEL = 18; // Độ rộng của cột "Thuoc tinh"
        final int W_VALUE = 66; // Độ rộng của cột "Gia tri"

        // Định nghĩa các chuỗi định dạng
        final String LINE_TOP = "╔" + repeatChar('═', W_LABEL + 2) + "╤" + repeatChar('═', W_VALUE + 2) + "╗";
        final String LINE_MID = "╠" + repeatChar('═', W_LABEL + 2) + "╬" + repeatChar('═', W_VALUE + 2) + "╣";
        final String LINE_BOT = "╚" + repeatChar('═', W_LABEL + 2) + "╧" + repeatChar('═', W_VALUE + 2) + "╝";
        
        // Dùng %-Ns để căn lề trái
        final String ROW_FMT = "║ %-" + W_LABEL + "s ║ %-" + W_VALUE + "s ║%n";
        
        System.out.println(LINE_TOP);
        System.out.printf("║ %-" + (W_LABEL + W_VALUE + 5) + "s ║%n", center("CHI TIET PHIEU NHAP HANG", W_LABEL + W_VALUE + 5));
        System.out.println(LINE_MID);
        
        System.out.printf(ROW_FMT, "Ma phieu nhap:", truncate(maPNH, W_VALUE));
        System.out.printf(ROW_FMT, "Ma nhan vien:", truncate(maNV, W_VALUE));
        System.out.printf(ROW_FMT, "Ma nha cung cap:", truncate(maNCC, W_VALUE));
        System.out.printf(ROW_FMT, "Ngay nhap:", truncate(ngayNhap, W_VALUE));
        
        // Định dạng tiền tệ
        String tien = String.format("%,.0f VND", tongTien);
        System.out.printf(ROW_FMT, "Tong tien:", tien);
        
        System.out.println(LINE_BOT);
    }
    
    private String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    private String center(String text, int width) {
        if (text == null || text.length() >= width) {
            return truncate(text, width);
        }
        int padding = width - text.length();
        int leftPad = padding / 2;
        int rightPad = padding - leftPad;
        return repeatChar(' ', leftPad) + text + repeatChar(' ', rightPad);
    }

    private String truncate(String text, int width) {
        if (text == null) return "";
        if (text.length() <= width) {
            return text;
        }
        if (width < 3) {
            return text.substring(0, width);
        }
        return text.substring(0, width - 3) + "...";
    }

    @Override
    public String toString() {
        return maPNH + "," + maNV + "," + maNCC + "," + ngayNhap + "," + tongTien;
    }
}