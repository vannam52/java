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

    public donGiaoHang() {
    }

    public donGiaoHang(donGiaoHang other) {
        this.maDH = other.maDH;
        this.maHD = other.maHD;
        this.ngayGiao = other.ngayGiao;
        this.diaChi = other.diaChi;
        this.soLuong = other.soLuong;
        this.trangThai = other.trangThai;
        this.tongTien = other.tongTien;
    }

    public donGiaoHang(String maDH, String maHD, String ngayGiao, String diaChi, int soLuong, String trangThai,
            double tongTien) {
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

    public void nhapDonGiaoHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma don hang: ");
        this.maDH = sc.nextLine();
        System.out.println("Nhap ma hoa don: ");
        this.maHD = sc.nextLine();
        System.out.println("Nhap ngay giao (dd/MM/yyyy): ");
        this.ngayGiao = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.println("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine(); // Tiêu thụ ký tự Enter
        System.out.println("Nhap trang thai: ");
        this.trangThai = sc.nextLine();
        System.out.println("Nhap tong tien: ");
        this.tongTien = sc.nextDouble();
        sc.nextLine(); // Tiêu thụ ký tự Enter
        System.out.println("nhap thong tin thanh cong.");
    }

    public void Xuat() {
        final String LINE = "═════════════════════════════════════════════════════════════════════════════";
        final int W = 77; // Giữ nguyên chiều rộng của mẫu

        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ------------------- THONG TIN DON GIAO HANG -----------------------------   ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma don hang: %-" + (W - 15) + "s ║%n", maDH);
        System.out.printf("║ Ma hoa don: %-" + (W - 14) + "s ║%n", maHD);
        System.out.printf("║ Ngay giao: %-" + (W - 13) + "s ║%n", ngayGiao);
        System.out.printf("║ Dia chi: %-" + (W - 11) + "s ║%n", diaChi);
        System.out.printf("║ So luong: %-" + (W - 12) + "d ║%n", soLuong);
        System.out.printf("║ Trang thai: %-" + (W - 14) + "s ║%n", trangThai);
        System.out.printf("║ Tong tien: %-" + (W - 13) + ".2f ║%n", tongTien);
        System.out.println("╚" + LINE + "╝");
    }

    @Override
    public String toString() {
        return "Mã DH: " + maDH +
                ", Mã HD: " + maHD +
                ", Ngày Giao: " + ngayGiao +
                ", Địa Chỉ: " + diaChi +
                ", Số Lượng: " + soLuong +
                ", Trạng Thái: " + trangThai +
                ", Tổng Tiền: " + tongTien;
    }
}