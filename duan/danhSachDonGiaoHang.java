package duan;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class danhSachDonGiaoHang implements ChucNang, IFile {
    private donGiaoHang[] dsDGH;
    private int soLuongDGH;

    public danhSachDonGiaoHang() {
        this.dsDGH = new donGiaoHang[0];
        this.soLuongDGH = 0;
    }

    public void themDonGiaoHang(donGiaoHang dgh) {
        if (timKiemTheoMa(dgh.getMaDH()) != null) {
            System.out.println("Ma don hang da ton tai");
            return;
        }
        dsDGH = Arrays.copyOf(dsDGH, soLuongDGH + 1);
        dsDGH[soLuongDGH] = dgh;
        soLuongDGH++;
        System.out.println("Them don giao hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        donGiaoHang dghMoi;
        boolean maBiTrung;

        do {
            maBiTrung = false;
            dghMoi = new donGiaoHang();

            System.out.println("--- Nhap thong tin don giao hang moi ---");
            dghMoi.nhapDonGiaoHang(); 

            if (timKiemTheoMa(dghMoi.getMaDH()) != null) {
                System.out.println("✗ Ma don hang da ton tai! Vui long nhap lai toan bo thong tin.");
                maBiTrung = true;
            } else {
                themDonGiaoHang(dghMoi);
                System.out.println("✓ Da them don giao hang thanh cong!");
            }

        } while (maBiTrung);
    }

    public void xoaDonGiaoHang(String maDH) {
        int vt = -1;
        for (int i = 0; i < soLuongDGH; i++) {
            if (dsDGH[i].getMaDH().equalsIgnoreCase(maDH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay don hang co ma " + maDH);
            return;
        }

        for (int j = vt; j < soLuongDGH - 1; j++) {
            dsDGH[j] = dsDGH[j + 1];
        }
        dsDGH = Arrays.copyOf(dsDGH, soLuongDGH - 1);
        soLuongDGH--;
        System.out.println("✓ Xoa don hang co ma " + maDH + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongDGH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma don hang can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaDonGiaoHang(maCanXoa);
    }

    @Override
    public void Sua() {
        if (soLuongDGH == 0) {
            System.out.println("✗ Danh sach don hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma don hang (MaDH) can sua: ");
        String ma = sc.nextLine().trim();

        donGiaoHang dghCanSua = timKiemTheoMa(ma);

        if (dghCanSua == null) {
            System.out.println("✗ Khong tim thay don hang co ma: " + ma);
            return;
        }

        System.out.println("Tim thay don hang. Chon thong tin can sua:");
        boolean tiepTuc = true;
        while(tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUA THONG TIN DON GIAO HANG: " + String.format("%-23s", ma) + "║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma hoa don                                                ║");
            System.out.println("║ 2. Sua ngay giao                                                 ║");
            System.out.println("║ 3. Sua dia chi                                                   ║");
            System.out.println("║ 4. Sua so luong                                                  ║");
            System.out.println("║ 5. Sua trang thai                                                ║");
            System.out.println("║ 6. Sua tong tien                                                 ║");
            System.out.println("║ 7. Sua lai tat ca (tru maDH)                                     ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-7): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ma hoa don moi: ");
                    dghCanSua.setMaHD(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhap ngay giao moi: ");
                    dghCanSua.setNgayGiao(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Nhap dia chi moi: ");
                    dghCanSua.setDiaChi(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Nhap so luong moi: ");
                    dghCanSua.setSoLuong(Integer.parseInt(sc.nextLine()));
                    break;
                case "5":
                    System.out.print("Nhap trang thai moi: ");
                    dghCanSua.setTrangThai(sc.nextLine());
                    break;
                case "6":
                    System.out.print("Nhap tong tien moi: ");
                    dghCanSua.setTongTien(Double.parseDouble(sc.nextLine()));
                    break;
                case "7":
                    System.out.println("\n>> Nhap lai tat ca thong tin (tru MaDH):");
                    System.out.println("Nhap ma hoa don: ");
                    dghCanSua.setMaHD(sc.nextLine());
                    System.out.println("Nhap ngay giao (dd/MM/yyyy): ");
                    dghCanSua.setNgayGiao(sc.nextLine());
                    System.out.println("Nhap dia chi: ");
                    dghCanSua.setDiaChi(sc.nextLine());
                    System.out.println("Nhap so luong: ");
                    dghCanSua.setSoLuong(sc.nextInt());
                    sc.nextLine(); 
                    System.out.println("Nhap trang thai: ");
                    dghCanSua.setTrangThai(sc.nextLine());
                    System.out.println("Nhap tong tien: ");
                    dghCanSua.setTongTien(sc.nextDouble());
                    sc.nextLine(); 
                    System.out.println("Da cap nhat tat ca thong tin.");
                    break;
                case "0":
                    System.out.println(">> Hoan thanh sua thong tin don giao hang!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    public donGiaoHang timKiemTheoMa(String maDH) {
        for (int i = 0; i < soLuongDGH; i++) {
            if (dsDGH[i].getMaDH().equalsIgnoreCase(maDH)) {
                return dsDGH[i];
            }
        }
        return null;
    }

    public donGiaoHang[] timKiemTheoMaHD(String maHD) {
        donGiaoHang[] ketQua = new donGiaoHang[soLuongDGH];
        int dem = 0;
        for (int i = 0; i < soLuongDGH; i++) {
            if (dsDGH[i].getMaHD().toLowerCase().contains(maHD.toLowerCase())) {
                ketQua[dem] = dsDGH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongDGH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM DON GIAO HANG ---");
        System.out.println("1. Tim theo ma don hang");
        System.out.println("2. Tim theo ma hoa don");
        System.out.print("Chon loai tim kiem: ");

        int chon = 0;
        try {
            chon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✗ Lua chon khong hop le!");
            return;
        }

        switch (chon) {
            case 1:
                System.out.print("Nhap ma don hang can tim: ");
                String maDH = sc.nextLine();
                donGiaoHang dgh = timKiemTheoMa(maDH);
                if (dgh != null) {
                    System.out.println("✓ Tim thay don hang:");
                    hienThiBang(new donGiaoHang[] { dgh }, 1);
                } else {
                    System.out.println("✗ Khong tim thay don hang co ma: " + maDH);
                }
                break;
            case 2:
                System.out.print("Nhap ma hoa don can tim (gan dung): ");
                String maHD = sc.nextLine();
                donGiaoHang[] ketQuaHD = timKiemTheoMaHD(maHD);
                if (ketQuaHD.length > 0) {
                    System.out.println("✓ Tim thay " + ketQuaHD.length + " don hang:");
                    hienThiBang(ketQuaHD, ketQuaHD.length);
                } else {
                    System.out.println("✗ Khong tim thay don hang co ma hoa don: " + maHD);
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
    }

    public void thongKe() {
        if (soLuongDGH == 0) {
            System.out.println("✗ Danh sach don hang rong");
            return;
        }

        double tongTien = 0;
        double maxThanhTien = dsDGH[0].getTongTien();
        double minThanhTien = dsDGH[0].getTongTien();
        donGiaoHang dghMax = dsDGH[0];
        donGiaoHang dghMin = dsDGH[0];

        for (int i = 0; i < soLuongDGH; i++) {
            tongTien += dsDGH[i].getTongTien();
            if (dsDGH[i].getTongTien() > maxThanhTien) {
                maxThanhTien = dsDGH[i].getTongTien();
                dghMax = dsDGH[i];
            }
            if (dsDGH[i].getTongTien() < minThanhTien) {
                minThanhTien = dsDGH[i].getTongTien();
                dghMin = dsDGH[i];
            }
        }

        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                  BANG THONG KE DON GIAO HANG                                                  ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║%n",
                "Tong so DH",
                "Tong tien",
                "Tien TB",
                "DH cao nhat",
                "DH thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                soLuongDGH,
                tongTien,
                (soLuongDGH > 0 ? tongTien / soLuongDGH : 0),
                dghMax.getMaDH(),
                dghMin.getMaDH(),
                maxThanhTien - minThanhTien);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    public void hienThiBang(donGiaoHang[] arr, int size) {
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════════════════════════"; 
        final String HEADER_TITLE = "                                       DANH SACH DON GIAO HANG                                            "; 
        
        System.out.println("╔" + LINE + "╗");
        System.out.println("║" + HEADER_TITLE + "║");
        System.out.println("╠══════════╦══════════╦════════════╦════════════════════════════╦══════════╦═══════════════╦═══════════════╣");
        System.out.println("║  Ma DH   ║  Ma HD   ║ Ngay Giao  ║          Dia Chi           ║ So Luong ║  Trang Thai   ║   Tong Tien   ║");
        System.out.println("╠══════════╬══════════╬════════════╬════════════════════════════╬══════════╬═══════════════╬═══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.printf("║ %-8s ║ %-8s ║ %-10s ║ %-25s ║ %-8d ║ %-13s ║ %13.2f ║%n",
                        arr[i].getMaDH(),
                        arr[i].getMaHD(),
                        arr[i].getNgayGiao(),
                        arr[i].getDiaChi(),
                        arr[i].getSoLuong(),
                        arr[i].getTrangThai(),
                        arr[i].getTongTien());
            }
        }
        System.out.println("╚══════════╩══════════╩════════════╩════════════════════════════╩══════════╩═══════════════╩═══════════════╝");
        System.out.println("Tong so: " + size + " don giao hang");
    }

    public void XuatDS() {
        if (soLuongDGH == 0) {
            System.out.println("✗ Danh sach don hang rong");
        } else {
            hienThiBang(dsDGH, soLuongDGH);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong don hang muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println("✗ So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Loi: Vui long nhap so hop le.");
            return;
        }
        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("\n--- Nhap don hang thu " + (soLuongDGH + 1) + " ---");
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
                    "║                            THONG BAO FILE KHONG TON TAI                              ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-79s", tenFile) + " ║");
            System.out.println(
                    "║ → Bat dau voi danh sach RONG. Hay them don giao hang moi!                             ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsDGH = new donGiaoHang[0];
            this.soLuongDGH = 0;
            return;
        }

        System.out.println("→ Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co don giao hang de doc.");
                this.dsDGH = new donGiaoHang[0];
                this.soLuongDGH = 0;
                return;
            }

            this.dsDGH = new donGiaoHang[count];
            this.soLuongDGH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongDGH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                
                if (parts.length >= 7) { 
                    try {
                        double tongTien = Double.parseDouble(parts[parts.length - 1].trim());
                        String trangThai = parts[parts.length - 2].trim();
                        int soLuong = Integer.parseInt(parts[parts.length - 3].trim());

                        String maDH = parts[0].trim();
                        String maHD = parts[1].trim();
                        String ngayGiao = parts[2].trim();

                        StringBuilder diaChiBuilder = new StringBuilder();
                        for (int i = 3; i < parts.length - 3; i++) {
                            diaChiBuilder.append(parts[i].trim());
                            if (i < parts.length - 4) {
                                diaChiBuilder.append(","); 
                            }
                        }
                        String diaChi = diaChiBuilder.toString();

                        dsDGH[soLuongDGH] = new donGiaoHang(maDH, maHD, ngayGiao, diaChi, soLuong, trangThai, tongTien);
                        soLuongDGH++;

                    } catch (NumberFormatException e) {
                        System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can it nhat 7)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongDGH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongDGH + "/" + count + " don giao hang");
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongDGH);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsDGH = new donGiaoHang[0];
            this.soLuongDGH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongDGH);

            for (int i = 0; i < soLuongDGH; i++) {
                donGiaoHang dgh = dsDGH[i];
                pw.printf("%s,%s,%s,%s,%d,%s,%.2f%n", 
                        dgh.getMaDH(),
                        dgh.getMaHD(),
                        dgh.getNgayGiao(),
                        dgh.getDiaChi(),
                        dgh.getSoLuong(),
                        dgh.getTrangThai(),
                        dgh.getTongTien());
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongDGH);
            System.out.printf("║ Vao file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    public donGiaoHang[] getDsDGH() {
        return Arrays.copyOf(dsDGH, soLuongDGH);
    }

    public int getSoLuongDGH() {
        return soLuongDGH;
    }
}