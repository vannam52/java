package duan;

import java.util.Scanner;

public class quanLyBanThuocYTe {
    private String maThuoc;
    private String ten;
    private String NSX;
    private String HSD;
    private int donGia;
    private danhSachNhanVien dsNhanVien;
    private danhSachKhachHang dsKhachHang;
    private danhSachThuoc dsThuoc;
    private danhSachKhuyenMai dsKhuyenMai;
    private Scanner sc;
    

    public quanLyBanThuocYTe() {
    }

    public quanLyBanThuocYTe(quanLyBanThuocYTe other){
        this.maThuoc = other.maThuoc;
        this.ten = other.ten;
        this.NSX = other.NSX;
        this.HSD = other.HSD;
        this.donGia = other.donGia;
    }

    public quanLyBanThuocYTe(String maThuoc, String ten, String NSX, int donGia) {
        this.maThuoc = maThuoc;
        this.ten = ten;
        this.NSX = NSX;
        this.donGia = donGia;
    }

    public String getMaThuoc() {
        return maThuoc;
    }
    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getNSX() {
        return NSX;
    }
    public void setNSX(String nSX) {
        this.NSX = nSX;
    }
    public int getDonGia() {
        return donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    public String getHSD() {
        return HSD;
    }
    public void setHSD(String hSD) {
        this.HSD = hSD;
    }
public void nhapThongTinThuoc(){
    System.out.print("Nhap ma thuoc: ");
    maThuoc = sc.nextLine();
    System.out.print("Nhap ten thuoc: ");
    ten = sc.nextLine();
    System.out.print("Nhap nha san xuat: ");
    NSX = sc.nextLine();
    System.out.print("Nhap han su dung (HSD): ");
    HSD = sc.nextLine();
    System.out.print("Nhap don gia: ");
    donGia = sc.nextInt();
}

public void hienThiThongTinThuoc(){
    System.out.println("Ma thuoc: " + maThuoc);
    System.out.println("Ten thuoc: " + ten);
    System.out.println("Nha san xuat: " + NSX);
    System.out.println("Han su dung (HSD): " + HSD);
    System.out.println("Don gia: " + donGia);
}

public void suaThongTinThuoc(){
    System.out.print("Nhap ma thuoc can sua: ");
    String maThuocCanSua = sc.nextLine();
    if(maThuocCanSua.equals(maThuoc)){
        System.out.print("Nhap ten thuoc moi: ");
        ten = sc.nextLine();
        System.out.print("Nhap nha san xuat moi: ");
        NSX = sc.nextLine();
        System.out.print("Nhap han su dung moi (HSD) moi: ");
        HSD = sc.nextLine();
        System.out.print("Nhap don gia moi: ");
        donGia = sc.nextInt();
        System.out.println("Sua thanh cong");
    } else {
        System.out.println("Không tìm thấy mã thuốc cần sửa.");
    }
}

    public void xoaThuoc(){
    System.out.print("Nhap ma thuoc can xoa: ");
    String maThuocCanXoa = sc.nextLine();
    if(maThuocCanXoa.equals(maThuoc)){
        maThuoc = "";
        ten = "";
        NSX = "";
        HSD = "";
        donGia = 0;
        System.out.println("Xoa thanh cong");
    } else {
        System.out.println("Không tìm thấy mã thuốc cần xóa.");
    }
}

    public void timKiemThuoc(){
    System.out.print("Nhap ma thuoc can tim: ");
    String maThuocCanTim = sc.nextLine();
    if(maThuocCanTim.equals(maThuoc)){
        hienThiThongTinThuoc();
    } else {
        System.out.println("Không tìm thấy mã thuốc cần tìm.");
    }
}
}
