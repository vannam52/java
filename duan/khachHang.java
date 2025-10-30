package duan;

import java.util.Scanner;
public class khachHang {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String sdt;
    private int diemTichLuy;
    
    public khachHang() {
    }

    public khachHang(khachHang other){
        this.maKH = other.maKH;
        this.tenKH = other.tenKH;
        this.diaChi = other.diaChi;
        this.sdt = other.sdt;
        this.diemTichLuy = other.diemTichLuy;
    }

    public khachHang(String maKH, String tenKH, String diaChi, String sdt, int diemTichLuy) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public int getDiemTichLuy() {
        return diemTichLuy;
    }
    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
    public void NhapThongTinKH(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma khach hang la: ");
        maKH = sc.nextLine();
        System.out.println("Ten khach hang la: ");
        tenKH = sc.nextLine();
        System.out.println("Dia chi khach hang la: ");
        diaChi = sc.nextLine();
        System.out.println("So dien thoai khach hang la: ");
        sdt = sc.nextLine();
        System.out.println("Diem tich luy cua khach hang la: ");
        diemTichLuy = sc.nextInt();
    }
    public void HienThiThongTinKH(){
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ten khach hang: " + tenKH);
        System.out.println("Dia chi khach hang: " + diaChi);
        System.out.println("So dien thoai khach hang: " + sdt);
        System.out.println("Diem tich luy cua khach hang: " + diemTichLuy);
    }

    //sua thong tin theo ma
    public void suaThongTinKH(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can sua: ");
        String maKHCanSua = sc.nextLine();

        if(maKHCanSua.equals(maKH)){
            System.out.print("Nhap ten khach hang moi: ");
            tenKH = sc.nextLine();
            System.out.print("Nhap dia chi khach hang moi: ");
            diaChi = sc.nextLine();
            System.out.print("Nhap so dien thoai khach hang moi: ");
            sdt = sc.nextLine();
            System.out.print("Nhap diem tich luy moi: ");
            diemTichLuy = sc.nextInt();
            sc.nextLine();
            System.out.println("Sua thanh cong");
        } else {
            System.out.println("Khong tim thay ma khach hang can sua.");
        }
    }

    public void capNhapDiemTichLuy(int diem) {
        this.diemTichLuy += diem;
    }
}
