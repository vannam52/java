package BTVN;

import java.util.Scanner;

public class sinhVien {
    private String ho;
    private String ten;
    private String MSSV;
    private String NS;
    private String gt;

    public sinhVien() {
    }

    public sinhVien(String ho, String ten, String mSSV, String nS, String gt) {
        this.ho = ho;
        this.ten = ten;
        this.MSSV = mSSV;
        this.NS = nS;
        this.gt = gt;
    }

    public sinhVien(sinhVien other){
        this.ho = other.ho;
        this.ten = other.ten;
        this.MSSV = other.MSSV;
        this.NS = other.NS;
        this.gt = other.gt;
    }

    public String getHo() { 
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String mSSV) {
        MSSV = mSSV;
    }

    public String getNS() {
        return NS;
    }

    public void setNS(String nS) {
        NS = nS;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho cua sinh vien: ");
        this.ho = sc.nextLine();
        System.out.println("Nhap ten cua sinh vien: ");
        this.ten = sc.nextLine();
        System.out.println("Nhap MSSV cua sinh vien: ");
        this.MSSV = sc.nextLine();
        System.out.println("Nhap ngay sinh sinh vien: ");
        this.NS = sc.nextLine();
        System.out.println("Nhap gioi tinh sinh vien: ");
        this.gt = sc.nextLine();
    }

    public void Xuat() {
        System.out.printf("\n%-15s %-15s %-15s %-15s %-10s", ho, ten, MSSV, NS, gt);
    }

}