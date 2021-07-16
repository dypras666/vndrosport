package com.gilang.vndrosport.model;

import com.google.gson.annotations.SerializedName;

public class KeranjangModel {
	@SerializedName("id")
	private final String idDetailKeranjang;
	@SerializedName("nama_produk")
	private final String namaProduk;
	@SerializedName("id_keranjang")
	private final String idKeranjang;
	@SerializedName("jumlah")
	private final String jumlahProduk;
	@SerializedName("m_sub_total")
	private final String subTotal;
	@SerializedName("gambar")
	private final String gambarProduk;

	public KeranjangModel(String idDetailKeranjang, String namaProduk, String idKeranjang, String jumlahProduk, String subTotal, String gambarProduk) {
		this.idDetailKeranjang = idDetailKeranjang;
		this.namaProduk = namaProduk;
		this.idKeranjang = idKeranjang;
		this.jumlahProduk = jumlahProduk;
		this.subTotal = subTotal;
		this.gambarProduk = gambarProduk;
	}

	public String getIdDetailKeranjang() {
		return idDetailKeranjang;
	}

	public String getNamaProduk() {
		return namaProduk;
	}

	public String getIdKeranjang() {
		return idKeranjang;
	}

	public String getJumlahProduk() {
		return jumlahProduk;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public String getGambarProduk() {
		return gambarProduk;
	}
}
