package duan;

import java.util.Scanner;
public class nhanVien {
    private String maNV;
    private String tenNV;
    private String gt;
    private String sdt;
    private String diaChi;
    private int tuoi;
    private double luong;

    public nhanVien() {
    }

    public nhanVien(nhanVien other){
        this.maNV = other.maNV;
        this.tenNV = other.tenNV;
        this.gt = other.gt;
        this.sdt = other.sdt;
        this.diaChi = other.diaChi;
        this.tuoi = other.tuoi;
        this.luong = other.luong;
    }

    public nhanVien(String maNV, String tenNV, String gt, String sdt, String diaChi, int tuoi, double luong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gt = gt;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
        this.luong = luong;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public String getGt() {
        return gt;
    }
    public void setGt(String gt) {
        this.gt = gt;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void NhapThongTinNV(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tenNV = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gt = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = sc.nextInt();
        System.out.print("Nhap luong: ");
        luong = sc.nextDouble();
    }
    public void hienThiThongTinNV() {
    System.out.println("=====================================");
    System.out.println("       THÔNG TIN NHÂN VIÊN           ");
    System.out.println("=====================================");
    
    System.out.printf("%-20s: %s\n", "Mã nhân viên", maNV);
    System.out.printf("%-20s: %s\n", "Tên nhân viên", tenNV);
    System.out.printf("%-20s: %s\n", "Giới tính", gt);
    System.out.printf("%-20s: %s\n", "Số điện thoại", sdt);
    System.out.printf("%-20s: %s\n", "Địa chỉ", diaChi);
    System.out.printf("%-20s: %s\n", "Tuổi", tuoi);
    System.out.printf("%-20s: %,.0f VNĐ\n", "Lương", luong); 
    System.out.println("-------------------------------------");
}

    public void suaThongTinNV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can sua: ");
        String maCanSua = sc.nextLine();
        if(maCanSua.equals(maNV)){
            System.out.println("Nhap ten nhan vien: ");
            tenNV = sc.nextLine();
            System.out.println("Nhap dia chi ten nhan vien: ");
            diaChi = sc.nextLine();
            System.out.println("Nhap gioi tinh nhan vien: ");
            gt = sc.nextLine();
            System.out.println("Nhap so dien thoai nhan vien: ");
            sdt = sc.nextLine();
            System.out.println("Nhap tuoi nhan vien: ");
            tuoi = sc.nextInt();
            System.out.println("Nhap luong: ");
            luong = sc.nextInt();
        }else{
            System.out.println("Khong tim thay nhan vien can sua voi ma"+maCanSua);
        }
    }

    public void tinhLuong(double tien){
        this.luong += tien;
    }   
}
