package BTVN;

import java.util.Arrays;
import java.util.Scanner;

public class danhSachSV {
    private int n;
    private sinhVien[] dssv = new sinhVien[0];

    public danhSachSV() {
    }

    public danhSachSV(int n, sinhVien[] dssv) {
        this.n = n;
        this.dssv = Arrays.copyOf(dssv, n);
    }

    private boolean kiemTraMSSV(String mssv) {
        for (int i = 0; i < dssv.length; i++) {
            sinhVien sv = dssv[i];
            if (sv != null && sv.getMSSV() != null && sv.getMSSV().equals(mssv)) {
                return false;
            }
        }
        return true;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so sinh vien: ");
        n = sc.nextInt();
        sc.nextLine();

        dssv = new sinhVien[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sinh vien thu " + (i + 1));
            System.out.println("Chon loai sinh vien (1: Sinh vien chinh quy, 2: Sinh vien lien thong): ");
            int choice = sc.nextInt();
            sc.nextLine();

            sinhVien sv;
            if (choice == 1) {
                sv = new sinhVienChinhQuy();
            } else if (choice == 2) {
                sv = new sinhVienLienThong();
            } else {
                System.out.println("Lua chon khong hop le. Mac dinh la sinh vien chinh quy.");
                sv = new sinhVienChinhQuy();
            }

            nhapThongTinChung(sv);

            if (sv instanceof sinhVienChinhQuy) {
                nhapSinhVienChinhQuy((sinhVienChinhQuy) sv);
            } else if (sv instanceof sinhVienLienThong) {
                nhapSinhVienLienThong((sinhVienLienThong) sv);
            }

            dssv[i] = sv;
        }
    }

    private void nhapThongTinChung(sinhVien sv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho cua sinh vien: ");
        sv.setHo(sc.nextLine());

        System.out.println("Nhap ten cua sinh vien: ");
        sv.setTen(sc.nextLine());

        String mssv;
        do {
            System.out.println("Nhap MSSV cua sinh vien: ");
            mssv = sc.nextLine();
            if (!kiemTraMSSV(mssv)) {
                System.out.println("MSSV da ton tai! Vui long nhap MSSV khac.");
            }
        } while (!kiemTraMSSV(mssv));
        sv.setMSSV(mssv);

        System.out.println("Nhap ngay sinh sinh vien: ");
        sv.setNS(sc.nextLine());

        System.out.println("Nhap gioi tinh sinh vien: ");
        sv.setGt(sc.nextLine());
    }

    private void nhapSinhVienChinhQuy(sinhVienChinhQuy sv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem ren luyen: ");
        sv.setDiemRenLuyen(sc.nextInt());
        sc.nextLine();
    }

    private void nhapSinhVienLienThong(sinhVienLienThong sv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nam tot nghiep cao dang: ");
        sv.setNamTotNghiepCD(sc.nextLine());

        System.out.println("Nhap nganh tot nghiep: ");
        sv.setNganhTotNghiep(sc.nextLine());
    }

    public void Xuat() {
        System.out.println("DANH SACH SINH VIEN ");
        for (int i = 0; i < dssv.length; i++) {
            System.out.println("\nSinh vien thu " + (i + 1) + ":");
            dssv[i].Xuat();
        }
    }

