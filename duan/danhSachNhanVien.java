package duan;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class danhSachNhanVien implements ChucNang, IFile {
    private nhanVien[] dsNV = new nhanVien[0];
    private int soLuongNV;

    public danhSachNhanVien() {
        this.dsNV = new nhanVien[0];
        this.soLuongNV = 0;
    }

    public danhSachNhanVien(int soLuongNV, nhanVien[] dsNV) {
        this.dsNV = Arrays.copyOf(dsNV, soLuongNV);
        this.soLuongNV = soLuongNV;
    }

    // THEM
    public void themNhanVien(nhanVien nv) {
        if (timKiemTheoMa(nv.getMaNV()) != null) {
            System.out.println("Da ton tai nhan vien co ma " + nv.getMaNV());
            return;
        }
        dsNV = Arrays.copyOf(dsNV, soLuongNV + 1);
        dsNV[soLuongNV] = nv;
        soLuongNV++;
        System.out.println("Them nhan vien thanh cong!");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        nhanVien nvMoi = new nhanVien();
        boolean maBiTrung;

        do {
            maBiTrung = false;
            nvMoi.Nhap();
            if (timKiemTheoMa(nvMoi.getMaNV()) != null) {
                System.out.println("Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);
        themNhanVien(nvMoi);
    }

    // XOA
    public void xoaNhanVien(String maNV) {
        int vt = -1;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay nhan vien co ma " + maNV);
            return;
        }
        for (int j = vt; j < soLuongNV - 1; j++) {
            dsNV[j] = dsNV[j + 1];
        }
        dsNV[soLuongNV - 1] = null;
        soLuongNV--;
        System.out.println("Xoa nhan vien co ma " + maNV + " thanh cong!");
    }

    @Override
    public void Xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaNhanVien(maCanXoa);
    }

    // SUA
    @Override
    public void Sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma nhan vien!");
            return;
        }

        nhanVien nv = dsNV[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUA THONG TIN NHAN VIEN: " + String.format("%-26s", ma) + "  ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten nhan vien                                             ║");
            System.out.println("║ 2. Sua ngay sinh                                                 ║");
            System.out.println("║ 3. Sua gioi tinh                                                 ║");
            System.out.println("║ 4. Sua so dien thoai                                             ║");
            System.out.println("║ 5. Sua dia chi                                                   ║");
            System.out.println("║ 6. Sua luong co ban                                              ║");
            System.out.println("║ 7. Sua thuong                                                    ║");
            System.out.println("║ 8. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-8): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ten nhan vien moi: ");
                    nv.setHoTen(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap ngay sinh moi (yyyy-MM-dd): ");
                    nv.setNgaySinh(sc.nextLine());
                    break;

                case "3":
                    System.out.print("Nhap gioi tinh moi: ");
                    nv.setGioiTinh(sc.nextLine());
                    break;

                case "4":
                    System.out.print("Nhap so dien thoai moi: ");
                    nv.setSDT(sc.nextLine());
                    break;

                case "5":
                    System.out.print("Nhap dia chi moi: ");
                    nv.setDiaChi(sc.nextLine());
                    break;

                case "6":
                    System.out.print("Nhap luong co ban moi: ");
                    double luongMoi = Double.parseDouble(sc.nextLine());
                    if (luongMoi < 0) {
                        System.out.println(">> Luong không thể am!");
                    } else {
                        nv.setLuongCoBan(luongMoi);
                    }
                    break;

                case "7":
                    System.out.print("Nhap thuong moi: ");
                    double thuongMoi = Double.parseDouble(sc.nextLine());
                    if (thuongMoi < 0) {
                        System.out.println(">> Thuong không thể am!");
                    } else {
                        nv.setThuong(thuongMoi);
                    }
                    break;

                case "8":
                    System.out.println("\n>> Nhap lai tat ca thong tin:");
                    nv.Nhap();
                    break;

                case "0":
                    System.out.println(">> Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;

                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    // TIM KIEM
    public nhanVien timKiemTheoMa(String maNV) {
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getMaNV().equals(maNV)) {
                return dsNV[i];
            }
        }
        return null;
    }

    public nhanVien[] timKiemTheoTen(String tenNV) {
        nhanVien[] ketQua = new nhanVien[soLuongNV];
        int dem = 0;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getHoTen().toLowerCase().contains(tenNV.toLowerCase())) {
                ketQua[dem] = dsNV[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongNV == 0) {
            System.out.println(" Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ten nhan vien can tim: ");
        String tuKhoa = sc.nextLine();

        nhanVien nv = timKiemTheoMa(tuKhoa);
        if (nv != null) {
            System.out.println(" Tim thay nhan vien theo ma:");
            nv.Xuat();
        } else {
            nhanVien[] ketQua = timKiemTheoTen(tuKhoa);
            if (ketQua.length > 0) {
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println(" Khong tim thay nhan vien co ma/ten: " + tuKhoa);
            }
        }
    }

    public double tinhTongLuong() {
        double tongLuong = 0;
        for (int i = 0; i < soLuongNV; i++) {
            tongLuong += dsNV[i].getLuong();
        }
        return tongLuong;
    }

    public void thongKeChung() {
        if (soLuongNV == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        double tongLuong = tinhTongLuong();
        double tinhLuongTB = tongLuong / soLuongNV;

        nhanVien nvMax = dsNV[0];
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getLuong() > nvMax.getLuong()) {
                nvMax = dsNV[i];
            }
        }

        int nam = 0, nu = 0;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getGioiTinh().equalsIgnoreCase("Nam")) {
                nam++;
            } else {
                nu++;
            }
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                              THONG KE CHUNG NHAN VIEN                                ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Tong so nhan vien:           %-55d ║%n", soLuongNV);
        System.out.printf("║ So nhan vien nam:            %-55d ║%n", nam);
        System.out.printf("║ So nhan vien nu:             %-55d ║%n", nu);
        System.out.printf("║ Tong luong:                  %-51.0f VND ║%n", tongLuong);
        System.out.printf("║ Luong trung binh:            %-51.0f VND ║%n", tinhLuongTB);
        System.out.printf("║ Nhan vien luong cao nhat:    %-40s (%.0f VND) ║%n",
                nvMax.getHoTen(), nvMax.getLuong());
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void thongKeTheoGioiTinh() {
        if (soLuongNV == 0) {
            System.out.println("Danh sach rong");
            return;
        }

        // Nhân viên Nam
        nhanVien[] dsNam = new nhanVien[soLuongNV];
        int demNam = 0;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getGioiTinh().equalsIgnoreCase("Nam")) {
                dsNam[demNam] = dsNV[i];
                demNam++;
            }
        }

        // Nhân viên Nữ
        nhanVien[] dsNu = new nhanVien[soLuongNV];
        int demNu = 0;
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getGioiTinh().equalsIgnoreCase("Nu")) {
                dsNu[demNu] = dsNV[i];
                demNu++;
            }
        }

        System.out.println("\n>>> DANH SACH NHAN VIEN NAM:");
        if (demNam > 0) {
            hienThiBang(dsNam, demNam);
        } else {
            System.out.println("Khong co nhan vien Nam");
        }

        System.out.println("\n>>> DANH SACH NHAN VIEN NU:");
        if (demNu > 0) {
            hienThiBang(dsNu, demNu);
        } else {
            System.out.println("Khong co nhan vien Nu");
        }
    }

    public void menuThongKe() {
        Scanner sc = new Scanner(System.in);
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              MENU THONG KE NHAN VIEN                             ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Thong ke chung                                                ║");
            System.out.println("║ 2. Thong ke theo gioi tinh                                       ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-2): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    thongKeChung();
                    break;
                case "2":
                    thongKeTheoGioiTinh();
                    break;
                case "0":
                    System.out.println(" Thoat menu thong ke!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        }
    }

    public void hienThiBang(nhanVien[] arr, int size) {
        final String LINE = "═════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out.println(
                "║                              DANH SACH NHAN VIEN                                    ║");
        System.out.println(
                "╠════════╦══════════════════════╦═══════╦═══════════╦══════════════╦══════════════════╣");
        System.out.println(
                "║  Ma NV ║      Ho va Ten       ║ Tuoi  ║ Gioi tinh ║      SDT     ║   Luong (VND)    ║");
        System.out.println(
                "╠════════╬══════════════════════╬═══════╬═══════════╬══════════════╬══════════════════╣");

        for (int i = 0; i < size; i++) {
            System.out.printf("║ %-6s ║ %-20s ║ %-5s ║ %-9s ║ %-12s ║ %,16.0f ║%n",
                    arr[i].getMaNV(),
                    arr[i].getHoTen(),
                    arr[i].tinhTuoi(),
                    arr[i].getGioiTinh(),
                    arr[i].getSDT(),
                    arr[i].getLuong());
        }

        System.out.println(
                "╚════════╩══════════════════════╩═══════╩═══════════╩══════════════╩══════════════════╝");
        System.out.println("Tong so: " + size + " nhan vien");
    }

    public void XuatDS() {
        if (soLuongNV == 0) {
            System.out.println(" Danh sach nhan vien rong");
        } else {
            hienThiBang(dsNV, soLuongNV);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println(" So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < soLuongThem; i++) {
            System.out.println(
                    "\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║              NHAP NHAN VIEN THU " + (soLuongNV + 1)
                    + "                                                    ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            Them();
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongNV);

            for (int i = 0; i < soLuongNV; i++) {
                nhanVien nv = dsNV[i];
                pw.printf(Locale.US, "%s,%s,%s,%s,%s,%s,%.2f,%.2f%n",
                        nv.getMaNV(),
                        nv.getHoTen(),
                        nv.getNgaySinh(),
                        nv.getGioiTinh(),
                        nv.getSDT(),
                        nv.getDiaChi(),
                        nv.getLuongCoBan(),
                        nv.getThuong());
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println(
                            "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongNV);
            System.out.printf("║ Vao file: %-75s║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsNV = new nhanVien[0];
            this.soLuongNV = 0;
            return;
        }

        System.out.println("Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co nhan vien de doc.");
                this.dsNV = new nhanVien[0];
                this.soLuongNV = 0;
                return;
            }

            this.dsNV = new nhanVien[count];
            this.soLuongNV = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongNV < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 8 || parts.length == 10) {
                    try {
                        String maNV = parts[0].trim();
                        String hoTen = parts[1].trim();
                        String ngaySinh = parts[2].trim();
                        String gioiTinh = parts[3].trim();
                        String sdt = parts[4].trim();
                        String diaChi = parts[5].trim();

                        double luongCoBan, thuong;

                        if (parts.length == 10) {
                            luongCoBan = Double.parseDouble(parts[6].trim() + "." + parts[7].trim());
                            thuong = Double.parseDouble(parts[8].trim() + "." + parts[9].trim());
                        } else {
                            luongCoBan = Double.parseDouble(parts[6].trim());
                            thuong = Double.parseDouble(parts[7].trim());
                        }

                        dsNV[soLuongNV] = new nhanVien(maNV, hoTen, ngaySinh, gioiTinh, sdt, diaChi, luongCoBan,
                                thuong);
                        soLuongNV++;

                    } catch (NumberFormatException e) {
                        System.err.println("  Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println("Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 8 hoac 10)");
                    System.err.println("     Noi dung: " + line);
                }
                lineNumber++;
            }

            if (soLuongNV < count) {
                System.out.println("Chi doc duoc " + soLuongNV + "/" + count + " nhan vien");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println(
                            "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongNV);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsNV = new nhanVien[0];
            this.soLuongNV = 0;
        }
    }

    public int getSoLuongNV() {
        return soLuongNV;
    }

    public nhanVien[] getDsNV() {
        return dsNV;
    }
}