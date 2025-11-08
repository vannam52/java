package duan;

import java.util.Scanner;

public class donGiaoHang {
    private String maDH;
    private String maHD;
    private String ngayGiao;
    private String diaChi;
    private int soLuong;
    private String trangThai;
    private double tongTien;
    
    public donGiaoHang() {}

    public donGiaoHang(donGiaoHang other) {
        this.maDH = other.maDH;
        this.maHD = other.maHD;
        this.ngayGiao = other.ngayGiao;
        this.diaChi = other.diaChi;
        this.soLuong = other.soLuong;
        this.trangThai = other.trangThai;
        this.tongTien = other.tongTien;
    }

    public donGiaoHang(String maDH, String maHD, String ngayGiao, String diaChi, int soLuong, String trangThai, double tongTien) {
        this.maDH = maDH;
        this.maHD = maHD;
        this.ngayGiao = ngayGiao;
        this.diaChi = diaChi;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public String getMaDH() { 
        return maDH; 
    }

    public void setMaDH(String maDH) { 
        this.maDH = maDH; 
    }

    public String getMaHD() { 
        return maHD; 
    }

    public void setMaHD(String maHD) { 
        this.maHD = maHD; 
    }

    public String getNgayGiao() { 
        return ngayGiao; 
    }

    public void setNgayGiao(String ngayGiao) { 
        this.ngayGiao = ngayGiao; 
    }

    public String getDiaChi() { 
        return diaChi; 
    }

    public void setDiaChi(String diaChi) { 
        this.diaChi = diaChi; 
    }

    public int getSoLuong() { 
        return soLuong; 
    }

    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; 
    }

    public String getTrangThai() { 
        return trangThai; 
    }

    public void setTrangThai(String trangThai) { 
        this.trangThai = trangThai; 
    }

    public double getTongTien() { 
        return tongTien; 
    }
    
    public void setTongTien(double tongTien) { 
        this.tongTien = tongTien; 
    }


    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin don giao hang:");
        System.out.print("Nhap maDH: ");
        this.maDH = sc.nextLine();
        System.out.print("Nhap maHD: ");
        this.maHD = sc.nextLine();
        System.out.print("Nhap ngay giao (dd/MM/yyyy): ");
        this.ngayGiao = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap so luong: ");
        try { 
            this.soLuong = Integer.parseInt(sc.nextLine()); 
        } catch (Exception e) { 
            this.soLuong = 0; 
        }
        System.out.print("Nhap trang thai: ");
        this.trangThai = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        try { this.tongTien = Double.parseDouble(sc.nextLine()); 
        } catch (Exception e) { 
            this.tongTien = 0.0; 
        }
        sc.close();
    }

    public void hienThiDonGiaoHang() {
        // Hàm này có thể giữ lại hoặc dùng Xuat()
        System.out.println("MaDH: " + maDH);
        System.out.println("MaHD: " + maHD);
        System.out.println("Ngay giao: " + ngayGiao);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So luong: " + soLuong);
        System.out.println("Trang thai: " + trangThai);
        System.out.println("Tong tien: " + tongTien + " VND");
    }

    public void Xuat() {
        // Định nghĩa độ rộng cột cho printf
        final int W_LABEL = 18;
        final int W_VALUE = 66;

        // Định nghĩa các chuỗi định dạng
        final String LINE_TOP = "╔" + repeatChar('═', W_LABEL + 2) + "╤" + repeatChar('═', W_VALUE + 2) + "╗";
        final String LINE_MID = "╠" + repeatChar('═', W_LABEL + 2) + "╬" + repeatChar('═', W_VALUE + 2) + "╣";
        final String LINE_BOT = "╚" + repeatChar('═', W_LABEL + 2) + "╧" + repeatChar('═', W_VALUE + 2) + "╝";
        
        // Dùng %-Ns để căn lề trái
        final String ROW_FMT = "║ %-" + W_LABEL + "s ║ %-" + W_VALUE + "s ║%n";
        
        System.out.println(LINE_TOP);
        System.out.printf("║ %-" + (W_LABEL + W_VALUE + 5) + "s ║%n", center("CHI TIET DON GIAO HANG", W_LABEL + W_VALUE + 5));
        System.out.println(LINE_MID);
        
        System.out.printf(ROW_FMT, "Ma don hang:", truncate(maDH, W_VALUE));
        System.out.printf(ROW_FMT, "Ma hoa don:", truncate(maHD, W_VALUE));
        System.out.printf(ROW_FMT, "Ngay giao:", truncate(ngayGiao, W_VALUE));
        System.out.printf(ROW_FMT, "Dia chi:", truncate(diaChi, W_VALUE));
        System.out.printf(ROW_FMT, "So luong:", soLuong);
        System.out.printf(ROW_FMT, "Trang thai:", truncate(trangThai, W_VALUE));
        
        // Định dạng tiền tệ
        String tien = String.format("%,.0f VND", tongTien);
        System.out.printf(ROW_FMT, "Tong tien:", tien);
        
        System.out.println(LINE_BOT);
    }
    
    // Hàm lặp ký tự (giống trong ví dụ hoaDon)
    private String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    // Hàm căn giữa văn bản (giống trong ví dụ hoaDon)
    private String center(String text, int width) {
        if (text == null || text.length() >= width) {
            return truncate(text, width);
        }
        int padding = width - text.length();
        int leftPad = padding / 2;
        int rightPad = padding - leftPad;
        return repeatChar(' ', leftPad) + text + repeatChar(' ', rightPad);
    }

    // Hàm cắt ngắn (vẫn cần thiết)
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
        return maDH + "," + maHD + "," + ngayGiao + "," + diaChi + "," + soLuong + "," + trangThai + "," + tongTien;
    }
}