//sua lai ham tinh tuoi
package duan;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class danhSachKhachHang implements ChucNang, IFile {
    private khachHang[] dsKH = new khachHang[0];
    private int soLuongKH;

    public danhSachKhachHang() {
        this.dsKH = new khachHang[0];
        this.soLuongKH = 0;
    }

    // them
    public void themKhachHang(khachHang kh) {
        if (timKiemTheoMa(kh.getMaKH()) != null) {
            System.out.println("Ma khach hang da ton tai");
            return;
        }
        dsKH = Arrays.copyOf(dsKH, soLuongKH + 1);
        dsKH[soLuongKH] = kh;
        soLuongKH++;
        System.out.println("Them khach hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        khachHang khMoi = new khachHang();
        boolean maBiTrung;
        do {
            maBiTrung = false;
            khMoi.Nhap();
            if (timKiemTheoMa(khMoi.getMaKH()) != null) {
                System.out.println("Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);
        themKhachHang(khMoi);
    }

    // xoa
    public void xoaKhachHang(String maKH) {
        int vt = -1;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(maKH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay khach hang co ma " + maKH);
            return;
        }

        for (int j = vt; j < soLuongKH - 1; j++) {
            dsKH[j] = dsKH[j + 1];
        }
        dsKH = Arrays.copyOf(dsKH, soLuongKH - 1);
        soLuongKH--;
        System.out.println("Xoa khach hang co ma " + maKH + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaKhachHang(maCanXoa);
    }

    // sua
    @Override
    public void Sua() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can sua: ");
        String ma = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma khach hang!");
            return;
        }

        khachHang kh = dsKH[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUA THONG TIN KHACH HANG: " + String.format("%-24s", ma) + "  ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten khach hang                                            ║");
            System.out.println("║ 2. Sua ngay sinh                                                 ║");
            System.out.println("║ 3. Sua gioi tinh                                                 ║");
            System.out.println("║ 4. Sua so dien thoai                                             ║");
            System.out.println("║ 5. Sua dia chi                                                   ║");
            System.out.println("║ 6. Sua diem tich luy                                             ║");
            System.out.println("║ 7. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-7): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ten khach hang moi: ");
                    kh.setHoTen(sc.nextLine());
                    break;

                case "2":
                    System.out.print("Nhap ngay sinh moi (dd/MM/yyyy): ");
                    kh.setNgaySinh(sc.nextLine());
                    break;

                case "3":
                    System.out.print("Nhap gioi tinh moi: ");
                    kh.setGioiTinh(sc.nextLine());
                    break;

                case "4":
                    System.out.print("Nhap so dien thoai moi: ");
                    kh.setSDT(sc.nextLine());
                    break;

                case "5":
                    System.out.print("Nhap dia chi moi: ");
                    kh.setDiaChi(sc.nextLine());
                    break;

                case "6":
                    System.out.print("Nhap so diem tich luy moi: ");
                    int diemMoi = Integer.parseInt(sc.nextLine());
                    if (diemMoi < 0) {
                        System.out.println(">> Diem tich luy khong the la so am!");
                    } else {
                        kh.setDiemTichLuy(diemMoi);
                    }
                    break;

                case "7":
                    System.out.println("\n>> Nhap lai tat ca thong tin:");
                    kh.Nhap();
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

    // tim kiem
    public khachHang timKiemTheoMa(String maKH) {
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equals(maKH)) {
                return dsKH[i];
            }
        }
        return null;
    }

    public khachHang[] timKiemTheoTen(String tenKH) {
        khachHang[] ketQua = new khachHang[soLuongKH];
        int dem = 0;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getHoTen().toLowerCase().contains(tenKH.toLowerCase())) {
                ketQua[dem] = dsKH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ten khach hang can tim: ");
        String tuKhoa = sc.nextLine();

        khachHang kh = timKiemTheoMa(tuKhoa);
        if (kh != null) {
            System.out.println("Tim thay khach hang theo ma:");
            kh.Xuat();
        } else {
            khachHang[] ketQua = timKiemTheoTen(tuKhoa);
            if (ketQua.length > 0) {
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay khach hang co ma/ten: " + tuKhoa);
            }
        }
    }

    public void thongKeChung() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              THONG KE DANH SACH KHACH HANG                       ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        // Tổng số khách hàng
        System.out.printf("║ Tong so khach hang: %-45d║%n", soLuongKH);

        // Khách hàng có điểm tích lũy cao nhất
        khachHang khMax = dsKH[0];
        for (int i = 1; i < soLuongKH; i++) {
            if (dsKH[i].getDiemTichLuy() > khMax.getDiemTichLuy()) {
                khMax = dsKH[i];
            }
        }
        System.out.printf("║ Khach hang co diem cao nhat: %-36s║%n", khMax.getHoTen());
        System.out.printf("║ Diem tich luy: %-50d║%n", khMax.getDiemTichLuy());

        // Tổng điểm tích lũy
        int tongDiem = 0;
        for (int i = 0; i < soLuongKH; i++) {
            tongDiem += dsKH[i].getDiemTichLuy();
        }
        System.out.printf("║ Tong diem tich luy: %-45d║%n", tongDiem);
        System.out.printf("║ Trung binh diem/khach: %-42.2f║%n", (double) tongDiem / soLuongKH);

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public void menuThongKe() {
        Scanner sc = new Scanner(System.in);
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              MENU THONG KE KHACH HANG                            ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Thong ke chung                                                ║");
            System.out.println("║ 2. Thong ke theo gioi tinh                                       ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-2): ");

            String luaChon = sc.nextLine().trim();

            switch (luaChon) {
                case "1":
                    thongKeChung();
                    break;
                case "2":
                    thongKeTheoGioiTinh();
                    break;
                case "0":
                    System.out.println(">> Thoat menu thong ke!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le!");
            }
        }
    }

    public void thongKeTheoGioiTinh() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
            return;
        }

        // Khách hàng Nam
        khachHang[] dsNam = new khachHang[soLuongKH];
        int demNam = 0;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getGioiTinh().equalsIgnoreCase("Nam")) {
                dsNam[demNam] = dsKH[i];
                demNam++;
            }
        }

        // Khách hàng Nữ
        khachHang[] dsNu = new khachHang[soLuongKH];
        int demNu = 0;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getGioiTinh().equalsIgnoreCase("Nu")) {
                dsNu[demNu] = dsKH[i];
                demNu++;
            }
        }

        System.out.println("\n>>> DANH SACH KHACH HANG NAM:");
        if (demNam > 0) {
            hienThiBang(dsNam, demNam);
        } else {
            System.out.println("Khong co khach hang Nam");
        }

        System.out.println("\n>>> DANH SACH KHACH HANG NU:");
        if (demNu > 0) {
            hienThiBang(dsNu, demNu);
        } else {
            System.out.println("Khong co khach hang Nu");
        }
    }

    public void hienThiBang(khachHang[] arr, int size) {
        final String LINE = "═══════════════════════════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out.println(
                "║                                             DANH SACH KHACH HANG                                          ║");
        System.out.println(
                "╠════════════╦══════════════════════╦════════════╦═════════════════╦═══════════════════════════╦════════════╣");
        System.out.println(
                "║    Ma KH   ║      Ho va Ten       ║  Nam Sinh  ║      SDT        ║         Dia chi           ║    Diem    ║");
        System.out.println(
                "╠════════════╬══════════════════════╬════════════╬═════════════════╬═══════════════════════════╬════════════╣");

        for (int i = 0; i < size; i++) {
            System.out.printf("║ %-10s ║ %-20s ║ %-10s ║ %-15s ║ %-25s ║ %-10d ║%n",
                    arr[i].getMaKH(),
                    arr[i].getHoTen(),
                    arr[i].tinhTuoi(),
                    arr[i].getSDT(),
                    arr[i].getDiaChi(),
                    arr[i].getDiemTichLuy());
        }
        System.out.println(
                "╚════════════╩══════════════════════╩════════════╩═════════════════╩═══════════════════════════╩════════════╝");
        System.out.println("Tong so: " + size + " khach hang");
    }

    public void XuatDS() {
        if (soLuongKH == 0) {
            System.out.println("Danh sach khach hang rong");
        } else {
            hienThiBang(dsKH, soLuongKH);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println("So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("\n--- Nhap khach hang thu " + (soLuongKH + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsKH = new khachHang[0];
            this.soLuongKH = 0;
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
                System.out.println("File khong co khach hang de doc.");
                this.dsKH = new khachHang[0];
                this.soLuongKH = 0;
                return;
            }

            this.dsKH = new khachHang[count];
            this.soLuongKH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongKH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 7) {
                    try {
                        String maKH = parts[0].trim();
                        String hoTen = parts[1].trim();
                        String ngaySinh = parts[2].trim();
                        String gioiTinh = parts[3].trim();
                        String sdt = parts[4].trim();
                        String diaChi = parts[5].trim();
                        int diemTichLuy = Integer.parseInt(parts[6].trim());

                        dsKH[soLuongKH] = new khachHang(maKH, hoTen, ngaySinh, gioiTinh, sdt, diaChi, diemTichLuy);
                        soLuongKH++;

                    } catch (NumberFormatException e) {
                        System.err.println("Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 7)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongKH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongKH + "/" + count + " khach hang");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println(
                            "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongKH);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsKH = new khachHang[0];
            this.soLuongKH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongKH);

            for (int i = 0; i < soLuongKH; i++) {
                khachHang kh = dsKH[i];
                pw.printf("%s,%s,%s,%s,%s,%s,%d%n",
                        kh.getMaKH(), kh.getHoTen(), kh.getNgaySinh(),
                        kh.getGioiTinh(), kh.getSDT(), kh.getDiaChi(),
                        kh.getDiemTichLuy());
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println(
                            "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongKH);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

}