package com.gilang.vndrosport.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.gilang.vndrosport.API.APIService;
import com.gilang.vndrosport.API.NoConnectivityException;
import com.gilang.vndrosport.R;
import com.gilang.vndrosport.adapter.ProdukAdapter;
import com.gilang.vndrosport.model.ProdukModel;
import com.gilang.vndrosport.response.ResponseProduk;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Allproduk extends AppCompatActivity {
	private RecyclerView gridView;
	private ProdukAdapter produkAdapter;
	private List<ProdukModel> daftarProduk;
	private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproduk);
		Toolbar toolbar = findViewById(R.id.tbtoolbar);
		setSupportActionBar(toolbar);
		if (getSupportActionBar() != null) {
			getSupportActionBar().setTitle("Detail Produk");
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setDisplayShowTitleEnabled(true);
		}
		initData();
		setupRecyclerView();
		setData(getApplicationContext());

    }

	public void setData(Context mContext){
		try{
			Call<ResponseProduk> call = APIService.Factory.create(mContext).produkHome();
			call.enqueue(new Callback<ResponseProduk>() {
				@EverythingIsNonNull
				@Override
				public void onResponse(Call<ResponseProduk> call, Response<ResponseProduk> response) {
					progressDialog.dismiss();
					if(response.isSuccessful()){
						if(response.body() != null){
							daftarProduk = response.body().getDaftarProduk();
							produkAdapter.replaceData(daftarProduk);
						}
					}
				}

				@EverythingIsNonNull
				@Override
				public void onFailure(Call<ResponseProduk> call, Throwable t) {
					progressDialog.dismiss();
					if(t instanceof NoConnectivityException) {
						pesan("Internet Offline!");
					}
				}
			});
		} catch (Exception e){
			progressDialog.dismiss();
			e.printStackTrace();
		}
	}


	private void initData(){
		progressDialog = ProgressDialog.show(this, "", "Loading.....", true, false);
		gridView = findViewById(R.id.rcItemProduk);
	}

	private void setupRecyclerView() {
		produkAdapter = new ProdukAdapter(new ArrayList<>(),this);
		// gridView.addItemDecoration(new MarginDecoration(this));
		gridView.setHasFixedSize(true);
		gridView.setLayoutManager(new GridLayoutManager(this,2));
		gridView.setAdapter(produkAdapter);
	}

	public void pesan(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

}
