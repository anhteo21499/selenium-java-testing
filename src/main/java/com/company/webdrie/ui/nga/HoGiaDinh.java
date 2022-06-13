package com.company.webdrie.ui.nga;

import java.util.List;

public class HoGiaDinh {
    private int soThanhVien;
    private String soNha;
    private List<ThanhVien> thanhVien;

    public HoGiaDinh(int soThanhVien, String soNha, List<ThanhVien> thanhVien) {
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        this.thanhVien = thanhVien;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<ThanhVien> getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(List<ThanhVien> thanhVien) {
        this.thanhVien = thanhVien;
    }

    @Override
    public String toString() {
        return "HoGiaDinh{" +
                "soThanhVien=" + soThanhVien +
                ", soNha='" + soNha + '\'' +
                ", thanhVien=" + thanhVien +
                '}';
    }
}
