package duan;

import java.util.Scanner;

abstract public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private String donViTinh;
    private double giaBan;
    private int soLuong;
    private String HSD;

    // Constructors
    public Thuoc() {
    }

    public Thuoc(String maThuoc, String tenThuoc, String donViTinh, double giaBan, int soLuong, String HSD) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donViTinh = donViTinh;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.HSD = HSD;
    }

    public Thuoc(Thuoc other) {
        this.maThuoc = other.maThuoc;
        this.tenThuoc = other.tenThuoc;
        this.donViTinh = other.donViTinh;
        this.giaBan = other.giaBan;
        this.soLuong = other.soLuong;
        this.HSD = other.HSD;
    }

    // Getters and Setters
    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Nhap Thong Tin Thuoc ---");
        System.out.print("Nhap ma thuoc: ");
        this.maThuoc = sc.nextLine();
        System.out.print("Nhap ten thuoc: ");
        this.tenThuoc = sc.nextLine();
        System.out.print("Nhap don vi tinh: ");
        this.donViTinh = sc.nextLine();
        System.out.println("Nhap gia ban: ");
        this.giaBan = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap HSD (vi du: 2026-12-02): ");
        this.HSD = sc.nextLine();
    }

    public void Xuat() {
        System.out.println(
                "─────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf("| %-11s | %-22s | %-15s | %-11s | %-10s | %-10s |\n",
                "Ma Thuoc", "Ten Thuoc", "Don Vi Tinh", "Gia Ban", "So Luong", "HSD");
        System.out.println(
                "─────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf("| %-11s | %-22s | %-15s | %11.2f | %10d | %-10s |\n",
                maThuoc, tenThuoc, donViTinh, giaBan, soLuong, HSD);
        System.out.println(
                "─────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    @Override
    public String toString() {
        return maThuoc + "," + tenThuoc + "," + donViTinh + "," + giaBan + "," + HSD;
    }
}