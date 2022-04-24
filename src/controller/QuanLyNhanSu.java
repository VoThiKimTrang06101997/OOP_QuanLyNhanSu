package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.CongTy;
import model.GiamDoc;
import model.NhanSu;
import model.NhanVien;
import model.TruongPhong;

public class QuanLyNhanSu {
	private List<NhanSu> danhSachNhanSu;
	private CongTy congTy;
	float tongLuong;
	double loiNhuanThang = 0;
	
	private List<NhanVien> danhSachNhanVien;
	private List<TruongPhong> danhSachTruongPhong;
	private List<GiamDoc> danhSachGiamDoc;
	
	public QuanLyNhanSu() {
		danhSachNhanSu = new ArrayList<>();
		danhSachNhanVien = new ArrayList<>();
		danhSachTruongPhong = new ArrayList<>();
		danhSachGiamDoc = new ArrayList<>();
		tongLuong = 0;
		congTy = new CongTy();
	}
	
	/* getters and setters */
	public List<NhanSu> getDanhSachNhanSu() {
		return danhSachNhanSu;
	}

	public void setDanhSachNhanSu(List<NhanSu> danhSachNhanSu) {
		this.danhSachNhanSu = danhSachNhanSu;
	}

	public List<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public List<TruongPhong> getDanhSachTruongPhong() {
		return danhSachTruongPhong;
	}

	public void setDanhSachTruongPhong(List<TruongPhong> danhSachTruongPhong) {
		this.danhSachTruongPhong = danhSachTruongPhong;
	}

	public List<GiamDoc> getDanhSachGiamDoc() {
		return danhSachGiamDoc;
	}

	public void setDanhSachGiamDoc(List<GiamDoc> danhSachGiamDoc) {
		this.danhSachGiamDoc = danhSachGiamDoc;
	}
	
	public double getLoiNhuanThang() {
		return loiNhuanThang;
	}

	public void setLoiNhuanThang(double loiNhuanThang) {
		this.loiNhuanThang = loiNhuanThang;
	}
	
	/* methods */
	public void nhapThongTinCongTy(Scanner scanner) {
		congTy.nhapThongTin(scanner);
	}
	
	public void xuatThongTinCongTy() {
		congTy.xuatThongTin();
	}
	
	// Thêm nhân sự
	public boolean them (NhanSu ns) {
		// validate - black list
		if(ns == null) 
			return false;
		if(ns.getMaSo() == null || ns.getMaSo().equals(""))
			return false;
		return danhSachNhanSu.add(ns);
	}
	
	// Xóa nhân sự
	public boolean xoa(String maSo) {
		return false;
	}
	
