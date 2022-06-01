// Generated by view binder compiler. Do not edit!
package com.example.tzva_naloga_1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tzva_naloga_1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogItemInfoNoStockBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnClose;

  @NonNull
  public final ImageButton btnFavoriteDg;

  @NonNull
  public final ImageButton btnShoppingDg;

  @NonNull
  public final ImageView ivPicDg;

  @NonNull
  public final TextView tvDescriptionDg;

  @NonNull
  public final TextView tvEanDg;

  @NonNull
  public final TextView tvNameDg;

  @NonNull
  public final TextView tvPriceDg;

  @NonNull
  public final TextView tvQuantityDg;

  @NonNull
  public final TextView tvShopDg;

  private DialogItemInfoNoStockBinding(@NonNull LinearLayout rootView, @NonNull Button btnClose,
      @NonNull ImageButton btnFavoriteDg, @NonNull ImageButton btnShoppingDg,
      @NonNull ImageView ivPicDg, @NonNull TextView tvDescriptionDg, @NonNull TextView tvEanDg,
      @NonNull TextView tvNameDg, @NonNull TextView tvPriceDg, @NonNull TextView tvQuantityDg,
      @NonNull TextView tvShopDg) {
    this.rootView = rootView;
    this.btnClose = btnClose;
    this.btnFavoriteDg = btnFavoriteDg;
    this.btnShoppingDg = btnShoppingDg;
    this.ivPicDg = ivPicDg;
    this.tvDescriptionDg = tvDescriptionDg;
    this.tvEanDg = tvEanDg;
    this.tvNameDg = tvNameDg;
    this.tvPriceDg = tvPriceDg;
    this.tvQuantityDg = tvQuantityDg;
    this.tvShopDg = tvShopDg;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogItemInfoNoStockBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogItemInfoNoStockBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_item_info_no_stock, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogItemInfoNoStockBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_close;
      Button btnClose = ViewBindings.findChildViewById(rootView, id);
      if (btnClose == null) {
        break missingId;
      }

      id = R.id.btn_favorite_dg;
      ImageButton btnFavoriteDg = ViewBindings.findChildViewById(rootView, id);
      if (btnFavoriteDg == null) {
        break missingId;
      }

      id = R.id.btn_shopping_dg;
      ImageButton btnShoppingDg = ViewBindings.findChildViewById(rootView, id);
      if (btnShoppingDg == null) {
        break missingId;
      }

      id = R.id.iv_pic_dg;
      ImageView ivPicDg = ViewBindings.findChildViewById(rootView, id);
      if (ivPicDg == null) {
        break missingId;
      }

      id = R.id.tv_description_dg;
      TextView tvDescriptionDg = ViewBindings.findChildViewById(rootView, id);
      if (tvDescriptionDg == null) {
        break missingId;
      }

      id = R.id.tv_ean_dg;
      TextView tvEanDg = ViewBindings.findChildViewById(rootView, id);
      if (tvEanDg == null) {
        break missingId;
      }

      id = R.id.tv_name_dg;
      TextView tvNameDg = ViewBindings.findChildViewById(rootView, id);
      if (tvNameDg == null) {
        break missingId;
      }

      id = R.id.tv_price_dg;
      TextView tvPriceDg = ViewBindings.findChildViewById(rootView, id);
      if (tvPriceDg == null) {
        break missingId;
      }

      id = R.id.tv_quantity_dg;
      TextView tvQuantityDg = ViewBindings.findChildViewById(rootView, id);
      if (tvQuantityDg == null) {
        break missingId;
      }

      id = R.id.tv_shop_dg;
      TextView tvShopDg = ViewBindings.findChildViewById(rootView, id);
      if (tvShopDg == null) {
        break missingId;
      }

      return new DialogItemInfoNoStockBinding((LinearLayout) rootView, btnClose, btnFavoriteDg,
          btnShoppingDg, ivPicDg, tvDescriptionDg, tvEanDg, tvNameDg, tvPriceDg, tvQuantityDg,
          tvShopDg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}