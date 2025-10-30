package duan;

import java.util.Scanner;

public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private String donViTinh;
    private double giaBan;
    private String ngayHetHan;

    public Thuoc(){}

    public Thuoc(Thuoc other){
        this.maThuoc = other.maThuoc;
        this.tenThuoc = other.tenThuoc;
        this.donViTinh = other.donViTinh;
        this.giaBan = other.giaBan;
        this.ngayHetHan = other.ngayHetHan;
    }

    public Thuoc(String maThuoc, String tenThuoc, String donViTinh, double giaBan, String ngayHetHan){
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donViTinh = donViTinh;
        this.giaBan = giaBan;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaThuoc(){
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc){
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc(){
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc){
        this.tenThuoc = tenThuoc;
    }

    public String getDonViTinh(){
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh){
        this.donViTinh = donViTinh;
    }

    public double getGiaBan(){
        return giaBan;
    }

    public void setGiaBan(double giaBan){
        this.giaBan = giaBan;
    }

    public String getNgayHetHan(){
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan){
        this.ngayHetHan = ngayHetHan;
    }

    public void nhapThongTinThuoc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma thuoc: ");
        maThuoc = sc.nextLine();
        System.out.println("Nhap ten Thuoc: ");
        tenThuoc = sc.nextLine();
        System.out.println("Nhap don vi tinh: ");
        donViTinh = sc.nextLine();
        System.out.println("Nhap gia ban: ");
        giaBan = sc.nextInt();
        System.out.println("Nhap ngay het han: ");
        ngayHetHan = sc.nextLine();
    }

    public void suaThongTinThuoc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma thuoc can sua: ");
        String maCanSua = sc.nextLine();
        if(maCanSua.equals(maThuoc)){
        System.out.println("Nhap ma thuoc: ");
        maThuoc = sc.nextLine();
        System.out.println("Nhap ten Thuoc: ");
        tenThuoc = sc.nextLine();
        System.out.println("Nhap don vi tinh: ");
        donViTinh = sc.nextLine();
        System.out.println("Nhap gia ban: ");
        giaBan = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhap ngay het han: ");
        ngayHetHan = sc.nextLine();
        }else{
            System.out.println("Khong tim thay thuoc co ma "+maCanSua);
        }
    }
    public void hienThiThongTinThuoc() {
    System.out.println("==================================================");
    System.out.println("          CHI TIẾT THÔNG TIN THUỐC                ");
    System.out.println("==================================================");
    
    System.out.printf("%-25s: %s\n", "Mã Thuốc", maThuoc);
    System.out.printf("%-25s: %s\n", "Tên Thuốc", tenThuoc);
    System.out.printf("%-25s: %s\n", "Đơn Vị Tính", donViTinh);
    System.out.printf("%-25s: %s\n", "Ngày Hết Hạn", ngayHetHan); 
    
    System.out.println("--------------------------------------------------");
}
}
