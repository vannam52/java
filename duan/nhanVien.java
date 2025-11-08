package duan;

import java.util.Scanner;

public class nhanVien extends conNguoi {
    private String maNV;
    private String diaChi;
    private double luongCoBan;
    private double thuong;

    public nhanVien() {
        super();
    }

    public nhanVien(String maNV, String HoTen, String ngaySinh, String GioiTinh, String SDT,
            String diaChi, double luongCoBan, double thuong) {
        super(HoTen, ngaySinh, GioiTinh, SDT);
        this.maNV = maNV;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
    }

    public nhanVien(nhanVien other) {
        this.maNV = other.maNV;
        this.diaChi = other.diaChi;
        this.luongCoBan = other.luongCoBan;
        this.thuong = other.thuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public double getLuong() {
        return this.luongCoBan + this.thuong;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin nhan vien:");
        System.out.println("Nhap maNV: ");
        this.maNV = sc.nextLine();
        super.Nhap();

        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();

        System.out.println("Nhap luong co ban: ");
        this.luongCoBan = sc.nextDouble();

        System.out.println("Nhap luong thuong: ");
        this.thuong = sc.nextDouble();
    }

    @Override
    public void Xuat() {
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════";

        System.out.println("╔" + LINE + "╗");
        System.out.println("║                                 NHAN VIEN                                            ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma NV: %-77s ║%n", maNV);
        System.out.println("╠" + LINE + "╣");
        System.out.println("║                             THONG TIN CA NHAN                                        ║");
        System.out.println("╠" + LINE + "╣");

        super.Xuat();
        System.out.printf("║ Dia chi: %-75s ║%n", diaChi);
        System.out.printf("║ Luong co ban: %-66.0f     ║%n", luongCoBan);
        System.out.printf("║ Thuong: %-72.0f     ║%n", thuong);
        System.out.printf("║ Tong luong: %-68.0f     ║%n", getLuong());
        System.out.println("╚" + LINE + "╝");
    }

    public void tinhLuong(double tien) {
        this.thuong += tien;
    }
}