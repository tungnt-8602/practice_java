package com.example.practivejavaandroid.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practivejavaandroid.activity.DetailActivity;
import com.example.practivejavaandroid.adapter.ItemAdapter;
import com.example.practivejavaandroid.model.Product;
import com.example.practivejavaandroid.R;

import java.util.ArrayList;
import java.util.List;

public class FeatureFragment extends Fragment {

    private List<Product> featureProd = new ArrayList<>();

    private RecyclerView recyclerProduct;

    private ItemAdapter adapter;

    public void initProds(){
        featureProd.add(new Product(R.drawable.ic_feature_fb, "Facebook"));
        featureProd.add(new Product(R.drawable.ic_feature_insta, "Instagram"));
        featureProd.add(new Product(R.drawable.ic_feature_twitter, "Twitter"));
        featureProd.add(new Product(R.drawable.ic_feature_ytb, "Youtube"));
        featureProd.add(new Product(R.drawable.ic_feature_linkedin, "Linkedin"));
        featureProd.add(new Product(R.drawable.ic_feature_github, "Github"));
        featureProd.add(new Product(R.drawable.ic_feature_wechat, "Wechat"));
        featureProd.add(new Product(R.drawable.ic_feature_gg, "Google"));
        featureProd.add(new Product(R.drawable.ic_feature_fb, "Facebook"));
        featureProd.add(new Product(R.drawable.ic_feature_insta, "Instagram"));
        featureProd.add(new Product(R.drawable.ic_feature_twitter, "Twitter"));
        featureProd.add(new Product(R.drawable.ic_feature_ytb, "Youtube"));
        featureProd.add(new Product(R.drawable.ic_feature_linkedin, "Linkedin"));
        featureProd.add(new Product(R.drawable.ic_feature_github, "Github"));
        featureProd.add(new Product(R.drawable.ic_feature_wechat, "Wechat"));
        featureProd.add(new Product(R.drawable.ic_feature_gg, "Google"));
        featureProd.add(new Product(R.drawable.ic_feature_fb, "Facebook"));
        featureProd.add(new Product(R.drawable.ic_feature_insta, "Instagram"));
        featureProd.add(new Product(R.drawable.ic_feature_twitter, "Twitter"));
        featureProd.add(new Product(R.drawable.ic_feature_ytb, "Youtube"));
        featureProd.add(new Product(R.drawable.ic_feature_linkedin, "Linkedin"));
        featureProd.add(new Product(R.drawable.ic_feature_github, "Github"));
        featureProd.add(new Product(R.drawable.ic_feature_wechat, "Wechat"));
        featureProd.add(new Product(R.drawable.ic_feature_gg, "Google"));
    }

    public FeatureFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initProds();
        bindingView(view);
    }

    void bindingView(@NonNull View view){
        recyclerProduct = view.findViewById(R.id.feature_list);
        adapter = new ItemAdapter(requireContext(), featureProd);
        recyclerProduct.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(),3);
        recyclerProduct.setLayoutManager(layoutManager);
        adapter.setOnClickListener(new ItemAdapter.OnClickListener() {
            @Override
            public void onClick(int position, Product p) {
                Intent intent = new Intent(requireContext(), DetailActivity.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("image", p.getImage());
                intent.putExtra("name", p.getName());
                // start the Intent
                startActivity(intent);
            }
        });
    }
}