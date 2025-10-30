package duan;

import java.util.Scanner;

public class danhSachThuoc {
    private Thuoc[] dsThuoc;
    private int soLuongThuoc;
    private final int MAX_SIZE = 100;

    public danhSachThuoc() {
        this.dsThuoc = new Thuoc[MAX_SIZE];
        this.soLuongThuoc = 0;
    }

    // them thuoc theo ma
    public void themThuoc(Thuoc th) {
        if (soLuongThuoc > MAX_SIZE) {
            System.out.println("Danh sach thuoc day");
            return;
        } else {
            dsThuoc[soLuongThuoc] = new Thuoc(th);
            th.nhapThongTinThuoc();
            if (timKiemThuocTheoMa(th.getMaThuoc()) != null) {
                System.out.println("Ma thuoc da ton tai");
                return;
            }
            dsThuoc[soLuongThuoc] = new Thuoc(th);
            soLuongThuoc++;
            System.out.println("Them thuoc thanh cong co ma" + th.getMaThuoc() + " thanh cong");
        }
    }

    // Them thuoc khong tham so
    public void themThuoc() {
        if (soLuongThuoc > MAX_SIZE) {
            System.out.println("Danh sach thuoc day");
            return;
        } else {
            Thuoc thuocMoi = new Thuoc();
            thuocMoi.nhapThongTinThuoc();

            if (timKiemThuocTheoMa(thuocMoi.getMaThuoc()) != null) {
                System.out.println("Da ton tai thuoc co ma" + thuocMoi.getMaThuoc());
                return;
            }

            dsThuoc[soLuongThuoc] = thuocMoi;
            soLuongThuoc++;
            System.out.println("Them thuoc co ma " + thuocMoi.getMaThuoc() + " thanh cong");
        }
    }

    // tim kiem thuoc theo ten
    public Thuoc[] timKiemThuocTheoTen(String tenThuoc) {
        Thuoc[] kq = new Thuoc[soLuongThuoc];
        int dem = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getTenThuoc().equalsIgnoreCase(tenThuoc)) {
                dem++;
            }
        }
        Thuoc[] th1 = new Thuoc[dem];
        for (int i = 0; i < dem; i++) {
            th1[i] = kq[i];
        }
        return th1;
    }

    // tim kiem thuoc theo ma
    public Thuoc timKiemThuocTheoMa(String maThuoc) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                return dsThuoc[i];
            }
        }
        return null;
    }

    // xoa thuoc theo ma
    public void xoaThuoc(String maThuoc) {
        if(soLuongThuoc == 0){
            System.out.println("Danh sach thuoc rong");
            return;
        }
        int vt = -1;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }
        if(vt == -1){
            System.out.println("Khong tim thay thuoc co ma"+maThuoc);
            return;
        }

        for(int j = vt; j < soLuongThuoc - 1; j++){
            dsThuoc[j] = dsThuoc[j + 1];
        }
        dsThuoc[soLuongThuoc] = null;
        soLuongThuoc--;
        System.out.println("xoa thanh cong thuoc co ma"+maThuoc);
    }

    //xoa thuoc khong tham so
    public void xoaThuoc(){
        if(soLuongThuoc == 0){
            System.out.println("Danh sach thuoc rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String maCanXoa = sc.nextLine();

        int vt = -1;
        for(int i = 0; i < soLuongThuoc; i++){
            if(dsThuoc[i].getMaThuoc().equalsIgnoreCase(maCanXoa)){
                vt = i;
                break;
            }
        }
        if(vt == -1){
            System.out.println("Khong tim thay thuoc can xoa");
            return;
        }
        for(int j = vt; j < soLuongThuoc - 1; j++){
            dsThuoc[j] = dsThuoc[j + 1];
        }
        dsThuoc[soLuongThuoc] = null;
        soLuongThuoc--;
        System.out.println("Da xoa thuoc co ma"+maCanXoa);
    }

    //sua thong tin thuoc theo ma thuoc
    public void suaThongTinThuoc(String maThuoc){
        if(soLuongThuoc == 0){
            System.out.println("Danh sach thuoc rong");
            return;
        }
        Thuoc th = timKiemThuocTheoMa(maThuoc);
        if(th != null){
            th.suaThongTinThuoc();
        }else{
            System.out.println("Khong tim thay thuoc can sua");
        }
    }

    //sua thong tin thuoc khong tham so
    public void suaThongTinThuoc(){
        if(soLuongThuoc == 0){
            System.out.println("Danh sach thuoc rong");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma thuoc can sua: ");
        String maCanSua = sc.nextLine();

        Thuoc th = timKiemThuocTheoMa(maCanSua);

        if(th != null){
            th.suaThongTinThuoc();
            System.out.println("Da sua thanh cong");
        }else{
            System.out.println("Khong tim thay thuoc can sua");
        }
    }

    //thong ke
    public void thongKeThuoc(){
        if(soLuongThuoc == 0){
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("Tổng số lượng thuốc hiện có: " + soLuongThuoc);
    }
}
