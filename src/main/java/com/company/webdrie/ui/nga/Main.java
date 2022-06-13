package com.company.webdrie.ui.nga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<HoGiaDinh> hoGiaDinhList  = new ArrayList<>();

        System.out.println("Nhap thong tin khu pho");
        System.out.println("Nhap ho gia dinh");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            List<ThanhVien> thanhViens  = new ArrayList<>();
            System.out.println(" Nhap ho gia dinh thu " + (i + 1));
            scanner.nextLine();
            System.out.println("Nhap so nha ");
            String soNha = scanner.nextLine();
            System.out.println("Nhap so thanh vien trong gia dinh");
            int soThanhVien = scanner.nextInt();

            for (int j = 0; j < soThanhVien; j++) {
                System.out.println("Nhap thanh vien thu " + (j + 1));
                scanner.nextLine();
                System.out.println("Nhap ten : ");
                String ten = scanner.nextLine();
                System.out.println("Nhap tuoi :");
                int tuoi = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap nghe nghiep : ");
                String nghe = scanner.nextLine();
                System.out.println("Nhap cmt : ");
                String cmt = scanner.nextLine();
                thanhViens.add(new ThanhVien(ten, tuoi, nghe, cmt));
            }
            hoGiaDinhList.add(new HoGiaDinh(soThanhVien, soNha, thanhViens));
        }

        System.out.println(hoGiaDinhList);
    }
}

