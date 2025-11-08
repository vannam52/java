package duan;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class danhSachDonGiaoHang implements ChucNang, IFile {
    private donGiaoHang[] ds;
    private int size;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // ... (Giữ nguyên các hàm constructor, Them, Xoa, Sua, TimKiem, thongKe...)
    
    public danhSachDonGiaoHang() {
        this.ds = new donGiaoHang[0];
        this.size = 0;
    }

    // THEM (khong tuong tac)
    public void themDon(donGiaoHang dgh) {
        if (dgh == null) return;
        if (timKiemTheoMa(dgh.getMaDH()) != null) {
            System.out.println("Da ton tai don co ma: " + dgh.getMaDH());
            return;
        }
        ds = Arrays.copyOf(ds, size + 1);
        ds[size++] = dgh;
        System.out.println("Them don giao hang thanh cong!");
    }

    // THEM (tuong tac)
    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        donGiaoHang dgh = new donGiaoHang();
        boolean maTrung;
        do {
            maTrung = false;
            dgh.Nhap();
            if (timKiemTheoMa(dgh.getMaDH()) != null) {
                System.out.println("Ma bi trung. Vui long nhap lai ma khac.");
                maTrung = true;
            }
        } while (maTrung);
        themDon(dgh);
        sc.close();
    }

    // XOA (khong tuong tac)
    public void xoaDon(String maXoa) {
        if (maXoa == null || size == 0) {
            System.out.println("Khong tim thay don giao.");
            return;
        }
        int vt = -1;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaDH() != null && ds[i].getMaDH().equalsIgnoreCase(maXoa)) { vt = i; break; }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay don: " + maXoa);
            return;
        }
        for (int j = vt; j < size - 1; j++) ds[j] = ds[j + 1];
        ds = Arrays.copyOf(ds, size - 1);
        size--;
        System.out.println("Da xoa don co ma: " + maXoa);
    }

    // XOA (tuong tac)
    @Override
    public void Xoa() {
        Scanner sc = new Scanner(System.in);
        if (size == 0) {
            System.out.println("Danh sach rong");
            sc.close();
            return;
        }
        System.out.print("Nhap ma don can xoa: ");
        String ma = sc.nextLine().trim();
        xoaDon(ma);
        sc.close();
    }

    // SUA (menu theo truong)
    @Override
    public void Sua() {
        if (size == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma don can sua: ");
        String ma = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaDH() != null && ds[i].getMaDH().equalsIgnoreCase(ma)) { viTri = i; break; }
        }
        if (viTri == -1) {
            System.out.println("Khong tim thay don co ma " + ma);
            sc.close();
            return;
        }

        donGiaoHang d = ds[viTri];
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                         SUA THONG TIN DON GIAO HANG: " + String.format("%-20s", ma) + "        ║");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma hoa don                                                                    ║");
            System.out.println("║ 2. Sua ngay giao (dd/MM/yyyy)                                                        ║");
            System.out.println("║ 3. Sua dia chi                                                                       ║");
            System.out.println("║ 4. Sua so luong                                                                      ║");
            System.out.println("║ 5. Sua trang thai                                                                    ║");
            System.out.println("║ 6. Sua tong tien                                                                     ║");
            System.out.println("║ 8. Nhap lai tat ca                                                                    ║");
            System.out.println("║ 0. Hoan thanh                                                                        ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-8): ");

            String chon = sc.nextLine().trim();
            switch (chon) {
                case "1":
                    System.out.print("Nhap ma hoa don moi: ");
                    d.setMaHD(sc.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Nhap ngay giao moi (dd/MM/yyyy): ");
                    d.setNgayGiao(sc.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Nhap dia chi moi: ");
                    d.setDiaChi(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Nhap so luong moi: ");
                    try { d.setSoLuong(Integer.parseInt(sc.nextLine().trim())); } catch (Exception ex) { d.setSoLuong(0); }
                    break;
                case "5":
                    System.out.print("Nhap trang thai moi: ");
                    d.setTrangThai(sc.nextLine().trim());
                    break;
                case "6":
                    System.out.print("Nhap tong tien moi: ");
                    try { d.setTongTien(Double.parseDouble(sc.nextLine().trim())); } catch (Exception ex) { d.setTongTien(0.0); }
                    break;
                case "8":
                    System.out.println("Nhap lai tat ca thong tin:");
                    d.Nhap(); 
                    break;
                case "0":
                    System.out.println("Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        sc.close();
    }

    // TIM THEO MA DON
    public donGiaoHang timKiemTheoMa(String maDH) {
        if (maDH == null) return null;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaDH() != null && ds[i].getMaDH().equalsIgnoreCase(maDH)) return ds[i];
        }
        return null;
    }

    // TIM THEO MA HOA DON (tra ve mang ket qua)
    public donGiaoHang[] timKiemTheoMaHD(String maHD) {
        if (maHD == null) return new donGiaoHang[0];
        donGiaoHang[] tmp = new donGiaoHang[size];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            String mahd = ds[i].getMaHD();
            if (mahd != null && mahd.toLowerCase().contains(maHD.toLowerCase())) {
                tmp[cnt++] = ds[i];
            }
        }
        return Arrays.copyOf(tmp, cnt);
    }

    // Tim kiem tuong tac
    @Override
    public void TimKiem() {
        if (size == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM DON GIAO HANG ---");
        System.out.println("1. Tim theo MaDH");
        System.out.println("2. Tim theo MaHD");
        System.out.print("Chon loai tim kiem: ");

        int chon = 0;
        try { chon = Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { System.out.println("Lua chon khong hop le!"); sc.close(); return; }

        switch (chon) {
            case 1:
                System.out.print("Nhap MaDH can tim: ");
                String ma = sc.nextLine().trim();
                donGiaoHang d = timKiemTheoMa(ma);
                if (d != null) { System.out.println("Tim thay theo MaDH:"); d.Xuat(); }
                else System.out.println("Khong tim thay don co MaDH: " + ma);
                break;
            case 2:
                System.out.print("Nhap MaHD can tim: ");
                String mahd = sc.nextLine().trim();
                donGiaoHang[] kq = timKiemTheoMaHD(mahd);
                if (kq.length > 0) {
                    System.out.println("Tim thay " + kq.length + " ket qua theo MaHD:");
                    // Sửa lại: Dùng hienThiBang để in mảng kết quả
                    hienThiBang(kq, kq.length); 
                } else System.out.println("Khong tim thay don phu hop.");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
        sc.close();
    }

    // Thong ke (tong tien, max, min)
    public void thongKe() {
        if (size == 0) {
            System.out.println("✗ Danh sach don giao hang rong");
            return;
        }
        double tong = 0;
        double max = ds[0].getTongTien();
        double min = ds[0].getTongTien();
        donGiaoHang dMax = ds[0], dMin = ds[0];

        for (int i = 0; i < size; i++) {
            tong += ds[i].getTongTien();
            if (ds[i].getTongTien() > max) { max = ds[i].getTongTien(); dMax = ds[i]; }
            if (ds[i].getTongTien() < min) { min = ds[i].getTongTien(); dMin = ds[i]; }
        }

        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                  BANG THONG KE DON GIAO HANG                                              ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-15s ║ %-15s ║ %-17s ║ %-17s ║ %-26s ║%n",
                "Tong so don",
                "Tong tien",
                "Tien TB",
                "Don cao nhat",
                "Don thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                size,
                tong,
                tong / size,
                dMax.getMaDH(),
                dMin.getMaDH(),
                max - min);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    public void hienThiBang(donGiaoHang[] arr, int sz) {
        // 1. Định nghĩa độ rộng cột cho printf (W_FMT)
        final int W_FMT_MADH = 8;
        final int W_FMT_MAHD = 10;
        final int W_FMT_NGAY = 10;
        final int W_FMT_DIACHI = 22;
        final int W_FMT_SOLUONG = 7; // (Cho "SoLuong")
        final int W_FMT_TRANGTHAI = 20;
        final int W_FMT_TONGTIEN = 12; // Thêm cột Tổng Tiền

        // 2. Định nghĩa độ rộng đường viền (W_BORDER = W_FMT + 2)
        final int W_BDR_MADH = W_FMT_MADH + 2;
        final int W_BDR_MAHD = W_FMT_MAHD + 2;
        final int W_BDR_NGAY = W_FMT_NGAY + 2;
        final int W_BDR_DIACHI = W_FMT_DIACHI + 2;
        final int W_BDR_SOLUONG = W_FMT_SOLUONG + 2;
        final int W_BDR_TRANGTHAI = W_FMT_TRANGTHAI + 2;
        final int W_BDR_TONGTIEN = W_FMT_TONGTIEN + 2;
        
        // 3. Tạo các chuỗi đường viền
        final String LINE = 
            repeatChar('═', W_BDR_MADH) + "╦" + 
            repeatChar('═', W_BDR_MAHD) + "╦" + 
            repeatChar('═', W_BDR_NGAY) + "╦" + 
            repeatChar('═', W_BDR_DIACHI) + "╦" + 
            repeatChar('═', W_BDR_SOLUONG) + "╦" + 
            repeatChar('═', W_BDR_TRANGTHAI) + "╦" + 
            repeatChar('═', W_BDR_TONGTIEN);

        final String TOP_BORDER = "╔" + LINE.replace('╦', '╤') + "╗";
        final String MID_BORDER = "╠" + LINE.replace('╦', '╬') + "╣";
        final String BOT_BORDER = "╚" + LINE.replace('╦', '╧') + "╝";

        // 4. Tạo các chuỗi định dạng (format string) cho printf
        // Dùng %-Ns (căn trái) và %Ns (căn phải)
        final String HEADER_FMT = "║ %-" + W_FMT_MADH + "s ║ %-" + W_FMT_MAHD + "s ║ %-" + W_FMT_NGAY + "s ║ %-" + W_FMT_DIACHI + "s ║ %" + W_FMT_SOLUONG + "s ║ %-" + W_FMT_TRANGTHAI + "s ║ %" + W_FMT_TONGTIEN + "s ║%n";
        final String ROW_FMT    = "║ %-" + W_FMT_MADH + "s ║ %-" + W_FMT_MAHD + "s ║ %-" + W_FMT_NGAY + "s ║ %-" + W_FMT_DIACHI + "s ║ %" + W_FMT_SOLUONG + "d ║ %-" + W_FMT_TRANGTHAI + "s ║ %" + W_FMT_TONGTIEN + ".0f ║%n";

        // 5. In bảng
        System.out.println(TOP_BORDER);
        int totalWidth = LINE.length() + 1; // Tổng độ rộng bên trong
        System.out.printf("║ %s ║%n", center("DANH SACH DON GIAO HANG", totalWidth));
        System.out.println(MID_BORDER);
        
        // In tiêu đề
        System.out.printf(HEADER_FMT, 
            "MaDH", 
            "MaHD", 
            "NgayGiao", 
            "DiaChi", 
            "SoLuong", 
            "TrangThai",
            "TongTien"
        );

        System.out.println(MID_BORDER);
        
        // In nội dung các dòng
        for (int i = 0; i < sz; i++) {
            donGiaoHang d = arr[i];
            
            // Áp dụng hàm truncate cho các chuỗi trước khi in
            String maDH = truncate(d.getMaDH(), W_FMT_MADH);
            String maHD = truncate(d.getMaHD(), W_FMT_MAHD);
            String ngayGiao = truncate(d.getNgayGiao(), W_FMT_NGAY);
            String diaChi = truncate(d.getDiaChi(), W_FMT_DIACHI);
            String trangThai = truncate(d.getTrangThai(), W_FMT_TRANGTHAI);
            
            System.out.printf(ROW_FMT,
                    maDH, maHD, ngayGiao, diaChi, d.getSoLuong(), trangThai, d.getTongTien());
        }
        System.out.println(BOT_BORDER);
    }

    public void XuatDS() {
        if (size == 0) {
            System.out.println("Danh sach don giao rong");
            return;
        }
        hienThiBang(ds, size);
    }

    // GHI FILE
    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(size);
            for (int i = 0; i < size; i++) {
                donGiaoHang d = ds[i];
                pw.printf(Locale.US, "%s,%s,%s,%s,%d,%s,%.2f%n",
                        escape(d.getMaDH()), escape(d.getMaHD()), escape(d.getNgayGiao()),
                        escape(d.getDiaChi()), d.getSoLuong(), escape(d.getTrangThai()), d.getTongTien());
            }
            System.out.println("Ghi file thanh cong. Da ghi: " + size);
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    // DOC FILE
    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Bat dau voi danh sach rong.");
            this.ds = new donGiaoHang[0];
            this.size = 0;
            return;
        }
        System.out.println("→ Dang doc file: " + tenFile + "...");
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String first = br.readLine();
            if (first == null || first.trim().isEmpty()) throw new IOException("File rong hoac khong co so luong!");
            int count = Integer.parseInt(first.trim());
            this.ds = new donGiaoHang[count];
            this.size = 0;
            String line; int ln = 2;
            while ((line = br.readLine()) != null && size < count) {
                if (line.trim().isEmpty()) { ln++; continue; }
                String[] parts = line.split(",", -1);
                if (parts.length < 6) {
                    System.err.println("Dong " + ln + ": Sai dinh dang");
                    ln++; continue;
                }
                String maDH = unescape(parts[0].trim());
                String maHD = unescape(parts[1].trim());
                String ngay = unescape(parts[2].trim());
                String diaChi = unescape(parts[3].trim());
                int sl = 0;
                try { sl = Integer.parseInt(parts[4].trim()); } catch (Exception e) { sl = 0; }
                String tt = unescape(parts[5].trim());
                double tong = 0.0;
                if (parts.length >= 7) {
                    try { tong = Double.parseDouble(parts[6].trim()); } catch (Exception ex) { tong = 0.0; }
                }
                ds[size++] = new donGiaoHang(maDH, maHD, ngay, diaChi, sl, tt, tong);
                ln++;
            }
            System.out.println("Doc file xong. Da doc: " + size);
        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.ds = new donGiaoHang[0];
            this.size = 0;
        }
    }

    private LocalDate parseDate(String s) {
        if (s == null || s.trim().isEmpty()) return null;
        try { return LocalDate.parse(s.trim(), DTF); }
        catch (DateTimeParseException e) { return null; }
    }

    public double tongTienTrongKhoang(String fromStr, String toStr) {
        LocalDate f = parseDate(fromStr), t = parseDate(toStr);
        if (f == null || t == null) return 0.0;
        if (t.isBefore(f)) { LocalDate tmp = f; f = t; t = tmp; }
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayGiao());
            if (d == null) continue;
            if ((d.isEqual(f) || d.isAfter(f)) && (d.isEqual(t) || d.isBefore(t))) sum += ds[i].getTongTien();
        }
        return sum;
    }

    public double[] thongKeTheoQuy(int nam) {
        double[] q = new double[4];
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayGiao());
            if (d == null || d.getYear() != nam) continue;
            int idx = (d.getMonthValue() - 1) / 3;
            q[idx] += ds[i].getTongTien();
        }
        return q;
    }

    public double[] thongKeTheoThangTrongNam(int nam) {
        double[] m = new double[12];
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayGiao());
            if (d == null || d.getYear() != nam) continue;
            m[d.getMonthValue() - 1] += ds[i].getTongTien();
        }
        return m;
    }

    private String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    private String center(String text, int width) {
        if (text == null || text.length() >= width) {
            return truncate(text, width);
        }
        int padding = width - text.length();
        int leftPad = padding / 2;
        int rightPad = padding - leftPad;
        return repeatChar(' ', leftPad) + text + repeatChar(' ', rightPad);
    }

    private String truncate(String text, int width) {
        if (text == null) return "";
        if (text.length() <= width) {
            return text;
        }
        if (width < 3) {
            return text.substring(0, width);
        }
        return text.substring(0, width - 3) + "...";
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("\n", " ").replace("\r", " ").replace(",", ";");
    }

    private static String unescape(String s) {
        if (s == null) return "";
        return s.replace(";", ",");
    }

    public int getSize() { return size; }
    public donGiaoHang[] getDs() { return Arrays.copyOf(ds, size); }
}