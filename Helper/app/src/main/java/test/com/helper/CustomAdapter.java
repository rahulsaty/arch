package test.com.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CustomAdapter {


    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transition(withCrossFade())
                .into(imageView);

    }
    @BindingAdapter({"notNull"})
    public static void setText(TextView textView, String text) {
        if (text != null) {
            textView.setText(text);
        }
    }

}
