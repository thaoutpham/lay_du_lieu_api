package com.example.synchronized_api.model;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maphuongxa;
    private String nguy_co;
    private String cap;
    private String ngay_cap_nhap;
    private String ten_tinh_thanh;
    private String ten_quan_huyen;
    private String ten_phuong_xa;
    private String ma_tinh_thanh;
    private String ma_quan_huyen;
    private int count_so_don_vi;
    private String max_ngay_cap_nhap;

    public Data() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNguy_co() {
        return nguy_co;
    }

    public void setNguy_co(String nguy_co) {
        this.nguy_co = nguy_co;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getNgay_cap_nhap() {
        return ngay_cap_nhap;
    }

    public void setNgay_cap_nhap(String ngay_cap_nhap) {
        this.ngay_cap_nhap = ngay_cap_nhap;
    }

    public String getTen_tinh_thanh() {
        return ten_tinh_thanh;
    }

    public void setTen_tinh_thanh(String ten_tinh_thanh) {
        this.ten_tinh_thanh = ten_tinh_thanh;
    }

    public String getTen_quan_huyen() {
        return ten_quan_huyen;
    }

    public void setTen_quan_huyen(String ten_quan_huyen) {
        this.ten_quan_huyen = ten_quan_huyen;
    }

    public String getTen_phuong_xa() {
        return ten_phuong_xa;
    }

    public void setTen_phuong_xa(String ten_phuong_xa) {
        this.ten_phuong_xa = ten_phuong_xa;
    }

    public String getMa_tinh_thanh() {
        return ma_tinh_thanh;
    }

    public void setMa_tinh_thanh(String ma_tinh_thanh) {
        this.ma_tinh_thanh = ma_tinh_thanh;
    }

    public String getMa_quan_huyen() {
        return ma_quan_huyen;
    }

    public void setMa_quan_huyen(String ma_quan_huyen) {
        this.ma_quan_huyen = ma_quan_huyen;
    }

    public String getMa_phuong_xa() {
        return maphuongxa;
    }

    public void setMa_phuong_xa(String maphuongxa) {
        this.maphuongxa = maphuongxa;
    }

    public int getCount_so_don_vi() {
        return count_so_don_vi;
    }

    public void setCount_so_don_vi(int count_so_don_vi) {
        this.count_so_don_vi = count_so_don_vi;
    }

    public String getMax_ngay_cap_nhap() {
        return max_ngay_cap_nhap;
    }

    public void setMax_ngay_cap_nhap(String max_ngay_cap_nhap) {
        this.max_ngay_cap_nhap = max_ngay_cap_nhap;
    }

    public Data(Long id, String nguy_co, String cap, String ngay_cap_nhap,
                String ten_tinh_thanh, String ten_quan_huyen, String ten_phuong_xa,
                String ma_tinh_thanh, String ma_quan_huyen, String ma_phuong_xa,
                int count_so_don_vi, String max_ngay_cap_nhap) {
        this.id = id;
        this.nguy_co = nguy_co;
        this.cap = cap;
        this.ngay_cap_nhap = ngay_cap_nhap;
        this.ten_tinh_thanh = ten_tinh_thanh;
        this.ten_quan_huyen = ten_quan_huyen;
        this.ten_phuong_xa = ten_phuong_xa;
        this.ma_tinh_thanh = ma_tinh_thanh;
        this.ma_quan_huyen = ma_quan_huyen;
        this.maphuongxa = ma_phuong_xa;
        this.count_so_don_vi = count_so_don_vi;
        this.max_ngay_cap_nhap = max_ngay_cap_nhap;
    }
}
