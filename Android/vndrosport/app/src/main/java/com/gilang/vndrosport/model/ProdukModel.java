package com.gilang.vndrosport.model;

import com.google.gson.annotations.SerializedName;

public class ProdukModel {
	@SerializedName("id")
	private final String idProduk;
	@SerializedName("nama_produk")
	private final String namaProduk;
	@SerializedName("harga")
	private final String hargaProduk;
	@SerializedName("nama_kategori")
	private final String namaKategori;
	@SerializedName("nama_merek")
	private final String namaMerek;
	@SerializedName("gambar")
	private final String gambarProduk;
	@SerializedName("ukuran")
	private final String ukuranProduk;
	@SerializedName("warna")
	private final String warnaProduk;

	public ProdukModel(String idProduk, String namaProduk, String hargaProduk, String namaKategori, String namaMerek, String gambarProduk, String ukuranProduk, String warnaProduk) {
		this.idProduk = idProduk;
		this.namaProduk = namaProduk;
		this.hargaProduk = hargaProduk;
		this.namaKategori = namaKategori;
		this.namaMerek = namaMerek;
		this.gambarProduk = gambarProduk;
		this.ukuranProduk = ukuranProduk;
		this.warnaProduk = warnaProduk;
	}

	public String getIdProduk() {
		return idProduk;
	}

	public String getNamaProduk() {
		return namaProduk;
	}

	public String getHargaProduk() {
		return hargaProduk;
	}

	public String getNamaKategori() {
		return namaKategori;
	}

	public String getNamaMerek() {
		return namaMerek;
	}

	public String getGambarProduk() {
		return gambarProduk;
	}

	public String getUkuranProduk() {
		return ukuranProduk;
	}

	public String getWarnaProduk() {
		return warnaProduk;
	}
}
