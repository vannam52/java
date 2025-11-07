package duan;

import java.time.LocalDate;
import java.util.Scanner;

abstract class conNguoi {
    private String HoTen;
    private String ngaySinh;
    private String GioiTinh;
    private String SDT;

    public conNguoi() {
    }

    public conNguoi(String HoTen, String ngaySinh, String GioiTinh, String SDT) {
        this.HoTen = HoTen;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ho ten: ");
        HoTen = sc.nextLine();
        System.out.print("Nhap ngay sinh(yyyy-MM-dd): ");
        ngaySinh = sc.nextLine();
        System.out.print("Giới tính: ");
        GioiTinh = sc.nextLine();
        System.out.println("Nhap SDT: ");
        SDT = sc.nextLine();
    }

    public void Xuat() {
        System.out.printf("║ Ho ten: %-76s ║%n", HoTen);
        System.out.printf("║ Nam sinh: %-74s ║%n", ngaySinh);
        System.out.printf("║ Gioi tinh: %-73s ║%n", GioiTinh);
        System.out.printf("║ SDT: %-79s ║%n", SDT);
    }

    @Override
    public String toString() {
        return HoTen + "," + ngaySinh + "," + GioiTinh + "," + SDT;
    }

    public int tinhTuoi() {
        if (ngaySinh == null || ngaySinh.length() < 10)
            return -1;
        int namSinh = Integer.parseInt(ngaySinh.substring(0, 4));
        int namHT = LocalDate.now().getYear();
        return namHT - namSinh;
    }
}