package duan;

import java.util.Scanner;

abstract class conNguoi {
    private String HoTen;
    private int tuoi;
    private String GioiTinh;
    private String SDT;

    // constructor
    public conNguoi() {
    }

    public conNguoi(String HoTen, int tuoi, String GioiTinh, String SDT) {
        this.HoTen = HoTen;
        this.tuoi = tuoi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public int getTuoi() {
        return tuoi;
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

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
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
        this.HoTen = sc.nextLine();
        boolean tuoiHopLe = false;
        int tuoiNhap = 0;
        do {
            System.out.print("Tuoi (từ 6 den 100): ");
            try {
                tuoiNhap = Integer.parseInt(sc.nextLine());
                if (tuoiNhap >= 6 && tuoiNhap <= 100) {
                    this.tuoi = tuoiNhap;
                    tuoiHopLe = true;
                } else {
                    System.out.println(">> LTuoi phai trong khoang tu 6 - 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println(">> Vui long nhap mot con so.");
            }
        } while (!tuoiHopLe);
        System.out.print("Giới tính: ");
        this.GioiTinh = sc.nextLine();
        boolean sdtHopLe = false;
        do {
            System.out.print("So dien thoai(10 so): ");
            this.SDT = sc.nextLine();
            if (this.SDT.matches("\\d{10}")) {
                sdtHopLe = true;
            } else {
                System.out.println(">> SDT phai 10 so vui long nhap lai.");
            }
        } while (!sdtHopLe);
    }

    public void Xuat() {
        System.out.printf("║ Ho ten: %-76s ║%n", HoTen);
        System.out.printf("║ Nam sinh: %-78d ║%n", tuoi);
        System.out.printf("║ Gioi tinh: %-73s ║%n", GioiTinh);
        System.out.printf("║ SDT: %-79s ║%n", SDT);
    }
}