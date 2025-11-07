package duan;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class danhSachThuoc implements ChucNang, IFile {
    private Thuoc[] dsThuoc;
    private int soLuongThuoc;

    public danhSachThuoc() {
        this.dsThuoc = new Thuoc[0];
        this.soLuongThuoc = 0;
    }

    // them
    public void themThuoc(Thuoc th) {
        if (timKiemTheoMa(th.getMaThuoc()) != null) {
            System.out.println("Ma thuoc da ton tai");
            return;
        }
        dsThuoc = Arrays.copyOf(dsThuoc, soLuongThuoc + 1);
        if (th instanceof thucPhamChucNang) {
            dsThuoc[dsThuoc.length - 1] = new thucPhamChucNang((thucPhamChucNang) th);
        } else {
            dsThuoc[dsThuoc.length - 1] = new thuocKeDon((thuocKeDon) th);
        }
        soLuongThuoc++;
        System.out.println("Them thuoc thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CHON LOAI THUOC CAN THEM                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Thuoc ke don                                                  ║");
        System.out.println("║ 2. Thuc pham chuc nang                                           ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.print("Chon loai (1-2): ");

        String luaChon = sc.nextLine();
        Thuoc thuocMoi = null;

        switch (luaChon) {
            case "1":
                thuocMoi = new thuocKeDon();
                break;
            case "2":
                thuocMoi = new thucPhamChucNang();
                break;
            default:
                System.out.println(">> Lua chon khong hop le!");
                return;
        }

        boolean maBiTrung;
        do {
            maBiTrung = false;
            thuocMoi.Nhap();
            if (timKiemTheoMa(thuocMoi.getMaThuoc()) != null) {
                System.out.println("Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);

        themThuoc(thuocMoi);
    }

    // xoa thuoc
    public void xoaThuoc(String maThuoc) {
        int vt = -1;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay thuoc co ma " + maThuoc);
            return;
        }

        for (int j = vt; j < soLuongThuoc - 1; j++) {
            dsThuoc[j] = dsThuoc[j + 1];
        }
        dsThuoc = Arrays.copyOf(dsThuoc, soLuongThuoc - 1);
        soLuongThuoc--;
        System.out.println("Xoa thuoc co ma " + maThuoc + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongThuoc == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma thuoc can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaThuoc(maCanXoa);
    }

    @Override
    public void Sua() {
        if (soLuongThuoc == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma thuoc can sua: ");
        String ma = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println(">> Khong tim thay ma thuoc!");
            return;
        }

        if (dsThuoc[viTri] instanceof thuocKeDon) {
            suaThuocKeDon(viTri);
        } else if (dsThuoc[viTri] instanceof thucPhamChucNang) {
            suaThucPhamChucNang(viTri);
        }
    }

    private void suaThuocKeDon(int index) {
        Scanner sc = new Scanner(System.in);
        thuocKeDon tkd = (thuocKeDon) dsThuoc[index];

        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║                 SUA THONG TIN THUOC KE DON                       ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten thuoc                                                 ║");
            System.out.println("║ 2. Sua don vi tinh                                               ║");
            System.out.println("║ 3. Sua gia ban                                                   ║");
            System.out.println("║ 4. Sua so luong                                                  ║");
            System.out.println("║ 5. Sua han su dung (HSD)                                         ║");
            System.out.println("║ 6. Sua loai thuoc ke don                                         ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-6): ");

            String luaChon = sc.nextLine();

            if (luaChon.equals("1")) {
                System.out.print("Nhap ten thuoc moi: ");
                tkd.setTenThuoc(sc.nextLine());
            } else if (luaChon.equals("2")) {
                System.out.print("Nhap don vi tinh moi: ");
                tkd.setDonViTinh(sc.nextLine());
            } else if (luaChon.equals("3")) {
                System.out.print("Nhap gia ban moi: ");
                double gia = Double.parseDouble(sc.nextLine());
                tkd.setGiaBan(gia);
            } else if (luaChon.equals("4")) {
                System.out.print("Nhap so luong moi: ");
                int sl = Integer.parseInt(sc.nextLine());
                tkd.setSoLuong(sl);
            } else if (luaChon.equals("5")) {
                System.out.print("Nhap HSD moi: ");
                tkd.setHSD(sc.nextLine());
            } else if (luaChon.equals("6")) {
                System.out.print("Nhap loai thuoc ke don moi: ");
                tkd.setLoaiThuocKeDon(sc.nextLine());
            } else if (luaChon.equals("0")) {
                System.out.println("\n>> Thong tin sau khi cap nhat:");
                tkd.Xuat();
                tiepTuc = false;
            } else {
                System.out.println(">> Lua chon khong hop le!");
            }
        }
    }

    private void suaThucPhamChucNang(int index) {
        Scanner sc = new Scanner(System.in);
        thucPhamChucNang tpcn = (thucPhamChucNang) dsThuoc[index];

        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║              SUA THONG TIN THUC PHAM CHUC NANG                   ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ten thuoc                                                 ║");
            System.out.println("║ 2. Sua don vi tinh                                               ║");
            System.out.println("║ 3. Sua gia ban                                                   ║");
            System.out.println("║ 4. Sua so luong                                                  ║");
            System.out.println("║ 5. Sua han su dung (HSD)                                         ║");
            System.out.println("║ 6. Sua loai thuc pham                                            ║");
            System.out.println("║ 0. Thoat                                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-6): ");

            String luaChon = sc.nextLine().trim();

            if (luaChon.equals("1")) {
                System.out.print("Nhap ten thuoc moi: ");
                tpcn.setTenThuoc(sc.nextLine());
            } else if (luaChon.equals("2")) {
                System.out.print("Nhap don vi tinh moi: ");
                tpcn.setDonViTinh(sc.nextLine());
            } else if (luaChon.equals("3")) {
                System.out.print("Nhap gia ban moi: ");
                double gia = Double.parseDouble(sc.nextLine());
                tpcn.setGiaBan(gia);
            } else if (luaChon.equals("4")) {
                System.out.print("Nhap so luong moi: ");
                int sl = Integer.parseInt(sc.nextLine());
                tpcn.setSoLuong(sl);
            } else if (luaChon.equals("5")) {
                System.out.print("Nhap HSD moi: ");
                tpcn.setHSD(sc.nextLine());
            } else if (luaChon.equals("6")) {
                System.out.print("Nhap loai thuc pham moi: ");
                tpcn.setLoaiTP(sc.nextLine());
            } else if (luaChon.equals("0")) {
                System.out.println("\n>> Thong tin sau khi cap nhat:");
                tpcn.Xuat();
                tiepTuc = false;
            } else {
                System.out.println(">> Lua chon khong hop le!");
            }
        }
    }

    // tim kiem
    public Thuoc timKiemTheoMa(String maThuoc) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                return dsThuoc[i];
            }
        }
        return null;
    }

    public Thuoc[] timKiemTheoTen(String tenThuoc) {
        Thuoc[] ketQua = new Thuoc[soLuongThuoc];
        int dem = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getTenThuoc().toLowerCase().contains(tenThuoc.toLowerCase())) {
                ketQua[dem] = dsThuoc[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongThuoc == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ten thuoc can tim: ");
        String tuKhoa = sc.nextLine();

        Thuoc th = timKiemTheoMa(tuKhoa);
        if (th != null) {
            System.out.println("Tim thay thuoc theo ma:");
            th.Xuat();
        } else {
            Thuoc[] ketQua = timKiemTheoTen(tuKhoa);
            if (ketQua.length > 0) {
                System.out.println("Tim thay " + ketQua.length + " thuoc theo ten:");
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println("Khong tim thay thuoc co ma/ten: " + tuKhoa);
            }
        }
    }

    public void thongKe() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              THONG KE DANH SACH THUOC                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        System.out.printf("║ Tong so thuoc: %-50d║%n", soLuongThuoc);

        int demThuocKeDon = 0;
        int demThucPhamChucNang = 0;

        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i] instanceof thucPhamChucNang) {
                demThucPhamChucNang++;
            } else if (dsThuoc[i] instanceof thuocKeDon) {
                demThuocKeDon++;
            }
        }

        System.out.printf("║   - Thuoc ke don: %-47d║%n", demThuocKeDon);
        System.out.printf("║   - Thuc pham chuc nang: %-40d║%n", demThucPhamChucNang);

        // Thuốc có giá cao nhất
        Thuoc thuocMax = dsThuoc[0];
        for (int i = 1; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getGiaBan() > thuocMax.getGiaBan()) {
                thuocMax = dsThuoc[i];
            }
        }
        System.out.printf("║ Thuoc gia cao nhat: %-45s║%n", thuocMax.getTenThuoc());
        System.out.printf("║ Gia: %-60.2f║%n", thuocMax.getGiaBan());

        // Tổng số lượng thuốc trong kho
        int tongSoLuongKho = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            tongSoLuongKho += dsThuoc[i].getSoLuong();
        }
        System.out.printf("║ Tong so luong thuoc trong kho: %-34d║%n", tongSoLuongKho);

        // Tổng giá trị kho
        double tongGia = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            tongGia += dsThuoc[i].getGiaBan() * dsThuoc[i].getSoLuong();
        }
        System.out.printf("║ Tong gia tri kho: %-47.2f║%n", tongGia);
        if (tongSoLuongKho > 0) {
            System.out.printf("║ Trung binh gia/thuoc: %-43.2f║%n", tongGia / tongSoLuongKho);
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public void hienThiBang(Thuoc[] arr, int size) {
        final String LINE = "═══════════════════════════════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out.println(
                "║                                        DANH SACH THUOC                                                        ║");
        System.out.println(
                "╠═════════════╦════════════════════════╦═════════════════╦═════════════╦════════════╦════════════╦══════════════╣");
        System.out.println(
                "║   Ma Thuoc  ║      Ten Thuoc         ║   Don Vi Tinh   ║   Gia Ban   ║  So Luong  ║    HSD     ║     Loai     ║");
        System.out.println(
                "╠═════════════╬════════════════════════╬═════════════════╬═════════════╬════════════╬════════════╬══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                String tenHienThi = arr[i].getTenThuoc().length() > 22
                        ? arr[i].getTenThuoc().substring(0, 19) + "..."
                        : arr[i].getTenThuoc();

                String donViHienThi = arr[i].getDonViTinh().length() > 15
                        ? arr[i].getDonViTinh().substring(0, 12) + "..."
                        : arr[i].getDonViTinh();

                // Xác định loại thuốc
                String loai;
                if (arr[i] instanceof thuocKeDon) {
                    thuocKeDon tkd = (thuocKeDon) arr[i];
                    loai = tkd.getLoaiThuocKeDon();
                } else if (arr[i] instanceof thucPhamChucNang) {
                    loai = "TPCN";
                } else {
                    loai = "Khac";
                }

                String loaiHienThi = loai.length() > 12 ? loai.substring(0, 10) + ".." : loai;

                System.out.printf("║ %-11s ║ %-22s ║ %-15s ║ %11.2f ║ %10d ║ %-10s ║ %-12s ║%n",
                        arr[i].getMaThuoc(),
                        tenHienThi,
                        donViHienThi,
                        arr[i].getGiaBan(),
                        arr[i].getSoLuong(),
                        arr[i].getHSD(),
                        loaiHienThi);
            }
        }

        System.out.println(
                "╚═════════════╩════════════════════════╩═════════════════╩═════════════╩════════════╩════════════╩══════════════╝");
        System.out.println("Tong so: " + size + " thuoc");
    }

    public void XuatDS() {
        if (soLuongThuoc == 0) {
            System.out.println("Danh sach thuoc rong");
        } else {
            hienThiBang(dsThuoc, soLuongThuoc);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong thuoc muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println("So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("\n--- Nhap thuoc thu " + (soLuongThuoc + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            THONG BAO FILE KHONG TON TAI                             ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-80s", tenFile) + " ║");
            System.out
                    .println("║  Bat dau voi danh sach RONG. Hay them thuoc moi!                                   ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsThuoc = new Thuoc[0];
            this.soLuongThuoc = 0;
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
                System.out.println("File khong co thuoc de doc.");
                this.dsThuoc = new Thuoc[0];
                this.soLuongThuoc = 0;
                return;
            }

            this.dsThuoc = new Thuoc[count];
            this.soLuongThuoc = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongThuoc < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");

                // Đọc theo loại thuốc
                try {
                    String loai = parts[0].trim();

                    if (loai.equals("ThuocKeDon") && parts.length == 8) {
                        // Thuoc ke don: Loai,Ma,Ten,DonVi,Gia,SoLuong,HSD,LoaiThuoc
                        dsThuoc[soLuongThuoc] = new thuocKeDon(
                                parts[1].trim(),
                                parts[2].trim(),
                                parts[3].trim(),
                                Double.parseDouble(parts[4].trim()),
                                Integer.parseInt(parts[5].trim()),
                                parts[6].trim(),
                                parts[7].trim());
                        soLuongThuoc++;
                    } else if (loai.equals("ThucPhamChucNang") && parts.length == 7) {
                        // Thuc pham chuc nang: Loai,Ma,Ten,DonVi,Gia,SoLuong,HSD
                        dsThuoc[soLuongThuoc] = new thucPhamChucNang(
                                parts[1].trim(),
                                parts[2].trim(),
                                parts[3].trim(),
                                Double.parseDouble(parts[4].trim()),
                                Integer.parseInt(parts[5].trim()),
                                parts[6].trim(),
                                "");
                        soLuongThuoc++;
                    } else {
                        System.err.println(" Dong " + lineNumber + ": Sai dinh dang hoac loai khong hop le");
                        System.err.println("     Noi dung: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.err.println(" Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                    System.err.println("     Noi dung: " + line);
                }
                lineNumber++;
            }

            if (soLuongThuoc < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongThuoc + "/" + count + " thuoc");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println(
                            "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongThuoc);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsThuoc = new Thuoc[0];
            this.soLuongThuoc = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongThuoc);

            for (int i = 0; i < soLuongThuoc; i++) {
                Thuoc th = dsThuoc[i];

                // Ghi theo loại thuốc
                if (th instanceof thuocKeDon) {
                    thuocKeDon tkd = (thuocKeDon) th;
                    pw.printf("ThuocKeDon,%s,%s,%s,%.2f,%d,%s,%s,%n",
                            tkd.getMaThuoc(),
                            tkd.getTenThuoc(),
                            tkd.getDonViTinh(),
                            tkd.getGiaBan(),
                            tkd.getSoLuong(),
                            tkd.getHSD(),
                            tkd.getLoaiThuocKeDon());
                } else if (th instanceof thucPhamChucNang) {
                    thucPhamChucNang TP = (thucPhamChucNang) th;
                    pw.printf("ThucPhamChucNang,%s,%s,%s,%.2f,%d,%s,%n",
                            TP.getMaThuoc(),
                            TP.getTenThuoc(),
                            TP.getDonViTinh(),
                            TP.getGiaBan(),
                            TP.getSoLuong(),
                            TP.getHSD());
                }
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            GHI FILE THANH CONG!                                     ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongThuoc);
            System.out.printf("║ Vao file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }
}