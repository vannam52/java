package duan;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class danhSachKhuyenMai implements ChucNang, IFile {
    private khuyenMai[] dsKM = new khuyenMai[0];
    private int soLuongKM;

    public danhSachKhuyenMai() {
        this.dsKM = new khuyenMai[0];
        this.soLuongKM = 0;
    }

    // THEM
    public void themKhuyenMai(khuyenMai km) {
        if (timKiemTheoMa(km.getMaKM()) != null) {
            System.out.println("Ma khuyen mai da ton tai");
            return;
        }
        dsKM = Arrays.copyOf(dsKM, soLuongKM + 1);
        dsKM[soLuongKM] = km;
        soLuongKM++;
        System.out.println("Them khuyen mai thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        khuyenMai kmMoi;
        boolean maBiTrung;

        do {
            maBiTrung = false;
            kmMoi = new khuyenMai();

            System.out.println("--- Nhap thong tin khuyen mai moi ---");
            kmMoi.Nhap();
            if (timKiemTheoMa(kmMoi.getMaKM()) != null) {
                System.out.println("Ma khuyen mai da ton tai! Vui long nhap lai toan bo thong tin.");
                maBiTrung = true;
            } else {
                themKhuyenMai(kmMoi);
                System.out.println("Da them khuyen mai thanh cong!");
            }

        } while (maBiTrung);
    }

    // SUA
    @Override
    public void Sua() {
        if (soLuongKM == 0) {
            System.out.println("Danh sach khuyen mai rong!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khuyen mai can sua: ");
        String ma = sc.nextLine().trim();
        int viTri = -1;
        for (int i = 0; i < soLuongKM; i++) {
            if (dsKM[i].getMaKM().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma khuyen mai!");
            return;
        }
        khuyenMai km = dsKM[viTri];
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUA THONG TIN KHUYEN MAI: " + String.format("%-24s", ma) + "  ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten khuyen mai                                            ║");
            System.out.println("║ 2. Sua phan tram giam gia                                        ║");
            System.out.println("║ 3. Sua ngay bat dau                                              ║");
            System.out.println("║ 4. Sua ngay ket thuc                                             ║");
            System.out.println("║ 5. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-5): ");
            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ten khuyen mai moi: ");
                    km.setTenKM(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhap phan tram giam gia moi: ");
                    try {
                        double phanTram = Double.parseDouble(sc.nextLine().trim());
                        km.setPhanTramGiamGia(phanTram);
                    } catch (NumberFormatException e) {
                        System.out.println("Phan tram giam gia khong hop le!");
                    }
                    break;
                case "3":
                    System.out.print("Nhap ngay bat dau moi: ");
                    km.setNgayBD(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Nhap ngay ket thuc moi: ");
                    km.setNgayKT(sc.nextLine());
                    break;
                case "5":
                    System.out.println("\n Nhap lai tat ca thong tin:");
                    km.Nhap();
                    break;
                case "0":
                    System.out.println("Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // XOA
    public void xoaKhuyenMai(String maKM) {
        int vt = -1;
        for (int i = 0; i < soLuongKM; i++) {
            if (dsKM[i].getMaKM().equalsIgnoreCase(maKM)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay khuyen mai co ma " + maKM);
            return;
        }

        for (int j = vt; j < soLuongKM - 1; j++) {
            dsKM[j] = dsKM[j + 1];
        }
        dsKM = Arrays.copyOf(dsKM, soLuongKM - 1);
        soLuongKM--;
        System.out.println("Xoa khuyen mai co ma " + maKM + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongKM == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khuyen mai can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaKhuyenMai(maCanXoa);
    }

    // TIM KIEM
    public khuyenMai timKiemTheoMa(String maKM) {
        for (int i = 0; i < soLuongKM; i++) {
            if (dsKM[i].getMaKM().equals(maKM)) {
                return dsKM[i];
            }
        }
        return null;
    }

    public khuyenMai[] timKiemTheoNgay(String ngay) {
        khuyenMai[] ketQua = new khuyenMai[soLuongKM];
        int dem = 0;
        for (int i = 0; i < soLuongKM; i++) {
            if (dsKM[i].getNgayBD().contains(ngay) || dsKM[i].getNgayKT().contains(ngay)) {
                ketQua[dem] = dsKM[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongKM == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ngay khuyen mai can tim: ");
        String tuKhoa = sc.nextLine();

        khuyenMai km = timKiemTheoMa(tuKhoa);
        if (km != null) {
            System.out.println("Tim thay khuyen mai theo ma:");
            km.Xuat();
        } else {
            khuyenMai[] ketQua = timKiemTheoNgay(tuKhoa);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " khuyen mai theo ngay:");
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay khuyen mai co ma/ngay: " + tuKhoa);
            }
        }
    }

    // THONG KE
    public void thongKe() {
        if (soLuongKM == 0) {
            System.out.println("Danh sach khuyen mai rong");
            return;
        }

        double maxPhanTram = dsKM[0].getPhanTramGiamGia();
        khuyenMai kmMax = dsKM[0];

        for (int i = 1; i < soLuongKM; i++) {
            if (dsKM[i].getPhanTramGiamGia() > maxPhanTram) {
                maxPhanTram = dsKM[i].getPhanTramGiamGia();
                kmMax = dsKM[i];
            }
        }

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 BANG THONG KE DANH SACH KHUYEN MAI                              ║");
        System.out.println("╠════════════════╦══════════════════╦═════════════════════════════════════════════╣");
        System.out.println("║  Tong so KM    ║  % Giam Gia Max  ║             KM Co % Cao Nhat                ║");
        System.out.println("╠════════════════╬══════════════════╬═════════════════════════════════════════════╣");
        System.out.printf("║      %-10d║       %6.2f%%    ║ %-43s ║%n",
                soLuongKM,
                maxPhanTram,
                kmMax.getMaKM() + " - " + kmMax.getTenKM());
        System.out.println("╚════════════════╩══════════════════╩═════════════════════════════════════════════╝");
    }

    public void hienThiBang(khuyenMai[] arr, int size) {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DANH SACH KHUYEN MAI                                     ║");
        System.out.println("╠════════════╦══════════════════════╦═════════════════╦════════════════╦═══════════╣");
        System.out.println("║   Ma KM    ║      Ten KM          ║   % Giam Gia    ║  Ngay Bat Dau  ║ Ngay KT   ║");
        System.out.println("╠════════════╬══════════════════════╬═════════════════╬════════════════╬═══════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.printf("║ %-10s ║ %-20s ║ %14.2f%% ║ %-14s ║ %-10s║%n",
                        arr[i].getMaKM(),
                        arr[i].getTenKM(),
                        arr[i].getPhanTramGiamGia(),
                        arr[i].getNgayBD(),
                        arr[i].getNgayKT());
            }
        }

        System.out.println("╚════════════╩══════════════════════╩═════════════════╩════════════════╩═══════════╝");
    }

    public void XuatDS() {
        if (soLuongKM == 0) {
            System.out.println("Danh sach khuyen mai rong");
        } else {
            hienThiBang(dsKM, soLuongKM);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khuyen mai muon them: ");
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
            System.out.println("\n--- Nhap khuyen mai thu " + (soLuongKM + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            THONG BAO FILE KHONG TON TAI                               ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-80s", tenFile) + " ║");
            System.out.println(
                    "║ → Bat dau voi danh sach RONG. Hay them khuyen mai moi!                                ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsKM = new khuyenMai[0];
            this.soLuongKM = 0;
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
                System.out.println("File khong co khuyen mai de doc.");
                this.dsKM = new khuyenMai[0];
                this.soLuongKM = 0;
                return;
            }

            this.dsKM = new khuyenMai[count];
            this.soLuongKM = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongKM < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String maKM = parts[0].trim();
                        String tenKM = parts[1].trim();
                        double phanTramGiamGia = Double.parseDouble(parts[2].trim());
                        String ngayBD = parts[3].trim();
                        String ngayKT = parts[4].trim();

                        dsKM[soLuongKM] = new khuyenMai(maKM, tenKM, phanTramGiamGia, ngayBD, ngayKT);
                        soLuongKM++;

                    } catch (NumberFormatException e) {
                        System.err.println(" Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 5)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongKM < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongKM + "/" + count + " khuyen mai");
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongKM);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsKM = new khuyenMai[0];
            this.soLuongKM = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongKM);

            for (int i = 0; i < soLuongKM; i++) {
                khuyenMai km = dsKM[i];
                pw.printf("%s,%s,%.2f,%s,%s%n",
                        km.getMaKM(),
                        km.getTenKM(),
                        km.getPhanTramGiamGia(),
                        km.getNgayBD(),
                        km.getNgayKT());
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongKM);
            System.out.printf("║ Vao file: %-74s  ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Getter cho danh sách
    public khuyenMai[] getDsKM() {
        return Arrays.copyOf(dsKM, soLuongKM);
    }
}