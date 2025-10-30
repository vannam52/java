package duan;

import java.util.Date;
import java.util.Scanner;

public class danhSachKhachHang {
    private khachHang[] dsKH;
    private int soLuongKH;
    private int tongKH;
    private Date ngayTaoDanhSach;

    public danhSachKhachHang() {
        this.dsKH = new khachHang[100];
        this.soLuongKH = 0;
        this.tongKH = 0;
        this.ngayTaoDanhSach = new Date();
    }

    public danhSachKhachHang(danhSachKhachHang other) {
        this.dsKH = other.dsKH;
        this.soLuongKH = other.soLuongKH;
        this.tongKH = other.tongKH;
        this.ngayTaoDanhSach = other.ngayTaoDanhSach;
    }

    // them khach hang theo ma
    public void themKhachHang(khachHang kh) {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        if (soLuongKH >= dsKH.length) {
            System.out.println("Danh sach khach hang day");
            return;
        } else {
            // kh.NhapThongTinKH();
            if (timKiemTheoMa(kh.getMaKH()) != null) {
                System.out.println("Ma khach hang da ton tai");
                return;
            }
            dsKH[soLuongKH] = new khachHang(kh);
            soLuongKH++;
            tongKH++;
            System.out.println("Them khach hang thanh cong");
        }
    }

    // them khach hang khong tham so
    public void themKhachHang() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        khachHang kh = new khachHang();
        kh.HienThiThongTinKH();

        if (timKiemTheoMa(kh.getMaKH()) != null) {
            System.out.println("da ton tai khach hang co ma" + kh.getMaKH());
            return;
        }
        dsKH[soLuongKH] = kh;
        soLuongKH++;
        System.out.println("Them khach hang thanh cong");
    }

    // xoa khach hang theo ma
    public void xoaKhachHang(String maKH) {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        int vt = -1;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(maKH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim khach hang co ma" + maKH);
            return;
        }
        for (int j = vt; j < soLuongKH - 1; j++) {
            dsKH[j] = dsKH[j + 1];
        }
        dsKH[soLuongKH] = null;
        soLuongKH--;
        System.out.println("Khong tim thay ma khach hang can xoa");
    }

    // xoa khach hang khong tham so
    public void xoaKhachHang() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String maCanXoa = sc.nextLine();

        int vt = -1;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(maCanXoa)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay ma can xoa");
            return;
        }
        for (int j = vt; j < soLuongKH - 1; j++) {
            dsKH[j] = dsKH[j + 1];
        }
        dsKH[soLuongKH] = null;
        soLuongKH--;
        System.out.println("Xoa thanh cong khach hang co ma " + maCanXoa);
    }

    // tim kiem khach hang theo ma
    public khachHang timKiemTheoMa(String maKH) {

        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equals(maKH)) {
                return dsKH[i];
            }
        }
        return null;
    }

    // tim kiem khach hang theo ten
    public khachHang[] timKiemTheoTen(String tenKH) {
        khachHang[] kq = new khachHang[soLuongKH];
        int cnt = 0;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getTenKH().equalsIgnoreCase(tenKH)) {
                kq[cnt++] = dsKH[i];
            }
        }
        khachHang[] result = new khachHang[cnt];
        for (int i = 0; i < cnt; i++) {
            result[i] = kq[i];
        }
        return result;
    }

    // tim kiem khong tham so
    public void timTiemKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoac ten khach hang: ");
        String input = sc.nextLine();

        khachHang kh = timKiemTheoMa(input);

        if (kh != null) {
            System.out.println("Tim thay khach hang");
            kh.HienThiThongTinKH();
        } else {
            // theo ten
            khachHang[] ten = timKiemTheoTen(input);

            if (ten.length > 0) {
                System.out.println("Tim thay " + ten.length);
                for (khachHang k : ten) {
                    k.HienThiThongTinKH();
                }
            } else {
                System.out.println("Khong tim thay ten khach hang");
            }
        }
    }

    // sua thong tin khach hang theo ma
    public void suaThongTinKH(String maKH) {
        khachHang kh = timKiemTheoMa(maKH);
        if (kh != null) {
            kh.suaThongTinKH();
        } else {
            System.out.println("Khong tim thay ma khach hang can sua" + maKH);
        }
    }

    // sua khach hang khong tham so
    public void suaThongTinKH() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang can sua: ");
        String maCanSua = sc.nextLine();

        suaThongTinKH(maCanSua);
    }

    // cap nhat diem tich luy cho khach hang
    public void capNhapDiemTichLuy(String maKH, int diem) {
        khachHang kh = timKiemTheoMa(maKH);
        if (kh != null) {
            kh.capNhapDiemTichLuy(diem);
        } else {
            System.out.println("Khong tim thay ma khach hang can cap nhat diem tich luy: " + maKH);
        }
    }

    // sap xep danh sach khach hang theo ten
    public void sapXepTheoTen() {
        for (int i = 0; i < soLuongKH - 1; i++) {
            for (int j = i + 1; j < soLuongKH; j++) {
                if (dsKH[i].getTenKH().compareTo(dsKH[j].getTenKH()) > 0) {
                    khachHang temp = dsKH[i];
                    dsKH[i] = dsKH[j];
                    dsKH[j] = temp;
                }
            }
        }
        System.out.println("Sap xep thanh cong");
    }

    // sap xep theo diem tich luy
    public void sapXepTheoDiemTichLuy() {
        for (int i = 0; i < soLuongKH - 1; i++) {
            for (int j = i + 1; j < soLuongKH; j++) {
                if (dsKH[i].getDiemTichLuy() < dsKH[j].getDiemTichLuy()) {
                    khachHang tmp = dsKH[i];
                    dsKH[i] = dsKH[j];
                    dsKH[j] = tmp;
                }
            }
        }
        System.out.println("Sap xep thanh cong");
    }

    // hien thi danh sach khach hang
    public void hienThiDanhSachKH() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
            return;
        }
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < soLuongKH; i++) {
            System.out.println("Khach hang thu " + (i + 1) + ": ");
            dsKH[i].HienThiThongTinKH();
        }
    }

    // thong ke
    public void thongKeKH() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
            return;
        }
        int tongDiem = 0;
        int khachCoDiemCaoNhat = 0;

        for (int i = 0; i < soLuongKH; i++) {
            tongDiem += dsKH[i].getDiemTichLuy();
            if (dsKH[i].getDiemTichLuy() > dsKH[khachCoDiemCaoNhat].getDiemTichLuy()) {
                khachCoDiemCaoNhat = i;
            }
        }
        double diemTB = (double) tongDiem / soLuongKH;
        System.out.println("Thong ke khach hang: ");
        System.out.println("Tong so khach hang: " + soLuongKH);
        System.out.println("Diem tich luy trung binh: " + diemTB);
        System.out.println("Khach hang co diem tich luy cao nhat: " + dsKH[khachCoDiemCaoNhat].getTenKH()
                + " voi diem: " + dsKH[khachCoDiemCaoNhat].getDiemTichLuy());
    }

    public int getSoLuongKH() {
        return soLuongKH;
    }

    public khachHang[] getDanhSach() {
        khachHang[] result = new khachHang[soLuongKH];
        for (int i = 0; i < soLuongKH; i++) {
            result[i] = dsKH[i];
        }
        return result;
    }

    // hien thi tat ca

}