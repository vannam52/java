package duan;

public class chiTietHoaDon {
    private String maHD;
    private String maThuoc;
    private String tenThuoc;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public chiTietHoaDon() {
    }

    public chiTietHoaDon(chiTietHoaDon other){
        this.maHD = other.maHD;
        this.maThuoc = other.maThuoc;
        this.tenThuoc = other.tenThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    public chiTietHoaDon(String maHD, String maThuoc, String tenThuoc, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public String getMaThuoc() {
        return maThuoc;
    }
    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public String getTenThuoc() {
        return tenThuoc;
    }
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public int getDonGia() {
        return donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    public int getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void hienThiChiTietHoaDon() {
        System.out.println("Mã hóa đơn: " + maHD);
        System.out.println("Mã thuốc: " + maThuoc);
        System.out.println("Tên thuốc: " + tenThuoc);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Thành tiền: " + thanhTien);
    }

    
    public void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }
    @Override
    public String toString() {
        return String.format("%s - %s | SL: %d | Đơn giá: %,.0f VNĐ | Thành tiền: %,.0f VNĐ",
                maThuoc, tenThuoc, soLuong, donGia, thanhTien);
    }
}