	// Header
	public void header(String thongTinHeader, String thongTin) {
		System.out.println("------------------------------------------------ Danh sách " + thongTinHeader +" -----------------------------------------------------------");
		System.out.printf("\n%-5s%-15s%-30s%-20s%-20s%-20s%-20s%-30s","STT","Mã số","Họ tên","Số điện thoại","Số ngày làm","Lương một ngày","Lương tháng",thongTin);
		System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	// Xuất danh sách nhân viên
	public void xuatDanhSachNhanSu() {
		int stt = 1;
		
		header("Nhân sự toàn công ty", "");
		for(NhanSu ns:danhSachNhanSu) {
			ns.tinhLuong();
			System.out.println();
			ns.xuatThongTin(stt);
			stt++;
		}
	}
	
	// Danh sách nhân viên
	public List<NhanVien> dsNhanViens() {
		for(NhanSu ns: danhSachNhanSu) {
			if(ns instanceof NhanVien) {
				danhSachNhanVien.add((NhanVien) ns);
			}
		}
		return danhSachNhanVien;
	}
	
	// Danh sách trưởng phòng
	public List<TruongPhong> dsTruongPhong() {
		for(NhanSu ns: danhSachNhanSu) {
			if(ns instanceof TruongPhong) {
				danhSachTruongPhong.add((TruongPhong) ns);
			}
		}
		return danhSachTruongPhong;
	}
	
	// Danh sách Giám đốc
	public List<GiamDoc> dsGiamDoc(){
		for(NhanSu ns:danhSachNhanSu) {
			if(ns instanceof GiamDoc) {
				danhSachGiamDoc.add((GiamDoc) ns);
			}
		}
		return danhSachGiamDoc;
	}	
	
	// Tìm nhân viên có lương cao nhất
	public NhanVien nvLuongCaoNhat() {
		NhanVien nv = this.danhSachNhanVien.get(0);
		
		for(NhanVien nhanVien: danhSachNhanVien) {
			if(nhanVien.getLuongThang() > nv.getLuongThang() && danhSachNhanVien.isEmpty() == false) {
				nv = nhanVien;
			}
			if(danhSachNhanVien.isEmpty() ==  true) {
				System.out.println("Công ty không có nhân viên lương cao nhất");
			}
		}
		return nv;
	}
	
	// Tìm trưởng phòng có nhân viên dưới quyền nhiều nhất
	public TruongPhong truongPhongNhieuNhanVien() {
		TruongPhong tp = this.danhSachTruongPhong.get(0);
		
		for(TruongPhong truongPhong: danhSachTruongPhong) {
			if(truongPhong.getSoNhanVien() > tp.getSoNhanVien() && danhSachTruongPhong.isEmpty() == false) {
				tp = truongPhong;
			}
		}
		return tp;
	}
	
	// Tìm giám đốc có số cổ phần nhiều nhất
	public GiamDoc giamDocNhieuCoPhan() {
		GiamDoc gd = this.danhSachGiamDoc.get(0);
		
		for(GiamDoc giamDoc:danhSachGiamDoc) {
			if(giamDoc.getSoCoPhan() > gd.getSoCoPhan() && danhSachGiamDoc.isEmpty() == false) {
				gd = giamDoc;
			}
		}
		return gd;	
	}
	
	// Tính tổng lương công ty
	public float tongLuongCongTy() {
		this.tongLuong = 0;
		for(NhanSu nhanSu: danhSachNhanSu) {
			this.tongLuong = this.tongLuong + nhanSu.tinhLuong();
		}
		return this.tongLuong;
	}
	
	// Tính lợi nhuận công ty
	public double tinhLoiNhuan() {
		loiNhuanThang = congTy.getDoanhThuThang() - this.tongLuong;
		return this.loiNhuanThang;
	}
	
	// Danh sách thu nhập giám đốc 
	public void xuatDSGiamDoc() {
		int stt = 1;
		this.dsGiamDoc();	
		
		for(GiamDoc gd: danhSachGiamDoc) {
			gd.tinhLuong();
			gd.thuNhapGiamDoc();
			System.out.println(String.format("%-5s%-15s%-30s%-25.2f", stt, gd.getMaSo(), gd.getHoTen(), gd.getThuNhapGiamDoc()));
			stt++;
		}
	}
	
	// Xóa nhân sự
	public void xoaNhanSu(String maNS) {
		int i = 0 ;
		
		for(NhanSu ns: danhSachNhanSu) {
			if(ns.getMaSo().equals(maNS) && ns != null) {
				// Xóa đối với nhân sự là giám đốc
				i++;
				if(ns instanceof GiamDoc) {
					this.danhSachNhanSu.remove(ns);
					this.danhSachGiamDoc.remove(ns);
					break;
				}
				// Xóa đối với nhân sự là nhân viên thường
				if(ns instanceof NhanVien) {
					if(!((NhanVien) ns).getMaSoTruongPhong().equals("")) {
						for(TruongPhong tp: danhSachTruongPhong) {
							if(tp.getMaSo() == ((NhanVien) ns).getMaSoTruongPhong()) {
								tp.setSoNhanVien(tp.getSoNhanVien() - 1);
								this.danhSachNhanSu.remove(ns);
								this.danhSachNhanVien.remove(ns);
								break;
							}
						}
					}
					if(((NhanVien) ns).getMaSoTruongPhong().equals("")) 
					{
						this.danhSachNhanVien.remove(ns);
						this.danhSachNhanSu.remove(ns);
						break;
					}
				}
				// Xóa đối với nhân sự là trưởng phòng
				if(ns instanceof TruongPhong) {
					for(NhanVien nv: danhSachNhanVien) {
						if(nv.getMaSoTruongPhong().equals(maNS)) {
							((NhanVien) nv).setMaSoTruongPhong("");
						}
					}
					this.danhSachNhanSu.remove(ns);
					this.danhSachTruongPhong.remove(ns);
					break;
				}
			}
			
			if(i==0) {
				System.out.println("Không có mã nhân sự nào như vậy");
			}
		}
	}
}
