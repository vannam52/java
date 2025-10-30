package duan;

public class hoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String ngayLap;
    private double tongTien;
    private chiTietHoaDon[] chiTietHoaDons;
    private int soLuongChiTiet;
    private final int MAX_CHI_TIET = 100;

    public hoaDon() {
    }

    public hoaDon(hoaDon other){
        this.maHD = other.maHD;
        this.maKH = other.maKH;
        this.maNV = other.maNV;
        this.ngayLap = other.ngayLap;
        this.tongTien = other.tongTien;
        this.soLuongChiTiet = other.soLuongChiTiet;
        this.chiTietHoaDons = new chiTietHoaDon[MAX_CHI_TIET];
        for (int i = 0; i < other.soLuongChiTiet; i++){
            this.chiTietHoaDons[i] = new chiTietHoaDon(other.chiTietHoaDons[i]);
        }
    }

    public hoaDon(String maHD, String maKH, String maNV, String ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.chiTietHoaDons = new chiTietHoaDon[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
    }

    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public void tinhTongTien(double tien) {
        this.tongTien += tien;
    }
    public void taoHoaDon(){
        System.out.println("Hoa don tao tu ma la: " + maHD);
    }
    public void xoaHoaDon(){
        System.out.println("Hoa don bi xoa co ma la: " + maHD);
    }

    public void hienThiHoaDon(){
        System.out.println("Ma hoa don: " + maHD);
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ngay lap: " + ngayLap);
        System.out.println("Tong tien: " + tongTien);
    }


    //them chi tiet hoa don
    public void themChiTietHoaDon(chiTietHoaDon CTHD, String maThuoc, String tenThuoc, int soLuong, double donGia){
        if(soLuongChiTiet > MAX_CHI_TIET){
            System.out.println("Khong the them");
        }
            chiTietHoaDons[soLuongChiTiet++] = new chiTietHoaDon(maHD, maThuoc, tenThuoc, soLuong, (int) donGia);
            System.out.println("Da them chi tiet hoa don");

            this.tinhTongTien(soLuong * donGia);
    }

    //tinh tong tien hoa don
    public double tinhTongTienHoaDon(){
        double tongTien = 0;
        for(int i = 0; i < soLuongChiTiet; i++){
            tongTien += chiTietHoaDons[i].getThanhTien();
        }
        return tongTien;
    }

    //hien thi chi tiet hoa don
    public void hienThiChiTietHoaDon(){
        System.out.println("Chi tiet hoa don cho ma hoa don: " + maHD);
        for(int i = 0; i < soLuongChiTiet; i++){
            chiTietHoaDons[i].hienThiChiTietHoaDon();
        }
    }


    //xoa chi tiet hoa don theo ma thuoc
    public void xoaChiTietHoaDon(String maThuoc){
        for(int i = 0; i < soLuongChiTiet; i++){
            if(chiTietHoaDons[i].getMaThuoc().equals(maThuoc)){
                for(int j = i; j < soLuongChiTiet - 1; j++){
                    chiTietHoaDons[j] = chiTietHoaDons[j + 1];
                }
                soLuongChiTiet--;
                System.out.println("Da xoa chi tiet hoa don cho ma thuoc: " + maThuoc);
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet hoa don cho ma thuoc: " + maThuoc);
    }

//tim kiem chi tiet hoa don theo ma thuoc
    public chiTietHoaDon timKiemChiTietHoaDon(String maThuoc){
        for(int i = 0; i < soLuongChiTiet; i++){
            if(chiTietHoaDons[i].getMaThuoc().equals(maThuoc)){
                return chiTietHoaDons[i];
            }
        }
        return null;
    }

}