    public void timKiemTheoDRL() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem ren luyen toi thieu can tim: ");
        int diemToiThieu = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < dssv.length; i++) {
            if (dssv[i] instanceof sinhVienChinhQuy) {
                sinhVienChinhQuy svcq = (sinhVienChinhQuy) dssv[i];
                if (svcq.getDiemRenLuyen() >= diemToiThieu) {
                    System.out.println("Sinh vien thu " + (i + 1) + ":");
                    svcq.Xuat();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Khong co sinh vien chinh quy nao co diem ren luyen >= " + diemToiThieu);
        }
    }

    public sinhVienChinhQuy[] timDRL(int drl) {
        sinhVienChinhQuy[] kq = new sinhVienChinhQuy[0];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (dssv[i] instanceof sinhVienChinhQuy) {
                sinhVienChinhQuy cq = (sinhVienChinhQuy) dssv[i];
                if (cq.getDiemRenLuyen() == drl) {
                    kq = Arrays.copyOf(kq, j + 1);
                    kq[j] = cq;
                    j++;
                    cq.Xuat();
                }
            }
        }
        return kq;
    }

    public sinhVien[] getDssv() {
        return dssv;
    }

    public sinhVien[] TimKiemHo(String ho) {
        sinhVien[] kq = new sinhVien[0];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (dssv[i].getHo().contains(ho)) {
                kq = Arrays.copyOf(kq, j + 1);
                kq[j] = new sinhVien(dssv[i]);
                j++;
                dssv[i].Xuat();
            }
        }
        return kq;
    }

    public void ThemSV() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon loai sinh vien can them (1: Sinh vien chinh quy, 2: Sinh vien lien thong): ");
        int choice = sc.nextInt();
        sc.nextLine();

        sinhVien sv;
        if (choice == 1) {
            sv = new sinhVienChinhQuy();
        } else if (choice == 2) {
            sv = new sinhVienLienThong();
        } else {
            System.out.println("Lua chon khong hop le. Mac dinh la sinh vien chinh quy.");
            sv = new sinhVienChinhQuy();
        }

        nhapThongTinChung(sv);

        if (sv instanceof sinhVienChinhQuy) {
            nhapSinhVienChinhQuy((sinhVienChinhQuy) sv);
        } else if (sv instanceof sinhVienLienThong) {
            nhapSinhVienLienThong((sinhVienLienThong) sv);
        }

        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = sv;
        n++;
    }

    public void ThemSV(sinhVien sv) {
        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = sv;
        n++;
        System.out.println("Them sinh vien thanh cong!");
    }

    public sinhVien TimKiem(String ma) {
        int vt = -1;
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMSSV().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay sinh vien co ma so " + ma);
            return null;
        }
        return dssv[vt];
    }

    public int[] thongKeGioiTinh(){
        int tkgt[] = new int[2];
        int nam = 0, nu = 0;
        for(int i = 0; i < n; i++){
            if(dssv[i].getGt().equalsIgnoreCase("Nam")){
                nam++;
            } else if(dssv[i].getGt().equalsIgnoreCase("Nu")){
                nu++;
            }
        }
        tkgt[0] = nam;
        tkgt[1] = nu;
        System.out.println("Thong ke gioi tinh: Nam = " + nam + ", Nu = " + nu);
        return tkgt;
    }

    public int[] thongKeLoaiSV(){
        int tksv[] = new int[2];
        int chinhQuy = 0, lienThong = 0;
        for(int i = 0; i < n; i++){
            if(dssv[i] instanceof sinhVienChinhQuy){
                chinhQuy++;
            } else if(dssv[i] instanceof sinhVienLienThong){
                lienThong++;
            }
        }
        tksv[0] = chinhQuy;
        tksv[1] = lienThong;
        System.out.println("Thong ke loai sinh vien: Chinh quy = " + chinhQuy + ", Lien thong = " + lienThong);
        return tksv;
    }

    public int[] thongKeTuoi(){
        int namHienTai = java.time.Year.now().getValue();
        int tuoi[] = new int[3];
        for(int i = 0; i < n; i++){
            String[] parts = dssv[i].getNS().split("-");
            int namSinh = Integer.parseInt(parts[2]);
            int age = namHienTai - namSinh;
            if(age < 20){
                tuoi[0]++;
            } else if(age <= 25){
                tuoi[1]++;
            } else {
                tuoi[2]++;
            }
        }
        System.out.println("Thong ke tuoi sinh vien: <20 = " + tuoi[0] + ", 20-25 = " + tuoi[1] + ", >25 = " + tuoi[2]);
        return tuoi;
    }
}